/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inf2050.e22.equipe2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author akaff
 */
public class RapportStatistique implements IRapportStatistique {

    public static final String RAPPORT = "rapport.txt";
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
    public static String entete = "# SPRINT 3 INF 2050";
    public static String titre = "# RAPPORT STATISTIQUE - EVALUATION TERRAIN";
    public static String delimiteur0 = "\n************************************" +
            "**********************************************\n";
    public static String delimiteur1 = "\n------------------------------------" +
            "----------------------------------------------\n";
    public static String enteteColonne = "# No. | Libelle                    " +
            "                               | Valeur";

    private final String content1 = Utilitaire.afficherFormatRapport(
            NOMBRE_TOTAL_DE_LOTS_TERRAINS, 0)
            + "\n";
    private final String content2 = Utilitaire.afficherFormatRapport(
            NOMBRE_DE_LOTS_AVEC_VALEUR_PAR_LOT, 0)+ "\n"
            + Utilitaire.afficherFormatRapport(DE_MOINS_DE_1000_$, 0)
            + "\n"
            + Utilitaire.afficherFormatRapport(DE_1000_À_10000_$, 0)
            + "\n"
            + Utilitaire.afficherFormatRapport(DE_PLUS_DE_10000_$, 0)
            + "\n";

    private final String content3 = Utilitaire.afficherFormatRapport(
            NOMBRE_DE_LOTS_PAR_TYPE_DE_TERRAIN, 0)+ "\n"
            + Utilitaire.afficherFormatRapport(LOTS_DESC_TERRAIN_AGRICOLE, 0)
            + "\n"
            + Utilitaire.afficherFormatRapport(LOTS_DESC_TERRAIN_RESIDENTIEL, 0)
            + "\n"
            + Utilitaire.afficherFormatRapport(LOTS_DESC_TERRAIN_COMMERCIAL, 0)
            + "\n";
    private final String content4 = Utilitaire.afficherFormatRapport(
            SUPERFICIE_MAXIMALE_SOUMISE_POUR_UN_LOT, 0) + "\n";
    private final String content5 = Utilitaire.afficherFormatRapport(
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

    private boolean verifierFichierValide() {
        return !file.exists() || file.length() == 0;
    }

    private String initialiserRapportStatistique() {
        return entete + delimiteur0 + titre
                + delimiteur1 + enteteColonne + delimiteur1 + content1
                + content2 + content3 + content4 + content5
                + FIN_RAPPORT + delimiteur0;
    }

    @Override
    public void genererRapportStat(File file, String content) throws IOException {
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content);

        bw.close();
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
        if (!ligne.startsWith("*") && !ligne.startsWith("#")
                && !ligne.startsWith("-") && !ligne.equals(" ")) {
            construireModelStatistiques(statistiques, ligne);
        }
    }

    private void construireModelStatistiques(ArrayList<Statistique> statistiques,
                                        String ligne) {
        String[] donnees = ligne.split("\\|");

        for (int i = 0; i < donnees.length; i++) {
            String numero = donnees[i].trim();
            i = i + 1;
            String libelle = donnees[i].trim();
            i = i + 1;
            int donnee = Integer.parseInt(donnees[i].trim());
            statistiques.add(new Statistique(numero, libelle, donnee));
        }
    }

    @Override
    public double obtenirMontantRepartiParLot(double [] montantsParLots,
                                              ArrayList<Lotissement> lotissements) {
        double montantParLot = 0;

        for (int i = 0; i < lotissements.size(); i++) {
            montantParLot = montantsParLots[i];
        }

        return montantParLot;
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

    private String redigerContenuRapport(int tailleTotale,
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

        return entete + delimiteur0 + titre
                + delimiteur1 + enteteColonne + delimiteur1 + content1
                + content2 + content3 + content4 + content5
                + FIN_RAPPORT + delimiteur0;
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