/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inf2050.e22.equipe2;

/**
 * Université du Québec à Montréal (UQAM)
 * Cours : INF2050 - 020 - Été 2022
 * Sprint 1
 *
 * PrixValideException : Exception générée lorsque le prix n'est
 * pas au format "NN.NN $".
 *
 * @author Achou Henri Joël / Akaffou
 * @version 19 mai 2022
 *
 */
public class PrixValideException extends Exception {
    
    public PrixValideException () {
        
    }
    
    public PrixValideException (String message) {
        super(message);  
    }
    
}
