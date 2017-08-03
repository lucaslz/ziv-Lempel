package basico;

import java.util.ArrayList;

/**
 * @author nobreck
 */
public class Comprimir {
    
    //Instaciando a variavel que tera todo o dicionario codificado
    TabelaAscii dicionario = new TabelaAscii();
    
    //Frase que o usuario digitou 
    String frase = new String();
       
    /**
     * Codifica a string e passa apara o dicionario 
     */
    public void codificarStringNoDicionario() {
        //Pegando tamanho da string
        Integer tamanhoFrase = this.getFrase().length();

        //Inicializando dicionario com simbolos basicos, correspondem aos 256 ascii
        ArrayList<String> tabelaAscii = dicionario.gerarTabelaAscii(tamanhoFrase);

        //Tamanho da tabela
        Integer tamanho = tabelaAscii.size(); 
        
        //convertendo string em array
        char[] arrayFrase = this.getFrase().toCharArray();
        
        //Tamanho normal do dicionario
        Integer tamanhoNormal = tamanho - tamanhoFrase;
        
        //Preciso pegar a ultima posicao do dicionario para inserir a string
        Integer tamanhoDicionario =  tamanhoNormal;
        
        //Percorrendo a frase e inserindo no dicionario
        for (int i = 0; i < tamanhoFrase; i++) {
            
            String conjunto = new String();
            
            if ((i+1) > tamanhoFrase) {
                    conjunto = Character.toString(arrayFrase[i]);
            } else {
                if ((i+1) < tamanhoFrase) {
                    System.out.println(i+1);
                    conjunto = Character.toString(arrayFrase[i]) + Character.toString(arrayFrase[i+1]);
                    i++;                    
                }
            }
                            
            if (this.verificaStringList(conjunto) == false) {
                System.out.println(tamanhoDicionario+" | "+conjunto);
                tabelaAscii.set(tamanhoDicionario, conjunto);
                tamanhoDicionario++;                
            }else {
                if (i < tamanhoFrase && (i+1) < tamanhoFrase && (i+2) <= tamanhoFrase) {
                    conjunto = Character.toString(arrayFrase[i]) + Character.toString(arrayFrase[i+1]) + Character.toString(arrayFrase[i+2]);
                    tabelaAscii.set(tamanhoDicionario, conjunto);
                    tamanhoDicionario++;                
                }
                
            }

        }
    }
    
    public boolean verificaStringList(String conjunto) {
        
        char[] conjuntoChar = conjunto.toCharArray();
        Integer tamanho = conjunto.length();
        
                //Pegando tamanho da string
        Integer tamanhoFrase = this.getFrase().length();
        
        
        for (int i = 0; i < tamanho; i++) {
            if (this.dicionario.tabela.get(i) == conjunto && tamanho < ) {
                return true;
            }
        }
        
        return false;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }
    
}
