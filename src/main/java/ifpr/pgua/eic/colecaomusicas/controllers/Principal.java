package ifpr.pgua.eic.colecaomusicas.controllers;

import ifpr.pgua.eic.colecaomusicas.App;
import javafx.fxml.FXML;

public class Principal {
    

    @FXML
    private void cadastrarGenero(){
        App.pushScreen("CADASTROGENERO");
    }

    @FXML
    private void cadastrarArtista(){
        App.pushScreen("CADASTROARTISTA");
    }

    @FXML
    private void listarGeneros(){
        App.pushScreen("LISTARGENEROS");
    }

}
