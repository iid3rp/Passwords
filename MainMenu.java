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

public class MainMenu
{
    public static JPanel mainMenuPanel;
    public static JPanel cautionPanel;
    public static JPanel settingsPanel;
    
    // adding JLabels go here
    public static JLabel locationLabel;
    public static JLabel playLabel;
    public static JLabel passwordsLabel;
    public static JLabel settingsLabel;
    public static JLabel achievementsLabel;
    public static JLabel cautionLabel;
    public static JLabel settingsLabel1;

    // Static fields go here :3
    public static Point offset;
    public static boolean isDragging = false;
    

    public static void initializeComponent()
    {
        mainMenuPanel = createMainMenuPanel();
        cautionPanel = createCautionPanel();
        settingsPanel = createSettingsPanel();

        // Create JLabels inside mainMenuPanel
        locationLabel = createLocationLabel();
        playLabel = createPlayLabel();
        passwordsLabel = createPasswordsLabel();
        settingsLabel = createSettingsLabel();
        achievementsLabel = createAchievementsLabel();
        
        // Create Labels inside cautionPanel
        cautionLabel = createCautionLabel();
        
        // initial the frame with the current panels you have
        InitialFrame.initialContentPanel.removeAll();
        InitialFrame.initialGlassPane.removeAll();

        // Add the new content (in this case, an alternative panel)
        InitialFrame.initialContentPanel = mainMenuPanel;
        InitialFrame.initialGlassPane = cautionPanel;
        
        // set the panels to the main panel
        InitialFrame.initialFrame.setContentPane(InitialFrame.initialContentPanel);
        InitialFrame.initialFrame.setGlassPane(InitialFrame.initialGlassPane);
        
        // Add JLabels to cautionPanel
        cautionPanel.add(cautionLabel);

        // making the panels to be visible
        cautionPanel.setVisible(true);
        mainMenuPanel.setVisible(true);     
        
        InitialFrame.initialFrame.addKeyListener(new KeyAdapter() 
        {
            @Override
            public void keyPressed(KeyEvent e) 
            {
                cautionPanel.setVisible(false);
                // Add stuff to mainMenuPanel
                mainMenuShow();
            }
        });
    }
    
