/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compressao;

import java.util.ArrayList;

/**
 * @author Lucas
 */
public class TratarCompressao {
    
    ArrayList<String> linhas = new ArrayList();
    String palavra;
    ArrayList<String> cadeiaStrings = new ArrayList();
    String caracters;

    public ArrayList getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList<String> linhas) {
        this.linhas = linhas;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public ArrayList<String> getCadeiaStrings() {
        return cadeiaStrings;
    }

    public void setCadeiaStrings(ArrayList<String> cadeiaStrings) {
        this.cadeiaStrings = cadeiaStrings;
    }

    public String getCaracters() {
        return caracters;
    }

    public void setCaracters(String caracters) {
        this.caracters = caracters;
    }
    
    public void pegarLinhaAtual() {
        for (int i = 0; i < 1; i++) {
            this.setCaracters(linhas.get(i));
        }
    }
    
    public void separarLinhaEmCadeias() {
        for (int i = 0; i < this.getCaracters().length(); i++) {
            this.setPalavra(this.getCaracters().substring(0, i));
        }
    }
}
