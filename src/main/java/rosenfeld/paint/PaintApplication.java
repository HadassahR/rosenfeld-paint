package rosenfeld.paint;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PaintApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/paint_application.fxml"));
        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("Paint");
        stage.setScene(scene);
        stage.show();

    }

    private void setupPaintComponents() {

        // Tools
        ToggleButton draw = new ToggleButton("Draw");
        ToggleButton erase = new ToggleButton("Erase");


        ToggleButton[] toolsArr = {draw, erase};
        ToggleGroup tools = new ToggleGroup();

        for (ToggleButton tool : toolsArr) {
            tool.setMinWidth(50);
            tool.setToggleGroup(tools);
        }

        Button clear = new Button("Clear");
        clear.setPadding(new Insets(5));
        clear.setPrefWidth(50);

        // Color picker
        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setValue(Color.BLACK);

        // Canvas

        Canvas canvas = new Canvas(200, 200);
        GraphicsContext gc;
        gc = canvas.getGraphicsContext2D();
        gc.setLineWidth(1);
    }

    public static void main(String[] args) {
        launch(args);
    }
}