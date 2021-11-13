package taskapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

public class Main extends Application {

    ArrayList<Label> allTasks = new ArrayList<>();
    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("Task App");

        TextArea textarea = new TextArea();
        Group group = new Group();
        group.getChildren().addAll(textarea);

        Scene scene = new Scene(group, 640, 480);
        stage.setScene(scene);
        stage.show();
        textarea.setOnKeyPressed( event -> {
            if( event.getCode() == KeyCode.ENTER ) {
                Label txtField = new Label();
                txtField.setText(textarea.getText());
                Task t = new Task(textarea.getText(), txtField);
                group.getChildren().add(t);
            }
        } );
//        for (Task t: allTasks) {
//
//        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}

class Task extends Label {
    String taskName;
    private double mousex;
    private double mousey;
    //String description;
    boolean complete;
    private Label text;
    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;
    //int deadline or dateDue

    Task(String taskName, Label t) {
        this.setLayoutX(300);
        this.setLayoutY(300);
        Border b = new Border((new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        this.setBorder(b);
        this.setText(taskName);

        this.taskName = taskName;
        this.complete = false;
        this.text = t;

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

//        Node textAreaContent = text.lookup(".content");
//        textAreaContent.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
//
//            System.out.println("is clicked");
//
//            orgSceneX = e.getSceneX();
//            orgSceneY = e.getSceneY();
//            orgTranslateX = text.getTranslateX();
//            orgTranslateY = text.getTranslateY();
//
//            text.toFront();
//        });
//
//        textAreaContent.addEventHandler(MouseEvent.MOUSE_DRAGGED, e -> {
//
//            System.out.println("is dragged");
//
//            double offsetX = e.getSceneX() - orgSceneX;
//            double offsetY = e.getSceneY() - orgSceneY;
//            double newTranslateX = orgTranslateX + offsetX;
//            double newTranslateY = orgTranslateY + offsetY;
//
//            text.setTranslateX(newTranslateX);
//            text.setTranslateY(newTranslateY);
//        });
    }
}