/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;


import form.FrmLogin;
import java.sql.SQLException;


/**
 *
 * @author Kuzner
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        FrmLogin frmLogin = new FrmLogin();
        frmLogin.setVisible(true);
    }
}
