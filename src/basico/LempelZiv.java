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
public class LempelZiv {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Frase a ser codificada
        Scanner entradaFrase = new Scanner(System.in);
        System.out.println("Digite a frase a ser codificada: ");
        String frase = entradaFrase.nextLine();
        
        //Codificando a string na tabela
        Comprimir codificarString = new Comprimir();
        
        //setando a string
        codificarString.setFrase(frase);
        
        //Pegando o tama
        codificarString.codificarStringNoDicionario();
    }
    
}
