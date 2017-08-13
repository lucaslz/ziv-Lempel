/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basico;

import java.util.ArrayList;

/**
 *
 * @author nobreack
 */
public class LempelZiv {
    
    public Integer quantidadeLinhas;
    public ArrayList<String> arrayArquivoReal;
    public Integer tamanhoTotal;
    
    public LempelZiv () {
        
    }
 
    public LempelZiv (Integer quantide, ArrayList<String> linhas, Integer tamanho) {
        this.arrayArquivoReal = linhas;
        this.quantidadeLinhas = quantide;
        this.tamanhoTotal = tamanho;
    }

    LempelZiv(int size, ArrayList<String> arrayArquivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
