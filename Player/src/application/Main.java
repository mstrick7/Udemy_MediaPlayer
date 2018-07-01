package application;
	
import java.io.File;
import java.net.MalformedURLException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;


public class Main extends Application {
	Player player;
	FileChooser fileChooser;
	public void start(Stage primaryStage) {
		
		MenuItem open = new MenuItem("open");
		Menu file = new Menu("file");
		MenuBar menu = new MenuBar();
		
		file.getItems().add(open);
		menu.getMenus().add(file);
		
		fileChooser = new FileChooser();
		
		open.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				player.player.pause();
				File file = fileChooser.showOpenDialog(primaryStage);
				if(file != null) {
					try {
						player = new Player(file.toURI().toURL().toExternalForm());
						Scene scene = new Scene(player, 720, 535, Color.BLACK);
						primaryStage.setScene(scene);
					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		primaryStage.setTitle("Matt's Media Player");
		player = new Player("file:/Users/matt/Desktop/GOPR0009.mp4");
		player.setTop(menu);
		Scene scene = new Scene(player, 720, 535, Color.BLACK);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
