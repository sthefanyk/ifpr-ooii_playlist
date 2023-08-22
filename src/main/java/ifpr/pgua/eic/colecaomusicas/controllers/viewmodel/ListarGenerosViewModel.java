package ifpr.pgua.eic.colecaomusicas.controllers.viewmodel;

import java.util.List;

import ifpr.pgua.eic.colecaomusicas.models.Genero;
import ifpr.pgua.eic.colecaomusicas.models.repositories.GeneroRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ListarGenerosViewModel {
    // private ObservableList<Genero> generos = FXCollections.observableArrayList();

    private GeneroRepository repo;

    public ListarGenerosViewModel(GeneroRepository repo) {
        this.repo = repo;
    }

    public List<Genero> getGeneros() {
        return repo.getGeneros();
    }
    
}
