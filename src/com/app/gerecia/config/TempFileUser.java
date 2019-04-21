/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.gerecia.config;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rique
 */
public class TempFileUser {

    static private String pathFile;
    static private String pathFile2;
    static private String currentUser;
    static private String currentOrder;
    
    public void tempWriterUser(String user) {
        try {
            File tempFile = File.createTempFile("user", ".tmp");
            System.out.println("Temp file On Default Location: " + tempFile.getAbsolutePath());
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {
                bw.write(user);
            }
            pathFile = tempFile.getAbsolutePath();
            tempFile.deleteOnExit();
        } catch (IOException e) {
        }
    }
    
    public String tempReadUser(){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(pathFile));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TempFileUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            currentUser = reader.readLine();
            reader.close();
            return currentUser;
        } catch (IOException ex) {
            Logger.getLogger(TempFileUser.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return null;
    }
    
    public void tempWriterOrder(String idOrder) {
        try {
            File tempFile = File.createTempFile("order", ".tmp");
            System.out.println("Temp file On Default Location: " + tempFile.getAbsolutePath());
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {
                bw.write(idOrder);
            }
            pathFile2 = tempFile.getAbsolutePath();
            tempFile.deleteOnExit();
        } catch (IOException e) {
        }
    }
    
    public String tempReadOrder(){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(pathFile2));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TempFileUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            currentOrder = reader.readLine();
            reader.close();
            return currentOrder;
        } catch (IOException ex) {
            Logger.getLogger(TempFileUser.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return null;
    }
}
