<p align="center">
  <a href="https://trueconf.de/" target="_blank" rel="noopener noreferrer">
    <picture>
      <source media="(prefers-color-scheme: dark)" srcset="https://trueconf.com/images/headMenu/logo.svg">
      <img width="150" src="https://trueconf.com/images/headMenu/logo.svg">
    </picture>
  </a>
</p>

<h1 align="center">TrueConf SDK für Android</h1>

<p align="center">Eine Softwarebibliothek zur Integration von unternehmensgerechter Videokommunikation in Android-Apps</p>

<p align="center">
    <a href="https://t.me/trueconf_talks" target="_blank">
        <img src="https://img.shields.io/badge/telegram-group-blue?style=flat-square&logo=telegram" />
    </a>
    <a href="https://chat.whatsapp.com/GY97WBzSgvD1cJG0dWEiGP">
        <img src="https://img.shields.io/badge/whatsapp-commiunity-gree?style=flat-square&logo=whatsapp" />
    </a>
    <a href="#">
        <img src="https://img.shields.io/github/stars/trueconf/trueconf-sdk-for-android?style=social" />
    </a>
</p>

<p align="center">
  <a href="./README.md">English</a> /
  <a href="./README-ru.md">Русский</a> /
  <a href="./README-de.md">Deutsch</a> /
  <a href="./README-es.md">Español</a>
</p>

<p align="center">
  <img src="/assets/example3_2.png" alt="Android Studio with TrueConf SDK" width="800" height="auto">
</p>

## Inhaltsverzeichnis

