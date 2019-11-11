package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void kortinSaldoAlussaOikein() {
        assertEquals(10, kortti.saldo());
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void rahanLataaminenKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(25);
        assertEquals(35, kortti.saldo());
    }
    
    @Test
    public void rahanOttaminenVahentaaSaldoaOikeinJosRahaaOnTarpeeksi() {
        kortti.otaRahaa(5);
        assertEquals(5, kortti.saldo());
    }
    
    @Test
    public void rahanOttaminenEiVahennaSaldoaJosRahaaEiOleTarpeeksi() {
        kortti.otaRahaa(15);
        assertEquals(10, kortti.saldo());
    }
    
    @Test
    public void otaRahaaPalauttaaTrueJosRahaaOtetaanAlleSaldonVerran() {
        assertTrue(kortti.otaRahaa(8));
    }
    
    @Test
    public void otaRahaaPalauttaaTrueJosRahaaOtetaanTasanSaldonVerran() {
        assertTrue(kortti.otaRahaa(10));
    }
    
    @Test
    public void otaRahaaPalauttaaFalseJosRahatEivatRiittaneet() {
        assertFalse(kortti.otaRahaa(11));
    }
}
