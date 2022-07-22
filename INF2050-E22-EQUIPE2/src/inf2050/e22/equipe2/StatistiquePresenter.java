package inf2050.e22.equipe2;

import java.io.IOException;

/**
 * Université du Québec à Montréal (UQAM)
 * Cours : INF2050 - 020 - Été 2022
 * Sprint 3
 *
 * Statistique : Cette classe contient les données
 *  *            sur la gestion des statistiques.
 *
 *
 * @author Jordan Mone
 * @version juillet 2022
 *
 */
public class StatistiquePresenter {

    private IStatistique iStatistique;

    public StatistiquePresenter(IStatistique iStatistique) {
        this.iStatistique = iStatistique;
    }

    public void obenirCalculStatistiques() throws IOException {
        iStatistique.obenirCalculRapportStatistiques();
    }
}