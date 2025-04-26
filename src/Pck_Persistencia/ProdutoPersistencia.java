package Pck_Persistencia;

import Pck_Model.ProdutoModel;
import Pck_DAO.ConexaoMySql;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ProdutoPersistencia {
    CallableStatement oCall;
    ConexaoMySql oConexaoMySql = new ConexaoMySql();

    public void inserirProduto(ProdutoModel oProdutoModel) {
        try {
            oCall = oConexaoMySql.oConnection.prepareCall("{CALL Proc_inserirProduto(?, ?, ?)}");
            oCall.setString(1, oProdutoModel.getA03_nome());
            oCall.setDouble(2, oProdutoModel.getA03_valor_unitario());
            oCall.setInt(3, oProdutoModel.getA03_estoque());
            oCall.execute();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public void alterarProduto(ProdutoModel oProdutoModel) {
        try {
            oCall = oConexaoMySql.oConnection.prepareCall("{CALL Proc_alterarProduto(?, ?, ?, ?)}");
            oCall.setInt(1, oProdutoModel.getA03_codigo());
            oCall.setString(1, oProdutoModel.getA03_nome());
            oCall.setDouble(2, oProdutoModel.getA03_valor_unitario());
            oCall.setInt(3, oProdutoModel.getA03_estoque());
            oCall.execute();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public void removerProduto(ProdutoModel oProdutoModel) {
        try {
            oCall = oConexaoMySql.oConnection.prepareCall("{CALL Proc_removerProduto(?)}");
            oCall.setInt(1, oProdutoModel.getA03_codigo());
            oCall.execute();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public ProdutoModel buscarProduto(int ia03_codigo) {
        try {
            oCall = oConexaoMySql.oConnection.prepareCall("{CALL Proc_buscarProduto(?)}");
            oCall.setInt(1, ia03_codigo);
            ResultSet rs = oCall.executeQuery();
            if (rs.next()) {
                String a03_nome = rs.getString("A03_nome");
                Double a03_valor_unitario = rs.getDouble("A03_valor_unitario");
                int a03_estoque = rs.getInt("A03_estoque");
                return new ProdutoModel(ia03_codigo, a03_nome, a03_valor_unitario, a03_estoque);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void baixaEstoque(int ia02_codigo){
        try {
            oCall = oConexaoMySql.oConnection.prepareCall("{CALL Proc_removerProduto(?)}");
            oCall.setInt(1, ia02_codigo);
            oCall.execute();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
}
