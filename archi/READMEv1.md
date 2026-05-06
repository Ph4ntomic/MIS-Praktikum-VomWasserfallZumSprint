# LagerMini

## Beschreibung

`LagerMini` ist ein einfaches Konsolenprogramm zur Lagerverwaltung.

Das Programm kann Artikel anlegen, anzeigen, Bestände erhöhen, Bestände verringern, negative Bestände verhindern, eine Warnung bei unterschrittenem Mindestbestand ausgeben und die Lagerdaten als JSON-Datei exportieren.

Das Programm wurde für das Praktikum **„Vom Wasserfall zum Sprint“** erstellt.

## Technologie

Programmiersprache: Java  
Bedienung: Konsole  
Speicherung während der Laufzeit: Arrays im Arbeitsspeicher  
Export: JSON-Datei  
Hauptdatei: `LagerMini.java`  
Hilfsdatei: `ExportJson.java`

## Starten des Programms

### Kompilieren

```bash
javac LagerMini.java ExportJson.java
```

### Ausführen

```bash
java LagerMini
```

## Bedienung

Nach dem Start erscheint dieses Menü:

```text
1 Add | 2 Show | 3 Plus | 4 Minus | 5 Export JSON | 0 Exit
```

## Wichtiger Bedienhinweis

```text
Erst 1 Add benutzen.
Dann 2 Show benutzen.
Danach können Plus, Minus oder Export JSON genutzt werden.
```

Wenn noch kein Artikel angelegt wurde, kann bei `2 Show` noch kein Artikel angezeigt werden.

## Menüfunktionen

| Eingabe | Funktion |
|---|---|
| `1` | Neuen Artikel anlegen |
| `2` | Alle Artikel anzeigen |
| `3` | Bestand eines Artikels erhöhen |
| `4` | Bestand eines Artikels verringern |
| `5` | Lagerdaten als JSON-Datei exportieren |
| `0` | Programm beenden |

## Beispielablauf

```text
1
ID: A001
Name: Screws
Quantity: 50
Minimum: 10
Price: 2.99

2
0 | ID: A001 | Name: Screws | Quantity: 50 | Minimum: 10 | Price: 2.99

3
Item number: 0
Amount: 20

2
0 | ID: A001 | Name: Screws | Quantity: 70 | Minimum: 10 | Price: 2.99

4
Item number: 0
Amount: 65

Warning: Minimum quantity reached.

5
JSON export completed: warehouse.json
```

## JSON-Export

Mit Menüpunkt `5` werden die aktuellen Lagerdaten in die Datei `warehouse.json` geschrieben.

Beispiel:

```json
[
  {
    "id": "A001",
    "name": "Screws",
    "quantity": 5,
    "minimum": 10,
    "price": 2.99
  }
]
```

Wichtig: Das Programm kann JSON exportieren, aber noch nicht automatisch beim Start wieder laden.

## Aufbau des Codes

Das Programm nutzt mehrere Arrays.

```java
String[] id
```

Speichert die Artikel-ID.

```java
String[] name
```

Speichert den Artikelnamen.

```java
int[] quantity
```

Speichert die aktuelle Menge der Artikel.

```java
int[] minimum
```

Speichert den Mindestbestand der Artikel.

```java
double[] price
```

Speichert den Preis der Artikel.

Die Variable `count` zählt, wie viele Artikel bereits angelegt wurden.

Die Klasse `ExportJson` enthält die Methode `exportJson(...)`.

Diese Methode schreibt die gespeicherten Artikeldaten in die Datei `warehouse.json`.

## Bezug zum Wasserfallmodell

In der Wasserfallphase wird das Programm nach einem festen Plan umgesetzt.

Umgesetzte Funktionen:

| Funktion | Beschreibung |
|---|---|
| Artikel anlegen | Ein neuer Artikel wird mit ID, Name, Menge, Mindestbestand und Preis gespeichert. |
| Artikel anzeigen | Alle gespeicherten Artikel werden in der Konsole angezeigt. |
| Bestand erhöhen | Der Bestand eines Artikels wird erhöht. |
| Bestand verringern | Der Bestand eines Artikels wird verringert. |
| Negativen Bestand verhindern | Es wird geprüft, ob genug Bestand vorhanden ist. |
| Mindestbestand prüfen | Bei zu niedrigem Bestand erscheint eine Warnung. |

Während der Entwicklung werden keine neuen Anforderungen aufgenommen.

## Bezug zu Scrum

In der Scrumphase wurde das Programm nach Kundenfeedback erweitert.

Aufgenommenes Feedback:

| Änderung | Umsetzung |
|---|---|
| Keine CSV-Datei verwenden | Stattdessen JSON-Export |
| Englische Labels verwenden | Menü und Ausgaben sind auf Englisch |
| Daten exportieren | Export in `warehouse.json` |

Scrum war hier sinnvoll, weil Änderungen nach dem ersten Sprint flexibel aufgenommen werden konnten.

## Grenzen des Programms

Das Programm ist absichtlich minimalistisch gehalten.

Einschränkungen:

| Grenze | Erklärung |
|---|---|
| Maximal 10 Artikel | Die Arrays haben eine feste Größe von 10. |
| Keine automatische Speicherung | Die Daten liegen während der Laufzeit im Arbeitsspeicher. |
| Nur JSON-Export | JSON kann exportiert, aber noch nicht geladen werden. |
| Keine Datenbank | Die Daten werden nicht in einer Datenbank gespeichert. |
| Keine grafische Oberfläche | Die Bedienung erfolgt nur über die Konsole. |
| Einfache Fehlerbehandlung | Texteingaben statt Zahlen können noch Fehler auslösen. |

## Kurzfazit

`LagerMini` zeigt eine einfache Lagerverwaltung auf Konsolenbasis.

Der Code ist bewusst klein gehalten, damit der Unterschied zwischen starrer Wasserfallentwicklung und flexibler Scrum-Erweiterung gut erkennbar bleibt.

Die Erweiterung um den JSON-Export zeigt, wie Kundenfeedback in Scrum nachträglich eingearbeitet werden kann.