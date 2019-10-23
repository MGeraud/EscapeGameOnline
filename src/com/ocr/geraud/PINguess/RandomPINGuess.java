package com.ocr.geraud.PINguess;

import com.ocr.geraud.player.Player;

public class RandomPINGuess implements PINguess{

    @Override
    public void pinTest(Player attaquant, Player defenseur) {
        String createTmpPIN = "";
        // creation au 1er essai donc hasard complet
        if (attaquant.getTmpPIN() == "") {
            int i;
            for (i = 0; i <= 3; i++) {
                ;
                int tmpDigit = (int) (10 * (Math.random()));
                String tmpString = Integer.toString(tmpDigit);
                createTmpPIN = createTmpPIN + tmpString;
            }
        } else {
            // boucle passant chaque caractere de la comparaison pour déterminer les nouvelles limmites du random
            int i;
            int tmpDigit;
            String tmpString ="";
            for (i=0 ; i <= 3 ; i++) {
                switch (defenseur.getTmpComparisonAnswer().charAt(i)) {
                    case '=' :
                        tmpString = tmpString + attaquant.getTmpPIN().charAt(i);
                        break;
                    case '+' :

                }
            }
        }

    }
}
