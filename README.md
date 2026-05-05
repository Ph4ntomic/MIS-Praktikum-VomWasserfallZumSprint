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
1 Add | 2 Show | 3 Plus | 4 Minus | 0 Exit
```

## Wichtiger Bedienhinweis

```text
Erst 1 Add benutzen.
Dann 2 Show benutzen.
```

Wenn noch kein Artikel angelegt wurde, kann bei `2 Show` noch kein Artikel angezeigt werden.

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
ID: A001
Name: Schrauben
Quantity: 50
Minimum: 10
Price: 2.99

2
0 | ID: A001 | Name: Schrauben | Quantity: 50 | Price: 2.99

3
Item number: 0
Amount: 20

2
0 | ID: A001 | Name: Schrauben | Quantity: 70 | Price: 2.99

4
Item number: 0
Amount: 65

Warning: Minimum quantity reached.
```

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

In der Scrumphase kann das Programm nach Feedback erweitert werden.

Mögliche Erweiterungen:

| Erweiterung | Nutzen |
|---|---|
| Artikelsuche | Artikel können schneller gefunden werden. |
| Artikel löschen | Falsch angelegte Artikel können entfernt werden. |
| Datei-Export | Lagerdaten können gespeichert werden. |
| bessere Fehlerbehandlung | Falsche Eingaben führen nicht direkt zu Programmfehlern. |
| dauerhafte Speicherung | Artikel bleiben nach Programmende erhalten. |

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