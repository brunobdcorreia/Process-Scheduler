package ufba.mata58.scheduler.main;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ufba.mata58.scheduler.gui.ProcessesScreen;


public class Main extends Application {
	private static Stage currentStage;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			currentStage = primaryStage;
			primaryStage.setTitle("Process Scheduler");
			primaryStage.setResizable(true);
			ProcessesScreen primaryScene = new ProcessesScreen();
			
			primaryStage.setScene(primaryScene.createScene());			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void changeScene(Scene newScene) {
		currentStage.setScene(newScene);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
