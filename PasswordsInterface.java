import java.awt.Toolkit;
import java.awt.datatransfer.*;
import javax.swing.*;
import javax.swing.JOptionPane.*;
import java.awt.*;
import java.awt.event.*;

public class PasswordsInterface
{
    public static JPanel mainMenuPanel;
    public static JLabel locationLabel;
    public static JLabel passwordLabel;
    public static JLabel guidingLabel;

    // Static fields goes here :3
    private static boolean isDragging = false;
    private static Point offset;
    private static String rawPassword = "";
    private static int
    passwordTextWidth = 0,
    guidingTextWidth = 0,
    passwordCenterX = 0,
    guidingCenterX = 0,
    centerY = 0;

    public static void initializeComponent()
    {

        // Initialize JPanel
        mainMenuPanel = new JPanel();
        mainMenuPanel.setBackground(Color.GRAY);
        mainMenuPanel.setLayout(null);  // Use null layout
        mainMenuPanel.setFont(new Font("Consolas", Font.BOLD, 25));

        // Create JLabel for displaying mainMenuPanel location
        locationLabel = createLocationLabel();
        mainMenuPanel.add(locationLabel);

        // Create Label for displaying the Password stuff
        passwordLabel = createPasswordLabel();
        mainMenuPanel.add(passwordLabel);
        
        // Create Label for displaying the guiding labels
        guidingLabel = createGuidingLabel();
        mainMenuPanel.add(guidingLabel);

        // Initialize JFrame
        JFrame mainMenuFrame = createMainMenuFrame();
        mainMenuFrame.setContentPane(mainMenuPanel);
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

                                if (pastedText.length() <= 3) 
                                {
                                    rawPassword += pastedText;
                                    passwordLabel.setText("< " + rawPassword + " >");
                                } 
                                else 
                                {
                                    guidingLabel.setText("You can't paste big texts here.");
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
                        guidingLabel.setText("You cant highlight texts here.");
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