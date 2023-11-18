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
    
    public static JLabel passwordText;
    public static JLabel otherLabels;
    
    private static int passwordTextTextWidth = 0, passwordTextTextHeight = 0;
    private static int chamber = 0;

    private static boolean isNewPassword = true;
    
    public static void initializeComponent()
    {
        passwordText = createPasswordText();
    }
    
    public static void start()
    {
        PasswordsInterface.mainMenuPanel.add(passwordText);
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
                
            }
            else
            {

            }
        }
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
    
    public static void startingPoint()
    {
       
    }
    
    public static void main(String[] args)
    {
        // must run at MainMenu.java
    }
}