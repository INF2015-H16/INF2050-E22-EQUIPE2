package inf2050.e22.equipe2;

import java.io.IOException;
import java.text.ParseException;

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

public interface IStatistique {


    void getSuperficieMaximale()
            throws LotValideException, IOException, ParseException,
            IntervallesValideException, LectureFichierException;

    void getValeurLotMaximale() throws LotValideException, IOException,
            IntervallesValideException, LectureFichierException, ParseException;

    void obenirCalculRapportStatistiques() throws IOException;
}