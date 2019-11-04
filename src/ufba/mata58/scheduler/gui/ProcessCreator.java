package ufba.mata58.scheduler.gui;

import java.util.ArrayList;
import java.util.Collection;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import ufba.mata58.scheduler.processes.*;

public class ProcessCreator extends GridPane {
	private Text arrivalTime;
	private Text executionTime;
	private Text deadline;
	private Text priority;
	private TextField arrivalTimeTF;
	private TextField executionTimeTF;
	private TextField deadlineTF;
	private TextField priorityTF;
	private StackPane createProcess;
	private Rectangle buttonBG = new Rectangle(70.0, 30.0);
	
	public ProcessCreator() {
		createTextFields();		
		createTextLabels();				
		createProcess = createProcessButton();
		
		setHgap(10);
		setVgap(10);
		setPadding(new Insets(10,15,10,15));
		setStyle("-fx-border-color: black; -fx-border-radius: 10");
		setAlignment(Pos.CENTER_LEFT);
		
		add(arrivalTime, 0, 0);
		add(arrivalTimeTF, 1, 0);
		add(executionTime, 0, 1);
		add(executionTimeTF, 1, 1);
		add(deadline, 0, 2);
		add(deadlineTF, 1, 2);
		add(priority, 0, 3);
		add(priorityTF, 1, 3);
		add(createProcess, 0, 4);
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

	private void createTextLabels() {
		arrivalTime = new Text("Tempo de chegada:");
		executionTime = new Text("Tempo de execução:");
		deadline = new Text("Deadline:");
		priority = new Text("Prioridade:");
		
		arrivalTime.setFont(Font.loadFont("file:resources/fonts/Inconsolata-Bold.ttf", 16));
		executionTime.setFont(Font.loadFont("file:resources/fonts/Inconsolata-Bold.ttf", 16));
		deadline.setFont(Font.loadFont("file:resources/fonts/Inconsolata-Bold.ttf", 16));
		priority.setFont(Font.loadFont("file:resources/fonts/Inconsolata-Bold.ttf", 16));
	}

	private void createTextFields() {
		arrivalTimeTF = new TextField();
		executionTimeTF = new TextField();
		deadlineTF = new TextField();
		priorityTF = new TextField();
		
		arrivalTimeTF.setMaxWidth(50);
		executionTimeTF.setMaxWidth(50);
		deadlineTF.setMaxWidth(50);
		priorityTF.setMaxWidth(50);
		
		forceNumeric(arrivalTimeTF);
		forceNumeric(executionTimeTF);
		forceNumeric(deadlineTF);
		forceNumeric(priorityTF);
	}
	
	private void forceNumeric(TextField tf) {
		tf.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if(!newValue.matches("\\d*")) {
					tf.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});
	}
	
	private void addHandlers(Collection<Shape> nodes) {
		for(Node node : nodes) {
			node.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					//createProcess();
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
	
	private ArrayList<Integer> parseTextFields() {
		ArrayList<Integer> values = new ArrayList<Integer>();
		
		if(!arrivalTimeTF.getText().isEmpty() && arrivalTimeTF.getText() != null && !executionTime.getText().isEmpty() && executionTimeTF.getText() != null 
			&& !deadlineTF.getText().isEmpty() && deadlineTF.getText() != null && !priorityTF.getText().isEmpty() && priorityTF.getText() != null) {
			
			values.add(Integer.parseInt(arrivalTimeTF.getText()));
			values.add(Integer.parseInt(executionTimeTF.getText()));
			values.add(Integer.parseInt(deadlineTF.getText()));
			values.add(Integer.parseInt(priorityTF.getText()));
		}
		
		else {
			return null;
		}
		
		return values;
	}
	
	public IOBoundProcess createIOBoundProcess() {
		System.out.println("Creating process...");
		
		ArrayList<Integer> processAttributes = parseTextFields();
		
		if(processAttributes != null) {
			return new IOBoundProcess(processAttributes.get(0), processAttributes.get(1), processAttributes.get(2), processAttributes.get(3));
		}
		
		else {
			System.out.println("Erro ao criar processo.");
			return null;
		}
	}
}













