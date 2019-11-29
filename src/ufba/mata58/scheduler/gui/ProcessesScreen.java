package ufba.mata58.scheduler.gui;

import java.util.ArrayList;
import java.util.Collection;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ufba.mata58.scheduler.main.Simulation;
import ufba.mata58.scheduler.processes.Process;

public class ProcessesScreen implements ISceneCreation {
	
	private BorderPane borderPane;
	private ScrollPane processList;
	private HBox processPane;
	private ProcessCreator processCreator = new ProcessCreator();
	private Rectangle buttonBG = new Rectangle(100.0, 30.0);
	
	@Override
	public Scene createScene() {
		borderPane = new BorderPane();		
		borderPane.setPadding(new Insets(0, 5, 5, 5));

		borderPane.setTop(createToolBar());	
		borderPane.setCenter(processCreator);
		borderPane.setBottom(createProcessManager());
			
		return new Scene(borderPane);
	}

	private GridPane createToolBar() {
		GridPane toolBar = new GridPane();
		toolBar.setVgap(10);
		toolBar.setHgap(10);
		toolBar.setPadding(new Insets(10));
		
		HBox toolBarButtons = new HBox();
		toolBarButtons.setPadding(new Insets(2));
		toolBarButtons.setSpacing(10);
		toolBarButtons.setAlignment(Pos.CENTER_RIGHT);
		
		Button processesButton = new Button("Processos");
		Button simulationButton = new Button("Simulação");
		Button settingsButton = new Button("Configurações");
		
		processesButton.setMaxWidth(Double.MAX_VALUE);
		simulationButton.setMaxWidth(Double.MAX_VALUE);
		settingsButton.setMaxWidth(Double.MAX_VALUE);
		
		simulationButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Stage simulationWindow = new Stage();
				simulationWindow.setTitle("Simulação");
				
				Gantt gantt = new Gantt();
				Scene root = new Scene(gantt);
				simulationWindow.setScene(root);
				
				simulationWindow.show();
			}
		});
		
		settingsButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Stage settingsWindow = new Stage();
				settingsWindow.setTitle("Configurações");
				settingsWindow.setResizable(false);
				settingsWindow.show();
			}
			
		});
		
		toolBarButtons.getChildren().addAll(processesButton, simulationButton, settingsButton);

		toolBar.add(toolBarButtons, 0, 0);
		
		Text schedulingAlgorithms = new Text("Escalonamento:");
		Text pagingAlgorithms = new Text("Substituição:");
		schedulingAlgorithms.setFont(Font.loadFont("file:resources/fonts/Inconsolata-Bold.ttf", 16));
		pagingAlgorithms.setFont(Font.loadFont("file:resources/fonts/Inconsolata-Bold.ttf", 16));
		
		toolBar.add(schedulingAlgorithms, 0, 1);
		toolBar.add(pagingAlgorithms, 0, 3);
		
		HBox schedulingAlgorithmSelector = createSchedulingAlgorithmSelectorButtons();	
		HBox pagingAlgorithmSelector = createPagingAlgorithmSelectorButtons();
		
		toolBar.add(schedulingAlgorithmSelector, 0, 2);
		toolBar.add(pagingAlgorithmSelector, 0, 4);
		
		return toolBar;
	}

	private HBox createPagingAlgorithmSelectorButtons() {
		ToggleGroup pagingAlgorithmButtons = new ToggleGroup();
		HBox pagingAlgorithmSelector = new HBox();
		pagingAlgorithmSelector.setPadding(new Insets(10));
		pagingAlgorithmSelector.setSpacing(10);
		
		RadioButton fifo = new RadioButton("FIFO");
		fifo.setToggleGroup(pagingAlgorithmButtons);
		fifo.setSelected(true);
		
		RadioButton lru = new RadioButton("MRU");
		lru.setToggleGroup(pagingAlgorithmButtons);
		
		pagingAlgorithmSelector.getChildren().addAll(fifo, lru);
		return pagingAlgorithmSelector;
	}

	private HBox createSchedulingAlgorithmSelectorButtons() {
		ToggleGroup schedulingAlgorithmButtons = new ToggleGroup();
		HBox schedulingAlgorithmSelector = new HBox();
		schedulingAlgorithmSelector.setPadding(new Insets(10));
		schedulingAlgorithmSelector.setSpacing(10);
		
		RadioButton fcfs = new RadioButton("FCFS");
		fcfs.setToggleGroup(schedulingAlgorithmButtons);
		fcfs.setSelected(true);
		
		RadioButton sjf = new RadioButton("SJF");
		sjf.setToggleGroup(schedulingAlgorithmButtons);
		
		RadioButton roundRobin = new RadioButton("Round-robin");
		roundRobin.setToggleGroup(schedulingAlgorithmButtons);
		
		RadioButton edf = new RadioButton("EDF");
		edf.setToggleGroup(schedulingAlgorithmButtons);
		
		schedulingAlgorithmSelector.getChildren().addAll(fcfs, sjf, roundRobin, edf);
		return schedulingAlgorithmSelector;
	}
	
	private StackPane createProcessButton() {
		StackPane createButton = new StackPane();
		
		buttonBG.setFill(Color.web("#2fd464"));
		buttonBG.setArcHeight(15);
		buttonBG.setArcWidth(15);
		
		Text createText = new Text("Criar");
		createText.setFill(Color.WHITE);
		createText.setFont(Font.loadFont("file:resources/fonts/Inconsolata-Bold.ttf", 20));
		createButton.getChildren().addAll(buttonBG, createText);
		
		ArrayList<Shape> nodes = new ArrayList<Shape>();
		nodes.add(buttonBG);
		nodes.add(createText);
		
		addHandlers(nodes);
		
		return createButton;
	}
	
	private void addHandlers(Collection<Shape> nodes) {
		for(Node node : nodes) {
			node.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					java.util.Random r = new java.util.Random();
					int a1 = r.nextInt(13);
					int a2 = r.nextInt(13);
					int a3 = r.nextInt(13);
					int a4 = r.nextInt(13);
					int a5 = r.nextInt(13);
					Process newProcess = new Process(a1,a2,a3,a4,a5);
					ProcessModel newPM = new ProcessModel(a1,a2,a3,a4,a5);
					processPane.getChildren().add(newPM);
					Simulation.addProcess(newProcess);
					processList.setHvalue(1);
				}
			});
			
			node.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					buttonBG.setFill(Color.web("#0d8433"));
				}
			});
			
			node.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					buttonBG.setFill(Color.web("#2fd464"));
				}
			});
		}
	}
	
	private VBox createProcessManager() {
		VBox vbox = new VBox();
		vbox.setSpacing(10);
		vbox.setPadding(new Insets(5));
		vbox.setAlignment(Pos.CENTER);
		
		processList = new ScrollPane();
		processList.setHbarPolicy(ScrollBarPolicy.ALWAYS);
		processList.setBackground(new Background(new BackgroundFill(Color.web("#DADBDA"), null, null)));
		processList.setMaxWidth(280);
		processList.setStyle("-fx-border-radius: 3");
		
		processPane = new HBox();
		processPane.setPadding(new Insets(10));
		processPane.setSpacing(10);
		
		processList.setContent(processPane);
		
		StackPane createProcess = createProcessButton();
		vbox.getChildren().addAll(createProcess, processList);
		
		return vbox;
	}
}