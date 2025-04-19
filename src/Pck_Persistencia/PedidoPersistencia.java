package Pck_Persistencia;

import Pck_Model.PedidoModel;
import Pck_DAO.ConexaoMySql;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class PedidoPersistencia{
    CallableStatement oCall;
    ConexaoMySql oConexaoMySql = new ConexaoMySql();

    public void inserirCliente(PedidoModel oPedidoModel) {
        try {
            if (oConexaoMySql.getConnection()) {
                oCall = oConexaoMySql.obj_connection.prepareCall("{CALL PROC_INSERIR_CLIENTE(?, ?, ?)}");
                oCall.setDate(1, oPedidoModel.getA02_data());
                oCall.setDouble(2, oPedidoModel.getA02_valor_total());
                oCall.setInt(3, oPedidoModel.getA01_codigo());
                oCall.execute();
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public void alterarCliente(PedidoModel oPedidoModel) {
        try {
            if (oConexaoMySql.getConnection()) {
                oCall = oConexaoMySql.obj_connection.prepareCall("{CALL PROC_ALTERAR_CLIENTE(?, ?, ?, ?)}");
                oCall.setInt(1, oPedidoModel.getA02_codigo());
                oCall.setDate(2, oPedidoModel.getA02_data());
                oCall.setDouble(3, oPedidoModel.getA02_valor_total());
                oCall.setInt(4, oPedidoModel.getA01_codigo());
                oCall.execute();
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public void removerCliente(PedidoModel oPedidoModel) {
        try {
            if (oConexaoMySql.getConnection()) {
                oCall = oConexaoMySql.obj_connection.prepareCall("{CALL PROC_EXCLUIR_CLIENTE(?)}");
                oCall.setInt(1, oPedidoModel.getA02_codigo());
                oCall.execute();
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
}
