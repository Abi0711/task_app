package taskapp;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

class Topic extends VBox {
    //whether the user is editing a textbox currently
    private boolean editing = false;
    private TextField newTask;


    Topic(){
        this.setBackground(new Background(new BackgroundFill(Color.BLACK,  new CornerRadii(10.0), new Insets(3))));
        newTask = new TextField();
        //newTask.setBackground(new Background(new BackgroundFill(Color.BLACK,  new CornerRadii(20.0), new Insets(3))));
        newTask.setBackground(
                new Background(new BackgroundFill(Color.WHITE, new CornerRadii(20.0), null))
        );
        newTask.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(20.0), BorderWidths.DEFAULT)));
        VBox.setVgrow(newTask, Priority.ALWAYS);

        Button addTask = new Button("+");
        addTask.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY,  new CornerRadii(10.0), new Insets(2))));
        addTask.setAlignment(Pos.CENTER);
        addTask.setMaxWidth(Double.MAX_VALUE);
        addTask.setFont(Font.font("Arial", 20));

        this.getChildren().addAll(newTask, addTask);
        //Hint text
        newTask.setPromptText("Enter topic name");
        newTask.getParent().requestFocus();
        editing = true;

        //add a new task if not already editing
        addTask.setOnAction(actionEvent ->  {
            if(!editing){
                this.getChildren().add(this.getChildren().size()-1,newTask);
                System.out.println("Can now edit");
                newTask.setPromptText("Enter task name");
                newTask.getParent().requestFocus();
                editing = true;
            } else{
                //TODO if already editing highlight text box that is being edited
                System.out.println("editing");
            }
        });
        //
        newTask.setOnKeyPressed( event -> {
            if( event.getCode() == KeyCode.ENTER ) {
                Task temp = new Task(newTask.getText());
                if(this.getChildren().size()==2){
                    temp.setColour(Color.BLACK);
                }

                this.getChildren().remove(newTask);
                this.getChildren().add(this.getChildren().size()-1,temp);
                newTask.setText("");
                editing = false;
            }
        } );

    }
}