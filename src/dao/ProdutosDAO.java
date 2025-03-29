/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexao.Conexao;
import construtores.Produtos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
/**
 *
 * @author vinic
 */
public class ProdutosDAO {
    
    Connection c;
     PreparedStatement statement;
    ResultSet set;
    
    ArrayList<Produtos> lista= new ArrayList<>();
    
    public void cadsatrar(Produtos p){
        Conexao c= new Conexao();
         c.conectar();
    }
    
    public ArrayList listar(){
        return lista;
    }
}
