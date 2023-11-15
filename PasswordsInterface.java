import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PasswordsInterface
{
    // Static fields to track dragging state
    private static boolean isDragging = false;
    private static Point offset;

    public static void initializeComponent()
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

        // Create JLabel for displaying panel location
        JLabel locationLabel = new JLabel("Panel Location: ");
        locationLabel.setFont(new Font("Consolas", Font.PLAIN, 12));
        locationLabel.setForeground(new Color(255, 255, 255));
        locationLabel.setHorizontalAlignment(SwingConstants.LEFT);
        locationLabel.setVerticalAlignment(SwingConstants.TOP);
        panel.add(locationLabel);

        // ActionListener for the Close Button
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

        // Layout for Close Button (right-aligned)
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panel.add(closeButton);

        // MouseListener for dragging the frame
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

        // MouseMotionListener for dragging and updating label
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

            @Override
            public void mouseMoved(MouseEvent e)
            {
                // Update label with the current cursor position when not dragging
                locationLabel.setText("Panel Location: (" + e.getX() + ", " + e.getY() + ")");
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
    
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                initializeComponent();
            }
        });
    }
}