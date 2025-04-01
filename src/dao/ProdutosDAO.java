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
        sql= "select*from produtos";
        
        try{
            statement= this.c.prepareStatement(sql);
            
            set= statement.executeQuery();
            
           while(set.next()){
               Produtos p= new Produtos();
               
                p.setId(set.getInt("ID"));
                 p.setNome(set.getString("Nome"));
                  p.setValor(set.getDouble("Valor"));
                 p.setStatus(set.getString("Status"));
                 
                 lista.add(p);
           }
           return lista;
        }catch(SQLException e){
            return null;
        }
    }
    
    public void vender(int id){
        sql = "update produtos set status= 'Vendido' where id= ? and status= 'A Venda'";
        
        try{
            statement = this.c.prepareStatement(sql);
            
            statement.setInt(1, id);
            
            int linhas= statement.executeUpdate();
             Produtos p= new Produtos();
            
            if (linhas> 0){
                JOptionPane.showMessageDialog(null, "Produto Vendido com Sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "Produto não pode ser Vendido!");
            }
        }catch(SQLException e){
            System.out.println("Erro ao tentar vender\n" + e.getMessage());
             JOptionPane.showMessageDialog(null, "Ocorreu um Erro ao Tentar Executar "
                     + "Venda!");
    }  
}
    
    public void listarVendidos(){
     sql= "select*from produtos where status= 'Vendido'";
     
     try{
         statement= this.c.prepareStatement(sql);
         
         set= statement.executeQuery();
         
         while(set.next()){
               Produtos p= new Produtos();
               
                p.setId(set.getInt("ID"));
                 p.setNome(set.getString("Nome"));
                  p.setValor(set.getDouble("Valor"));
                 p.setStatus(set.getString("Status"));
                 
                 lista.add(p);
           }
     }catch(SQLException e){
         System.out.println("erro ao tentar listar\n"+e.getMessage());
     }
    }
}
