# TrainingApp

Sovelluksen avulla käyttäjät voivat lisätä itselleen tehtäviä/kysymyksiä, joita he voivat myöhemmin harjoitella. Sovellusta on mahdollista käyttää useampi rekisteröitynyt käyttäjä, joilla kaikilla on omat henkilökohtaiset tehtävänsä/kysymyksensä.

## Dokumentaatio

[Käyttöohje](https://github.com/omacode/ot-harjoitustyo/blob/master/dokumentointi/kayttoohje.md)

[Vaatimusmäärittely](https://github.com/omacode/ot-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](https://github.com/omacode/ot-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)

[Testausdokumentti](https://github.com/omacode/ot-harjoitustyo/blob/master/dokumentointi/testausdokumentti.md)

[Työaikakirjanpito](https://github.com/omacode/ot-harjoitustyo/blob/master/dokumentointi/tyoaikakirjanpito.md)

## Releaset

[Viikko 5](https://github.com/omacode/ot-harjoitustyo/releases/tag/viikko5)

[Viikko 6](https://github.com/omacode/ot-harjoitustyo/releases/tag/viikko6)

[Loppupalautus](https://github.com/omacode/ot-harjoitustyo/releases/tag/loppupalautus)

## Komentorivitoiminnot

### Testaus

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto _target/site/jacoco/index.html_

### Suoritettavan jarin generointi

Komento

```
mvn package
```

generoi hakemistoon _target_ suoritettavan jar-tiedoston _TrainingApp-1.0-SNAPSHOT.jar_

### JavaDoc

JavaDoc generoidaan komennolla

```
mvn javadoc:javadoc
```

JavaDocia voi katsella avaamalla selaimella tiedosto _target/site/apidocs/index.html_

### Checkstyle

Tiedoston checkstyle.xml määrittelemät tarkistukset suoritetaan komennolla

```
mvn jxr:jxr checkstyle:checkstyle
```
Mahdollisia virheilmoituksia voi tarkastella avaamalla selaimella tiedosto target/site/checkstyle.html
