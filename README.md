
# 🧠 Memory Game (Java AWT)

A fun little memory matching game made using **Java AWT**! Match all animal pairs and win the game. Simple logic, clean UI, and adorable animal images. 🐻🐶🐱🦊🐼🦉🐧🐨

---

## 🎮 Gameplay

- 4x4 grid (16 buttons)
- Behind each button is a hidden image
- Find all 8 matching pairs
- Game tracks your clicks
- On successful match: images remain visible
- On win: you get a popup 🎉

---

## 📁 Project Structure

```
MemoryGameAWT/
├── bear.jpg
├── cat.jpg
├── dog.jpg
├── fox.jpg
├── iwl.jpg
├── koala.jpg
├── panda.jpg
├── penguin.jpg
├── MemoryGameAWT.java           ← Main source file
├── MemoryGameAWT.class          ← Compiled class file
├── MemoryGameAWT$1.class        ← Compiled anonymous inner class
└── README.md                    ← You're reading this!
```

> 📸 All images and code should be in the **same folder**. Do not move them into subfolders.

---

## 🛠 Requirements

- Java JDK 8+  
- Terminal or IDE (e.g., IntelliJ, Eclipse, or VSCode with Java Extension)

---

## 🚀 How to Compile & Run

### 1. Compile

```bash
javac -source 8 -target 8 MemoryGameAWT.java
```

> For Java 8 users, this helps avoid version mismatch errors.

### 2. Run

```bash
java MemoryGameAWT
```

---

## 🖼 Image Requirements

You’ll need 8 JPG images with these exact filenames:

- `bear.jpg`
- `cat.jpg`
- `dog.jpg`
- `fox.jpg`
- `iwl.jpg`
- `koala.jpg`
- `panda.jpg`
- `penguin.jpg`

👉 They must be placed in the same directory as `MemoryGameAWT.java`.

---

## ✨ Features

- 16 buttons representing hidden image pairs
- Images are scaled to button size
- Simple matching logic
- Random shuffle of images
- Game-over popup on winning

---

## ⚠ Known Issues

- Only JPG format supported (unless code modified)
- No move counter or time tracker (can be added)
- UI may lag if clicked rapidly (can be fixed using a `javax.swing.Timer`)

---

## 🧑‍💻 Author

Made with 💻 and 💖 by **Rushi And Samarth**  
_"If Java had true garbage collection, most programs would delete themselves."_ 😜

---

## 📦 Want a JAR File?

```bash
jar cfe MemoryGame.jar MemoryGameAWT *.class *.jpg
java -jar MemoryGame.jar
```

---

🎉 Enjoy the game and happy debugging!
