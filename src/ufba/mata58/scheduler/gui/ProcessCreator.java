package ufba.mata58.scheduler.gui;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import ufba.mata58.scheduler.processes.*;

public class ProcessCreator extends GridPane {
	private Text arrivalTime;
	private Text executionTime;
	private Text deadline;
	private Text priority;
	private Text nPages;
	private TextField arrivalTimeTF;
	private TextField executionTimeTF;
	private TextField deadlineTF;
	private TextField priorityTF;
	private TextField nPagesTF;
	
	public ProcessCreator() {
		createTextFields();		
		createTextLabels();				
		
		setHgap(10);
		setVgap(10);
		setPadding(new Insets(10,15,10,15));
		setStyle("-fx-border-color: black; -fx-border-radius: 10");
		setAlignment(Pos.CENTER);
		
		add(arrivalTime, 0, 0);
		add(arrivalTimeTF, 1, 0);
		add(executionTime, 0, 1);
		add(executionTimeTF, 1, 1);
		add(deadline, 0, 2);
		add(deadlineTF, 1, 2);
		add(priority, 0, 3);
		add(priorityTF, 1, 3);
		add(nPages, 0, 4);
		add(nPagesTF, 1, 4);
	}

	private void createTextLabels() {
		arrivalTime = new Text("Tempo de chegada:");
		executionTime = new Text("Tempo de execução:");
		deadline = new Text("Deadline:");
		priority = new Text("Prioridade:");
		nPages = new Text("Número de páginas:");
		
		arrivalTime.setFont(Font.loadFont("file:resources/fonts/Inconsolata-Bold.ttf", 16));
		executionTime.setFont(Font.loadFont("file:resources/fonts/Inconsolata-Bold.ttf", 16));
		deadline.setFont(Font.loadFont("file:resources/fonts/Inconsolata-Bold.ttf", 16));
		priority.setFont(Font.loadFont("file:resources/fonts/Inconsolata-Bold.ttf", 16));
		nPages.setFont(Font.loadFont("file:resources/fonts/Inconsolata-Bold.ttf", 16));
	}

	private void createTextFields() {
		arrivalTimeTF = new TextField("0");
		executionTimeTF = new TextField("0");
		deadlineTF = new TextField("0");
		priorityTF = new TextField("0");
		nPagesTF = new TextField("0");
		
		arrivalTimeTF.setMaxWidth(70);
		executionTimeTF.setMaxWidth(70);
		deadlineTF.setMaxWidth(70);
		priorityTF.setMaxWidth(70);
		nPagesTF.setMaxWidth(70);
		
		arrivalTimeTF.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getButton() == MouseButton.SECONDARY) {
					if(arrivalTimeTF.getText().isEmpty())
						System.out.println("meu pau");
					System.out.println(Integer.parseInt(arrivalTimeTF.getText()));
				}
			}
		});
		
		forceNumeric(arrivalTimeTF);
		forceNumeric(executionTimeTF);
		forceNumeric(deadlineTF);
		forceNumeric(priorityTF);
		forceNumeric(nPagesTF);
	}
	
	private void forceNumeric(TextField tf) {
		tf.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if(!newValue.matches("\\d*")) {
					tf.setText(newValue.replaceAll("\\D+", ""));
				}
			}
		});
	}
	
	protected ArrayList<Integer> parseTextFields() {
		ArrayList<Integer> values = new ArrayList<Integer>();
		
		if((!arrivalTimeTF.getText().isEmpty() || arrivalTimeTF.getText() != null) && (!executionTimeTF.getText().isEmpty() || executionTimeTF.getText() != null) 
			&& (!deadlineTF.getText().isEmpty() || deadlineTF.getText() != null) && (!priorityTF.getText().isEmpty() || priorityTF.getText() != null) && 
			(!nPagesTF.getText().isEmpty() || nPages.getText() != null)) {
			
			values.add(Integer.parseInt(arrivalTimeTF.getText()));
			values.add(Integer.parseInt(executionTimeTF.getText()));
			values.add(Integer.parseInt(deadlineTF.getText()));
			values.add(Integer.parseInt(priorityTF.getText()));
			values.add(Integer.parseInt(nPagesTF.getText()));
			
			for(int i : values) {
				System.out.println(i);
			}
			
			System.out.println(values);
		}
		
		else {
			return null;
		}
		
		return values;
	}
	
	protected ProcessModel createProcess() {
		List<Integer> values = parseTextFields();
		
		if(values == null) System.out.println("sa porra ta nula");
		
		ProcessModel model = new ProcessModel(values.get(0), values.get(1), values.get(2), values.get(3), values.get(4));
		
		return model;
	}
}

