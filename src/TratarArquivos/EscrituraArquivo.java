/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TratarArquivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Lucas
 */
public class EscrituraArquivo {
    String nomeArquivo;
    File abrirArquivo;
    FileWriter fr;
    BufferedWriter bw;
    String parteString;

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

    public FileWriter getFr() {
        return fr;
    }

    public void setFr(FileWriter fr) {
        this.fr = fr;
    }

    public BufferedWriter getBw() {
        return bw;
    }

    public void setBw(BufferedWriter bw) {
        this.bw = bw;
    }

    public String getParteString() {
        return parteString;
    }

    public void setParteString(String parteString) {
        this.parteString = parteString;
    }

    public int verificaSeArquivoExiste() {
        if (!this.getNomeArquivo().isEmpty()) {
            this.setAbrirArquivo(new File(this.nomeArquivo));
        } else {
            return 1;
        }
        
        if (!this.getAbrirArquivo().exists()) {
            try {
                this.getAbrirArquivo().createNewFile();
            } catch (IOException ex) {
                System.out.println("Não foi possivel criar o arquivo: " +  ex);
            }
            return 2;
        } else {
            this.getAbrirArquivo().delete();
            if (!this.getAbrirArquivo().exists()) {
                try {
                    this.getAbrirArquivo().createNewFile();
                } catch (IOException ex) {
                    System.out.println("Não foi possivel criar o arquivo: " +  ex);
                }
            }
        }  
        return 3;
    }    

    public void escreverEmArquivo() {
        try {
            this.setFr(new FileWriter(this.abrirArquivo, true));
            this.setBw(new BufferedWriter(this.fr));
            this.getBw().write(this.getParteString());
            this.getBw().flush();
        } catch (IOException ex) {
            System.out.println("Não foi possivel escrever no arquivo: " + ex);
        }
    }
    
    public void quebrarLinha() {
        try {
            this.getBw().newLine();
        } catch (IOException ex) {
            System.out.println("Não foi possivel quebrar a linha: " + ex);
        }
    }
    
    public void fecharArquivo() {
        try {
            this.bw.close();
        } catch (IOException ex) {
            System.err.println("Erro não foi possivel fechar o arquivo: " + ex);
        }
    }
}