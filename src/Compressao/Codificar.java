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
public class Codificar {

    public ArrayList<String> index = new ArrayList();
    public ArrayList<String> codigicacao = new ArrayList();
    public ArrayList<String> arrayLista = new ArrayList();
    public ArrayList<String> auxiliaDicionario = new ArrayList();

    public Codificar() {

    }

    public ArrayList<String> getIndex() {
        return index;
    }

    public void setIndex(ArrayList<String> index) {
        this.index = index;
    }

    public ArrayList<String> getCodigicacao() {
        return codigicacao;
    }

    public void setCodigicacao(ArrayList<String> codigicacao) {
        this.codigicacao = codigicacao;
    }

    public ArrayList<String> getArrayLista() {
        return arrayLista;
    }

    public void setArrayLista(ArrayList<String> arrayLista) {
        this.arrayLista = arrayLista;
    }

    public ArrayList<String> getAuxiliaDicionario() {
        return auxiliaDicionario;
    }

    public void setAuxiliaDicionario(ArrayList<String> auxiliaDicionario) {
        this.auxiliaDicionario = auxiliaDicionario;
    }
    
    public void indexarStrings() {
        for (int i = 0; i < this.getArrayLista().size(); i++) {
            for (int j = 0; j < this.getArrayLista().get(i).length(); j++) {
                if (this.getArrayLista().get(i).substring(0, j).charAt(this.getArrayLista().get(i).length() - 1) == '|') {
                    this.getIndex().add(this.getArrayLista().get(i).substring(0, j));
                }
            }
        }
    }

    public void codificarStrings() {
        String palavra;
        for (int i = 0; i < this.getIndex().size(); i++) {
            for (int j = 0; j < this.getIndex().get(i).length(); j++) {
                int tamanho = this.getIndex().get(i).length() - 1;
                if (i == 0) {
                    if ("|".equals(this.getIndex().get(i).substring(0, tamanho))) {
                        palavra = this.getIndex().get(i).substring(0, tamanho - 1);
                        this.auxiliaDicionario.add(palavra);
                    }
                }
                if (this.getIndex().get(i).substring(0, tamanho).equals("|")) {
                    palavra = this.getIndex().get(i);
                    for (int k = 0; k < palavra.length(); k++) {
                        for (int l = 0; l < this.getAuxiliaDicionario().size(); l++) {
                            if (this.getAuxiliaDicionario().get(l).equals(palavra.substring(0, k))) {
//                                if (palavra.substring(0, k + 2)) {
                                    
//                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
