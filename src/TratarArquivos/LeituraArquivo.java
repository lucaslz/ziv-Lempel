/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TratarArquivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * @author Lucas
 */
public class LeituraArquivo {

    public String nomeArquivo;
    public File abrirArquivo;
    public FileReader fr;
    public BufferedReader br;
    public ArrayList<String> linhas = new ArrayList();

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public File getAbrirArquivo() {
        return abrirArquivo;
    }
    
    public void setAbrirArquivo(File abrirArquivo) {
        this.abrirArquivo = abrirArquivo;
    }

    public FileReader getFr() {
        return fr;
    }

    public void setFr(FileReader fr) {
        this.fr = fr;
    }

    public BufferedReader getBr() {
        return br;
    }

    public void setBr(BufferedReader br) {
        this.br = br;
    }

    public ArrayList<String> getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList<String> linhas) {
        this.linhas = linhas;
    }
    
    /**
     * Verifica se o arquivo existe
     * Se o nome do arquivo não for setado retorna 1
     * Se o arquivo não existe o metodo retorna 2
     * Se o arquivo não existe retorna 3
     * @return int
     */
    public int verificaSeArquivoExiste() {
        if (!this.nomeArquivo.isEmpty()) {
            this.abrirArquivo = new File(this.nomeArquivo);
        } else {
            return 1;
        }
        
        if (this.abrirArquivo.exists()) {
            return 2;
        }  
        return 3;
    }
    
    /**
     * Instancia o arquivo e o le ao mesmo tempo
     */
    public void lerArquivoLinhaPorLinha () {
        
        try {
            this.fr = new FileReader(this.abrirArquivo);
            this.br = new BufferedReader(this.fr);
        } catch (FileNotFoundException ex) {
            System.err.println("Não foi possivel ler o arquivo: " + ex);
        }
        
        try {
            while (br.ready()) {                
                this.linhas.add(br.readLine());
            }
        } catch (IOException e) {
            System.err.println("Não foi possivel ler o arquivo: " + e);
        }
    }
    
    public void fecharArquivo() {
        try {
            this.br.close();
        } catch (IOException ex) {
            System.err.println("Erro não foi possivel fechar o arquivo: " + ex);
        }
    }
}
