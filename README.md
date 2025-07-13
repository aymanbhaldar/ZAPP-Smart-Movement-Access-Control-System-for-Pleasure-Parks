🎢 ZAPP – Zenith Attractions and Pleasure Parks
A Java-based object-oriented simulation for smart guest movement and access control

📌 Project Overview
This project simulates a guest movement system for a theme park, Fantasia Pleasure Park, where access between park areas is controlled through smart cards and one-way bridges. Each guest carries a card loaded with credits and a luxury rating which determines where they can go. The system ensures access rules, credit deduction, and area capacities are correctly enforced.

🧠 Key Features
🚪 Bridge Crossing Rules: Guests can only cross if they have enough credits, the destination has space, and their luxury rating meets the area requirement.

🎫 Smart Card System: Cards track guest name, credits, points, and luxury rating. Points can be converted to credits.

🧱 Park Structure: Areas are connected by one-way bridges and enforce strict access control.

🧍‍♂️ Card Types with Inheritance: Includes ChildCard, TouristCard, and CompanyCard with custom behaviors.

🧪 Test-driven Development: Includes CardTester, MyTester, and ParkUI for full test coverage.

🧱 Object-Oriented Design
Card – Base class for all card types

Area – Represents a zone in the park with capacity and luxury rating

Bridge – Handles one-way movement between areas with validation

Park – Implements the ZAPP interface and manages all cards, areas, and bridges

ParkUI – Console-based interface for user interaction

MyTester – Automated test class simulating real scenarios

🛠 Technologies Used
Java 17+

BlueJ IDE (main development)

IntelliJ IDEA (converted for compatibility)

Modular OOP design with clear separation of concerns

🚀 How to Run
✅ BlueJ
Open the zapp-students project in BlueJ.

Compile all classes.

Run ParkUI or MyTester for testing.

✅ IntelliJ
Import the project into IntelliJ as a Java project.

Run ParkUI.java or MyTester.java.

🧪 Test Coverage
CardTester – Validates all methods in Card class

MyTester – Comprehensive park simulation, edge-case testing

ParkUI – Interactive console-based user test interface

📁 Project Structure
zapp-students/
├── Card.java
├── CardTester.java
├── Area.java
├── Bridge.java
├── Park.java
├── ZAPP.java (interface)
├── ParkUI.java
├── MyTester.java
└── (Other card subclasses)

👤 Author
Ayman Bhaldar
University of Hertfordshire | BSc Computer Science (Artificial Intelligence)
Email: aymanbhaldar123@gmail.com
LinkedIn: linkedin.com/in/aymanbhaldar
