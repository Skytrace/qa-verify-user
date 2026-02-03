# QA-Verify-User: Automated Testing Framework

This project covers functional API testing and performance evaluation for user management services.

---

## 🏗 Framework Design & Scalability

### Project Structure Explanation
The framework follows a **Modular Layered Architecture** to ensure separation of concerns:
* **`src/main/java` (Core & Clients)**: Contains API clients, models (Lombok), and centralized configuration. This acts as an internal library for the tests.
* **`src/test/java` (Test Layer)**:
    * `com.userservice.steps`: Gherkin step definitions.
    * `com.userservice.runner`: TestNG configurations and Cucumber entry points.
* **`src/test/resources`**: Feature files, environment properties, and performance scripts (`.jmx`).

## 🔄 CI/CD & Infrastructure

### Jenkins Integration
The solution is designed for a **Pipeline-as-Code** (Jenkinsfile) approach:
* **Test Stage**: `mvn clean test -DsuiteXmlFile=testng.xml` running in a Jenkins.
* **Reporting**: Post-action to archive `allure-results` and generate the Allure Results plugin.



---

## 🧪 Testing Strategy

### 1. What is Tested
* **Functional API Tests**: Business logic validation, status codes, field-level assertion.
* **Performance**: `/POST /api/users`