package ifpr.pgua.eic.colecaomusicas.controllers.viewmodel;

import ifpr.pgua.eic.colecaomusicas.models.Artista;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RowArtista {
    private Artista artista;

    public RowArtista(Artista artista) {
        this.artista = artista;
    }

    public Artista getArtista() {
        return artista;
    }

    /**
     * Propriedade para representar o atributo nome do artista.
     * 
     * @return SimpleStringProperty com o valor do nome do artista.
     */
    public StringProperty nomeProperty(){
        return new SimpleStringProperty(artista.getNome());
    }

    /**
     * Propriedade para representar o atributo contato do artista.
     * 
     * @return SimpleStringProperty com o valor do contato do artista.
     */
    public StringProperty contatoProperty(){
        return new SimpleStringProperty(artista.getContato());
    }
}
