package com.example.labb3;

import com.example.labb3.Shapes.Cirkel;
import com.example.labb3.Shapes.Position;
import com.example.labb3.Shapes.Rectangle;
import com.example.labb3.Shapes.Shape;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Model {

    private double mouseX;
    private double mouseY;
    private final int size = 50;

    List<Shape> shape = new ArrayList<>();

    public Rectangle rectangle;
    public Cirkel cirkel; //This connect
    private final StringProperty shapeSize;
    Shape shapeClass;
    Position position;

    public Model() {
        this.shapeSize = new SimpleStringProperty("50");

    }

    public double getMouseX() {
        return mouseX;
    }

    public void setMouseX(double mouseX) {
        this.mouseX = mouseX;
    }

    public double getMouseY() {
        return mouseY;
    }

    public void setMouseY(double mouseY) {
        this.mouseY = mouseY;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public Cirkel getCirkel() {
        return cirkel;
    }

    public void setCirkel(Cirkel cirkel) {
        this.cirkel = cirkel;
    }

    public void drawCirkel(GraphicsContext graphicsContext, ColorPicker colorPicker) {

        try {
                graphicsContext.setFill(colorPicker.getValue());
                graphicsContext.fillOval(getMouseX() - size / 2, getMouseY() - size / 2 , getShapeSizeAsDouble(), getShapeSizeAsDouble());

        } catch (Exception e) {
            System.out.println("Error with draw");
        }
    }
    public Shape drawRectangle (GraphicsContext graphicsContext, ColorPicker colorPicker) {

        try {
            graphicsContext.setFill(colorPicker.getValue());
            graphicsContext.fillRect(getMouseX() - size / 2 , getMouseY() - size / 2  , getShapeSizeAsDouble(), getShapeSizeAsDouble());
        } catch (Exception e) {
            System.out.println("Error with draw");
        }
        return null;
    }
    public void addShapeToList(GraphicsContext graphicsContext, ColorPicker colorPicker){
        shape.add(drawRectangle(graphicsContext,colorPicker));

        System.out.println(shape.toString());
    }

    public String getShapeSize() {
        return shapeSize.get();
    }
    public Double getShapeSizeAsDouble() {
        try {
            return Double.parseDouble(getShapeSize());
        } catch (Exception e) {
            System.out.println("Please write a number.");
        }
        return null;
    }
    public StringProperty shapeSizeProperty() {
        return shapeSize;
    }

    public  void setShape(String shapeSize) {
        this.shapeSize.set(shapeSize);
    }

    public void changeSizeOnSelectedShapes() {
       shapeClass.setSize(getShapeSizeAsDouble());
    }

    /*
     public void deleteSelectedShapes() {
        addToUndoDeque();

        for (var shape : shape) {
            shapes.remove(shape);
        }
    }
    public void addToUndoDeque() {
        ObservableList<Shape> tempList = getTempList();
        undoDeque.addLast(tempList);
    }
    public ObservableList<Shape> getTempList() {
        ObservableList<Shape> tempList = FXCollections.observableArrayList();

        for (Shape shape : shapes) {
            tempList.add(shape.copyOf());
        }
        return tempList;
    }

  */

    }



