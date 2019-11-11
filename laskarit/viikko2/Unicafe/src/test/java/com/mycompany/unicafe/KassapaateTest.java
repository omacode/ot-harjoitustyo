
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {

    Kassapaate paate;
    
    @Before
    public void setUp() {
        paate = new Kassapaate();
    }

    @Test
    public void luodunKassapaatteenTilaOnAlussaKunnossa() {
        assertEquals(100000, paate.kassassaRahaa());
        assertEquals(0, paate.edullisiaLounaitaMyyty());
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void edullisenLounaanOstoRiittavallaMaarallaKateistaLiikuttaaRahaaOikein() {
        assertEquals(260, paate.syoEdullisesti(500));
        assertEquals(100240, paate.kassassaRahaa());
    }
    
    @Test
    public void edullisenLounaanOstoRiittavallaMaarallaKateistaKasvattaaMyytyjenMaraa() {
        paate.syoEdullisesti(500);
        assertEquals(1, paate.edullisiaLounaitaMyyty());
    }    

    @Test
    public void edullisenLounaanOstoEiRiittavallaMaarallaKateistaToimiiOikein() {
        assertEquals(200, paate.syoEdullisesti(200));
        assertEquals(100000, paate.kassassaRahaa());        
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }    
    
    @Test
    public void maukkaanLounaanOstoRiittavallaMaarallaKateistaLiikuttaaRahaaOikein() {
        assertEquals(100, paate.syoMaukkaasti(500));
        assertEquals(100400, paate.kassassaRahaa());
    }
    
    @Test
    public void maukkaanLounaanOstoRiittavallaMaarallaKateistaKasvattaaMyytyjenMaraa() {
        paate.syoMaukkaasti(500);
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void maukkaanLounaanOstoEiRiittavallaMaarallaKateistaToimiiOikein() {
        assertEquals(350, paate.syoMaukkaasti(350));
        assertEquals(100000, paate.kassassaRahaa());        
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void edullisenLounaanOstoVeloittaaKorttiaOikeinKunKortillaOnTarpeeksiRahaa() {
        Maksukortti kortti = new Maksukortti(500);
        assertTrue(paate.syoEdullisesti(kortti));
        assertEquals(260, kortti.saldo());
    }
    
    @Test
    public void edullisenLounaanOstoKortillaRahanRiittaessaKasvattaaMyytyjenMaraa() {
        Maksukortti kortti = new Maksukortti(500);
        paate.syoEdullisesti(kortti);
        assertEquals(1, paate.edullisiaLounaitaMyyty());
    }    
    
    @Test
    public void edullisenLounaanOstoKortillaJollaEiOleRiittavastiRahaaToimiiOikein() {
        Maksukortti kortti = new Maksukortti(200);
        assertFalse(paate.syoEdullisesti(kortti));
        assertEquals(200, kortti.saldo());
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void edullisenLounaanOstoKortillaEiMuutaKassanRahamaaraa() {
        Maksukortti kortti = new Maksukortti(500);
        paate.syoEdullisesti(kortti);
        assertEquals(100000, paate.kassassaRahaa());
    }
    
    @Test
    public void maukkaanLounaanOstoVeloittaaKorttiaOikeinKunKortillaOnTarpeeksiRahaa() {
        Maksukortti kortti = new Maksukortti(500);
        assertTrue(paate.syoMaukkaasti(kortti));
        assertEquals(100, kortti.saldo());
    }
    
    @Test
    public void maukkaanLounaanOstoKortillaRahanRiittaessaKasvattaaMyytyjenMaraa() {
        Maksukortti kortti = new Maksukortti(500);
        paate.syoMaukkaasti(kortti);
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void maukkaanLounaanOstoKortillaJollaEiOleRiittavastiRahaaToimiiOikein() {
        Maksukortti kortti = new Maksukortti(200);
        assertFalse(paate.syoMaukkaasti(kortti));
        assertEquals(200, kortti.saldo());
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void maukkaanLounaanOstoKortillaEiMuutaKassanRahamaaraa() {
        Maksukortti kortti = new Maksukortti(500);
        paate.syoMaukkaasti(kortti);
        assertEquals(100000, paate.kassassaRahaa());
    }
    
    @Test
    public void eiNegatiivisenRahamaaranLataaminenKortilleMuuttaaKortinJaKassanRahamaariaOikein() {
        Maksukortti kortti = new Maksukortti(1000);
        paate.lataaRahaaKortille(kortti, 4000);
        assertEquals(5000, kortti.saldo());
        assertEquals(104000, paate.kassassaRahaa());
    }
    
    @Test
    public void negatiivisenRahamaaranLataaminenKortilleEiMuuttaaKortinJaKassanRahamaaria() {
        Maksukortti kortti = new Maksukortti(1000);
        paate.lataaRahaaKortille(kortti, -4000);
        assertEquals(1000, kortti.saldo());
        assertEquals(100000, paate.kassassaRahaa());
    }
}
