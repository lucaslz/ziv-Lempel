package basico;

import java.util.ArrayList;

/**
 * @author nobreck
 */
public class TabelaAscii {
    
    /**
     * A tabela ascii tem 128 posicoes
     * @var integer posicoes
     */
    public Integer posicoes = 255;
    
    /**
     * Tabela com os caracters ascii
     * @var char tabela
     */
    ArrayList<String> tabela = new ArrayList<>();
    
    /**
     * Gerando tabela ascii automaticamente
     * @param tamanhoString
     * @return ArrayList tabela
     * @access public
     */
    public ArrayList<String> gerarTabelaAscii(Integer tamanhoString) {
        
        Integer totalList = tamanhoString +  this.posicoes;
        
        for (int i = 0; i < totalList; i++) {
            //Convertendo para char
            char caracter = (char) i;

            //convertendo para string
            String caracterString = Character.toString(caracter);
            
            //Inserindo string na tabela
            if (this.posicoes <= i) {
                this.tabela.add(i, caracterString);                
            } else {
                this.tabela.add(i, "");
            }
        }
        return this.tabela;
    }
    
    /**
     * Imprime a tabela ascii que foi gerada
     * @access public
     */
    public void imprimirTabelaAscii() {
        for (int i = 0; i < this.posicoes; i++) {
            System.out.println(this.tabela.get(i));
        }
    }
}
