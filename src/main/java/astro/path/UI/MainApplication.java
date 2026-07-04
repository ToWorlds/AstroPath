package astro.path.UI;

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

import astro.path.objects.*;
import astro.path.controller.*;

public class MainApplication extends Application{
	
	private Stage primaryStage;
	private Scene startUp;
	private Scene mainScene;
	private BorderPane root;
	private BorderPane layoutDash;
	private BorderPane layoutFleet;
	private BorderPane layoutSurfaceLander;
	private BorderPane layoutTelemetry;
	private BorderPane layoutObjectives;
	private BorderPane layoutEventLog;
	private BorderPane layoutPlanetaryOrbiter;
	private BorderPane layoutSpaceProbe;
	
	//Images
	
	Image surfaceLanderImg = new Image("/ChatGPT_Image_May_17__2026_at_10_06_07_PM-removebg-preview-2.png");
	ImageView surfaceLanderView = new ImageView(surfaceLanderImg);
	ImageView surfaceLanderIcon = new ImageView(surfaceLanderImg);
	
	Image planetaryOrbiterImg = new Image("/ChatGPT Image May 17, 2026 at 10_06_07 PM-2.png");
	ImageView planetaryOrbiterView = new ImageView(planetaryOrbiterImg);
	ImageView planetaryOrbiterIcon = new ImageView(planetaryOrbiterImg);
	
	Image spaceProbeImg = new Image("/ChatGPT Image Jun 13, 2026 at 01_41_30 PM.png");
	ImageView spaceProbeView = new ImageView(spaceProbeImg);
	ImageView spaceProbeIcon = new ImageView(spaceProbeImg);
	
	Image backButtonImg = new Image("/6BFB9EE0-9F88-4FAD-8BD4-CFCAC9A177B1-2-removebg-preview.png");
	ImageView backButtonView = new ImageView(backButtonImg);
	ImageView backButtonView2 = new ImageView(backButtonImg);
	ImageView backButtonView3 = new ImageView(backButtonImg);

	//Buttons
	
	Button button = new Button("Launch into Space!");
	Button button2 = new Button("get me outta here!");
	
	Button surfaceLanderBtn = new Button("Surface Landers");
	Button planetaryOrbiterBtn = new Button("Planetary Orbiters");
	Button spaceProbeBtn = new Button("Deep-Space Probes");
	Button backButton = new Button("BACK");
	Button backButton2 = new Button("BACK");
	Button backButton3 = new Button("BACK");

