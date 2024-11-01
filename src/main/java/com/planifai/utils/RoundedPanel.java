package com.planifai.utils;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author marta
 */

import java.awt.geom.RoundRectangle2D;

public class RoundedPanel extends JPanel {
    private int borderRadius; // Radio de las esquinas

    public RoundedPanel(int borderRadius) {
        this.borderRadius = borderRadius;
        setOpaque(false); // Permitir que el fondo sea transparente
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Crear un área con bordes redondeados
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Double(
                0, 0, getWidth(), getHeight(), borderRadius, borderRadius
        );

        // Llenar el área con el color de fondo del panel
        g2.setColor(getBackground());
        g2.fill(roundedRectangle);

        // Dibujar el borde
        g2.setColor(getForeground());
        g2.draw(roundedRectangle);
    }
}

