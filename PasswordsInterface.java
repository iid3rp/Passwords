import java.awt.Toolkit;
import java.awt.image.*;
import java.awt.datatransfer.*;
import javax.swing.*;
import javax.swing.JOptionPane.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.io.*;

public class PasswordsInterface
{
    public static JPanel mainMenuPanel;
    public static JPanel interfacePanel;
    public static JLabel locationLabel;
    public static JLabel passwordLabel;
    public static JLabel guidingLabel;
    public static JLabel passwordText;

    // Static fields go here :3
    private static boolean isDragging = false;
    private static Point offset;
    private static String rawPassword = "";
    private static int passwordTextWidth = 0, guidingTextWidth = 0, passwordCenterX = 0, guidingCenterX = 0, centerY = 0;
    private static int passwordTextTextWidth = 0, passwordTextTextHeight = 0;

    // flashlight thingy
    private static boolean isFlashlightOn = true;
    private static Point flashlightCenter = new Point(0, 0);
    private static int flashlightRadius = 100; // Adjust the radius as needed

    public static void initializeComponent()
    {
        JFrame mainMenuFrame = createMainMenuFrame();
        mainMenuPanel = createMainMenuPanel();
        interfacePanel = createInterfacePanel();

        // Create JLabels
        locationLabel = createLocationLabel();
        passwordLabel = createPasswordLabel();
        guidingLabel = createGuidingLabel();
        passwordText = createPasswordText();

        // Add JLabels to mainMenuPanel
        mainMenuPanel.add(locationLabel);

        // add interface Panel to the
        interfacePanel.add(passwordLabel);
        interfacePanel.add(guidingLabel);

        mainMenuFrame.setContentPane(mainMenuPanel);
        mainMenuFrame.setGlassPane(interfacePanel);
        interfacePanel.setVisible(true);
        mainMenuFrame.setVisible(true);
        
        mainMenuFrame.addKeyListener(new KeyAdapter() 
        {
            @Override
            public void keyPressed(KeyEvent e) 
            {
                if (e.isControlDown())
                {
                    if(e.getKeyCode() == KeyEvent.VK_V)
                    {
                        // Get the system clipboard
                        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                
                        // Get the contents of the clipboard
                        Transferable transferable = clipboard.getContents(null);
                        
                        // Check if the contents are text
                        if (transferable != null && transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) 
                        {
                            try 
                            {
                                String pastedText = (String) transferable.getTransferData(DataFlavor.stringFlavor);

                                if (pastedText.length() <= 1) 
                                {
                                    rawPassword += pastedText;
                                    passwordLabel.setText("< " + rawPassword + " >");
                                } 
                                else 
                                {
                                    guidingLabel.setText("You can only paste one character at a time.");
                                    pastedText = "";  
                                }
                                passwordLabelMiddle();
                            } 
                            catch (Exception ex) 
                            {
                                ex.printStackTrace();
                            }
                        }
                    }
                    else if(e.getKeyCode() == KeyEvent.VK_A)
                    {
                        guidingLabel.setText("You can't highlight texts here.");
                        passwordLabelMiddle();
                    }    
                    else if(e.getKeyCode() == KeyEvent.VK_C)
                    {
                        guidingLabel.setText("You can't copy the current password. >:3");
                        passwordLabelMiddle();
                    } 
                }
                else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) 
                {
                    int result = JOptionPane.showConfirmDialog(mainMenuFrame,
                            "Are you sure you want to close the application?",
                            "Confirm Close",
                            JOptionPane.YES_NO_OPTION);
                            
                    if (result == JOptionPane.YES_OPTION) 
                    {
                        System.exit(0);
                    }
                } 
                else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) 
                {
                    if (!rawPassword.isEmpty()) 
                    {
                        guidingLabel.setText("");
                        rawPassword = rawPassword.substring(0, rawPassword.length() - 1);
                        passwordLabel.setText("< " + rawPassword + " >");
                        
                        if(rawPassword == "")
                        {
                            passwordLabel.setText("");
                        }
                        passwordLabelMiddle();
                    }
                } 
                else if(Character.isDefined(e.getKeyChar()) && !Character.isISOControl(e.getKeyChar()))
                {
                    guidingLabel.setText("");
                    rawPassword += e.getKeyChar();
                    passwordLabel.setText("< " + rawPassword + " >");
                    passwordLabelMiddle();
                }      
            }
        });   
        
        mainMenuPanel.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mousePressed(MouseEvent e) 
            {
                if (SwingUtilities.isLeftMouseButton(e)) 
                {
                    isDragging = true;
                    offset = e.getPoint();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) 
            {
                if (SwingUtilities.isLeftMouseButton(e)) 
                {
                    isDragging = false;
                }
            }
        });

        // MouseMotionListener for dragging and updating label
        mainMenuPanel.addMouseMotionListener(new MouseMotionAdapter()
        {
            @Override
            public void mouseDragged(MouseEvent e)
            {
                if (isDragging)
                {
                    Point currentMouse = e.getLocationOnScreen();

                    int deltaX = currentMouse.x - offset.x;
                    int deltaY = currentMouse.y - offset.y;

                    mainMenuFrame.setLocation(deltaX, deltaY);
                }
            }

            @Override
            public void mouseMoved(MouseEvent e)
            {
                // Update label with the current cursor position when not dragging
                locationLabel.setText("Panel Location: (" + e.getX() + ", " + e.getY() + ")");
                
                flashlightCenter.setLocation(e.getX(), e.getY());
                interfacePanel.repaint(); // Trigger repaint to update flashlight effect
            }
        });
    }
    
    public static JFrame createMainMenuFrame()
    {
        JFrame mainMenuFrame = new JFrame("Passwords!");
        mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenuFrame.setSize(1280, 720); // Set size to 720p
        mainMenuFrame.setUndecorated(true); // Remove window decorations (title bar, borders)
        mainMenuFrame.setLocationRelativeTo(null); // Center the mainMenuFrame on the screen.
        return mainMenuFrame;   
    }
    
    public static JPanel createMainMenuPanel()
    {
        JPanel mainMenuPanel = new JPanel();
        mainMenuPanel.setBackground(Color.GRAY);
        mainMenuPanel.setLayout(null);  // Use null layout
        mainMenuPanel.setFont(new Font("Consolas", Font.BOLD, 25));
        return mainMenuPanel;
    }
    
    private static JPanel createInterfacePanel() 
    {
        JPanel interfacePanel = new JPanel() 
        {
            @Override
            protected void paintComponent(Graphics g) 
            {
                super.paintComponent(g);
    
                if (isFlashlightOn) 
                {
                    BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
                    Graphics2D g2d = image.createGraphics();
            
                    // Fill the entire image with a black color
                    g2d.setColor(Color.BLACK);
                    g2d.fillRect(0, 0, getWidth(), getHeight());
            
                    // Create the circular region
                    Ellipse2D hole = new Ellipse2D.Double(
                            flashlightCenter.x - flashlightRadius,
                            flashlightCenter.y - flashlightRadius,
                            flashlightRadius * 2,
                            flashlightRadius * 2
                    );
            
                    // Clear the circular region by setting its pixels to transparent
                    g2d.setComposite(AlphaComposite.Clear);
                    g2d.fill(hole);
            
                    // Draw the image onto the component
                    g.drawImage(image, 0, 0, null);
            
                    g2d.dispose();
                }
            }
        };
        interfacePanel.setOpaque(false); // Make the panel transparent
        interfacePanel.setLayout(null);

        return interfacePanel;
    }

    public static JLabel createLocationLabel()
    {
        JLabel locationLabel = new JLabel();
        locationLabel.setFont(new Font("Consolas", Font.PLAIN, 12));
        locationLabel.setForeground(new Color(255, 255, 255));
        locationLabel.setLayout(new FlowLayout());
        locationLabel.setBounds(15, 10, 200, 20);
        return locationLabel;
    }
    
    public static JLabel createPasswordLabel()
    {
        JLabel passwordLabel = new JLabel("");
        passwordLabel.setFont(new Font("Consolas", Font.BOLD, 25));
        passwordLabel.setForeground(new Color(255, 255, 255));
        passwordLabel.setLayout(new FlowLayout());
        String passwordText = passwordLabel.getText();

        // Calculate the center coordinates of the panel based on the text width
        // Set the location and size
        return passwordLabel;
    }
    
    public static JLabel createGuidingLabel()
    {
        JLabel guidingLabel = new JLabel();
        guidingLabel.setFont(new Font("Consolas", Font.BOLD, 15));
        guidingLabel.setForeground(new Color(255, 255, 255));
        guidingLabel.setLayout(new FlowLayout());
        return guidingLabel;
    }

    public static JLabel createPasswordText()
    {
        passwordText = new JLabel();
        passwordText.setFont(new Font("Consolas", Font.BOLD, 20));
        passwordText.setForeground(new Color(255, 255, 255));
        passwordText.setLayout(new FlowLayout());
        return passwordText;
    }
    
    public static void passwordTextMiddle()
    {
        FontMetrics passwordTextMetrics = passwordText.getFontMetrics(passwordText.getFont());
        passwordTextTextWidth = passwordTextMetrics.stringWidth(passwordText.getText());
        passwordTextTextHeight = passwordTextMetrics.getHeight();
   
        passwordText.setBounds(200, 200, passwordTextTextWidth, passwordTextTextHeight);
    }


    public static void passwordLabelMiddle()
    {
        FontMetrics passwordMetrics = passwordLabel.getFontMetrics(passwordLabel.getFont()),
                    guidingMetrics = guidingLabel.getFontMetrics(guidingLabel.getFont());
                    
        passwordTextWidth = passwordMetrics.stringWidth(passwordLabel.getText());
        guidingTextWidth = guidingMetrics.stringWidth(guidingLabel.getText());
        
        passwordCenterX = mainMenuPanel.getWidth() / 2 - passwordTextWidth / 2;
        guidingCenterX = mainMenuPanel.getWidth() / 2 - guidingTextWidth / 2;
                    
        passwordLabel.setBounds(passwordCenterX, 600, passwordTextWidth, 50);
        guidingLabel.setBounds(guidingCenterX, 570, guidingTextWidth, 50);
    }
    
    public static void main(String[] args)
    {
        // some stuff here
        // must run at MainMenu.java
        initializeComponent();
    }
}