	public static void main(String [] args) {
		DataController dc = new DataController();
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
		
		Label orbiterLabel = new Label("Planetary Orbiters");
		orbiterLabel.setStyle("-fx-font-size: 16px;" +
				"-fx-text-fill: white;"
				);
		
		Label probeLabel = new Label("Deep-Space Probes");
		probeLabel.setStyle("-fx-font-size: 16px;" +
				"-fx-text-fill: white;"
				);
		
		//Tables
		
		TableView<?> surfaceTable = new TableView();
		surfaceTable.setPlaceholder(new Label("No Surface Lander Data yet..."));
		surfaceTable.setMaxWidth(400);
		surfaceTable.setMaxHeight(300);
		
		TableView<?> orbiterTable = new TableView();
		orbiterTable.setPlaceholder(new Label("No Planetary Orbiter Data yet..."));
		orbiterTable.setMaxWidth(400);
		orbiterTable.setMaxHeight(300);
		
		TableView<?> probeTable = new TableView();
		probeTable.setPlaceholder(new Label("No Deep-Space Probe Data yet..."));
		probeTable.setMaxWidth(400);
		probeTable.setMaxHeight(300);
		
		TableView<?> dashTelemetryTable = new TableView();
		dashTelemetryTable.setPlaceholder(new Label("No Telemetry data yet..."));
		dashTelemetryTable.setMaxWidth(600);
		dashTelemetryTable.setMaxHeight(150);
		
		TableView<?> dashFleetTable = new TableView();
		dashFleetTable.setPlaceholder(new Label("No Fleet data yet..."));
		dashFleetTable.setMaxWidth(200);
		dashFleetTable.setMaxHeight(200);
		
		TableView<?> objectivesTable = new TableView();
		objectivesTable.setPlaceholder(new Label("No Objectives Data yet..."));
		objectivesTable.setMaxWidth(800);
		objectivesTable.setMaxHeight(600);
		
		TableView<?> telemetryTable = new TableView();
		telemetryTable.setPlaceholder(new Label("No Telemetry Data yet..."));
		telemetryTable.setMaxWidth(600);
		telemetryTable.setMaxHeight(500);
		
		TableView<?> eventLogTable = new TableView();
		eventLogTable.setPlaceholder(new Label("No Events yet..."));
		eventLogTable.setMaxWidth(800);
		eventLogTable.setMaxHeight(800);
		
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
		
		VBox tableBox = new VBox(surfaceTable);
		tableBox.setAlignment(Pos.CENTER);
		
		VBox tableBox2 = new VBox(orbiterTable);
		tableBox2.setAlignment(Pos.CENTER);
		
		VBox tableBox3 = new VBox(probeTable);
		tableBox3.setAlignment(Pos.CENTER);
		
		VBox tableBoxDashTelemetry = new VBox(dashTelemetryTable);
		tableBoxDashTelemetry.setAlignment(Pos.BOTTOM_LEFT);
		
		VBox tableBoxDashFleet = new VBox(dashFleetTable);
		tableBoxDashFleet.setAlignment(Pos.CENTER_LEFT);
		
		VBox tableBoxObjectives = new VBox(objectivesTable);
		tableBoxObjectives.setAlignment(Pos.CENTER);
		
		VBox tableBoxTelemetry = new VBox(telemetryTable);
		tableBoxTelemetry.setAlignment(Pos.CENTER);
		
		VBox tableBoxEventLog = new VBox(eventLogTable);
		tableBoxEventLog.setAlignment(Pos.CENTER);
		
		HBox spacecraftBtns = new HBox(30);
		spacecraftBtns.getChildren().addAll(surfaceLanderBtn,planetaryOrbiterBtn, spaceProbeBtn);
		spacecraftBtns.setAlignment(Pos.CENTER);
		
		layoutFleet = new BorderPane();
		layoutFleet.setCenter(spacecraftBtns);
		layoutFleet.setStyle(
				"-fx-background-image: url('/nathan-anderson-KvgB81s4dF0-unsplash.jpg');"
				+ "-fx-background-size: cover;"
				);
		
		layoutDash = new BorderPane();
		layoutDash.setRight(quitButton);
		layoutDash.setBottom(tableBoxDashTelemetry);
		layoutDash.setCenter(tableBoxDashFleet);
		layoutDash.setStyle(
				"-fx-background-image: url('/7NvodtH-1080p-wallpaper-space.jpg');"
				+ "-fx-background-size: cover;"
				);

		
		VBox surfaceImage = new VBox(surfaceLanderIcon, surfaceLabel);
		surfaceImage.setAlignment(Pos.CENTER_LEFT);
		
		VBox orbiterImage = new VBox(planetaryOrbiterIcon, orbiterLabel);
		orbiterImage.setAlignment(Pos.CENTER_LEFT);
		
		VBox probeImage = new VBox(spaceProbeIcon, probeLabel);
		probeImage.setAlignment(Pos.CENTER_LEFT);
		
		VBox backBox = new VBox();
		backBox.setPadding(new Insets(5, 0, 10, 0));
		backBox.getChildren().add(backButton);
		
		VBox backBox2 = new VBox();
		backBox2.setPadding(new Insets(5, 0, 10, 0));
		backBox2.getChildren().add(backButton2);
		
		VBox backBox3 = new VBox();
		backBox3.setPadding(new Insets(5, 0, 10, 0));
		backBox3.getChildren().add(backButton3);
		
		VBox leftSurfaceBox = new VBox();
		leftSurfaceBox.getChildren().addAll(backBox, surfaceImage);
		leftSurfaceBox.setSpacing(200);
		
		VBox leftOrbiterBox = new VBox();
		leftOrbiterBox.getChildren().addAll(backBox2, orbiterImage);
		leftOrbiterBox.setSpacing(200);
		
		VBox leftProbeBox = new VBox();
		leftProbeBox.getChildren().addAll(backBox3, probeImage);
		leftProbeBox.setSpacing(200);
		
		layoutSurfaceLander = new BorderPane();
		layoutSurfaceLander.setLeft(leftSurfaceBox);
		surfaceImage.setPadding(new Insets(0, 0, 0, 20));
		layoutSurfaceLander.setCenter(tableBox);
		layoutSurfaceLander.setStyle(
				"-fx-background-image: url('/nathan-anderson-KvgB81s4dF0-unsplash.jpg');"
				+ "-fx-background-size: cover;"
				);
		
		layoutPlanetaryOrbiter = new BorderPane();
		layoutPlanetaryOrbiter.setLeft(leftOrbiterBox);
		orbiterImage.setPadding(new Insets(0, 0, 0, 20));
		layoutPlanetaryOrbiter.setCenter(tableBox2);
		layoutPlanetaryOrbiter.setStyle(
				"-fx-background-image: url('/nathan-anderson-KvgB81s4dF0-unsplash.jpg');"
				+ "-fx-background-size: cover;"
				);
		
		layoutSpaceProbe = new BorderPane();
		layoutSpaceProbe.setLeft(leftProbeBox);
		probeImage.setPadding(new Insets(0, 0, 0, 20));
		layoutSpaceProbe.setCenter(tableBox3);
		layoutSpaceProbe.setStyle(
				"-fx-background-image: url('/nathan-anderson-KvgB81s4dF0-unsplash.jpg');"
				+ "-fx-background-size: cover;"
				);
		
		layoutTelemetry = new BorderPane();
		layoutTelemetry.setCenter(tableBoxTelemetry);
		layoutTelemetry.setStyle(
				"-fx-background-image: url('/nathan-anderson-KvgB81s4dF0-unsplash.jpg');"
				+ "-fx-background-size: cover;"
				);
		
		layoutObjectives = new BorderPane();
		layoutObjectives.setCenter(tableBoxObjectives);
		layoutObjectives.setStyle(
				"-fx-background-image: url('/nathan-anderson-KvgB81s4dF0-unsplash.jpg');"
				+ "-fx-background-size: cover;"
				);
		
		layoutEventLog = new BorderPane();
		layoutEventLog.setCenter(tableBoxEventLog);
		layoutEventLog.setStyle(
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
		layoutTelemetry.setTop(createNavBar());		
		layoutObjectives.setTop(createNavBar());	
		layoutEventLog.setTop(createNavBar());
		layoutPlanetaryOrbiter.setTop(createNavBar());
		layoutSpaceProbe.setTop(createNavBar());
		
		//Button interaction
		
		button.setOnAction(e -> setView(layoutDash, 1200, 800));
		button2.setOnAction(e -> PopUpWindow.display( () -> setView(layoutStart, 600, 400)));
		surfaceLanderBtn.setOnAction(e -> setView(layoutSurfaceLander, 1200, 800));
		backButton.setOnAction(e -> setView(layoutFleet, 1200, 800));
		planetaryOrbiterBtn.setOnAction(e -> setView(layoutPlanetaryOrbiter, 1200, 800));
		backButton2.setOnAction(e -> setView(layoutFleet, 1200, 800));
		backButton3.setOnAction(e -> setView(layoutFleet, 1200, 800));
		spaceProbeBtn.setOnAction(e -> setView(layoutSpaceProbe, 1200, 800));
		
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
		
		planetaryOrbiterIcon.setFitWidth(imgWidth);
		planetaryOrbiterIcon.setFitHeight(imgHeight);
		
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
		
		spaceProbeIcon.setFitWidth(imgWidth);
		spaceProbeIcon.setFitHeight(imgHeight);
		
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
		
		backButton2.setGraphic(backButtonView2);
		backButton2.setGraphicTextGap(0);
		backButton2.setPadding(Insets.EMPTY);
		backButton2.setContentDisplay(ContentDisplay.TOP);
		backButton2.setAlignment(Pos.CENTER);
		backButton2.setTextAlignment(TextAlignment.CENTER);
		backButton2.setStyle("-fx-text-fill: white;" +
								  "-fx-font-size: 16px;" +
								  "-fx-background-color: transparent;" +
								  "-fx-border-color: transparent;" 
								 );
		
		backButton3.setGraphic(backButtonView3);
		backButton3.setGraphicTextGap(0);
		backButton3.setPadding(Insets.EMPTY);
		backButton3.setContentDisplay(ContentDisplay.TOP);
		backButton3.setAlignment(Pos.CENTER);
		backButton3.setTextAlignment(TextAlignment.CENTER);
		backButton3.setStyle("-fx-text-fill: white;" +
								  "-fx-font-size: 16px;" +
								  "-fx-background-color: transparent;" +
								  "-fx-border-color: transparent;" 
								 );
		
		backButtonView.setFitWidth(100);
		backButtonView.setFitHeight(50);
		
		backButtonView2.setFitWidth(100);
		backButtonView2.setFitHeight(50);
		
		backButtonView3.setFitWidth(100);
		backButtonView3.setFitHeight(50);
		
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
		telemetryButton.setOnAction(e -> setView(layoutTelemetry, 1200, 800));
		objectivesButton.setOnAction(e -> setView(layoutObjectives, 1200, 800));
		eventLogButton.setOnAction(e -> setView(layoutEventLog, 1200, 800));
		
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
