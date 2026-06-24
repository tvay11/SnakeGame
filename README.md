# SnakeGame

A classic Snake game implemented in Java using the Model-View-Controller (MVC) architectural pattern. This project demonstrates clean separation of concerns, modular design, and fundamental game development principles.

## Project Overview

SnakeGame is a fully functional implementation of the timeless Snake arcade game. The player controls a snake that moves across a grid, consuming food to grow longer while avoiding collisions with walls and its own body. The game increases in difficulty as the snake grows, requiring increasingly precise navigation.

This project was built to showcase proficiency in Java programming, object-oriented design, and the MVC pattern. By separating game logic (Model), user interface (View), and input handling (Controller), the codebase remains maintainable, testable, and extensible. The project serves as a strong example of how to structure a medium-sized application with clear responsibilities and minimal coupling.

## Core Features

- Full Snake game mechanics including movement, growth, collision detection, and scoring.
- Real-time keyboard input handling for directional control (arrow keys).
- Dynamic difficulty scaling as the snake grows longer.
- Clean, grid-based rendering with a simple graphical user interface.
- Game-over detection and restart capability.
- Modular codebase organized into distinct Model, View, and Controller packages.

## Technology Stack

- **Java**: The entire application is written in Java, chosen for its strong object-oriented features, cross-platform compatibility, and extensive standard library. Java's Swing framework provides a straightforward way to build the graphical user interface without external dependencies.
- **Swing (javax.swing)**: Used for rendering the game window, grid, and snake graphics. Swing was selected for its simplicity and built-in support for event-driven programming, which aligns well with the MVC pattern.
- **AWT (java.awt)**: Provides the event handling infrastructure for keyboard input and basic drawing operations. AWT's event model integrates seamlessly with Swing components.

## Architecture / Design Decisions

The project follows the Model-View-Controller (MVC) architectural pattern to ensure a clean separation of concerns:

- **Model**: Contains the core game logic, including the snake's position, direction, growth mechanics, collision detection, and score tracking. The model is completely independent of the user interface, making it easy to test and modify.
- **View**: Responsible for rendering the game state to the screen. The view reads data from the model and draws the grid, snake, food, and score display. It has no knowledge of game logic or input handling.
- **Controller**: Handles user input (keyboard events) and translates them into commands that modify the model. The controller acts as the intermediary between the user and the game logic.

This design decision was made to promote maintainability, testability, and future extensibility. For example, the game logic can be reused with a different view (e.g., a web-based interface) without modification. Similarly, the view can be enhanced or replaced independently of the game rules.

## Installation & Setup

### Prerequisites

- Java Development Kit (JDK) 8 or higher installed on your system.
- A terminal or command prompt.

### Steps

1. Clone the repository:
   ```
   git clone https://github.com/tvay11/SnakeGame.git
   ```

2. Navigate to the project directory:
   ```
   cd SnakeGame
   ```

3. Compile the Java source files:
   ```
   javac -d out src/**/*.java
   ```

4. Run the game:
   ```
   java -cp out SnakeGame
   ```

The game window will open. Use the arrow keys to control the snake. Press any key to restart after a game over.

## Future Scope / Key Learnings

This project reinforced the importance of architectural patterns in building maintainable software. By adhering to MVC, the codebase remained organized even as features were added incrementally. Key learnings include effective use of Java's event-driven programming model, managing game state with a fixed timestep loop, and designing for testability by isolating core logic from presentation.

Future enhancements could include:

- Adding a high-score persistence system using file I/O or a lightweight database.
- Implementing multiple difficulty levels or speed settings.
- Introducing power-ups or obstacles for increased gameplay variety.
- Porting the game logic to a web-based frontend using a framework like JavaFX or a REST API.