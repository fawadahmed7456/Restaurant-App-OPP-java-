package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel {
    JLabel picLabel, title;
    JButton button;
    private Panel panel_1;
    static JFrame frame;

    public void createAndShowGUI() throws IOException {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground((Color.lightGray));

        // Use the relative path to the image resource
        URL imageURL = this.getClass().getResource("/food_logo.png");
        if (imageURL != null) {
            Image image = ImageIO.read(imageURL);
            Image imageScaled = image.getScaledInstance(350, 300, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(imageScaled);
            picLabel = new JLabel(imageIcon);

            Box right = Box.createVerticalBox();
            panel_1 = new Panel();
            title = new JLabel("Comsats United Cafe");  
            title.setAlignmentX(Component.CENTER_ALIGNMENT);
            title.setAlignmentY(0.0f);
            title.setHorizontalAlignment(SwingConstants.CENTER);
            title.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 18));
            title.setForeground(Color.BLUE);

            // Button, with filler
            button = new JButton("Order online Now >>");
            panel_1.add(button);
            button.setAlignmentX(Component.LEFT_ALIGNMENT);

            panel.add(picLabel, BorderLayout.CENTER);
            panel.add(right, BorderLayout.SOUTH);
            right.add(title);
            right.add(panel_1);
            add(panel);

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    FoodMenu food;
                    try {
                        food = new FoodMenu();
                        food.createAndShowGUI();
                        food.setVisible(true);
                        setVisible(false);
                        frame.dispose();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            });
        } else {
            System.err.println("Error: Could not find the image resource.");
            // Handle the error appropriately, e.g., show an error message.
        }
    }

    public static void main(String args[]) throws IOException {
        MainMenu main = new MainMenu();
        main.createAndShowGUI();
        frame = new JFrame();
        frame.setTitle("Comsats food Ordering System");
        frame.getContentPane().add(main);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
