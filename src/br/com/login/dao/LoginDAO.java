/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.login.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
    
    public void cadastrarUsuario(String nome, String email,String senha) throws SQLException{
        Connection conexao = new Conexao().getConnection();
        String sql = "INSERT INTO login (nome,email,senha) VALUES ('"+nome+"','"+email+"','"+senha+"')";
        System.out.println(sql);
        PreparedStatement statment = conexao.prepareStatement(sql);
        statment.execute();
        conexao.close();
        
    }
    
    public void login(String emai, String senha) throws SQLException{
        Connection conexao = new Conexao().getConnection();
        String sql = "SELECT email, senha FROM login WHERE email = '" +emai+ "' AND senha = '" +senha+ "'";
        System.out.println(sql);
        PreparedStatement statment = conexao.prepareStatement(sql);
        ResultSet rs= statment.executeQuery();
        
        if(rs.next()){
            System.out.println("Possui");
        } else {
            System.out.println("Nao Possui");
        }
                
        conexao.close();
    }
}
