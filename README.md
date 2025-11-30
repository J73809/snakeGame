# **Snake Game**

A simple Snake game built with **Java Swing**, featuring wrap-around movement, score tracking, and basic collision detection.

---
## **Features**

* Arrow-key controls
* Screen wrap (no borders)
* Score counter
* Growing tail
* Apple spawning on a grid
* Lightweight Swing-based rendering

## **Controls**

* **↑ Up**
* **↓ Down**
* **← Left**
* **→ Right**

## **How It Works**

* The snake moves in fixed units (`UNIT_SIZE = 50`).
* When the snake eats an apple:

    * Score increases
    * Tail grows
    * Apple respawns randomly
* Going off one edge makes the snake appear on the opposite side.
* Colliding with your own tail ends the game (throws an exception).

---

## **Run the Game**

### **Using IntelliJ**

1. Clone the repo
2. Open the folder in IntelliJ
3. Run `Main.java`

### **Using command line**

```
javac -d out src/*.java
java -cp out Main
```

---

## **Requirements**

* Java 17+ recommended

## **Notes**

* Rendering uses basic Swing `Graphics` for simplicity.
* Timer speed can be changed in `GamePanel` by adjusting the `Timer` delay.
* Movement feel depends on `UNIT_SIZE` and timer speed; tweak freely.
* First java mini-project
