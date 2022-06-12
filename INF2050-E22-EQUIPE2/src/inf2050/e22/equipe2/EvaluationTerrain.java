/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inf2050.e22.equipe2;

import java.io.FileNotFoundException;
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
public class EvaluationTerrain implements IEvaluationTerrain {

    public final static double TAXE_SCOLAIRE = 0.012;
    public final static double TAXE_MUNICIPALE = 0.025;
    public final static String ETIQUETTE_DESCRIPTION = "description";
    public final static String ETIQUETTE_TYPE_TERRAIN = "type_terrain";
    public final static String ETIQUETTE_PRIX_M2_MIN = "prix_m2_min";
    public final static String ETIQUETTE_PRIX_M2_MAX = "prix_m2_max";
    public final static String ETIQUETTE_LOTISSEMENTS = "lotissements";

    public final static String ETIQUETTE_VALEUR_FONCIERE_TOTALE =
            "valeur_fonciere_totale";
    public final static String ETIQUETTE_TAXE_SCOLAIRE = "taxe_scolaire";
    public final static String ETIQUETTE_TAXE_MUNICIPALE = "taxe_municipale";
    public final static String ETIQUETTE_VALEUR_PAR_LOT = "valeur_par_lot";

    public final static String DECIMAL_ONLY = "[^\\d.]";

    @Override
    public Terrain obtenirDonneesTerrain(String json,
            EvaluationLot lotissements)
            throws FileNotFoundException, IOException,
            NumberFormatException, IntervallesValideException,
            PrixValideException {

        Terrain terrain = null;
        if (json.length() != 0) {
            JSONObject enteteTerrain = JSONObject.fromObject(json);
            
            int typeTerrain = VerificationDonnee
                    .valeurEstInt(enteteTerrain
                            .getInt(ETIQUETTE_TYPE_TERRAIN));
            String prixMin = VerificationDonnee.
                    validerPrix(enteteTerrain
                            .getString(ETIQUETTE_PRIX_M2_MIN));
            String priMax = VerificationDonnee.
                    validerPrix(enteteTerrain
                            .getString(ETIQUETTE_PRIX_M2_MAX));
            
            if (VerificationDonnee.validerTypeTerrain(typeTerrain)) {
                terrain = new Terrain(typeTerrain, prixMin,
                        priMax, lotissements);
            }
        }
        
        return terrain;

    }

    @Override
    public int obtenirTypeTerrain(Terrain terrain)
            throws IOException, NullPointerException {
        return terrain.getTypeTerrain();
    }

    @Override
    public double obtenirPrixMinimum(Terrain terrain)
            throws IOException, NullPointerException {
        return Double.parseDouble(terrain.getPrixMin()
                .replaceAll(DECIMAL_ONLY, ""));
    }

    @Override
    public double obtenirPrixMaximum(Terrain terrain)
            throws IOException, NullPointerException {
        return Double.parseDouble(terrain.getPrixMax()
                .replaceAll(DECIMAL_ONLY, ""));
    }

    @Override
    public double calculerTaxeScolaire(double montantTerrain)
            throws IOException, NullPointerException {
        
        return montantTerrain * TAXE_SCOLAIRE;
    }

    @Override
    public double calculerTaxeMunicipale(double montantTerrain)
            throws IOException {
        
        return montantTerrain * TAXE_MUNICIPALE;
    }

    @Override
    public void genererRapportEvaluation (String sortie, double montantTerrain,
                       double montantTaxeScolaire, double montantTaxeMunicipale,
                       double [] montantsParLot, String [] descriptions)
            throws IOException, LotValideException {
        // Methode à completer
    }

    public JSONObject fournirRapportValide(double montantTerrain,
            double montantTaxeScolaire, double montantTaxeMunicipale,
            double [] montantsParLot, String [] descriptions)
            throws IOException, LotValideException {

        JSONObject donneRapport = new JSONObject();
        if (VerificationDonnee.verifierLotsDoublons(descriptions)) {

            donneRapport = fournirEnteteRapport(montantTerrain,
                    montantTaxeScolaire, montantTaxeMunicipale);

            for (int i = 0; i < montantsParLot.length; i++) {

                JSONObject detailsLot = fournirDetailsRapport(i,
                        descriptions, montantsParLot);

                donneRapport.accumulate(ETIQUETTE_LOTISSEMENTS,detailsLot);
            }
        }

        return donneRapport;
    }

    private JSONObject fournirEnteteRapport(double montantTerrain,
                                            double montantTaxeScolaire,
                                            double montantTaxeMunicipale) {
        JSONObject enteteRapport = new JSONObject();

        enteteRapport.accumulate(ETIQUETTE_VALEUR_FONCIERE_TOTALE,
                Utilitaire.convertirMontant(montantTerrain));
        enteteRapport.accumulate(ETIQUETTE_TAXE_SCOLAIRE,
                Utilitaire.convertirMontant(montantTaxeScolaire));
        enteteRapport.accumulate(ETIQUETTE_TAXE_MUNICIPALE,
                Utilitaire.convertirMontant(montantTaxeMunicipale));

        return enteteRapport;
    }

    private JSONObject fournirDetailsRapport(int index, String [] descriptions,
                                             double [] montantsParLot) {

        JSONObject detailsLot = new JSONObject();

        detailsLot.accumulate(ETIQUETTE_DESCRIPTION, descriptions[index]);
        detailsLot.accumulate(ETIQUETTE_VALEUR_PAR_LOT,
                Utilitaire.convertirMontant(montantsParLot[index]));

        return detailsLot;
    }

}
