package repository;

import model.Immobile;
import model.Proprietario;
import model.Annessi;
import config.DbConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class ImmobileRepository {

    public List<String> listaVillaGiardino() {
        List<String> listaville = new ArrayList<String>();
        String villa = "";
        try{
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT DISTINCT imm.tipo, an.tipo_ann, pr.nome, pr.cognome\n" +
                    "FROM immobile as imm\n" +
                    "JOIN Proprietario pr ON pr.idP = imm.xidP\n" +
                    "JOIN Annessi an on an.XidI = imm.idI\n" +
                    "WHERE imm.tipo LIKE 'Villa' and an.tipo_ann LIKE 'Giardino';");
            while (rs.next()) {
                villa = rs.getString("tipo") +" "+ rs.getString("tipo_ann") + " "+ rs.getString("nome") + " "+ rs.getString("cognome");
                listaville.add(villa);
            }
        } catch (ClassNotFoundException | SQLException e ) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaville;
    }

    public List<String> appartNovantaSei(){
        List<String> app = new ArrayList<>();
        try{
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT pr.Nome, pr.Cognome, imm.tipo, imm.anno\n" +
                    "FROM immobile as imm\n" +
                    "JOIN Proprietario pr ON pr.idP = imm.xidP\n" +
                    "WHERE imm.anno > 1996; ");
            while(rs.next()) {
                app.add(rs.getString("nome") + " " + rs.getString("cognome") + " "+ rs.getString("tipo") + " "+ rs.getString("anno"));
            }
        }catch (ClassNotFoundException | SQLException e){
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return app;
    }

}
