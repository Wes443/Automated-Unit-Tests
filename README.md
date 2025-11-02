# ChatGPT Portion — Assignment 4

This repo contains **only the ChatGPT-generated part** of the assignment:

- `src/Stack.java` — the SUT from the prompt
- `test/chatgpt/ChatGPTTest.java` — ChatGPT-authored JUnit 5 tests
- `pom.xml` — wired so Maven compiles sources from `./src` and tests from `./test`, and produces a JaCoCo coverage report

## How to run (Maven)
```bash
mvn -q test
# Coverage HTML will be at: target/site/jacoco/index.html
```

## Expected coverage (ChatGPT tests only)
With the provided tests, the Stack class should achieve:
- **Statement coverage:** 100%
- **Branch coverage:** 100% (both paths for push/pop/peek)
- **Method coverage:** 100%

> Verify using the JaCoCo report above; include the numbers in your report’s Coverage Table under the ChatGPT column.

## Where to place the other tools’ tests
This project follows the assignment’s folder scheme so you can drop in generated tests:
```
test/
├─ chatgpt/ChatGPTTest.java      
├─ randoop/RegressionTest0.java   
│  └─ ErrorTest0.java
└─ evosuite/EvoSuiteTest.java     
   └─ EvoSuiteRegressionTest.java
```
All `*Test.java` files anywhere under `test/` will be run by Maven Surefire.

## Notes
- No package declaration is used, matching the provided `Stack.java`. Keep tests package-less so they see the default-package class.
- JDK 17 is set in `pom.xml` (adjust `<release>` if needed).
   