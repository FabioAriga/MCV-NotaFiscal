package Pck_Persistencia;

import Pck_Model.ClienteModel;
import Pck_DAO.ConexaoMySql;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ClientePersistencia {
    CallableStatement oCall;
    ConexaoMySql oConexaoMySql = new ConexaoMySql();

    public void inserirCliente(ClienteModel oClienteModel) {
        try {
            oCall = oConexaoMySql.obj_connection.prepareCall("{CALL Proc_inserirCliente(?, ?, ?, ?, ?, ?, ?, ?)}");
            oCall.setString(1, oClienteModel.getA01_nome());
            oCall.setString(2, oClienteModel.getA01_endereco());
            oCall.setLong(3, oClienteModel.getA01_telefone());
            oCall.setLong(4, oClienteModel.getA01_cpf());
            oCall.setDate(5, oClienteModel.getA01_data_nasc());
            oCall.setString(6, oClienteModel.getA01_email());
            oCall.setDouble(7, oClienteModel.getA01_credito());
            oCall.execute();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public void alterarCliente(ClienteModel oClienteModel) {
        try {
            oCall = oConexaoMySql.obj_connection.prepareCall("{CALL Proc_alterarCliente(?, ?, ?, ?, ?, ?, ?, ?)}");
            oCall.setInt(1, oClienteModel.getA01_codigo());
            oCall.setString(2, oClienteModel.getA01_nome());
            oCall.setString(3, oClienteModel.getA01_endereco());
            oCall.setLong(4, oClienteModel.getA01_telefone());
            oCall.setLong(5, oClienteModel.getA01_cpf());
            oCall.setDate(6, oClienteModel.getA01_data_nasc());
            oCall.setString(7, oClienteModel.getA01_email());
            oCall.setDouble(8, oClienteModel.getA01_credito());
            oCall.execute();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public void removerCliente(ClienteModel oClienteModel) {
        try {
            oCall = oConexaoMySql.obj_connection.prepareCall("{CALL Proc_removerCliente(?)}");
            oCall.setInt(1, oClienteModel.getA01_codigo());
            oCall.execute();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public ClienteModel buscarCliente(long cpf) {
        try {
            oCall = oConexaoMySql.obj_connection.prepareCall("{CALL Proc_buscarCliente(?)}");
            oCall.setLong(1, cpf);
            ResultSet rs = oCall.executeQuery();
            if (rs.next()) {
                int codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                long telefone = rs.getLong("telefone");
                java.sql.Date data_nasc = rs.getDate("data_nasc");
                String email = rs.getString("email");
                double credito = rs.getDouble("credito");
                return new ClienteModel(codigo, nome, endereco, telefone, cpf, data_nasc, email, credito);
                }
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return null;
    }
}
