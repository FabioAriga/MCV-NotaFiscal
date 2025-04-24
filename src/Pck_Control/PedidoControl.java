package Pck_Control;

import Pck_Model.PedidoModel; 
import Pck_Persistencia.PedidoPersistencia; 

public class PedidoControl {
    PedidoModel oPedidoModel = new PedidoModel(); 
    PedidoPersistencia oPedidoPersistencia = new PedidoPersistencia();  
    
    public int inserirPedido (java.sql.Date da02_data, double da02_valor_total, int ia01_codigo) { 
    oPedidoModel.setA02_data(da02_data); 
    oPedidoModel.setA02_valor_total(da02_valor_total); 
    oPedidoModel.setA01_codigo(ia01_codigo); 
    return oPedidoPersistencia.inserirPedido(oPedidoModel); 
    } 
    
    public void atualizarPedido(int ia02_codigo, java.sql.Date da02_data, double da02_valor_total, int ia01_codigo, double da04_valor_item) { 
    oPedidoModel.setA02_codigo(ia02_codigo); 
    oPedidoModel.setA02_data(da02_data); 
    oPedidoModel.setA02_valor_total(da02_valor_total); 
    oPedidoModel.setA01_codigo(ia01_codigo); 
    oPedidoPersistencia.alterarPedido(oPedidoModel, da04_valor_item); 
    } 
    
    public void removerPedido(int ia02_codigo) { 
    oPedidoModel.setA02_codigo(ia02_codigo); 
    oPedidoPersistencia.removerPedido(oPedidoModel); 
    } 
    
    public void excluirItemPedido(int ia02_codigo, java.sql.Date da02_data, double da02_valor_total, int ia01_codigo, double da04_valor_item) { 
    oPedidoModel.setA02_codigo(ia02_codigo); 
    oPedidoModel.setA02_data(da02_data); 
    oPedidoModel.setA02_valor_total(da02_valor_total); 
    oPedidoModel.setA01_codigo(ia01_codigo); 
    oPedidoPersistencia.excluirItemPedido(oPedidoModel, da04_valor_item); 
    } 
}
