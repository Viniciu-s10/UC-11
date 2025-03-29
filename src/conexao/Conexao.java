/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author vinic
 */
public class Conexao {
    Connection c;
    
    public Connection conectar(){
        try{
            c= DriverManager.getConnection("jdbc:mysql://localhost/uc11","root", 
                    "R2d2/bb80");
            return c;
        }catch(SQLException e){
            System.out.println("erro ao tentar conectar\n"+e.getMessage());
            return null;
        }
    }
}
