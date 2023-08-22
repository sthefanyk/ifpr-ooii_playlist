package ifpr.pgua.eic.colecaomusicas.controllers.viewmodel;

import ifpr.pgua.eic.colecaomusicas.models.repositories.GeneroRepository;
import ifpr.pgua.eic.colecaomusicas.models.results.Result;
import ifpr.pgua.eic.colecaomusicas.models.results.SuccessResult;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CadastroGeneroViewModel {
    private StringProperty nomeProperty = new SimpleStringProperty();
    private ObjectProperty<Result> alertProperty = new SimpleObjectProperty<>();

    private GeneroRepository repo;

    public CadastroGeneroViewModel(GeneroRepository repo) {
        this.repo = repo;
    }

    public boolean inserir() {
        String nome = nomeProperty.getValue();

        Result msg = repo.insert(nome);
        alertProperty.setValue(msg);
        return msg instanceof SuccessResult;
    }

    public void limpar() {
        nomeProperty.setValue("");
    }

    public StringProperty getNomeProperty() {
        return nomeProperty;
    }

    public ObjectProperty<Result> getAlertProperty() {
        return alertProperty;
    }

    public GeneroRepository getRepo() {
        return repo;
    }

}
