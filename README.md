# 🏥 RS DIGITAL Queue Management System

A simple hospital queue management system developed in Java to demonstrate the implementation and comparison of three fundamental data structures: **Linked List**, **Queue**, and **Stack**.

---

## 🚀 Key Features

- **Patient Registration**  
  Add new patients to both the master database and the active queue simultaneously.

- **Patient Calling (FIFO)**  
  Call the next patient based on registration order using the *First-In-First-Out* principle.

- **Undo Last Call (LIFO)**  
  Cancel the most recent call and return the patient to the queue using the *Last-In-First-Out* principle.

- **Master Data Management**  
  View all patients, search by name, and remove specific patient records.

- **Data Structure Visualization**  
  Informative console display to monitor the current state of the Queue (waiting list) and Stack (history).

---

## 📊 Data Structure Implementation

This project uses **custom implementations** (not Java Collections Framework) for educational purposes:

### 1. Linked List (`LinkedListPasien`)
Acts as the main data storage (master data), allowing flexible operations such as searching and deleting nodes.

### 2. Queue (`QueueAntrian`)
Manages the patient queue, ensuring fair service order based on arrival time.

### 3. Stack (`StackRiwayat`)
Stores recent call history, enabling the *undo* feature by retrieving the most recent operation.

---

## 🛠️ Requirements

- Java Development Kit (JDK) 8 or higher

---

## 💻 How to Run

1. Clone this repository:
   ```bash
   git clone https://github.com/username/repository-name.git
   ```

2. Navigate to the project directory:
   ```bash
   cd "Tugas 1 linked list stack and queue"
   ```

3. Compile the Java files:
   ```bash
   javac src/*.java -d out
   ```

4. Run the program:
   ```bash
   java -cp out Main
   ```

---

## 🖥️ Menu Preview

```
┌─────────────────────────────────────────┐
│  Queue: 4   |  History: 0   |  Total Patients: 4   │
├─────────────────────────────────────────┤
│  [1] Register New Patient               │
│  [2] Call Next Patient                  │
│  [3] View Current Queue (Queue)         │
│  [4] View All Patients (LinkedList)     │
│  [5] View Action History (Stack)        │
│  [6] Undo Last Call                     │
│  [7] Search Patient                     │
│  [8] Delete Patient Data                │
│  [0] Exit                               │
└─────────────────────────────────────────┘
```

---

## 📌 Notes

- This project is built for educational purposes to understand how fundamental data structures work internally.
- All data structures are implemented manually without using Java Collections Framework.
