package ifpr.pgua.eic.colecaomusicas.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.colecaomusicas.App;
import ifpr.pgua.eic.colecaomusicas.controllers.viewmodel.CadastroGeneroViewModel;
import ifpr.pgua.eic.colecaomusicas.models.results.Result;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class CadastroGenero extends BaseController implements Initializable{

    @FXML
    private TextField tfId;

    @FXML
    private TextField tfNome;

    private CadastroGeneroViewModel viewmodel;

    public CadastroGenero(CadastroGeneroViewModel viewmodel){
        this.viewmodel = viewmodel;
    }

    @FXML
    void cadastrar(ActionEvent event) {
        viewmodel.inserir();
    }

    @FXML
    void cancelar(ActionEvent event) {
        App.popScreen();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        tfNome.textProperty().bindBidirectional(viewmodel.getNomeProperty());

        viewmodel.getAlertProperty().addListener((ChangeListener<Result>) (observable, oldVal, newVal) -> {
            showMessage(newVal);
        });

        viewmodel.limpar();
    }

}
