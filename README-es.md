<p align="center">
  <a href="https://trueconf.com" target="_blank" rel="noopener noreferrer">
    <picture>
      <source media="(prefers-color-scheme: dark)" srcset="https://raw.githubusercontent.com/TrueConf/.github/refs/heads/main/logos/logo-dark.svg">
      <img width="150" alt="trueconf" src="https://raw.githubusercontent.com/TrueConf/.github/refs/heads/main/logos/logo.svg">
    </picture>
  </a>
</p>

<h1 align="center">TrueConf SDK para Android</h1>

<p align="center">Una biblioteca de software para integrar comunicación por video de nivel empresarial en aplicaciones móviles Android</p>

<p align="center">
   <a href="https://t.me/trueconf_chat" target="_blank">
        <img src="https://img.shields.io/badge/Telegram-2CA5E0?logo=telegram&logoColor=white" />
    </a>
    <a href="https://discord.gg/2gJ4VUqATZ">
        <img src="https://img.shields.io/badge/Discord-%235865F2.svg?&logo=discord&logoColor=white" />
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

## Tabla de Contenidos

- [¿Qué es TrueConf SDK para Android?](#qué-es-trueconf-sdk-para-android)
  - [Casos de Uso](#casos-de-uso)
  - [Características Técnicas](#características-técnicas)
  - [Frameworks Soportados](#frameworks-soportados)
  - [Integración con el Ecosistema TrueConf](#integración-con-el-ecosistema-trueconf)
- [Cómo Obtener Acceso a TrueConf SDK](#cómo-obtener-acceso-a-trueconf-sdk)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Ejemplo 1. Demostración de Funcionalidades Básicas de TrueConf SDK](#ejemplo-1-demostración-de-funcionalidades-básicas-de-trueconf-sdk)
  - [Inicialización de la Aplicación](#inicialización-de-la-aplicación)
  - [Inicialización de la Interfaz de Usuario (UI)](#inicialización-de-la-interfaz-de-usuario-ui)
  - [Lógica Principal](#lógica-principal)
  - [Métodos Utilizados](#métodos-utilizados)
- [Ejemplo 2. Trabajo con Enlaces URI de TrueConf](#ejemplo-2-trabajo-con-enlaces-uri-de-trueconf)
  - [Descripción General del Código Principal](#descripción-general-del-código-principal)
    - [Manejo del Botón Parse link](#manejo-del-botón-parse-link)
    - [Manejo del Botón Clear](#manejo-del-botón-clear)
    - [Método onViewCreated](#método-onviewcreated)
  - [Ejemplo 3. Trabajo con Conferencias Grupales](#ejemplo-3-trabajo-con-conferencias-grupales)
  - [Ejemplo 4. Trabajo con Estados de Usuarios](#ejemplo-4-trabajo-con-estados-de-usuarios)
  - [Ejemplo 5. Personalización de la Interfaz](#ejemplo-5-personalización-de-la-interfaz)
    - [¿Cómo funciona?](#cómo-funciona)
    - [Ejemplo de Código](#ejemplo-de-código)
    - [¿Dónde aparecerán los botones?](#dónde-aparecerán-los-botones)
    - [Personalización de íconos en llamada](#personalización-de-íconos-en-llamada)
    - [Resumen](#resumen)
  - [Ejemplo 6. Chat](#ejemplo-6-chat)
    - [📬 Envío de mensajes: `sendChatMessage(toID, text)`](#-envío-de-mensajes-sendchatmessagetoid-text)
    - [📥 Recepción de mensajes: `onChatMessageReceived(...)`](#-recepción-de-mensajes-onchatmessagereceived)
    - [📱 Interfaz de chat: cómo funciona](#-interfaz-de-chat-cómo-funciona)
      - [1. Manejo del botón de envío](#1-manejo-del-botón-de-envío)
      - [2. Inicialización de RecyclerView](#2-inicialización-de-recyclerview)
      - [3. Renderizado de mensajes en la UI](#3-renderizado-de-mensajes-en-la-ui)
    - [Resumen](#resumen-1)
  - [Ejemplo 7. Personalización de Ventanas de Video en Conferencia](#ejemplo-7-personalización-de-ventanas-de-video-en-conferencia)
    - [Características Principales de Personalización](#características-principales-de-personalización)
    - [Estructura de UI Personalizada](#estructura-de-ui-personalizada)
    - [Gestión de Elementos de Conferencia](#gestión-de-elementos-de-conferencia)
    - [Trabajo con el Layout de la Conferencia](#trabajo-con-el-layout-de-la-conferencia)
      - [Ajuste de Parámetros de la Ventana de Llamada](#ajuste-de-parámetros-de-la-ventana-de-llamada)
    - [Personalización de la Ubicación de Ventanas de Video](#personalización-de-la-ubicación-de-ventanas-de-video)
      - [Gestión de Dispositivos](#gestión-de-dispositivos)

## ¿Qué es TrueConf SDK para Android?

**TrueConf SDK para Android** es una biblioteca de software para integrar comunicación por video de nivel empresarial en aplicaciones móviles Android. Con ella puedes añadir soporte para **videollamadas**, **videoconferencias grupales** con **chat** y gestionar de forma flexible la interfaz y la experiencia de usuario en tu app.

TrueConf SDK se conecta a tu proyecto como una dependencia externa y proporciona un completo **conjunto de APIs** para la integración total con el sistema de videoconferencia TrueConf. Incluye:

- autenticación de usuarios;
- realización de llamadas y participación en conferencias;
- obtención y seguimiento de estados de usuarios;
- trabajo con multimedia;
- personalización de interfaces y ventanas de video.

### Casos de Uso

TrueConf SDK es adecuado para crear:

- mensajeros corporativos con videocomunicación,
- soluciones de telemedicina,
- estaciones de trabajo móviles,
- aplicaciones sectoriales para seguridad, educación, industria y más.

### Características Técnicas

- Conexión al servidor mediante el protocolo **trueconf**.
- Autorización y registro de cuentas de usuario.
- Conexión a **conferencias grupales**.
- Llamadas a otros usuarios.
- Chat en conferencia.
- Recepción y seguimiento de estados de usuarios.
- **Personalización de la interfaz y componentes de video**.

### Frameworks Soportados

TrueConf SDK está disponible no solo para plataformas nativas, sino también para desarrollo multiplataforma:

- **.NET (C#)**
- **React Native (JavaScript)**
- **Cordova (JavaScript)**
- **Qt (C++)**

### Integración con el Ecosistema TrueConf

El SDK oficial garantiza la interacción fiable de las aplicaciones móviles con otros productos TrueConf, incluyendo:

- TrueConf Server;
- otras aplicaciones cliente basadas en el SDK;
- sistemas externos a través del TrueConf Server API.

> [!TIP]
> Las aplicaciones móviles creadas con TrueConf Mobile SDK pueden conectarse **solo a servidores** donde la [**extensión TrueConf SDK esté activada**](https://trueconf.com/docs/server/es/admin/extensions/#support-for-sdk-applications).

<p align="center">
    <img src="/assets/license-es.png" style="border: 1px solid #D1CCCC;" alt="License TrueConf SDK in Control Panel TrueConf Server" width="800" height="auto">
</p>

## Cómo Obtener Acceso a TrueConf SDK

**TrueConf SDK** para aplicaciones móviles se distribuye a través de un **repositorio remoto privado**. El acceso se proporciona **bajo solicitud individual**—por favor, contacta al departamento de ventas usando el formulario de contacto en el sitio web o mediante los [contactos oficiales](https://trueconf.com/es-es/empresa/contactos.html).

**Cómo obtener acceso:**

1. **Contacta al departamento de ventas de TrueConf.** Especifica que deseas acceso a TrueConf SDK y al repositorio privado Maven para Android.  
   Contacto: [https://trueconf.com/es-es/empresa/contactos.html](https://trueconf.com/es-es/empresa/contactos.html)
2. **Describe tu proyecto.** Los representantes de TrueConf pueden pedirte información sobre el uso previsto del SDK.
3. **Recibe las credenciales de acceso.** Tras revisar tu solicitud, recibirás un usuario y contraseña para conectarte al repositorio Maven.
4. **Configura el acceso al repositorio Maven.** Para descargar la librería de Android, debes configurar la autorización en Gradle usando tu usuario y contraseña. En tu archivo `gradle.properties`, añade las siguientes líneas:
  
   ```properties
   trueconfUsername=your_login  
   trueconfPassword=your_password
   ```

> [!WARNING]
> Sustituye **your_login** y **your_password** por las credenciales que te hayan proporcionado.

## Estructura del Proyecto

Descarga este repositorio y ábrelo en Android Studio. Todos los ejemplos explicados a continuación están incluidos en este proyecto. El proyecto tiene aproximadamente la siguiente estructura:

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

## Ejemplo 1. Demostración de Funcionalidades Básicas de TrueConf SDK

Una aplicación donde se implementan todas las funciones principales de TrueConf SDK:

- Inicialización del SDK y conexión al servidor;
- autorización y cierre de sesión de usuario;
- llamada a un usuario del servidor por su [TrueConf ID](https://trueconf.com/docs/server/es/admin/users/#user-id);
- posibilidad de recibir llamadas entrantes de audio y video.

<p align="center">
  <img src="/assets/example1_1.png" style="border: 1px solid #D1CCCC;" alt="Android Studio with TrueConf SDK" width="300" height="auto">
  <img src="/assets/example1_2.png" style="border: 1px solid #D1CCCC;" alt="Android Studio with TrueConf SDK" width="300" height="auto">
</p>

### Inicialización de la Aplicación

En el proyecto, abre el archivo `TestApp1.java` en el módulo `TestApp1`. El archivo `TestApp1.java` es la clase principal de la aplicación (`Application`) responsable de inicializar TrueConf SDK al arrancar la app. Soporta `MultiDex` (`MultiDexApplication`), lo que permite superar el límite de 65,536 métodos y usar múltiples archivos **.dex**. Más información en la [documentación oficial](https://developer.android.com/build/multidex).

Para inicializar el SDK, debes registrar la aplicación usando el método [`registerApp`](https://trueconf.com/docs/mobile-sdk/en/functions-android/#registerapp). Pasa `this` (la clase principal de la aplicación, que hereda de Application) como parámetro. Esto es necesario para gestionar los recursos del SDK durante todo el ciclo de vida de la aplicación.

Para iniciar el SDK, utiliza el método [**start**](https://trueconf.com/docs/mobile-sdk/en/functions-android/#start). Debes llamarlo **después** de `registerApp()` para que el SDK comience a funcionar. Puedes pasar los siguientes parámetros a `start()`:

- `serverList` – lista de direcciones de servidores separadas por comas (String, parámetro opcional);
- `checkPermissions` – comprueba si la app tiene los permisos necesarios, como acceso a la cámara, micrófono, red (Boolean).

**Ejemplo de clase `TestApp1`:**

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

### Inicialización de la Interfaz de Usuario (UI)

Ahora veamos el código en `MainActivity1.java`. La clase `MainActivity1` es una actividad que hereda de `AppCompatActivity`. Realiza la inicialización básica de la UI, configura el TrueConf SDK y gestiona los fragments.

En esta clase, sobreescribimos el método `onCreate()` de `AppCompatActivity`. Este método se llama al crear la actividad y es responsable de su inicialización. La llamada a `super.onCreate(savedInstanceState)` asegura la correcta inicialización de la actividad, incluyendo la configuración del tema, el funcionamiento de `FragmentManager` y la restauración del estado tras la destrucción. Esta llamada es obligatoria antes de añadir tu lógica personalizada.

A continuación, deben realizarse varios pasos importantes:

1. Asegura el manejo correcto de la salida de la llamada y evita la situación en la que el usuario se quede en una pantalla en blanco tras finalizar una llamada. Para ello, utiliza [`setFallbackActivity()`](https://trueconf.com/docs/mobile-sdk/en/functions-android/#setfallbackactivity) y pasa la clase `Activity` deseada (en este caso, `MainActivity1.class`).

2. Inicializa el layout para que se muestre algo en la app. En vez de usar el clásico `findViewById`, utilizaremos la herramienta [`View Binding`](https://developer.android.com/topic/libraries/view-binding?hl=es) para mayor comodidad. Crea un objeto `binding` que vincula automáticamente el código con los elementos de la UI en `res/layout/activity_main.xml`:
  
   ```java
   ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
   ```

3. Muestra la pantalla al usuario. Usa `setContentView(binding.getRoot())`. Si es la primera vez que se lanza la pantalla (`savedInstanceState == null`), carga nuestra interfaz usando el fragment manager ([`FragmentManager`](https://developer.android.com/guide/fragments/fragmentmanager?hl=es)):

   ```java
   getSupportFragmentManager()  
   .beginTransaction()  
   .add(binding.container.getId(), new PlaceholderFragment())  
   .commit();
   ```

**Ejemplo de clase `MainActivity1`:**

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

### Lógica Principal

Toda la lógica de este ejemplo se encuentra en el archivo `PlaceholderFragment.java`. Allí se define la clase `PlaceholderFragment`, que es un fragment de Android e implementa las interfaces `TrueConfListener.LoginEventsCallback` y `TrueConfListener.ServerStatusEventsCallback`, permitiendo manejar los cambios de estado de conexión y autorización.

Funciones principales de la clase `PlaceholderFragment`:

1. **Conexión al servidor** – introducción de la dirección del servidor de video (IP o FQDN) e inicio de la conexión.
2. **Autorización** – introducción de usuario y contraseña para iniciar sesión.
3. **Realización de llamada** – introducción del ID de usuario e inicio de la llamada.
4. **Cerrar sesión** – manejo del cierre de sesión del usuario.
5. **Actualización de la interfaz** – gestión de la visibilidad de botones y campos según el estado de conexión y autorización.

No revisaremos las ~200 líneas de este archivo, sino solo los puntos clave.

Los métodos anotados con `@Override` son funciones callback que sobrescriben métodos de la clase padre, añadiendo lógica adicional. Por ejemplo, cuando la app se destruye, también eliminamos el `TrueConfListener`:

```java
@Override
    public void onDestroy() {
        super.onDestroy();
        TrueConfSDK.getInstance().removeTrueconfListener(this);
    }
```

Toda la lógica principal de la app se encuentra en el método `setUpUI()`. Este método:

- vincula elementos de la UI a variables:

  ```java
  mETLogin = binding.etLogin;  
  mETPass = binding.etPass;  
  ...
  ```

- asigna manejadores de eventos a los botones (autorización, conexión, llamada, cierre de sesión):

  ```java
  binding.btnConnect.setOnClickListener(btn -> afterServerEnter());  
  mBtnLogin.setOnClickListener(btn -> {...}  
  mBtnCall.setOnClickListener(btn -> {...}
  ```

- gestiona la visibilidad de los elementos según el estado:

  ```java
  mETServer.setVisibility(data == null || data.length == 0 ? View.GONE : View.VISIBLE)
  ```

Así que, si necesitas modificar alguna lógica del Ejemplo 1, debes editar el archivo `PlaceholderFragment.java`.

### Métodos Utilizados

Por último, veamos los métodos de TrueConfSDK empleados:

- `TrueConfSDK.getInstance().addTrueconfListener(this)` – añade un listener;
- `TrueConfSDK.getServerManager().isLoggedIn()` – comprueba si el usuario está autorizado en el servidor;
- `TrueConfSDK.getInstance().start(server, true)` – inicia el SDK con un servidor específico;
- `TrueConfSDK.getServerManager().loginAs(username, password, true, false)` – autoriza a un usuario concreto en el servidor;
- `TrueConfSDK.getConferenceManager().callTo(peerId)` – llama a un usuario concreto;
- `TrueConfSDK.getServerManager().logout()` – cierra la sesión (desautoriza) del usuario;
- `TrueConfSDK.getInstance().removeTrueconfListener(this)` – elimina el listener.

## Ejemplo 2. Trabajo con Enlaces URI de TrueConf

Veamos un ejemplo donde la aplicación permite conectarse a TrueConf Server e iniciar una llamada usando el esquema URI **trueconf** (por ejemplo, `trueconf:ivanov`). Esto puede ser una llamada a un usuario específico por su TrueConf ID o la conexión a una conferencia grupal por su identificador. La autorización y la conexión se realizan automáticamente—los parámetros de login y servidor se pasan dentro del enlace. La llamada se maneja usando el método [`parseProtocolLink`](https://trueconf.com/docs/mobile-sdk/en/functions-android/#parseprotocollink), que recibe la cadena de llamada como un `String`.

> [!TIP]
> Para más detalles sobre la sintaxis y posibilidades del esquema URI **trueconf**, [lee este artículo.](https://trueconf.com/blog/knowledge-base/trueconf-protocol-designed-to-interact-with-trueconf-client-applications)

### Descripción General del Código Principal

En `MainActivity2.java` del módulo `TestApp2`, hay una clase con el mismo nombre, que al igual que `TestApp1` hereda de `AppCompatActivity`. Dentro de la clase `MainActivity2`, encontrarás una clase anidada estática `PlaceholderFragment`. Su objetivo es demostrar el trabajo con el SDK introduciendo y analizando enlaces usando el esquema URI **trueconf**. Tras inicializar la aplicación y crear el layout del fragment, se llama al método `onViewCreated()` de la clase. Este implementa las siguientes acciones:

#### Manejo del Botón Parse link

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

#### Manejo del Botón Clear

```java
binding.btnClear.setOnClickListener(btn -> mETLink.setText(""));
```

Simplemente limpia el campo de entrada, reseteando su contenido. Para facilitar las pruebas de este ejemplo, puedes pegar un enlace desde el código para no tener que escribirlo cada vez:

```java
mETLink.setText("trueconf:chester&h=10.110.2.240&login=joe_smith&password=12345678&encrypt=1&force=1");
```

#### Método onViewCreated

**Fragmento de código del método `onViewCreated()`:**

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

### Ejemplo 3. Trabajo con Conferencias Grupales

Este ejemplo muestra cómo conectarse a una videoconferencia multiusuario usando el método `joinConf(conferenceId)`. A diferencia de llamar a un usuario concreto mediante `callTo(userId)`, aquí se utiliza el identificador de la conferencia `(String confId)` para unirse a una sesión ya creada en el servidor.

La interfaz es casi idéntica a la del Ejemplo 1, salvo que se usa el método `joinConf(...)` en lugar de `callTo(...)`.

<p align="center">
  <img src="/assets/example3_1.png" style="border: 1px solid #D1CCCC;" alt="" width="300" height="auto">
</p>

Actualmente solo se soporta la conexión a conferencias existentes.

En el método `setUpUI()` de la clase `PlaceholderFragment`, aquí tienes un ejemplo de conexión a una conferencia al pulsar el botón **Call**:

```java
mBtnCall.setOnClickListener(v1 -> {
  var conferenceId = mETConferenceId.getText().toString();
  if (!conferenceId.isEmpty()) {
      TrueConfSDK.getConferenceManager().joinConf(conferenceId);
  }
});
```

Si el `Conference ID` se especifica correctamente, la app se conectará a la conferencia correspondiente:  

<p align="center">
  <img src="/assets/example3_2.png" style="border: 1px solid #D1CCCC;" alt="" width="800" height="auto">
</p>

### Ejemplo 4. Trabajo con Estados de Usuarios

Este ejemplo demuestra cómo rastrear los estados de los usuarios en el servidor, así como añadir un usuario para monitorizar su disponibilidad posteriormente.

La implementación consta de dos pantallas: la primera conecta al servidor y autoriza al usuario, tras lo cual la segunda pantalla muestra una lista de usuarios de la libreta de direcciones.

El ejemplo muestra cómo obtener el estado actual de un usuario usando el método `getUserStatus(user)`, así como manejar los cambios de estado mediante los callbacks `onUserStatusUpdate` y `onContactListUpdate`.

Para ver el código, ve a `TestApp4 → java → com.trueconf.sample`. Esta carpeta contiene algunos archivos más que los ejemplos anteriores, así que los repasamos brevemente:

- `TestApp4.java` — Clase Application. Inicializa TrueConf SDK en `onCreate()`: establece el servidor, realiza la autorización y establece la conexión.
- `MainActivity4.java` — Punto de entrada UI. Carga `ContactListFragment` al iniciar la actividad.
- `ContactListFragment.java` — Fragment UI. Muestra la lista de usuarios, se suscribe a eventos de cambio de estado (`onUserStatusUpdate`, `onContactListUpdate`), permite añadir usuarios por ID. Usa `ContactsAdapter`.
- `ContactsAdapter.java` — Adaptador RecyclerView. Muestra el ID de usuario y el estado con emoji. Actualiza datos mediante `updateContact`, usa un ViewHolder.

**🗂 Estructura de componentes e interacción:**

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

**📍 `ContactListFragment.java`: suscripción a eventos y gestión de la lista**

El archivo `ContactListFragment.java` implementa un fragment que muestra los usuarios con su estado de conexión actual. Tras crear el fragment y cargar su layout en `onViewCreated()`, la clase actual se registra como listener de eventos del SDK:

```java
TrueConfSDK.getInstance().addTrueconfListener(this);
```

Esto permite manejar los cambios mediante callbacks:

- `onUserStatusUpdate(String id, PresenceStatus status)` — se llama cuando cambia el estado de un usuario concreto;
- `onContactListUpdate()` — se llama cuando se actualiza la libreta de direcciones.

Cuando se pulsa el botón de añadir contacto, se obtiene el estado del usuario por ID:

```java
var peerId = addContactEdit.getText().toString();  
var status = TrueConfSDK.getContactsManager().getUserStatus(peerId);
```

El método [`getUserStatus(String id)`](https://trueconf.com/docs/mobile-sdk/en/functions-android/#getuserstatus) devuelve un valor `PresenceStatus`—puede ser `ONLINE`, `BUSY`, `LOGOFF` y [otros estados](https://trueconf.com/docs/mobile-sdk/en/types/). Tras obtener el estado, se pasa al adaptador:

```java
adapter.updateContact(peerId, status);
```

En `onContactListUpdate()`, se obtiene la libreta de direcciones completa de suscriptores desde el servidor TrueConf. El método [`getUsers()`](https://trueconf.com/docs/mobile-sdk/en/functions-android/#getusers) devuelve una lista de todos los usuarios disponibles en la libreta:

```java
var peerList = TrueConfSDK.getContactsManager().getUsers();  
adapter.contacts.clear();  
adapter.contacts.addAll(peerList);  
adapter.notifyDataSetChanged();
```

Esta lista se almacena en el adaptador, y la interfaz se actualiza mediante `notifyDataSetChanged()` si hay menos de dos elementos en la lista actual. Este enfoque se usa para la carga inicial de datos o para restaurar la lista tras un reinicio de estado.

Así, el fragment implementa la suscripción completa a eventos del TrueConf SDK y actualizaciones de UI en tiempo real.

**📍 `ContactsAdapter.java`: mostrar IDs y estados con emoji**

La clase `ContactsAdapter` implementa un adaptador `RecyclerView` que muestra el `ID` y el estado actual del usuario. Trabaja con objetos `ContactInfo` que contienen el identificador del usuario y el valor `PresenceStatus`. El formateo de los datos para mostrar se implementa en el método `onBindViewHolder`, donde se llama a la función `getStatusEmoji(...)`:

```java
var text = peerId + " " + getStatusEmoji(status);  
holder.binding.text.setText(text);
```

El método `getStatusEmoji` mapea los valores de `PresenceStatus` a indicadores visuales claros, por ejemplo:

```java
case ONLINE: return "🟢 Online";  
case BUSY: return "🟠 Busy";
```

**📍 ¿Qué obtenemos como resultado?**

Este ejemplo muestra una implementación práctica de los principales mecanismos de TrueConf SDK para Android: suscripción a eventos de actualización de estado de usuarios, obtención del estado actual de los suscriptores y carga de toda la libreta de direcciones desde el servidor usando los métodos `getUserStatus()` y `getUsers()`.

A continuación, capturas de pantalla de la aplicación **Ejemplo 4** en funcionamiento:

<p align="center">
  <img src="/assets/example4_1.png" style="border: 1px solid #D1CCCC;" alt="" width="300" height="auto">
  <img src="/assets/example4_2.png" style="border: 1px solid #D1CCCC;" alt="" width="300" height="auto">
</p>

### Ejemplo 5. Personalización de la Interfaz

En TrueConf SDK para Android puedes ampliar el panel de control de llamada añadiendo tus propios botones mediante la interfaz [`IExtraButtonController`](https://trueconf.com/docs/mobile-sdk/en/functions-android/#iextrabuttoncontroller). Esto permite lanzar acciones adicionales directamente desde la ventana de conferencia, como abrir un fragment o navegar a otra `Activity`.

#### ¿Cómo funciona?

Los botones personalizados se añaden usando el método `setNewExtraButtons()`, que recibe una lista de objetos `TCExtraButton`. Estos botones aparecen en la interfaz de conferencia cuando el usuario pulsa el botón "más" (⋯), que es el elemento más a la derecha del panel de control de llamada durante una llamada.

El `IExtraButtonController` está disponible vía SDK:

```java
TrueConfSDK.getExtraButtonController()
```

#### Ejemplo de Código

A continuación, un ejemplo completo de cómo añadir dos botones:

- El primer botón abre un `Fragment`,
- El segundo botón lanza una `Activity`.

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

#### ¿Dónde aparecerán los botones?

Los botones añadidos no reemplazan los elementos estándar de la interfaz. Solo se muestran al pulsar el botón "más" (⋯) en el panel inferior de control de llamada. Aparecen en el orden en que fueron añadidos a la lista `buttons`.

<p align="center">
  <img src="/assets/example5_1.png" style="border: 1px solid #D1CCCC;" alt="" width="400" height="auto">
</p>

#### Personalización de íconos en llamada

Si necesitas cambiar los íconos por defecto (por ejemplo, micrófono, cámara, altavoz, botón de colgar, etc.), puedes reemplazar los recursos de imagen en la carpeta `res/drawable`. El SDK usará automáticamente tus versiones personalizadas si los nombres de los archivos coinciden con los estándar.

Aquí tienes la lista de nombres de íconos soportados para reemplazo:

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

Solo tienes que añadir tus versiones de estos íconos con los nombres correspondientes a `res/drawable`, y reemplazarán automáticamente los integrados.

#### Resumen

El Ejemplo 5 muestra cómo puedes integrar acciones personalizadas directamente en la ventana de conferencia con un esfuerzo mínimo, manteniendo la apariencia nativa de la interfaz. Gracias a la flexible API `IExtraButtonController` y la posibilidad de sobrescribir íconos, los desarrolladores pueden adaptar el comportamiento y la apariencia del panel a las necesidades de su aplicación.

El primer botón abre un `Fragment` y el segundo una `Activity`.  

<p align="center">
  <img src="/assets/example5_2.png" style="border: 1px solid #D1CCCC;" alt="" width="300" height="auto">
  <img src="/assets/example5_3.png" style="border: 1px solid #D1CCCC;" alt="" width="300" height="auto">
</p>

### Ejemplo 6. Chat

Este ejemplo muestra la implementación de un chat de texto, incluyendo el envío de mensajes con `sendChatMessage()` y el manejo de eventos entrantes mediante `onChatMessageReceived()`.

En esta sección, veremos cómo se implementa el chat en una app móvil usando TrueConf SDK, y cómo funciona el envío, visualización y procesamiento de mensajes desde la arquitectura de la aplicación.

#### 📬 Envío de mensajes: `sendChatMessage(toID, text)`

El método `sendChatMessage()` te permite enviar un mensaje de texto a un usuario determinado:

```java
TrueConfSDK.getChatManager().sendChatMessage(receiverId, messageText);
```

Parámetros:

- `toID` — TrueConf ID del destinatario (en formato `user@server.name`). Para enviar al chat grupal de la conferencia actual, puedes pasar una cadena vacía.
- `text` — contenido del mensaje.

Valor de retorno:

- `true` – si el mensaje fue enviado correctamente al servidor;
- `false` — si falló por pérdida de conexión (en este caso, el mensaje se pone en cola y se enviará cuando se recupere la conexión).

> [!TIP]
> Ventaja de TrueConf SDK: si el usuario está desconectado, el mensaje se entregará en cuanto se conecte.

#### 📥 Recepción de mensajes: `onChatMessageReceived(...)`

Para manejar los mensajes entrantes, implementa un callback:

```java
@Override  
public void onChatMessageReceived(String fromId, String fromName, String text, String toId) {  
  mAdapter.addNewMessage(fromId, fromName, text, toId, false);  
}
```

Parámetros:

- `fromId` — ID del remitente;
- `fromName` — nombre del remitente;
- `text` — texto del mensaje;
- `toId` — ID del destinatario (tu ID o conferencia).

#### 📱 Interfaz de chat: cómo funciona

##### 1. Manejo del botón de envío

En `ChatPageFragment`, dentro del método `onViewCreated()`, se gestiona el botón de envío:

```java
view.findViewById(R.id.chat_action_button).setOnClickListener(v -> {
    var receiverId = binding.toolbar.etTo.getText().toString();
    var messageText = binding.toolbar.etChatMessage.getText().toString();
    TrueConfSDK.getChatManager().sendChatMessage(receiverId, messageText);
    mAdapter.addNewMessage(TrueConfSDK.getContactsManager().getMyId(), TrueConfSDK.getContactsManager().getMyName(),
        messageText, receiverId, true);
});
```

¿Qué ocurre?

- Se obtiene el ID del destinatario y el texto del mensaje.
- Se envía el mensaje mediante el SDK.
- Se añade el mensaje a la lista (localmente, para mostrar en el `RecyclerView`).

##### 2. Inicialización de RecyclerView

Toda la visualización de mensajes se gestiona mediante un `RecyclerView` y el `ChatPageMsgsRecyclerAdapter`:

```java
mAdapter = new ChatPageMsgsRecyclerAdapter();  
messagesRecycler.setAdapter(mAdapter);
```

Cada mensaje se añade usando el método:

```java
public void addNewMessage(String fromId, String fromName, String text, String outId, boolean isOut) {
    messages.add(new ChatModel(fromId, fromName, text, outId, isOut));
    notifyItemInserted(messages.size() - 1);
}
```

Aquí se crea un objeto `ChatModel` con los parámetros:

- `fromId` y `fromName` — identificación del remitente,
- `text` — texto del mensaje,
- `outId` — ID del destinatario,
- `isOutgoing` — si el mensaje es del usuario actual.

##### 3. Renderizado de mensajes en la UI

El método `onBindViewHolder` del adaptador gestiona la visualización de los mensajes:

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

#### Resumen

- Si el mensaje es saliente (`isOutgoing == true`) — se muestra a la derecha.
- Los mensajes entrantes aparecen a la izquierda, mostrando el nombre del remitente.

**💡 Cosas a tener en cuenta:**

- Usa el TrueConf ID completo (`user@server`) — esto mejora la fiabilidad de la entrega.
- Puedes usar `sendChatMessage("", "text")` para enviar al chat grupal de la conferencia actual.
- Todos los eventos y mensajes pueden ser registrados para depuración o analítica.
- La UI se puede ampliar fácilmente: añadir emoji, adjuntos, indicadores de entrega/lectura, etc.

<p align="center">
  <img src="/assets/example6_1.png" style="border: 1px solid #D1CCCC;" alt="TrueConf SDK. Example 6. Chat. Image 1" width="300" height="auto">
  <img src="/assets/example6_2.png" style="border: 1px solid #D1CCCC;" alt="TrueConf SDK. Example 6. Chat. Image 2" width="300" height="auto">
</p>

### Ejemplo 7. Personalización de Ventanas de Video en Conferencia

En este ejemplo exploramos capacidades avanzadas de personalización de la interfaz de videoconferencia usando TrueConf SDK para Android. Aquí mostramos cómo un desarrollador puede reemplazar completamente el comportamiento de las ventanas estándar de conferencia e implementar una UI personalizada con control preciso sobre las ventanas de video y los dispositivos de audio.

<p align="center">
  <img src="/assets/example7_1.png" style="border: 1px solid #D1CCCC;" alt="TrueConf SDK. Example 7. Custom Video Layout. Image 1" width="300" height="auto">
  <img src="/assets/example7_2.png" style="border: 1px solid #D1CCCC;" alt="TrueConf SDK. Example 7. Custom Video Layout. Image 2" width="300" height="auto">
</p>

#### Características Principales de Personalización

Este ejemplo implementa las siguientes características:

- Reemplazo de las ventanas estándar de llamada entrante y saliente por implementaciones personalizadas de `Fragment`.
- Conexión de una interfaz de conferencia personalizada basada en `ConferenceFragment`.
- Gestión de micrófono, cámara y altavoz mediante el SDK.
- Ajuste flexible del tamaño y posición de las ventanas de video de los participantes.
- Selección manual de dispositivos de audio durante la llamada.

#### Estructura de UI Personalizada

Para sobrescribir las ventanas del SDK, se reemplazan las siguientes clases:

| Propósito de la ventana | Clase base del SDK         | Clase personalizada del ejemplo |
| :---------------------- | :------------------------- | :----------------------------- |
| Llamada entrante        | `IncomingCallFragment`     | `IncomingCallFragmentCast`     |
| Llamada saliente        | `PlaceCallFragment`        | `PlaceCallFragmentCast`        |
| Ventana de conferencia  | `ConferenceFragment`       | `ConferenceFragmentCast`       |

La inicialización de ventanas personalizadas se realiza usando el método `setCallCastFragments()` en `MainActivity7`:

```java
TrueConfSDK.getCallScreenController().setPlaceCallFragment(new PlaceCallFragmentCast(...));  
TrueConfSDK.getCallScreenController().setReceiveCallFragment(new IncomingCallFragmentCast(...));  
TrueConfSDK.getCallScreenController().setConferenceFragment(new ConferenceFragmentCast(...));
```

#### Gestión de Elementos de Conferencia

En el archivo `ConferenceFragmentCast.java` se añaden elementos de control manual:

- `btnMic`, `btnCam`, `btnSpeaker` — alternar micrófono, cámara y seleccionar dispositivo de audio.
- `btnFlip`, `btnClose` — cambiar de cámara y finalizar llamada.

Los eventos se gestionan mediante métodos del SDK, por ejemplo:

```java
btnMic.setOnClickListener(view -> onSwitchMic());  
btnSpeaker.setOnClickListener(view -> {  
  TrueConfSDK.getAudioDeviceController().requestAudioState();  
  showDialog = true;  
});
```

El botón de altavoz invoca un diálogo de selección de dispositivo de audio mediante el método `changeAudioDeviceDialog()`. Esta implementación permite al usuario seleccionar manualmente el dispositivo de audio activo o silenciar completamente el sonido:

```java
TrueConfSDK.getAudioDeviceController().setDefaultAudioDevice(selectedDevice);
```

#### Trabajo con el Layout de la Conferencia

##### Ajuste de Parámetros de la Ventana de Llamada

El método `setCallLayoutParams()` permite establecer el tamaño y la posición de la ventana de llamada:

```java
WindowManager.LayoutParams params = new WindowManager.LayoutParams();  
params.width = MATCH_PARENT;  
params.height = 400dp;  
params.gravity = Gravity.BOTTOM;  
TrueConfSDK.getCallWindowController().setCallLayoutParams(params);
```

#### Personalización de la Ubicación de Ventanas de Video

Este ejemplo soporta la colocación manual de ventanas de participantes. Las coordenadas se establecen en un `HashMap<String, Rect> forcedCells`:

```java
forcedCells.put("user1@trueconf.name", new Rect(0, 0, 400, 200));  
forcedCells.put("user2@trueconf.name", new Rect(30, 310, 400, 510));
```

Para aplicar estos valores, descomenta el código en el método `onCalculateCustomLayouts()`:

```java
var customGfxLayout = GfxLayout.NewInstance("just description");  
customGfxLayout.SetManualMode(true);  
customGfxLayout.SetUserCell(peerId, cell);  
...  
TrueConfSDK.getParticipantLayoutController().setCustomLayout(customGfxLayout);
```

Esto da al desarrollador control total sobre la posición y tamaño de las ventanas de video de los participantes en pantalla.

##### Gestión de Dispositivos

El SDK proporciona métodos prácticos para activar/desactivar por defecto el micrófono y la cámara:

```java
TrueConfSDK.getAudioDeviceController().setDefaultMicEnabled(true);  
TrueConfSDK.getVideoDeviceController().setDefaultCameraEnabled(true);
```

El estado actual del dispositivo se puede mostrar en la UI mediante listeners:

```java
@Override  
public void onAudioDeviceUpdate(boolean playerMute, boolean recorderMute, AudioDeviceInfo pair) {  
  setupMic(recorderMute);  
  setupSpeaker(playerMute, pair);  
}
```

La visualización del estado se implementa cambiando los íconos de los botones según el estado:

```java
btnMic.setImageResource(muteRecorder ? R.drawable.ic_mic_off : R.drawable.ic_mic);
```
