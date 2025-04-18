package Pck_Control;

import Pck_Model.ItemModel; 
//import Pck_Persistencia.ItemPersistencia; 

public class ItemControl {
    ItemModel oItemModel = new ItemModel(); 
    //ProdutoPersistencia oProdutoPersistencia = new ProdutoPersistencia();  
    
    public void inserirItem (int ia03_codigo, int ia02_codigo, int ia04_quantidade, double da04_valor_item) { 
    oItemModel.setA03_codigo(ia03_codigo); 
    oItemModel.setA02_codigo(ia02_codigo); 
    oItemModel.setA04_quantidade(ia04_quantidade); 
    oItemModel.setA04_valor_item(da04_valor_item); 
    //oItemPersistencia.inserirItem(oItemModel); 
    } 
    
    public void atualizarItem(int ia04_codigo, int ia03_codigo, int ia02_codigo, int ia04_quantidade, double da04_valor_item) { 
    oItemModel.setA04_codigo(ia04_codigo); 
    oItemModel.setA03_codigo(ia03_codigo); 
    oItemModel.setA02_codigo(ia02_codigo); 
    oItemModel.setA04_quantidade(ia04_quantidade); 
    oItemModel.setA04_valor_item(da04_valor_item); 
    //oItemPersistencia.alterarItem (oItemModel); 
    } 
    
    public void removerItem(int ia04_codigo) { 
    oItemModel.setA04_codigo(ia04_codigo); 
    //oItemPersistencia.removerItem(oPItemModel); 
    } 
}
