package rosenfeld.paint;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class PaintController {

    @FXML
    public ColorPicker colorPicker;
    @FXML
    public RadioButton draw;
    @FXML
    public RadioButton erase;
    @FXML
    public Canvas paintCanvas;
    @FXML
    public Button clear;
    @FXML
    public Slider lineThickness;
    @FXML
    List<RadioButton> toggleTools;

    final ToggleGroup paintTools = new ToggleGroup();

    public void initialize(){
        for (RadioButton t : toggleTools){
            t.setToggleGroup(paintTools);
        }
    }

    public void clearCanvas(MouseEvent actionEvent) {
        GraphicsContext gc = paintCanvas.getGraphicsContext2D();
        gc.clearRect(0, 0, paintCanvas.getWidth(), paintCanvas.getWidth());

    }

    public void draw(MouseEvent actionEvent) {
        GraphicsContext gc = paintCanvas.getGraphicsContext2D();
        if (draw.isSelected()) {
            try {
                paintCanvas.setOnMouseDragged(e -> {
                    double size = 20.0;
                    double x = e.getX() - size / 2;
                    double y = e.getY() - size / 2;
                    gc.setFill(colorPicker.getValue());
                    gc.fillOval(x, y, size, size);
                });
            } catch (Exception exc) {
                exc.getMessage();
            }
        } else {
//            double size = 0.0;
            // do nothing
        }
    }

    public void erase(MouseEvent mouseEvent) {
        GraphicsContext gc = paintCanvas.getGraphicsContext2D();
        if (erase.isSelected()) {
            try {
                paintCanvas.setOnMouseDragged(e -> {
                    double size = 20.0;
                    double x = e.getX() - size / 2;
                    double y = e.getY() - size / 2;
                    gc.setFill(colorPicker.getValue());
                    gc.clearRect(x, y, size, size);
                });
            } catch (Exception exc) {
                exc.getMessage();
            }
        } else {
//            double size = 0.0;
            // do nothing
        }
    }
}
