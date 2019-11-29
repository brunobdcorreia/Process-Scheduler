package ufba.mata58.scheduler.gui;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ProcessModel extends VBox {
	protected static int nProcesses = 1;
	private Text processNumber;
	private Text arrivalTime;
	private Text executionTime;
	private Text deadline;
	private Text priority;
	private Text nPages;
	
	public ProcessModel(int arrivalTime, int executionTime, int deadline, int priority, int nPages) {
		setSpacing(10);
		setPadding(new Insets(10));
		setStyle("-fx-border-color: black; -fx-border-radius: 5;");
		
		addAnimationHandlers();
		
		this.processNumber = new Text("Processo " + nProcesses++);
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
		
		getChildren().addAll(this.processNumber, this.arrivalTime, this.executionTime, this.deadline, this.priority, this.nPages);
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
}
