package prj_nota;

import Pck_View.InicialView;

public class Prj_Nota {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicialView().setVisible(true);
            }
        });
    }
}
