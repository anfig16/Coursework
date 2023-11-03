//*****************
//Andrea Figueroa
//HW 9- Event-Driven Programming
//Programming Exercise 15.3- Move the ball
//Spring 2023
//COSC 1174
//*****************
package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;

public class Main extends Application {
	Button left = new Button("Left");
	Button right = new Button("Right");
	Button up = new Button("Up");
	Button down = new Button("Down");
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Circle circle = new Circle(25);
			circle.setStroke(Color.BLACK);
			circle.setFill(Color.TRANSPARENT);
			circle.setCenterX(50);
			circle.setCenterY(50);
			Pane pane = new Pane(circle);
			
			HBox hBox = new HBox(left, right, up, down);
			hBox.setSpacing(5);
			hBox.setAlignment(Pos.CENTER);
			BorderPane borderPane = new BorderPane(pane);
			borderPane.setBottom(hBox);
			
			left.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					if(circle.getCenterX() > 25) {
						circle.setCenterX(circle.getCenterX()-5);
					}
				}
			});
			right.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					if(circle.getCenterX() < 275) {
						circle.setCenterX(circle.getCenterX()+5);
					}
				}
			});
			up.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					if(circle.getCenterY() > 25) {
						circle.setCenterY(circle.getCenterY()-5);
					}
				}
			});
			down.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					if(circle.getCenterY() < 120) {
						circle.setCenterY(circle.getCenterY()+5);
					}
				}
			});

			Scene scene = new Scene(borderPane, 300, 170);
			primaryStage.setTitle("Exercise15_03");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}
