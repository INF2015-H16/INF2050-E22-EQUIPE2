/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inf2050.e22.equipe2;

/**
 * Université du Québec à Montréal (UQAM)
 * Cours : INF2050 - 020 - Été 2022
 * Sprint 3
 *
 * Lotissement : Cette classe permet de modéliser le lotissement.
 *
 * @author Achou Henri Joël / Akaffou
 * @version juillet 2022
 *
 */
public class Lotissement {
    
    private String description;
    private int nombreDroitPassage;
    private int nombreService;
    private int superficie;
    private String dateMesure;
    
    
    public Lotissement(String description, int nombreDroitPassage,
                       int nombreService, int superficie, String dateMesure) {
        this.nombreDroitPassage = nombreDroitPassage;
        this.nombreService = nombreService;
        this.superficie = superficie;
        this.dateMesure = dateMesure;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    public int getNombreDroitPassage() {
        return nombreDroitPassage;
    }

    public int getNombreService() {
        return nombreService;
    }
    public int getSuperficie() {
        return superficie;
    }

    public String getDateMesure() {
        return dateMesure;
    }
}