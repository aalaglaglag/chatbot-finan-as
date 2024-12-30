/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.login.controller;

import br.com.login.dao.Conexao;
import br.com.login.dao.LoginDAO;
import br.com.login.view.CadastroView;
import br.com.login.view.LoginView;
import java.sql.Connection;
import java.sql.SQLException;



/**
 *
 * @author giovanni
 */
public class LoginController {
    
    public void CadastroUsuario(CadastroView view) throws SQLException{
        
        Connection conexao = new Conexao().getConnection();
        LoginDAO cadastro = new LoginDAO();
        cadastro.cadastrarUsuario(view.getjTextFieldNome().getText(),
                                  view.getjTextFieldEmail().getText(),
                                  view.getjPasswordFieldSenha().getText());
    }
    
    public void LoginUsuario(LoginView view) throws SQLException{
        
        Connection conexao = new Conexao().getConnection();
        LoginDAO login = new LoginDAO();
        login.login(view.getjTextFieldLogin().getText(), view.getjPasswordFieldSenha().getText());
    }
    
}
