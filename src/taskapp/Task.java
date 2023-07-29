package taskapp;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * Individual tasks within a topic
 */
class Task extends Label {
    private double mousex;
    private double mousey;
    //String description;
    boolean complete;
    //int deadline or dateDue

    Task(String taskName) {
        this.setAlignment(Pos.CENTER);
        this.setBackground(new Background(new BackgroundFill(Color.ROYALBLUE, new CornerRadii(5.0), new Insets(5))));
        //TODO add padding to task - letters with tail e.g. p,g,j overflow out of task box

        this.setMaxWidth(Double.MAX_VALUE);
        this.setText(taskName);
        this.setFont(Font.font("Arial", 30));
        this.setTextFill(Color.color(1,1,1));
        this.complete = false;
        //if user double clicks
        this.setOnMouseClicked(mouseEvent -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() == 2){
                    System.out.println("Double clicked");
                }
            }
        });
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

    public void setColour(Color color){
        this.setBackground(new Background(new BackgroundFill(color, new CornerRadii(5.0), new Insets(5))));
    }
}