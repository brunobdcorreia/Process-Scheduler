package ufba.mata58.scheduler.gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ProcessCreator extends GridPane {
	private Text arrivalTime;
	private Text executionTime;
	private Text deadline;
	private Text priority;
	private TextField arrivalTimeTF;
	private TextField executionTimeTF;
	private TextField deadlineTF;
	private TextField priorityTF;
	
	public ProcessCreator() {
		arrivalTimeTF = new TextField();
		executionTimeTF = new TextField();
		deadlineTF = new TextField();
		priorityTF = new TextField();
		
		arrivalTimeTF.setMinWidth(Control.USE_PREF_SIZE);
		executionTimeTF.setMinWidth(Control.USE_PREF_SIZE);
		deadlineTF.setMinWidth(Control.USE_PREF_SIZE);
		priorityTF.setMinWidth(Control.USE_PREF_SIZE);
		
		forceNumeric(arrivalTimeTF);
		forceNumeric(executionTimeTF);
		forceNumeric(deadlineTF);
		forceNumeric(priorityTF);
		
		arrivalTime = new Text("Tempo de chegada:");
		executionTime = new Text("Tempo de execução:");
		deadline = new Text("Deadline:");
		priority = new Text("Prioridade:");
		
		arrivalTime.setFont(Font.loadFont("file:resources/fonts/Inconsolata-Bold.ttf", 16));
		executionTime.setFont(Font.loadFont("file:resources/fonts/Inconsolata-Bold.ttf", 16));
		deadline.setFont(Font.loadFont("file:resources/fonts/Inconsolata-Bold.ttf", 16));
		priority.setFont(Font.loadFont("file:resources/fonts/Inconsolata-Bold.ttf", 16));
		
		setHgap(10);
		setVgap(10);
		setPadding(new Insets(10,15,10,15));
		setStyle("-fx-border-color: black; -fx-border-radius: 10");
		
		add(arrivalTime, 0, 0);
		add(arrivalTimeTF, 1, 0);
		add(executionTime, 0, 1);
		add(executionTimeTF, 1, 1);
		add(deadline, 0, 2);
		add(deadlineTF, 1, 2);
		add(priority, 0, 3);
		add(priorityTF, 1, 3);
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
}
