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
import javafx.scene.text.Font;
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
        topicContainer.setAlignment(Pos.CENTER);
        topicContainer.getChildren().add(addTopic);

        addTopic.setOnAction(actionEvent ->  {
            //VBox t1 = Controller.createTopic();
            Topic t1 = new Topic();
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

class Topic extends VBox{
    //whether the user is editing a textbox currently
    boolean editing;
    TextArea newTask;

    Topic(){
        this.setBackground(new Background(new BackgroundFill(Color.BLACK,  new CornerRadii(10.0), new Insets(3))));
        newTask = new TextArea();
        //TODO set text box font and styling

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

        this.getChildren().addAll(l1, l2, l3, l4, l5, addTask);


        addTask.setOnAction(actionEvent ->  {
            if(!editing){
                this.getChildren().add(this.getChildren().size()-1,newTask);
                System.out.println("Can now edit");
                //TODO set focus to textarea
            }
            else{
                System.out.println("Already adding something");
            }
        });
        newTask.setOnKeyPressed( event -> {
            if( event.getCode() == KeyCode.ENTER ) {
                Task temp = new Task(newTask.getText());
                this.getChildren().remove(newTask);
                this.getChildren().add(this.getChildren().size()-1,temp);
                newTask.setText("");
                editing = false;
            }
        } );
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
        this.setBackground(new Background(new BackgroundFill(Color.ROYALBLUE, new CornerRadii(5.0), new Insets(5))));
        this.setMaxWidth(Double.MAX_VALUE);
        this.setText(taskName);
        this.setFont(Font.font("Arial", 30));
        this.setTextFill(Color.color(1,1,1));
        this.complete = false;


        //TODO drag tasks around
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