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

public class Application
{
    public static JFrame applicationFrame;
    
    public static void initializeComponent()
    {
        applicationFrame = createApplicationFrame();
        
        applicationFrame.addKeyListener(new KeyAdapter() 
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
                    else if(e.getKeyCode() == KeyEvent.VK_ENTER)
                    {
                        PasswordsGame.initializeComponent();
                        PasswordsGame.start();
                    }
                }
                else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) 
                {
                    int result = JOptionPane.showConfirmDialog(applicationFrame,
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
    }
    
    public static JFrame createApplicationFrame()
    {
        applicationFrame = new JFrame("Passwords");
        applicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        applicationFrame.setSize(1280, 720);
        applicationFrame.setUndecorated(true);
        applicationFrame.setLocationRelativeTo(null);
        return applicationFrame;   
    }
    
    
}