package astro.path.UI;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import astro.path.objects.Mission;
import astro.path.objects.MissionCoordinator;
import astro.path.objects.MissionStage;
import astro.path.objects.Spacecraft;
import astro.path.objects.Time;
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
import astro.path.objects.SCPart;
import astro.path.objects.Thruster;
import astro.path.objects.SolarPanel;
import astro.path.objects.Sensor;

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
		
		
		Spacecraft s1 = new Spacecraft("Apollo-N", "Surface Lander", "🟢"); 
		Spacecraft p1 = new Spacecraft("Bravo-B", "Planetary Orbiter", "🟡"); 
		Spacecraft d1 = new Spacecraft("Celeste-C", "Deep-Space Probe", "🔴"); 
		
		s1.id = "1";
		p1.id = "2";
		d1.id = "3";
		
		//Spacecraft Parts
		// Apollo-N
		Thruster s1Thruster = new Thruster(10, 500, 0, 100);   
		SolarPanel s1Panel = new SolarPanel(5, 100);
		s1Panel.setCurrentCapacity(70);                          
		Sensor s1Sensor = new Sensor(100, 10, 5, 2);
		s1Sensor.setCurrentCapacityUsed(40);                     
		s1.addSCPart(s1Thruster);
		s1.addSCPart(s1Panel);
		s1.addSCPart(s1Sensor);

		// Bravo-B
		Thruster p1Thruster = new Thruster(8, 400, 0, 100);
		p1Thruster.setCurrentCapacity(55);                       
		SolarPanel p1Panel = new SolarPanel(6, 100);
		p1Panel.setCurrentCapacity(85);                          
		p1.addSCPart(p1Thruster);
		p1.addSCPart(p1Panel);

		// Celeste-C
		Sensor d1Sensor = new Sensor(200, 15, 5, 3);
		d1Sensor.setCurrentCapacityUsed(120);                   
		Thruster d1Thruster = new Thruster(12, 600, 0, 100);
		d1Thruster.setCurrentCapacity(30);                       
		d1.addSCPart(d1Thruster);
		d1.addSCPart(d1Sensor);
		
		// Mission 1
		Mission m1 = new Mission();
		m1.setName("Moon Landing");
		m1.getSCList().add(s1);
		m1.MissionStageList.get(0).name = "Initialization";
		m1.MissionStageList.get(0).startTime.setTime(0);
		m1.MissionStageList.get(0).targetTime.setTime(3600);

		// Mission 2
		Mission m2 = new Mission();
		m2.setName("Orbital run v1.0");
		m2.getSCList().add(p1);
		m2.MissionStageList.get(0).name = "Approach";
		m2.MissionStageList.get(0).startTime.setTime(0);
		m2.MissionStageList.get(0).targetTime.setTime(7200);
		
		// Mission 3
		Mission m3 = new Mission();
		m2.setName("Deep Space Dive");
		m2.getSCList().add(d1);
		m2.MissionStageList.get(0).name = "Dive";
		m2.MissionStageList.get(0).startTime.setTime(0);
		m2.MissionStageList.get(0).targetTime.setTime(8712);

		MissionCoordinator coordinator = new MissionCoordinator(); 
		
		
		coordinator.addSpacecraft(s1); 
		coordinator.addSpacecraft(p1); 
		coordinator.addSpacecraft(d1); 
		coordinator.addMission(m1);
		coordinator.addMission(m2);
		coordinator.addMission(m3);
		
		ObservableList<Spacecraft> fleet = 
				FXCollections.observableArrayList(coordinator.getManagedFleet());
		
		//Average fleet telemetry
		
		double fuelSum = 0, powerSum = 0, dataSum = 0;
		int fuelCount = 0, powerCount = 0, dataCount = 0;

		for (Spacecraft sc : fleet) {
		    for (SCPart part : sc.getSCPartList()) {
		        if (part instanceof Thruster thruster) {
		            fuelSum += thruster.getCurrentCapacity();
		            fuelCount++;
		        }
		        if (part instanceof SolarPanel panel) {
		            powerSum += panel.getCurrentCapacity();
		            powerCount++;
		        }
		        if (part instanceof Sensor sensor) {
		            dataSum += sensor.getCurrentCapacityUsed();
		            dataCount++;
		        }
		    }
		}

		double startFuel  = (fuelCount  > 0) ? fuelSum  / fuelCount  : 0;
		double startPower = (powerCount > 0) ? powerSum / powerCount : 0;
		double startData  = (dataCount  > 0) ? dataSum  / dataCount  : 0;

		
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
		
		Label telemetryOverview = new Label("  Spacecraft Telemetry Average"); 
		telemetryOverview.setStyle("-fx-text-fill: white;" + "-fx-font-size: 14px;");
		
		Label warningLabel = new Label("Alerts "); 
		warningLabel.setStyle("-fx-font-size: 14px;" + "-fx-text-fill: white;" ); 
		
		// Gauges 
		
		
		Gauge fuelGauge = GaugeBuilder.create()
		        .title("Fuel")
		        .unit("%")
		        .minValue(0)
		        .maxValue(100)
		        .value(startFuel)
		        .build();
		fuelGauge.setBackgroundPaint(Color.WHITE);
		fuelGauge.setMaxSize(100, 100);

		Gauge tempGauge = GaugeBuilder.create()
		        .title("Solar Power")
		        .unit("%")
		        .minValue(0)
		        .maxValue(100)
		        .value(startPower)
		        .build();
		tempGauge.setBackgroundPaint(Color.WHITE);
		tempGauge.setMaxSize(100, 100);

		Gauge signalGauge = GaugeBuilder.create()
		        .title("Sensor Data")
		        .unit("%")
		        .minValue(0)
		        .maxValue(100)
		        .value(startData)
		        .build();
		signalGauge.setBackgroundPaint(Color.WHITE);
		signalGauge.setMaxSize(100, 100);
		
		
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
				.title("Solar Power") 
				.unit("%") 
				.minValue(-150) 
				.maxValue(150) 
				.value(0) 
				.build(); 
		
		tempTelemetryGauge.setBackgroundPaint(Color.WHITE); 
		tempTelemetryGauge.setMaxSize(100, 100); 
		
		Gauge signalTelemetryGauge = GaugeBuilder.create() 
				.title("Sensor Data") 
				.unit("%") 
				.minValue(0) 
				.maxValue(100) 
				.value(0) 
				.build(); 
		
		signalTelemetryGauge.setBackgroundPaint(Color.WHITE); 
		signalTelemetryGauge.setMaxSize(100, 100); 
		
		//Tables 
		
		TableView<Spacecraft> surfaceTable = new TableView(); 
		TableColumn <Spacecraft, String> surfaceId = new TableColumn<>("ID");
		TableColumn <Spacecraft, String> surfaceName = new TableColumn<>("Name"); 
		TableColumn <Spacecraft, String> surfaceStatus = new TableColumn<>("Status"); 
		
		
		
		surfaceId.setCellValueFactory( new PropertyValueFactory<>("id")); 
		surfaceName.setCellValueFactory( new PropertyValueFactory<>("name")); 
		surfaceStatus.setCellValueFactory( new PropertyValueFactory<>("status")); 
		surfaceTable.getColumns().addAll(surfaceId, surfaceName, surfaceStatus); 
		
		ObservableList<Spacecraft> surfaceData = FXCollections.observableArrayList();
		surfaceData.addAll(fleet.stream().filter(sc -> "Surface Lander".equals(sc.getType())).collect(Collectors.toList()));
		surfaceTable.setItems(surfaceData);
	  
		surfaceTable.setMaxWidth(400); 
		surfaceTable.setMaxHeight(300); 
		
		TableView<Spacecraft> orbiterTable = new TableView(); 
		TableColumn <Spacecraft, String> orbiterId = new TableColumn<>("ID"); 
		TableColumn <Spacecraft, String> orbiterName = new TableColumn<>("Name"); 
		TableColumn <Spacecraft, String> orbiterStatus = new TableColumn<>("Status"); 
		
		
		orbiterId.setCellValueFactory( new PropertyValueFactory<>("id")); 
		orbiterName.setCellValueFactory( new PropertyValueFactory<>("name"));
		orbiterStatus.setCellValueFactory( new PropertyValueFactory<>("status")); 
		
		orbiterTable.getColumns().addAll(orbiterId, orbiterName, orbiterStatus); 
		
		ObservableList<Spacecraft> orbiterData = FXCollections.observableArrayList(); 
		
		orbiterData.addAll(fleet.stream().filter(sc -> 
			"Planetary Orbiter".equals(sc.getType())).collect(Collectors.toList()));
		
		orbiterTable.setItems(orbiterData); 
		orbiterTable.setMaxWidth(400); 
		orbiterTable.setMaxHeight(300); 
		
		TableView<Spacecraft> probeTable = new TableView(); 
		TableColumn <Spacecraft, String> probeId = new TableColumn<>("ID"); 
		TableColumn <Spacecraft, String> probeName = new TableColumn<>("Name"); 
		TableColumn <Spacecraft, String> probeStatus = new TableColumn<>("Status"); 
		
		
		
		probeId.setCellValueFactory( new PropertyValueFactory<>("id")); 
		probeName.setCellValueFactory( new PropertyValueFactory<>("name")); 
		probeStatus.setCellValueFactory( new PropertyValueFactory<>("status")); 
		probeTable.getColumns().addAll(probeId, probeName, probeStatus); 
		
		ObservableList<Spacecraft> probeData = FXCollections.observableArrayList(); 
		
		
		probeData.addAll(fleet.stream().filter(sc -> 
			"Deep-Space Probe".equals(sc.getType())).collect(Collectors.toList()));
		
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
		TableColumn <Mission, String> missionNameCol = new TableColumn<>("name"); 
		TableColumn <Mission, String> stageCol = new TableColumn<>("Stage"); 
		TableColumn<Mission, String> spaceCraftCol = new TableColumn<>("SpaceCraft"); 
		TableColumn <Mission, String> startTimeCol = new TableColumn<>("Start"); 
		TableColumn <Mission, String> endTimeCol = new TableColumn<>("Est. End"); 
		
		missionNameCol.setCellValueFactory( new PropertyValueFactory<>("name")); 
		stageCol.setCellValueFactory(cell ->
	    new SimpleStringProperty(
	        cell.getValue()
	            .MissionStageList
	            .get(0)
	            .name
	    		)
			); 
		
		spaceCraftCol.setCellValueFactory( cell -> 
			new SimpleStringProperty( 
				cell.getValue().getSCList()
				.stream() 
				.map(sc -> sc.getName())
				.collect(Collectors.joining(", ")) 
				)); 
	
		startTimeCol.setCellValueFactory(cell ->
	    new SimpleStringProperty(
	        String.valueOf(
	            cell.getValue()
	                .MissionStageList
	                .get(0)
	                .startTime
	                .getTotalSeconds()
	        		)
	    		)
			);

		endTimeCol.setCellValueFactory(cell ->
	    	new SimpleStringProperty(	
	    		String.valueOf(
	    				cell.getValue()
	    				.MissionStageList
	    				.get(0)
	    				.targetTime
	    				.getTotalSeconds()
	    				)
	    			)
				);
		
		ObservableList<Mission> missionData =
			    FXCollections.observableArrayList(coordinator.getCurrentMissions());
			objectivesTable.setItems(missionData);

		objectivesTable.getColumns().addAll(missionNameCol, stageCol, spaceCraftCol, startTimeCol, endTimeCol);
		objectivesTable.setMaxWidth(800); 
		objectivesTable.setMaxHeight(600); 
		
		TableView<Spacecraft> telemetryTable = new TableView<>();
		telemetryTable.setPlaceholder(new Label("No Telemetry Data yet..."));
		TableColumn <Spacecraft, String> tName = new TableColumn<>("Name");
		TableColumn <Spacecraft, String> fuelCol = new TableColumn<>("Fuel");
		TableColumn <Spacecraft, String> tempCol = new TableColumn<>("Solar Power");
		TableColumn <Spacecraft, String> signalCol = new TableColumn<>("Sensor Data");

		tName.setCellValueFactory(new PropertyValueFactory<>("name"));

		fuelCol.setCellValueFactory(cell -> {
		    double v = 0;
		    for (SCPart part : cell.getValue().getSCPartList()) {
		        if (part instanceof Thruster t) v = t.getCurrentCapacity();
		    }
		    return new SimpleStringProperty(String.valueOf(v));
		});

		tempCol.setCellValueFactory(cell -> {
		    double v = 0;
		    for (SCPart part : cell.getValue().getSCPartList()) {
		        if (part instanceof SolarPanel p) v = p.getCurrentCapacity();
		    }
		    return new SimpleStringProperty(String.valueOf(v));
		});

		signalCol.setCellValueFactory(cell -> {
		    double v = 0;
		    for (SCPart part : cell.getValue().getSCPartList()) {
		        if (part instanceof Sensor s) v = s.getCurrentCapacityUsed();
		    }
		    return new SimpleStringProperty(String.valueOf(v));
		});

		telemetryTable.getColumns().addAll(tName, fuelCol, tempCol, signalCol);
		telemetryTable.setItems(fleet);
		telemetryTable.setMinWidth(300);
		telemetryTable.setMaxHeight(250);
		
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
	    .addListener((obs, oldCraft, newCraft) -> {
	        if (newCraft != null) {
	            double fuel = 0, power = 0, data = 0;
	            for (SCPart part : newCraft.getSCPartList()) {
	                if (part instanceof Thruster t)   fuel  = t.getCurrentCapacity();
	                if (part instanceof SolarPanel p) power = p.getCurrentCapacity();
	                if (part instanceof Sensor s)     data  = s.getCurrentCapacityUsed();
	            }
	            fuelTelemetryGauge.setValue(fuel);
	            tempTelemetryGauge.setValue(power);
	            signalTelemetryGauge.setValue(data);

	            telemetryTable.getSelectionModel().select(newCraft);
	            telemetryTable.scrollTo(newCraft);
	        }
	    });

		
		telemetrySpacecrafts.setMaxWidth(300); 
		telemetrySpacecrafts.setMaxHeight(200); 
		
		TableView<?> eventLogTable = new TableView(); 
		eventLogTable.setPlaceholder(new Label("No Events yet...")); 
		eventLogTable.setMaxWidth(800); 
		eventLogTable.setMaxHeight(800); 
		
		//Removing redundant empty right side column
		
		surfaceTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		orbiterTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		probeTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		dashFleetTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		objectivesTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		telemetryTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		telemetrySpacecrafts.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		//Warning Box 
		
		ObservableList<String> warnings = FXCollections.observableArrayList(); 
		
		
		for (Spacecraft sc : fleet) {
		    for (SCPart part : sc.getSCPartList()) {

		        if (part.getStatus() == SCPart.Status.WARNING ||
		            part.getStatus() == SCPart.Status.CRITICAL ||
		            part.getStatus() == SCPart.Status.OFFLINE) {

		            warnings.add(
		                sc.getName() + " - "
		                + part.getClass().getSimpleName()+ " : "
		                + part.getStatus()
		            );
		        }
		    }
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
		layoutDash.setRight(quitButton); 
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
		telemetryBox.setSpacing(60);
		telemetryBox.setPadding(new Insets(150));
		
		
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
		
		//Button adjustment 
		
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
		} 
	
	//Function to create Navigation Bar for each Scene 
	
	private HBox createNavBar() { 
		
		//Buttons 
		
		Button homeButton = new Button("AstroPath"); 
		Button fleetButton = new Button("Fleet"); 
		Button telemetryButton = new Button("Telemetry"); 
		Button objectivesButton = new Button("Missions"); 
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
