/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inf2050.e22.equipe2;

import java.io.IOException;
import java.util.ArrayList;
import net.sf.json.JSONObject;

/**
 * Université du Québec à Montréal (UQAM)
 * Cours : INF2050 - 020 - Été 2022
 * Sprint 3
 *
 * IEvaluationTerrain : Cette interface contient les données sur
 *                     le type de terrain, les prix min et max.
 *                     Elle permet de calculer la valeur foncière du
 *                     terrain ainsi que les taxes scolaire et municipale.
 *
 *
 * @author Achou Henri Joël / Akaffou
 * @version juillet 2022
 *
 */
public interface IEvaluationTerrain {

    Terrain obtenirDonneesTerrain(String json, EvaluationLot lotissements)
            throws IntervallesValideException, PrixValideException;

    int obtenirTypeTerrain(Terrain terrain)
            throws IOException, NullPointerException;

    double obtenirPrixMinimum(Terrain terrain)
            throws IOException, NullPointerException, PrixValideException;

    double obtenirPrixMaximum(Terrain terrain)
            throws IOException, NullPointerException, PrixValideException;

    boolean obtenirPrixMaxDoublePrixMin(double prixMin, double prixMax);
    double calculerTaxeScolaire(double montantTerrain)
            throws IOException, NullPointerException;

    double obtenirTaxeScolaireDoubleVersement(double taxeScolaire);
    double calculerTaxeMunicipale(double montantTerrain)
            throws IOException;

    double obtenirTaxeMunicipaleDoubleVersement(double taxeMunicipale);
    JSONObject fournirRapportValide(double montantTerrain,
                                    double montantTaxeScolaire,
                                    double montantTaxeMunicipale,
                                    double [] montantsParLot,
                                    String [] descriptions,
                                    ArrayList<String> observationChainee)
            throws IOException, LotValideException, LectureFichierException;

    JSONObject fournirRapportErreur(String message);

}