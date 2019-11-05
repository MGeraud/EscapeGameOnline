package com.ocr.geraud;

import com.ocr.geraud.gameMode.ChallengerStrategy;
import com.ocr.geraud.gameMode.DefenderStrategy;
import com.ocr.geraud.gameMode.DualStrategy;
import com.ocr.geraud.gameMode.ModeJeuStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Game {
    private String pinLenghtString = LoadProperties.getInstance().getProperty("PINLenght");
    private int modeChoice;
    private String replayChoice ;
    private Scanner sc = new Scanner(System.in);
    private static final Logger logger = LogManager.getLogger(Game.class);

    /**
     * print game's introduction out
     * doesn't appear when replay
     */
    private void introduce() {
        System.out.println("Vous voila arrivés au défi de recherche de combinaison secrète d'Escape Game Online.");
        System.out.println("\nVous avez le choix entre 3 modes de jeu :");
        System.out.println("\nLe mode challenger : il vous faudra deviner la combinaison de " + pinLenghtString + " chiffres choisie par Mr Bot." );
        System.out.println("Le mode defenseur : il vous faudra choisir une combinaison de " + pinLenghtString + " chiffres, en espérant que Mr Bot n'arrivera pas à la deviner.");
        System.out.println("Le mode duel : Vous et Mr Bot choisissez chacun une combinaison de "+ pinLenghtString + " chiffres. Puis tour a tour vous essayez de deviner la combinaison de l'autre.");
    }

    /**
     * loop to choose game mode
     */
    private void chooseMode() {
            do {
                System.out.println("\nPour choisir Challenger tapez 1 , pour Defenseur tapez 2 , pour Duel tapez 3");
                try{
                    modeChoice = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    logger.error("Le joueur a saisi autre chose qu'un chiffre lors du choix de Mode de jeu. "+ e);
                    System.out.println("Vous devez saisir 1 , 2 ou 3 ");
                    sc.reset();
                    modeChoice = 0;
                }
        } while (modeChoice != 1 && modeChoice!= 2 && modeChoice!= 3);
    }

    /**
     * Uses Strategy Pattern on different game modes
     * All this into loop in case of replay choice
     */
    private void playChoosenMode() {
        do {
            replayChoice ="";
            switch (modeChoice) {
                case 1:
                    logger.info("Lancement de la strategie challenger");
                    ModeJeuStrategy challenger = new ChallengerStrategy();
                    challenger.jouer();
                    break;
                case 2:
                    logger.info("Lancement de la strategie defender");
                    ModeJeuStrategy defenseur = new DefenderStrategy();
                    defenseur.jouer();
                    break;
                case 3:
                    logger.info("Lancement de la strategie dual");
                    ModeJeuStrategy duel = new DualStrategy();
                    duel.jouer();
                    break;
            }
            System.out.println("\nVous avez maintenant 3 options : \nRejouer le même mode de jeu, tapez : R \nJouer à un autre mode du jeu, tapez : J \nArrêter de jouer, tapez : A");
            do {
                replayChoice = sc.nextLine();
                replayChoice = replayChoice.toLowerCase();
                if (!"r".equals(replayChoice) && !"j".equals(replayChoice) && !"a".equals(replayChoice)){
                    logger.info("Le joueur a saisi autre chose que les choix proposer pour rejouer ou non");
                    System.out.println("Vous devez choisir entre R , J ou A .");
                }
            }while (!"r".equals(replayChoice) && !"j".equals(replayChoice) && !"a".equals(replayChoice));
        }while ("r".equals(replayChoice));
    }

    /**
     * run method
     * return to same game, play different game or stop game
     */
    public void run() {
        this.introduce();
        do {
            this.chooseMode();
            this.playChoosenMode();
        }while (replayChoice.equals("j"));
        if (replayChoice.equals("a")) {
            System.out.println("Merci d'avoir joué avec nous. A bientôt.");
            System.exit(0);
        }
    }

}
