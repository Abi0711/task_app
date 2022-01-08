package taskapp;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Controller {

    public static VBox createTopic() {
        VBox topic = new VBox();
        topic.setBackground(new Background(new BackgroundFill(Color.BLACK,  new CornerRadii(10.0), new Insets(3))));
        Task l1 = new Task("Task 1");
        //VBox.setVgrow(l1, Priority.ALWAYS);
        
        Task l2 = new Task("Task 2");
        Task l3 = new Task("Task 3");
        Task l4 = new Task("Task 4");
        Task l5 = new Task("Task 5");

        Button addTask = new Button("+");

        addTask.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY,  new CornerRadii(10.0), new Insets(2))));
        addTask.setAlignment(Pos.CENTER);
        addTask.setMaxWidth(Double.MAX_VALUE);
        addTask.setFont(Font.font("Arial", 20));

        topic.getChildren().addAll(l1, l2, l3, l4, l5, addTask);


        addTask.setOnAction(actionEvent ->  {

        });

        return topic;
    }
}