- [Was ist das TrueConf SDK für Android?](#was-ist-das-trueconf-sdk-für-android)
  - [Anwendungsfälle](#anwendungsfälle)
  - [Technische Merkmale](#technische-merkmale)
  - [Unterstützte Frameworks](#unterstützte-frameworks)
  - [Integration in das TrueConf-Ökosystem](#integration-in-das-trueconf-ökosystem)
- [Zugang zum TrueConf SDK erhalten](#zugang-zum-trueconf-sdk-erhalten)
- [Projektstruktur](#projektstruktur)
- [Beispiel 1. Demonstration der grundlegenden Funktionen des TrueConf SDK](#beispiel-1-demonstration-der-grundlegenden-funktionen-des-trueconf-sdk)
  - [Initialisierung der Anwendung](#initialisierung-der-anwendung)
  - [Initialisierung der Benutzeroberfläche (UI)](#initialisierung-der-benutzeroberfläche-ui)
  - [Hauptlogik](#hauptlogik)
  - [Verwendete Methoden](#verwendete-methoden)
- [Beispiel 2. Arbeiten mit TrueConf-URI-Links](#beispiel-2-arbeiten-mit-trueconf-uri-links)
  - [Überblick über den Hauptcode](#überblick-über-den-hauptcode)
    - [Verarbeitung der "Parse link"-Schaltfläche](#verarbeitung-der-parse-link-schaltfläche)
    - [Verarbeitung der "Clear"-Schaltfläche](#verarbeitung-der-clear-schaltfläche)
    - [onViewCreated-Methode](#onviewcreated-methode)
  - [Beispiel 3. Arbeiten mit Gruppenkonferenzen](#beispiel-3-arbeiten-mit-gruppenkonferenzen)
  - [Beispiel 4. Arbeiten mit Benutzerstatus](#beispiel-4-arbeiten-mit-benutzerstatus)
  - [Beispiel 5. Anpassung der Oberfläche](#beispiel-5-anpassung-der-oberfläche)
    - [Wie funktioniert das?](#wie-funktioniert-das)
    - [Codebeispiel](#codebeispiel)
    - [Wo erscheinen die Schaltflächen?](#wo-erscheinen-die-schaltflächen)
    - [Anpassung der Icons während des Anrufs](#anpassung-der-icons-während-des-anrufs)
    - [Zusammenfassung](#zusammenfassung)
  - [Beispiel 6. Chat](#beispiel-6-chat)
    - [📬 Nachrichten senden: `sendChatMessage(toID, text)`](#-nachrichten-senden-sendchatmessagetoid-text)
    - [📥 Nachrichten empfangen: `onChatMessageReceived(...)`](#-nachrichten-empfangen-onchatmessagereceived)
    - [📱 Chat-Oberfläche: Funktionsweise](#-chat-oberfläche-funktionsweise)
      - [1. Verarbeitung der Senden-Schaltfläche](#1-verarbeitung-der-senden-schaltfläche)
      - [2. Initialisierung von RecyclerView](#2-initialisierung-von-recyclerview)
      - [3. Nachrichtenanzeige in der UI](#3-nachrichtenanzeige-in-der-ui)
    - [Zusammenfassung](#zusammenfassung-1)
  - [Beispiel 7. Anpassung der Videofenster in Konferenzen](#beispiel-7-anpassung-der-videofenster-in-konferenzen)
    - [Hauptfunktionen der Anpassung](#hauptfunktionen-der-anpassung)
    - [Struktur des benutzerdefinierten UI](#struktur-des-benutzerdefinierten-ui)
    - [Verwaltung von Konferenzelementen](#verwaltung-von-konferenzelementen)
    - [Arbeiten mit dem Konferenz-Layout](#arbeiten-mit-dem-konferenz-layout)
      - [Anpassung der Fensterparameter](#anpassung-der-fensterparameter)
    - [Anpassung der Positionierung von Videofenstern](#anpassung-der-positionierung-von-videofenstern)
      - [Geräteverwaltung](#geräteverwaltung)

## Was ist das TrueConf SDK für Android?

**TrueConf SDK für Android** ist eine Softwarebibliothek zur Integration von unternehmensgerechter Videokommunikation in Android-Apps. Damit können Sie **Videoanrufe**, **Gruppenvideokonferenzen** mit **Chat** hinzufügen und die Oberfläche sowie das Nutzererlebnis flexibel anpassen.

Das TrueConf SDK wird als externe Abhängigkeit in Ihr Projekt eingebunden und stellt ein umfassendes **API-Set** für die vollständige Integration in das TrueConf-Videokonferenzsystem bereit. Es beinhaltet:

- Benutzerauthentifizierung
- Anrufe und Teilnahme an Konferenzen
- Abrufen und Überwachen von Benutzerstatus
- Arbeiten mit Multimedia
- Anpassung von Oberflächen und Videofenstern

### Anwendungsfälle

Das TrueConf SDK eignet sich für die Entwicklung von:

- Unternehmensmessengern mit Videokommunikation
- Telemedizin-Lösungen
- mobilen Arbeitsplätzen
- branchenspezifischen Anwendungen für Sicherheit, Bildung, Produktion und mehr

### Technische Merkmale

- Verbindung zum Server über das **trueconf**-Protokoll
- Benutzerregistrierung und -anmeldung
- Verbindung zu **Gruppenkonferenzen**
- Anrufe zu anderen Benutzern
- Chat innerhalb der Konferenz
- Empfangen und Verfolgen von Benutzerstatus
- **Anpassung von Oberfläche und Videokomponenten**

### Unterstützte Frameworks

Das TrueConf SDK steht nicht nur für native Plattformen, sondern auch für Cross-Platform-Entwicklung zur Verfügung:

- **.NET (C#)**
- **React Native (JavaScript)**
- **Cordova (JavaScript)**
- **Qt (C++)**

### Integration in das TrueConf-Ökosystem

Das offizielle SDK gewährleistet eine zuverlässige Interaktion mobiler Anwendungen mit anderen TrueConf-Produkten, darunter:

- TrueConf Server
- weitere Client-Anwendungen auf Basis des SDK
- externe Systeme über die TrueConf Server API

> [!TIPP]
> Mit dem TrueConf Mobile SDK erstellte Apps können sich **nur mit Servern verbinden**, bei denen die [**TrueConf SDK-Erweiterung aktiviert ist**](https://trueconf.com/docs/server/en/admin/extensions/#support-for-sdk-applications).

<p align="center">
    <img src="/assets/license-de.png" style="border: 1px solid #D1CCCC;" alt="License TrueConf SDK in Control Panel TrueConf Server" width="800" height="auto">
</p>

## Zugang zum TrueConf SDK erhalten

Das **TrueConf SDK** für mobile Anwendungen wird über ein **privates Remote-Repository** bereitgestellt. Der Zugang erfolgt **auf individuelle Anfrage** – wenden Sie sich bitte über das Kontaktformular auf der Website oder über die [offiziellen Kontakte](https://trueconf.de/) an den Vertrieb.

**So erhalten Sie Zugang:**

1. **Kontaktieren Sie den Vertrieb von TrueConf.** Geben Sie an, dass Sie Zugang zum TrueConf SDK und zum privaten Maven-Repository für Android wünschen.  
   Kontakte: [https://trueconf.de/](https://trueconf.de/)
2. **Beschreiben Sie Ihr Projekt.** Die TrueConf-Mitarbeiter können Sie nach dem geplanten Einsatz des SDK fragen.
3. **Erhalten Sie Zugangsdaten.** Nach Prüfung Ihrer Anfrage erhalten Sie einen Login und ein Passwort für das Maven-Repository.
4. **Konfigurieren Sie den Zugriff auf das Maven-Repository.** Um die Android-Bibliothek herunterzuladen, müssen Sie die Autorisierung in Gradle mit Ihrem Login und Passwort einrichten. Fügen Sie in Ihrer Datei `gradle.properties` folgende Zeilen hinzu:
  
   ```properties
   trueconfUsername=your_login  
   trueconfPassword=your_password
   ```

   > [!WARNUNG]
   > Ersetzen Sie **your_login** und **your_password** durch die Ihnen bereitgestellten Zugangsdaten.

## Projektstruktur

Laden Sie dieses Repository herunter und öffnen Sie es in Android Studio. Alle unten beschriebenen Beispiele sind in diesem Projekt enthalten. Die Projektstruktur sieht ungefähr wie folgt aus:

```
gradle/                 
└── wrapper/  
├── gradle-wrapper.jar        
└── gradle-wrapper.properties

TestApp1/            // Пример №1     
├── src/                   
│   ├── main/              
│   │   ├── java/          
│   │   │   └── com/example/trueconf/sample/  
│   │   │       ├── MainActivity1.java  
│   │   │       ├── PlaceholderFragment.java  
│   │   │       └── TestApp1.java  
│   │   ├── res/           
│   │   │   ├── drawable/           
│   │   │   ├── layout/             
│   │   │   ├── values/             
│   │   └── AndroidManifest.xml    
└── build.gradle

TestApp2/  
TestApp3/  
TestApp4/  
TestApp5/  
TestApp6/  
TestApp7/

build.gradle  
settings.gradle       
gradlew           
gradlew.bat  
gradle.properties
```

## Beispiel 1. Demonstration der grundlegenden Funktionen des TrueConf SDK

Eine Anwendung, in der alle Hauptfunktionen des TrueConf SDK implementiert sind:

- Initialisierung des SDK und Verbindung zum Server
- Benutzeranmeldung und Abmeldung
- Anruf eines Serverbenutzers über die [TrueConf ID](https://trueconf.com/docs/server/en/admin/users/#user-id)
- Möglichkeit, eingehende Audio- und Videoanrufe zu empfangen

<p align="center">
  <img src="/assets/example1_1.png" style="border: 1px solid #D1CCCC;" alt="Android Studio with TrueConf SDK" width="300" height="auto">
  <img src="/assets/example1_2.png" style="border: 1px solid #D1CCCC;" alt="Android Studio with TrueConf SDK" width="300" height="auto">
</p>

### Initialisierung der Anwendung

Öffnen Sie im Projekt die Datei `TestApp1.java` im Modul `TestApp1`. Die Datei `TestApp1.java` ist die Hauptanwendungsklasse (`Application`), die für die Initialisierung des TrueConf SDK beim Start der App verantwortlich ist. Sie unterstützt `MultiDex` (`MultiDexApplication`), was es ermöglicht, die 65.536 Methoden-Grenze zu umgehen und mehrere **.dex**-Dateien zu verwenden. Weitere Informationen finden Sie in der [offiziellen Dokumentation](https://developer.android.com/build/multidex).

Um das SDK zu initialisieren, registrieren Sie die Anwendung mit der Methode [`registerApp`](https://trueconf.com/docs/mobile-sdk/en/functions-android/#registerapp). Übergeben Sie `this` (die Hauptanwendungsklasse, die von Application erbt) als Parameter. Dies ist erforderlich, um die SDK-Ressourcen während des gesamten Lebenszyklus der Anwendung zu verwalten.

Zum Starten des SDK verwenden Sie die Methode [**start**](https://trueconf.com/docs/mobile-sdk/en/functions-android/#start). Diese muss **nach** `registerApp()` aufgerufen werden, damit das SDK arbeitet. Sie können folgende Parameter an `start()` übergeben:

- `serverList` – eine kommaseparierte Liste von Serveradressen (String, optional)
- `checkPermissions` – prüft, ob die App über die notwendigen Berechtigungen verfügt, z. B. Kamera, Mikrofon, Netzwerk (Boolean)

**Beispiel für die Klasse `TestApp1`:**

```java
public class TestApp1 extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        TrueConfSDK.getInstance().registerApp(this);
        TrueConfSDK.getInstance().start(true);
    }
}
```

### Initialisierung der Benutzeroberfläche (UI)

Sehen wir uns nun den Code in `MainActivity1.java` an. Die Klasse `MainActivity1` ist eine Activity, die von `AppCompatActivity` erbt. Sie übernimmt die grundlegende Initialisierung der Benutzeroberfläche, konfiguriert das TrueConf SDK und verwaltet Fragmente.

In dieser Klasse überschreiben wir die Methode `onCreate()` von `AppCompatActivity`. Diese Methode wird beim Erstellen der Activity aufgerufen und ist für deren Initialisierung zuständig. Der Aufruf von `super.onCreate(savedInstanceState)` stellt sicher, dass die Activity korrekt initialisiert wird, einschließlich Theme-Setup, `FragmentManager`-Betrieb und Wiederherstellung des Zustands nach einer Zerstörung. Dieser Aufruf ist erforderlich, bevor eigene Logik hinzugefügt wird.

Danach sind mehrere wichtige Schritte auszuführen:

1. Sicherstellen, dass beim Beenden eines Anrufs korrekt zur gewünschten Oberfläche zurückgekehrt wird und der Nutzer nicht auf einem leeren Bildschirm verbleibt. Verwenden Sie dazu [`setFallbackActivity()`](https://trueconf.com/docs/mobile-sdk/en/functions-android/#setfallbackactivity) und übergeben Sie die gewünschte `Activity`-Klasse (hier `MainActivity1.class`).

2. Initialisieren Sie das Layout, damit die App etwas anzeigt. Statt des üblichen `findViewById`-Ansatzes verwenden wir das praktische [`View Binding`](https://developer.android.com/topic/libraries/view-binding?hl=de) Tool. Erstellen Sie ein `binding`-Objekt, das automatisch Code mit UI-Elementen aus `res/layout/activity_main.xml` verbindet:
  
   ```java
   ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
   ```

3. Zeigen Sie die Oberfläche dem Nutzer an. Verwenden Sie `setContentView(binding.getRoot())`. Falls der Bildschirm zum ersten Mal gestartet wird (`savedInstanceState == null`), laden Sie die Oberfläche über den Fragment-Manager ([`FragmentManager`](https://developer.android.com/guide/fragments/fragmentmanager?hl=de)):

   ```java
   getSupportFragmentManager()  
   .beginTransaction()  
   .add(binding.container.getId(), new PlaceholderFragment())  
   .commit();
   ```

**Beispiel für die Klasse `MainActivity1`:**

```java
public class MainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Example 1. Calling a User by TrueConf ID");
        TrueConfSDK.getInstance().setFallbackActivity(MainActivity1.class);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(binding.container.getId(), new PlaceholderFragment())
                    .commit();
        }
    }
}
```

### Hauptlogik

Die gesamte Logik für dieses Beispiel befindet sich in der Datei `PlaceholderFragment.java`. Sie definiert die Klasse `PlaceholderFragment`, ein Android-Fragment, das die Interfaces `TrueConfListener.LoginEventsCallback` und `TrueConfListener.ServerStatusEventsCallback` implementiert. Dadurch können Sie auf Änderungen des Verbindungs- und Anmeldestatus reagieren.

Hauptfunktionen der Klasse `PlaceholderFragment`:

1. **Verbindung zum Server** – Eingabe der Adresse des Videokonferenzservers (IP oder FQDN) und Verbindungsaufbau
2. **Anmeldung** – Eingabe von Login und Passwort zur Anmeldung
3. **Anruf tätigen** – Eingabe der Benutzer-ID und Starten eines Anrufs
4. **Abmelden** – Behandlung der Benutzerabmeldung
5. **Aktualisierung der Oberfläche** – Verwaltung der Sichtbarkeit von Schaltflächen und Feldern je nach Verbindungs- und Anmeldestatus

Wir gehen nicht auf alle 200 Zeilen dieser Datei ein, sondern konzentrieren uns auf die wichtigsten Punkte.

Mit `@Override` annotierte Methoden sind Callback-Funktionen, die Methoden der Basisklasse überschreiben und zusätzliche Logik hinzufügen. Wenn beispielsweise die App zerstört wird, entfernen wir auch den `TrueConfListener`:

```java
@Override
    public void onDestroy() {
        super.onDestroy();
        TrueConfSDK.getInstance().removeTrueconfListener(this);
    }
```

Die gesamte Hauptlogik der App ist in der Methode `setUpUI()` konzentriert. Sie:

- bindet UI-Elemente an Variablen:

  ```java
  mETLogin = binding.etLogin;  
  mETPass = binding.etPass;  
  ...
  ```

- weist Event-Handler für Schaltflächen zu (Anmeldung, Verbindung, Anruf, Abmeldung):

  ```java
  binding.btnConnect.setOnClickListener(btn -> afterServerEnter());  
  mBtnLogin.setOnClickListener(btn -> {...}  
  mBtnCall.setOnClickListener(btn -> {...}
  ```

- verwaltet die Sichtbarkeit von Elementen je nach Status:

  ```java
  mETServer.setVisibility(data == null || data.length == 0 ? View.GONE : View.VISIBLE)
  ```

Wenn Sie also die Logik in Beispiel 1 ändern möchten, bearbeiten Sie die Datei `PlaceholderFragment.java`.

### Verwendete Methoden

Abschließend ein Überblick über die verwendeten TrueConfSDK-Methoden:

- `TrueConfSDK.getInstance().addTrueconfListener(this)` – Listener hinzufügen
- `TrueConfSDK.getServerManager().isLoggedIn()` – Prüfen, ob der Benutzer am Server angemeldet ist
- `TrueConfSDK.getInstance().start(server, true)` – SDK mit bestimmtem Server starten
- `TrueConfSDK.getServerManager().loginAs(username, password, true, false)` – Anmeldung eines bestimmten Benutzers am Server
- `TrueConfSDK.getConferenceManager().callTo(peerId)` – Anruf eines bestimmten Benutzers
- `TrueConfSDK.getServerManager().logout()` – Benutzer abmelden (de-autorisieren)
- `TrueConfSDK.getInstance().removeTrueconfListener(this)` – Listener entfernen

## Beispiel 2. Arbeiten mit TrueConf-URI-Links

In diesem Beispiel zeigt die Anwendung, wie Sie sich mit dem TrueConf Server verbinden und einen Anruf über das **trueconf**-URI-Schema initiieren (z. B. `trueconf:ivanov`). Dies kann ein Anruf zu einem bestimmten Benutzer über dessen TrueConf ID oder der Beitritt zu einer Gruppenkonferenz über deren Kennung sein. Die Anmeldung und Verbindung erfolgen automatisch – Login- und Serverparameter werden im Link übergeben. Der Aufruf wird mit der Methode [`parseProtocolLink`](https://trueconf.com/docs/mobile-sdk/en/functions-android/#parseprotocollink) verarbeitet, die den Verbindungsstring als `String` erhält.

> [!TIPP]
> Weitere Informationen zur Syntax und den Möglichkeiten des **trueconf**-URI-Schemas finden Sie [in diesem Artikel.](https://trueconf.com/blog/knowledge-base/trueconf-protocol-designed-to-interact-with-trueconf-client-applications)

### Überblick über den Hauptcode

In `MainActivity2.java` in the `TestApp2` module, there is a class with the same name, which, like `TestApp1`, inherits from `AppCompatActivity`. Inside the `MainActivity2` class, you will find a static nested class `PlaceholderFragment`. Its purpose is to demonstrate working with the SDK by entering and parsing links using the **trueconf** URI scheme. After the application is initialized and the fragment layout is created, the class's `onViewCreated()` method is called. It implements the following actions:

#### Verarbeitung der "Parse link"-Schaltfläche

```java
binding.btnParseLink.setOnClickListener(btn -> {
    var link = mETLink.getText().toString().trim();
    if (!TextUtils.isEmpty(link)) {
        TrueConfSDK.getVisicallManager().parseProtocolLink(link);
    }
});
```

- When pressed, it reads the text from the field and trims spaces;
- If the string is not empty, it calls the `parseProtocolLink(...)` method of [`IVisicallManager`](https://trueconf.com/docs/mobile-sdk/en/functions-android/#ivisicallmanager) provided by TrueConf SDK;
- This method initializes the connection to the server, authorizes the user, and initiates the call—all [through a single link](https://trueconf.com/blog/knowledge-base/trueconf-protocol-designed-to-interact-with-trueconf-client-applications).

#### Verarbeitung der "Clear"-Schaltfläche

```java
binding.btnClear.setOnClickListener(btn -> mETLink.setText(""));
```

Simply clears the input field, resetting its content. For convenience in testing this example, you can paste a link from the code so you don't have to type it every time:

```java
mETLink.setText("trueconf:chester&h=10.110.2.240&login=joe_smith&password=12345678&encrypt=1&force=1");
```

#### onViewCreated-Methode

**Code snippet from the `onViewCreated()` method:**

```java
@Override
public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    binding = FragmentPlaceholderBinding.bind(view);
    var mETLink = binding.etLink;
    binding.btnParseLink.setOnClickListener(btn -> {
        var link = mETLink.getText().toString().trim();
        if (!TextUtils.isEmpty(link)) {
            TrueConfSDK.getVisicallManager().parseProtocolLink(link);
        }
    });
    binding.btnClear.setOnClickListener(btn -> mETLink.setText(""));
}
```

<p align="center">
  <img src="/assets/example2_1.png" style="border: 1px solid #D1CCCC;" alt="Android Studio with TrueConf SDK" width="300" height="auto">
  <img src="/assets/example2_2.png" style="border: 1px solid #D1CCCC;" alt="Android Studio with TrueConf SDK" width="300" height="auto">
</p>

### Beispiel 3. Arbeiten mit Gruppenkonferenzen

Dieses Beispiel zeigt, wie Sie sich mit der Methode `joinConf(conferenceId)` zu einer Mehrbenutzer-Videokonferenz verbinden. Im Gegensatz zum Anruf eines bestimmten Benutzers über `callTo(userId)` wird hier die Konferenzkennung `(String confId)` verwendet, um einer bereits auf dem Server bestehenden Sitzung beizutreten.

Die Oberfläche ist nahezu identisch mit Beispiel 1, allerdings wird die Methode `joinConf(...)` anstelle von `callTo(...)` verwendet.

<p align="center">
  <img src="/assets/example3_1.png" style="border: 1px solid #D1CCCC;" alt="" width="300" height="auto">
</p>

Derzeit wird nur der Beitritt zu bestehenden Konferenzen unterstützt.

Im `setUpUI()` der Klasse `PlaceholderFragment` wird beim Drücken der **Call**-Schaltfläche wie folgt eine Verbindung zur Konferenz hergestellt:

```java
mBtnCall.setOnClickListener(v1 -> {
  var conferenceId = mETConferenceId.getText().toString();
  if (!conferenceId.isEmpty()) {
      TrueConfSDK.getConferenceManager().joinConf(conferenceId);
  }
});
```

Ist die `Conference ID` korrekt angegeben, verbindet sich die App mit der entsprechenden Konferenz:  

<p align="center">
  <img src="/assets/example3_2.png" style="border: 1px solid #D1CCCC;" alt="" width="800" height="auto">
</p>

### Beispiel 4. Arbeiten mit Benutzerstatus

Dieses Beispiel zeigt, wie Sie den Status von Benutzern auf dem Server überwachen und einen Benutzer zur späteren Überwachung seiner Erreichbarkeit hinzufügen können.

Die Implementierung besteht aus zwei Bildschirmen: Der erste verbindet sich mit dem Server und meldet den Benutzer an, danach zeigt der zweite Bildschirm eine Liste von Benutzern aus dem Adressbuch.

Das Beispiel demonstriert, wie Sie mit der Methode `getUserStatus(user)` den aktuellen Status eines Benutzers abfragen und wie Sie Statusänderungen über die Callbacks `onUserStatusUpdate` und `onContactListUpdate` behandeln.

Um den Code einzusehen, gehen Sie zu `TestApp4 → java → com.trueconf.sample`. Dieser Ordner enthält etwas mehr Dateien als die vorherigen Beispiele. Ein kurzer Überblick:

- `TestApp4.java` — Application-Klasse. Initialisiert das TrueConf SDK in `onCreate()`: setzt den Server, führt die Anmeldung durch und baut die Verbindung auf.
- `MainActivity4.java` — Einstiegspunkt der UI. Lädt beim Start das `ContactListFragment`.
- `ContactListFragment.java` — UI-Fragment. Zeigt die Benutzerliste an, abonniert Statusänderungs-Events (`onUserStatusUpdate`, `onContactListUpdate`), ermöglicht das Hinzufügen von Benutzern per ID. Verwendet `ContactsAdapter`.
- `ContactsAdapter.java` — RecyclerView-Adapter. Zeigt Benutzer-ID und Status mit Emoji an. Aktualisiert Daten über `updateContact`, verwendet einen ViewHolder.

**🗂 Komponentenstruktur und Interaktion:**

```
TestApp4 (Application)  
│  
└───▶ TrueConf SDK initialization  
│  
▼  
MainActivity4 (Activity)  
│  
└───▶ Loads ContactListFragment  
│  
├── Connects to TrueConf SDK  
├── Subscribes to user status events  
├── Displays user list (RecyclerView)  
└── Uses:  
▼  
ContactsAdapter (RecyclerView.Adapter)  
├── Stores user list  
├── Displays ID and status (emoji)  
└── Updates data on SDK events
```

**📍 `ContactListFragment.java`: Abonnieren von Events und Listenverwaltung**

Die Datei `ContactListFragment.java` implementiert ein Fragment, das Benutzer mit ihrem aktuellen Verbindungsstatus anzeigt. Nachdem das Fragment erstellt und das Layout in `onViewCreated()` geladen wurde, wird die aktuelle Klasse als SDK-Event-Listener registriert:

```java
TrueConfSDK.getInstance().addTrueconfListener(this);
```

So können Sie Änderungen über folgende Callbacks behandeln:

- `onUserStatusUpdate(String id, PresenceStatus status)` — wird aufgerufen, wenn sich der Status eines bestimmten Benutzers ändert
- `onContactListUpdate()` — wird aufgerufen, wenn das Adressbuch aktualisiert wurde

Wird die Schaltfläche zum Hinzufügen eines Kontakts gedrückt, wird der Status des Benutzers per ID abgefragt:

```java
var peerId = addContactEdit.getText().toString();  
var status = TrueConfSDK.getContactsManager().getUserStatus(peerId);
```

Die Methode [`getUserStatus(String id)`](https://trueconf.com/docs/mobile-sdk/en/functions-android/#getuserstatus) gibt einen Wert vom Typ `PresenceStatus` zurück – dies kann `ONLINE`, `BUSY`, `LOGOFF` oder [andere Zustände](https://trueconf.com/docs/mobile-sdk/en/types/) sein. Nach dem Abrufen des Status wird dieser an den Adapter übergeben:

```java
adapter.updateContact(peerId, status);
```

In `onContactListUpdate()` wird das vollständige Adressbuch der Teilnehmer vom TrueConf Server abgerufen. Die Methode [`getUsers()`](https://trueconf.com/docs/mobile-sdk/en/functions-android/#getusers) liefert eine Liste aller im Adressbuch verfügbaren Benutzer:

```java
var peerList = TrueConfSDK.getContactsManager().getUsers();  
adapter.contacts.clear();  
adapter.contacts.addAll(peerList);  
adapter.notifyDataSetChanged();
```

Diese Liste wird im Adapter gespeichert und die Oberfläche wird über `notifyDataSetChanged()` aktualisiert, wenn weniger als zwei Einträge in der aktuellen Liste vorhanden sind. Dieser Ansatz wird für das initiale Laden der Daten oder das Wiederherstellen nach einem Reset verwendet.

Somit implementiert das Fragment eine vollständige Subscription auf TrueConf SDK-Events und Echtzeit-UI-Updates.

**📍 `ContactsAdapter.java`: Anzeige von IDs und Status mit Emoji**

Die Klasse `ContactsAdapter` implementiert einen `RecyclerView`-Adapter, der die Benutzer-`ID` und den aktuellen Status anzeigt. Sie arbeitet mit `ContactInfo`-Objekten, die die Benutzerkennung und den `PresenceStatus` enthalten. Die Datenformatierung für die Anzeige erfolgt in der Methode `onBindViewHolder`, in der die Funktion `getStatusEmoji(...)` aufgerufen wird:

```java
var text = peerId + " " + getStatusEmoji(status);  
holder.binding.text.setText(text);
```

Die Methode `getStatusEmoji` ordnet `PresenceStatus`-Werte klaren visuellen Indikatoren zu, zum Beispiel:

```java
case ONLINE: return "🟢 Online";  
case BUSY: return "🟠 Busy";
```

**📍 Was ist das Ergebnis?**

Dieses Beispiel zeigt eine praxisnahe Implementierung der wichtigsten Mechanismen des TrueConf SDK für Android: das Abonnieren von Benutzerstatus-Events, das Abrufen des aktuellen Status von Teilnehmern und das Laden des vollständigen Adressbuchs vom Server über die Methoden `getUserStatus()` und `getUsers()`.

Nachfolgend Screenshots der laufenden **Beispiel 4**-App:

<p align="center">
  <img src="/assets/example4_1.png" style="border: 1px solid #D1CCCC;" alt="" width="300" height="auto">
  <img src="/assets/example4_2.png" style="border: 1px solid #D1CCCC;" alt="" width="300" height="auto">
</p>

### Beispiel 5. Anpassung der Oberfläche

Im TrueConf SDK für Android können Sie die Anrufsteuerleiste erweitern, indem Sie eigene Schaltflächen über das Interface [`IExtraButtonController`](https://trueconf.com/docs/mobile-sdk/en/functions-android/#iextrabuttoncontroller) hinzufügen. So können Sie zusätzliche Aktionen direkt aus dem Konferenzfenster auslösen, z. B. das Öffnen eines Fragments oder das Starten einer anderen `Activity`.

#### Wie funktioniert das?

Eigene Schaltflächen werden mit der Methode `setNewExtraButtons()` hinzugefügt, die eine Liste von `TCExtraButton`-Objekten erwartet. Diese Schaltflächen erscheinen in der Konferenzoberfläche, wenn der Nutzer auf die Schaltfläche "Mehr" (⋯) klickt – das rechte Element der Anrufsteuerleiste während eines Gesprächs.

Das `IExtraButtonController`-Interface steht über das SDK zur Verfügung:

```java
TrueConfSDK.getExtraButtonController()
```

#### Codebeispiel

Nachfolgend ein vollständiges Beispiel zum Hinzufügen von zwei Schaltflächen:

- Die erste Schaltfläche öffnet ein `Fragment`
- Die zweite startet eine `Activity`

```java
ArrayList<TCExtraButton> buttons = new ArrayList<>();
// Handler for the first button: open a Fragment over the conference  
View.OnClickListener onClickListener = btn ->
  ((AppCompatActivity) btn.getContext())
          .getSupportFragmentManager()
          .beginTransaction()
          .add(com.trueconf.sdk.R.id.container_call, new EmptyFragment())
          .addToBackStack(null)
          .commit();  
// Handler for the second button: launch an Activity  
View.OnClickListener onClickListener2 = btn -> {
    Intent emptyActivity = new Intent (this, FirstActivity.class);
    startActivity(emptyActivity);
}; 
// Create buttons and add to the list  
buttons.add(new TCExtraButton("button 1", onClickListener));  
buttons.add(new TCExtraButton("button 2", onClickListener2));  
// Pass the button list to the SDK  
TrueConfSDK.getExtraButtonController().setNewExtraButtons(buttons);
```

#### Wo erscheinen die Schaltflächen?

Die hinzugefügten Schaltflächen ersetzen keine Standard-UI-Elemente. Sie werden nur angezeigt, wenn Sie auf die "Mehr"-Schaltfläche (⋯) in der unteren Anrufsteuerleiste klicken. Die Reihenfolge entspricht der Reihenfolge in der `buttons`-Liste.

<p align="center">
  <img src="/assets/example5_1.png" style="border: 1px solid #D1CCCC;" alt="" width="400" height="auto">
</p>

#### Anpassung der Icons während des Anrufs

Wenn Sie die Standard-Icons (z. B. Mikrofon, Kamera, Lautsprecher, Auflegen-Button usw.) ändern möchten, ersetzen Sie die Bildressourcen im Ordner `res/drawable`. Das SDK verwendet automatisch Ihre eigenen Versionen, wenn die Dateinamen mit den Standardnamen übereinstimmen.

Hier die unterstützten Icon-Namen für den Austausch:

```
ic_bluetooth_audio_arrow_off  
ic_bluetooth_audio_arrow  
ic_bluetooth_audio  
ic_call_end  
ic_camera_off  
ic_camera_on  
ic_dyn_arrow_off  
ic_dyn_arrow  
ic_empty_invoice  
ic_headphones_arrow_off  
ic_headphones_arrow  
ic_headset_mic_arrow_off  
ic_headset_mic_arrow  
ic_headset_mic  
ic_headset  
ic_mic_off  
ic_mic_on  
ic_more_horiz  
ic_phone_in_talk_arrow_off  
ic_phone_in_talk_arrow  
ic_phone_in_talk_off  
ic_phone_in_talk  
ic_sound_off  
ic_sound_on  
ic_rotate  
ic_minimize_fullscreen  
conf_button_back
```

Fügen Sie einfach Ihre eigenen Versionen dieser Icons mit den entsprechenden Namen in `res/drawable` ein – sie ersetzen dann automatisch die eingebauten Grafiken.

#### Zusammenfassung

Beispiel 5 zeigt, wie Sie mit minimalem Aufwand eigene Aktionen direkt ins Konferenzfenster integrieren und dabei das native Look & Feel beibehalten. Dank des flexiblen `IExtraButtonController`-API und der Möglichkeit, Icons zu überschreiben, können Entwickler Verhalten und Aussehen der Steuerleiste individuell an die Anforderungen ihrer App anpassen.

Die erste Schaltfläche öffnet ein `Fragment`, die zweite eine `Activity`.  

<p align="center">
  <img src="/assets/example5_2.png" style="border: 1px solid #D1CCCC;" alt="" width="300" height="auto">
  <img src="/assets/example5_3.png" style="border: 1px solid #D1CCCC;" alt="" width="300" height="auto">
</p>

### Beispiel 6. Chat

Dieses Beispiel zeigt die Implementierung eines Textchats, einschließlich Senden von Nachrichten mit `sendChatMessage()` und der Verarbeitung eingehender Events über `onChatMessageReceived()`.

In diesem Abschnitt sehen wir, wie der Chat in einer mobilen App mit dem TrueConf SDK umgesetzt wird und wie das Senden, Anzeigen und Verarbeiten von Nachrichten aus architektonischer Sicht funktioniert.

#### 📬 Nachrichten senden: `sendChatMessage(toID, text)`

Mit der Methode `sendChatMessage()` können Sie eine Textnachricht an einen bestimmten Benutzer senden:

```java
TrueConfSDK.getChatManager().sendChatMessage(receiverId, messageText);
```

Parameter:

- `toID` — TrueConf ID des Empfängers (im Format `user@server.name`). Für den Gruppenchat der aktuellen Konferenz kann ein leerer String übergeben werden.
- `text` — Nachrichteninhalt

Rückgabewert:

- `true` – wenn die Nachricht erfolgreich an den Server gesendet wurde
- `false` – bei Verbindungsverlust (in diesem Fall wird die Nachricht in die Warteschlange gestellt und bei Wiederherstellung der Verbindung gesendet)

> [!TIPP]
> Vorteil des TrueConf SDK: Ist der Benutzer offline, wird die Nachricht zugestellt, sobald er wieder online ist.

#### 📥 Nachrichten empfangen: `onChatMessageReceived(...)`

Um eingehende Nachrichten zu verarbeiten, implementieren Sie einen Callback:

```java
@Override  
public void onChatMessageReceived(String fromId, String fromName, String text, String toId) {  
  mAdapter.addNewMessage(fromId, fromName, text, toId, false);  
}
```

Parameter:

- `fromId` — ID des Absenders
- `fromName` — Name des Absenders
- `text` — Nachrichtentext
- `toId` — Empfänger-ID (Ihre ID oder Konferenz)

#### 📱 Chat-Oberfläche: Funktionsweise

##### 1. Verarbeitung der Senden-Schaltfläche

Im `ChatPageFragment` wird innerhalb der Methode `onViewCreated()` die Senden-Schaltfläche verarbeitet:

```java
view.findViewById(R.id.chat_action_button).setOnClickListener(v -> {
    var receiverId = binding.toolbar.etTo.getText().toString();
    var messageText = binding.toolbar.etChatMessage.getText().toString();
    TrueConfSDK.getChatManager().sendChatMessage(receiverId, messageText);
    mAdapter.addNewMessage(TrueConfSDK.getContactsManager().getMyId(), TrueConfSDK.getContactsManager().getMyName(),
        messageText, receiverId, true);
});
```

Was passiert:

- Empfänger-ID und Nachrichtentext werden ausgelesen
- Die Nachricht wird über das SDK gesendet
- Die Nachricht wird lokal zur Anzeige in der `RecyclerView` hinzugefügt

##### 2. Initialisierung von RecyclerView

Die Anzeige aller Nachrichten erfolgt über eine `RecyclerView` und den `ChatPageMsgsRecyclerAdapter`:

```java
mAdapter = new ChatPageMsgsRecyclerAdapter();  
messagesRecycler.setAdapter(mAdapter);
```

Each message is added using the method:

```java
public void addNewMessage(String fromId, String fromName, String text, String outId, boolean isOut) {
    messages.add(new ChatModel(fromId, fromName, text, outId, isOut));
    notifyItemInserted(messages.size() - 1);
}
```

Hier wird ein `ChatModel`-Objekt mit folgenden Parametern erstellt:

- `fromId` und `fromName` — Absenderkennung
- `text` — Nachrichtentext
- `outId` — Empfänger-ID
- `isOutgoing` — ob die Nachricht vom aktuellen Nutzer stammt

##### 3. Nachrichtenanzeige in der UI

Die Anzeige der Nachrichten erfolgt in der Methode `onBindViewHolder` des Adapters:

```java
if (outgoing) {  
tvMsgOutgoing.setText(msgText);  
tvMsgOutgoing.setVisibility(View.VISIBLE);  
tvMsgIncoming.setVisibility(View.GONE);  
tvMsgIncomingSender.setVisibility(View.GONE);  
} else {  
tvMsgIncoming.setText(msgText);  
tvMsgIncoming.setVisibility(View.VISIBLE);  
tvMsgOutgoing.setVisibility(View.GONE);  
tvMsgIncomingSender.setText(senderName);  
}
```

#### Zusammenfassung

- Ist die Nachricht ausgehend (`isOutgoing == true`), wird sie rechts angezeigt
- Eingehende Nachrichten erscheinen links, mit dem Namen des Absenders

**💡 Hinweise:**

- Verwenden Sie die vollständige TrueConf ID (`user@server`) – dies erhöht die Zustellsicherheit
- Für den Gruppenchat der aktuellen Konferenz kann `sendChatMessage("", "text")` verwendet werden
- Alle Events und Nachrichten können zu Debug- oder Analysezwecken protokolliert werden
- Die Oberfläche kann leicht erweitert werden: z. B. Emoji, Anhänge, Zustell-/Lesebestätigungen usw.

<p align="center">
  <img src="/assets/example6_1.png" style="border: 1px solid #D1CCCC;" alt="TrueConf SDK. Example 6. Chat. Image 1" width="300" height="auto">
  <img src="/assets/example6_2.png" style="border: 1px solid #D1CCCC;" alt="TrueConf SDK. Example 6. Chat. Image 2" width="300" height="auto">
</p>

### Beispiel 7. Anpassung der Videofenster in Konferenzen

In diesem Beispiel werden die erweiterten Anpassungsmöglichkeiten der Videokonferenzoberfläche mit dem TrueConf SDK für Android gezeigt. Hier demonstrieren wir, wie ein Entwickler das Verhalten der Standard-Konferenzfenster vollständig überschreiben und ein eigenes UI mit präziser Kontrolle über Videofenster und Audiogeräte implementieren kann.

<p align="center">
  <img src="/assets/example7_1.png" style="border: 1px solid #D1CCCC;" alt="TrueConf SDK. Example 7. Custom Video Layout. Image 1" width="300" height="auto">
  <img src="/assets/example7_2.png" style="border: 1px solid #D1CCCC;" alt="TrueConf SDK. Example 7. Custom Video Layout. Image 2" width="300" height="auto">
</p>

#### Hauptfunktionen der Anpassung

Dieses Beispiel implementiert folgende Funktionen:

- Ersetzen der Standardfenster für eingehende und ausgehende Anrufe durch eigene `Fragment`-Implementierungen
- Einbindung einer eigenen Konferenzoberfläche auf Basis von `ConferenceFragment`
- Steuerung von Mikrofon, Kamera und Lautsprecher über das SDK
- Flexible Anpassung von Größe und Position der Teilnehmer-Videofenster
- Manuelle Auswahl von Audiogeräten während eines Anrufs

#### Struktur des benutzerdefinierten UI

Um SDK-Fenster zu überschreiben, werden folgende Klassen ersetzt:

| Zweck des Fensters     | SDK-Basisklasse           | Benutzerdefinierte Klasse im Beispiel |
| :--------------------- | :------------------------ | :------------------------------------ |
| Eingehender Anruf      | `IncomingCallFragment`    | `IncomingCallFragmentCast`            |
| Ausgehender Anruf      | `PlaceCallFragment`       | `PlaceCallFragmentCast`               |
| Konferenzfenster       | `ConferenceFragment`      | `ConferenceFragmentCast`              |

Die Initialisierung der eigenen Fenster erfolgt mit der Methode `setCallCastFragments()` in `MainActivity7`:

```java
TrueConfSDK.getCallScreenController().setPlaceCallFragment(new PlaceCallFragmentCast(...));  
TrueConfSDK.getCallScreenController().setReceiveCallFragment(new IncomingCallFragmentCast(...));  
TrueConfSDK.getCallScreenController().setConferenceFragment(new ConferenceFragmentCast(...));
```

#### Verwaltung von Konferenzelementen

In der Datei `ConferenceFragmentCast.java` werden manuelle Steuerelemente hinzugefügt:

- `btnMic`, `btnCam`, `btnSpeaker` — Mikrofon, Kamera und Lautsprecher/Audiogerät umschalten
- `btnFlip`, `btnClose` — Kamera wechseln und Anruf beenden

Events werden über SDK-Methoden verarbeitet, z. B.:

```java
btnMic.setOnClickListener(view -> onSwitchMic());  
btnSpeaker.setOnClickListener(view -> {  
  TrueConfSDK.getAudioDeviceController().requestAudioState();  
  showDialog = true;  
});
```

Die Lautsprecherschaltfläche öffnet einen Dialog zur Auswahl des Audiogeräts über die Methode `changeAudioDeviceDialog()`. Damit kann der Nutzer das aktive Audiogerät manuell auswählen oder den Ton komplett stummschalten:

```java
TrueConfSDK.getAudioDeviceController().setDefaultAudioDevice(selectedDevice);
```

#### Arbeiten mit dem Konferenz-Layout

##### Anpassung der Fensterparameter

Mit der Methode `setCallLayoutParams()` können Sie die Größe und Position des Anruffelds festlegen:

```java
WindowManager.LayoutParams params = new WindowManager.LayoutParams();  
params.width = MATCH_PARENT;  
params.height = 400dp;  
params.gravity = Gravity.BOTTOM;  
TrueConfSDK.getCallWindowController().setCallLayoutParams(params);
```

#### Anpassung der Positionierung von Videofenstern

Dieses Beispiel unterstützt die manuelle Platzierung von Teilnehmerfenstern. Die Koordinaten werden in einer `HashMap<String, Rect> forcedCells` festgelegt:

```java
forcedCells.put("user1@trueconf.name", new Rect(0, 0, 400, 200));  
forcedCells.put("user2@trueconf.name", new Rect(30, 310, 400, 510));
```

Um diese Werte anzuwenden, kommentieren Sie den Code in der Methode `onCalculateCustomLayouts()` ein:

```java
var customGfxLayout = GfxLayout.NewInstance("just description");  
customGfxLayout.SetManualMode(true);  
customGfxLayout.SetUserCell(peerId, cell);  
...  
TrueConfSDK.getParticipantLayoutController().setCustomLayout(customGfxLayout);
```

Damit erhält der Entwickler vollständige Kontrolle über Position und Größe der Teilnehmer-Videofenster auf dem Bildschirm.

##### Geräteverwaltung

Das SDK bietet komfortable Methoden, um Mikrofon und Kamera standardmäßig zu aktivieren/deaktivieren:

```java
TrueConfSDK.getAudioDeviceController().setDefaultMicEnabled(true);  
TrueConfSDK.getVideoDeviceController().setDefaultCameraEnabled(true);
```

Der aktuelle Gerätestatus kann über Listener in der UI angezeigt werden:

```java
@Override  
public void onAudioDeviceUpdate(boolean playerMute, boolean recorderMute, AudioDeviceInfo pair) {  
  setupMic(recorderMute);  
  setupSpeaker(playerMute, pair);  
}
```

Die Statusanzeige erfolgt durch Wechseln der Button-Icons je nach Zustand:

```java
btnMic.setImageResource(muteRecorder ? R.drawable.ic_mic_off : R.drawable.ic_mic);
```
