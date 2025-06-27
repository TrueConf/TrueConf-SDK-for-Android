<p align="center">
  <a href="https://trueconf.com" target="_blank" rel="noopener noreferrer">
    <picture>
      <source media="(prefers-color-scheme: dark)" srcset="https://trueconf.com/images/headMenu/logo.svg">
      <img width="150" src="https://trueconf.com/images/headMenu/logo.svg">
    </picture>
  </a>
</p>

<h1 align="center">TrueConf SDK for Android</h1>

<p align="center">A software library for embedding enterprise-grade video communication into Android mobile applications</p>

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

## Table of Contents

- [What is TrueConf SDK for Android?](#what-is-trueconf-sdk-for-android)
  - [Use Cases](#use-cases)
  - [Technical Features](#technical-features)
  - [Supported Frameworks](#supported-frameworks)
  - [Integration with the TrueConf Ecosystem](#integration-with-the-trueconf-ecosystem)
- [Getting Access to TrueConf SDK](#getting-access-to-trueconf-sdk)
- [Project Structure](#project-structure)
- [Example 1. Demonstration of Basic TrueConf SDK Features](#example-1-demonstration-of-basic-trueconf-sdk-features)
  - [Application Initialization](#application-initialization)
  - [User Interface (UI) Initialization](#user-interface-ui-initialization)
  - [Main Logic](#main-logic)
  - [Used Methods](#used-methods)
- [Example 2. Working with TrueConf URI links](#example-2-working-with-trueconf-uri-links)
  - [Overview of the Main Code](#overview-of-the-main-code)
    - [Handling the Parse link Button](#handling-the-parse-link-button)
    - [Handling the Clear Button](#handling-the-clear-button)
    - [onViewCreated Method](#onviewcreated-method)
  - [Example 3. Working with Group Conferences](#example-3-working-with-group-conferences)
  - [Example 4. Working with User Statuses](#example-4-working-with-user-statuses)
  - [Example 5. Interface Customization](#example-5-interface-customization)
    - [How does it work?](#how-does-it-work)
    - [Code Example](#code-example)
    - [Where will the buttons appear?](#where-will-the-buttons-appear)
    - [Customizing in-call icons](#customizing-in-call-icons)
    - [Summary](#summary)
  - [Example 6. Chat](#example-6-chat)
    - [📬 Sending messages: `sendChatMessage(toID, text)`](#-sending-messages-sendchatmessagetoid-text)
    - [📥 Receiving messages: `onChatMessageReceived(...)`](#-receiving-messages-onchatmessagereceived)
    - [📱 Chat interface: how it works](#-chat-interface-how-it-works)
      - [1. Handling the send button](#1-handling-the-send-button)
      - [2. Initializing RecyclerView](#2-initializing-recyclerview)
      - [3. Rendering messages in the UI](#3-rendering-messages-in-the-ui)
    - [Summary](#summary-1)
  - [Example 7. Customizing Conference Video Windows](#example-7-customizing-conference-video-windows)
    - [Main Customization Features](#main-customization-features)
    - [Custom UI Structure](#custom-ui-structure)
    - [Managing Conference Elements](#managing-conference-elements)
    - [Working with Conference Layout](#working-with-conference-layout)
      - [Adjusting Call Window Parameters](#adjusting-call-window-parameters)
    - [Customizing Video Window Placement](#customizing-video-window-placement)
      - [Device Management](#device-management)

## What is TrueConf SDK for Android?

**TrueConf SDK for Android** is a software library for embedding enterprise-grade video communication into Android mobile applications. With it, you can add support for **video calls**, **group video conferences** with **chat**, and flexibly manage the interface and user experience in your app.

TrueConf SDK is connected to your project as an external dependency and provides a comprehensive **API set** for full integration with the TrueConf video conferencing system. It includes:

- user authentication;
- making calls and participating in conferences;
- obtaining and tracking user statuses;
- working with multimedia;
- customizing interfaces and video windows.

### Use Cases

TrueConf SDK is suitable for creating:

- corporate messengers with video communication,
- telemedicine solutions,
- mobile workstations,
- industry-specific applications for security, education, manufacturing, and more.

### Technical Features

- Connection to the server via the **trueconf** protocol.
- User account authorization and registration.
- Connection to **group conferences**.
- Calls to other users.
- In-conference chat.
- Receiving and tracking user statuses.
- **Interface and video component customization**.

### Supported Frameworks

TrueConf SDK is available not only for native platforms but also for cross-platform development:

- **.NET (C#)**
- **React Native (JavaScript)**
- **Cordova (JavaScript)**
- **Qt (C++)**

### Integration with the TrueConf Ecosystem

The official SDK ensures reliable interaction of mobile applications with other TrueConf products, including:

- TrueConf Server;
- other client applications based on the SDK;
- external systems via the TrueConf Server API.

> [!TIP]
> Mobile applications created with TrueConf Mobile SDK can connect **only to servers** where the [**TrueConf SDK extension is activated**](https://trueconf.com/docs/server/en/admin/extensions/#support-for-sdk-applications).

<p align="center">
    <img src="/assets/license.png" style="border: 1px solid #D1CCCC;" alt="License TrueConf SDK in Control Panel TrueConf Server" width="800" height="auto">
</p>

## Getting Access to TrueConf SDK

**TrueConf SDK** for mobile applications is distributed via a **private remote repository**. Access is provided **upon individual request**—please contact the sales department using the feedback form on the website or via [official contacts](https://trueconf.com/company/contacts.html).

**How to get access:**

1. **Contact the TrueConf sales department.** Specify that you want access to the TrueConf SDK and the private Maven repository for Android.  
   Contacts: [https://trueconf.com/company/contacts.html](https://trueconf.com/company/contacts.html)
2. **Describe your project.** TrueConf representatives may ask about your intended use of the SDK.
3. **Receive access credentials.** After your request is reviewed, you will receive a login and password to connect to the Maven repository.
4. **Configure access to the Maven repository.** To download the Android library, you need to set up authorization in Gradle using your login and password. In your `gradle.properties` file, add the following lines:
  
   ```properties
   trueconfUsername=your_login  
   trueconfPassword=your_password
   ```

   > [!WARNING]
   > Replace **your_login** and **your_password** with the credentials provided to you.

## Project Structure

Download this repository and open it in Android Studio. All the examples discussed below are included in this project. The project has approximately the following structure:

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

## Example 1. Demonstration of Basic TrueConf SDK Features

An application where all the main TrueConf SDK functions are implemented:

- SDK initialization and connection to the server;
- user authorization and logout;
- calling a server user by their [TrueConf ID](https://trueconf.com/docs/server/en/admin/users/#user-id);
- the ability to receive incoming audio and video calls.

<p align="center">
  <img src="/assets/example1_1.png" style="border: 1px solid #D1CCCC;" alt="Android Studio with TrueConf SDK" width="300" height="auto">
  <img src="/assets/example1_2.png" style="border: 1px solid #D1CCCC;" alt="Android Studio with TrueConf SDK" width="300" height="auto">
</p>

### Application Initialization

In the project, open the `TestApp1.java` file in the `TestApp1` module. The `TestApp1.java` file is the main application class (`Application`) responsible for initializing TrueConf SDK when the app starts. It supports `MultiDex` (`MultiDexApplication`), which allows bypassing the 65,536 method limit and using multiple **.dex** files. Learn more in the [official documentation](https://developer.android.com/build/multidex).

To initialize the SDK, you need to register the application using the [`registerApp`](https://trueconf.com/docs/mobile-sdk/en/functions-android/#registerapp) method. Pass `this` (the main application class, which inherits from Application) as a parameter. This is required to manage SDK resources throughout the application's lifecycle.

To start the SDK, use the [**start** method](https://trueconf.com/docs/mobile-sdk/en/functions-android/#start). You must call it **after** `registerApp()` for the SDK to begin working. You can pass the following parameters to `start()`:

- `serverList` – a comma-separated list of server addresses (String, optional parameter);
- `checkPermissions` – checks if the app has the necessary permissions, such as access to the camera, microphone, network (Boolean).

**Example `TestApp1` class:**

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

### User Interface (UI) Initialization

Now let's look at the code in `MainActivity1.java`. The `MainActivity1` class is an activity that inherits from `AppCompatActivity`. It performs basic UI initialization, configures the TrueConf SDK, and manages fragments.

In this class, we override the `onCreate()` method from `AppCompatActivity`. This method is called when the activity is created and is responsible for its initialization. The call to `super.onCreate(savedInstanceState)` ensures proper activity initialization, including theme setup, `FragmentManager` operation, and restoring state after destruction. This call is required before adding your custom logic.

Next, several important steps must be performed:

1. Ensure proper handling of call exit and prevent the situation where the user stays on a blank screen after a call. For this, use [`setFallbackActivity()`](https://trueconf.com/docs/mobile-sdk/en/functions-android/#setfallbackactivity) and pass the desired `Activity` class (in this case, `MainActivity1.class`).

2. Initialize the layout so that something is displayed in the app. Instead of the usual `findViewById` approach, we will use the convenient [`View Binding`](https://developer.android.com/topic/libraries/view-binding?hl=en) tool. Create a `binding` object that automatically binds code to UI elements from `res/layout/activity_main.xml`:
  
   ```java
   ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
   ```

3. Display the screen to the user. Use `setContentView(binding.getRoot())`. If this is the first time the screen is launched (`savedInstanceState == null`), load our interface using the fragment manager ([`FragmentManager`](https://developer.android.com/guide/fragments/fragmentmanager?hl=en)):

   ```java
   getSupportFragmentManager()  
   .beginTransaction()  
   .add(binding.container.getId(), new PlaceholderFragment())  
   .commit();
   ```

**Example `MainActivity1` class:**

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

### Main Logic

All the logic for this example is located in the `PlaceholderFragment.java` file. It defines a class `PlaceholderFragment`, which is an Android fragment and implements the `TrueConfListener.LoginEventsCallback` and `TrueConfListener.ServerStatusEventsCallback` interfaces, allowing you to handle connection and authorization status changes.

Main functions of the `PlaceholderFragment` class:

1. **Connecting to the server** – entering the video server address (IP or FQDN) and starting the connection.
2. **Authorization** – entering a login and password to sign in.
3. **Making a call** – entering the user ID and initiating a call.
4. **Logout** – handling user logout.
5. **Updating the interface** – managing the visibility of buttons and fields depending on the connection and authorization state.

We won't go through all 200 lines in this file, but will focus on the key points.

Methods annotated with `@Override` are callback functions that override methods from the parent class, adding extra logic. For example, when the app is destroyed, we also remove the `TrueConfListener`:

```java
@Override
    public void onDestroy() {
        super.onDestroy();
        TrueConfSDK.getInstance().removeTrueconfListener(this);
    }
```

All main app logic is concentrated in the `setUpUI()` method. It:

- binds UI elements to variables:

  ```java
  mETLogin = binding.etLogin;  
  mETPass = binding.etPass;  
  ...
  ```

- assigns event handlers for buttons (authorization, connection, call, logout):

  ```java
  binding.btnConnect.setOnClickListener(btn -> afterServerEnter());  
  mBtnLogin.setOnClickListener(btn -> {...}  
  mBtnCall.setOnClickListener(btn -> {...}
  ```

- manages the visibility of elements depending on states:

  ```java
  mETServer.setVisibility(data == null || data.length == 0 ? View.GONE : View.VISIBLE)
  ```

So, if you need to change any logic in Example 1, you need to edit the `PlaceholderFragment.java` file.

### Used Methods

And finally, let's look at the TrueConfSDK methods used:

- `TrueConfSDK.getInstance().addTrueconfListener(this)` – adds a listener;
- `TrueConfSDK.getServerManager().isLoggedIn()` – checks if the user is authorized on the server;
- `TrueConfSDK.getInstance().start(server, true)` – starts the SDK with a specific server;
- `TrueConfSDK.getServerManager().loginAs(username, password, true, false)` – authorizes a specific user on the server;
- `TrueConfSDK.getConferenceManager().callTo(peerId)` – calls a specific user;
- `TrueConfSDK.getServerManager().logout()` – logs out (de-authorizes) the user;
- `TrueConfSDK.getInstance().removeTrueconfListener(this)` – removes the listener.

## Example 2. Working with TrueConf URI links

Let's look at an example where the application allows you to connect to TrueConf Server and initiate a call using the **trueconf** URI scheme (for example, `trueconf:ivanov`). This can be a call to a specific user by their TrueConf ID or connecting to a group conference by its identifier. Authorization and connection are performed automatically—login and server parameters are passed inside the link. The call is handled using the [`parseProtocolLink`](https://trueconf.com/docs/mobile-sdk/en/functions-android/#parseprotocollink) method, which takes the call string as a `String`.

> [!TIP]
> For more details about the syntax and capabilities of the **trueconf** URI scheme, [read this article.](https://trueconf.com/blog/knowledge-base/trueconf-protocol-designed-to-interact-with-trueconf-client-applications)

### Overview of the Main Code

In `MainActivity2.java` in the `TestApp2` module, there is a class with the same name, which, like `TestApp1`, inherits from `AppCompatActivity`. Inside the `MainActivity2` class, you will find a static nested class `PlaceholderFragment`. Its purpose is to demonstrate working with the SDK by entering and parsing links using the **trueconf** URI scheme. After the application is initialized and the fragment layout is created, the class's `onViewCreated()` method is called. It implements the following actions:

#### Handling the Parse link Button

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

#### Handling the Clear Button

```java
binding.btnClear.setOnClickListener(btn -> mETLink.setText(""));
```

Simply clears the input field, resetting its content. For convenience in testing this example, you can paste a link from the code so you don't have to type it every time:

```java
mETLink.setText("trueconf:chester&h=10.110.2.240&login=joe_smith&password=12345678&encrypt=1&force=1");
```

#### onViewCreated Method

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

### Example 3. Working with Group Conferences

This example demonstrates connecting to a multi-user video conference using the `joinConf(conferenceId)` method. Unlike calling a specific user via `callTo(userId)`, here the conference identifier `(String confId)` is used to join an already created session on the server.

The interface is almost identical to Example 1, except that the `joinConf(...)` method is used instead of `callTo(...)`.

<p align="center">
  <img src="/assets/example3_1.png" style="border: 1px solid #D1CCCC;" alt="" width="300" height="auto">
</p>

Currently, only connection to existing conferences is supported.

In the `setUpUI()` method of the `PlaceholderFragment` class, here is an example of connecting to a conference when the **Call** button is pressed:

```java
mBtnCall.setOnClickListener(v1 -> {
  var conferenceId = mETConferenceId.getText().toString();
  if (!conferenceId.isEmpty()) {
      TrueConfSDK.getConferenceManager().joinConf(conferenceId);
  }
});
```

If the `Conference ID` is specified correctly, the app will connect to the corresponding conference:  

<p align="center">
  <img src="/assets/example3_2.png" style="border: 1px solid #D1CCCC;" alt="" width="800" height="auto">
</p>

### Example 4. Working with User Statuses

This example demonstrates how to track user statuses on the server, as well as add a user for subsequent monitoring of their availability.

The implementation consists of two screens: the first connects to the server and authorizes the user, after which the second screen displays a list of users from the address book.

The example shows how to get the current user status using the `getUserStatus(user)` method, as well as how to handle status changes via the `onUserStatusUpdate` and `onContactListUpdate` callbacks.

To view the code, go to `TestApp4 → java → com.trueconf.sample`. This folder contains a few more files than previous examples, so let's briefly review them:

- `TestApp4.java` — Application class. Initializes TrueConf SDK in `onCreate()`: sets the server, performs authorization, and establishes the connection.
- `MainActivity4.java` — UI entry point. Loads `ContactListFragment` when the activity starts.
- `ContactListFragment.java` — UI fragment. Displays the user list, subscribes to status change events (`onUserStatusUpdate`, `onContactListUpdate`), allows adding users by ID. Uses `ContactsAdapter`.
- `ContactsAdapter.java` — RecyclerView adapter. Displays the user ID and status with emoji. Updates data via `updateContact`, uses a ViewHolder.

**🗂 Component structure and interaction:**

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

**📍 `ContactListFragment.java`: subscribing to events and managing the list**

The `ContactListFragment.java` file implements a fragment that displays users with their current connection status. After the fragment is created and its layout is loaded in `onViewCreated()`, the current class is registered as an SDK event listener:

```java
TrueConfSDK.getInstance().addTrueconfListener(this);
```

This allows you to handle changes via callbacks:

- `onUserStatusUpdate(String id, PresenceStatus status)` — called when a specific user's status changes;
- `onContactListUpdate()` — called when the contact list (address book) is updated.

When the add contact button is pressed, the user's status is retrieved by ID:

```java
var peerId = addContactEdit.getText().toString();  
var status = TrueConfSDK.getContactsManager().getUserStatus(peerId);
```

The [`getUserStatus(String id)`](https://trueconf.com/docs/mobile-sdk/en/functions-android/#getuserstatus) method returns a `PresenceStatus` value—this can be `ONLINE`, `BUSY`, `LOGOFF`, and [other states](https://trueconf.com/docs/mobile-sdk/en/types/). After getting the status, it is passed to the adapter:

```java
adapter.updateContact(peerId, status);
```

In `onContactListUpdate()`, the full address book of subscribers is obtained from the TrueConf server. The [`getUsers()`](https://trueconf.com/docs/mobile-sdk/en/functions-android/#getusers) method returns a list of all users available in the address book:

```java
var peerList = TrueConfSDK.getContactsManager().getUsers();  
adapter.contacts.clear();  
adapter.contacts.addAll(peerList);  
adapter.notifyDataSetChanged();
```

This list is stored in the adapter, and the interface is updated via `notifyDataSetChanged()` if there are fewer than two items in the current list. This approach is used for initial data loading or restoring the list after a state reset.

Thus, the fragment implements full subscription to TrueConf SDK events and real-time UI updates.

**📍 `ContactsAdapter.java`: displaying IDs and statuses with emoji**

The `ContactsAdapter` class implements a `RecyclerView` adapter that displays the user's `ID` and current status. It works with `ContactInfo` objects containing the user's identifier and `PresenceStatus` value. Data formatting for display is implemented in the `onBindViewHolder` method, where the `getStatusEmoji(...)` function is called:

```java
var text = peerId + " " + getStatusEmoji(status);  
holder.binding.text.setText(text);
```

The `getStatusEmoji` method maps `PresenceStatus` values to clear visual indicators, for example:

```java
case ONLINE: return "🟢 Online";  
case BUSY: return "🟠 Busy";
```

**📍 What do we get as a result?**

This example demonstrates a practical implementation of the main mechanisms of TrueConf SDK for Android: subscribing to user status update events, obtaining the current state of subscribers, and loading the full address book from the server using the `getUserStatus()` and `getUsers()` methods.

Below are screenshots of the working **Example 4** application:

<p align="center">
  <img src="/assets/example4_1.png" style="border: 1px solid #D1CCCC;" alt="" width="300" height="auto">
  <img src="/assets/example4_2.png" style="border: 1px solid #D1CCCC;" alt="" width="300" height="auto">
</p>

### Example 5. Interface Customization

In TrueConf SDK for Android, you can extend the call control panel by adding your own buttons via the [`IExtraButtonController`](https://trueconf.com/docs/mobile-sdk/en/functions-android/#iextrabuttoncontroller) interface. This allows you to trigger additional actions directly from the conference window, such as opening a fragment or navigating to another `Activity`.

#### How does it work?

Custom buttons are added using the `setNewExtraButtons()` method, which takes a list of `TCExtraButton` objects. These buttons appear in the conference interface when the user clicks the "more" (⋯) button, which is the rightmost element of the call control panel during a call.

The `IExtraButtonController` is available via the SDK:

```java
TrueConfSDK.getExtraButtonController()
```

#### Code Example

Below is a complete example of adding two buttons:

- The first button opens a `Fragment`,
- The second button launches an `Activity`.

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

#### Where will the buttons appear?

The added buttons do not replace standard interface elements. They are displayed only when you click the "more" button (⋯) on the bottom call control panel. They appear in the order in which they were added to the `buttons` list.

<p align="center">
  <img src="/assets/example5_1.png" style="border: 1px solid #D1CCCC;" alt="" width="400" height="auto">
</p>

#### Customizing in-call icons

If you need to change the default icons (e.g., microphone, camera, speaker, end call button, etc.), you can replace the image resources in the `res/drawable` folder. The SDK will automatically use your custom versions if the filenames match the standard ones.

Here is the list of supported icon names for replacement:

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

Just add your versions of these icons with the corresponding names to `res/drawable`, and they will automatically replace the built-in ones.

#### Summary

Example 5 shows how you can integrate custom actions directly into the conference window with minimal effort, while maintaining the native look and feel of the interface. Thanks to the flexible `IExtraButtonController` API and the ability to override icons, developers can tailor the behavior and appearance of the panel to their application's needs.

The first button opens a `Fragment`, and the second opens an `Activity`.  

<p align="center">
  <img src="/assets/example5_2.png" style="border: 1px solid #D1CCCC;" alt="" width="300" height="auto">
  <img src="/assets/example5_3.png" style="border: 1px solid #D1CCCC;" alt="" width="300" height="auto">
</p>

### Example 6. Chat

This example demonstrates the implementation of a text chat, including sending messages with `sendChatMessage()` and handling incoming events via `onChatMessageReceived()`.

In this section, we will look at how chat is implemented in a mobile app using TrueConf SDK, and show how sending, displaying, and processing of messages works from the application architecture perspective.

#### 📬 Sending messages: `sendChatMessage(toID, text)`

The `sendChatMessage()` method allows you to send a text message to a specified user:

```java
TrueConfSDK.getChatManager().sendChatMessage(receiverId, messageText);
```

Parameters:

- `toID` — TrueConf ID of the recipient (in the format `user@server.name`). To send to the group chat of the current conference, you can pass an empty string.
- `text` — message content.

Return value:

- `true` – if the message was successfully sent to the server;
- `false` — if it failed due to loss of connection (in this case, the message is queued and will be sent when the connection is restored).

> [!TIP]
> TrueConf SDK advantage: if the user is offline, the message will be delivered as soon as they come online.

#### 📥 Receiving messages: `onChatMessageReceived(...)`

To handle incoming messages, implement a callback:

```java
@Override  
public void onChatMessageReceived(String fromId, String fromName, String text, String toId) {  
  mAdapter.addNewMessage(fromId, fromName, text, toId, false);  
}
```

Parameters:

- `fromId` — sender's ID;
- `fromName` — sender's name;
- `text` — message text;
- `toId` — recipient's ID (your ID or conference).

#### 📱 Chat interface: how it works

##### 1. Handling the send button

In `ChatPageFragment`, inside the `onViewCreated()` method, the send button is handled:

```java
view.findViewById(R.id.chat_action_button).setOnClickListener(v -> {
    var receiverId = binding.toolbar.etTo.getText().toString();
    var messageText = binding.toolbar.etChatMessage.getText().toString();
    TrueConfSDK.getChatManager().sendChatMessage(receiverId, messageText);
    mAdapter.addNewMessage(TrueConfSDK.getContactsManager().getMyId(), TrueConfSDK.getContactsManager().getMyName(),
        messageText, receiverId, true);
});
```

What happens:

- Get recipient ID and message text.
- Send the message via SDK.
- Add the message to the list (locally, for display in `RecyclerView`).

##### 2. Initializing RecyclerView

All message display is handled via a `RecyclerView` and the `ChatPageMsgsRecyclerAdapter`:

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

Here, a `ChatModel` object is created with parameters:

- `fromId` and `fromName` — sender identification,
- `text` — message text,
- `outId` — recipient ID,
- `isOutgoing` — whether the message is from the current user.

##### 3. Rendering messages in the UI

The adapter's `onBindViewHolder` method handles the display of messages:

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

#### Summary

- If the message is outgoing (`isOutgoing == true`) — it is displayed on the right.

- Incoming messages are on the left, with the sender's name shown.

**💡 Things to consider:**

- Use the full TrueConf ID (`user@server`) — this increases delivery reliability.
- You can use `sendChatMessage("", "text")` to send to the group chat of the current conference.
- All events and messages can be logged for debugging or analytics.
- The UI can be easily extended: add emoji, attachments, delivery/read indicators, etc.

<p align="center">
  <img src="/assets/example6_1.png" style="border: 1px solid #D1CCCC;" alt="TrueConf SDK. Example 6. Chat. Image 1" width="300" height="auto">
  <img src="/assets/example6_2.png" style="border: 1px solid #D1CCCC;" alt="TrueConf SDK. Example 6. Chat. Image 2" width="300" height="auto">
</p>

### Example 7. Customizing Conference Video Windows

In this example, we explore advanced customization capabilities of the video conference interface using TrueConf SDK for Android. Here, we demonstrate how a developer can completely override the behavior of standard conference windows and implement a custom UI with precise control over video windows and audio devices.

<p align="center">
  <img src="/assets/example7_1.png" style="border: 1px solid #D1CCCC;" alt="TrueConf SDK. Example 7. Custom Video Layout. Image 1" width="300" height="auto">
  <img src="/assets/example7_2.png" style="border: 1px solid #D1CCCC;" alt="TrueConf SDK. Example 7. Custom Video Layout. Image 2" width="300" height="auto">
</p>

#### Main Customization Features

This example implements the following features:

- Replacing the standard incoming and outgoing call windows with custom `Fragment` implementations.
- Connecting a custom conference interface based on `ConferenceFragment`.
- Managing microphone, camera, and speaker via the SDK.
- Flexible adjustment of participant video window sizes and positions.
- Manual selection of audio devices during a call.

#### Custom UI Structure

To override SDK windows, the following classes are replaced:

| Window Purpose         | SDK Base Class           | Custom Class from Example    |
| :--------------------- | :----------------------- | :-------------------------- |
| Incoming call          | `IncomingCallFragment`   | `IncomingCallFragmentCast`  |
| Outgoing call          | `PlaceCallFragment`      | `PlaceCallFragmentCast`     |
| Conference window      | `ConferenceFragment`     | `ConferenceFragmentCast`    |

Custom window initialization is performed using the `setCallCastFragments()` method in `MainActivity7`:

```java
TrueConfSDK.getCallScreenController().setPlaceCallFragment(new PlaceCallFragmentCast(...));  
TrueConfSDK.getCallScreenController().setReceiveCallFragment(new IncomingCallFragmentCast(...));  
TrueConfSDK.getCallScreenController().setConferenceFragment(new ConferenceFragmentCast(...));
```

#### Managing Conference Elements

In the `ConferenceFragmentCast.java` file, manual control elements are added:

- `btnMic`, `btnCam`, `btnSpeaker` — toggle microphone, camera, and select audio device.
- `btnFlip`, `btnClose` — switch camera and end call.

Events are handled via SDK methods, for example:

```java
btnMic.setOnClickListener(view -> onSwitchMic());  
btnSpeaker.setOnClickListener(view -> {  
  TrueConfSDK.getAudioDeviceController().requestAudioState();  
  showDialog = true;  
});
```

The speaker button invokes an audio device selection dialog via the `changeAudioDeviceDialog()` method. This implementation allows the user to manually select the active audio device or completely mute sound:

```java
TrueConfSDK.getAudioDeviceController().setDefaultAudioDevice(selectedDevice);
```

#### Working with Conference Layout

##### Adjusting Call Window Parameters

The `setCallLayoutParams()` method allows you to set the call window size and position:

```java
WindowManager.LayoutParams params = new WindowManager.LayoutParams();  
params.width = MATCH_PARENT;  
params.height = 400dp;  
params.gravity = Gravity.BOTTOM;  
TrueConfSDK.getCallWindowController().setCallLayoutParams(params);
```

#### Customizing Video Window Placement

This example supports manual placement of participant windows. Coordinates are set in a `HashMap<String, Rect> forcedCells`:

```java
forcedCells.put("user1@trueconf.name", new Rect(0, 0, 400, 200));  
forcedCells.put("user2@trueconf.name", new Rect(30, 310, 400, 510));
```

To apply these values, uncomment the code in the `onCalculateCustomLayouts()` method:

```java
var customGfxLayout = GfxLayout.NewInstance("just description");  
customGfxLayout.SetManualMode(true);  
customGfxLayout.SetUserCell(peerId, cell);  
...  
TrueConfSDK.getParticipantLayoutController().setCustomLayout(customGfxLayout);
```

This gives the developer full control over the position and size of participant video windows on the screen.

##### Device Management

The SDK provides convenient methods for enabling/disabling microphone and camera by default:

```java
TrueConfSDK.getAudioDeviceController().setDefaultMicEnabled(true);  
TrueConfSDK.getVideoDeviceController().setDefaultCameraEnabled(true);
```

The current device status can be displayed in the UI via listeners:

```java
@Override  
public void onAudioDeviceUpdate(boolean playerMute, boolean recorderMute, AudioDeviceInfo pair) {  
  setupMic(recorderMute);  
  setupSpeaker(playerMute, pair);  
}
```

Status display is implemented by changing button icons depending on state:

```java
btnMic.setImageResource(muteRecorder ? R.drawable.ic_mic_off : R.drawable.ic_mic);
```
