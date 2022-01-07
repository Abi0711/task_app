package taskapp;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Controller {
    public static VBox createTopic() {
        VBox hbox = new VBox();

        Label l1 = new Label("Label 1");
        l1.setAlignment(Pos.CENTER);
        l1.setBackground(new Background(new BackgroundFill(Color.ROYALBLUE, new CornerRadii(5.0), new Insets(5, 5,5,5))));
        l1.setMaxWidth(Double.MAX_VALUE);
        //l1.setMaxHeight(Double.MAX_VALUE);
        VBox.setVgrow(l1, Priority.ALWAYS);

        hbox.setFillWidth(true);


        Label l2 = new Label("Label 2");
        l2.setMaxWidth(200);
        //l2.setMaxHeight(200);
        l2.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, new CornerRadii(5.0), new Insets(5, 5,5,5))));

        Label l3 = new Label("Label 3");
        l3.setMaxWidth(200);

        Label l4 = new Label("Label 4");


        Label l5 = new Label("Label 5");

        hbox.getChildren().addAll(l1, l2, l3, l4, l5);
        return hbox;
    }
}
