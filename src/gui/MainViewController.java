package gui;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXML;

public class MainViewController {

	private Main main;
	
	@FXML
	private void onBtnHomeAction() throws IOException {
		main.showMainItems();
	}
	
}
