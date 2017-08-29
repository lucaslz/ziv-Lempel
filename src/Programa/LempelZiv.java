/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programa;

import Compressao.Codificar;
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
        System.out.println("Retorno da arquivo existe: " + retorno);
        ler.lerArquivoLinhaPorLinha();
        System.out.println("Retorno da Linhas lidas " + ler.getLinhas());
        
        //Pegando caracters do arquivo
        TratarCompressao tc = new TratarCompressao();
        tc.setLinhas(ler.getLinhas());
        tc.pegarLinhaAtual();
//        System.out.println("Retorno de caracteres: " + tc.getCaracters());
        
        //Escrevendo em arquivos
        EscrituraArquivo ea = new EscrituraArquivo();
        ea.setNomeArquivo("saida.txt");
        int retornoArquivo = ea.verificaSeArquivoExiste();
//        System.out.println("Retorno do arquivo: " + retornoArquivo);
        ea.setParteString("Lucas Lima");
        ea.escreverEmArquivo();
        
        
        //Escrevendo em arquivos por partes
        EscrituraArquivo eArquivo = new EscrituraArquivo();
        eArquivo.setNomeArquivo("caracterPorCaracter.txt");
        int retornoEArquivo = eArquivo.verificaSeArquivoExiste();
        LeituraCaracterPorCaracter lCP = new LeituraCaracterPorCaracter();
        lCP.setLerArquivo(ler);
        String palavra = lCP.pegarParteString(3);

        
        //Indexando string codificando e escrevendo no arquivo
        Codificar c = new Codificar();
        LeituraArquivo lerc = new LeituraArquivo();
        lerc.setNomeArquivo("dicionario.txt");
        int retornos = lerc.verificaSeArquivoExiste();
        lerc.lerArquivoLinhaPorLinha();
        c.setArrayLista(ler.getLinhas());
        c.indexarStrings();
        System.out.println("Texto Indexado: " + c.getIndex());
        c.codificarStrings();
        System.out.println("Dicionario: " + c.getCodigicacao());
    }
}
