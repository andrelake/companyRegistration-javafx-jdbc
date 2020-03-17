package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.entities.Company;
import model.services.CompanyService;

public class PublicCompanyListController implements Initializable{

	private CompanyService service;
	
	//AnchorPane > TableView
	@FXML
	private TableView<Company> tableViewPublicCompany;
	
	@FXML
	private TableColumn<Company, String> tableColumnRegistered;
	
	private ObservableList<Company> registeredList;
	
	//AnchorPane > TabPane
	//BasicInfo
	@FXML
	private Label lblName;
	
	@FXML
	private Label lblAdress;
	
	@FXML
	private Label lblCity;
	
	@FXML
	private Label lblPhone;
	
	@FXML
	private Label lblEmail;
	
	@FXML
	private Label lblDate;

	@FXML
	private Label lblDuration;
	
	@FXML
	private Label lblRenewalType;
	
	
	public void setCompanyService(CompanyService service) {
		this.service = service;
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
		
	}

	private void initializeNodes() {
		tableColumnRegistered.setCellValueFactory(new PropertyValueFactory<>("Name"));
		
	}
	
	public void updateTableView() {  // carrega itens do service e joga na tableview
		
		if(service == null) {
			throw new IllegalStateException("Service was null");
		}
		
		List<Company> list = service.findAll();
		registeredList = FXCollections.observableArrayList(list);
		tableViewPublicCompany.setItems(registeredList);
	}

}
