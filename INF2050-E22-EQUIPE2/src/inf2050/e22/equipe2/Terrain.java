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
 * Terrain : Cette classe permet de modéliser le terrain.
 *
 * @author Achou Henri Joël / Akaffou
 * @version juillet 2022
 *
 */
public class Terrain {

    private int typeTerrain;
    private String prixMin;
    private String prixMax;
    private EvaluationLot lotissement;

    public Terrain(int typeTerrain, String prixMin, String prixMax,
                   EvaluationLot lotissement) {
        this.typeTerrain = typeTerrain;
        this.prixMin = prixMin;
        this.prixMax = prixMax;
        this.lotissement = lotissement;
    }

    public int getTypeTerrain() throws IntervallesValideException {
        return VerificationDonnee
                .validerTypeTerrain(typeTerrain);
    }
    public String getPrixMin() throws PrixValideException {
        return VerificationDonnee.validerPrix
                (VerificationDonnee
                        .verifierPrixNegatif(prixMin));
    }
    public String getPrixMax() throws PrixValideException {
        return VerificationDonnee.validerPrix
                (VerificationDonnee.verifierPrixNegatif(prixMax));
    }

}