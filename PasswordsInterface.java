import javax.swing.*;
import javax.swing.JOptionPane.*;
import java.awt.*;
import java.awt.event.*;

public class PasswordsInterface
{
    public static JPanel mainMenuPanel;
    public static JLabel locationLabel;
    public static JLabel passwordLabel;

    // Static fields goes here :3
    private static boolean isDragging = false;
    private static Point offset;
    private static String rawPassword = "";
    private static int
    textWidth = 0,
    centerX = 0,
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
        
        // Initialize JFrame
        JFrame mainMenuFrame = createMainMenuFrame();
        mainMenuFrame.setContentPane(mainMenuPanel);
        mainMenuFrame.setVisible(true);
        
        mainMenuFrame.addKeyListener(new KeyAdapter() 
        {
            @Override
            public void keyPressed(KeyEvent e) 
            {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) 
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
                else
                {
                    rawPassword += e.getKeyChar();
                    passwordLabel.setText("< " + rawPassword + " >");
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
        passwordLabel.setFont(new Font("Consolas", Font.BOLD, 20));
        passwordLabel.setForeground(new Color(255, 255, 255));
        passwordLabel.setLayout(new FlowLayout());
        String passwordText = passwordLabel.getText();

        // Calculate the center coordinates of the panel based on the text width
        FontMetrics metrics = passwordLabel.getFontMetrics(passwordLabel.getFont());
        textWidth = metrics.stringWidth(passwordText);
        centerX = mainMenuPanel.getWidth() / 2 - textWidth / 2;
        centerY = mainMenuPanel.getHeight() / 2 - passwordLabel.getHeight() / 2;
        
        passwordLabel.setBounds(centerX, centerY, textWidth, 50); // Set the location and size
        return passwordLabel;
    }
    
    public static void main(String[] args)
    {
        // some stuff here
        // must run at MainMenu.java
    }
}