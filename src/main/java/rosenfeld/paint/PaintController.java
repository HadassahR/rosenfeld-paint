package rosenfeld.paint;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
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
    public List<RadioButton> toggleTools;
    final ToggleGroup paintTools = new ToggleGroup();

    public void initialize() {
        for (RadioButton t : toggleTools) {
            t.setToggleGroup(paintTools);
        }

    }

    public void clearCanvas() {
        GraphicsContext gc = paintCanvas.getGraphicsContext2D();
        gc.clearRect(0, 0, paintCanvas.getWidth(), paintCanvas.getWidth());

    }

    public void brush() {
        GraphicsContext gc = paintCanvas.getGraphicsContext2D();

        paintCanvas.setOnMouseDragged(e -> {
            double size = 20.00;
            double x = e.getX() - size / 2;
            double y = e.getY() - size / 2;
            gc.setFill(colorPicker.getValue());
            if (draw.isSelected()) {
                gc.fillRect(x, y, size, size);
            } else if (erase.isSelected()) {
                gc.clearRect(x, y, size, size);
            }
        });
    }
}


