# Contributing to JavaFX Template

## Development Setup

1. Clone the repository
   ```bash
   git clone https://github.com/Summit-Technology-Academy/javafx-template.git
   cd javafx-template
   ```

2. Ensure Java 21+ is installed
   ```bash
   java -version
   ```

3. Run the application (Maven not required - uses wrapper)
   ```bash
   ./mvnw clean javafx:run
   ```

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
│   │   │               └── util/         # Utilities (constants, resource loading, dialogs)
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
├── .mvn/                         # Maven wrapper configuration
├── mvnw / mvnw.cmd               # Maven wrapper scripts
├── pom.xml                       # Maven dependencies
├── module-info.java              # Java Platform Module System descriptor
└── README.md
```

## Module System

This project uses the Java Platform Module System (JPMS). The `module-info.java` file defines:
- Required modules (javafx.controls, javafx.fxml, java.logging)
- Packages opened for reflection (controllers for FXML)
- Exported packages (public API)

When adding new packages:
1. If the package contains FXML controllers, add `opens packagename to javafx.fxml;`
2. If the package is part of the public API, add `exports packagename;`
3. If you add dependencies, add corresponding `requires` statements

## Code Style

- Use 4 spaces for indentation
- Follow Java naming conventions (camelCase for methods, PascalCase for classes)
- Add logging to all public methods using `java.util.logging`
- Write unit tests for utility classes
- Use constants from `AppConstants` instead of hardcoded strings
- Keep controllers focused on UI logic, extract business logic to separate classes

## Logging Best Practices

```java
private static final Logger LOGGER = Logger.getLogger(ClassName.class.getName());

// Use appropriate log levels
LOGGER.info("User action or significant event");
LOGGER.fine("Detailed debugging information");
LOGGER.warning("Warning condition");
LOGGER.severe("Error condition");
```

## Testing

```bash
# Run all tests
./mvnw test

# Run tests with coverage (if configured)
./mvnw clean test jacoco:report
```

## Building

```bash
# Compile
./mvnw compile

# Package JAR
./mvnw package

# Clean build
./mvnw clean install
```

## Pull Request Process

1. Create a feature branch
   ```bash
   git checkout -b feature/my-new-feature
   ```

2. Make your changes following the code style guidelines

3. Add tests for new functionality

4. Ensure all tests pass
   ```bash
   ./mvnw test
   ```

5. Update README.md if adding new features or changing behavior

6. Commit with descriptive messages
   ```bash
   git commit -m "Add feature: description of what you added"
   ```

7. Push to your fork and submit a pull request

8. Wait for review and address any feedback

## Adding New Features

### Adding a New View
1. Create FXML file in `src/main/resources/fxml/`
2. Add constant to `AppConstants.java`
3. Create controller in `src/main/java/controller/` extending `BaseController`
4. Use `ResourceLoader.getFXMLLoader()` to load the view

### Adding New Resources
1. Place files in appropriate `src/main/resources/` subdirectory
2. Add path constant to `AppConstants.java`
3. Use `ResourceLoader` methods to load resources

### Adding Dependencies
1. Add dependency to `pom.xml`
2. Update version properties if applicable
3. Document any new setup steps in README.md

## Debugging

Set logging level to `FINE` or `FINER` in `logging.properties`:
```properties
.level=FINE
org.lsr7.sta.controller.level=FINER
```

## Questions?

Open an issue for:
- Bug reports
- Feature requests
- Documentation improvements
- General questions

Thank you for contributing!
