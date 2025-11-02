# ChatGPT-Based Test Generation — Report Section

**Team member:** Rami Blaik — rxb240025

---

## 3. Strengths of ChatGPT-based Test Generation

- **Readability & intent clarity:** Tests are written in natural, descriptive style using `@DisplayName`, making test purpose and behavior clear for both instructors and teammates.  
- **Targeted oracle design:** Assertions check exact expected results and exception messages (e.g., `"Stack is full"`, `"Stack is empty"`), not just exception types. This makes the tests act as executable specifications.  
- **Comprehensive boundary coverage:** ChatGPT easily identifies corner cases such as empty stack, single-slot capacity, overflow, underflow, and LIFO validation. This led to complete *branch coverage* for all conditionals.  
- **Rapid generation & adaptability:** Once the `Stack.java` code was provided, ChatGPT generated all tests and the Maven setup instantly. The tests can be quickly regenerated or adapted for new requirements.  
- **Readable documentation by example:** Each test clearly shows the intended use and expected output, effectively doubling as human-readable documentation for the `Stack` class.

---

## 4. Process and Prompts of ChatGPT

### Process Followed

1. Provided the exact `Stack.java` implementation (from assignment prompt) to ChatGPT.  
2. Requested JUnit 5 tests covering:
   - Normal flows (`push`, `pop`, `peek`, `size`)  
   - Exceptional cases (overflow/underflow)  
   - Helper methods (`isEmpty`, `isFull`)  
3. Asked that tests be placed under `test/chatgpt/ChatGPTTest.java` in a Maven-compatible folder structure.  
4. Requested ChatGPT to also generate a `pom.xml` configured with:
   - Custom `src/` and `test/` directories  
   - JUnit 5 and JaCoCo plugins  
5. Executed the tests locally using:
   ```bash
   mvn clean test
   ```
   and viewed the JaCoCo report in `target/site/jacoco/index.html`.  
6. Recorded actual coverage numbers from the HTML report for the final table.

### Example Prompt Used

> “Generate JUnit 5 tests for the following default-package `Stack` class. Cover push, pop, peek, overflow/underflow, size, `isEmpty`, `isFull`, and LIFO behavior. Ensure assertions check exact exception messages. Put tests in `test/chatgpt/ChatGPTTest.java` and provide a `pom.xml` configured with `sourceDirectory=src`, `testSourceDirectory=test`, JUnit 5, and JaCoCo. The tests must compile against a class in the default package.”

### Artifacts Produced

- `src/Stack.java` — provided class under test  
- `test/chatgpt/ChatGPTTest.java` — ChatGPT-generated JUnit 5 test file  
- `pom.xml` — project configuration with JUnit + JaCoCo  
- `README.md` — instructions for running and verifying coverage  

---

## 6. Tool Preference (if only one approach could be used)

For a **small, isolated class like `Stack`**, the best choice is **ChatGPT**:

- Produces full branch coverage and meaningful, readable assertions.  
- Extremely fast setup — no tool installation or tuning needed.  
- Easier to maintain and understand than EvoSuite or Randoop’s auto-generated tests.  

However, for **large or complex systems**, combining ChatGPT with EvoSuite or Randoop would yield the best results — EvoSuite for exhaustive search-based coverage, Randoop for random exploration, and ChatGPT for readable refactoring of those generated tests.

---

## 7. Improvement Ideas for LLM-Generated Tests

- **Better oracle generation:** Allow ChatGPT to infer invariants or mini reference models to verify more subtle correctness properties.  
- **Dependency handling:** Automatically mock or stub related classes when testing multi-class systems.  
- **Mutation testing awareness:** Integrate test generation that targets surviving mutants to ensure stronger fault detection.  
- **Parameterization and data variation:** Add automatic property-based or fuzz-style input generation for broader value ranges.  
- **Traceability features:** Embed requirement IDs or docstring references linking tests directly to their corresponding functional specs.

---

## 8. Coverage Table (final results after running JaCoCo)

| Tool      | Statement | Branch | Method |
|------------|------------|--------|--------|
| EvoSuite  | (team)     | (team) | (team) |
| Randoop   | (team)     | (team) | (team) |
| **ChatGPT** | **73%** | **100%** | **87.5%** |

**Interpretation:**  
- ChatGPT tests achieved *complete branch coverage* (every `if/else` explored).  
- Slightly lower statement coverage (73%) resulted from unexecuted trivial lines, such as constructor initialization paths.  
- Method coverage reached 87.5%, meaning 7 of 8 methods were directly invoked by tests.

Overall, these results confirm that ChatGPT-generated tests are highly effective and readable, providing strong coverage with minimal manual setup.

---
