# Multicast Client-Server Chat Application

This is a simple Java-based multicast client-server chat application that allows users to send and receive messages over a multicast group. The project uses **Java Sockets**, **Multicast**, and **Swing** for the graphical user interface (GUI).

## Features

- **Multicast Communication**: The application uses multicast to send messages to multiple recipients in a specific multicast group.
- **Client-Server Model**: The communication is based on a client-server architecture, where the client sends messages, and the server receives and displays them.
- **Swing GUI**: Both the client and server applications feature a graphical interface, allowing users to interact easily.
- **Simple Messaging System**: Users can join a multicast group, send messages, and receive messages from others who are part of the same group.

## Project Structure

- **Client.java**: The client-side application where users can enter and send messages to a multicast group.
- **Server.java**: The server-side application that listens to the multicast group and displays received messages.
- **swingMulticast.java**: A launcher for the client-side application with the GUI, which interacts with `Client.java`.

## Requirements

- **Java Development Kit (JDK)** version 8 or later
- **Operating System**: Works on any platform that supports Java (Windows, MacOS, Linux)

## How to Run

### 1. Compile the Java Files

Navigate to the project directory and compile the Java files:

```bash
javac Client.java Server.java swingMulticast.java
```

### 2. Start the Server

Run the Server.java file in a terminal or command prompt:

```bash
java Server
```

### 3. Start the Client

Open a new terminal or command prompt and run the swingMulticast.java file:

```bash
java swingMulticast
```

### 4. Interact with the Application

- Join a Group: Enter the multicast group IP (e.g., 224.100.100.100) and click Join to start receiving messages from others in the group.
- Send Messages: Type your message in the text field and click Send to broadcast it to the group.

## How It Works
- The Server listens to the multicast group and receives any messages sent by clients. It will display the received messages in the GUI.
- The Client sends messages to the multicast group, which will be received by all clients that have joined the group.

