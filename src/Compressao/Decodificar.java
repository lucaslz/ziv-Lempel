/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compressao;

import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class Decodificar {
    public ArrayList<String> dicionario = new ArrayList();
    public ArrayList<String> textoCompactador = new ArrayList();

    public ArrayList<String> getDicionario() {
        return dicionario;
    }

    public void setDicionario(ArrayList<String> dicionario) {
        this.dicionario = dicionario;
    }

    public ArrayList<String> getTextoCompactador() {
        return textoCompactador;
    }

    public void setTextoCompactador(ArrayList<String> textoCompactador) {
        this.textoCompactador = textoCompactador;
    }
    
    
    
}
