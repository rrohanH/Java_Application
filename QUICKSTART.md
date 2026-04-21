# Quick Start Guide - Calculator Web Application

## ✅ Project Successfully Created!

Your Calculator Web Application has been built and is ready to run. Here's how to get started:

## 🚀 Running the Application

### Option 1: Run the Pre-Built JAR (Easiest)
```bash
cd c:\Users\rhnha\Desktop\Java_Application
java -jar target\calculator-app-1.0.0.jar
```

Then open your browser and go to: **http://localhost:8081**

### Option 2: Run from Source with Maven Wrapper
```bash
cd c:\Users\rhnha\Desktop\Java_Application
java "-Dmaven.multiModuleProjectDirectory=." -classpath ".mvn\wrapper\maven-wrapper.jar" org.apache.maven.wrapper.MavenWrapperMain spring-boot:run
```

### Option 3: Rebuild and Run
```bash
cd c:\Users\rhnha\Desktop\Java_Application
java "-Dmaven.multiModuleProjectDirectory=." -classpath ".mvn\wrapper\maven-wrapper.jar" org.apache.maven.wrapper.MavenWrapperMain clean package -DskipTests
java -jar target\calculator-app-1.0.0.jar
```

## 📁 Project Structure

```
Java_Application/
├── pom.xml                                  # Maven configuration
├── mvnw.cmd                                 # Maven wrapper for Windows
├── README.md                                # Full documentation
├── .mvn/wrapper/
│   ├── maven-wrapper.jar                   # Maven automation
│   └── maven-wrapper.properties             # Maven settings
├── src/
│   ├── main/
│   │   ├── java/com/calculator/
│   │   │   ├── CalculatorApplication.java   # Main app entry point
│   │   │   ├── controller/
│   │   │   │   └── CalculatorController.java # REST API endpoints
│   │   │   └── service/
│   │   │       └── CalculatorService.java    # Business logic
│   │   └── resources/
│   │       ├── application.properties        # App configuration
│   │       └── static/
│   │           ├── index.html                # Web interface
│   │           ├── styles.css                # Styling
│   │           └── calculator.js             # Frontend logic
│   └── test/
│       └── java/com/calculator/
│           └── service/
│               └── CalculatorServiceTest.java # Unit tests
└── target/
    ├── calculator-app-1.0.0.jar             # Built application
    └── ...build artifacts...
```

## 🎯 Features

✅ **Basic Operations:** +, -, *, /
✅ **Advanced Operations:** √, x², 1/x  
✅ **Calculation History:** Auto-saved and persistent
✅ **Keyboard Support:** Full keyboard input
✅ **Responsive Design:** Works on desktop, tablet, mobile
✅ **Error Handling:** Graceful error messages
✅ **REST API:** Full API endpoints

## 🌐 Available at

**http://localhost:8081**

## 📡 REST API Endpoints

### Basic Calculator
```
POST /api/calculator/calculate
  ?num1=10&num2=5&operation=+
```

### Advanced Operations
```
POST /api/calculator/advanced
  ?number=16&operation=sqrt
```

### Health Check
```
GET /api/calculator/health
```

## ⌨️ Keyboard Shortcuts

| Key | Action |
|-----|--------|
| 0-9 | Enter numbers |
| . | Decimal point |
| +, -, *, / | Operations |
| Enter | Calculate |
| Backspace | Delete last digit |
| Escape | Clear all |

## 🧪 Running Tests

```bash
cd c:\Users\rhnha\Desktop\Java_Application
java "-Dmaven.multiModuleProjectDirectory=." -classpath ".mvn\wrapper\maven-wrapper.jar" org.apache.maven.wrapper.MavenWrapperMain test
```

## 🔧 Technology Stack

- **Java:** 17 LTS
- **Framework:** Spring Boot 3.1.5
- **Build Tool:** Maven 3.9.5
- **Frontend:** HTML5, CSS3, JavaScript
- **Testing:** JUnit 5

## ⚙️ Application Properties

Edit `src/main/resources/application.properties` to change:
- Server port (default: 8080)
- Application name
- Other Spring Boot settings

## 💡 Tips

1. **First Run:** The first run will take a bit longer as Maven downloads dependencies
2. **Development Mode:** Add DevTools for hot reload by keeping the app running
3. **Clear History:** Click "Clear History" button in the app
4. **History Persistence:** Calculation history is saved in browser localStorage
5. **API Testing:** Use any REST client (Postman, curl, etc.) to test the API

## 📖 Full Documentation

See [README.md](./README.md) for complete documentation including:
- Detailed API documentation
- Setup instructions
- Troubleshooting guide
- Architecture overview
- Future enhancement ideas

## ✨ Enjoying Your Calculator!

Your calculator application is now ready to use. Start doing calculations, and the app will maintain your history automatically!

For questions or issues, refer to the detailed README.md file.
