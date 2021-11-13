package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

import javax.swing.text.html.ImageView;
import java.util.ArrayList;

public class Main extends Application {

    ArrayList<Label> allTasks = new ArrayList<>();
    @Override
    public void start(Stage stage) throws Exception{
//        stage.setTitle("Task App");
////        Group root = new Group();
////        Scene scene = new Scene(root, 300,300);
////        stage.setScene(scene);
////        Rectangle r = new Rectangle(100,100,100,100);
////        r.setFill(Color.RED);
////        root.getChildren().add(r);
//        StackPane rootText = new StackPane();
//        Scene sceneText = new Scene(rootText, 600,700);
//        stage.setScene(sceneText);
//        Text hi = new Text("Hello World");
//        hi.setFont(Font.font("Tahoma", FontWeight.BLACK, 40));
//        hi.setFill(Color.ROYALBLUE);
//        //stage.setOpacity(0.5);
//        rootText.getChildren().add(hi);
//        stage.show();
//        TextArea textarea = new TextArea();
//        Group group = new Group();
//        group.getChildren().addAll(textarea);


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