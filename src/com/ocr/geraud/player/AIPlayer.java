package com.ocr.geraud.player;

import com.ocr.geraud.LoadProperties;

public class AIPlayer extends Player {

    int i;

    @Override
    public void createSecretPIN() {
        System.out.println("C'est parti, Mr Bot a choisi sa combinaison secrète !");
        for (i = 0; i <= (pinLenght - 1); i++) {
            ;
            int tmpDigit = (int) (10 * (Math.random()));
            String tmpString = Integer.toString(tmpDigit);
            secretPIN = secretPIN + tmpString;
        }
    }

    public String getSecretPIN() {
        return secretPIN;
    }
}
