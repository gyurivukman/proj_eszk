Online Recept és Bevásárlólista
===============================

Ez egy **Angular2** és **SpringBoot** alapú online recept-tár és bevásárlólistát ötvöző webes alkalmazás.

- Regisztrálva és anonym módon is elérhető.
- A felhasználóknak lehetőségük van recepteket és hozzávalókat felvenni, megfelelő jogosultsággal szerkeszteni, hozzávalókat állítani és kommentelni. Az ehhez szükséges adatok egy MySQL adatbázisban tárolódnak.
- A receptek között lehet különféle módon keresni (Hozzávalók, gluténmentes, stb.).
- A hozzávalók alapján ki lehet számítani, hogy adott recept mennyit tartalmaz a legfontosabb makrotápanyagokból, úgy mint szénhidrát vagy fehérje.
- "Mi van a hűtődben" feature.
- A kiválasztott recepteket a hozzávalók szűrése után hozzá lehet adni a bevásárlólistához.


Szerver Oldal
-------------
Java Spring keretrendszerben Gradle projektépítő eszköz használatával. A mappaszerkezet a modell-nézet-vezérlő szabványt követi. Az adatbázis kezelő rendszert (jelen esetben MySQL) JDBC segítségével érjük el. 
### Végpontok
/api
 - /user
   * /login
   * /register
   
### Tesztelés
Unit tesztek.


Kliens Oldal
------------
Angular v2 TypeScript alapú web aplikációs keretrendszerben. 

### Tesztelés
End-to-end tesztelés Protractor-ral.


Screenshots
-----------
![alt text](https://imgur.com/HhBuCyx.jpg)


Használat
---------
1. Indítsunk egy MySQL szerver a localhost:3306 porton és hozzunk létre egy **proj_eszk** nevű adatbázist.
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
placeholder


Use Case Diagram
----------------
placeholder
![alt text](https://imgur.com/SO2ReVg.png)


Fejlesztési Lehetőségek
-----------------------
- Az alkalmazás felhasználhatna valamilyen már létező REST API-t (pl a Tescoét) hogy árajánlatot is tudjon adni.
- Valamilyen térkép integráció, hogy hol tudná a felhasználó beszerezni a kiválaszott alapanyagokat.
