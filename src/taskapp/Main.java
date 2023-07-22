package taskapp;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.ScrollPane;
import javafx.scene.Group;
import javafx.scene.control.TextArea;

import java.awt.*;
import java.util.ArrayList;

public class Main extends Application {

    ArrayList<Task> allTasks = new ArrayList<>();
    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("Task App");
        ScrollPane root = new ScrollPane();
        HBox topicContainer = new HBox();
        Scene scene = new Scene(root, 640, 480);
        //add horizontal scroll
        root.setContent(topicContainer);
        root.setFitToHeight(true);

        //add button to create new topics
        Button addTopic = new Button("+ New Topic");
        addTopic.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE,  new CornerRadii(10.0), new Insets(2))));
        addTopic.prefHeightProperty().bind(stage.widthProperty());
        addTopic.setPrefWidth(100);
        topicContainer.setAlignment(Pos.CENTER);
        topicContainer.getChildren().add(addTopic);

        //if the user presses the button for a new topic
        addTopic.setOnAction(actionEvent ->  {
            Topic t1 = new Topic();
            //add a horizontal scroll to the task
            ScrollPane scroll = new ScrollPane();
            scroll.setContent(t1);
            HBox.setHgrow(scroll, Priority.ALWAYS);
            scroll.setFitToWidth(true);
            scroll.setMinWidth(300);
            scroll.setBackground(new Background(new BackgroundFill(Color.WHITE,  new CornerRadii(10.0), new Insets(2))));

            //add the new topic to the position before the button
            topicContainer.getChildren().add(topicContainer.getChildren().size()-1,scroll);
        });

        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}


