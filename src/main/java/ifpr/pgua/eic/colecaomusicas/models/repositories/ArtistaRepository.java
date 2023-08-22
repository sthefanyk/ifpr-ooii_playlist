package ifpr.pgua.eic.colecaomusicas.models.repositories;

import ifpr.pgua.eic.colecaomusicas.models.Artista;
import ifpr.pgua.eic.colecaomusicas.models.daos.ArtistaDAO;
import ifpr.pgua.eic.colecaomusicas.models.results.Result;

public class ArtistaRepository {
    ArtistaDAO dao;

    public ArtistaRepository(ArtistaDAO dao) {
        this.dao = dao;
    }

    public Result insert(String nome, String contato){
        if (!nome.equals("") && !contato.equals("")) {
            Artista artista = new Artista(nome, contato);
            return dao.insert(artista);
        }
        return Result.fail("Preencha todos os campos!");
    }
}
