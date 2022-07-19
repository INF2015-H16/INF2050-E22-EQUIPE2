/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inf2050.e22.equipe2;

import java.util.ArrayList;

/**
 * Université du Québec à Montréal (UQAM)
 * Cours : INF2050 - 020 - Été 2022
 * Sprint 1
 *
 * Terrain : Cette classe permet de modéliser le terrain.
 *
 * @author Achou Henri Joël / Akaffou
 * @version 19 mai 2022
 *
 */
public class Terrain {
    
    public final static int TERRAIN_AGRICOLE = 0;
    public final static int TERRAIN_RESIDENTIEL = 1;
    public final static int TERRAIN_COMMERCIAL = 2;
    public final static String DESC_TERRAIN_AGRICOLE = "Agricole";
    public final static String DESC_TERRAIN_RESIDENTIEL = "Résidentiel";
    public final static String DESC_TERRAIN_COMMERCIAL = "Commercial";
    
    private int typeTerrain;
    private String prixMin;
    private String prixMax;
    private EvaluationLot lotissement;
    private ArrayList <String> observation;
    
    
    public Terrain(int typeTerrain, String prixMin, String prixMax,
                   EvaluationLot lotissement,
                   ArrayList<String> observation) {
        this.typeTerrain = typeTerrain;
        this.prixMin = prixMin;
        this.prixMax = prixMax;
        this.lotissement = lotissement;
        this.observation = observation;
    }

    public int getTypeTerrain() {
        return typeTerrain;
    }
    public String getPrixMin() {
        return prixMin;
    }
    public String getPrixMax() {
        return prixMax;
    }
    
}