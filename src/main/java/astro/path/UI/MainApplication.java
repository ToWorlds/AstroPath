package astro.path.UI;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
//import astro.path.controller.TelemetryData;
import astro.path.objects.Mission;
import astro.path.objects.MissionCoordinator;
import astro.path.objects.MissionStage;
import astro.path.objects.Spacecraft;
import astro.path.objects.Time;
//import astro.path.objects.misc.DeepSpaceProbe;
//import astro.path.objects.misc.PlanetaryOrbiter;
//import astro.path.objects.misc.SurfaceLander;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import eu.hansolo.medusa.Gauge;
import eu.hansolo.medusa.GaugeBuilder;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;
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
	private SplitPane telTables;
	
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
		/*
		TelemetryData tel1 = new TelemetryData(80, 22, 95);
		TelemetryData tel2 = new TelemetryData(40, 20, 91);
		TelemetryData tel3 = new TelemetryData(15, 23, 97);
		
		/* ObservableList<TelemetryData> telemetry = FXCollections.observableArrayList();
		 *  telemetry.addAll(tel1, tel2, tel3); */ 
		/*
		SurfaceLander s1 = new SurfaceLander("Apollo-N", "2", "🟢", tel1, "mobSys", "landingGearStat"); 
		PlanetaryOrbiter p1 = new PlanetaryOrbiter("Bravo-B", "3", "🟡", tel2, "parameters", "payload"); 
		DeepSpaceProbe d1 = new DeepSpaceProbe("Celeste-C", "4", "🔴", tel3, "antenna", "protocol"); 
		*/
		//ObservableList<Spacecraft> fleet = FXCollections.observableArrayList(); 
		//fleet.addAll(s1, p1, d1);  
		
		MissionCoordinator coordinator = new MissionCoordinator(); 
		
		/*
		coordinator.addSpacecraft(s1); 
		coordinator.addSpacecraft(p1); 
		coordinator.addSpacecraft(d1); 
		*/
		ObservableList<Spacecraft> fleet = 
				FXCollections.observableArrayList(coordinator.getManagedFleet());
		/*
		ObservableList<TelemetryData> telemetry = 
				FXCollections.observableArrayList(); 
		
		for(Spacecraft sc : fleet) { 
			telemetry.add(sc.getTelemetry()); 
			} 
		*/
		//Stage 
		
		this.primaryStage = primaryStage; primaryStage.setTitle("AstroPath"); 
		
		//Labels
		
		Label labelStart = new Label("Hello fellow Traveler!"); 
		labelStart.setStyle("-fx-text-fill: black;"); 
		
		Label surfaceLabel = new Label("Surface Landers");
		surfaceLabel.setStyle("-fx-font-size: 16px;" + "-fx-text-fill: white;" ); 
		
		Label orbiterLabel = new Label("Planetary Orbiters"); 
		orbiterLabel.setStyle("-fx-font-size: 16px;" + "-fx-text-fill: white;" ); 
		
		Label probeLabel = new Label("Deep-Space Probes"); 
		probeLabel.setStyle("-fx-font-size: 16px;" + "-fx-text-fill: white;" ); 
		
		Label activeFleet = new Label(" Active Fleet"); 
		activeFleet.setStyle("-fx-text-fill: white;" + "-fx-font-size: 14px;"); 
		
		Label telemetryOverview = new Label(" Telemetry Overview"); 
		telemetryOverview.setStyle("-fx-text-fill: white;" + "-fx-font-size: 14px;");
		
		Label warningLabel = new Label("Alerts "); 
		warningLabel.setStyle("-fx-font-size: 14px;" + "-fx-text-fill: white;" ); 
		
		// Gauges 
		
		/*
		Gauge fuelGauge = GaugeBuilder.create() 
				.title("fuel") 
				.unit("%") 
				.minValue(0) 
				.maxValue(100) 
				.value(tel1.getFuelLevel()) 
				.build(); 
		*/
		
		/*
		fuelGauge.setValue(tel1.getFuelLevel()); 
		fuelGauge.setBackgroundPaint(Color.WHITE); 
		fuelGauge.setMaxSize(100, 100); 
		*/
		
		/*
		Gauge tempGauge = GaugeBuilder.create() 
				.title("temp") 
				.unit("°C") 
				.minValue(-150) 
				.maxValue(150) 
				.value(tel1.getTemperature()) 
				.build(); 
		*/
		
		/*
		tempGauge.setValue(tel1.getTemperature()); 
		tempGauge.setBackgroundPaint(Color.WHITE); 
		tempGauge.setMaxSize(100, 100); 
		*/
		
		/*
		Gauge signalGauge = GaugeBuilder.create() 
				.title("signal") 
				.unit("%") 
				.minValue(0) 
				.maxValue(100) 
				.value(tel1.getSignalStrength()) 
				.build();
		*/
		
		/*
		signalGauge.setValue(tel1.getSignalStrength()); 
		signalGauge.setBackgroundPaint(Color.WHITE); 
		signalGauge.setMaxSize(100, 100); 
		*/
		
		Gauge fuelTelemetryGauge = GaugeBuilder.create() 
				.title("Fuel") 
				.unit("%") 
				.minValue(0) 
				.maxValue(100) 
				.value(0) 
				.build(); 
		
		fuelTelemetryGauge.setBackgroundPaint(Color.WHITE); 
		fuelTelemetryGauge.setMaxSize(100, 100); 
		
		Gauge tempTelemetryGauge = GaugeBuilder.create() 
				.title("Temperature") 
				.unit("°C") 
				.minValue(-150) 
				.maxValue(150) 
				.value(0) 
				.build(); 
		
		tempTelemetryGauge.setBackgroundPaint(Color.WHITE); 
		tempTelemetryGauge.setMaxSize(100, 100); 
		
		Gauge signalTelemetryGauge = GaugeBuilder.create() 
				.title("Signal") 
				.unit("%") 
				.minValue(0) 
				.maxValue(100) 
				.value(0) 
				.build(); 
		
		signalTelemetryGauge.setBackgroundPaint(Color.WHITE); 
		signalTelemetryGauge.setMaxSize(100, 100); 
		
		//Tables 
		
		/*
		TableView<SurfaceLander> surfaceTable = new TableView(); 
		TableColumn <SurfaceLander, String> surfaceId = new TableColumn<>("ID");
		TableColumn <SurfaceLander, String> surfaceName = new TableColumn<>("Name"); 
		TableColumn <SurfaceLander, String> surfaceStatus = new TableColumn<>("Status"); 
		*/
		
		/*
		surfaceId.setCellValueFactory( new PropertyValueFactory<>("id")); 
		surfaceName.setCellValueFactory( new PropertyValueFactory<>("name")); 
		surfaceStatus.setCellValueFactory( new PropertyValueFactory<>("status")); 
		surfaceTable.getColumns().addAll(surfaceId, surfaceName, surfaceStatus); 
		*/
		
		/*
		ObservableList<SurfaceLander> surfaceData = FXCollections.observableArrayList(); 
		/* surfaceData.add(s1); */ 
		/*
		surfaceData.addAll(fleet.stream().filter(sc -> sc instanceof SurfaceLander) 
				.map(sc -> (SurfaceLander) sc).toList() ); 
		
		surfaceTable.setItems(surfaceData); 
		surfaceTable.setMaxWidth(400); 
		surfaceTable.setMaxHeight(300); 
		
		TableView<PlanetaryOrbiter> orbiterTable = new TableView(); 
		TableColumn <PlanetaryOrbiter, String> orbiterId = new TableColumn<>("ID"); 
		TableColumn <PlanetaryOrbiter, String> orbiterName = new TableColumn<>("Name"); 
		TableColumn <PlanetaryOrbiter, String> orbiterStatus = new TableColumn<>("Status"); 
		orbiterId.setCellValueFactory( new PropertyValueFactory<>("id")); 
		orbiterName.setCellValueFactory( new PropertyValueFactory<>("name"));
		orbiterStatus.setCellValueFactory( new PropertyValueFactory<>("status")); 
		
		orbiterTable.getColumns().addAll(orbiterId, orbiterName, orbiterStatus); 
		
		ObservableList<PlanetaryOrbiter> orbiterData = FXCollections.observableArrayList(); 
		/* orbiterData.add(p1); */ 
		/*
		orbiterData.addAll(fleet.stream().filter(sc -> sc instanceof PlanetaryOrbiter) 
				.map(sc -> (PlanetaryOrbiter) sc).toList() ); 
		
		orbiterTable.setItems(orbiterData); 
		orbiterTable.setMaxWidth(400); 
		orbiterTable.setMaxHeight(300); 
		
		TableView<DeepSpaceProbe> probeTable = new TableView(); 
		TableColumn <DeepSpaceProbe, String> probeId = new TableColumn<>("ID"); 
		TableColumn <DeepSpaceProbe, String> probeName = new TableColumn<>("Name"); 
		TableColumn <DeepSpaceProbe, String> probeStatus = new TableColumn<>("Status"); 
		
		probeId.setCellValueFactory( new PropertyValueFactory<>("id")); 
		probeName.setCellValueFactory( new PropertyValueFactory<>("name")); 
		probeStatus.setCellValueFactory( new PropertyValueFactory<>("status")); 
		probeTable.getColumns().addAll(probeId, probeName, probeStatus); 
		
		ObservableList<DeepSpaceProbe> probeData = FXCollections.observableArrayList(); 
		/* probeData.add(d1); */ 
		/*
		probeData.addAll(fleet.stream().filter(sc -> sc instanceof DeepSpaceProbe) 
				.map(sc -> (DeepSpaceProbe) sc).toList() ); 
		
		probeTable.setItems(probeData); 
		probeTable.setMaxWidth(400); 
		probeTable.setMaxHeight(300); 
		
		TableView<Spacecraft> dashFleetTable = new TableView(); 
		TableColumn <Spacecraft, String> activeId = new TableColumn<>("ID"); 
		TableColumn <Spacecraft, String> activeName = new TableColumn<>("Name"); 
		TableColumn <Spacecraft, String> activeStatus = new TableColumn<>("Status"); 
		
		activeId.setCellValueFactory( new PropertyValueFactory<>("id")); 
		activeName.setCellValueFactory( new PropertyValueFactory<>("name")); 
		activeStatus.setCellValueFactory( new PropertyValueFactory<>("status")); 
		
		dashFleetTable.getColumns().addAll(activeId, activeName, activeStatus); 
		
		dashFleetTable.setItems(fleet); 
		dashFleetTable.setMaxWidth(200); 
		dashFleetTable.setMaxHeight(200); 
		
		TableView<Mission> objectivesTable = new TableView(); 
		TableColumn <Mission, String> missionNameCol = new TableColumn<>("Mission"); 
		TableColumn <Mission, MissionStage> stageCol = new TableColumn<>("Stage"); 
		TableColumn <Mission, String> objectiveCol = new TableColumn<>("Objective"); 
		TableColumn<Mission, String> spaceCraftCol = new TableColumn<>("SpaceCraft"); 
		TableColumn <Mission, Time> startTimeCol = new TableColumn<>("Start"); 
		TableColumn <Mission, Time> endTimeCol = new TableColumn<>("Est. End"); 
		TableColumn <Mission, Integer> progressCol = new TableColumn<>("Progress"); 
		
		missionNameCol.setCellValueFactory( new PropertyValueFactory<>("mission")); 
		stageCol.setCellValueFactory( new PropertyValueFactory<>("stage")); 
		objectiveCol.setCellValueFactory( new PropertyValueFactory<>("objective")); 
		
	spaceCraftCol.setCellValueFactory( cell -> 
			new SimpleStringProperty( 
				cell.getValue().getSCList()
				.stream() 
				.map(sc -> sc.getName())
				.collect(Collectors.joining(", ")) 
				)); 
		
		startTimeCol.setCellValueFactory( new PropertyValueFactory<>("startTimestamp")); 
		endTimeCol.setCellValueFactory( new PropertyValueFactory<>("targetTimestamp")); 
		progressCol.setCellValueFactory( new PropertyValueFactory<>("progressStatus")); 
		
		objectivesTable.getColumns().addAll(missionNameCol, stageCol, objectiveCol,spaceCraftCol, startTimeCol, endTimeCol, progressCol);
		objectivesTable.setMaxWidth(800); 
		objectivesTable.setMaxHeight(600); 
		
		TableView<TelemetryData> telemetryTable = new TableView(); 
		//telemetryTable.setPlaceholder(new Label("No Telemetry Data yet...")); 
		TableColumn <TelemetryData, Double> fuelCol = new TableColumn<>("Fuel Level");
		TableColumn <TelemetryData, Double> tempCol = new TableColumn<>("Temperature in °C"); 
		TableColumn <TelemetryData, Double> signalCol = new TableColumn<>("Signal Strength"); 
		
		fuelCol.setCellValueFactory( new PropertyValueFactory<>("fuelLevel")); 
		tempCol.setCellValueFactory( new PropertyValueFactory<>("temperature")); 
		signalCol.setCellValueFactory( new PropertyValueFactory<>("signalStrength")); 
		
		telemetryTable.getColumns().addAll(fuelCol, tempCol, signalCol); 
		telemetryTable.setItems(telemetry); 
		telemetryTable.setMinWidth(500); 
		telemetryTable.setMinHeight(400); 
		
		TableView<Spacecraft> telemetrySpacecrafts = new TableView(); 
		TableColumn <Spacecraft, String> idCol = new TableColumn<>("ID"); 
		TableColumn <Spacecraft, String> nameCol = new TableColumn<>("Name"); 
		TableColumn <Spacecraft, String> statusCol = new TableColumn<>("Status"); 
		
		idCol.setCellValueFactory( new PropertyValueFactory<>("id")); 
		nameCol.setCellValueFactory( new PropertyValueFactory<>("name")); 
		statusCol.setCellValueFactory( new PropertyValueFactory<>("status")); 
		
		telemetrySpacecrafts.getColumns().addAll(idCol, nameCol, statusCol); 
		telemetrySpacecrafts.setItems(fleet); 
		telemetrySpacecrafts.getSelectionModel() 
			.selectedItemProperty() 
			.addListener((obs, oldCraft, newCraft) -> { if(newCraft != null) { 
				TelemetryData t = newCraft.getTelemetry(); 
				
				fuelTelemetryGauge.setValue(t.getFuelLevel()); 
				tempTelemetryGauge.setValue(t.getTemperature()); 
				signalTelemetryGauge.setValue(t.getSignalStrength()); 
				} }); 
		
		telemetrySpacecrafts.setMaxWidth(300); 
		telemetrySpacecrafts.setMaxHeight(200); 
		
		TableView<?> eventLogTable = new TableView(); 
		eventLogTable.setPlaceholder(new Label("No Events yet...")); 
		eventLogTable.setMaxWidth(800); 
		eventLogTable.setMaxHeight(800); 
		
		// Textfields 
		
		/* TextField landerNameField = new TextField(); 
		 * TextField landerIdField = new TextField(); 
		 * TextField landerStatusField = new TextField(); 
		 * TextField landerTelemetryField = new TextField(); */
		/*
		ComboBox<Spacecraft> spaceCraftSelection = new ComboBox(fleet); 
		TextField missionNameField = new TextField(); 
		TextField missionObjectiveField = new TextField(); 
		// TextField missionStartField = new TextField(); 
		// TextField missionEndField = new TextField(); 
		// Time startTime = Time.parse(missionStartField.getText()); 
		// Time endTime = Time.parse(); 
		
		//Warning Box 
		
		ObservableList<String> warnings = FXCollections.observableArrayList(); 
		
		for(Spacecraft sc : fleet){
			String diagnostic = sc.performSelfDiagnostic(); 
		
			if(diagnostic.contains("Warning")) { 
				warnings.add(diagnostic); } 
		} 
		
		if(warnings.isEmpty()) { 
			warnings.add("No Warnings or Alerts."); 
			} 
		
		ListView <String> warningList = new ListView<>(); 
		warningList.setItems(warnings); 
		warningList.setMaxSize(250, 150); 
		
		//Layouts(Boxes) 
		
		VBox layoutStart = new VBox(20); 
		layoutStart.getChildren().addAll(labelStart ,button); 
		layoutStart.setAlignment(Pos.CENTER); 
		layoutStart.setStyle( "-fx-background-image: url('/shutterstock_1847866900-1-600x400.jpg');" 
				+ "-fx-background-size: cover;" ); 
		
		HBox dashGauge = new HBox(fuelGauge, tempGauge, signalGauge); 
		dashGauge.setAlignment(Pos.BOTTOM_LEFT); 
		dashGauge.setPadding(new Insets(20)); 
		dashGauge.setSpacing(20); 
		dashGauge.setStyle("-fx-background-color: rgba(50, 50, 50, 0.4);" 
				+ "-fx-background-radius: 12;"); 
		
		VBox telGauge = new VBox(fuelTelemetryGauge, tempTelemetryGauge, signalTelemetryGauge); 
		telGauge.setSpacing(20); 
		telGauge.setAlignment(Pos.CENTER); 
		
		VBox warningBox = new VBox(); 
		warningBox.getChildren().addAll(warningLabel, warningList); 
		warningBox.setPadding(new Insets(15)); 
		warningBox.setAlignment(Pos.BOTTOM_RIGHT); 
		
		HBox quitButton = new HBox(button2); 
		quitButton.setAlignment(Pos.TOP_RIGHT); 
		
		VBox tableBox = new VBox(surfaceTable); 
		tableBox.setAlignment(Pos.CENTER); 
		
		VBox tableBox2 = new VBox(orbiterTable); 
		tableBox2.setAlignment(Pos.CENTER); 
		
		VBox tableBox3 = new VBox(probeTable); 
		tableBox3.setAlignment(Pos.CENTER); 
		
		VBox tableBoxObjectives = new VBox(objectivesTable); 
		tableBoxObjectives.setAlignment(Pos.CENTER); 
		
		VBox tableBoxTelemetry = new VBox(telemetryTable); 
		tableBoxTelemetry.setAlignment(Pos.CENTER_RIGHT); 
		
		VBox tableBoxTelemetrySc = new VBox(telemetrySpacecrafts); 
		tableBoxTelemetrySc.setAlignment(Pos.CENTER_LEFT); 
		
		VBox tableBoxEventLog = new VBox(eventLogTable); 
		tableBoxEventLog.setAlignment(Pos.CENTER); 
		
		HBox spacecraftBtns = new HBox(30); 
		spacecraftBtns.getChildren().addAll(surfaceLanderBtn,planetaryOrbiterBtn, spaceProbeBtn); 
		spacecraftBtns.setAlignment(Pos.CENTER); 
		
		VBox activeFleetBox = new VBox(activeFleet, dashFleetTable); 
		activeFleetBox.setAlignment(Pos.CENTER_LEFT); 
		activeFleetBox.setPadding(new Insets(20)); 
		
		VBox telOverview = new VBox(telemetryOverview, dashGauge); 
		telOverview.setAlignment(Pos.BOTTOM_LEFT); 
		
		layoutFleet = new BorderPane(); 
		layoutFleet.setCenter(spacecraftBtns); 
		layoutFleet.setStyle( "-fx-background-image: url('/nathan-anderson-KvgB81s4dF0-unsplash.jpg');" 
				+ "-fx-background-size: cover;" ); 
		
		layoutDash = new BorderPane(); 
		//layoutDash.setRight(quitButton); 
		layoutDash.setRight(warningBox); 
		layoutDash.setBottom(telOverview); 
		layoutDash.setCenter(activeFleetBox); 
		layoutDash.setStyle( "-fx-background-image: url('/7NvodtH-1080p-wallpaper-space.jpg');" 
				+ "-fx-background-size: cover;" ); 
		
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
		
		HBox telemetryBox = new HBox(tableBoxTelemetrySc, tableBoxTelemetry, telGauge); 
		telemetryBox.setSpacing(40); 
		
		layoutSurfaceLander = new BorderPane(); 
		layoutSurfaceLander.setLeft(leftSurfaceBox); 
		surfaceImage.setPadding(new Insets(0, 0, 0, 20)); 
		layoutSurfaceLander.setCenter(tableBox); 
		layoutSurfaceLander.setStyle( "-fx-background-image: url('/nathan-anderson-KvgB81s4dF0-unsplash.jpg');" 
				+ "-fx-background-size: cover;" ); 
		
		layoutPlanetaryOrbiter = new BorderPane(); 
		layoutPlanetaryOrbiter.setLeft(leftOrbiterBox); 
		orbiterImage.setPadding(new Insets(0, 0, 0, 20)); 
		layoutPlanetaryOrbiter.setCenter(tableBox2); 
		layoutPlanetaryOrbiter.setStyle( "-fx-background-image: url('/nathan-anderson-KvgB81s4dF0-unsplash.jpg');" 
				+ "-fx-background-size: cover;" ); 
		
		layoutSpaceProbe = new BorderPane(); 
		layoutSpaceProbe.setLeft(leftProbeBox); 
		probeImage.setPadding(new Insets(0, 0, 0, 20)); 
		layoutSpaceProbe.setCenter(tableBox3); 
		layoutSpaceProbe.setStyle( "-fx-background-image: url('/nathan-anderson-KvgB81s4dF0-unsplash.jpg');" 
				+ "-fx-background-size: cover;" ); 
		
		layoutTelemetry = new BorderPane(); 
		layoutTelemetry.setCenter(telemetryBox); 
		layoutTelemetry.setStyle( "-fx-background-image: url('/nathan-anderson-KvgB81s4dF0-unsplash.jpg');" 
				+ "-fx-background-size: cover;" );
		
		layoutObjectives = new BorderPane(); 
		layoutObjectives.setCenter(tableBoxObjectives); 
		layoutObjectives.setStyle( "-fx-background-image: url('/nathan-anderson-KvgB81s4dF0-unsplash.jpg');" 
				+ "-fx-background-size: cover;" ); 
		
		layoutEventLog = new BorderPane(); 
		layoutEventLog.setCenter(tableBoxEventLog); 
		layoutEventLog.setStyle( "-fx-background-image: url('/nathan-anderson-KvgB81s4dF0-unsplash.jpg');" 
				+ "-fx-background-size: cover;" ); 
		
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
		//button2.setOnAction(e -> PopUpWindow.display( () -> setView(layoutStart, 600, 400); 
		surfaceLanderBtn.setOnAction(e -> setView(layoutSurfaceLander, 1200, 800)); 
		backButton.setOnAction(e -> setView(layoutFleet, 1200, 800)); 
		planetaryOrbiterBtn.setOnAction(e -> setView(layoutPlanetaryOrbiter, 1200, 800)); 
		backButton2.setOnAction(e -> setView(layoutFleet, 1200, 800)); 
		backButton3.setOnAction(e -> setView(layoutFleet, 1200, 800)); 
		spaceProbeBtn.setOnAction(e -> setView(layoutSpaceProbe, 1200, 800)); 
		
		/*addMission.setOnAction(e -> { Mission m = new Mission( missionNameField.getText(), 
		 * missionObjectiveField.getText(), 0, List.of(spaceCraftSelection.getValue()) ); 
		 * MissionStage mStage = new MissionStage(m); }); 
		 * landerButton.setOnAction(e -> { String name = landerNameField.getText(); 
		 * String id = landerIdField.getText(); 
		 * String status = landerStatusField.getText(); 
		 * String telemetryData = landerTelemetryField.getText(); 
		 * SurfaceLander s = new SurfaceLander(name, id, status, TelemetryData, String, String); 
		 * surfaceData.add(s); 
		 * landerNameField.clear(); 
		 * landerIdField.clear(); 
		 * landerStatusField.clear(); });*/
		
		//Button adjustment 
		
		/*
		surfaceLanderBtn.setGraphic(surfaceLanderView); 
		surfaceLanderBtn.setContentDisplay(ContentDisplay.TOP); 
		surfaceLanderBtn.setAlignment(Pos.CENTER); 
		surfaceLanderBtn.setTextAlignment(TextAlignment.RIGHT); 
		surfaceLanderBtn.setStyle("-fx-text-fill: white;" 
				+ "-fx-font-size: 16px;" + "-fx-background-color: transparent;" 
				+ "-fx-border-color: lightblue;" ); 
		double imgWidth = surfaceLanderView.getImage().getWidth(); 
		double imgHeight = surfaceLanderView.getImage().getHeight(); 
		
		planetaryOrbiterBtn.setGraphic(planetaryOrbiterView); 
		planetaryOrbiterBtn.setContentDisplay(ContentDisplay.TOP); 
		planetaryOrbiterBtn.setAlignment(Pos.CENTER); 
		planetaryOrbiterBtn.setTextAlignment(TextAlignment.CENTER); 
		planetaryOrbiterBtn.setStyle("-fx-text-fill: white;" 
				+ "-fx-font-size: 16px;" + "-fx-background-color: transparent;" 
				+ "-fx-border-color: lightblue;" ); 
		planetaryOrbiterView.setFitWidth(imgWidth); 
		planetaryOrbiterView.setFitHeight(imgHeight); 
		planetaryOrbiterIcon.setFitWidth(imgWidth); 
		planetaryOrbiterIcon.setFitHeight(imgHeight); 
		
		spaceProbeBtn.setGraphic(spaceProbeView); 
		spaceProbeBtn.setContentDisplay(ContentDisplay.TOP); 
		spaceProbeBtn.setAlignment(Pos.CENTER); 
		spaceProbeBtn.setTextAlignment(TextAlignment.CENTER); 
		spaceProbeBtn.setStyle("-fx-text-fill: white;" 
				+ "-fx-font-size: 16px;" + "-fx-background-color: transparent;" 
				+ "-fx-border-color: lightblue;" ); 
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
		backButton.setStyle("-fx-text-fill: white;" 
				+ "-fx-font-size: 16px;" + "-fx-background-color: transparent;" 
				+ "-fx-border-color: transparent;" ); 
		
		backButton2.setGraphic(backButtonView2); 
		backButton2.setGraphicTextGap(0); 
		backButton2.setPadding(Insets.EMPTY); 
		backButton2.setContentDisplay(ContentDisplay.TOP); 
		backButton2.setAlignment(Pos.CENTER); 
		backButton2.setTextAlignment(TextAlignment.CENTER); 
		backButton2.setStyle("-fx-text-fill: white;" 
				+ "-fx-font-size: 16px;" + "-fx-background-color: transparent;" 
				+ "-fx-border-color: transparent;" ); 
		
		backButton3.setGraphic(backButtonView3); 
		backButton3.setGraphicTextGap(0); 
		backButton3.setPadding(Insets.EMPTY); 
		backButton3.setContentDisplay(ContentDisplay.TOP); 
		backButton3.setAlignment(Pos.CENTER); 
		backButton3.setTextAlignment(TextAlignment.CENTER); 
		backButton3.setStyle("-fx-text-fill: white;" 
				+ "-fx-font-size: 16px;" + "-fx-background-color: transparent;" 
				+ "-fx-border-color: transparent;" ); 
		
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
		*/
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
		homeButton.setStyle("-fx-font-size: 25px;" + "-fx-text-fill: black;" 
				+ "-fx-background-color: rgba(58, 110, 165, 0.6);" ); 
		
		fleetButton.setPrefSize(150, 50); 
		fleetButton.setStyle("-fx-font-size: 16px;" + "-fx-text-fill: black;" 
				+ "-fx-background-color: rgba(58, 110, 165, 0.6);" ); 
		
		telemetryButton.setPrefSize(150, 50); 
		telemetryButton.setStyle("-fx-font-size: 16px;" + "-fx-text-fill: black;" 
				+ "-fx-background-color: rgba(58, 110, 165, 0.6);" ); 
		
		objectivesButton.setPrefSize(150, 50); 
		objectivesButton.setStyle("-fx-font-size: 16px;" + "-fx-text-fill: black;" 
				+ "-fx-background-color: rgba(58, 110, 165, 0.6);" ); 
		
		eventLogButton.setPrefSize(150, 50); 
		eventLogButton.setStyle("-fx-font-size: 16px;" + "-fx-text-fill: black;" 
				+ "-fx-background-color: rgba(58, 110, 165, 0.6);" ); 
		
		Label navTime = new Label(); 
		navTime.setStyle("-fx-text-fill: white;"); 
		
		// Date and Time 
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
		Timeline clock = new Timeline( 
				new KeyFrame(Duration.ZERO, e -> {
					navTime.setText( LocalDateTime.now().format(formatter)); 
					}), 
				new KeyFrame(Duration.seconds(1)) ); 
		
		clock.setCycleCount(Animation.INDEFINITE); 
		clock.play(); 
		
		//Events 
		
		homeButton.setOnAction(e -> setView(layoutDash, 1200, 800)); 
		fleetButton.setOnAction(e -> setView(layoutFleet, 1200, 800)); 
		telemetryButton.setOnAction(e -> setView(layoutTelemetry, 1200, 800)); 
		objectivesButton.setOnAction(e -> setView(layoutObjectives, 1200, 800)); 
		eventLogButton.setOnAction(e -> setView(layoutEventLog, 1200, 800)); 
		
		HBox navBar = new HBox(10); 
		Region spacer = new Region(); 
		HBox.setHgrow(spacer, Priority.ALWAYS); 
		navBar.getChildren().addAll(homeButton, fleetButton, telemetryButton, objectivesButton, eventLogButton, spacer, navTime); 
		navBar.setAlignment(Pos.TOP_LEFT); return navBar; 
		
	} 
	private void setView(Region view, double w, double h) { 
		root.setCenter(view); 
		primaryStage.setWidth(w); 
		primaryStage.setHeight(h); 
		} 

}
