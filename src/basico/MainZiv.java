/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basico;

import java.util.Scanner;

/**
 *
 * @author nobreck
 */
public class MainZiv {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Lendo arquivo e retorando em formato de array
//        System.out.println("Nome Arquivo: ");
//        Scanner in = new Scanner(System.in);
//        String nomeArquivo = in.nextLine();
//        Leitura leitura = new Leitura();
//        LempelZiv lempelZiv = leitura.lerArquivo(nomeArquivo);
        
        //Gerando a tabela ascci e comprimindo o arquivo
//        Comprimir tabela = new Comprimir();

        Escrita e = new Escrita();
        e.criarTabelaAsciiArquivo();
    }
}
