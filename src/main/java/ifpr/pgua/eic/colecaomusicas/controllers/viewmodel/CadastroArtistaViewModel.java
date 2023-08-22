package ifpr.pgua.eic.colecaomusicas.controllers.viewmodel;

import ifpr.pgua.eic.colecaomusicas.models.repositories.ArtistaRepository;
import ifpr.pgua.eic.colecaomusicas.models.results.Result;
import ifpr.pgua.eic.colecaomusicas.models.results.SuccessResult;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CadastroArtistaViewModel {
    private StringProperty nomeProperty = new SimpleStringProperty();
    private StringProperty contatoProperty = new SimpleStringProperty();
    private ObjectProperty<Result> alertProperty = new SimpleObjectProperty<>();

    private ArtistaRepository repo;

    public CadastroArtistaViewModel(ArtistaRepository repo) {
        this.repo = repo;
    }

    public boolean inserir() {
        String nome = nomeProperty.getValue();
        String contato = contatoProperty.getValue();

        Result msg = repo.insert(nome, contato);
        alertProperty.setValue(msg);
        return msg instanceof SuccessResult;
    }

    public void limpar() {
        nomeProperty.setValue("");
        contatoProperty.setValue("");
    }

    public StringProperty getNomeProperty() {
        return nomeProperty;
    }

    public StringProperty getContatoProperty() {
        return contatoProperty;
    }

    public ObjectProperty<Result> getAlertProperty() {
        return alertProperty;
    }

    public ArtistaRepository getRepo() {
        return repo;
    }

}
