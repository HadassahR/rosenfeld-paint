package rosenfeld.paint;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class PaintController {

    @FXML
    public ColorPicker colorPicker;
    @FXML
    public CheckBox draw;
    @FXML
    public Canvas paintCanvas;
    @FXML
    public Button clear;

    public void clearCanvas(MouseEvent actionEvent) {
        GraphicsContext gc = paintCanvas.getGraphicsContext2D();
        paintCanvas.setOnMouseClicked(e -> {
            gc.clearRect(0, 0, paintCanvas.getWidth(), paintCanvas.getWidth());

        });
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
            } catch (Exception exc){
                exc.getMessage();
            }
        }
    }

}
