package Pck_Persistencia;

import Pck_Model.PedidoModel;
import Pck_DAO.ConexaoMySql;
import Pck_Model.ClienteModel;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class PedidoPersistencia{
    CallableStatement oCall;
    ConexaoMySql oConexaoMySql = new ConexaoMySql();

    public int inserirPedido(PedidoModel oPedidoModel) {
        int codigo_pedido = -1;
        try {
            oCall = oConexaoMySql.oConnection.prepareCall("{CALL Proc_inserirPedido(?, ?, ?, ?)}");
            oCall.setDate(1, oPedidoModel.getA02_data());
            oCall.setDouble(2, oPedidoModel.getA02_valor_total());
            oCall.setInt(3, oPedidoModel.getA01_codigo());
            oCall.registerOutParameter(4, java.sql.Types.INTEGER);
            oCall.execute();
            codigo_pedido = oCall.getInt(4);
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return codigo_pedido;
    }
    
    public void alterarPedido(PedidoModel oPedidoModel, double da04_valor_item) {
        try {
            oCall = oConexaoMySql.oConnection.prepareCall("{CALL Proc_alterarPedido(?, ?, ?, ?, ?)}");
            oCall.setInt(1, oPedidoModel.getA02_codigo());
            oCall.setDate(2, oPedidoModel.getA02_data());
            oCall.setDouble(3, oPedidoModel.getA02_valor_total());
            oCall.setInt(4, oPedidoModel.getA01_codigo());
            oCall.setDouble(5, da04_valor_item);
            oCall.execute();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public void removerPedido(PedidoModel oPedidoModel) {
        try {
            oCall = oConexaoMySql.oConnection.prepareCall("{CALL Proc_removerPedido(?)}");
            oCall.setInt(1, oPedidoModel.getA02_codigo());   
            oCall.execute();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public void excluirItemPedido(PedidoModel oPedidoModel, double da04_valor_item) {
        try {
            oCall = oConexaoMySql.oConnection.prepareCall("{CALL Proc_excluirItemPedido(?, ?, ?, ?, ?)}");
            oCall.setInt(1, oPedidoModel.getA02_codigo());
            oCall.setDate(2, oPedidoModel.getA02_data());
            oCall.setDouble(3, oPedidoModel.getA02_valor_total());
            oCall.setInt(4, oPedidoModel.getA01_codigo());
            oCall.setDouble(5, da04_valor_item);
            oCall.execute();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public PedidoModel buscarValorTotal(int ia02_codigo){
        try {
            oCall = oConexaoMySql.oConnection.prepareCall("{CALL Proc_buscarValorTotal(?)}");
            oCall.setInt(1, ia02_codigo);
            ResultSet rs = oCall.executeQuery();
            if (rs.next()) {
                int a02_codigo = rs.getInt("A02_codigo");
                java.sql.Date a02_data = rs.getDate("A02_data");
                double a02_valor_total = rs.getDouble("A02_valor_total");
                int a01_codigo = rs.getInt("A01_codigo");
                return new PedidoModel(a02_codigo, a02_data, a02_valor_total, a01_codigo);
                }
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return null;
    }
    
    public ClienteModel buscarCliente(int ia02_codigo){
        try {
            oCall = oConexaoMySql.oConnection.prepareCall("{CALL Proc_buscarClienteP(?)}");
            oCall.setLong(1, ia02_codigo);
            ResultSet rs = oCall.executeQuery();
            if (rs.next()) {
                int a01_codigo = rs.getInt("A01_codigo");
                String a01_nome = rs.getString("A01_nome");
                String a01_endereco = rs.getString("A01_endereco");
                long a01_telefone = rs.getLong("A01_telefone");
                long a01_cpf = rs.getLong("A01_cpf");
                java.sql.Date a01_data_nasc = rs.getDate("A01_data_nasc");
                String a01_email = rs.getString("A01_email");
                double a01_credito = rs.getDouble("A01_credito");
                return new ClienteModel(a01_codigo, a01_nome, a01_endereco, a01_telefone, a01_cpf, a01_data_nasc, a01_email, a01_credito);
                }
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return null;
    }
}
