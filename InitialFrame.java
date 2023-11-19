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

public class InitialFrame
{
    public static JFrame initialFrame = new JFrame();
    
    public static void initializeComponent()
    {
        initialFrame = createInitialFrame();
        initialFrame.setVisible(true);
        
        initialFrame.addKeyListener(new KeyAdapter() 
        {
            @Override
            public void keyPressed(KeyEvent e) 
            {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) 
                {
                    int result = JOptionPane.showConfirmDialog(InitialFrame.initialFrame,
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
    
    public static JFrame createInitialFrame()
    {
        initialFrame = new JFrame("Passwords");
        initialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initialFrame.setSize(1280, 720);
        initialFrame.setUndecorated(true);
        initialFrame.setLocationRelativeTo(null);
        return initialFrame;   
    }
    
    public static void main(String[] args)
    {
        //
    }
}