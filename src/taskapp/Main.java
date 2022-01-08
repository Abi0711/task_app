package taskapp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.control.TextArea;

import java.awt.*;
import java.util.ArrayList;

public class Main extends Application {

    ArrayList<Task> allTasks = new ArrayList<>();
    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("Task App");
        HBox topicContainer = new HBox();
        Button addTopic = new Button("+ New Topic");
        topicContainer.getChildren().add(addTopic);

        addTopic.setOnAction(actionEvent ->  {
            VBox t1 = Controller.createTopic();
            HBox.setHgrow(t1, Priority.ALWAYS);
            topicContainer.getChildren().add(0,t1);
        });

        TextArea textarea = new TextArea();
        Group group = new Group();
        group.getChildren().addAll(textarea);



        Scene scene = new Scene(topicContainer, 640, 480);
        stage.setScene(scene);
        stage.show();
        textarea.setOnKeyPressed( event -> {
            if( event.getCode() == KeyCode.ENTER ) {

                Label txtField = new Label();
                txtField.setText(textarea.getText());
                Task t = new Task(textarea.getText());

                group.getChildren().add(t);
                allTasks.add(t);
            }
        } );

    }


    public static void main(String[] args) {
        launch(args);
    }
}

class Task extends Label {
    private double mousex;
    private double mousey;
    //String description;
    boolean complete;
    //int deadline or dateDue

    Task(String taskName) {
        this.setAlignment(Pos.CENTER);
        this.setBackground(new Background(new BackgroundFill(Color.ROYALBLUE, new CornerRadii(5.0), new Insets(5, 5,5,5))));
        this.setMaxWidth(Double.MAX_VALUE);
        this.setText(taskName);

        this.complete = false;
        this.setText(taskName);

        this.setOnMousePressed(event -> {
            mousex = this.getLayoutX() - event.getSceneX();
            mousey = this.getLayoutY() - event.getSceneY();
        });

        this.setOnMouseDragged(event -> {
            this.setLayoutX(event.getSceneX()+mousex);
            this.setLayoutY(event.getSceneY()+mousey);
        });
        setOnMouseReleased(event -> {     // drag is complete
            mousex = event.getSceneX();
            mousey = event.getSceneY();
        });
        this.toFront();
    }
}