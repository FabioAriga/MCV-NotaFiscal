package Pck_DAO;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 

public class ConexaoMySql {
    public Connection oConnection = null; 
    private final String DRIVER = "com.mysql.cj.jdbc.Driver"; 
    private final String URL= "jdbc:mysql://localhost:3306/db_padrao_venda"; 
    private final String LOGIN	= "root"; 
    private final String SENHA	= "admin"; 

    public Connection getConnection() { 
        try { 
            Class.forName(DRIVER); 
            return DriverManager.getConnection(URL,LOGIN,SENHA); 
        } catch (ClassNotFoundException erro) { 
            System.out.println("Driver nao encontrado" + erro.toString()); 
        } catch (SQLException erro) { 
            System.out.println("Falha ao conectar" + erro.toString()); 
        } 
        return null;
    }   
}
