package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

	private static Stage primaryStage;
	private static BorderPane mainLayout;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Company Registration App");
		
		showMainView();
		showMainItems();
	}

	public static void showMainItems() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/gui/MainItems.fxml"));
		BorderPane mainItems = loader.load();
		mainLayout.setCenter(mainItems);
	}

	private void showMainView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/gui/MainView.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout, 600, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void showPublicCompanyScene() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/gui/PublicCompanyView.fxml"));
		BorderPane publicCompany = loader.load();
		mainLayout.setCenter(publicCompany);
	}
	
	public static void showPrivateCompanyScene() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/gui/PrivateCompanyView.fxml"));
		BorderPane privateCompany = loader.load();
		mainLayout.setCenter(privateCompany);
	}

	public static void showAddStage() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/gui/AddNewCompany.fxml"));
		BorderPane addNewCompany = loader.load();
		
		Stage addDialogStage = new Stage();
		addDialogStage.setTitle("Add New Company");
		addDialogStage.initModality(Modality.WINDOW_MODAL);
		addDialogStage.initOwner(primaryStage);
		
		Scene scene = new Scene(addNewCompany);
		addDialogStage.setScene(scene);
		addDialogStage.showAndWait();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
