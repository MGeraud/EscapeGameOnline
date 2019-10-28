package com.ocr.geraud.compareMethods;

import com.ocr.geraud.player.AIPlayer;
import com.ocr.geraud.player.HumanPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AIComparisonTest {
    AIComparison p = new AIComparison();

    @Test
    void Given_goodAnswer_When_comparingPIN_Then_DisplayEqualsChar() {
        AIPlayer d = new AIPlayer();
        HumanPlayer a = new HumanPlayer();
        d.createSecretPIN();
        a.setTmpPIN(d.getSecretPIN());
        p.comparer(a,d);
        assertEquals("====", d.getTmpComparisonAnswer());
    }
}