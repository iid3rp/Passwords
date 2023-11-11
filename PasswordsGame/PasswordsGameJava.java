// @iid3rp
// starting point :3
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class PasswordsGameJava
{
    private static int gitStart()
    {
        return 0;
    }
    
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> // the invocation of the interface
        {
            JFrame frame = new JFrame("Passwords");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JButton redirectButton = new JButton("Github Repository");
            
            redirectButton.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    openWebpage("https://www.github.com/iid3rp/passwords");
                }
            });

            frame.getContentPane().setLayout(new FlowLayout());
            frame.getContentPane().add(redirectButton);

            frame.setSize(300, 200);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
        
        System.out.print(gitStart());
    }
    
    private static void openWebpage(String url) 
    {
        try 
        {
            Desktop.getDesktop().browse(new URI(url));
        } 
        catch 
        (IOException | URISyntaxException e) 
        {
            e.printStackTrace();
        }
    }
}