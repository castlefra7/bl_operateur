/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operateur_bl;

import conn.ConnGen;
import gen.FctGen;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import mg.operateur.Credit;
import mg.operateur.Customer;
import mg.operateur.Deposit;
import mg.operateur.Fee;
import mg.operateur.Withdraw;

/**
 *
 * @author lacha
 */
public class Operateur_bl {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        
        Connection conn = null;
        try {
            /*** MOBILE MONEY ***/
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            conn = ConnGen.getConn();
            Customer manou = new Customer(2);

            /* DEPOSITS */
            Deposit deposit = new Deposit();
            deposit.setCreated_at(sdf.parse("16/03/2021 14:00"));
            deposit.setCustomer_id(2);
            deposit.setCustomer_source_id(2);
            deposit.setAmount(200);
            //manou.deposit(deposit, conn);
            
            /* WITHDRAW */
            Withdraw withdraw = new Withdraw();
            withdraw.setCreated_at(sdf.parse("16/03/2021 15:00"));
            withdraw.setAmount(150);
            withdraw.setCustomer_id(2);
            String pwd = "0108";
            //manou.withdraw(withdraw, pwd, conn);
            
            /* TRANSFER */
            //manou.transfer(150, pwd, sdf.parse("16/03/2021 15:00"), 1, conn);
            
            
            /*** CREDIT ***/
            Credit newCredit = new Credit();
            newCredit.setCustomer_id(2);
            newCredit.setAmount(1000);
            newCredit.setCustomer_source_id(2);
            newCredit.setCreated_at(sdf.parse("16/03/2021 18:00"));
            
            /* ACHAT DE CREDIT */
            //manou.buyCredit(newCredit, conn);
            
            /* Transfert de crédit */
            //manou.transferCredit(500, pwd, sdf.parse("16/03/2021 20:00"), 1, conn);
            
        } catch(Exception ex) {
            throw ex;
        } finally {
            if(conn!=null) conn.close();
        }
       
    }
    
}
