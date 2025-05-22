# JAVA-JACOCO

This is a simple Java Maven project demonstrating how to use [JaCoCo](https://www.jacoco.org/jacoco/) for code coverage and [GitHub Actions](https://github.com/features/actions) for CI/CD automation.

## Project Structure

```
JAVA-JACOCO/
├── src/
│   ├── main/java/com/example/App.java
│   └── test/java/com/example/AppTest.java
├── pom.xml
└── .github/workflows/ci.yml
```

## Features
- Java 17
- JUnit 5 for testing
- JaCoCo for code coverage
- GitHub Actions for CI and coverage artifact upload

## Getting Started

### Build and Test Locally

```
mvn clean verify
```
- This will compile the code, run tests, and generate a JaCoCo coverage report in `target/site/jacoco/index.html`.

### GitHub Actions CI
- On every push to the `main` branch, GitHub Actions will:
  1. Check out the code
  2. Set up Java 17
  3. Build and test with Maven
  4. Generate a JaCoCo coverage report
  5. Upload the coverage report as an artifact

You can download the coverage report from the "Artifacts" section of the workflow run on GitHub.

## References
- [JaCoCo Maven Plugin Documentation](https://www.eclemma.org/jacoco/trunk/doc/maven.html)
- [GitHub Actions: Upload Artifact](https://github.com/actions/upload-artifact)
