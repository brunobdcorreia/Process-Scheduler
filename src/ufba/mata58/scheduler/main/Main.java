package ufba.mata58.scheduler.main;
	
import javafx.application.Application;
import javafx.stage.Stage;
import ufba.mata58.scheduler.gui.MainScreen;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Process Scheduler");
			primaryStage.setResizable(false);
			MainScreen primaryScene = new MainScreen();
			primaryStage.setScene(primaryScene.createScene());			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}