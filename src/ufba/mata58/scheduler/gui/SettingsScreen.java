package ufba.mata58.scheduler.gui;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ufba.mata58.scheduler.main.Simulation;

public class SettingsScreen extends Stage {
	private VBox container;
	private GridPane grid;
	private Text overload;
	private Text quantum;
	private Text timeInDisk;
	private TextField overloadTF;
	private TextField quantumTF;
	private TextField timeInDiskTF;
	private Button saveButton;
	
	public SettingsScreen() {
		setTitle("Configurações");
		setResizable(false);
		container = new VBox();
		grid = new GridPane();
		overload = new Text("Sobrecarga:");
		quantum = new Text("Quantum:");
		timeInDisk = new Text("Tempo no disco:");
		overloadTF = new TextField(Simulation.getOverload().toString());
		quantumTF = new TextField(Simulation.getQuantum().toString());
		timeInDiskTF = new TextField(Simulation.getTimeInDisk().toString());
		saveButton = new Button("Salvar");
		
		overload.setFont(Font.loadFont("file:resources/fonts/Inconsolata-Bold.ttf", 16));
		quantum.setFont(Font.loadFont("file:resources/fonts/Inconsolata-Bold.ttf", 16));
		timeInDisk.setFont(Font.loadFont("file:resources/fonts/Inconsolata-Bold.ttf", 16));
		
		overloadTF.setMaxWidth(50);
		quantumTF.setMaxWidth(50);
		timeInDiskTF.setMaxWidth(50);
		
		forceNumeric(overloadTF);
		forceNumeric(quantumTF);
		forceNumeric(timeInDiskTF);
		
		saveButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				List<Integer> newValues = parseTextFields();
				Simulation.setOverload(newValues.get(0));
				Simulation.setQuantum(newValues.get(1));
				Simulation.setTimeInDisk(newValues.get(2));
				close();
			}
		});
		
		grid.setPadding(new Insets(10));
		grid.setHgap(10);
		grid.setVgap(10);
		
		grid.add(overload, 0, 0);
		grid.add(overloadTF, 1, 0);
		grid.add(quantum, 0, 1);
		grid.add(quantumTF, 1, 1);
		grid.add(timeInDisk, 0, 2);
		grid.add(timeInDiskTF, 1, 2);
		
		container.setAlignment(Pos.CENTER);
		container.setPadding(new Insets(10));
		container.setSpacing(10);
		container.getChildren().addAll(grid, saveButton);
		
		Scene scene = new Scene(container);
		setScene(scene);
		show();
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
	
	protected List<Integer> parseTextFields() {
		List<Integer> results = new ArrayList<Integer>();
		
		if((!overloadTF.getText().isEmpty() && overloadTF.getText() != null) &&(!quantumTF.getText().isEmpty() && quantumTF.getText() != null) && 
		(!timeInDiskTF.getText().isEmpty() && timeInDiskTF.getText() != null)) {
			
			int newOverload = Integer.parseInt(overloadTF.getText());
			int newQuantum = Integer.parseInt(quantumTF.getText());
			int newTid = Integer.parseInt(timeInDiskTF.getText());
			
			results.add(newOverload);
			results.add(newQuantum);
			results.add(newTid);
		}
		
		return results;
	}
}
