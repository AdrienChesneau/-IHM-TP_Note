package sample;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;

public class Controller {

    //On ajoute les objets
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

    //Ajout d'un Shape pour gérer la selection de figure  [NE FONCTIONNE PAS]
    Shape s;

    public Controller(){}

    @FXML
    public void initialize(){
        //On creer une zone graphique sur tout le canvas
        final GraphicsContext gc = canvas.getGraphicsContext2D();

        //Lorsque qu'on clique sur le canvas, on dessine/sectionne une figure selon le radioButton selectionné
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

        //Lorsque on reste appuyé sur une figure, on l'a move
        this.canvas.setOnMouseDragged((event) -> {
            });

        //Si une figure a été selectionné on l'a clone avec un déplacement vers le bas à droite
        this.clone.setOnMouseClicked((event) -> {
            if(selected.isSelected()){
            }
        });

        //Si une figure est selectionné on l'a supprime en l'a rendant opaque
        this.delete.setOnMouseClicked((event) -> {
            if(selected.isSelected()){
                Paint p = s.getStroke();
                p.isOpaque();
            }
        });

    }
}
