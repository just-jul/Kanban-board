package com.julia;

import javax.swing.*;
import java.awt.*;

public class RoundedLabel extends JLabel {

    private int radius;

    public RoundedLabel(String text, int radius){
        super(text, SwingConstants.CENTER);
        this.radius = radius;
        setOpaque(false);
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        g2.dispose();
        super.paintComponent(g);
    }

}
