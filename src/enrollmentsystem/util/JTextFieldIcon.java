/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enrollmentsystem.util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
/**
 *
 * @author Java Programming with Aldrin
 */
public class JTextFieldIcon extends JTextFieldX {

    private Icon icon;


    @Override
    protected void paintBorder(Graphics g) {
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (getIcon() != null) {
            Image prefix = ((ImageIcon) getIcon()).getImage();
            int y = (getHeight() - getIcon().getIconHeight()) / 2;
            g2.drawImage(prefix, 3, y, this);
        }
        if (isFocusOwner()) {
            g.setColor(new Color(4, 88, 167));
        } else {
            g.setColor(new Color(142, 142, 142));
        }
    }

    /**
     * @return the icon
     */
    public Icon getIcon() {
        return icon;
    }

    /**
     * @param icon the icon to set
     */
    public void setIcon(Icon icon) {
        this.icon = icon;
    }
}
