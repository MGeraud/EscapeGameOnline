package com.ocr.geraud.gameMode;

import com.ocr.geraud.LoadProperties;
import com.ocr.geraud.PINguess.PINguess;
import com.ocr.geraud.PINguess.ScanPINGuess;
import com.ocr.geraud.compareMethods.AIComparison;
import com.ocr.geraud.compareMethods.Comparison;
import com.ocr.geraud.player.AIPlayer;
import com.ocr.geraud.player.HumanPlayer;
import com.ocr.geraud.player.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChallengerStrategy implements ModeJeuStrategy {
    private Player challenger = new HumanPlayer();
    private Player defender = new AIPlayer();
    private String maxtries = LoadProperties.getInstance().getProperty("MaxTries");
    private int maxTries = Integer.parseInt(maxtries);

    private static final Logger logger = LogManager.getLogger(ChallengerStrategy.class);


    @Override
    public void jouer() {
        PINguess challengerPINGuess = new ScanPINGuess();
        Comparison defenderComparison = new AIComparison();
        defender.createSecretPIN();
        boolean winner = false;
        int i = 1;


        do {
            System.out.println("Essai  numero : " + i);
            challengerPINGuess.pinTest(challenger,defender);
            defenderComparison.comparer(challenger,defender);
            if (challenger.getTmpPIN().equals(defender.getSecretPIN())) {
                winner = true;
            }
            i++;
        } while (!winner && i <= maxTries);
        if (winner) {
            System.out.println("Bravo! Vous avez trouvé la bonne combinaison.");
            logger.info("Le joueur a trouvé la bonne combinaison.");
        }
        if (i > maxTries) {
            System.out.println("Perdu, vous avez épuisé tous vos essais");
        }
    }
}
