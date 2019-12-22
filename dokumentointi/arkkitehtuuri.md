# Arkkitehtuurikuvaus

## Rakenne

Ohjelmassa käytetään kolmitasoista kerrosarkkitehtuuria, ja koodin pakkausrakenne on seuraavanlainen:

<img src="https://github.com/omacode/ot-harjoitustyo/blob/master/dokumentointi/kuvat/pakkaus.png" width="161">

Pakkaus _trainingapp.ui_ sisältää fxml:llä totetutetun käyttöliittymän, _trainingapp.domain_ sovelluslogiikan ja _trainingapp.dao_ vastaa tietojen pysyväistallentamisesta.

## Käyttöliittymä

Käyttöliittymä koostuu seuraavista neljästä näkymästä:

- kirjautuminen
- uuden käyttäjän luominen
- tehtävien harjoittelu
- tehtävien hallinta

Jokaiselle näkymälle on luotu fxml-tiedosto, joka sisältää näkymän rakenteen. Kaikilla näkymillä on myös omat kontrolleriluokat, jotka vastaavat yksittäisen näkymän toiminnallisuuksien suorittamisesta.

Näkymiä esitetään käyttäjälle yksi kerrallaan kutsumalla luokan trainingapp.ui.MainApp metodeja kontrolleriluokista, kun käyttäjä painaa esitettävää näkymää vaihtavaa painiketta käyttöliittymässä.

Käyttöliittymä on pyritty eristämään mahdollisimman hyvin sovelluslogiikasta, joten täysin uusien käyttöliittymien toteuttaminen pitäisi olla helppoa myöhemmin.

## Sovelluslogiikka

Ohjelman loogisen datamallin muodostavat luokat Player ja Assignment, jotka kuvaavat kirjautunutta käyttäjää ja hänen tehtäviänsä.

Sovelluslogiikan päätoiminnallisuuksia hallinnoi luokasta AssignmentService luotava olio. Tämän luokan metodit käsittelevät tietokannassa säilytettävää dataa pakkauksen trainingapp.dao rajapinnat PlayerDao ja AssignmentDao toteuttavien luokkien kautta.

Ohjelman luokka/pakkauskaavio on seuraavanlainen:

<img src="https://github.com/omacode/ot-harjoitustyo/blob/master/dokumentointi/kuvat/luokka-pakkaus.png" width="226">

## Tietojen pysyväistallennus

Pakkauksen trainingapp.dao rajapinnat PlayerDao ja AssignmentDao toteuttavat luokat SqlitePlayerDao ja SqliteAssignmentDao vastaavat tietokannassa säilytettävän tiedon käsittelystä.

Luokat on toteutettu DAO-suunnittelumallin mukaisesti. Näin on haluttu helpottaa mahdollisten toisenlaisten tietojen pysyväistallennusratkaisujen toteuttamista tulevaisuudessa.

### Tietokanta

Sovelluksessa käytetään Sqlite-tietokantaa trainingApp.db, johon luodaan sovelluksen käynnistyksen yhteydessä taulut Player ja Assignment, mikäli niitä ei ole vielä aiemmin luotu.

Testit käyttävät omaa Sqlite-tietokantaansa test.db.

## Päätoiminnallisuudet

Esitetään ohjelman päätoiminnallisuuksista käyttäjän sisäänkirjautuminen sekvenssikaavion avulla ja muut päätoiminnallisuudet sanallisesti.

### Käyttäjän sisäänkirjautuminen

Kun käyttäjä haluaa kirjautua sisään ohjelmaan, hän kirjoittaa kirjautumisnäkymän syötekenttiin käyttäjätunnuksensa ja salasanansa sekä painaa Log In -painiketta. Tällöin ohjelma etenee seuraavasti:

<img src="https://github.com/omacode/ot-harjoitustyo/blob/master/dokumentointi/kuvat/sisaankirjautuminen.png" width="750">

Tällöin LoginSceneController kutsuu AssignmentServicen metodia login parametreinaan syötetty käyttäjätunnus ja salasana. Seuraavaksi haetaan PlayerDaon metodilla findByUsernameAndPassword samoin parametrein käyttäjä, joka lisätään kirjautuneeksi. Metodi login palauttaa true, kun kirjautuminen on onnistunut. Tämän jälkeen näkymä vaihdetaan harjoittelunäkymäksi kutsumalla kontrollerissa luokan MainApp metodia setTrainingScene.

### Muut toiminnallisuudet

Muut toiminnallisuudet kuten uuden käyttäjän luominen ja käyttäjän tehtävien noutaminen etenevät sovelluksessa samankaltaisesti. Ensin käyttäjän toimien mukaisesti kontrollerissa kutsutaan luokan AssignmentServicen metodia, joka kutsuu dao-luokan metodia. Tämä metodi käsittelee tietokannan dataa. Sen jälkeen vastaus palautuu samaa reittiä takaisin käyttöliittymään, mikä näyttäytyy käyttäjälle muutoksena käyttöliittymässä.
