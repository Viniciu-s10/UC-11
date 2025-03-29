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
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author vinic
 */
public class ProdutosDAO {
    
    Connection c;
     PreparedStatement statement;
    ResultSet set;
    
    private Conexao conexao;
     private String sql=null;
     
     public ProdutosDAO() {
        this.conexao= new Conexao();
         this.c= this.conexao.conectar();
    }
    
    ArrayList<Produtos> lista= new ArrayList<>();
    
    public void cadastrar(Produtos p){
        sql= "insert into produtos(nome, valor) values"+"(?,?)";
        
        try{
            statement= this.c.prepareStatement(sql);
             statement.setString(1, p.getNome());
              statement.setDouble(2, p.getValor());
              
            statement.execute();
            
            JOptionPane.showMessageDialog(null, "Produto Cadastrado com Sucesso\n"
                    + "Nome: "+p.getNome()+"\nValor: "+p.getValor());
        }catch(SQLException e){
            System.out.println("erro ao tentar cadastrar\n"+e.getMessage());
             JOptionPane.showMessageDialog(null, "Ocorreu um Erro ao Tentar Cadastrar Produto");
        }
    }
    
    public ArrayList listar(){
        return lista;
    }
}
