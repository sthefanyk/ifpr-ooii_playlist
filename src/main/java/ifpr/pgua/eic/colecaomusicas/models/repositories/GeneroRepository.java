package ifpr.pgua.eic.colecaomusicas.models.repositories;

import java.util.List;

import ifpr.pgua.eic.colecaomusicas.models.Genero;
import ifpr.pgua.eic.colecaomusicas.models.daos.GeneroDAO;
import ifpr.pgua.eic.colecaomusicas.models.results.Result;

public class GeneroRepository {
    GeneroDAO dao;

    public GeneroRepository(GeneroDAO dao) {
        this.dao = dao;
    }

    public Result insert(String nome){
        if (!nome.equals("")) {
            Genero genero = new Genero(nome);
            return dao.insert(genero);
        }
        return Result.fail("Preencha todos os campos!");
    }

    public List<Genero> getGeneros(){
        return dao.listAllGeneros();
    }

    
}
