package com.ocr.geraud.gameMode;


import com.ocr.geraud.LoadProperties;
import com.ocr.geraud.PINguess.PINguess;
import com.ocr.geraud.PINguess.RandomPINGuess;
import com.ocr.geraud.PINguess.ScanPINGuess;
import com.ocr.geraud.compareMethods.AIComparison;
import com.ocr.geraud.compareMethods.Comparison;
import com.ocr.geraud.compareMethods.HumanComparison;
import com.ocr.geraud.player.AIPlayer;
import com.ocr.geraud.player.HumanPlayer;
import com.ocr.geraud.player.Player;

public class DefenderStrategy implements ModeJeuStrategy{

    String maxtries = LoadProperties.getInstance().getProperty("MaxTries");
    int maxTries = Integer.parseInt(maxtries);
    Player challenger = new AIPlayer();
    Player defender = new HumanPlayer();

    @Override
    public void jouer() {
        challenger.resetLimitMax();
        challenger.resetLimitMin();
        PINguess challengerPINGuess = new RandomPINGuess();
        Comparison defenderComparison = new HumanComparison();

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
        } while (winner == false && i <= maxTries);
        if (winner == true) {
            System.out.println("Mr Bot a trouvé votre combinaison sans tricher en " + i + " essais.");
        }
        if (i > maxTries) {
            System.out.println("Vous avez réussi a pièger Mr Bot!");
        }
    }
}

