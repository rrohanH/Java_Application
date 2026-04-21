# Calculator Web Application

A modern, feature-rich calculator web application built with **Spring Boot** and **JavaScript**. This application provides basic arithmetic operations, advanced mathematical functions, and a persistent calculation history.

## Features

✨ **Core Features:**
- Basic arithmetic operations: Addition, Subtraction, Multiplication, Division
- Advanced operations: Square Root, Square, Reciprocal
- Real-time calculation history
- Persistent history using localStorage
- Keyboard support for all operations
- Responsive, mobile-friendly design

🎨 **User Interface:**
- Modern gradient UI with intuitive design
- Real-time expression display
- Smooth animations and transitions
- Clean and organized layout
- Mobile-responsive design

🔧 **Technical Stack:**
- **Backend:** Spring Boot 3.1.5
- **Frontend:** HTML5, CSS3, JavaScript
- **Build Tool:** Maven
- **Java Version:** 17
- **HTTP Server:** Embedded Tomcat

## Project Structure

```
Java_Application/
├── pom.xml                                 # Maven configuration
├── src/
│   ├── main/
│   │   ├── java/com/calculator/
│   │   │   ├── CalculatorApplication.java # Main Spring Boot application
│   │   │   ├── controller/
│   │   │   │   └── CalculatorController.java # REST API endpoints
│   │   │   └── service/
│   │   │       └── CalculatorService.java  # Business logic
│   │   └── resources/
│   │       ├── application.properties      # Application configuration
│   │       └── static/
│   │           ├── index.html              # Main HTML interface
│   │           ├── styles.css              # Styling
│   │           └── calculator.js           # Frontend logic
│   └── test/
│       └── java/com/calculator/
│           └── service/
│               └── CalculatorServiceTest.java # Unit tests
└── README.md                               # This file
```

## Installation & Setup

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- A modern web browser

### Steps

1. **Navigate to the project directory:**
   ```bash
   cd Java_Application
   ```

2. **Build the project:**
   ```bash
   mvn clean package
   ```

3. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

   Or run the JAR directly:
   ```bash
   java -jar target/calculator-app-1.0.0.jar
   ```

4. **Access the application:**
   - Open your browser and navigate to: `http://localhost:8081`
   - The calculator interface will load immediately

## API Endpoints

### Basic Calculator Operations
**POST** `/api/calculator/calculate`

Request parameters:
- `num1` (double): First number
- `num2` (double): Second number
- `operation` (string): Operation to perform (+, -, *, /)

Example:
```bash
curl -X POST "http://localhost:8081/api/calculator/calculate?num1=10&num2=5&operation=%2B"
```

Response:
```json
{
  "success": true,
  "num1": 10,
  "num2": 5,
  "operation": "+",
  "result": 15
}
```

### Advanced Operations
**POST** `/api/calculator/advanced`

Request parameters:
- `number` (double): Input number
- `operation` (string): Operation to perform (sqrt, square, reciprocal)

Example:
```bash
curl -X POST "http://localhost:8081/api/calculator/advanced?number=16&operation=sqrt"
```

Response:
```json
{
  "success": true,
  "number": 16,
  "operation": "sqrt",
  "result": 4.0
}
```

### Health Check
**GET** `/api/calculator/health`

Response:
```json
{
  "status": "OK",
  "message": "Calculator API is running"
}
```

## Usage

### Mouse/Touch Operations
1. Click number buttons to enter values
2. Select an operation operator (+, -, *, /)
3. Click the equals button (=) to calculate
4. Use the "C" button to clear the display
5. Use "DEL" to delete the last character

### Keyboard Support
- **Numbers:** 0-9
- **Operators:** +, -, *, /
- **Calculate:** Enter
- **Delete:** Backspace
- **Clear:** Escape
- **Decimal:** .

### Advanced Operations
- Click **√** for square root
- Click **x²** for square
- Click **1/x** for reciprocal

### Calculation History
- All calculations are automatically saved to history
- Click any history item to use it as the current value
- Click "Clear History" to remove all history
- History is persisted in browser's localStorage

## Running Tests

Execute the unit tests:
```bash
mvn test
```

The test suite covers:
- All basic arithmetic operations
- Advanced mathematical operations
- Error handling (division by zero, negative square root, etc.)
- Invalid operation validation

## Error Handling

The application handles common errors gracefully:
- **Division by Zero:** Returns an error message
- **Invalid Operations:** Returns specific error descriptions
- **Negative Square Root:** Returns appropriate error
- **Connection Errors:** Displays user-friendly error messages

## Features in Detail

### Calculation History
- Last 20 calculations are stored
- Click any history item to load its result
- Persistent across browser sessions
- Clear all history with one click

### Responsive Design
- Works seamlessly on desktop, tablet, and mobile
- Adaptive button sizes
- Touch-friendly interface
- Adjusts layout for smaller screens

### Performance
- Instant calculations
- Smooth animations
- No lag even with complex operations
- Efficient API calls

## Troubleshooting

**Problem:** Port 8081 is already in use
**Solution:** Change the port in `application.properties`:
```properties
server.port=8082
```

**Problem:** Build fails with Maven
**Solution:** Ensure Java 17 is installed and set as JAVA_HOME:
```bash
java -version
```

**Problem:** Frontend not responding to API calls
**Solution:** Check browser console for CORS errors. Verify the server is running.

## Development Notes

### Project Dependencies
- Spring Boot Starter Web: REST API framework
- Spring Boot Starter Thymeleaf: Template engine
- JUnit 5: Testing framework
- Spring Boot DevTools: Development utilities

### Build Information
- **Group ID:** com.calculator
- **Artifact ID:** calculator-app
- **Version:** 1.0.0

### Source Encoding
All files use UTF-8 encoding for international character support.

## Future Enhancements

Potential improvements:
- Support for trigonometric functions (sin, cos, tan)
- Scientific notation display
- Custom number formats
- Dark mode toggle
- User accounts and cloud history sync
- Calculation steps visualization
- Export history as CSV

## License

This project is provided as-is for educational and personal use.

## Contact & Support

For issues or suggestions, feel free to reach out or open an issue in the repository.

---

**Enjoy your calculator application!** 🧮
