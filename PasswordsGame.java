import javax.swing.*;
import javax.swing.JOptionPane.*;
import java.awt.Toolkit;
import java.awt.image.*;
import java.awt.datatransfer.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.io.*;
import java.util.*;

public class PasswordsGame
{
    public static final Random rand = new Random();
    
    public static JPanel gamePanel;
    public static JPanel interfacePanel;
    public static JLabel passwordLabel;
    public static JLabel guidingLabel;
    public static JLabel passwordText;
    public static JLabel otherLabels;
    
    public static int passwordTextTextWidth = 0, passwordTextTextHeight = 0;
    public static int chamber = 0;
    
    public static String rawPassword = "";
    public static int passwordTextWidth = 0, guidingTextWidth = 0, passwordCenterX = 0, guidingCenterX = 0, centerY = 0;
    public static boolean isNewPassword = true;
    public static boolean passwordsStarted = true;
    
    // window dragging thingy
    public static Point offset;
    public static boolean isDragging = false;
    
    // flashlight thingy
    public static boolean isFlashlightOn = true;
    public static Point flashlightCenter = new Point(0, 0);
    public static int flashlightRadius = 360; // Adjust the radius as needed
    
    public static void initializeComponent()
    {
        gamePanel = createGamePanel();
        interfacePanel = createInterfacePanel();
        
        
        // create JLabels here :3
        passwordText = createPasswordText();
        passwordLabel = createPasswordLabel();
        guidingLabel = createGuidingLabel();
        
        // initial the frame with the current panels you have
        InitialFrame.initialContentPanel = null;
        InitialFrame.initialGlassPane = null;

        // Add the new content (in this case, an alternative panel)
        InitialFrame.initialContentPanel = gamePanel;
        InitialFrame.initialGlassPane = interfacePanel;
        
        // set the panels to the main panel
        InitialFrame.initialFrame.setContentPane(InitialFrame.initialContentPanel);
        InitialFrame.initialFrame.setGlassPane(InitialFrame.initialGlassPane);
        
        interfacePanel.add(passwordLabel);
        interfacePanel.add(guidingLabel);
        
        MainMenu.mainMenuPanel.setVisible(false);
        MainMenu.cautionPanel.setVisible(false);
        
        interfacePanel.setVisible(true);
        gamePanel.setVisible(true);
        
        gamePanel.add(passwordText);
        gamePanel.add(MainMenu.locationLabel);
        
        gamePanel.addMouseListener(new MouseAdapter() 
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
        
        gamePanel.addMouseMotionListener(new MouseMotionAdapter() 
        {   
            @Override
            public void mouseMoved(MouseEvent e) 
            {
                // Update label with the current cursor position
                MainMenu.locationLabel.setText("Frame Location: (" + e.getX() + ", " + e.getY() + ")");
                
                // for the flashlight thingy
                flashlightCenter = e.getPoint();
                interfacePanel.repaint();  
            }
            
            @Override
            public void mouseDragged(MouseEvent e)
            {
                if (isDragging)
                {
                    Point currentMouse = e.getLocationOnScreen();

                    int deltaX = currentMouse.x - offset.x;
                    int deltaY = currentMouse.y - offset.y;

                    InitialFrame.initialFrame.setLocation(deltaX, deltaY);
                }
            }
        });
        
        InitialFrame.initialFrame.addKeyListener(new KeyAdapter()
        {
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
                    else if(e.getKeyCode() == KeyEvent.VK_ENTER)
                    {
                        PasswordsGame.initializeComponent();
                        PasswordsGame.start();
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
    }
    
    public static void start()
    {
        gamePanel.add(passwordText);
        passwordText.setText(req.stuff[4]);
        passwordTextMiddle();
        
        if(chamber < 1000)
        {
            if(chamber == 0)
            {
                startingPoint();
            }
            else if(isNewPassword)
            {
                rogue.newPasswordAlgorithm();
            }
            else
            {

            }
        }
    }
    
    public static JPanel createGamePanel()
    {
        ImageIcon backgroundImage = new ImageIcon("Properties/Images/stock-image2.jpg");
        
        JPanel gamePanel = new JPanel() 
        {
            @Override
            protected void paintComponent(Graphics g) 
            {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        
        gamePanel.setOpaque(false);
        gamePanel.setLayout(null);
        gamePanel.setFont(new Font("Consolas", Font.BOLD, 25));
        return gamePanel;
    }
    
    public static JPanel createInterfacePanel() 
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


    public static void passwordLabelMiddle()
    {
        FontMetrics passwordMetrics = passwordLabel.getFontMetrics(passwordLabel.getFont()),
                    guidingMetrics = guidingLabel.getFontMetrics(guidingLabel.getFont());
                    
        passwordTextWidth = passwordMetrics.stringWidth(passwordLabel.getText());
        guidingTextWidth = guidingMetrics.stringWidth(guidingLabel.getText());
        
        passwordCenterX = gamePanel.getWidth() / 2 - passwordTextWidth / 2;
        guidingCenterX = gamePanel.getWidth() / 2 - guidingTextWidth / 2;
                    
        passwordLabel.setBounds(passwordCenterX, 600, passwordTextWidth, 50);
        guidingLabel.setBounds(guidingCenterX, 570, guidingTextWidth, 50);
    }
    
    public static void startingPoint()
    {
       
    }
    
    public static void main(String[] args)
    {
        // must run at MainMenu.java
    }
}