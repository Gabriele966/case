package repository;

import config.DbConnection;
import model.Annessi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class AnnessiRepository {

    public int nBox(){
        int numero = 0;
        try{
            Connection C = DbConnection.openConnection();
            System.out.println("Connessione riuscita");
            Statement stmt = C.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT tipo, COUNT(tipo_ann)\n" +
                    "FROM Annessi\n" +
                    "WHERE tipo_ann LIKE 'Box'\n" +
                    "GROUP BY(tipo_ann);");
            numero = rs.getInt("count");

        }catch(ClassNotFoundException | SQLException e){
            System.err.println(e.getMessage());
            System.exit(0);

        }
        return numero;
    }

}
