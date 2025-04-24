package Pck_Persistencia;

import Pck_Model.ItemModel;
import Pck_DAO.ConexaoMySql;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class ItemPersistencia {
    CallableStatement oCall;
    ConexaoMySql oConexaoMySql = new ConexaoMySql();

    public void inserirItem(ItemModel oItemModel) {
        try {
            oCall = oConexaoMySql.obj_connection.prepareCall("{CALL Proc_inserirItem(?, ?, ?, ?)}");
            oCall.setInt(1, oItemModel.getA03_codigo());
            oCall.setInt(2, oItemModel.getA02_codigo());
            oCall.setInt(3, oItemModel.getA04_quantidade());
            oCall.setDouble(4, oItemModel.getA04_valor_item());
            oCall.execute();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public void alterarItem(ItemModel oItemModel) {
        try {
            oCall = oConexaoMySql.obj_connection.prepareCall("{CALL Proc_alterarItem(?, ?, ?, ?, ?)}");
            oCall.setInt(1, oItemModel.getA04_codigo());
            oCall.setInt(2, oItemModel.getA03_codigo());
            oCall.setInt(3, oItemModel.getA02_codigo());
            oCall.setInt(4, oItemModel.getA04_quantidade());
            oCall.setDouble(5, oItemModel.getA04_valor_item());
            oCall.execute();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public void removerItem(ItemModel oItemModel) {
        try {
            oCall = oConexaoMySql.obj_connection.prepareCall("{CALL Proc_removerItem(?, ?)}");
            oCall.setInt(1, oItemModel.getA03_codigo());
            oCall.setInt(2, oItemModel.getA02_codigo());
            oCall.execute();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public double somarValores(int id_pedido) {
        double valor_total = 0;
        try {
            if (oConexaoMySql.getConnection()) {
                CallableStatement oCall = oConexaoMySql.obj_connection.prepareCall("{CALL Proc_somarValorTotalItens(?, ?)}");
                oCall.setInt(1, id_pedido);
                oCall.registerOutParameter(2, java.sql.Types.DOUBLE);
                oCall.execute();
                valor_total = oCall.getDouble(2);
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return valor_total;
    }
}
