# JAVA Project

This project is an Order Management System implemented in Java. It demonstrates the use of classic data structures (such as Binary Search Trees) and object-oriented programming to manage customers, products, and orders. The system provides a menu-driven interface for managing and processing orders, customers, and products.

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- (Optional) An IDE like IntelliJ IDEA, Eclipse, or VS Code for easier code navigation

## Installation

1. **Clone the repository** (if not already downloaded):
   ```sh
   git clone <repository-url>
   cd Sale-Management-System-main
   ```
2. **Compile the source code:**
   Use the following command from the project root to compile all Java files:
   ```sh
   javac -d target/classes src/asm/*.java
   ```
   This will compile the Java files and place the `.class` files in the `target/classes` directory.

   Alternatively, if you use Maven, you can build the project with:
   ```sh
   mvn clean package
   ```

## How to Run

After compiling, run the main class to start the Order Management System. For example:

```sh
java -cp target/classes asm.Asm
```

Or, if you built with Maven, you can run the generated JAR:

```sh
java -jar target/asm-1.0-SNAPSHOT.jar
```

## Project Structure

```
Sale-Management-System-main/
├── src/
│   └── asm/
│       ├── Asm.java           # Main entry point
│       ├── Customer.java      # Customer entity
│       ├── Menu.java          # Menu system
│       ├── MenuManager.java   # Menu management logic
│       ├── MyList.java        # Custom list implementation
│       ├── Ordering.java      # Order management
│       ├── Product.java       # Product entity
│       ├── Validate.java      # Input validation
│       └── run.bat            # Batch file to run the program (Windows)
├── src/file/                  # Data files (Customers, Orders, Products)
├── target/                    # Compiled classes and JAR output
├── README.md                  # Project documentation
└── ... (other project and build files)
```

- The `asm` package contains all the main Java source files for the Order Management System.
- The `file` directory contains sample data files for customers, orders, and products.
- The `target` directory contains compiled classes and the packaged JAR after building.

## Learn More

- [Java Documentation](https://docs.oracle.com/javase/tutorial/)
- [How to Compile and Run Java](https://www.oracle.com/java/technologies/javase/codeconventions-137265.html)
- For questions or contributions, please open an issue or pull request.
