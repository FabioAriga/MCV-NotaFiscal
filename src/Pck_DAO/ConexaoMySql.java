package Pck_DAO;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 

public class ConexaoMySql {
    public Connection oConnection = null; 
    private final String DRIVER = "com.mysql.jdbc.Driver"; 
    private final String URL= "jdbc:mysql//localhost:3306/db_padra_venda"; 
    private final String LOGIN	= "root"; 
    private final String SENHA	= ""; 

    public boolean getConnection() { 
        try { 
            Class.forName(DRIVER); 
            oConnection= DriverManager.getConnection(URL,LOGIN,SENHA); 
            System.out.println("Conectou"); 
            return true; 
        } catch (ClassNotFoundException erro) { 
            System.out.println("Driver nao encontrado" + erro.toString()); 
            return false; 
        } catch (SQLException erro) { 
            System.out.println("Falha ao conectar" + erro.toString()); 
            return false; 
        } 
    }   
}
