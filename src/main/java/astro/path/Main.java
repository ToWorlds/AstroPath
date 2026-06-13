package astro.path;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextAlignment;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Main extends Application{
	
	private Stage primaryStage;
	private Scene startUp;
	private Scene mainScene;
	private BorderPane root;
	private BorderPane layoutDash;
	private BorderPane layoutFleet;
	private BorderPane layoutSurfaceLander;
	
	//Images
	
	Image surfaceLanderImg = new Image("/ChatGPT_Image_May_17__2026_at_10_06_07_PM-removebg-preview-2.png");
	ImageView surfaceLanderView = new ImageView(surfaceLanderImg);
	ImageView surfaceLanderIcon = new ImageView(surfaceLanderImg);
	
	Image planetaryOrbiterImg = new Image("/ChatGPT Image May 17, 2026 at 10_06_07 PM-2.png");
	ImageView planetaryOrbiterView = new ImageView(planetaryOrbiterImg);
	
	Image spaceProbeImg = new Image("/ChatGPT Image Jun 13, 2026 at 01_41_30 PM.png");
	ImageView spaceProbeView = new ImageView(spaceProbeImg);
	
	Image backButtonImg = new Image("/6BFB9EE0-9F88-4FAD-8BD4-CFCAC9A177B1-2-removebg-preview.png");
	ImageView backButtonView = new ImageView(backButtonImg);
	

	//Buttons
	
	Button button = new Button("Launch into Space!");
	Button button2 = new Button("get me outta here!");
	
	Button surfaceLanderBtn = new Button("Surface Landers");
	Button planetaryOrbiterBtn = new Button("Planetary Orbiters");
	Button spaceProbeBtn = new Button("Deep-Space Probes");
	Button backButton = new Button("BACK");

	public static void main(String [] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) throws Exception{
		
		//Stage
		
		this.primaryStage = primaryStage;
		primaryStage.setTitle("AstroPath");
		
		//Labels
		
		Label labelStart = new Label("Hello fellow Traveler!");
		labelStart.setStyle("-fx-text-fill: black;");
		Label surfaceLabel = new Label("Surface Landers");
		surfaceLabel.setStyle("-fx-font-size: 16px;" +
				"-fx-text-fill: white;"
				);
		
		//Tables
		
		TableView<?> surfaceTable = new TableView();
		surfaceTable.setPlaceholder(new Label("No Data yet..."));
		surfaceTable.setMaxWidth(400);
		surfaceTable.setMaxHeight(300);
		
		//Layouts(Boxes)
		
		VBox layoutStart = new VBox(20);
		layoutStart.getChildren().addAll(labelStart ,button);
		layoutStart.setAlignment(Pos.CENTER);
		layoutStart.setStyle(
				"-fx-background-image: url('/shutterstock_1847866900-1-600x400.jpg');"
				+ "-fx-background-size: cover;"
				);
		
		HBox quitButton = new HBox(button2);
		quitButton.setAlignment(Pos.TOP_RIGHT);
		
		
		layoutDash = new BorderPane();
		layoutDash.setRight(quitButton);
		
		layoutDash.setStyle(
				"-fx-background-image: url('/7NvodtH-1080p-wallpaper-space.jpg');"
				+ "-fx-background-size: cover;"
				);
		
		HBox spacecraftBtns = new HBox(30);
		spacecraftBtns.getChildren().addAll(surfaceLanderBtn,planetaryOrbiterBtn, spaceProbeBtn);
		spacecraftBtns.setAlignment(Pos.CENTER);

		
		VBox surfaceImage = new VBox(surfaceLanderIcon, surfaceLabel);
		surfaceImage.setAlignment(Pos.CENTER_LEFT);
		
		VBox tableBox = new VBox(surfaceTable);
		tableBox.setAlignment(Pos.CENTER);
		
		layoutFleet = new BorderPane();
		layoutFleet.setCenter(spacecraftBtns);
		layoutFleet.setStyle(
				"-fx-background-image: url('/nathan-anderson-KvgB81s4dF0-unsplash.jpg');"
				+ "-fx-background-size: cover;"
				);
		
		VBox backBox = new VBox();
		backBox.setPadding(new Insets(5, 0, 10, 0));
		backBox.getChildren().add(backButton);
		
		VBox leftSurfaceBox = new VBox();
		leftSurfaceBox.getChildren().addAll(backBox, surfaceImage);
		leftSurfaceBox.setSpacing(200);
		
		layoutSurfaceLander = new BorderPane();
		layoutSurfaceLander.setLeft(leftSurfaceBox);
		surfaceImage.setPadding(new Insets(0, 0, 0, 20));
		layoutSurfaceLander.setCenter(tableBox);
		layoutSurfaceLander.setStyle(
				"-fx-background-image: url('/nathan-anderson-KvgB81s4dF0-unsplash.jpg');"
				+ "-fx-background-size: cover;"
				);
		
		
		root = new BorderPane();

		
		//Scenes
		
		startUp = new Scene(layoutStart, 600, 400);
		mainScene = new Scene(root, 600, 400);
		
		layoutDash.setTop(createNavBar());
		layoutFleet.setTop(createNavBar());
		layoutSurfaceLander.setTop(createNavBar());
		
		//Button interaction
		
		button.setOnAction(e -> setView(layoutDash, 1200, 800));
		button2.setOnAction(e -> PopUpWindow.display( () -> setView(layoutStart, 600, 400)));
		surfaceLanderBtn.setOnAction(e -> setView(layoutSurfaceLander, 1200, 800));
		backButton.setOnAction(e -> setView(layoutFleet, 1200, 800));
		
		//Button adjustment
		
		surfaceLanderBtn.setGraphic(surfaceLanderView);
		surfaceLanderBtn.setContentDisplay(ContentDisplay.TOP);
		surfaceLanderBtn.setAlignment(Pos.CENTER);
		surfaceLanderBtn.setTextAlignment(TextAlignment.RIGHT);
		surfaceLanderBtn.setStyle("-fx-text-fill: white;" +
								  "-fx-font-size: 16px;" +
								  "-fx-background-color: transparent;" +
								  "-fx-border-color: lightblue;"
								 );
		
		double imgWidth = surfaceLanderView.getImage().getWidth();
		double imgHeight = surfaceLanderView.getImage().getHeight();
		
		planetaryOrbiterBtn.setGraphic(planetaryOrbiterView);
		planetaryOrbiterBtn.setContentDisplay(ContentDisplay.TOP);
		planetaryOrbiterBtn.setAlignment(Pos.CENTER);
		planetaryOrbiterBtn.setTextAlignment(TextAlignment.CENTER);
		planetaryOrbiterBtn.setStyle("-fx-text-fill: white;" +
								  "-fx-font-size: 16px;" +
								  "-fx-background-color: transparent;" +
								  "-fx-border-color: lightblue;"
								 );
		planetaryOrbiterView.setFitWidth(imgWidth);
		planetaryOrbiterView.setFitHeight(imgHeight);
		
		spaceProbeBtn.setGraphic(spaceProbeView);
		spaceProbeBtn.setContentDisplay(ContentDisplay.TOP);
		spaceProbeBtn.setAlignment(Pos.CENTER);
		spaceProbeBtn.setTextAlignment(TextAlignment.CENTER);
		spaceProbeBtn.setStyle("-fx-text-fill: white;" +
								  "-fx-font-size: 16px;" +
								  "-fx-background-color: transparent;" +
								  "-fx-border-color: lightblue;"
								 );
		spaceProbeView.setFitWidth(imgWidth);
		spaceProbeView.setFitHeight(imgHeight);
		
		backButton.setGraphic(backButtonView);
		backButton.setGraphicTextGap(0);
		backButton.setPadding(Insets.EMPTY);
		backButton.setContentDisplay(ContentDisplay.TOP);
		backButton.setAlignment(Pos.CENTER);
		backButton.setTextAlignment(TextAlignment.CENTER);
		backButton.setStyle("-fx-text-fill: white;" +
								  "-fx-font-size: 16px;" +
								  "-fx-background-color: transparent;" +
								  "-fx-border-color: transparent;" 
								 );
		backButtonView.setFitWidth(100);
		backButtonView.setFitHeight(50);
		
		primaryStage.setWidth(600);
		primaryStage.setHeight(400);
		root.setCenter(layoutStart);	
		primaryStage.setScene(mainScene);
		primaryStage.show();
		
	}
	
	//Function to create Navigation Bar for each Scene
	
	private HBox createNavBar() {
		
		//Buttons
		
		Button homeButton = new Button("AstroPath");
		Button fleetButton = new Button("Fleet");
		Button telemetryButton = new Button("Telemetry");
		Button objectivesButton = new Button("Objectives");
		Button eventLogButton = new Button("Event Log");
		
		//Button Size and Font
		
		homeButton.setPrefSize(200, 67);
		homeButton.setStyle("-fx-font-size: 25px;" +
					"-fx-text-fill: black;" +
					"-fx-background-color: rgba(58, 110, 165, 0.6);"
				);
		fleetButton.setPrefSize(150, 50);
		fleetButton.setStyle("-fx-font-size: 16px;" +
				"-fx-text-fill: black;" +
				"-fx-background-color: rgba(58, 110, 165, 0.6);"	
				);
		telemetryButton.setPrefSize(150, 50);
		telemetryButton.setStyle("-fx-font-size: 16px;" +
				"-fx-text-fill: black;" +
				"-fx-background-color: rgba(58, 110, 165, 0.6);"
				);
		objectivesButton.setPrefSize(150, 50);
		objectivesButton.setStyle("-fx-font-size: 16px;" +
				"-fx-text-fill: black;" +
				"-fx-background-color: rgba(58, 110, 165, 0.6);"
				);
		eventLogButton.setPrefSize(150, 50);
		eventLogButton.setStyle("-fx-font-size: 16px;" +
				"-fx-text-fill: black;" +
				"-fx-background-color: rgba(58, 110, 165, 0.6);"
				);
		
		//Events
		homeButton.setOnAction(e -> setView(layoutDash, 1200, 800));
		fleetButton.setOnAction(e -> setView(layoutFleet, 1200, 800));
		
		
		HBox navBar = new HBox(10);
		navBar.getChildren().addAll(homeButton, fleetButton, telemetryButton, objectivesButton, eventLogButton);
		navBar.setAlignment(Pos.TOP_LEFT);
		
		return navBar;
	}
	
	private void setView(Region view, double w, double h) {
		root.setCenter(view);
		primaryStage.setWidth(w);
		primaryStage.setHeight(h);
	}
}

