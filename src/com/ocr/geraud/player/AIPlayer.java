package com.ocr.geraud.player;

public class AIPlayer {


    private String secretAIPIN = "";
    int i;

    public void createSecretAIPIN() {
        for (i = 0; i <= 3; i++) {
            ;
            int tmpDigit = (int) (10 * (Math.random()));
            char tmpChar = Character.forDigit(tmpDigit, 10);
            String tmpString = Character.toString(tmpChar);
            secretAIPIN = secretAIPIN + tmpString;
        }
    }
}
