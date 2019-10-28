package com.ocr.geraud.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AIPlayerTest {
    AIPlayer p = new AIPlayer();

    @Test
    void createSecretPIN() {
        p.createSecretPIN();
        assertEquals(p.secretPIN.length(),4);
    }
}