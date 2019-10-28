package com.ocr.geraud;


import com.ocr.geraud.gameMode.ChallengerStrategy;
import com.ocr.geraud.gameMode.DefenderStrategy;
import com.ocr.geraud.gameMode.DualStrategy;
import com.ocr.geraud.gameMode.ModeJeuStrategy;

import java.util.Scanner;

public class Game {
    private String pinLenghtString = LoadProperties.getInstance().getProperty("PINLenght");
    private int modeChoice;
    private String replayChoice;
    Scanner sc = new Scanner(System.in);


    public void introduce() {
        System.out.println("Vous voila arrivés au défi de recherche de cobinaison secrète d'Escape Game Online.");
        System.out.println("\nVous avez le choix entre 3 modes de jeu :");
        System.out.println("\nLe mode challenger : il vous faudra deviner la combinaison de " + pinLenghtString + " chiffres choisie par Mr Bot." );
        System.out.println("Le mode defenseur : il vous faudra choisir une combinaison de " + pinLenghtString + " chiffres, en espérant que Mr Bot n'arrivera pas à la deviner.");
        System.out.println("Le mode duel : Vous et Mr Bot choisissez chacun une combinaison de "+ pinLenghtString + " chiffres. Puis tour a tour vous essayez de deviner la combinaison de l'autre.");
    }
    public void chooseMode() {
        do {
            System.out.println("\nPour choisir Challenger tapez 1 , pour Defenseur tapez 2 , pour Duel tapez 3");
            modeChoice = sc.nextInt();
        } while (modeChoice != 1 && modeChoice!=2 && modeChoice!=3);
    }

    public void playChoosenMode() {
        do {
            switch (modeChoice) {
                case 1:
                    ModeJeuStrategy challenger = new ChallengerStrategy();
                    challenger.jouer();
                    break;
                case 2:
                    ModeJeuStrategy defenseur = new DefenderStrategy();
                    defenseur.jouer();
                    break;
                case 3:
                    ModeJeuStrategy duel = new DualStrategy();
                    duel.jouer();
                    break;
            }
            do {
                System.out.println("\nVous avez maintenant 3 options : \nRejouer le même mode de jeu, tapez : R \nJouer à un autre mode du jeu, tapez : J \nArrêter de jouer, tapez : A");
                replayChoice = sc.nextLine();
                replayChoice = replayChoice.toLowerCase();
            } while (!"r".equals(replayChoice) && !"j".equals(replayChoice) && !"a".equals(replayChoice));
            }while ("r".equals(replayChoice));
    }

    public void run() {
        this.introduce();
        do {
            this.chooseMode();
            this.playChoosenMode();
        }while (replayChoice.equals("j"));
        if (replayChoice.equals("r")) {
            System.out.println("Merci d'avoir joué avec nous. A bientôt.");
            System.exit(0);
        }
    }

}
