Telepítés:

Docker https://www.docker.com/products/docker-desktop/ (and Linux subsystem for Windows)

DataGrip https://www.jetbrains.com/datagrip/download/#section=windows


A fenti eszközök telepítése után, futó docker desktop mellett a mellékelt Databases zip file kicsomagolása után, úgy hogy a mappájában vagytok, futtassátok azt konzolból, hogy:


docker-compose up -d


Ez létrehozza egy lokálik MySQL Server docker container-t.

Ehhez DataGrip-el tudunk csatlakozni, megnézni a benne lévő adatokat, és táblákat létrehozni.

DataGrip-ben válasszátok ki a MySQL szerver típust, írjátok be a lenti felhasználónevet/jelszót, és töltsétek le a connector-okat amiket felajánl a DataGrip.


User: root

Password: progtech


Ezután a DataGrip konzolban futtasd le a highscores-db.sql file-ban található SQL parancsokat, hogy létrehozd az adatbázist és egy táblát benne - ezekre szükség van a Databases Java projectben. Miután ez megtörtént, látnod kell mindkettőt a DataGripben.

Ezután nyisd meg a Databases Java projectet IntelliJ-ben. A run configuration-ben állítsd be a 9.1-es msql connector classpath-ját (ez a lib könyvtárban található). A linkelt projectben már ott van a classpath, de az útvonalat a saját gépedre kell szabni!

Végezetül, futtasd a projectet. Ez létrehoz újabb és újabb score-okat, amiket eltárol / esetleg régieket töröl a táblából.

Ehhez a példa implementációhoz hasonló megoldást a saját projectedben is tudsz használni!