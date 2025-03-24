# Cargo Delivery System 🚚

A Java-based logistics simulation project designed to manage cargo delivery operations between multiple distribution centers. This project was developed as part of the **CMPE223 - Data Structures** course assignment.

## 📌 Project Info

- **Name:** Elif Konak  
- **Student ID:** 15235113326  
- **Section:** 02  
- **Assignment:** 01

---

## 🧠 Problem Statement

The Cargo Delivery System simulates a logistics network where packages are transported between cities using a combination of custom data structures such as:

- **Stack** (for LIFO cargo handling)
- **Queue** (for FIFO vehicle dispatch)
- **Doubly Linked List** (for managing both cargo and vehicles internally)

---

## 🎯 Objectives

1. **Implement custom data structures**
   - Doubly Linked List
   - Stack (LIFO for cargo packages)
   - Queue (FIFO for delivery vehicles)

2. **Mission Execution**
   - Handle loading/unloading of cargo across different cities
   - Execute missions based on input files
   - Manage city inventories and vehicle logistics

3. **File I/O Processing**
   - Read initial system configuration (cities, packages, vehicles, missions)
   - Output result files showing final delivery status

---

## 🧱 Module Overview

### 🏁 Main Program
- Manages execution flow, scenario processing, and system initialization

### 📁 File Manager
- Handles reading input files and writing output files

### 🧭 Mission Controller
- Parses and executes delivery missions
- Validates mission instructions

### 🏙️ Distribution Center Manager
- Controls package stacks and vehicle queues in each city

### 🧩 Data Structure Implementations
- Custom implementation of:
  - Stack
  - Queue
  - Doubly Linked List

---

## 💡 Key Classes

- `CargoPackage`: Represents a cargo item, comparable by ID.
- `City`: Holds cargo (stack) and vehicles (queue).
- `CityList`: Manages multiple cities and provides lookup.
- `Mission`: Stores mission details like source, middle, and destination cities.
- `Vehicle`: Inherits from `CargoPackage`, has capacity and cargo list.
- `Main`: Entry point that orchestrates file reading and mission execution.

---

## 📂 File Inputs

- `cities.txt`: List of cities
- `packages.txt`: Initial cargo packages
- `vehicles.txt`: Delivery vehicles and their capacities
- `missions.txt`: Mission routes and instructions

---

## 🔧 Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Custom Data Structures (no built-in Java collections used)

---

## 🚀 How to Run

1. Compile all `.java` files:

```bash
javac *.java

2. Run the main program:
java Main
