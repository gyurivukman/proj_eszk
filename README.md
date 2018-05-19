Online Recept és Bevásárlólista
===============================

Ez egy **Angular2** és **SpringBoot** alapú online recept-tár és bevásárlólistát ötvöző webes alkalmazás.

- Regisztrálva és anonym módon is elérhető.
- A felhasználóknak lehetőségük van recepteket és hozzávalókat felvenni, megfelelő jogosultsággal szerkeszteni, hozzávalókat állítani és kommentelni. Az ehhez szükséges adatok egy MySQL adatbázisban tárolódnak.
- A receptek között lehet különféle módon keresni (Hozzávalók, gluténmentes, stb.).
- A hozzávalók alapján ki lehet számítani, hogy adott recept mennyit tartalmaz a legfontosabb makrotápanyagokból, úgy mint szénhidrát vagy fehérje.
- "Mi van a hűtődben" feature.
- A kiválasztott recepteket a hozzávalók szűrése után hozzá lehet adni a bevásárlólistához.

A szerver és kliens közti kommunikáció JSON Web Token segítségével titkosítva van. A tesztelés Jenkins-szel történik.

Screenshots
-----------

![alt text](https://imgur.com/HhBuCyx.jpg)

Használat
---------

1. Fusson egy MySQL szerver a localhost:3306 porton és hozzunk létre egy **proj_eszk** nevű adatbázist.
2. A projekt automatikus buildelése és függőségek behúzása Gradle-lel történik. Ehhez IntelliJ Ultimate használata ajánlott. 
3. Bizonyosodjunk meg róla, hogy a **Lombok Plugin** telepítve van, és a File/Settings/Build, Execution, Deployment/Compiler/Annotation Processors menüpont alatt az *Enable Annotation Processing* checkbox be van pipálva.
4. A Backend mappájában állva parancssorból hajtsuk végre *gradle update* parancsot, amellyel végrehajtjuk az adatbázis migrálást (**liquibase**).
5. A kliens oldal elindításához **npm**-et használunk. Az Angular függőségek letöltéséhez a Frontend mappában parancssorból hajtsuk végre az *npm install* parancsot.
6. Ezután az *npm start* parancs után a localhost:4200-on elérhetjük a weboldalt. 

Adatbázis Modell
----------------

placeholder

Class Diagram
-------------

Model View Controller szerkezeti minta alapján.

Use Case Diagram
----------------

placeholder

Fejlesztési Lehetőségek
-----------------------

- Az alkalmazás felhasználhatna valamilyen már létező REST API-t (pl a Tescoét) hogy árajánlatot is tudjon adni.
- Valamilyen térkép integráció, hogy hol tudná a felhasználó beszerezni a kiválaszott alapanyagokat.
