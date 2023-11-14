import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenuFrame
{
    private static boolean isDragging = false;
    private static Point offset;

    public static void main(String[] args)
    {
        // Initialize JFrame
        JFrame frame = new JFrame("Cute Draggable JFrame Example :3");

        // Initialize JPanel
        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        panel.setLayout(new BorderLayout());

        // Set font for the panel
        Font font = new Font("Consolas", Font.PLAIN, 12);
        panel.setFont(font);

        // Add Close Button
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int result = JOptionPane.showConfirmDialog(frame, "Are you sure you want to close the application?", "Confirm Close", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION)
                {
                    System.exit(0);
                }
            }
        });
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panel.add(closeButton);

        // Add mouse listener for dragging the frame
        panel.addMouseListener(new MouseAdapter()
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

        // Add mouse motion listener for dragging
        panel.addMouseMotionListener(new MouseMotionAdapter()
        {
            @Override
            public void mouseDragged(MouseEvent e)
            {
                if (isDragging)
                {
                    Point currentMouse = e.getLocationOnScreen();

                    int deltaX = currentMouse.x - offset.x;
                    int deltaY = currentMouse.y - offset.y;

                    frame.setLocation(deltaX, deltaY);
                }
            }
        });

        // Set up the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720); // Set size to 720p
        frame.setUndecorated(true); // Remove window decorations (title bar, borders)
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}