    public static JPanel createMainMenuPanel()
    {
        ImageIcon backgroundImage = new ImageIcon("Properties/Images/stock-image2.jpg");
        JPanel mainMenuPanel = new JPanel() 
        {
            @Override
            protected void paintComponent(Graphics g) 
            {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        mainMenuPanel.setLayout(null);  // Use null layout
        mainMenuPanel.setFont(new Font("Consolas", Font.BOLD, 25));
        
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
        
        mainMenuPanel.addMouseMotionListener(new MouseMotionAdapter() 
        {   
            @Override
            public void mouseMoved(MouseEvent e) 
            {
                // Update label with the current cursor position
                MainMenu.locationLabel.setText("Frame Location: (" + e.getX() + ", " + e.getY() + ")");
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
        
        return mainMenuPanel;
    }
    
    public static JPanel createCautionPanel() 
    {
        JPanel cautionPanel = new JPanel() 
        {
            @Override
            protected void paintComponent(Graphics g) 
            {
                super.paintComponent(g);
                BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = image.createGraphics();
                
                // Fill the entire image with a black color
                g2d.setColor(new Color(70, 35, 1, 150));
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g.drawImage(image, 0, 0, null);
                
                g2d.dispose();
            }
        };
        cautionPanel.setOpaque(false);
        cautionPanel.setLayout(null);

        return cautionPanel;
    }
    
    public static JPanel createSettingsPanel()
    {
        settingsPanel = new JPanel()
        {
            @Override
            protected void paintComponent(Graphics g) 
            {
                super.paintComponent(g);
                BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = image.createGraphics();
                
                // Fill the entire image with a black color
                g2d.setColor(new Color(70, 35, 1, 150));
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g.drawImage(image, 0, 0, null);
                
                g2d.dispose();
            }
        };
        settingsPanel.setOpaque(false);
        settingsPanel.setLayout(null);
        
        return settingsPanel;
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
    
    public static JLabel createPasswordsLabel()
    {
        passwordsLabel = new JLabel("Passwords");
        passwordsLabel.setForeground(new Color(255, 255, 255));
        passwordsLabel.setFont(new Font("Consolas", Font.BOLD, 100));
        passwordsLabel.setBounds(100, 100, 700, 200);
        return passwordsLabel;
    }
    
    public static JLabel createPlayLabel()
    {
        playLabel = new JLabel("Start");
        playLabel.setFont(new Font("Consolas", Font.PLAIN, 48));
        playLabel.setForeground(new Color(255, 255, 255));
        playLabel.setLayout(new FlowLayout());
        playLabel.setBounds(100, 300, 200, 100);
        
        playLabel.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseEntered(MouseEvent e)
            {
                playLabel.setForeground(new Color(255, 0, 0));
                System.out.println("mouse");
            }
            
            @Override
            public void mouseExited(MouseEvent e)
            {
                playLabel.setForeground(new Color(255, 255, 255));
            }
            
            @Override
            public void mouseClicked(MouseEvent e)
            {
                cautionLabel.setText("Loading...");
                cautionPanel.setVisible(true);
                PasswordsGame.initializeComponent();
            }
        }); 
        
        return playLabel;
    }
    
    public static JLabel createSettingsLabel()
    {
        settingsLabel = new JLabel("Settings");
        settingsLabel.setForeground(new Color(255, 255, 255));
        settingsLabel.setFont(new Font("Consolas", Font.PLAIN, 48));
        settingsLabel.setBounds(100, 400, 700, 100);

        settingsLabel.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseEntered(MouseEvent e)
            {
                settingsLabel.setForeground(new Color(255, 0, 0));
                System.out.println("mouse");
            }
            
            @Override
            public void mouseExited(MouseEvent e)
            {
                settingsLabel.setForeground(new Color(255, 255, 255));
            }
            
            @Override
            public void mouseClicked(MouseEvent e)
            {
                InitialFrame.initialContentPanel.removeAll();
                InitialFrame.initialGlassPane = settingsPanel;
                InitialFrame.initialFrame.setGlassPane(InitialFrame.initialGlassPane);
                settingsPanel.setVisible(true);
            }
        }); 
        
        return settingsLabel;
    }

    public static JLabel createAchievementsLabel()
    {
        achievementsLabel = new JLabel("Achievements");
        achievementsLabel.setForeground(new Color(255, 255, 255));
        achievementsLabel.setFont(new Font("Consolas", Font.PLAIN, 48));
        achievementsLabel.setBounds(100, 500, 700, 100);

        achievementsLabel.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseEntered(MouseEvent e)
            {
                achievementsLabel.setForeground(new Color(255, 0, 0));
                System.out.println("mouse");
            }
            
            @Override
            public void mouseExited(MouseEvent e)
            {
                achievementsLabel.setForeground(new Color(255, 255, 255));
            }
            
            @Override
            public void mouseClicked(MouseEvent e)
            {
                
            }
        });
        
        return achievementsLabel;
    }
    
    public static JLabel createCautionLabel()
    {
        cautionLabel = new JLabel();
        cautionLabel.setText("Things to Caution!, Press anything to continue.");
        cautionLabel.setFont(new Font("Consolas", Font.PLAIN, 20));
        cautionLabel.setBounds(255, 200, 720, 50);
        cautionLabel.setForeground(new Color(255, 255, 255));
        cautionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cautionLabel.setVerticalAlignment(SwingConstants.CENTER);
        return cautionLabel;
    }
    
    public static void main(String[] args)
    {
        // some stuff here
        // must run at MainMenu.java
        initializeComponent(); // you only run this when debugging
    }
    
    public static void mainMenuShow()
    {
        mainMenuPanel.add(locationLabel);
        mainMenuPanel.add(playLabel);
        mainMenuPanel.add(passwordsLabel);
        mainMenuPanel.add(settingsLabel);
        mainMenuPanel.add(achievementsLabel);
    }
}
