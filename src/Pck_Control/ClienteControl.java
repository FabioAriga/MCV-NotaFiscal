package Pck_Control;

import Pck_Model.ClienteModel; 
import Pck_Persistencia.ClientePersistencia; 

public class ClienteControl {
    ClienteModel oClienteModel = new ClienteModel(); 
    ClientePersistencia oClientePersistencia = new ClientePersistencia();  
    
    public void inserirCliente (String sa01_nome, String sa01_endereco, long la01_telefone, long la01_cpf, java.sql.Date da01_data_nasc, String sa01_email, double da01_credito) { 
    oClienteModel.setA01_nome(sa01_nome); 
    oClienteModel.setA01_endereco(sa01_endereco); 
    oClienteModel.setA01_telefone(la01_telefone); 
    oClienteModel.setA01_cpf(la01_cpf); 
    oClienteModel.setA01_data_nasc(da01_data_nasc); 
    oClienteModel.setA01_email(sa01_email); 
    oClienteModel.setA01_credito(da01_credito); 
    oClientePersistencia.inserirCliente(oClienteModel); 
    } 
    
    public void atualizarCliente(int ia01_codigo, String sa01_nome, String sa01_endereco, long la01_telefone, long la01_cpf, java.sql.Date da01_data_nasc, String sa01_email, double da01_credito) { 
    oClienteModel.setA01_codigo(ia01_codigo); 
    oClienteModel.setA01_nome(sa01_nome); 
    oClienteModel.setA01_endereco(sa01_endereco); 
    oClienteModel.setA01_telefone(la01_telefone); 
    oClienteModel.setA01_cpf(la01_cpf); 
    oClienteModel.setA01_data_nasc(da01_data_nasc); 
    oClienteModel.setA01_email(sa01_email); 
    oClienteModel.setA01_credito(da01_credito); 
    oClientePersistencia.alterarCliente(oClienteModel); 
    } 
    
    public void removerCliente(int ia01_codigo) { 
    oClienteModel.setA01_codigo(ia01_codigo); 
    oClientePersistencia.removerCliente(oClienteModel); 
    } 
    
    public ClienteModel buscarCliente(long la01_cpf){
        return oClientePersistencia.buscarCliente(la01_cpf); 
    }
    
    public double buscarCredito(long la01_cpf){
        return oClientePersistencia.buscarCredito(la01_cpf); 
    }
    
    public void atualizarCredito(long la01_cpf, double da01_credito){
        oClientePersistencia.atualizarCredito(la01_cpf, da01_credito);
    }
}
