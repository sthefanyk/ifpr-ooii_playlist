package ifpr.pgua.eic.colecaomusicas.models.daos;

import java.util.List;

import ifpr.pgua.eic.colecaomusicas.models.Genero;
import ifpr.pgua.eic.colecaomusicas.models.results.Result;

public interface GeneroDAO {
    Result insert(Genero genero);
    Result update(Genero genero, Genero generoAtualizado);
    Result delete(Genero genero);
    List<Genero> listAllGeneros();
}

