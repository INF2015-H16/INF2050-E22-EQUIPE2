/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inf2050.e22.equipe2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author akaff
 */
public class RapportStatistique {

    public static final String RAPPORT = "rapport.txt";
    public static final String NOMBRE_TOTAL_DE_LOTS_TERRAINS
            = "* le nombre total de lots soumis tous terrains confondus : ";
    public static final String NOMBRE_DE_LOTS_AVEC_VALEUR_PAR_LOT
            = "* le nombre de lots avec une valeur par lot : ";
    public static final String DE_MOINS_DE_1000_$
            = "              - de moins de 1000$ : ";
    public static final String DE_1000_À_10000_$
            = "              - de 1000 à 10000$ : ";
    public static final String DE_PLUS_DE_10000_$
            = "              - de plus de 10000$ : ";
    public static final String NOMBRE_DE_LOTS_PAR_TYPE_DE_TERRAIN
            = "* le nombre de lots par type de terrain : ";
    public static final String SUPERFICIE_MAXIMALE_SOUMISE_POUR_UN_LOT
            = "* la superficie maximale soumise pour un lot : ";
    public static final String VALEUR_PAR_LOT_MAXIMALE_POUR_UN_LOT
            = "* la valeur par lot maximale pour un lot : ";

    public static void rapporterStatistiques() throws IOException {
        String entete = "SPRINT 3 INF 2050";
        String titre = "RAPPORT STATISTIQUE - EVALUATION TERRAIN" +
                "                 No : " + 1;
        String content0 = "\n-------------------------------------------" +
                "--------------------------\n";
        String content1 = Utilitaire.afficherFormatRapport(
                NOMBRE_TOTAL_DE_LOTS_TERRAINS, 10)
                + "\n";
        String content2 = Utilitaire.afficherFormatRapport(
                NOMBRE_DE_LOTS_AVEC_VALEUR_PAR_LOT, 60)+ "\n"
                + Utilitaire.afficherFormatRapport(DE_MOINS_DE_1000_$, 20)
                + "\n"
                + Utilitaire.afficherFormatRapport(DE_1000_À_10000_$, 20)
                + "\n"
                + Utilitaire.afficherFormatRapport(DE_PLUS_DE_10000_$, 20)
                + "\n";
        String content3 = Utilitaire.afficherFormatRapport(
                NOMBRE_DE_LOTS_PAR_TYPE_DE_TERRAIN, 10) + "\n";
        String content4 = Utilitaire.afficherFormatRapport(
                SUPERFICIE_MAXIMALE_SOUMISE_POUR_UN_LOT, 10) + "\n";
        String content5 = Utilitaire.afficherFormatRapport(
                VALEUR_PAR_LOT_MAXIMALE_POUR_UN_LOT, 10) + "\n";

        String content = entete + content0 + titre + content0 + content1
                + content2 + content3 + content4 + content5 + content0;

        File file = new File(RAPPORT);

        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content);

        bw.close();
    }

}