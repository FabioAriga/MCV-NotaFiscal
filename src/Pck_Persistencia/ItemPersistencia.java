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
            oCall = oConexaoMySql.obj_connection.prepareCall("{CALL PROC_INSERIR_CLIENTE(?, ?, ?, ?)}");
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
            oCall = oConexaoMySql.obj_connection.prepareCall("{CALL PROC_ALTERAR_CLIENTE(?, ?, ?, ?, ?)}");
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
            oCall = oConexaoMySql.obj_connection.prepareCall("{CALL PROC_EXCLUIR_CLIENTE(?)}");
            oCall.setInt(1, oItemModel.getA04_codigo());
            oCall.execute();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
}
