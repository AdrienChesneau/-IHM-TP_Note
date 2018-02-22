package sample;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;
import javafx.scene.control.ToggleGroup;

import java.awt.*;


public class Controller {

    @FXML
    private RadioButton selected;
    @FXML
    private RadioButton ellipse;
    @FXML
    private RadioButton line;
    @FXML
    private RadioButton rectangle;
    @FXML
    private Button delete;
    @FXML
    private Button clone;
    @FXML
    private Canvas canvas;
    @FXML
    private ColorPicker color;

    Shape s;



    public Controller(){}

    @FXML
    public void initialize(){
        final GraphicsContext gc = canvas.getGraphicsContext2D();

        this.canvas.setOnMouseClicked((event) -> {
            gc.setFill(color.getValue());
            gc.setStroke(color.getValue());
            if (ellipse.isSelected()) {
                gc.fillOval(event.getX(), event.getY(), 50, 50);
            } else if (line.isSelected()) {
                gc.strokeLine(event.getX(), event.getY(), event.getX() + 20, event.getY() + 80);
            } else if (rectangle.isSelected()) {
                gc.fillRect(event.getX(), event.getY(), 50, 50);
            } else if(selected.isSelected()){
                 s = (Shape) event.getSource();
            }
        });

        this.canvas.setOnMouseDragged((event) -> {
            if (selected.isSelected()) {
            }});

        this.clone.setOnMouseClicked((event) -> {
            if(selected.isSelected()){
            }
        });

        this.delete.setOnMouseClicked((event) -> {
            if(selected.isSelected()){
                Paint p = s.getStroke();
                p.isOpaque();
            }
        });

    }
}
