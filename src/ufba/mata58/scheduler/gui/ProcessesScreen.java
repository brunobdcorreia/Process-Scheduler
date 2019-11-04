package ufba.mata58.scheduler.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ProcessesScreen implements ISceneCreation {
	
	@Override
	public Scene createScene() {
		BorderPane borderPane = new BorderPane();
		
		borderPane.setPadding(new Insets(0, 5, 5, 5));
		borderPane.setTop(createToolBar());	
		borderPane.setCenter(new ProcessCreator());
			
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
		
		Button processesButton = new Button("Processos");
		Button simulationButton = new Button("Simulação");
		toolBarButtons.getChildren().addAll(processesButton, simulationButton);

		toolBar.add(toolBarButtons, 0, 0);
		
		Text schedulingAlgorithms = new Text("Escalonamento:");
		Text pagingAlgorithms = new Text("Substituição:");
		schedulingAlgorithms.setFont(Font.loadFont("file:resources/fonts/Inconsolata-Bold.ttf", 16));
		pagingAlgorithms.setFont(Font.loadFont("file:resources/fonts/Inconsolata-Bold.ttf", 16));
		
		toolBar.add(schedulingAlgorithms, 0, 1);
		toolBar.add(pagingAlgorithms, 0, 3);
		
		ToggleGroup algorithmButtons = new ToggleGroup();
		HBox algorithmSelector = new HBox();
		algorithmSelector.setPadding(new Insets(10));
		algorithmSelector.setSpacing(10);
		
		RadioButton fcfs = new RadioButton("FCFS");
		fcfs.setToggleGroup(algorithmButtons);
		fcfs.setSelected(true);
		
		RadioButton sjf = new RadioButton("SJF");
		sjf.setToggleGroup(algorithmButtons);
		
		RadioButton roundRobin = new RadioButton("Round-robin");
		roundRobin.setToggleGroup(algorithmButtons);
		
		RadioButton edf = new RadioButton("EDF");
		edf.setToggleGroup(algorithmButtons);
		
		algorithmSelector.getChildren().addAll(fcfs, sjf, roundRobin, edf);
		toolBar.add(algorithmSelector, 0, 2);
		
		return toolBar;
	}
	
	private ScrollPane createProcessList() {
		ScrollPane processList = new ScrollPane();
		processList.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
		
		FlowPane fp = new FlowPane();
		fp.setPadding(new Insets(10));
		
		
		return processList;
	}
}




















