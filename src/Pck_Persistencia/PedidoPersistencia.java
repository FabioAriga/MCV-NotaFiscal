package Pck_Persistencia;

import Pck_Model.PedidoModel;
import Pck_DAO.ConexaoMySql;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class PedidoPersistencia{
    CallableStatement oCall;
    ConexaoMySql oConexaoMySql = new ConexaoMySql();

    public int inserirPedido(PedidoModel oPedidoModel) {
        int codigo_pedido = -1;
        try {
            if (oConexaoMySql.getConnection()) {
                oCall = oConexaoMySql.obj_connection.prepareCall("{CALL Proc_inserirPedido(?, ?, ?, ?)}");
                oCall.setDate(1, oPedidoModel.getA02_data());
                oCall.setDouble(2, oPedidoModel.getA02_valor_total());
                oCall.setInt(3, oPedidoModel.getA01_codigo());
                oCall.registerOutParameter(4, java.sql.Types.INTEGER);
                oCall.execute();
                codigo_pedido = oCall.getInt(4);
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return codigo_pedido;
    }
    
    public void alterarPedido(PedidoModel oPedidoModel, double da04_valor_item) {
        try {
            if (oConexaoMySql.getConnection()) {
                oCall = oConexaoMySql.obj_connection.prepareCall("{CALL Proc_alterarPedido(?, ?, ?, ?, ?)}");
                oCall.setInt(1, oPedidoModel.getA02_codigo());
                oCall.setDate(2, oPedidoModel.getA02_data());
                oCall.setDouble(3, oPedidoModel.getA02_valor_total());
                oCall.setInt(4, oPedidoModel.getA01_codigo());
                oCall.setDouble(5, da04_valor_item);
                oCall.execute();
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public void removerPedido(PedidoModel oPedidoModel) {
        try {
            if (oConexaoMySql.getConnection()) {
                oCall = oConexaoMySql.obj_connection.prepareCall("{CALL Proc_removerPedido(?)}");
                oCall.setInt(1, oPedidoModel.getA02_codigo());
                oCall.execute();
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
}
