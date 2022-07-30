package inf2050.e22.equipe2;

import java.io.*;
import java.util.ArrayList;

/**
 * Université du Québec à Montréal (UQAM)
 * Cours : INF2050 - 020 - Été 2022
 * Sprint 3
 *
 * RapportStatistique : Cette classe contient les données
 *                         sur la gestion des statistiques.
 *
 *
 * @author Achou Henri Joël / Akaffou
 * @version juillet 2022
 *
 */
public class RapportStatistique implements IRapportStatistique {

    public static final String RAPPORT = "rapport.txt";
    public static final String PREFIX_ETOILE = "*";
    public static final String PREFIX_TIRET = "-";
    public static final String ESPACE = " ";
    public static final String SEPARATEUR_COLONNE = "\\|";
    public static final String NOMBRE_TOTAL_DE_LOTS_TERRAINS
            = "1.    | Nombre total de lots soumis (tous terrains confondus) : ";
    public static final String NOMBRE_DE_LOTS_AVEC_VALEUR_PAR_LOT
            = "2.    | Nombre de lots avec une valeur par lot : ";
    public static final String DE_MOINS_DE_1000_$
            = " 2.1. |               de moins de 1000$ : ";
    public static final String DE_1000_À_10000_$
            = " 2.2. |               de 1000 à 10000$ : ";
    public static final String DE_PLUS_DE_10000_$
            = " 2.3. |               de plus de 10000$ : ";
    public static final String NOMBRE_DE_LOTS_PAR_TYPE_DE_TERRAIN
            = "3.    | Nombre de lots par type de terrain : ";
    public static final String LOTS_DESC_TERRAIN_AGRICOLE
            = " 3.1. |               Agricole : ";
    public static final String LOTS_DESC_TERRAIN_RESIDENTIEL
            = " 3.2. |               Résidentiel : ";
    public static final String LOTS_DESC_TERRAIN_COMMERCIAL
            = " 3.3. |               Commercial : ";
    public static final String SUPERFICIE_MAXIMALE_SOUMISE_POUR_UN_LOT
            = "4.    | Superficie maximale soumise pour un lot : ";
    public static final String VALEUR_PAR_LOT_MAXIMALE_POUR_UN_LOT
            = "5.    | Valeur par lot maximale pour un lot : ";
    public static final String FIN_RAPPORT = "#";
    public static final String ENTETE_RAPPORT = "# SPRINT 3 INF 2050";
    public static final String TITRE_RAPPORT = "# RAPPORT STATISTIQUE" +
            " - EVALUATION TERRAIN";
    public static final String DELIMITEUR_EXTERNE = "\n**************" +
            "*******************************************************" +
            "**********\n";
    public static final String DELIMITEUR_INTERNE = "\n---------------" +
            "----------------------------------------------------------" +
            "------\n";
    public static final String ENTETE_COLONNE = "# No. | Libelle           " +
            "                                        | Valeur";


    private static final String ENTITE_0 = Utilitaire.afficherFormatRapport(
            NOMBRE_TOTAL_DE_LOTS_TERRAINS, 0) + "\n";
    private static final String ENTITE_1 = Utilitaire.afficherFormatRapport(
            NOMBRE_DE_LOTS_AVEC_VALEUR_PAR_LOT, 0)+ "\n"
            + Utilitaire.afficherFormatRapport(DE_MOINS_DE_1000_$, 0)
            + "\n"
            + Utilitaire.afficherFormatRapport(DE_1000_À_10000_$, 0)
            + "\n"
            + Utilitaire.afficherFormatRapport(DE_PLUS_DE_10000_$, 0)
            + "\n";

    private static final String ENTITE_2 = Utilitaire.afficherFormatRapport(
            NOMBRE_DE_LOTS_PAR_TYPE_DE_TERRAIN, 0)+ "\n"
            + Utilitaire.afficherFormatRapport(LOTS_DESC_TERRAIN_AGRICOLE, 0)
            + "\n"
            + Utilitaire.afficherFormatRapport(LOTS_DESC_TERRAIN_RESIDENTIEL,
            0)
            + "\n"
            + Utilitaire.afficherFormatRapport(LOTS_DESC_TERRAIN_COMMERCIAL, 0)
            + "\n";
    private static final String ENTITE_3 = Utilitaire.afficherFormatRapport(
            SUPERFICIE_MAXIMALE_SOUMISE_POUR_UN_LOT, 0) + "\n";
    private static final String ENTITE_4 = Utilitaire.afficherFormatRapport(
            VALEUR_PAR_LOT_MAXIMALE_POUR_UN_LOT, 0) + "\n";

