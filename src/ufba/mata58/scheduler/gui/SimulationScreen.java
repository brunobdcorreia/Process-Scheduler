package ufba.mata58.scheduler.gui;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SimulationScreen extends Stage {
	private BorderPane container;
	private HBox bottomBom;
	private GridPane virtualMemory;
	private GridPane ram;

	public SimulationScreen() {
		setTitle("Simulação");
		container = new BorderPane();
		container.setPadding(new Insets(5));
		Gantt gantt = new Gantt();
		
		container.setCenter(gantt);
		container.setBottom(createRAM());
		Scene scene = new Scene(container);
		setResizable(false);
		setScene(scene);
		show();
	}
	
	private VBox createRAM() {
		VBox vbox = new VBox();
		Text text = new Text("RAM");
		text.setFont(Font.loadFont("file:resources/fonts/Ubuntu-Bold.ttf", 24));
		
		GridPane ram = new GridPane();
		
		ram.setPadding(new Insets(5));
		ram.setHgap(3);
		ram.setVgap(3);
		ram.setStyle("-fx-background-color: #DEDEDE; -fx-border-color: black; -fx-border-radius: 5");
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 5; j++) {
				ram.add(new Rectangle(50, 25, Color.WHITE), i, j);
			}
		}
		
		vbox.getChildren().addAll(text, ram);
		
		return vbox;
	}
	
	private GridPane createVirtualMemory() {
		GridPane vm = new GridPane();
		
		
		
		return vm;
	}
}












