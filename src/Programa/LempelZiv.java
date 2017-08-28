/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programa;

import TratarArquivos.LeituraArquivo;
import Compressao.TratarCompressao;
import TratarArquivos.EscrituraArquivo;
import TratarArquivos.LeituraCaracterPorCaracter;

/**
 * @author Lucas
 */
public class LempelZiv {
    public static void main(String[] args) {
        
        //Pesquisando em arquivo
        LeituraArquivo ler = new LeituraArquivo();
        ler.setNomeArquivo("teste.txt");
        int retorno = ler.verificaSeArquivoExiste();
        System.out.println("Retorno da função: " + retorno);
        ler.lerArquivoLinhaPorLinha();
        System.out.println("Retorno da função: " + ler.getLinhas());
        
        //Pegando caracters do arquivo
        TratarCompressao tc = new TratarCompressao();
        tc.setLinhas(ler.getLinhas());
        tc.pegarLinhaAtual();
        System.out.println("Retorno da função: " + tc.getCaracters());
        
        //Escrevendo em arquivos
        EscrituraArquivo ea = new EscrituraArquivo();
        ea.setNomeArquivo("saida.txt");
        int retornoArquivo = ea.verificaSeArquivoExiste();
        System.out.println("Retorno do arquivo: " + retornoArquivo);
        ea.setParteString("Lucas Lima");
        ea.escreverEmArquivo();
        
        
        //Escrevendo em arquivos por partes
        EscrituraArquivo eArquivo = new EscrituraArquivo();
        eArquivo.setNomeArquivo("caracterPorCaracter.txt");
        int retornoEArquivo = eArquivo.verificaSeArquivoExiste();
        LeituraCaracterPorCaracter lCP = new LeituraCaracterPorCaracter();
        lCP.setLerArquivo(ler);
        String palavra = lCP.pegarParteString(3);
        System.out.println(palavra);
        
        //Escrever no dicionario com uma barra
        for (int i = 0; i < palavra.length(); i++) {
            if (palavra.charAt(palavra.length()-1) == 'a') {
                System.out.println(palavra.charAt(palavra.length()-1));
            }
        }
        ea.setNomeArquivo("dicionario.txt");
        int retornoDicionario = ea.verificaSeArquivoExiste();
        ea.setParteString(palavra + "|");
        ea.escreverEmArquivo();
        ea.escreverEmArquivo();
        ea.escreverEmArquivo();
        ea.escreverEmArquivo();
    }
}
