/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inf2050.e22.equipe2;

import net.sf.json.JSONException;
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
    public final static String DECIMAL_SEULEMENT_POINT = "[^\\d.]";
    public static final String MESSAGE = "message";

    @Override
    public Terrain obtenirDonneesTerrain(String json,
                                         EvaluationLot lotissements,
                                         EvaluationObservation observations)
            throws IntervallesValideException, PrixValideException,
            JSONException {
        Terrain terrain = null;
        if (json.length() != 0) {
            JSONObject enteteTerrain = JSONObject.fromObject(json);

            int typeTerrain = VerificationDonnee
                    .validerTypeTerrain(
                            enteteTerrain.getInt(ETIQUETTE_TYPE_TERRAIN));
            String prixMin = VerificationDonnee.validerPrix
                                    (VerificationDonnee
                                            .verifierPrixNegatif(enteteTerrain
                            .getString(ETIQUETTE_PRIX_M2_MIN)));
            String priMax = VerificationDonnee.validerPrix
                    (VerificationDonnee.verifierPrixNegatif(enteteTerrain
                            .getString(ETIQUETTE_PRIX_M2_MAX)));

            terrain = new Terrain(typeTerrain, prixMin,
                    priMax, lotissements, observations);

        }

        return terrain;
    }

    @Override
    public int obtenirTypeTerrain(Terrain terrain)
            throws NullPointerException {
        return terrain.getTypeTerrain();
    }

    @Override
    public double obtenirPrixMinimum(Terrain terrain)
            throws NullPointerException, PrixValideException {
        String temp = terrain.getPrixMin();
        String changerVirgule = temp.replaceAll(",", ".");
        String prixMinimum = changerVirgule
                .replaceAll(DECIMAL_SEULEMENT_POINT, "");
        return Double.parseDouble(prixMinimum);
    }

    @Override
    public double obtenirPrixMaximum(Terrain terrain)
            throws NullPointerException, PrixValideException {
        String temp = terrain.getPrixMax();
        String changerVirgule = temp.replaceAll(",", ".");
        String prixMaximum = changerVirgule
                .replaceAll(DECIMAL_SEULEMENT_POINT, "");
        return Double.parseDouble(prixMaximum);
    }


    @Override
    public double calculerTaxeScolaire(double montantTerrain)
            throws NullPointerException {
        return montantTerrain * TAXE_SCOLAIRE;
    }

    @Override
    public double calculerTaxeMunicipale(double montantTerrain) {
        return montantTerrain * TAXE_MUNICIPALE;
    }

    @Override
    public JSONObject fournirRapportValide(double montantTerrain,
                                           double montantTaxeScolaire,
                                           double montantTaxeMunicipale,
                                           double [] montantsParLot,
                                           String [] descriptions)
            throws LotValideException {

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

    @Override
    public JSONObject fournirRapportErreur(String message) {
        JSONObject rapport = new JSONObject();

        return rapport.accumulate(MESSAGE, message);
    }

}