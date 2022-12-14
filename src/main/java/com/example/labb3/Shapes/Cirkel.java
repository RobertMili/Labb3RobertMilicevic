package com.example.labb3.Shapes;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Cirkel extends Shape {


    public Cirkel(double mouseX, double mouseY, double size, Color color) {
        super(mouseX, mouseY, size, color);
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {

            graphicsContext.setFill(getColor());
            graphicsContext.fillOval(getMouseX()  - getSize() - 2.5, getMouseY() - getSize() - 2.5, 2 * getSize() + 5, 2 *  getSize() + 5);

    }

    @Override
    public boolean isInsideShape(double mouseX, double mouseY) {
        double distX = mouseX - getMouseX();
        double distY = mouseY -getMouseY();
        double distance = Math.sqrt((distX * distX) + (distY * distY));

        return distance <= getSize() / 2;
    }

    @Override
    public String drawSVG() {
        String convertColor = "#" + getColor().toString().substring(2,10);

        return "<circle cx=\"" + getMouseX() +  "\" " +
                "cy=\"" + getMouseY() + "\" " +
                "r=\"" + getSize() +  "\" " +
                "fill=\"" + convertColor + "\" />";

    }
    @Override
    public String toSVG() {
        String svgColorCode = "#" + getColor().toString().substring(2, 10);
        return "<circle cx=\"" + getMouseX() + "\" cy=\"" + getMouseY() + "\" r=\"" + getSize() + "\" fill=\"" + svgColorCode + "\"/>";

    }



}





