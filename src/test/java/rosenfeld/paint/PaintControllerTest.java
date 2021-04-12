package rosenfeld.paint;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;


import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class PaintControllerTest {
    @BeforeClass
    public static void beforeClass() {
        com.sun.javafx.application.PlatformImpl.startup(()->{});
    }

    @Test
    public void initialize(){
        // given
        PaintController controller = new PaintController();

        // when
        controller.initialize();

        // then
//        Mockito.verify(controller.paintTools)


    }
    @Test
    public void clearCanvas() {

        // given

        PaintController controller = new PaintController();

        // when

        // then

    }
    @Test
    public void draw(){

    }
    @Test
    public void erase(){

    }

}
