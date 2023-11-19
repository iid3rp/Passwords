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
    
    // adding JLabels go here
    public static JLabel locationLabel;
    public static JLabel playLabel;

    // Static fields go here :3
    public static Point offset;
    public static boolean isDragging = false;
    

    public static void initializeComponent()
    {
        mainMenuPanel = createMainMenuPanel();
        cautionPanel = createCautionPanel();

        // Create JLabels
        locationLabel = createLocationLabel();
        playLabel = createPlayLabel();
        

        // Add JLabels to mainMenuPanel
        mainMenuPanel.add(locationLabel);
        mainMenuPanel.add(playLabel);
        
        // initial frame thingy
        InitialFrame.initialFrame.setContentPane(mainMenuPanel);
        InitialFrame.initialFrame.setGlassPane(cautionPanel);
        cautionPanel.setVisible(true); 
        
        InitialFrame.initialFrame.addKeyListener(new KeyAdapter() 
        {
            @Override
            public void keyPressed(KeyEvent e) 
            {
                cautionPanel.setEnabled(false);
                cautionPanel.setVisible(false);
            }
        });
        
        cautionPanel.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent e)
            {
            
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
        
        playLabel.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                PasswordsGame.initializeComponent();
            }
        });
    }
    
    public static JPanel createMainMenuPanel()
    {
        mainMenuPanel = new JPanel();
        mainMenuPanel.setBackground(Color.GRAY);
        mainMenuPanel.setLayout(null);  // Use null layout
        mainMenuPanel.setFont(new Font("Consolas", Font.BOLD, 25));
        return mainMenuPanel;
    }
    
    public static JPanel createCautionPanel() 
    {
        JPanel cautionPanel = new JPanel(); 
        cautionPanel.setBackground(Color.GRAY);
        cautionPanel.setOpaque(true); // Make the panel transparent
        cautionPanel.setLayout(null);

        return cautionPanel;
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
    
    public static JLabel createPlayLabel()
    {
        playLabel = new JLabel("PLAY");
        playLabel.setFont(new Font("Consolas", Font.BOLD, 48));
        playLabel.setForeground(new Color(255, 255, 255));
        playLabel.setLayout(new FlowLayout());
        playLabel.setBounds(200, 200, 200, 50);
        return playLabel;
    }
    
    public static void main(String[] args)
    {
        // some stuff here
        // must run at MainMenu.java
        initializeComponent(); // you only run this when debugging
    }
}