    private File file;
    private IStatistique iStatistique;

    public RapportStatistique(IStatistique iStatistique) throws IOException {
        this.iStatistique = iStatistique;
        file = new File(RAPPORT);

        if (verifierFichierValide()) {
            file.createNewFile();
            genererRapportStat(file, initialiserRapportStatistique());
            lireFichierStatistiques();
        } else {
            lireFichierStatistiques();
        }
    }

    public RapportStatistique(File file) {
        this.file = file;
    }

    private boolean verifierFichierValide() {
        return !file.exists() || file.length() == 0;
    }

    public boolean reinitialiserRapportStatistique(File file)
            throws IOException {
        boolean estInitialise = false;
        file.createNewFile();
        genererRapportStat(file, initialiserRapportStatistique());

        int somme = obtenirSommeDesDonnees();

        if (somme == 0) {
            estInitialise = true;
        }

        return estInitialise;
    }

    private int obtenirSommeDesDonnees() throws IOException {
        int somme = 0;

        for (int i = 0; i < lireFichierStatistiques().size(); i++) {
            int donnee = obtenirDonnee(i);
            somme = somme + donnee;

        }
        return somme;
    }

    private String initialiserRapportStatistique() {
        return ENTETE_RAPPORT + DELIMITEUR_EXTERNE + TITRE_RAPPORT
                + DELIMITEUR_INTERNE + ENTETE_COLONNE + DELIMITEUR_INTERNE
                + ENTITE_0 + ENTITE_1 + ENTITE_2 + ENTITE_3 + ENTITE_4
                + FIN_RAPPORT + DELIMITEUR_EXTERNE;
    }

    @Override
    public void genererRapportStat(File file, String content)
            throws IOException {
        FileWriter fluxConnecteur = new FileWriter(file.getAbsoluteFile());
        BufferedWriter fluxTampon = new BufferedWriter(fluxConnecteur);
        fluxTampon.write(content);

        fluxTampon.close();
    }

    @Override
    public ArrayList<Statistique> lireFichierStatistiques()
            throws IOException {
        ArrayList<Statistique> statistiques = new ArrayList<>();

        FileReader fluxConnecteur = new FileReader(RAPPORT);
        BufferedReader fluxTampon = new BufferedReader(fluxConnecteur);

        while (fluxTampon.ready()) {
            obtenirDonneeStatistique(statistiques, fluxTampon);
        }

        fluxTampon.close();
        fluxConnecteur.close();

        return statistiques;
    }

    private void obtenirDonneeStatistique(ArrayList<Statistique> statistiques,
                                          BufferedReader fluxTampon)
            throws IOException {
        String ligne = fluxTampon.readLine();
        if (!ligne.startsWith(PREFIX_ETOILE) && !ligne.startsWith(FIN_RAPPORT)
                && !ligne.startsWith(PREFIX_TIRET) && !ligne.equals(ESPACE)) {
            construireModelStatistiques(statistiques, ligne);
        }
    }

    private void construireModelStatistiques(ArrayList<Statistique> statistiques,
                                        String ligne) {
        String[] donnees = ligne.split(SEPARATEUR_COLONNE);

        for (int i = 0; i < donnees.length; i++) {
            String numero = donnees[i].trim();
            i = i + 1;
            String libelle = donnees[i].trim();
            i = i + 1;
            int donnee = Integer.parseInt(donnees[i].trim());
            statistiques.add(new Statistique(numero, libelle, donnee));
        }
    }

    public void rapporterStatistiques(int tailleTotale,
                                      int nombreLot1000,
                                      int nombreLot1000_100000,
                                      int nombrePlus10000,
                                      int nombreLotTerrAgric,
                                      int nombreLotTerrResid,
                                      int nombreLotTerrCommer,
                                      int superficieMaximale,
                                      int valeurLotMaximale)
            throws IOException {
        String content = redigerContenuRapport(tailleTotale, nombreLot1000,
                nombreLot1000_100000, nombrePlus10000, nombreLotTerrAgric,
                nombreLotTerrResid, nombreLotTerrCommer,
                superficieMaximale, valeurLotMaximale);

        genererRapportStat(file, content);
    }

