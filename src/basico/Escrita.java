/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basico;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nobreack
 */
public class Escrita {
    
    public File arquivo = new File("LempelZiv.txt");
    
    public void escreverNoArquivo() {
        try {
            FileWriter escrever = new FileWriter(arquivo);
            BufferedWriter bufferedEscrita = new BufferedWriter(escrever);
            bufferedEscrita.write("Teste");
            bufferedEscrita.newLine();
            bufferedEscrita.write("Teste");
            bufferedEscrita.newLine();
            bufferedEscrita.write("Teste");
            bufferedEscrita.newLine();
            bufferedEscrita.write("Teste");
            bufferedEscrita.newLine();            
        } catch (IOException ex) {
            Logger.getLogger(Escrita.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
