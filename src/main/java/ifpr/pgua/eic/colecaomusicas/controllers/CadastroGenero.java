package ifpr.pgua.eic.colecaomusicas.controllers;

import ifpr.pgua.eic.colecaomusicas.models.Repositorio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CadastroGenero {

    @FXML
    private TextField tfId;

    @FXML
    private TextField tfNome;

    private Repositorio repositorio;

    public CadastroGenero(Repositorio repositorio){
        this.repositorio = repositorio;
    }

    @FXML
    void cadastrar(ActionEvent event) {
        String nome = tfNome.getText();

        String msg = repositorio.cadastrarGenero(nome);

        Alert alert = new Alert(AlertType.INFORMATION,msg);
        alert.showAndWait();

    }

    @FXML
    void cancelar(ActionEvent event) {

    }

}
