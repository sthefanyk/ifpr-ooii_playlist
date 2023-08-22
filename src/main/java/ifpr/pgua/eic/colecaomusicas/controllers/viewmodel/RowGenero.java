package ifpr.pgua.eic.colecaomusicas.controllers.viewmodel;

import ifpr.pgua.eic.colecaomusicas.models.Genero;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RowGenero {
    private Genero genero;

    public RowGenero(Genero genero) {
        this.genero = genero;
    }

    public Genero getGenero() {
        return genero;
    }

    /**
     * Propriedade para representar o atributo nome do genero.
     * 
     * @return SimpleStringProperty com o valor do nome do genero.
     */
    public StringProperty nomeProperty(){
        return new SimpleStringProperty(genero.getNome());
    }
}
