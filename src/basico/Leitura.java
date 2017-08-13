/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nobreack
 */
public class Leitura {
    
    /**
     * @var file arquivo que desejo comprimir
     */
    public File arquivo;
    /**
     * @var lempelZiv 
     */
    public LempelZiv lempelZiv;
    
    /**
     * Leitura de qualquer arquivo de texto
     * @param nomeArquivo
     * @return lempelZiv
     */
    public LempelZiv lerArquivo (String nomeArquivo) {
        
        this.arquivo = new File(nomeArquivo);
        
        try {
            FileReader ler = new FileReader(this.arquivo);
            BufferedReader bufferedLeitura = new BufferedReader(ler);
            
            //Lendo a primeira linha
            String linha = "";
            ArrayList<String> arrayArquivo = new ArrayList<>();
            ArrayList arrayArquivoVetor = new ArrayList<>();
            char letra;
            
            while (linha != null) {
                linha = bufferedLeitura.readLine();                    
                arrayArquivo.add(linha);
            }
            
            for (int i = 0; i < arrayArquivo.size(); i++) {
                if (arrayArquivo.get(i) == null) {
                    arrayArquivo.remove(i);
                }
            }
            
            for (int i = 0; i < arrayArquivo.size(); i++) {
                for (int j = 0; j < arrayArquivo.get(i).length(); j++) {
                    letra = arrayArquivo.get(i).charAt(j);
                    arrayArquivoVetor.add(letra);
                }
                arrayArquivoVetor.add("|");
            }
            System.out.println(arrayArquivoVetor);
//           this.lempelZiv = new LempelZiv(arrayArquivo.size(), arrayArquivo);

        } catch (FileNotFoundException e) {
            System.err.println("Erro: " + e.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(Leitura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.lempelZiv;
    }
}
