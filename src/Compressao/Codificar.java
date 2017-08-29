/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compressao;

import TratarArquivos.EscrituraArquivo;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class Codificar {

    public ArrayList<String> index = new ArrayList();
    public ArrayList<String> codigicacao = new ArrayList();
    public ArrayList<String> arrayLista = new ArrayList();
    public ArrayList<String> arrayAIndexar = new ArrayList();
    public String parteString;

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

    public ArrayList<String> getArrayAIndexar() {
        return arrayAIndexar;
    }

    public void setArrayAIndexar(ArrayList<String> arrayAIndexar) {
        this.arrayAIndexar = arrayAIndexar;
    }

    public void particionarListaStrings() {
        for (int i = 0; i < this.getArrayLista().size(); i++) {
            for (int j = 0; j < this.getArrayLista().get(i).length() + 1; j++) {
                String palavra = this.getArrayLista().get(i).substring(0, j);
                int total = this.getArrayAIndexar().size();
                boolean teste = false;
                if (!palavra.isEmpty()) {
                    if (this.getArrayAIndexar().contains(palavra)) {
                        teste = true;
                    }
                    if (teste == false) {
                        this.getArrayAIndexar().add(palavra);
                    }
                }
            }
        }
    }

    public void escreverStringsParticionadas(EscrituraArquivo eA) {
        for (int i = 0; i < this.getArrayAIndexar().size(); i++) {
            eA.setParteString(this.getArrayAIndexar().get(i) + "|");
            eA.verificaSeArquivoExiste();
            eA.escreverEmArquivo();
        }
    }

    public void indexarStrings() {
        int inicio = 0;
        for (int i = 0; i < this.getArrayLista().size(); i++) {
            for (int j = 0; j < this.getArrayLista().get(i).length(); j++) {
                String palavraCerta = this.getArrayLista().get(i).substring(inicio, j);
                String palavraTeste = this.getArrayLista().get(i).substring(inicio, j + 1);
                if (palavraTeste.indexOf("|") != -1) {
                    this.getIndex().add(palavraCerta);
                    inicio = j + 1;
                }
            }
        }
    }

    public int verificaSeContemString(String palavra) {
        for (int i = 0; i < this.getIndex().size(); i++) {
            if (this.getIndex().get(i).equals(palavra)) {
                return i + 1;
            }
        }
        return -1;
    }

    public void codificarStrings() {
        for (int i = 0; i < this.getIndex().size(); i++) {
            int total = this.getIndex().get(i).length();
            String palavra = this.getIndex().get(i).substring(0, total - 1);
            int retorno = verificaSeContemString(palavra);
            String palavraCodificada = "";
            if (retorno != -1 && palavra.length() > 1) {
                palavraCodificada = this.getIndex().get(i).substring(total - 1, total);
                this.getCodigicacao().add(retorno + palavraCodificada);
            } else {
                if (palavra.length() == 1) {
                    this.getCodigicacao().add(0 + palavra);
                }
            }
        }
    }

    public void escreverStringsCodificadas(EscrituraArquivo eA) {
        for (int i = 0; i < this.getCodigicacao().size(); i++) {
            eA.setParteString(this.getCodigicacao().get(i) + "|");
            eA.verificaSeArquivoExiste();
            eA.escreverEmArquivo();
        }
    }
}
