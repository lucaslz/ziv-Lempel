
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Programa para compressao e compactacao de dados LempelZiv
 * @author Lucas Lima
 */
public class LempelZiv {
    
    public static void main(String args[])
    {
        String arquivoDeEntrada = "Entrada.txt";
        String arquivoComprimido = "Comprimido.txt";
        String arquivoDescomprimido = "Descomprimido.txt";
        String dicionario = "dicionario.txt";
        comprimir(arquivoDeEntrada, arquivoComprimido);
        descomprimir(arquivoComprimido, arquivoDescomprimido);
    }
    
    /**
     * Metodo para comprimir o arquivo e escrever em outro arquivo
     * @param caminhoArquivoEntrada caminho onde ficara o arquivo com a string de entrada
     * @param caminhoArquivoSaida arquivo onde ficara o arquivo de saida o dicionario
     * @return false ou true caso não consiga encontrar o arquivo
     */
    public static boolean comprimir(
        String caminhoArquivoEntrada,
        String caminhoArquivoSaida
    ) 
    {
        BufferedReader ler;
        BufferedWriter escrever;
        
        try {
            //Chamando metodo para verificar se o arquivo existe
            File arquivoEntrada = new File(caminhoArquivoEntrada);
            verificaArquivoCriado(arquivoEntrada);
            //Preparando arquivo de entrada
            ler = new BufferedReader(new FileReader(arquivoEntrada));
            
            //Chamando metodo para verificar se o arquivo existe
            File arquivoSaida = new File(caminhoArquivoSaida);
            verificaArquivoCriado(arquivoSaida);
            //Preparando arquivo de saida
            escrever = new BufferedWriter(new FileWriter(arquivoSaida, false));    
            
            /**
             * Eu vou inicializar o dicionario apenas com as Letras de A-Z
             * Isso é só para simplificar, mas sei que o correto é toda tabela ASCII
             */
            ArrayList<String> dicionario = new ArrayList(500);
            for(int i = 0; i < 127; i++)
            {
                String temporaria = (char)(i)+""; //ou String temporaria = (char)(i+65)+"";
                dicionario.add(temporaria);
            }
            System.out.println(dicionario);
            String X, Z, linha;
            
            while((linha = ler.readLine()) != null){
                int indice = 0;
                
                while (indice < linha.length()) {
                    //X é o caracter atual
                    X = linha.charAt(indice) + ""; 
                    //Z é o proximo caracter
                    Z = linha.charAt(++indice) + "";
                    
                    //O loop ocorrera até a sequencia de caracters não esta
                    //no dicionario
                   while(dicionario.contains(X+Z))    
                    {                                   
                        X = X+Z;
                        indice++;
                        if(indice < linha.length()){
                            Z = linha.charAt(indice) + "";
                        } else {
                            //quando chegar ao fim colocar null no final
                            Z = null;
                        }                           
                    }
                    //Adicionando string ao dicionario
                    dicionario.add(X+Z);

                    //Escrever o indice na saida
                    escrever.write(dicionario.indexOf(X) + " ");
                }
            }
            //Printando o dicionario na tela
            System.out.println(dicionario.toString());
            ler.close();
            escrever.close();
            return true;
        }
        catch( FileNotFoundException e)
        {
            System.out.println("Arquivo de entrada não encontrado. Fechando Execução.");
            return false;
        }
        catch (IOException e)
        {
            System.out.println("Erro ao criar arquivo de saida. Fechando o Programa.");
            return false;
        }
    }
    
    /**
     * Metodo para verificar se o arquivo foi criado ou não caso o arquivo
     * não seja encontrado ele é criado
     * @param arquivo 
     */
    public static void verificaArquivoCriado(File arquivo)
    {
        if (!arquivo.exists()) {
            try {
                arquivo.createNewFile();
            } catch (IOException ex) {
                System.out.println("Erro ao criar arquivo.");
            }
        }
    }
    
    /**
     * Descomprir arquivos comprimidos
     * @param caminhoArquivoEntrada
     * @param caminhoArquivoSaida
     * @return false ou true
     */
    public static boolean descomprimir(
        String caminhoArquivoEntrada,
        String caminhoArquivoSaida
    )
    {
        BufferedReader ler;
        BufferedWriter escrever;
        Scanner entrada;
        
        try {
            //Chamando metodo para verificar se o arquivo existe
            File arquivoEntrada = new File(caminhoArquivoEntrada);
            verificaArquivoCriado(arquivoEntrada);
            //Preparando arquivo de entrada
            ler = new BufferedReader(new FileReader(arquivoEntrada));
            entrada = new Scanner(ler);
            
            //Chamando metodo para verificar se o arquivo existe
            File arquivoSaida = new File(caminhoArquivoSaida);
            verificaArquivoCriado(arquivoSaida);
            //Preparando arquivo de saida
            escrever = new BufferedWriter(new FileWriter(arquivoSaida, false));    
            
            /**
             * Eu vou inicializar o dicionario apenas com as Letras de A-Z
             * Isso é só para simplificar, mas sei que o correto é toda tabela ASCII
             */
            ArrayList<String> dicionario = new ArrayList(500);
            for(int i = 0; i < 127; i++)
            {
                String temporaria = (char)(i)+""; //ou String temporaria = (char)(i+65)+"";
                dicionario.add(temporaria);
            }
            
            String atual, X, Z;
            String[] linha;
            Integer[] inteiros;
            
            
            while(entrada.hasNextLine()){
                atual = entrada.nextLine();
                //converte a entrada em array
                linha = atual.split(" ");
                System.out.println(linha[0]);
                inteiros = new Integer[linha.length];
                
                //Percorre o array de inteiros
                for (int i = 0; i < inteiros.length; i++){
                    //E transfere string para o array de inteiros
                    inteiros[i] = Integer.parseInt(linha[i]);
                }
                
                for (int i = 0; i < inteiros.length; i++) {
                    X = dicionario.get(inteiros[i]);
                    if ((i+1) < inteiros.length && inteiros[i + 1] < dicionario.size()){
                        Z = dicionario.get(inteiros[i + 1]);
                        //adicionar primeiro caracter e avançar para proximo caracter
                        Z = Z.charAt(0) + "";
                    }else if((i+1) >= inteiros.length) {
                        //Se chara até o final da entrada coloca null no final
                        Z = null;
                    } else {
                        //Se nao o dicionario não tem o proximo indice
                        //Potanto tem que ser a primeiro caracter da string corrente
                        Z = X.charAt(0) + "";
                    }
                    //Adiciona nova sequecia de caracters ao dicionario
                    dicionario.add(X+Z);
                    //escreve no arquivo de saida
                    escrever.write(X);
                }
                escrever.write("\n");
            }
            //Escrevendo dicionario na saida
            System.out.println(dicionario.toString());
            entrada.close();
            ler.close();
            escrever.close();
            return true;
        }
        catch( FileNotFoundException e)
        {
            System.out.println("Arquivo de entrada não encontrado. Fechando Execução.");
            return false;
        }
        catch (IOException e)
        {
            System.out.println("Erro ao criar arquivo de saida. Fechando Execução.");
            return false;
        }
    }    
}
