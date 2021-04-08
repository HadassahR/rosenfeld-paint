
package rosenfeld.paint;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class PaintCanvas extends Canvas {

    public void draw() {
        GraphicsContext context = getGraphicsContext2D();
        context.setLineWidth(1);
        context.setFill(Color.BLACK);
    }


}