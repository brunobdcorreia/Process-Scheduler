package ufba.mata58.scheduler.gui;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import ufba.mata58.scheduler.main.Simulation;

public class ProcessModel extends VBox {
	public static int nProcesses = 1;
	private int pNumber = ProcessesScreen.getProcessPane().getChildren().size() + 1;
	private Text processNumber;
	private Text arrivalTime;
	private Text executionTime;
	private Text deadline;
	private Text priority;
	private Text nPages;
	private StackPane delete;
	
	public ProcessModel(int arrivalTime, int executionTime, int deadline, int priority, int nPages) {
		setSpacing(10);
		setPadding(new Insets(10));
		
		delete = new StackPane();
		Circle deleteBG = new Circle(0, 0, 10, Color.web("#f9f9f9"));
		deleteBG.setStroke(Color.BLACK);
		Text deleteText = new Text("X");
		deleteText.setFill(Color.BLACK);
		deleteText.setFont(Font.loadFont("file:resources/fonts/Inconsolata-Bold.ttf", 14));
		
		delete.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				ProcessesScreen.getProcessPane().getChildren().remove(pNumber - 1);
				
				if(pNumber - 1 < ProcessesScreen.getProcessPane().getChildren().size()) {
					for(int i = pNumber - 1; i < ProcessesScreen.getProcessPane().getChildren().size(); i++) {
						ProcessModel pm = (ProcessModel) ProcessesScreen.getProcessPane().getChildren().get(i);
						pm.setProcessNumber(i + 1);
					}
				}
					
				Simulation.removeProcess(pNumber - 1);
			}
		});
	
		
		delete.getChildren().addAll(deleteBG, deleteText);
		
		
		addAnimationHandlers();
		
		HBox hbox = new HBox();
		hbox.setSpacing(40);
		
//		this.processNumber = new Text("Processo " + nProcesses++);
		this.processNumber = new Text("Processo " + pNumber);
		this.arrivalTime = new Text("Tempo de chegada: " + arrivalTime);
		this.executionTime = new Text("Tempo de execução: " + executionTime);
		this.deadline = new Text("Deadline: " + deadline);
		this.priority = new Text("Prioridade: " + priority);
		this.nPages = new Text("Nº de páginas: " + nPages);
		
		this.processNumber.setFont(Font.loadFont("file:resources/fonts/Inconsolata-Bold.ttf", 18));
		this.arrivalTime.setFont(Font.loadFont("file:resources/fonts/Inconsolata-Regular.ttf", 14));
		this.executionTime.setFont(Font.loadFont("file:resources/fonts/Inconsolata-Regular.ttf", 14));
		this.deadline.setFont(Font.loadFont("file:resources/fonts/Inconsolata-Regular.ttf", 14));
		this.priority.setFont(Font.loadFont("file:resources/fonts/Inconsolata-Regular.ttf", 14));
		this.nPages.setFont(Font.loadFont("file:resources/fonts/Inconsolata-Regular.ttf", 14));
		
		hbox.getChildren().addAll(this.processNumber, delete);
		
		getChildren().addAll(hbox, this.arrivalTime, this.executionTime, this.deadline, this.priority, this.nPages);
	}
	
	public void setProcessNumber(int newNumber) {
		processNumber.setText("Processo " + newNumber);
	}
	
	private void addAnimationHandlers() {
		this.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setStyle("-fx-border-color: #1E74CA; -fx-border-radius: 5;");
			}
		});
		
		this.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setStyle("-fx-border-color: black; -fx-border-radius: 5;");
			}
		});
	}

	public int getProcessNumber() {
		return pNumber;
	}
}
