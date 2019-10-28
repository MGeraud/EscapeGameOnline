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

public class DualStrategy implements ModeJeuStrategy {
    private Player humanPlayer = new HumanPlayer();
    private Player aiPlayer = new AIPlayer();
    private String maxtries = LoadProperties.getInstance().getProperty("MaxTries");
    private int maxTries = Integer.parseInt(maxtries);


    @Override
    public void jouer() {
        PINguess humanPINGuess = new ScanPINGuess();
        PINguess aiPINGuess = new RandomPINGuess();
        Comparison humanComparison = new HumanComparison();
        Comparison aiComparison = new AIComparison();
        aiPlayer.createSecretPIN();
        humanPlayer.createSecretPIN();
        boolean winnerHuman = false , winnerAI = false;
        aiPlayer.resetLimitMin();
        aiPlayer.resetLimitMax();
        int i = 1;


        do {
            System.out.println("Essai  numero : " + i);
            humanPINGuess.pinTest(humanPlayer,aiPlayer);
            aiComparison.comparer(humanPlayer,aiPlayer);
            if (humanPlayer.getTmpPIN().equals(aiPlayer.getSecretPIN())) {
                winnerHuman = true;
            }
            aiPINGuess.pinTest(aiPlayer,humanPlayer);
            humanComparison.comparer(aiPlayer,humanPlayer);
            if (aiPlayer.getTmpPIN().equals(humanPlayer.getSecretPIN())) {
                winnerAI = true;
            }
            i++;
        } while (!winnerAI && !winnerHuman && i <= maxTries);

        if (winnerAI && winnerHuman) {
            System.out.println("Je ne sais pas comment c'est possible , mais EGALITE");
        } else if (winnerAI ) {
            System.out.println("Mr Bot a gagné, il a été le plus rapide pour une fois ...");
        } else if (winnerHuman) {
            System.out.println("Vous avez vaincu Mr Bot, TROP fort!");
        } else  {
            System.out.println("Aucun de vous n'a trouvé le code secret de l'autre, on pourrait dire EGALITE ... ou PERDU tous les 2!!!!");
        }

    }
}
