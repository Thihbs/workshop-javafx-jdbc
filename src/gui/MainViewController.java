package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable {
    @FXML
	private MenuItem menuItemCadastro;
    @FXML
    private MenuItem menuItemConsulta;
    @FXML
    private MenuItem menuItemHelp;
    
    @FXML
    public void onMenuItemCadastroAction( ) {
    	loadView("/gui/CadastroDeUsuario.fxml");
    }
    @FXML
    public void onMenuItemConsultaAction( ) {
    	System.out.println(" onMenuItemConsultaAction");
    }
    @FXML
    public void onMenuItemHelpAction( ) {
    	loadView("/gui/About.fxml");
    }
    
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		
	}
	private void loadView(String absoluteName) {
		try {
			
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
		VBox newVBox = loader.load();
		
		Scene mainScene = Main.getMainScene();
		VBox mainVBox = (VBox) ((ScrollPane)mainScene.getRoot()).getContent();
		Node mainMenu = mainVBox.getChildren().get(0);
		mainVBox.getChildren().clear();
		mainVBox.getChildren().add(mainMenu);
		mainVBox.getChildren().addAll(newVBox.getChildren());
		
	}
		catch (IOException e ) {
			Alerts.showAlert("IO Exception", "ERROR LOADING VIEW	",e.getMessage(), AlertType.ERROR);
		} 
	}
}
