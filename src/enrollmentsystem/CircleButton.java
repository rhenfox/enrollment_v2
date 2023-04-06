/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enrollmentsystem;

/**
 *
 * @author Java Programming with Aldrin
 */
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class CircleButton extends JButton {
    public CircleButton(String label) {
        super(label);

        // Set button properties
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setPreferredSize(new Dimension(50, 50));
        setBackground(Color.red);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw circle button
        if (getModel().isArmed()) {
            g2.setColor(Color.lightGray);
        } else {
            g2.setColor(getBackground());
        }
        g2.fill(new Ellipse2D.Double(0, 0, getSize().width-1, getSize().height-1));

        super.paintComponent(g);
    }

    public static void main(String[] args) {
        // Create frame and button
        JFrame frame = new JFrame("Circle Button Example");
        CircleButton button = new CircleButton("Click me!");

        // Add button to frame
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(button);

        // Display frame
        frame.setSize(200, 200);
        frame.setVisible(true);
    }
}