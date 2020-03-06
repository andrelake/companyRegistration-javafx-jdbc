package gui;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXML;

public class MainItemsController {

	private Main main;
	
	@FXML
	private void onBtnPublicCompanyAction() throws IOException {
		main.showPublicCompanyScene();
	}
	
	@FXML
	private void onBtnPrivateCompanyAction() throws IOException {
		main.showPrivateCompanyScene();
	}
}
