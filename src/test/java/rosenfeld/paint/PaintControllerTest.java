package rosenfeld.paint;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.paint.Color;
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
        controller.paintCanvas = mock(PaintCanvas.class);
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

        //then

        verify(controller.paintCanvas.getGraphicsContext2D()).clearRect(0, 0,
               controller.paintCanvas.getHeight(), controller.paintCanvas .getWidth());

    }

    @Test
    public void brush_DrawSelected() {
        // given
        givenPaintController();
        controller.draw.setSelected(true);
        controller.erase.setSelected(false);

        //when
        controller.brush();

        // then
        verify(controller.draw).setSelected(true);
        verify(controller.erase).setSelected(false);

    }

    @Test
    public void brush_EraseSelected() {
        // given
        givenPaintController();
        controller.draw.setSelected(false);
        controller.erase.setSelected(true);

        //when
        controller.brush();

        // then
        verify(controller.draw).setSelected(false);
        verify(controller.erase).setSelected(true);

    }

    @Test
    public void brush_ColorChanged(){
        // given
        givenPaintController();
        controller.colorPicker.setValue(Color.DARKBLUE);

        // when
        controller.brush();

        // then
        verify(controller.colorPicker).setValue(Color.DARKBLUE);

    }
}
