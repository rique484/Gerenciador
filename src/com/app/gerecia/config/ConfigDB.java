/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.gerecia.config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rique
 */
public class ConfigDB {
    private String caminho = "";

    //conString
    public Connection conector(){  
      getConfig();
      java.sql.Connection conexao = null;
      String driver = "com.mysql.jdbc.Driver";
      String url="jdbc:mysql:"+caminho+"/dbcentral";
      String user="root";
      String password="";
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            System.out.println("OK");
            return conexao;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            return null;
        }
    }
    public static boolean setConfig(String Texto){
        try {
            FileWriter arq = new FileWriter("conf.con");
            try (PrintWriter gravarArq = new PrintWriter(arq)) {
                gravarArq.println(Texto);
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    } 
    public void getConfig(){
        try{
            FileReader arq = new FileReader("conf.con");
            BufferedReader lerArq = new BufferedReader(arq);
            String linha="";
        try{
        linha = lerArq.readLine();
        while(linha!=null){
        caminho+=linha;
        linha = lerArq.readLine();
        }
        arq.close();
        }catch(IOException e){
            Boolean erro = true; 
        }
            }catch(FileNotFoundException e){
            Boolean erro = true; 
            }  
    }
}
