package com.ocr.geraud;

import com.ocr.geraud.PINguess.ScanPINGuess;
import com.ocr.geraud.compareMethods.HumanComparison;
import com.ocr.geraud.gameMode.ChallengerStrategy;
import com.ocr.geraud.gameMode.DefenderStrategy;
import com.ocr.geraud.player.AIPlayer;
import com.ocr.geraud.player.HumanPlayer;

import java.io.*;
import java.util.Properties;

public class Main {

    public static void main(String[] args){
        DefenderStrategy p = new DefenderStrategy();
        p.jouer();



}
}
