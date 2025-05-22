# Updates and Configuration Details

## 1. Updated Existing `pom.xml` to Add JaCoCo Plugin

Add the following to your `pom.xml` plugins section:

```xml
<!-- Jacoco Plugin -->
<plugin>
  <groupId>org.jacoco</groupId>
  <artifactId>jacoco-maven-plugin</artifactId>
  <version>0.8.10</version>
  <executions>
    <execution>
      <goals>
        <goal>prepare-agent</goal>
      </goals>
    </execution>
    <execution>
      <id>report</id>
      <phase>test</phase>
      <goals>
        <goal>report</goal>
      </goals>
    </execution>
  </executions>
</plugin>
<!-- Jacoco Plugin -->
```

*(See lines 74-93 in your `pom.xml`)*

---

## 2. Created a Workflow File Inside `.github/workflows`

Create a file (e.g., `.github/workflows/ci.yml`) with the following content:

```yaml
name: Java CI with Maven and JaCoCo

on:
  push:
    branches: [main, test]

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
      - uses: actions/checkout@v3

      - name: Set up JDK 17
        uses: actions/setup-java@v3
        with:
          java-version: '17'
          distribution: 'temurin'

      - name: Build with Maven
        run: mvn clean verify

      - name: Upload JaCoCo coverage report
        uses: actions/upload-artifact@v4
        with:
          name: jacoco-report
          path: target/site/jacoco/
```

This workflow will generate JaCoCo reports, upload them to GitHub Actions artifacts, and allow you to download and unzip the report. Open `index.html` inside the artifact to view the JaCoCo coverage report.
