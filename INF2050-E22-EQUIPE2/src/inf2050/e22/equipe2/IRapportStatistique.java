package inf2050.e22.equipe2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


/**
 *  * Université du Québec à Montréal (UQAM)
 *  * Cours : INF2050 - 020 - Été 2022
 *  * Sprint 3
 *
 *  *
 *   @author Jordan Mone
 *  * @version 20 Juillet 2022
 *  *
 *  */

public interface IRapportStatistique {

    void genererRapportStat(File file, String content)
            throws IOException;
    ArrayList<Statistique> lireFichierStatistiques()
            throws IOException;
}