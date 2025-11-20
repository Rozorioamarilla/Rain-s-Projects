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
Rain's Closet - Minimal JavaFX Dress-Up

What this repo contains
- Minimal JavaFX application: `src/main/java/org/lsr7/sta/application/RainsClosetFX.java`
- Image assets under `src/main/resources/img/` used by the app

Goals
- Keep the project small and focused on building a dress-up game UI
- Load images from the classpath so the app runs both from IDE and via Maven

Run (development)

The recommended way to run during development is using the JavaFX Maven plugin:

```bash
mvn clean javafx:run
```

Build

```bash
mvn clean package
```

Notes
- `RainsClosetFX` loads images from `resources/img` using classpath lookups (`getResource(...)`). Ensure the images exist in `src/main/resources/img/` before running.
- For a simple development run, `mvn javafx:run` will download the correct JavaFX dependencies for your platform.

If you want, I can:
- Add simple UI controls to swap clothes at runtime
- Produce a runnable, self-contained native image using `jlink`/`jpackage`
- Reintroduce any of the removed helper classes if you prefer a different structure

Tell me which of the above you'd like next and I will continue.