package ifpr.pgua.eic.colecaomusicas.models.daos;

import java.util.List;

import ifpr.pgua.eic.colecaomusicas.models.Artista;
import ifpr.pgua.eic.colecaomusicas.models.results.Result;

public interface ArtistaDAO {
    Result insert(Artista artista);
    Result update(Artista artista, Artista artistaAtualizado);
    Result delete(Artista artista);
    List<Artista> listAllArtistas();
}