    public String redigerContenuRapport(int tailleTotale,
                                         int nombreLot1000,
                                         int nombreLot1000_100000,
                                         int nombrePlus10000,
                                         int nombreLotTerrAgric,
                                         int nombreLotTerrResid,
                                         int nombreLotTerrCommer,
                                         int superficieMaximale,
                                         int valeurLotMaximale)
            throws IOException {
        String content1 = obtenirValeur(obtenirDonnee(0)
                + tailleTotale, NOMBRE_TOTAL_DE_LOTS_TERRAINS);

        String content2 = obtenirNombreLotParValeur(nombreLot1000,
                nombreLot1000_100000, nombrePlus10000);

        String content3 = obtenirNombreLotTerra(nombreLotTerrAgric,
                nombreLotTerrResid, nombreLotTerrCommer);

        String content4 = obtenirValeur(obtenirValeurMaximale(9,
                superficieMaximale), SUPERFICIE_MAXIMALE_SOUMISE_POUR_UN_LOT);

        String content5 = obtenirValeur(obtenirValeurMaximale(10,
                valeurLotMaximale), VALEUR_PAR_LOT_MAXIMALE_POUR_UN_LOT);

        return ENTETE_RAPPORT + DELIMITEUR_EXTERNE + TITRE_RAPPORT
                + DELIMITEUR_INTERNE + ENTETE_COLONNE + DELIMITEUR_INTERNE
                + content1 + content2 + content3 + content4 + content5
                + FIN_RAPPORT + DELIMITEUR_EXTERNE;
    }

    private String obtenirValeur(int donnee,
                                 String nombreTotalDeLotsTerrains) {
        return Utilitaire.afficherFormatRapport(
                nombreTotalDeLotsTerrains, donnee)
                + "\n";
    }

    private String obtenirNombreLotTerra(int nombreLotTerrAgric,
                                         int nombreLotTerrResid,
                                         int nombreLotTerrCommer)
            throws IOException {
        int nombreLotTerrain1 = obtenirDonnee(6) + nombreLotTerrAgric;
        int nombreLotTerrain2 = obtenirDonnee(7) + nombreLotTerrResid;
        int nombreLotTerrain3 = obtenirDonnee(8) + nombreLotTerrCommer;
        return Utilitaire.afficherFormatRapport(
                NOMBRE_DE_LOTS_PAR_TYPE_DE_TERRAIN, nombreLotTerrain1
                        + nombreLotTerrain2 + nombreLotTerrain3)+ "\n"
                + Utilitaire.afficherFormatRapport(
                        LOTS_DESC_TERRAIN_AGRICOLE, nombreLotTerrain1)
                + "\n"
                + Utilitaire.afficherFormatRapport(
                        LOTS_DESC_TERRAIN_RESIDENTIEL, nombreLotTerrain2)
                + "\n"
                + Utilitaire.afficherFormatRapport(
                        LOTS_DESC_TERRAIN_COMMERCIAL, nombreLotTerrain3)
                + "\n";
    }

    private String obtenirNombreLotParValeur(int nombreLot1000,
                                             int nombreLot1000_100000,
                                             int nombrePlus10000)
            throws IOException {
        int nombreLot1 = obtenirDonnee(2) + nombreLot1000;
        int nombreLot2 = obtenirDonnee(3) + nombreLot1000_100000;
        int nombreLot3 = obtenirDonnee(4) + nombrePlus10000;

        return Utilitaire.afficherFormatRapport(
                NOMBRE_DE_LOTS_AVEC_VALEUR_PAR_LOT, (nombreLot1
                        + nombreLot2 + nombreLot3))+ "\n"
                + Utilitaire.afficherFormatRapport(DE_MOINS_DE_1000_$,
                nombreLot1)
                + "\n"
                + Utilitaire.afficherFormatRapport(DE_1000_À_10000_$,
                nombreLot2)
                + "\n"
                + Utilitaire.afficherFormatRapport(DE_PLUS_DE_10000_$,
                nombreLot3)
                + "\n";
    }

    private int obtenirValeurMaximale(int index, int valeur)
            throws IOException {
        int tempValeurLot = obtenirDonnee(index);
        int valeurMax;

        if (tempValeurLot > valeur) {
            valeurMax = tempValeurLot;
        } else {
            valeurMax = valeur;
        }
        return valeurMax;
    }

    private int obtenirDonnee(int index) throws IOException {
        return lireFichierStatistiques().get(index).getDonnee();
    }

}