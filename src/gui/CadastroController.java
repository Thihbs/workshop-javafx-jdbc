package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Cadastro;

public class CadastroController implements Initializable {

	@FXML
	
	private TableView<Cadastro> tableViewCadastro;
	@FXML
	private TableColumn<Cadastro,Integer> tableColumnId;
	@FXML
	private TableColumn<Cadastro,String > tableColumnName;
	@FXML
	private Button btNew;
	
	@FXML
	public void onBtNewAction() {
		System.out.println("onBTNewAction");
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initializeNodes();
	}


	private void initializeNodes() {
    tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
    tableColumnName.setCellValueFactory(new PropertyValueFactory<>("Name"));
    
	
    Stage stage  = (Stage) Main.getMainScene().getWindow();
    tableViewCadastro.prefHeightProperty().bind(stage.heightProperty());
    
}
	}
