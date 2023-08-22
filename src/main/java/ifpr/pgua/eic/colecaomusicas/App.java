package ifpr.pgua.eic.colecaomusicas;

import ifpr.pgua.eic.colecaomusicas.controllers.CadastroArtista;
import ifpr.pgua.eic.colecaomusicas.controllers.CadastroGenero;
import ifpr.pgua.eic.colecaomusicas.controllers.ListarGeneros;
import ifpr.pgua.eic.colecaomusicas.controllers.Principal;
import ifpr.pgua.eic.colecaomusicas.controllers.viewmodel.CadastroArtistaViewModel;
import ifpr.pgua.eic.colecaomusicas.controllers.viewmodel.CadastroGeneroViewModel;
import ifpr.pgua.eic.colecaomusicas.controllers.viewmodel.ListarGenerosViewModel;
import ifpr.pgua.eic.colecaomusicas.models.FabricaConexoes;
import ifpr.pgua.eic.colecaomusicas.models.Repositorio;
import ifpr.pgua.eic.colecaomusicas.models.daos.ArtistaDAO;
import ifpr.pgua.eic.colecaomusicas.models.daos.GeneroDAO;
import ifpr.pgua.eic.colecaomusicas.models.daos.JDBCArtistaDAO;
import ifpr.pgua.eic.colecaomusicas.models.daos.JDBCGeneroDAO;
import ifpr.pgua.eic.colecaomusicas.models.repositories.ArtistaRepository;
import ifpr.pgua.eic.colecaomusicas.models.repositories.GeneroRepository;
import io.github.hugoperlin.navigatorfx.BaseAppNavigator;
import io.github.hugoperlin.navigatorfx.ScreenRegistryFXML;

/**
 * JavaFX App
 */
public class App extends BaseAppNavigator {

    private ArtistaDAO artistaDAO;
    private ArtistaRepository artistaRepo;

    private GeneroDAO generoDAO;
    private GeneroRepository generoRepo;


    @Override
    public void init() throws Exception {
        super.init();

        artistaDAO = new JDBCArtistaDAO(FabricaConexoes.getInstance());
        artistaRepo = new ArtistaRepository(artistaDAO);

        generoDAO = new JDBCGeneroDAO(FabricaConexoes.getInstance());
        generoRepo = new GeneroRepository(generoDAO);
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public String getHome() {
        // TODO Auto-generated method stub
        return "PRINCIPAL";
    }

    @Override
    public String getAppTitle() {
        // TODO Auto-generated method stub
        return "Coleção de Músicas";
    }

    @Override
    public void registrarTelas() {
        registraTela("PRINCIPAL", new ScreenRegistryFXML(App.class, "principal.fxml", o->new Principal()));
        registraTela("CADASTROGENERO",
                  new ScreenRegistryFXML(App.class, 
                      "cadastrar_genero.fxml", 
                      o->new CadastroGenero(new CadastroGeneroViewModel(generoRepo))
                  )
        );
        registraTela("LISTARGENEROS",
                  new ScreenRegistryFXML(App.class, 
                      "listar_generos.fxml", 
                      o->new ListarGeneros(new ListarGenerosViewModel(generoRepo))
                  )
        );
        registraTela("CADASTROARTISTA",
                  new ScreenRegistryFXML(App.class, 
                      "cadastrar_artista.fxml", 
                      o->new CadastroArtista(new CadastroArtistaViewModel(artistaRepo))
                  )
        );
    }

}