package taskapp;

import javafx.scene.layout.*;

public class Controller {

    public static VBox createTopic() {
        VBox topic = new VBox();

        Task l1 = new Task("Task 1");
        VBox.setVgrow(l1, Priority.ALWAYS);
        
        Task l2 = new Task("Task 2");
        Task l3 = new Task("Task 3");
        Task l4 = new Task("Task 4");
        Task l5 = new Task("Task 5");

        topic.getChildren().addAll(l1, l2, l3, l4, l5);
        return topic;
    }
}