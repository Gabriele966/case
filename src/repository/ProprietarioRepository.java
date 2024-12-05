package repository;

import config.DbConnection;
import model.Proprietario;
import model.Immobile;
import java.sql.*;
import java.util.*;
import java.util.concurrent.CancellationException;


public class ProprietarioRepository {

    public Map<Proprietario, Integer> superficePosseduta(){
        int metri;
        Map<Proprietario, Integer> map = new HashMap<Proprietario, Integer>();
        List<Proprietario> lproprietario = new ArrayList<Proprietario>();
        List<Integer> lmetri = new ArrayList<Integer>();
        try{
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT pr.Nome, pr.Cognome, SUM(Sup)\n" +
                    "FROM Proprietario AS pr\n" +
                    "JOIN immobile imm ON imm.xidP = pr.idP\n" +
                    "GROUP BY(pr.Nome, pr.Cognome);");
            while(rs.next()){
                Proprietario oProprietario = new Proprietario();
                oProprietario.setNome(rs.getString("Nome"));
                oProprietario.setCognome(rs.getString("Cognome"));
                metri = rs.getInt("Sum");
                map.put(oProprietario, metri);
            }


        }catch (ClassNotFoundException | SQLException e){
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return map;
    }

    public List<String> possessoriVilla(){
        List<String> proprietari = new ArrayList<>();
        String prop = "";
        try{
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT pr.Nome, pr.Cognome, imm.tipo\n" +
                    "FROM Proprietario AS pr\n" +
                    "JOIN immobile imm ON imm.xidP = pr.idP\n" +
                    "WHERE imm.tipo LIKE 'Villa'");
            while(rs.next()){
                prop = rs.getString("Nome") + " " + rs.getString("Cognome");
                proprietari.add(prop);
            }
        }catch (ClassNotFoundException | SQLException e){
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return proprietari;
    }

}
