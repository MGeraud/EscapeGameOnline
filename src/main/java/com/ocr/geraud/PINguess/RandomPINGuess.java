package com.ocr.geraud.PINguess;

import com.ocr.geraud.LoadProperties;
import com.ocr.geraud.player.Player;

public class RandomPINGuess implements PINguess{
    private String pinLenghtString = LoadProperties.getInstance().getProperty("PINLenght");
    private int pinLenght = Integer.parseInt(pinLenghtString);

    @Override
    public void pinTest(Player attaquant, Player defenseur) {
        String createTmpPIN = "";
        // creation au 1er essai donc hasard complet
        if (attaquant.getTmpPIN().equals("")) {
            int i;
            for (i = 0; i <= (pinLenght - 1); i++) {
                int tmpDigit = (int) (10 * (Math.random()));
                String tmpString = Integer.toString(tmpDigit);
                createTmpPIN = createTmpPIN + tmpString;
            }
        } else {
            // boucle passant chaque caractere de la comparaison pour lancer un nouveau random
            int i;
            int tmpDigit;
            String tmpString = "";
            for (i=0 ; i <= (pinLenght - 1) ; i++) {
                if (defenseur.getTmpComparisonAnswer().charAt(i) == '=') {
                    tmpString = tmpString + attaquant.getTmpPIN().charAt(i);
                } else  {
                        tmpDigit = attaquant.getLimitMin()[i]  + (int) ( Math.random() * ((attaquant.getLimitMax()[i] - attaquant.getLimitMin()[i]) +1 ) );
                        tmpString = tmpString + tmpDigit;
                }
            }
            createTmpPIN = tmpString;
        }
        System.out.println("Mr Bot propose : " + createTmpPIN);
        attaquant.setTmpPIN(createTmpPIN);
    }
}
