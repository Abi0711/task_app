package taskapp;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.HPos;
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
        stage.setTitle("Schmello");
        VBox root = new VBox();
        root.setFillWidth(true);
        // Header
        GridPane heading = new GridPane();
        heading.setPadding(new Insets(5, 10, 5, 10));
        Label title = new Label("Title");
        title.setFont(Font.font("Arial", 30));
        heading.add(title,0,0);
        GridPane.setHalignment(title,HPos.LEFT);

        Button help = new Button("Help");
        heading.add(help,1,0);
        GridPane.setHalignment(help,HPos.RIGHT);
        //two grid columns = set two column constraints at 50% width
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(50);
        heading.getColumnConstraints().add(column1);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(50);
        heading.getColumnConstraints().add(column2);

        //Task area
        ScrollPane scroll = new ScrollPane();
        HBox topicContainer = new HBox();

        //add horizontal scroll
        scroll.setContent(topicContainer);
        scroll.setFitToHeight(true);

        root.getChildren().add(heading);
        root.getChildren().add(scroll);

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
            //add a vertical scroll to the task
            ScrollPane scrollPane = new ScrollPane();
            scrollPane.setContent(t1);
            HBox.setHgrow(scrollPane, Priority.ALWAYS);
            scrollPane.setFitToWidth(true);
            scrollPane.setMinWidth(300);
            scrollPane.setBackground(new Background(new BackgroundFill(Color.WHITE,  new CornerRadii(10.0), new Insets(2))));

            //add the new topic to the position before the button
            topicContainer.getChildren().add(topicContainer.getChildren().size()-1,scrollPane);
        });

        Scene scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.setMinWidth(640);
        stage.setMinHeight(480);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}


