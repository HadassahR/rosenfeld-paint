package rosenfeld.paint;

import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class PaintControllerTest {

    private PaintController controller;
    private ColorPicker colorPicker;
    private RadioButton draw;
    private RadioButton erase;
    private Canvas paintCanvas;
    private Button clear;
    private List<RadioButton> toggleTools;


    @BeforeClass
    public static void beforeClass() {
        com.sun.javafx.application.PlatformImpl.startup(() -> {
        });
    }

    private void givenPaintController() {
        controller = new PaintController();
        controller.colorPicker = mock(ColorPicker.class);
        controller.draw = mock(RadioButton.class);
        controller.erase = mock(RadioButton.class);
        controller.paintCanvas = mock(Canvas.class);
        controller.clear = mock(Button.class);
        controller.toggleTools = Arrays.asList(
                mock(RadioButton.class),
                mock(RadioButton.class));
    }

    @Test
    public void initialize() {
        //given
        givenPaintController();
        doReturn("draw", "erase")
                .when(toggleTools).listIterator();

        // when
        controller.initialize();

        // then
        verify(controller.toggleTools).get(0).setText("draw");
        verify(controller.toggleTools).get(1).setText("erase");

    }

//    @Test
//    public void clearCanvas() {
//        givenPaintController();
//        // when
//        controller.clearCanvas();
//
//        // then
//    }
//
//    @Test
//    public void draw() {
//        givenPaintController();
//
//    }
//
//    @Test
//    public void erase() {
//        givenPaintController();
//
//        controller.brush();
//
//    }

}
