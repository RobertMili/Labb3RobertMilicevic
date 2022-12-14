package com.example.labb3.Shapes;

import javafx.scene.canvas.GraphicsContext;

import javafx.scene.paint.Color;

public class Rectangle extends Shape  {


    public Rectangle(double mouseX, double mouseY, double size, Color color) {
        super(mouseX, mouseY, size, color);
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {

            graphicsContext.setFill(getColor());
            graphicsContext.fillRect(getMouseX()  - getSize() - 2.5, getMouseY() - getSize() - 2.5, 2 * getSize() + 5, 2 *  getSize() + 5 );


    }

    @Override
    public boolean isInsideShape(double mouseX, double mouseY) {
        double distX = Math.abs(mouseX - getMouseX());
        double distY = Math.abs(mouseY - getMouseY());

        return distX <= getSize() && distY <= getSize();

    }

    @Override
    public String drawSVG() {
        String convertColor = "#" + getColor().toString().substring(2,10);
        return "<rect x=\"" + (getMouseX() - getSize()) + "\" " +
                "y=\"" + (getMouseY() - getSize()) + "\" " +
                "width=\"" + (2 * getSize()) + "\" " +
                "height=\"" + (2* getSize()) + "\" " +
                "fill=\"" + convertColor + "\" />";
    }

    @Override
    public String toSVG() {
        String svgColorCode = "#" + getColor().toString().substring(2, 10);
        return "<rect fill=\"" + svgColorCode + "\" stroke=\"" + svgColorCode + "\" x=\"" + getMouseX() +
                "\" y=\"" + getMouseY() + "\" width=\"" + getSize() + "\" height=\"" + getSize() + "\"/>";
    }
}



