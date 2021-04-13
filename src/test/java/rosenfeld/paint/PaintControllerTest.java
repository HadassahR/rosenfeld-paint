package rosenfeld.paint;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PaintControllerTest {

    private PaintController controller;


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

        // when
        controller.initialize();

        // then
        verify(controller.toggleTools.get(0)).setToggleGroup(controller.paintTools);
        verify(controller.toggleTools.get(1)).setToggleGroup(controller.paintTools);
    }

    @Test
    public void clearCanvas() {
        //given
        givenPaintController();

        // when
        controller.clearCanvas();

        // then
        verify(controller.paintCanvas.getGraphicsContext2D()).clearRect(0, 0,
                controller.paintCanvas.getHeight(), controller.paintCanvas.getWidth());

    }

    @Test
    public void draw() {
        // given
        givenPaintController();

        //when
        controller.brush();

        // then

    }

    @Test
    public void erase() {
        // given
        givenPaintController();

        // when
        controller.brush();

        // then
    }

}
