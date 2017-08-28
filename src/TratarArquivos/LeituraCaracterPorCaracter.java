/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TratarArquivos;

import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class LeituraCaracterPorCaracter {
    
    public String conjuntoCaracter;
    public String conjuntoAInserir;
    public LeituraArquivo lerArquivo;

    public String getConjuntoCaracter() {
        return conjuntoCaracter;
    }

    public void setConjuntoCaracter(String conjuntoCaracter) {
        this.conjuntoCaracter = conjuntoCaracter;
    }
    
    public void setConjuntoCaracterMais(String conjuntoCaracter) {
        this.conjuntoCaracter += conjuntoCaracter;
    }
    
    public String getConjuntoAInserir() {
        return conjuntoAInserir;
    }

    public void setConjuntoAInserir(String conjuntoAInserir) {
        this.conjuntoAInserir = conjuntoAInserir;
    }

    public LeituraArquivo getLerArquivo() {
        return lerArquivo;
    }

    public void setLerArquivo(LeituraArquivo lerArquivo) {
        this.lerArquivo = lerArquivo;
    }
    
    public String pegarCaracterComparar() {
        for (int i = 0; i < lerArquivo.linhas.size(); i++) {
            for (int j = 0; j < lerArquivo.linhas.get(i).length(); j++) {
                if (lerArquivo.linhas.get(i).substring(0, j).charAt(lerArquivo.linhas.get(i).length()-1) != '|') {
                    this.setConjuntoCaracterMais(lerArquivo.linhas.get(i).substring(0, j));                    
                }
         
                if (!this.getConjuntoCaracter().equals(conjuntoAInserir)) {
                   return this.getConjuntoCaracter();
                }                
            }
        }
        return "";
    }
    
    public String pegarParteString(int numeroCaracter) {
        
        String palavra = null;
        
        for (int i = 0; i < lerArquivo.linhas.size(); i++) {
            for (int j = 0; j < lerArquivo.linhas.get(i).length(); j++) {
                if (numeroCaracter == j) {
                    if (lerArquivo.linhas.get(i).length() > j++) {
                        palavra = this.getLerArquivo().linhas.get(i).substring(0, j++);
                        break;
                    }
                }
            }
        }
        return palavra;
    }
}
