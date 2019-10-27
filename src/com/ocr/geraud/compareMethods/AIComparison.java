package com.ocr.geraud.compareMethods;

import com.ocr.geraud.LoadProperties;
import com.ocr.geraud.player.Player;

public class AIComparison implements Comparison{

    @Override
    public void comparer(Player challenger, Player defender) {
        String pinLenghtString = LoadProperties.getInstance().getProperty("PINLenght");
        int pinLenght = Integer.parseInt(pinLenghtString);
        String tmpComparison = "";
        for (int i = 0 ; i <= (pinLenght - 1) ; i++ ){
            if (challenger.getTmpPIN().charAt(i) == defender.getSecretPIN().charAt(i)) {
                tmpComparison = tmpComparison + "=";
            } else if (challenger.getTmpPIN().charAt(i) < defender.getSecretPIN().charAt(i)) {
                tmpComparison = tmpComparison + "+";

            } else if (challenger.getTmpPIN().charAt(i) > defender.getSecretPIN().charAt(i)) {
                tmpComparison = tmpComparison + "-";

            }
        }
        defender.setTmpComparisonAnswer(tmpComparison);
        System.out.println("Mr Bot vous annonce le résultat de la comparaison : " + tmpComparison);
    }
}
