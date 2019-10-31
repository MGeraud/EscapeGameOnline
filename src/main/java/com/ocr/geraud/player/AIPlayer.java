package com.ocr.geraud.player;

import com.ocr.geraud.LoadProperties;

public class AIPlayer extends Player {
    private String devMode = LoadProperties.getInstance().getProperty("devMode");
    private int i;

    @Override
    public void createSecretPIN() {
        System.out.println("C'est parti, Mr Bot a choisi sa combinaison secrète !");
        for (i = 0; i <= (pinLenght - 1); i++) {
            int tmpDigit = (int) (10 * (Math.random()));
            String tmpString = Integer.toString(tmpDigit);
            secretPIN = secretPIN + tmpString;
        }
        if (devMode.equals("true")) System.out.println("Vous êtes en mode developper, voici la combinaison secrete choisie par Mr Bot " + secretPIN);
    }

    public String getSecretPIN() {
        return secretPIN;
    }
}
