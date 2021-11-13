package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("Task App");
//        Group root = new Group();
//        Scene scene = new Scene(root, 300,300);
//        stage.setScene(scene);
//        Rectangle r = new Rectangle(100,100,100,100);
//        r.setFill(Color.RED);
//        root.getChildren().add(r);
        StackPane rootText = new StackPane();
        Scene sceneText = new Scene(rootText, 600,700);
        stage.setScene(sceneText);
        Text hi = new Text("Hello World");
        hi.setFont(Font.font("Tahoma", FontWeight.BLACK, 40));
        hi.setFill(Color.ROYALBLUE);
        //stage.setOpacity(0.5);
        rootText.getChildren().add(hi);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
