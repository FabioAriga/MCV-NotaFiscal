package Pck_Model;

public class PedidoModel {
    private int a02_codigo;
    private java.sql.Date a02_data;
    private double a02_valor_total;
    private int a01_codigo;

    public int getA02_codigo() {
        return a02_codigo;
    }
    public java.sql.Date getA02_data() {
        return a02_data;
    }
    public double getA02_valor_total() {
        return a02_valor_total;
    }
    public int getA01_codigo() {
        return a01_codigo;
    }

    public void setA02_codigo(int a02_codigo) {
        this.a02_codigo = a02_codigo;
    }
    public void setA02_data(java.sql.Date a02_data) {
        this.a02_data = a02_data;
    }
    public void setA02_valor_total(double a02_valor_total) {
        this.a02_valor_total = a02_valor_total;
    }
    public void setA01_codigo(int a01_codigo) {
        this.a01_codigo = a01_codigo;
    }
}
