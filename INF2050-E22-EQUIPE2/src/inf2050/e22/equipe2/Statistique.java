/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inf2050.e22.equipe2;

/**
 * Université du Québec à Montréal (UQAM)
 * Cours : INF2050 - 020 - Été 2022
 * Sprint 3
 *
 * @author @kemayou
 * @version Juillet 2022
 */

public class Statistique {

    private String numero;
    private String libelleRapport;
    private int donnee;

    public Statistique(String numero, String libelleRapport, int donnee) {
        this.numero = numero;
        this.libelleRapport = libelleRapport;
        this.donnee = donnee;
    }

    public int getDonnee() {
        return donnee;
    }
}