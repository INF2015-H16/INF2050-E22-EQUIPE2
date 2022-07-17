/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inf2050.e22.equipe2;

import java.io.IOException;
import net.sf.json.JSONObject;

/**
 * Université du Québec à Montréal (UQAM)
 * Cours : INF2050 - 020 - Été 2022
 * Sprint 1
 *
 * EvaluationTerrain : Cette classe contient les données sur la description,
 *                le nombre de droits de passage, le nombre de services,
 *                la superficie, la date de mesure des lots,
 *                ainsi que, le type de terrain, les prix min et max.
 *                Elle permet de calculer la valeur foncière du
 *                terrain ainsi que les taxes scolaire et municipale.
 *
 *
 * @author Achou Henri Joël / Akaffou
 * @version 19 mai 2022
 *
 */
public interface IEvaluationTerrain {

    Terrain obtenirDonneesTerrain(String json, EvaluationLot lotissements,
                                  EvaluationObservation observations)
            throws IntervallesValideException, PrixValideException;

    int obtenirTypeTerrain(Terrain terrain)
            throws IOException, NullPointerException;

    double obtenirPrixMinimum(Terrain terrain)
            throws IOException, NullPointerException, PrixValideException;

    double obtenirPrixMaximum(Terrain terrain)
            throws IOException, NullPointerException, PrixValideException;

    double calculerTaxeScolaire(double montantTerrain)
            throws IOException, NullPointerException;

    double calculerTaxeMunicipale(double montantTerrain)
            throws IOException;

    JSONObject fournirRapportValide(double montantTerrain,
                                    double montantTaxeScolaire,
                                    double montantTaxeMunicipale,
                                    double [] montantsParLot,
                                    String [] descriptions)
            throws IOException, LotValideException, LectureFichierException;

    JSONObject fournirRapportErreur(String message);

}