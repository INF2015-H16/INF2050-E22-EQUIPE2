/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inf2050.e22.equipe2;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import net.sf.json.JSONException;


/**
 * Université du Québec à Montréal (UQAM)
 * Cours : INF2050 - 020 - Été 2022
 * Sprint 3
 *
 * La classe ProjetDeSessionSprint2 contient une methode main.
 * Elle permet de tester toutes les autres classes et les utilisent pour
 * calculer l'évaluation d'un terrain selon son type pouvant contenir
 * plusieurs lots. Ces lots sont caractérisés par leur superficie, le nombre de
 * droits de passages et le nombres de services.
 *
 * @author Elza Meguieng Tiemghen
 * @version juillet 2022
 */

public class ProjetDeSessionSprint3 {

    public static final String RAPPORT_CORRECTEMENT_REINITIALISE
            = "Le rapport a été correctement réinitialisé\n";
    public static final String VERIFIER_PARAMETRES_LIGNE_DE_COMMANDE
            = "Verifier les parametres de la ligne de commande\n";
    public static final String COMMANDE_STATISTIQUE_AFFICHER = "-S";
    public static final String COMMANDE_STATISTIQUE_REINITIALISER = "-SR";
    public static final String FICHIER_ENTREE = "entree.json";
    public static final String FICHIER_SORTIE = "sortie.json";

    private static boolean verifierParametreProgramme(String [] parametres)
            throws IOException {
        boolean estEnEntree;
        if (parametres.length == 0) {
            throw new IOException(GestionnaireMessage.
                    ERREUR_FICHER_ENTREE);

        } else {
            estEnEntree = true;
        }
        return estEnEntree;
    }

    private static String gererDocumentJson(String entree) {
        String donneFichier = null;

        try {
            String fichier = VerificationDonnee.chargerDonneeDeFichier(entree,
                    LancementProgramme.ENCODAGE_DE_FICHIER);
            String donnee = VerificationDonnee.
                    verifierPresenceDonnees(fichier);
            donneFichier = VerificationDonnee.
                    verifierContenuFichierTerrain(donnee);
        } catch (IOException
                 | NumberFormatException
                 | NullPointerException e) {
                Utilitaire.afficherMessage(e.getMessage());
        }
        return donneFichier;
    }

    private static void lancerLeProgramme(String [] parametres,
                                          String entree, String sortie) {
        try {
            if (verifierParametreProgramme(parametres)) {
                String donneeEntree = gererDocumentJson(entree);
                LancementProgramme lancementProgramme =
                        new LancementProgramme(donneeEntree);
                lancementProgramme.enregisterRapportDansFichier(sortie);

            }

        } catch (IOException
                 | NullPointerException
                 | NumberFormatException
                 | LotValideException
                 | JSONException
                 | PrixValideException
                 | IntervallesValideException
                 | LectureFichierException
                 | ParseException e) {
            Utilitaire.afficherMessage(e.getMessage());
            try {
                VerificationDonnee.enregistrerDonneeDansFichier(sortie,
                        e.getMessage(), LancementProgramme.
                                ENCODAGE_DE_FICHIER);
            } catch (NumberFormatException
                     | LectureFichierException
                     | IOException ex) {
                Utilitaire.afficherMessage(ex.getMessage());
            }
        }
    }

    private static void executerLeProgramme(String [] parametres) {
        RapportStatistique rapportStatistique = new RapportStatistique(
                new File(RapportStatistique.RAPPORT));

        IExecuterProgramme iExecuterProgramme = new IExecuterProgramme() {
            @Override
            public void lancerProgramme(String entree, String sortie) {
                lancerLeProgramme(parametres, entree, sortie);
            }

            @Override
            public void rapporterStatistique() {
                try {
                    String content = rapportStatistique.redigerContenuRapport(
                            0,0,
                            0,0,0,
                            0,0,0,0);
                    Utilitaire.afficherMessage(content);

                } catch (IOException e) {
                    Utilitaire.afficherMessage(e.getMessage());
                }
            }

            @Override
            public void reinitialiserStatistique() {
                try {
                    boolean reinitialise = rapportStatistique
                            .reinitialiserRapportStatistique(
                            new File(RapportStatistique.RAPPORT));

                    if (reinitialise) {
                        Utilitaire.afficherMessage(
                                RAPPORT_CORRECTEMENT_REINITIALISE);

                    }

                } catch (IOException e) {
                    Utilitaire.afficherMessage(e.getMessage());
                }
            }
        };

        controlerLeProgramme(iExecuterProgramme, parametres);
    }

    private static void controlerLeProgramme(
            IExecuterProgramme iExecuterProgramme,
            String [] parametres) {

        if (parametres.length == 1) {
            String option = parametres[0];

            choisirOptionStatistique(iExecuterProgramme, option);
        } else if (parametres.length == 2) {
            String entree = parametres[0];
            String sortie = parametres[1];

            if (estLigneCommandeEntreeSortie(entree, sortie)) {
                iExecuterProgramme.lancerProgramme(entree, sortie);

            }
        } else {
            Utilitaire.afficherMessage(VERIFIER_PARAMETRES_LIGNE_DE_COMMANDE);
        }
    }

    private static boolean estLigneCommandeEntreeSortie(String entree,
                                                        String sortie) {
        return entree.equals(FICHIER_ENTREE)
                && sortie.equals(FICHIER_SORTIE);
    }

    private static void choisirOptionStatistique(
            IExecuterProgramme iExecuterProgramme, String option) {
        if (option.equals(COMMANDE_STATISTIQUE_AFFICHER)) {
            iExecuterProgramme.rapporterStatistique();
        } else if (option.equals(COMMANDE_STATISTIQUE_REINITIALISER)) {
            iExecuterProgramme.reinitialiserStatistique();
        } else {
            Utilitaire.afficherMessage(VERIFIER_PARAMETRES_LIGNE_DE_COMMANDE);

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        executerLeProgramme(args);

    }

}