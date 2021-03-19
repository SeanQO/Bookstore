package ui;

import java.io.IOException;
import java.util.Optional;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {
	
	private GUIController gc;
	
	public Main() {
		gc = new GUIController();
	}

	public static void main(String[] args) throws IOException {
		launch(args);
		
		Menu m;
		m = new Menu();
		m.startMenu();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmll = new FXMLLoader(getClass().getResource("fxml/mainPane.fxml"));
		fxmll.setController(gc);
		Parent root = fxmll.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Login");
		primaryStage.setResizable(false);
		
		//sets an alert for when the user tries to close the program window.
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			
            public void handle(WindowEvent e) {
            	Alert alert = new Alert(AlertType.CONFIRMATION);
        		
        		alert.setTitle("Exit confirmation");
        		alert.setHeaderText("");
        		alert.setContentText("Are you sure you want to exit the program?");
        		
        		Optional<ButtonType> result = alert.showAndWait();
        		
        		if (result.get() == ButtonType.OK) {
        			Platform.exit();
        	        System.exit(0);
        		}else {
        			e.consume();
        		}
            	
            }
        });
		
		primaryStage.show();

	}

}
