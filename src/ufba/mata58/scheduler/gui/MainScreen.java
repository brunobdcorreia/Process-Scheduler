package ufba.mata58.scheduler.gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MainScreen implements ISceneCreation {
	
	@Override
	public Scene createScene() {
		BorderPane borderPane = new BorderPane();
		
		borderPane.setPadding(new Insets(0, 5, 5, 5));
		borderPane.setTop(createToolBar());	
		borderPane.setCenter(new ProcessCreator());
			
		return new Scene(borderPane);
	}

	private GridPane createToolBar() {
//		HBox toolBar = new HBox();
//		toolBar.setPadding(new Insets(15,15,15,15));
//		toolBar.setSpacing(12);
//		toolBar.setStyle("-fx-background-color: #799FAE;");
//		Button processesButton = new Button("Processes");
//		Button simulationButton = new Button("Simulation");
//		toolBar.getChildren().addAll(processesButton, simulationButton);
		GridPane toolBar = new GridPane();
		toolBar.setVgap(10);
		toolBar.setHgap(10);
		toolBar.setPadding(new Insets(10));
		
		Button processesButton = new Button("Processos");
		Button simulationButton = new Button("Simulação");
		toolBar.add(processesButton, 0, 0);
		toolBar.add(simulationButton, 1, 0);
		
		Text schedulingAlgorithms = new Text("Escalonamento:");
		Text pagingAlgorithms = new Text ("Substituição:");
		schedulingAlgorithms.setFont(Font.loadFont("file:resources/fonts/Inconsolata-Bold.ttf", 16));
		pagingAlgorithms.setFont(Font.loadFont("file:resources/fonts/Inconsolata-Bold.ttf", 16));
		
		toolBar.add(schedulingAlgorithms, 0, 1);
		toolBar.add(pagingAlgorithms, 0, 3);
		
		ToggleGroup algorithmButtons = new ToggleGroup();
		
		RadioButton fcfs = new RadioButton("FCFS");
		fcfs.setToggleGroup(algorithmButtons);
		fcfs.setSelected(true);
		
		RadioButton sjf = new RadioButton("SJF");
		sjf.setToggleGroup(algorithmButtons);
		
		RadioButton roundRobin = new RadioButton("Round-robin");
		roundRobin.setToggleGroup(algorithmButtons);
		
		RadioButton edf = new RadioButton("EDF");
		edf.setToggleGroup(algorithmButtons);
		
		toolBar.add(fcfs, 0, 2);
		toolBar.add(sjf, 1, 2);
		toolBar.add(roundRobin, 2, 2);
		toolBar.add(edf, 3, 2);
		
		return toolBar;
	}
}
