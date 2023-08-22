package ifpr.pgua.eic.colecaomusicas.models.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ifpr.pgua.eic.colecaomusicas.models.FabricaConexoes;
import ifpr.pgua.eic.colecaomusicas.models.Genero;
import ifpr.pgua.eic.colecaomusicas.models.results.Result;

public class JDBCGeneroDAO implements GeneroDAO{

    private static final String INSERT = "INSERT INTO playlist_generos (nome) VALUES (?)";
    private static final String SELECT_ALL = "SELECT * FROM playlist_generos";

    FabricaConexoes fabricaConexoes;

    public JDBCGeneroDAO(FabricaConexoes fabricaConexoes) {
        this.fabricaConexoes = fabricaConexoes;
    }

    @Override
    public Result insert(Genero genero) {
        try{
            Connection con = fabricaConexoes.getConnection();
            PreparedStatement pstm = con.prepareStatement(INSERT);

            pstm.setString(1, genero.getNome());

            pstm.executeUpdate();

            pstm.close();
            con.close();

            return Result.success("Genero cadastrado!");

        }catch(SQLException e){
            System.out.println(e.getMessage());
            return Result.fail(msg(e.getMessage()));
        }
    }

    @Override
    public Result update(Genero genero, Genero generoAtualizado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Result delete(Genero genero) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<Genero> listAllGeneros() {
        ArrayList<Genero> generos = new ArrayList<>();
        try{
            Connection con = fabricaConexoes.getConnection();
            PreparedStatement pstm = con.prepareStatement(SELECT_ALL);

            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                Genero genero = new Genero(rs.getInt("id"), rs.getString("nome"));
                generos.add(genero);
            }

            rs.close();
            pstm.close();
            con.close();

            return generos;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String msg(String msg){
        String[] msgSeparada = msg.split("'");
        msg = msgSeparada[1];
        msgSeparada = msg.split("\\.");
        return msgSeparada[1];
    }
    
}
