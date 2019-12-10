# Arkkitehtuurikuvaus

## Rakenne

Ohjelmassa käytetään kolmitasoista kerrosarkkitehtuuria, ja koodin pakkausrakenne on seuraavanlainen:

<img src="https://github.com/omacode/ot-harjoitustyo/blob/master/dokumentointi/kuvat/pakkaus.png" width="161">

Pakkaus _trainingapp.ui_ sisältää fxml:llä totetutetun käyttöliittymän, _trainingapp.domain_ sovelluslogiikan ja _trainingapp.dao_ vastaa tietojen pysyväistallentamisesta.

<img src="https://github.com/omacode/ot-harjoitustyo/blob/master/dokumentointi/kuvat/luokka-pakkaus.png" width="226">

## Käyttäjän sisäänkirjautuminen

<img src="https://github.com/omacode/ot-harjoitustyo/blob/master/dokumentointi/kuvat/sisaankirjautuminen.png" width="750">
