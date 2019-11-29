package ufba.mata58.scheduler.gui;

import java.util.ArrayList;
import java.util.Collection;

import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import ufba.mata58.scheduler.main.Simulation;

public class Gantt extends ScrollPane {
	private GridPane gantt;
	
	public Gantt() {
		gantt = new GridPane();
		int nRows = 3;
		int nColumns = 51;
		
		setPadding(new Insets(5));
		gantt.setHgap(3);
		gantt.setVgap(3);
		gantt.setPadding(new Insets(5));
		
		setContent(gantt);
		setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
		
		setMaxWidth(600);
		
		for(int i = 0; i < nRows; ++i) {
			for(int j = 0; j < nColumns; ++j) {
				gantt.add(new Rectangle(25, 25, Color.LIGHTGRAY), j, i);
			}
		}
	}
}
