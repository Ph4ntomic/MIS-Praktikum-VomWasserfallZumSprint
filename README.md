# LagerMini

## Beschreibung

`LagerMini` ist ein einfaches Konsolenprogramm zur Lagerverwaltung.

Das Programm kann Artikel anlegen, anzeigen, Bestände erhöhen, Bestände verringern, negative Bestände verhindern und eine Warnung ausgeben, wenn der Mindestbestand unterschritten wird.

Das Programm wurde für das Praktikum **„Vom Wasserfall zum Sprint“** erstellt.

## Technologie

Programmiersprache: Java  
Bedienung: Konsole  
Speicherung: Arrays im Arbeitsspeicher  
Hauptdatei: `LagerMini.java`

## Starten des Programms

### Kompilieren

```bash
javac LagerMini.java
```

### Ausführen

```bash
java LagerMini
```

## Bedienung

Nach dem Start erscheint dieses Menü:

```text
1 Anlegen | 2 Anzeigen | 3 Plus | 4 Minus | 0 Ende
```

## Menüfunktionen

| Eingabe | Funktion |
|---|---|
| `1` | Neuen Artikel anlegen |
| `2` | Alle Artikel anzeigen |
| `3` | Bestand eines Artikels erhöhen |
| `4` | Bestand eines Artikels verringern |
| `0` | Programm beenden |

## Beispielablauf

```text
1
Name: Schrauben
Bestand: 50
Minimum: 10

2
0 Schrauben Bestand: 50

3
Artikelnummer: 0
Menge: 20

2
0 Schrauben Bestand: 70

4
Artikelnummer: 0
Menge: 65

Warnung: Mindestbestand unterschritten.
```

## Aufbau des Codes

Das Programm nutzt drei Arrays.

```java
String[] name
```

Speichert die Artikelnamen.

```java
int[] bestand
```

Speichert die aktuelle Menge der Artikel.

```java
int[] minimum
```

Speichert den Mindestbestand der Artikel.

Die Variable `anzahl` zählt, wie viele Artikel bereits angelegt wurden.

## Bezug zum Wasserfallmodell

In der Wasserfallphase wird das Programm nach einem festen Plan umgesetzt.

Umgesetzte Funktionen:

| Funktion | Beschreibung |
|---|---|
| Artikel anlegen | Ein neuer Artikel wird mit Name, Bestand und Mindestbestand gespeichert. |
| Artikel anzeigen | Alle gespeicherten Artikel werden in der Konsole angezeigt. |
| Bestand erhöhen | Der Bestand eines Artikels wird erhöht. |
| Bestand verringern | Der Bestand eines Artikels wird verringert. |
| Negativen Bestand verhindern | Es wird geprüft, ob genug Bestand vorhanden ist. |

Während der Entwicklung werden keine neuen Anforderungen aufgenommen.

## Bezug zu Scrum

In der Scrumphase kann das Programm nach Feedback erweitert werden.

Mögliche Erweiterungen:

| Erweiterung | Nutzen |
|---|---|
| Mindestbestand prüfen | Das System warnt bei zu niedrigem Bestand. |
| Artikelsuche | Artikel können schneller gefunden werden. |
| Artikel löschen | Falsch angelegte Artikel können entfernt werden. |
| Datei-Export | Lagerdaten können gespeichert werden. |
| bessere Fehlerbehandlung | Falsche Eingaben führen nicht direkt zu Programmfehlern. |

## Grenzen des Programms

Das Programm ist absichtlich minimalistisch gehalten.

Einschränkungen:

| Grenze | Erklärung |
|---|---|
| Maximal 10 Artikel | Die Arrays haben eine feste Größe von 10. |
| Keine dauerhafte Speicherung | Nach Programmende sind die Daten weg. |
| Keine Datenbank | Die Daten liegen nur im Arbeitsspeicher. |
| Keine grafische Oberfläche | Die Bedienung erfolgt nur über die Konsole. |
| Einfache Fehlerbehandlung | Texteingaben statt Zahlen können noch Fehler auslösen. |

## Kurzfazit

`LagerMini` zeigt eine einfache Lagerverwaltung auf Konsolenbasis.

Der Code ist bewusst klein gehalten, damit der Unterschied zwischen starrer Wasserfallentwicklung und flexibler Scrum-Erweiterung gut erkennbar bleibt.