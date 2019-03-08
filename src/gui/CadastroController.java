package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Cadastro;
import model.services.CadastroConsulta;

public class CadastroController implements Initializable {
    private CadastroConsulta consulta;
    
	@FXML
	
	private TableView<Cadastro> tableViewCadastro;
	@FXML
	private TableColumn<Cadastro,Integer> tableColumnId;
	@FXML
	private TableColumn<Cadastro,String > tableColumnName;
	@FXML
	private Button btNew;
	private ObservableList<Cadastro> obsList;
	
	@FXML
	public void onBtNewAction() {
		System.out.println("onBTNewAction");
	}
	
	public void setCadastroConsulta(CadastroConsulta consulta) {
		this.consulta = consulta;
	}
	@Override
	public void initialize(URL URL, ResourceBundle rb) {
		initializeNodes();
	}


	private void initializeNodes() {
    tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
    tableColumnName.setCellValueFactory(new PropertyValueFactory<>("Name"));
    
	
    Stage stage  = (Stage) Main.getMainScene().getWindow();
    tableViewCadastro.prefHeightProperty().bind(stage.heightProperty());
    
}
	public void updateTableView() {
		if(consulta == null ) {
			throw new IllegalStateException("SERVICE WAS NULL");
	}	
	List<Cadastro> list = consulta.findAll();
	obsList = FXCollections.observableArrayList(list);
	tableViewCadastro.setItems(obsList);
	}	
	
	
}
