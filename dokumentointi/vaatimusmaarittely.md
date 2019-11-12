# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovelluksen avulla käyttäjät voivat lisätä itselleen tehtäviä/kysymyksiä, joita he voivat myöhemmin harjoitella. Sovellusta on mahdollista käyttää useampi rekisteröitynyt käyttäjä, joilla kaikilla on omat henkilökohtaiset tehtävänsä/kysymyksensä.

## Käyttäjät

Alkuun sovelluksella on vain yksi käyttäjärooli eli normaali käyttäjä. Myöhemmin sovellukseen tullaan mahdollisesti lisäämään suuremmilla oikeuksilla varustettu pääkäyttäjä.

## Käyttöliittymäluonnos

<img src="https://github.com/omacode/ot-harjoitustyo/blob/master/dokumentointi/kuvat/kayttoliittymaluonnos.png" width="750">

## Perusversion tarjoama toiminnallisuus

### Ennen kirjautumista

- Käyttäjä voi rekisteröityä sovelluksen käyttäjäksi
  - Käyttäjätunnuksen tulee olla uniikki ja vähintään 4 merkkiä pitkä
- Käyttäjä voi kirjautua sisään
  - Käyttäjän sisään kirjautuminen onnistuu syöttämällä oma käyttäjätunnus kirjautumislomakkeelle
  - Sovellus ilmoittaa virheellisestä käyttäjätunnuksesta

### Kirjautumisen jälkeen

- Käyttäjä voi liikkua harjoittelu- ja kysymyksienhallintanäkymän välillä käyttämällä sovelluksen ylälaidassa olevia painikkeita
- Harjoittelunäkymässä käyttäjälle esitetään omia kysymyksiään yksi kerrallaan
  - Vastauksen oikeellisuudesta annetaan palautetta
  - Käyttäjällä on mahdollisuus siirtyä seuraavaan kysymykseen
- Kysymyksien hallintanäkymässa listataan kaikki kysymykset ja niiden oikeat vastaukset
  - Käyttäjällä on mahdollisuus luoda uusia kysymyksiä
- Käyttäjä voi kirjautua ulos sovelluksesta

## Jatkokehitysideoita

Ajan salliessa sovellukseen lisätään seuraavia toiminnallisuuksia

- Käyttäjä voi pyytää vinkkiä kysymykseen
- Käyttäjä saa oikean vastauksensa jälkeen lisätietoja (laajemmat perustelut) oikeasta vastauksesta
- Käyttäjä näkee kysymyskohtaisesti yritysten ja oikeinvastaamisiensa lukumäärät
- Käyttäjä voi lisätä kysymykselle aiheen ja harjoitella aiheittain
- Käyttäjällä on mahdollisuus valita, että tulevien kysymyksien järjestys arvotaan
- Kysymyksiä voi poistaa sovelluksesta
- Kysymyksiä voi piitottaa, jolloin ne eivät näy harjoittelussa
- Käyttäjiltä vaaditaan salasana kirjautuessa
- Käyttäjä voi poistaa tunnuksensa ja kaikki syöttämänsä tiedot sovelluksesta