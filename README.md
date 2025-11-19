# JavaFX Template

A production-ready JavaFX application template demonstrating best practices.

## Features

- ✅ Modern JavaFX 21 with modular architecture (JPMS)
- ✅ Proper reverse domain notation package structure (`org.lsr7.sta`)
- ✅ Java Platform Module System (`module-info.java`)
- ✅ Centralized resource management
- ✅ Structured logging with `java.util.logging`
- ✅ CSS-based theming
- ✅ Maven build system with wrapper
- ✅ JUnit 5 testing support
- ✅ Native installer support (jpackage ready)

## Project Structure

```
javafx-template/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org/
│   │   │       └── lsr7/
│   │   │           └── sta/
│   │   │               ├── application/  # Main app entry point
│   │   │               ├── controller/   # FXML controllers
│   │   │               └── util/         # Utilities (constants, resource loading)
│   │   └── resources/
│   │       ├── fxml/            # FXML layout files
│   │       ├── css/             # Stylesheets
│   │       ├── images/          # Image assets
│   │       └── logging.properties
│   └── test/
│       └── java/
│           └── org/
│               └── lsr7/
│                   └── sta/
│                       └── util/  # Unit tests
├── pom.xml
└── README.md
```

## Building & Running

### Prerequisites
- Java 21 or higher
- **No Maven installation required** (uses Maven Wrapper)

### Run the Application
```bash
# Mac/Linux
./mvnw clean javafx:run

# Windows
mvnw.cmd clean javafx:run
```

### Build JAR
```bash
./mvnw clean package    # Mac/Linux
mvnw.cmd clean package  # Windows
```

### Run Tests
```bash
./mvnw test             # Mac/Linux
mvnw.cmd test           # Windows
```

### Create Native Installer (Optional)
```bash
# Create a custom runtime image with jlink
./mvnw javafx:jlink

# The runtime image will be in target/javafx-template/
# Run with: target/javafx-template/bin/javafx-template
```

> **Note**: The Maven Wrapper will automatically download Maven 3.9.6 on first run. This may take a minute depending on your internet connection.

## Configuration

### Module System
The project uses Java Platform Module System (JPMS). Module configuration in `module-info.java`:
```java
module org.lsr7.sta.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    
    opens org.lsr7.sta.controller to javafx.fxml;
    exports org.lsr7.sta.application;
}
```

### Logging
Adjust log levels in `src/main/resources/logging.properties`:
```properties
# Set to FINE, FINER, or FINEST for more verbose logging
.level=INFO
org.lsr7.sta.controller.level=FINE  # Debug controllers
org.lsr7.sta.util.level=INFO        # Normal utility logging
```

### Styling
Customize colors in `src/main/resources/css/mainView.css`:
```css
.root {
    -color-primary: #008367;
    -color-primary-light: #01AA8F;
}
```

## License
MIT License