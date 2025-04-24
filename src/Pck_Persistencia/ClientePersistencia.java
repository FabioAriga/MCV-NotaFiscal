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
            oCall = oConexaoMySql.oConnection.prepareCall("{CALL Proc_inserirCliente(?, ?, ?, ?, ?, ?, ?, ?)}");
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
            oCall = oConexaoMySql.oConnection.prepareCall("{CALL Proc_alterarCliente(?, ?, ?, ?, ?, ?, ?, ?)}");
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
            oCall = oConexaoMySql.oConnection.prepareCall("{CALL Proc_removerCliente(?)}");
            oCall.setInt(1, oClienteModel.getA01_codigo());
            oCall.execute();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public ClienteModel buscarCliente(long la01_cpf) {
        try {
            oCall = oConexaoMySql.oConnection.prepareCall("{CALL Proc_buscarCliente(?)}");
            oCall.setLong(1, la01_cpf);
            ResultSet rs = oCall.executeQuery();
            if (rs.next()) {
                int a01_codigo = rs.getInt("A01_codigo");
                String a01_nome = rs.getString("A01_nome");
                String a01_endereco = rs.getString("A01_endereco");
                long a01_telefone = rs.getLong("A01_telefone");
                java.sql.Date a01_data_nasc = rs.getDate("A01_data_nasc");
                String a01_email = rs.getString("A01_email");
                double a01_credito = rs.getDouble("A01_credito");
                return new ClienteModel(a01_codigo, a01_nome, a01_endereco, a01_telefone, la01_cpf, a01_data_nasc, a01_email, a01_credito);
                }
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return null;
    }
    
    public double buscarCredito(long la01_cpf){
        try {
            oCall = oConexaoMySql.oConnection.prepareCall("{CALL Proc_buscarCliente(?)}");
            oCall.setLong(1, la01_cpf);
            ResultSet rs = oCall.executeQuery();
            if (rs.next()) {
                double a01_credito = rs.getDouble("A01_credito");
                return a01_credito;
                }
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return 0;
    }
}
