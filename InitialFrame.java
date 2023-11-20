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

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class InitialFrame 
{
    public static JFrame initialFrame = new JFrame();
    public static JPanel initialContentPanel = new JPanel();
    public static JPanel initialGlassPane = new JPanel();

    public static void initializeComponent() 
    {
        initialFrame = createInitialFrame();
        initialContentPanel = createInitialContentPanel();
        initialGlassPane = createInitialGlassPane();
         
        initialFrame.setVisible(true);

        initialFrame.addKeyListener(new KeyAdapter() 
        {
            @Override
            public void keyPressed(KeyEvent e) 
            {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) 
                {
                    int result = JOptionPane.showConfirmDialog(initialFrame,
                            "Are you sure you want to close the application?",
                            "Confirm Close",
                            JOptionPane.YES_NO_OPTION);

                    if (result == JOptionPane.YES_OPTION) 
                    {
                        System.exit(0);
                    }
                }
            }
        });

        MainMenu.initializeComponent();
    }

    private static JFrame createInitialFrame() 
    {
        initialFrame = new JFrame("Passwords");
        initialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initialFrame.setSize(1280, 720);
        initialFrame.setUndecorated(true);
        initialFrame.setLocationRelativeTo(null);
        return initialFrame;
    }
    
    public static JPanel createInitialContentPanel()
    {
        initialContentPanel = new JPanel();
        initialContentPanel.setOpaque(false);
        initialContentPanel.setLayout(null);
        
        return initialContentPanel;
    }
    
    public static JPanel createInitialGlassPane()
    {
        initialGlassPane = new JPanel();
        initialGlassPane.setOpaque(false);
        initialGlassPane.setLayout(null);
        
        return initialGlassPane;
    }

    public static void main(String[] args) 
    {
        // must run at FinalProject.java smth,.,.
    }
}
