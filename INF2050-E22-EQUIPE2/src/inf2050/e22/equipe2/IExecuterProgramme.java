package inf2050.e22.equipe2;

/**
 * Université du Québec à Montréal (UQAM)
 * Cours : INF2050 - 020 - Été 2022
 * Sprint 3
 *
 * IExecuterProgramme : Cette interface se comporte à peu près comme un menu.
 *                      Elle offre trois choix, à savoir lancer le programme,
 *                      fournir le rapport statistique et réinitialiser
 *                      le programme.
 *
 *
 * @author Elza Meguieng Tiemghen
 * @version juillet 2022
 *
 */
public interface IExecuterProgramme {

    void lancerProgramme(String entree, String Sortie);
    void rapporterStatistique();
    void reinitialiserStatistique();
}