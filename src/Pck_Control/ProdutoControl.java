package Pck_Control;

import Pck_Model.ProdutoModel; 
import Pck_Persistencia.ProdutoPersistencia; 

public class ProdutoControl {
    ProdutoModel oProdutoModel = new ProdutoModel(); 
    ProdutoPersistencia oProdutoPersistencia = new ProdutoPersistencia();  
    
    public void inserirProduto (String sa03_nome, double da03_valor_unitario, int ia03_estoque) { 
    oProdutoModel.setA03_nome(sa03_nome); 
    oProdutoModel.setA03_valor_unitario(da03_valor_unitario); 
    oProdutoModel.setA03_estoque(ia03_estoque); 
    oProdutoPersistencia.inserirProduto(oProdutoModel); 
    } 
    
    public void atualizarProduto(int ia03_codigo, String sa03_nome, double da03_valor_unitario, int ia03_estoque) { 
    oProdutoModel.setA03_codigo(ia03_codigo); 
    oProdutoModel.setA03_nome(sa03_nome); 
    oProdutoModel.setA03_valor_unitario(da03_valor_unitario); 
    oProdutoModel.setA03_estoque(ia03_estoque); 
    oProdutoPersistencia.alterarProduto (oProdutoModel); 
    } 
    
    public void removerProduto(int ia03_codigo) { 
    oProdutoModel.setA03_codigo(ia03_codigo); 
    oProdutoPersistencia.removerProduto(oProdutoModel); 
    } 
    
    public ProdutoModel buscarProduto(int ia03_codigo){
        return oProdutoPersistencia.buscarProduto(ia03_codigo); 
    }
    
    public void baixaEstoque(int ia02_codigo){
        oProdutoPersistencia.baixaEstoque(ia02_codigo);
    }
}
