package ifpr.pgua.eic.colecaomusicas.models.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import ifpr.pgua.eic.colecaomusicas.models.Artista;
import ifpr.pgua.eic.colecaomusicas.models.FabricaConexoes;
import ifpr.pgua.eic.colecaomusicas.models.results.Result;

public class JDBCArtistaDAO implements ArtistaDAO{

    private static final String INSERT = "INSERT INTO playlist_artistas (nome, contato) VALUES (?, ?)";

    FabricaConexoes fabricaConexoes;

    public JDBCArtistaDAO(FabricaConexoes fabricaConexoes) {
        this.fabricaConexoes = fabricaConexoes;
    }

    @Override
    public Result insert(Artista artista) {
        try{
            Connection con = fabricaConexoes.getConnection();
            PreparedStatement pstm = con.prepareStatement(INSERT);

            pstm.setString(1, artista.getNome());
            pstm.setString(2, artista.getContato());

            pstm.executeUpdate();

            pstm.close();
            con.close();

            return Result.success("Artista cadastrado!");

        }catch(SQLException e){
            System.out.println(e.getMessage());
            return Result.fail(msg(e.getMessage()));
        }
    }

    @Override
    public Result update(Artista artista, Artista artistaAtualizado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Result delete(Artista artista) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<Artista> listAllArtistas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listAllArtistas'");
    }

    public String msg(String msg){
        String[] msgSeparada = msg.split("'");
        msg = msgSeparada[1];
        msgSeparada = msg.split("\\.");
        return msgSeparada[1];
    }
    
}
