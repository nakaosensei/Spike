package br.com.model;

import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;

/**
 * @author Nakao
 */
public class Arquivo {
    
    public static String lerArquivo(String path){
        
        FileReader arq;
        BufferedReader buff;            
        String out="";
        try {
            arq = new FileReader (path);
            buff = new BufferedReader(arq);
            while (buff.ready()){
                out+=(buff.readLine())+"\n";                
            }
            buff.close();
            return out;
        }catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao abrir arquivo");
            return "";
        }
        
    }
}
