/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basico;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author nobreack
 */
public class Escrita {
    
    public File arquivo;
    
    public void escreverNoArquivo() {
        try {
            this.arquivo = new File("LempelZiv.txt");
            FileWriter escrever = new FileWriter(arquivo);
            escrever.write("Lucas Lima Teste");
            escrever.flush();
        } catch (IOException ex) {
            System.err.println("Error: " + ex);
        }
    }
    
    public void criarTabelaAsciiArquivo() {
        try {
            this.arquivo = new File("TabelaAscii.txt");
            FileWriter fW = new FileWriter(this.arquivo);
            TabelaAscii tabela = new TabelaAscii();
            ArrayList tabelaAscii = tabela.gerarTabelaAscii(254);
            
            for (int i = 0; i < tabelaAscii.size(); i++) {
                String letra = (String) tabelaAscii.get(i);
                fW.append(letra + "\r\n");
                fW.flush();
            }
        } catch (IOException e) {
            System.err.println("Error: " + e);
        }
    }
}
