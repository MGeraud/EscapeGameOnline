package com.ocr.geraud.player;

public class AIPlayer extends Player {


    private String secretPIN = "";
    int i;

    public void createSecretPIN() {
        for (i = 0; i <= 3; i++) {
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
