package astro.path.UI;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class PopUpWindow {
	
	
	public static void display(Runnable onConfirm) {
		
		Stage popUp = new Stage();
		
		popUp.initModality(Modality.APPLICATION_MODAL); 		// Blocks user interaction with other Stages
		popUp.setTitle("Attention!");
		popUp.setMinWidth(300);
		
		Label poplabel = new Label("Do you want to leave?");
		
		Button closeButton = new Button("Yes");
		Button stayButton = new Button("No");
		
		closeButton.setOnAction(e -> {
									 popUp.close();
									 onConfirm.run();
							   });
		stayButton.setOnAction(e -> popUp.close());
		
		HBox layoutButtons = new HBox(20);
		layoutButtons.getChildren().addAll(closeButton, stayButton);
		layoutButtons.setAlignment(Pos.CENTER);
		
		VBox layoutPopUp = new VBox(20);
		layoutPopUp.getChildren().addAll(poplabel, layoutButtons);
		layoutPopUp.setAlignment(Pos.CENTER);
		
		popUp.setScene(new Scene(layoutPopUp));
		popUp.showAndWait();
		};
		
		
	}

