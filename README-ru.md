<p align="center">
  <a href="https://trueconf.ru" target="_blank" rel="noopener noreferrer">
    <picture>
      <source media="(prefers-color-scheme: dark)" srcset="https://raw.githubusercontent.com/TrueConf/.github/refs/heads/main/logos/logo-cyrillic-dark.svg">
      <img width="150" src="https://raw.githubusercontent.com/TrueConf/.github/refs/heads/main/logos/logo-cyrillic.svg">
    </picture>
  </a>
</p>

<h1 align="center">TrueConf SDK для Android</h1>

<p align="center">Программная библиотека для встраивания видеосвязи корпоративного уровня в мобильные приложения на Android</p>

<p align="center">
    <a href="https://t.me/trueconf_talks" target="_blank">
       <img src="https://img.shields.io/badge/Telegram-2CA5E0?logo=telegram&logoColor=white" />
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

## Содержание

- [Что такое TrueConf SDK для Android?](#что-такое-trueconf-sdk-для-android)
  - [Области применения](#области-применения)
  - [Технические особенности](#технические-особенности)
  - [Поддерживаемые фреймворки](#поддерживаемые-фреймворки)
  - [Интеграция с экосистемой TrueConf](#интеграция-с-экосистемой-trueconf)
- [Получение доступа к TrueConf SDK](#получение-доступа-к-trueconf-sdk)
- [Структура проекта](#структура-проекта)
- [Пример №1. Демонстрация основных возможностей TrueConf SDK](#пример-1-демонстрация-основных-возможностей-trueconf-sdk)
  - [Инициализация приложения](#инициализация-приложения)
  - [Инициализация пользовательского интерфейса (UI)](#инициализация-пользовательского-интерфейса-ui)
  - [Основная логика](#основная-логика)
  - [Используемые методы](#используемые-методы)
- [Пример №2. Демонстрация работы с trueconf-ссылками](#пример-2-демонстрация-работы-с-trueconf-ссылками)
  - [Обзор основного кода](#обзор-основного-кода)
    - [Обработка кнопки Parse link](#обработка-кнопки-parse-link)
    - [Обработка кнопки Clear](#обработка-кнопки-clear)
    - [Метод onViewCreated](#метод-onviewcreated)
  - [Пример №3. Работа с групповыми конференциями](#пример-3-работа-с-групповыми-конференциями)
  - [Пример №4. Работа со статусами пользователей](#пример-4-работа-со-статусами-пользователей)
  - [Пример №5. Кастомизация интерфейса](#пример-5-кастомизация-интерфейса)
    - [Как это работает?](#как-это-работает)
    - [Пример кода](#пример-кода)
    - [Где появятся кнопки?](#где-появятся-кнопки)
    - [Кастомизация иконок внутри звонка](#кастомизация-иконок-внутри-звонка)
    - [Итоги](#итоги)
  - [Пример №6. Чат](#пример-6-чат)
    - [📬 Отправка сообщений: `sendChatMessage(toID, text)`](#-отправка-сообщений-sendchatmessagetoid-text)
    - [📥 Получение сообщений: `onChatMessageReceived(...)`](#-получение-сообщений-onchatmessagereceived)
    - [📱 Интерфейс чата: как всё работает](#-интерфейс-чата-как-всё-работает)
      - [1. Обработка кнопки отправки](#1-обработка-кнопки-отправки)
      - [2. Инициализация RecyclerView](#2-инициализация-recyclerview)
      - [3. Отрисовка сообщений в UI](#3-отрисовка-сообщений-в-ui)
    - [Вывод](#вывод)
  - [Пример №7. Кастомизация вывода видеоокон в конференции](#пример-7-кастомизация-вывода-видеоокон-в-конференции)
    - [Основные возможности кастомизации](#основные-возможности-кастомизации)
    - [Структура кастомного UI](#структура-кастомного-ui)
    - [Управление элементами конференции](#управление-элементами-конференции)
    - [Работа с макетом видеоконференции](#работа-с-макетом-видеоконференции)
      - [Настройка параметров окна звонка](#настройка-параметров-окна-звонка)
    - [Кастомизация размещения видеоокон](#кастомизация-размещения-видеоокон)
      - [Управление устройствами](#управление-устройствами)


## Что такое TrueConf SDK для Android?

**TrueConf SDK для Android** — это программная библиотека для встраивания видеосвязи корпоративного уровня в мобильные приложения на Android. С её помощью вы можете добавить в своё приложение поддержку **видеозвонков**, **групповых видеоконференций** с **чатом**, а также гибко управлять интерфейсом и пользовательским опытом.

TrueConf SDK подключается к проекту как внешняя зависимость и предоставляет разработчику обширный **набор API** для полной интеграции с системой видеоконференцсвязи TrueConf. Он включает в себя:

- авторизацию пользователей;
- совершение звонков и участие в конференциях;
- получение и отслеживание статусов пользователей;
- работу с мультимедиа;
- кастомизацию интерфейсов и видеоокон.

### Области применения

TrueConf SDK подходит для создания:

- корпоративных мессенджеров с видеосвязью,
- телемедицинских решений,
- мобильных рабочих мест,
- отраслевых приложений для безопасности, образования, промышленности и т. д.

### Технические особенности

- Подключение к серверу по протоколу **trueconf**.
- Авторизация и регистрация в пользовательской учётной записи.
- Подключение к **групповым конференциям**.
- Звонки другим пользователям.
- Чат внутри конференции.
- Получение и отслеживание пользовательских статусов.
- **Кастомизация интерфейса и видеокомпонентов**.

### Поддерживаемые фреймворки

TrueConf SDK доступен не только для нативных платформ, но и для кроссплатформенной разработки:

- **.NET (C#)**
- **React Native (JavaScript)**  
- **Cordova (JavaScript)**
- **Qt (C++)**

### Интеграция с экосистемой TrueConf

Наличие официального SDK гарантирует надёжное взаимодействие мобильных приложений с другими продуктами TrueConf, включая:

- сервер TrueConf Server;
- другие клиентские приложения на базе SDK;
- внешние системы через TrueConf Server API.

> [!TIP]
> Подключение мобильных приложений, созданных с использованием TrueConf Mobile SDK, возможно **только к серверам**, на которых [**активировано расширение TrueConf SDK**](https://trueconf.ru/docs/server/ru/admin/extensions/#%D0%BF%D0%BE%D0%B4%D0%B4%D0%B5%D1%80%D0%B6%D0%BA%D0%B0-sdk-%D0%BF%D1%80%D0%B8%D0%BB%D0%BE%D0%B6%D0%B5%D0%BD%D0%B8%D0%B8).

<p align="center">
    <img src="/assets/license-ru.png" style="border: 1px solid #D1CCCC;" alt="License TrueConf SDK in Control Panel TrueConf Server" width="800" height="auto">
</p>

## Получение доступа к TrueConf SDK

**TrueConf SDK** для мобильных приложений распространяется через **закрытый удалённый репозиторий**. Доступ к нему предоставляется **по индивидуальному запросу** — обратитесь в отдел продаж через форму обратной связи на сайте или по [официальным контактам](https://trueconf.ru/company/contacts.html).

**Как получить доступ:**

1. **Свяжитесь с отделом продаж TrueConf.** Уточните, что вы хотите получить доступ к TrueConf SDK и приватному Maven-репозиторию для Android.  
   Контакты: [https://trueconf.ru/company/contacts.html](https://trueconf.ru/company/contacts.html)
2. **Опишите ваш проект**. Представители TrueConf могут поинтересоваться целями использования SDK.
3. **Получите реквизиты доступа.** После рассмотрения запроса вы получите логин и пароль для подключения к Maven-репозиторию;
4. **Настройте доступ к Maven-репозиторию.** Для скачивания Android-библиотеки необходимо настроить авторизацию в Gradle с использованием логина и пароля. Для этого в файле `gradle.properties` укажите следующие строки:
  
   ```properties
   trueconfUsername=your_login  
   trueconfPassword=your_password
   ```

> [!WARNING]
> Замените **your\_login** и **your\_password** на выданные вам учетные данные.

## Структура проекта

Скачайте данный репозиторий и откройте его в Android Studio. Все ниже рассматриваемые примеры находятся внутри этого проекта. Проект имеет примерно следующую структуру:

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

## Пример №1. Демонстрация основных возможностей TrueConf SDK

Приложение, где реализованы все основные функции TrueConf SDK:

- инициализация SDK и подключение к серверу;
- авторизация и выход из учетной записи пользователя;
- звонок абоненту сервера по его [TrueConf ID](https://trueconf.ru/docs/server/ru/admin/users/#user-id);
- возможность принимать входящие аудио- и видеозвонки.

<p align="center">
  <img src="/assets/example1_1.png" style="border: 1px solid #D1CCCC;" alt="Android Studio with TrueConf SDK" width="300" height="auto">
  <img src="/assets/example1_2.png" style="border: 1px solid #D1CCCC;" alt="Android Studio with TrueConf SDK" width="300" height="auto">
</p>

### Инициализация приложения

В проекте отройте файл `TestApp1.java` в модуле `TestApp1`. Файл `TestApp1.java` представляет собой главный класс приложения (`Application`), который отвечает за инициализацию TrueConf SDK при старте приложения. Он поддерживает `MultiDex`, что позволяет обойти лимит в 65 536 методов и использовать несколько **.dex**-файлов. Подробнее в [официальной документации](https://developer.android.com/build/multidex).

Для инициализации SDK нужно зарегистрировать приложение с помощью метода [`registerApp`](https://trueconf.ru/docs/mobile-sdk/ru/functions-android/#registerapp). В качестве параметра передаём this (основной класс приложения, который является наследником Application). Это необходимо для управления ресурсами SDK на протяжении всего жизненного цикла приложения.

Для запуска SDK используйте [метод **start**](https://trueconf.ru/docs/mobile-sdk/ru/functions-android/#start). Его вызов требуется **после** `registerApp()`, чтобы SDK мог начать работу. В `start()` можно передать следующие параметры:

- `serverList` – список адресов серверов, разделённых запятой (тип String, необязательный параметр);
- `checkPermissions` – проверяет, есть ли у приложения необходимые разрешения, например, доступ к камере, микрофону, сети (тип Boolean).

**Пример класса `TestApp1`**:

```java
public class TestApp1 extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        TrueConfSDK.getInstance().registerApp(this);
        TrueConfSDK.getInstance().start(true);
    }
}
```

### Инициализация пользовательского интерфейса (UI)

Теперь разберем код в файле `MainActivity1.java`. Класс `MainActivity1` является активностью унаследованной от `AppCompatActivity`. Он выполняет базовую инициализацию пользовательского интерфейса (UI), настраивает работу TrueConf SDK и управляет фрагментами.

В классе мы переопределяем метод `onCreate()`, унаследованный от `AppCompatActivity`. Этот метод вызывается при создании активности и отвечает за ее инициализацию. Вызов `super.onCreate(savedInstanceState)` обеспечивает корректную инициализацию активности, включая установку темы, работу `FragmentManager` и восстановление состояния после уничтожения. Это обязательный вызов перед добавлением пользовательской логики.

Далее нужно выполнить еще несколько важных операций:

1. Необходимо обеспечить корректную обработку выхода из звонка и предотвратить ситуацию, когда после вызова пользователь остается на пустом экране. Для этого в [`setFallbackActivity()`](https://trueconf.ru/docs/mobile-sdk/ru/functions-android/#setfallbackactivity) передайте нужный `Activity` (Class), в нашем случае это – `MainActivity1.class`.

2. Нужно инициализировать разметку, чтобы что-то отображалось в приложении. Вместо обычного способа работы с разметкой (через `findViewById`), мы будем использовать удобный инструмент — [`View Binding`](https://developer.android.com/topic/libraries/view-binding?hl=ru). Для этого создадим объект `binding`, который автоматически связывает код с элементами интерфейса из `res/layout/activity\_main.xml`:
  
   ```java
   ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
   ```

3. Отобразить экран пользователю. Для этого используем `setContentView(binding.getRoot())`. Если это первый запуск экрана, что значит `savedInstanceState == null`, то подгружаем наш интерфейс с помощью менеджера фрагментов ([`FragmentManager`](https://developer.android.com/guide/fragments/fragmentmanager?hl=ru)):

   ```java
   getSupportFragmentManager()  
   .beginTransaction()  
   .add(binding.container.getId(), new PlaceholderFragment())  
   .commit();
   ```

**Пример класса `MainActivity1`**:

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

### Основная логика

Вся логика работы этого примера расположена в файле `PlaceholderFragment.java`. В нем определен одноименный класс PlaceholderFragment, который представляет собой фрагмент Android-приложения и реализует интерфейсы `TrueConfListener.LoginEventsCallback` и `TrueConfListener.ServerStatusEventsCallback`, позволяя обрабатывать изменения статуса подключения и авторизации.

Основные функции класса `PlaceholderFragment`:

1. **Подключение к серверу** – ввод адреса сервера видеосвязи (IP или FQDN) и запуск подключение.
2. **Авторизация** – ввод логина и пароля для входа в систему.
3. **Осуществление вызова** – ввод ID пользователя и инициирование звонка.
4. **Выход из системы** – обработка выхода пользователя.
5. **Обновление интерфейса** – управление видимостью кнопок и полей в зависимости от состояния подключения и авторизации.

Мы не будем подробно разбирать все 200 строк в этом файле, а остановимся на важных моментах.

Методы с аннотацией `@Override` являются callback-функциями, которые переопределяют методы из родительского класса, тем самым добавляя дополнительную логику, например, при уничтожении приложения мы дополнительно удаляем `TrueConfListener`:

```java
@Override
    public void onDestroy() {
        super.onDestroy();
        TrueConfSDK.getInstance().removeTrueconfListener(this);
    }
```

Вся основная логика приложения сконцентрирована в одном методе `setUpUI()`. Он:

- связывает элементы интерфейса с переменными:

  ```java
  mETLogin = binding.etLogin;  
  mETPass = binding.etPass;  
  ...
  ```

- назначает обработчики событий для кнопок (авторизация, подключение, вызов, выход):

  ```java
  binding.btnConnect.setOnClickListener(btn -> afterServerEnter());  
  mBtnLogin.setOnClickListener(btn -> {...}  
  mBtnCall.setOnClickListener(btn -> {...}
  ```

- управляет видимостью элементов в зависимости от состояний:

  ```java
  mETServer.setVisibility(data == null || data.length == 0 ? View.GONE : View.VISIBLE)
  ```

Соответственно, если вам необходимо изменить какую-то логику в примере №1, то необходимо править файл `PlaceholderFragment.java`.

### Используемые методы

И наконец разберем используемые методы TrueConfSDK:

- `TrueConfSDK.getInstance().addTrueconfListener(this)` – добавление слушателя;
- `TrueConfSDK.getServerManager().isLoggedIn()` – проверка авторизации пользователя на сервере;
- `TrueConfSDK.getInstance().start(server, true)` – запускает SDK с определённым сервером;
- `TrueConfSDK.getServerManager().loginAs(username, password, true, false)` – авторизация на сервере определенным пользователем;
- `TrueConfSDK.getConferenceManager().callTo(peerId)` – вызов определенного пользователя;
- `TrueConfSDK.getServerManager().logout()` – выход (деавторизация) из учетной записи пользователя;
- `TrueConfSDK.getInstance().removeTrueconfListener(this)` – удаление слушателя.

## Пример №2. Демонстрация работы с trueconf-ссылками

Разберём пример, в котором приложение позволяет подключиться к TrueConf Server и инициировать вызов с помощью URI-схемы **trueconf** (например, `trueconf:ivanov`). Это может быть как звонок конкретному пользователю по его TrueConf ID, так и подключение к групповой конференции по её идентификатору. Авторизация и соединение выполняются автоматически — логин и параметры сервера передаются внутри ссылки. Вызов обрабатывается с помощью метода [`parseProtocolLink`](https://trueconf.ru/docs/mobile-sdk/ru/functions-android/#parseprotocollink), которому передается строка вызова в формате `String`.

> [!TIP]
> Подробнее о синтаксисе и возможностях URI-схемы **trueconf** [читайте в этой статье.](https://trueconf.ru/blog/baza-znaniy/protokol-trueconf-dlya-vzaimodeystviya-s-klientskimi-prilozheniyami-trueconf)

### Обзор основного кода

В файле `MainActivity2.java` в модуле `TestApp2` находится класс с одноименным названием, который также как и `TestApp1` наследуется от `AppCompatActivity`. Внутри класса `MainActivity2` вы найдете статический вложенный класс (*static nested class*) `PlaceholderFragment`. Его задача — продемонстрировать работу с SDK через ввод и разбор ссылок с URI-схемой **trueconf**. После инициализации приложения и создания макета фрагмента вызывается метод класса `onViewCreated()`. В нем реализуются следующие действия:

#### Обработка кнопки Parse link

```java
binding.btnParseLink.setOnClickListener(btn -> {
    var link = mETLink.getText().toString().trim();
    if (!TextUtils.isEmpty(link)) {
        TrueConfSDK.getVisicallManager().parseProtocolLink(link);
    }
});
```

- при нажатии считывается текст из поля, удаляются пробелы;
- если строка не пуста, вызывается метод `parseProtocolLink(...)` у [`IVisicallManager`](https://trueconf.ru/docs/mobile-sdk/ru/functions-android/#ivisicallmanager), предоставляемого TrueConf SDK;
- этот метод инициализирует соединение с сервером, авторизует пользователя и инициирует вызов — [всё через одну ссылку](https://trueconf.ru/blog/baza-znaniy/protokol-trueconf-dlya-vzaimodeystviya-s-klientskimi-prilozheniyami-trueconf).

#### Обработка кнопки Clear

```java
binding.btnClear.setOnClickListener(btn -> mETLink.setText(""));
```

Просто очищает поле ввода, сбрасывая содержимое. Для удобства тестирования данного примера вы можете вставить ссылку из кода, чтобы не вводить ее каждый раз:

```java
mETLink.setText("trueconf:chester&h=10.110.2.240&login=joe_smith&password=12345678&encrypt=1&force=1");
```

#### Метод onViewCreated

**Фрагмент кода метода `onViewCreated()`**:

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

### Пример №3. Работа с групповыми конференциями

Данный пример демонстрирует подключение к многопользовательской видеоконференции с помощью метода `joinConf(conferenceId)`. В отличие от вызова конкретного пользователя через `callTo(userId)`, здесь используется идентификатор конференции `(String confId)` для подключения к уже созданной сессии на сервере.

Интерфейс практически не отличается от примера №1, за исключением того, что используется метод `joinConf(...)` вместо `callTo(...)`.

<p align="center">
  <img src="/assets/example3_1.png" style="border: 1px solid #D1CCCC;" alt="" width="300" height="auto">
</p>

На текущий момент поддерживается только подключение к уже существующим конференциям.

В методе `setUpUI()` в классе `PlaceholderFragment` приведен пример реализации подключения к конференции при нажатии на кнопку **Call**:

```java
mBtnCall.setOnClickListener(v1 -> {
  var conferenceId = mETConferenceId.getText().toString();
  if (!conferenceId.isEmpty()) {
      TrueConfSDK.getConferenceManager().joinConf(conferenceId);
  }
});
```

Если `Conference ID` указан корректно, будет выполнено подключение к соответствующей конференции:  

<p align="center">
  <img src="/assets/example3_2.png" style="border: 1px solid #D1CCCC;" alt="" width="800" height="auto">
</p>

### Пример №4. Работа со статусами пользователей

Пример демонстрирует, как отслеживать статусы пользователей на сервере, а также добавление пользователя для последующего мониторинга его доступности.

Реализация состоит из двух экранов: на первом осуществляется подключение к серверу и авторизация, после чего открывается второй экран со списком пользователей из адресной книги.

В примере показано, как получить текущий статус пользователя с помощью метода `getUserStatus(user)`, а также как обрабатывать изменения статуса через обратные вызовы `onUserStatusUpdate` и `onContactListUpdate`.

Чтобы ознакомиться с кодом, перейдите в проект `TestApp4 → java → com.trueconf.sample`. В данной папке немного больше файлов, чем в предыдущих, поэтому вкратце разберем их:

- `TestApp4.java` — класс Application. Инициализирует TrueConf SDK в onCreate(): задаёт сервер, выполняет авторизацию и устанавливает соединение.
- `MainActivity4.java` — точка входа в UI. Загружает ContactListFragment при запуске активности.
- `ContactListFragment.java` — фрагмент UI. Отображает список пользователей, подписывается на события изменения статуса (onUserStatusUpdate, onContactListUpdate), позволяет добавлять пользователей по ID. Использует ContactsAdapter.
- `ContactsAdapter.java` — адаптер RecyclerView. Отображает ID и статус пользователя с emoji. Обновляет данные через updateContact, использует ViewHolder.

**🗂 Структура и взаимодействие компонентов:**

```
TestApp4 (Application)  
│  
└───▶ Инициализация TrueConf SDK  
│  
▼  
MainActivity4 (Activity)  
│  
└───▶ Загружает ContactListFragment  
│  
├── Подключается к TrueConf SDK  
├── Подписывается на события статуса пользователей  
├── Отображает список пользователей (RecyclerView)  
└── Использует:  
▼  
ContactsAdapter (RecyclerView.Adapter)  
├── Хранит список пользователей  
├── Отображает ID и статус (emoji)  
└── Обновляет данные по событиям SDK
```

**📍 `ContactListFragment.java`: подписка на события и управление списком**

Файл `ContactListFragment.java` реализует фрагмент, в котором отображаются пользователи с их актуальным статусом подключения. После создания фрагмента и загрузки макета в `onViewCreated()`, происходит регистрация текущего класса как слушателя событий SDK:

```java
TrueConfSDK.getInstance().addTrueconfListener(this);
```

Это позволяет обрабатывать изменения через callback:

- `onUserStatusUpdate(String id, PresenceStatus status)` — вызывается при изменении статуса конкретного пользователя;

- `onContactListUpdate()` — вызывается при обновлении списка контактов (адресной книги).

При нажатии на кнопку добавления контакта вызывается получение статуса пользователя по ID:

```java
var peerId = addContactEdit.getText().toString();  
var status = TrueConfSDK.getContactsManager().getUserStatus(peerId);
```

Метод [`getUserStatus(String id)`](https://trueconf.ru/docs/mobile-sdk/ru/functions-android/#getuserstatus) возвращает значение `PresenceStatus` — это может быть `ONLINE`, `BUSY`, `LOGOFF` и [другие состояния](https://trueconf.ru/docs/mobile-sdk/ru/types/). После получения статуса он передаётся в адаптер:

```java
adapter.updateContact(peerId, status);
```

Также в `onContactListUpdate()` происходит получение полной адресной книги абонентов с сервера TrueConf. Метод [`getUsers()`](https://trueconf.ru/docs/mobile-sdk/ru/functions-android/#getusers) возвращает список всех пользователей, доступных в адресной книге:

```java
var peerList = TrueConfSDK.getContactsManager().getUsers();  
adapter.contacts.clear();  
adapter.contacts.addAll(peerList);  
adapter.notifyDataSetChanged();
```

Этот список сохраняется в адаптере, а интерфейс обновляется через `notifyDataSetChanged()`, если в текущем списке менее двух элементов. Такой подход используется для первичной загрузки данных или восстановления списка при сбросе состояния.

Таким образом, фрагмент реализует полную подписку на события TrueConf SDK и обновление UI в реальном времени.

**📍 `ContactsAdapter.java`: отображение ID и статусов с эмоджи**

Класс `ContactsAdapter` реализует адаптер `RecyclerView`, отображающий `ID` пользователя и его текущий статус. Он работает с объектами ContactInfo, содержащими идентификатор пользователя и значение `PresenceStatus`. Форматирование данных для отображения реализовано в методе `onBindViewHolder`, где вызывается функция `getStatusEmoji(...)`:

```java
var text = peerId + " " + getStatusEmoji(status);  
holder.binding.text.setText(text);
```

Метод `getStatusEmoji` сопоставляет значения `PresenceStatus` с понятными визуальными индикаторами, например:

```java
case ONLINE: return "🟢 Online";  
case BUSY: return "🟠 Busy";
```

**📍 Что мы имеем в итоге?**

В рамках примера была продемонстрирована практическая реализация основных механизмов TrueConf SDK для Android: подписка на события обновления статуса пользователей, получение текущего состояния абонентов и загрузка полной адресной книги с сервера с использование методов `getUserStatus()` и `getUsers()`.

Ниже приведен скриншоты работающего приложения **Example 4**:

<p align="center">
  <img src="/assets/example4_1.png" style="border: 1px solid #D1CCCC;" alt="" width="300" height="auto">
  <img src="/assets/example4_2.png" style="border: 1px solid #D1CCCC;" alt="" width="300" height="auto">
</p>

### Пример №5. Кастомизация интерфейса

В TrueConf SDK для Android вы можете расширить панель управления звонком, добавив собственные кнопки через интерфейс [`IExtraButtonController`](https://trueconf.ru/docs/mobile-sdk/ru/functions-android/#iextrabuttoncontroller). Это позволяет запускать дополнительные действия прямо из окна конференции — например, открытие фрагмента или переход в другую `Activity`.

#### Как это работает?

Пользовательские кнопки добавляются методом `setNewExtraButtons()`, который принимает список объектов типа `TCExtraButton`. Эти кнопки появляются в интерфейсе конференции при нажатии на кнопку “троеточие” (⋯) — это правый элемент панели управления во время звонка.

Контроллер `IExtraButtonController` доступен через SDK:

```java
TrueConfSDK.getExtraButtonController()
```

#### Пример кода

Ниже представлен полный пример добавления двух кнопок:

- первая кнопка открывает `Fragment`,

- вторая — запускает `Activity`.

```java
ArrayList<TCExtraButton> buttons = new ArrayList<>();
// Обработчик для первой кнопки: открытие Fragment поверх конференции  
View.OnClickListener onClickListener = btn ->
  ((AppCompatActivity) btn.getContext())
          .getSupportFragmentManager()
          .beginTransaction()
          .add(com.trueconf.sdk.R.id.container_call, new EmptyFragment())
          .addToBackStack(null)
          .commit();  
// Обработчик для второй кнопки: запуск Activity  
View.OnClickListener onClickListener2 = btn -> {
    Intent emptyActivity = new Intent (this, FirstActivity.class);
    startActivity(emptyActivity);
}; 
// Создание кнопок и добавление в список  
buttons.add(new TCExtraButton("button 1", onClickListener));  
buttons.add(new TCExtraButton("button 2", onClickListener2));  
// Передача списка кнопок в SDK  
TrueConfSDK.getExtraButtonController().setNewExtraButtons(buttons);
```

#### Где появятся кнопки?

Добавленные кнопки не заменяют стандартные элементы интерфейса. Они отображаются только по нажатию на “троеточие” в нижней панели управления звонком. Располагаются они в том порядке, в котором были добавлены в список `buttons`.

<p align="center">
  <img src="/assets/example5_1.png" style="border: 1px solid #D1CCCC;" alt="" width="400" height="auto">
</p>

#### Кастомизация иконок внутри звонка

Если вам нужно изменить стандартные иконки (например, микрофон, камера, динамик, кнопка завершения вызова и т.д.), вы можете заменить ресурсы изображений в папке `res/drawable`. SDK автоматически подхватит ваши кастомные версии, если имена файлов совпадают со стандартными.

Вот список поддерживаемых имён для замены иконок:

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

Просто добавьте ваши версии этих иконок с соответствующими именами в `res/drawable`, и они автоматически заменят встроенные.

#### Итоги

Пример №5 показывает, как с минимальными усилиями интегрировать кастомные действия прямо в окно конференции, сохраняя нативный внешний вид интерфейса. Благодаря гибкому API `IExtraButtonController` и возможности подмены иконок, разработчики могут настроить поведение и внешний вид панели под задачи своего приложения.

Первая кнопка открывает `Fragment`, а вторая – `Activity`.  

<p align="center">
  <img src="/assets/example5_2.png" style="border: 1px solid #D1CCCC;" alt="" width="300" height="auto">
  <img src="/assets/example5_3.png" style="border: 1px solid #D1CCCC;" alt="" width="300" height="auto">
</p>

### Пример №6. Чат

Этот пример демонстрирует реализацию текстового чата, включая отправку сообщений с помощью `sendChatMessage()` и обработку входящих событий через `onChatMessageReceived()`.

В этом материале мы разберем, как устроен чат в мобильном приложении с использованием TrueConf SDK, и покажем, как происходит отправка, отображение и обработка сообщений с точки зрения архитектуры приложения.

#### 📬 Отправка сообщений: `sendChatMessage(toID, text)`

Метод `sendChatMessage()` позволяет отправить текстовое сообщение указанному пользователю:

```java
TrueConfSDK.getChatManager().sendChatMessage(receiverId, messageText);
```

Параметры:

- `toID` — TrueConf ID получателя (в формате `user@server.name`). Для отправки в общий чат конференции можно передавать пустую строку.
- `text` — содержимое сообщения.

Возвращаемое значение:

- `true` – если сообщение было успешно отправлено на сервер;
- `false` — если не удалось из-за потери соединения (в этом случае сообщение ставится в очередь и будет отправлено при восстановлении связи).

> [!TIP]
> Преимущество TrueConf SDK: если пользователь оффлайн — сообщение доставится, как только он появится в сети.

#### 📥 Получение сообщений: `onChatMessageReceived(...)`

Для обработки входящих сообщений реализуется callback:

```java
@Override  
public void onChatMessageReceived(String fromId, String fromName, String text, String toId) {  
  mAdapter.addNewMessage(fromId, fromName, text, toId, false);  
}
```

Параметры:

- `fromId` — ID отправителя;
- `fromName` — имя отправителя;
- `text` — текст сообщения;
- `toId` — ID получателя (ваш ID или конференция).

#### 📱 Интерфейс чата: как всё работает

##### 1. Обработка кнопки отправки

В `ChatPageFragment` в методе `onViewCreated()` обрабатывается нажатие кнопки отправки:

```java
view.findViewById(R.id.chat_action_button).setOnClickListener(v -> {
    var receiverId = binding.toolbar.etTo.getText().toString();
    var messageText = binding.toolbar.etChatMessage.getText().toString();
    TrueConfSDK.getChatManager().sendChatMessage(receiverId, messageText);
    mAdapter.addNewMessage(TrueConfSDK.getContactsManager().getMyId(), TrueConfSDK.getContactsManager().getMyName(),
        messageText, receiverId, true);
});
```

Что происходит:

- Получаем ID получателя и текст.
- Отправляем сообщение через SDK.
- Добавляем сообщение в список (локально, для отображения в `RecyclerView`).

##### 2. Инициализация RecyclerView

Всё отображение сообщений происходит через `RecyclerView` и адаптер `ChatPageMsgsRecyclerAdapter`:

```java
mAdapter = new ChatPageMsgsRecyclerAdapter();  
messagesRecycler.setAdapter(mAdapter);
```

Каждое сообщение добавляется с помощью метода:

```java
public void addNewMessage(String fromId, String fromName, String text, String outId, boolean isOut) {
    messages.add(new ChatModel(fromId, fromName, text, outId, isOut));
    notifyItemInserted(messages.size() - 1);
}
```

Здесь создаётся объект `ChatModel` с параметрами:

- `fromId` и `fromName` — идентификация отправителя,
- `text` — текст сообщения,
- `outId` — ID получателя,
- `isOutgoing` — метка, исходит ли сообщение от текущего пользователя.

##### 3. Отрисовка сообщений в UI

Метод `onBindViewHolder` адаптера обрабатывает отображение сообщений:

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

#### Вывод

- Если сообщение исходящее (`isOutgoing == true`) — оно отображается справа.

- Входящее сообщение — слева, с подписью отправителя.

**💡 Что стоит учесть?**

- Используйте полный TrueConf ID (`user@server`) — это повышает стабильность доставки.
- Можно использовать `sendChatMessage("", "текст")` для отправки в общий чат текущей конференции.
- Все события и сообщения можно логировать для отладки или аналитики.
- UI можно легко расширить: добавить emoji, вложения, индикаторы “доставлено/прочитано”.

<p align="center">
  <img src="/assets/example6_1.png" style="border: 1px solid #D1CCCC;" alt="TrueConf SDK. Example 6. Chat. Image 1" width="300" height="auto">
  <img src="/assets/example6_2.png" style="border: 1px solid #D1CCCC;" alt="TrueConf SDK. Example 6. Chat. Image 2" width="300" height="auto">
</p>

### Пример №7. Кастомизация вывода видеоокон в конференции

В данной примере мы рассмотрим расширенные возможности кастомизации интерфейса видеоконференции при использовании TrueConf SDK для Android. Здесь мы хотим продемонстрировать, как разработчик может полностью переопределить поведение стандартных окон конференции и реализовать собственный UI с точным управлением видеоокнами и аудиоустройствами.

<p align="center">
  <img src="/assets/example7_1.png" style="border: 1px solid #D1CCCC;" alt="TrueConf SDK. Example 6. Chat. Image 1" width="300" height="auto">
  <img src="/assets/example7_2.png" style="border: 1px solid #D1CCCC;" alt="TrueConf SDK. Example 6. Chat. Image 2" width="300" height="auto">
</p>

#### Основные возможности кастомизации

Пример реализует следующие функции:

- Замена стандартных окон входящего и исходящего вызовов кастомными `Fragment`.
- Подключение собственного интерфейса конференции на основе `ConferenceFragment`.
- Управление микрофоном, камерой и динамиком через SDK.
- Гибкая настройка размеров и координат видеоокон участников.
- Возможность ручного выбора аудиоустройств во время звонка.

#### Структура кастомного UI

Для замены окон SDK используется переопределение следующих классов:

| Назначение окна | Базовый класс SDK | Кастомный класс из примера |
| :---- | :---- | :---- |
| Входящий вызов | `IncomingCallFragment` | `IncomingCallFragmentCast` |
| Исходящий вызов | `PlaceCallFragment` | `PlaceCallFragmentCast` |
| Окно конференции | `ConferenceFragment` | `ConferenceFragmentCast` |

Инициализация кастомных окон выполняется методом `setCallCastFragments()` в `MainActivity7`:

```java
TrueConfSDK.getCallScreenController().setPlaceCallFragment(new PlaceCallFragmentCast(...));  
TrueConfSDK.getCallScreenController().setReceiveCallFragment(new IncomingCallFragmentCast(...));  
TrueConfSDK.getCallScreenController().setConferenceFragment(new ConferenceFragmentCast(...));
```

#### Управление элементами конференции

В файле `ConferenceFragmentCast.java` вручную добавлены элементы управления:

- `btnMic`, `btnCam`, `btnSpeaker` — переключение микрофона, камеры и выбора аудиоустройства.

- `btnFlip`, `btnClose` — смена камеры и завершение звонка.

События обработаны через методы SDK, например:

```java
btnMic.setOnClickListener(view -> onSwitchMic());  
btnSpeaker.setOnClickListener(view -> {  
  TrueConfSDK.getAudioDeviceController().requestAudioState();  
  showDialog = true;  
});
```

Кнопка динамика вызывает диалог выбора устройства через метод `changeAudioDeviceDialog()`. Реализация позволяет пользователю вручную выбрать активное аудиоустройство или полностью отключить звук:

```java
TrueConfSDK.getAudioDeviceController().setDefaultAudioDevice(selectedDevice);
```

#### Работа с макетом видеоконференции

##### Настройка параметров окна звонка

Метод `setCallLayoutParams()` позволяет задать размеры и положение окна вызова:

```java
WindowManager.LayoutParams params = new WindowManager.LayoutParams();  
params.width = MATCH_PARENT;  
params.height = 400dp;  
params.gravity = Gravity.BOTTOM;  
TrueConfSDK.getCallWindowController().setCallLayoutParams(params);
```

#### Кастомизация размещения видеоокон

Пример предусматривает ручное размещение окон участников конференции. Координаты задаются в `HashMap<String, Rect> forcedCells`:

```java
forcedCells.put("user1@trueconf.name", new Rect(0, 0, 400, 200));  
forcedCells.put("user2@trueconf.name", new Rect(30, 310, 400, 510));
```

Чтобы применить эти значения, необходимо раскомментировать код в методе `onCalculateCustomLayouts()`:

```java
var customGfxLayout = GfxLayout.NewInstance("just description");  
customGfxLayout.SetManualMode(true);  
customGfxLayout.SetUserCell(peerId, cell);  
...  
TrueConfSDK.getParticipantLayoutController().setCustomLayout(customGfxLayout);
```

Это дает разработчику полный контроль над положением и размерами окон видеоучастников на экране.

##### Управление устройствами

SDK предоставляет удобные методы для включения/выключения микрофона и камеры по умолчанию:

```java
TrueConfSDK.getAudioDeviceController().setDefaultMicEnabled(true);  
TrueConfSDK.getVideoDeviceController().setDefaultCameraEnabled(true);
```

Текущий статус устройств можно отобразить на UI через слушатели:

```java
@Override  
public void onAudioDeviceUpdate(boolean playerMute, boolean recorderMute, AudioDeviceInfo pair) {  
  setupMic(recorderMute);  
  setupSpeaker(playerMute, pair);  
}
```

Отображение состояния реализовано через изменение иконок кнопок в зависимости от статуса:

```java
btnMic.setImageResource(muteRecorder ? R.drawable.ic_mic_off : R.drawable.ic_mic);
```
