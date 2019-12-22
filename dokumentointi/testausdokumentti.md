# Testausdokumentti

Ohjelman testaus on suoritettu sekä automatisoiduilla JUnit yksikkö- ja integraatiotesteillä että manuaalisilla järjestelmätesteillä.

## Yksikkö- ja integraatiotestaus

## Sovelluslogiikka ja DAO

Luokka AssignmentServicePlayerTest testaa integraatiotesteillä ohjelman toimintaa käyttäen hyväkseen luokkia FakeAssignmentDao ja FakePlayerDao. Luokat SqliteAssignmentDaoTest ja SqlitePlayerDaoTest taas käyttävät testeissä Sqlite-tietokantaa test.db.

Luokka PlayerTest testaa yksikkötestein luokkaa Player.

### Testikattavuus

Käyttöliittymän rakentava koodi haluttiin poistaa testikattavuusraportista, minkä jälkeen rivikattavuudeksi saatiin 86% ja haaraumakattavuudeksi 80%.

<img src="https://github.com/omacode/ot-harjoitustyo/blob/master/dokumentointi/kuvat/testi.png" width="1000">

## Järjestelmätestaus

Ohjelman järjestelmätestaus on tehty manuaalisti.

### Asennus

Ohjelma on ladattu ja sitä on testattu käyttöohjeen neuvomalla tavalla sekä OSX- että Linux-ympäristöissä. Ohjelmaa on testattu tilanteissa, joissa tietokanta on jo valmiiksi luotuna ja joissa tietokanta rakennetaan ohjelman käynnistyksen yhteydessä.

### Toiminnallisuudet

Kaikki määrittelydokumentin ja käyttöohjeen kertomat toteutetut toiminnallisuudet on tarkistettu.
