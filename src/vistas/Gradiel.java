package vistas;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GradientPaint;
import java.awt.Color;

public class Gradiel extends JPanel {
    private Color startColor;
    private Color endColor;

    // Constructor to accept color parameters
    public Gradiel(Color startColor, Color endColor) {
        this.startColor = startColor;
        this.endColor = endColor;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        // Create a GradientPaint object for diagonal gradient
        GradientPaint gp = new GradientPaint(0, 0, startColor, width, height, endColor);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);
    }
}
