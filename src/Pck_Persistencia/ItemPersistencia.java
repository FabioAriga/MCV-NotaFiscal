package Pck_Persistencia;

import Pck_Model.ItemModel;
import Pck_Model.ItemProdutoModel;
import Pck_DAO.ConexaoMySql;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemPersistencia {
    CallableStatement oCall;
    ConexaoMySql oConexaoMySql = new ConexaoMySql();

    public void inserirItem(ItemModel oItemModel) {
        try {
            oCall = oConexaoMySql.oConnection.prepareCall("{CALL Proc_inserirItem(?, ?, ?, ?)}");
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
            oCall = oConexaoMySql.oConnection.prepareCall("{CALL Proc_alterarItem(?, ?, ?, ?, ?)}");
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
            oCall = oConexaoMySql.oConnection.prepareCall("{CALL Proc_removerItem(?, ?)}");
            oCall.setInt(1, oItemModel.getA03_codigo());
            oCall.setInt(2, oItemModel.getA02_codigo());
            oCall.execute();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public double somarValores(int ia02_codigo) {
        double a02_valor_total = 0;
        try {
            oCall = oConexaoMySql.oConnection.prepareCall("{CALL Proc_somarValorTotal(?, ?)}");
            oCall.setInt(1, ia02_codigo);
            oCall.registerOutParameter(2, java.sql.Types.DOUBLE);
            oCall.execute();
            a02_valor_total = oCall.getDouble(2);
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return a02_valor_total;
    }
    
    public List<ItemProdutoModel> listarItens(int ia02_codigo) {
    List<ItemProdutoModel> lista = new ArrayList<>();
    try {
        oCall = oConexaoMySql.oConnection.prepareCall("{CALL Proc_listarItens(?)}");
        oCall.setInt(1, ia02_codigo);
        ResultSet rs = oCall.executeQuery();
        while (rs.next()) {
            ItemProdutoModel item = new ItemProdutoModel();
            item.setA04_codigo(rs.getInt("A04_codigo"));
            item.setA03_codigo(rs.getInt("A03_codigo"));
            item.setA03_nome(rs.getString("A03_nome"));
            item.setA03_valor_unitario(rs.getDouble("A03_valor_unitario"));
            item.setA04_quantidade(rs.getInt("A04_quantidade"));
            item.setA04_valor_item(rs.getDouble("A04_valor_item"));
            lista.add(item);
        }
    } catch (SQLException erro) {
        erro.printStackTrace();
    }
    return lista;
}
}
