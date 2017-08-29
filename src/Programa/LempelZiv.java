/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programa;

import Compressao.Codificar;
import TratarArquivos.LeituraArquivo;
import TratarArquivos.EscrituraArquivo;

/**
 * @author Lucas
 */
public class LempelZiv {
    public static void main(String[] args) {
        
        //Lendo e retornando arquivo de entrada
        LeituraArquivo ler = new LeituraArquivo();
        ler.setNomeArquivo("texto.txt");
        ler.verificaSeArquivoExiste();
        ler.lerArquivoLinhaPorLinha();
        System.out.println("Texto linha por linha do arquivo de entrada: " + ler.getLinhas());
        
        //Codificar o que foi lido do arquivo
        Codificar c = new Codificar();
        c.setArrayLista(ler.getLinhas());
        c.particionarListaStrings();
        System.out.println("Dicionario: " + c.getArrayAIndexar());
        
        //Indexando as strings no arquivos, separando-as por '|'
        EscrituraArquivo eA = new EscrituraArquivo();
        eA.setNomeArquivo("dicionario.txt");
        c.escreverStringsParticionadas(eA);
        
        //Ler arquivo de testo indexado e gerar arquivo comprimido
        LeituraArquivo lerc = new LeituraArquivo();
        lerc.setNomeArquivo("dicionario.txt");
        lerc.verificaSeArquivoExiste();
        lerc.lerArquivoLinhaPorLinha();
        c.setArrayLista(lerc.getLinhas());
        c.indexarStrings();
        c.codificarStrings();
        System.out.println("Texto Compactado: " + c.getCodigicacao());
        
        //Escrever texto compactado no arquivo
        eA.setNomeArquivo("arquivo_texto_comprimido.txt");
        c.escreverStringsCodificadas(eA);
        
    }
}
