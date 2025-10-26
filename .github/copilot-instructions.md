<!-- Copilot instructions for AI coding agents: concise, repo-specific guidance -->
# Project quick summary

This repository is a small Java Selenium UI automation starter. The top-level
README.md states: "A base framework for Web UI testing automation using
Selenium, Java, Maven, TestNG." Use that as the primary source of truth.

# What this agent should know (big picture)
- Purpose: provide and maintain Web UI tests implemented in Java using
  Selenium WebDriver. The project uses Maven and TestNG conventions when
  present.
- Typical layout to expect: Maven-style sources under `src/main/java` and
  tests under `src/test/java`. Also look for `pom.xml` at the repo root.
- TestNG XML configuration files are located under `src/test/resources`.

# Concrete developer workflows (discoverable)
- Build & run tests (Maven present):

  - Windows / PowerShell:
    mvn -B test

  - Run a single TestNG test class or method (Maven Surefire):
    mvn -Dtest=MyTest#testMethod test

- If `pom.xml` is missing the README still indicates Maven/TestNG. Before
  changing build config, search for `pom.xml`, `gradle`, or custom scripts.

# Project-specific conventions & patterns
- Tests should follow TestNG conventions (look for `@Test` annotations).
- TestNG suite files (e.g., `testng.xml`) are located in `src/test/resources`.
- Search the codebase for the strings `WebDriver`, `RemoteWebDriver`,
  `DesiredCapabilities` or `selenium` to find integration points and
  browser setup code to reuse.
- Naming: expect test classes to use `*Test` suffix (common with Surefire).
- Page Object Model (POM) pattern is implemented:
  - Pages are located under `src/main/java/com/company/qa/pages`.
  - All pages inherit from `BasePage`.
  - Tests interact with pages (e.g., `LoginPage`, `InventoryPage`) to perform actions.

# Integration points & external dependencies
- Selenium WebDriver is the primary external dependency — check `pom.xml`
  for the Selenium artifact version.
- CI/workflows: check `.github/workflows/` for build steps (if present).

# How to make changes safely (agent guidance)
- Prefer small, self-contained commits. When adding tests, place them under
  `src/test/java` and update `pom.xml` only when necessary.
- Run `mvn -B test` locally (or on CI) to validate changes. If Maven is not
  present, add a short note in your PR describing how you validated the
  change.
- When adding new tests:
  - If it's a new test class, inherit from `BaseTest`.
  - If the test requires a new page, create the required Page Object under `src/main/java/com/company/qa/pages` if it does not already exist.
- Always use best practices for Selenium, Java, Maven, and TestNG.

# Quick search patterns (examples)
- Find tests: `git grep -n "@Test"` or `git grep -n "class .*Test"`
- Find WebDriver usage: `git grep -n "WebDriver\|RemoteWebDriver\|selenium"`
- Locate build: `ls -la | grep pom.xml` (or search for `pom.xml` in the tree)

# Files to check first
- `README.md` — project description and expectations
- `pom.xml` — build configuration (may be missing in minimal scaffold)
- `src/test/java` — add or update TestNG-based tests
- `src/test/resources/testng.xml` — TestNG suite configuration
- `.github/workflows/` — CI configuration if present

# What not to assume
- Do not assume credentials, remote URLs, or a running Selenium Grid are
  present in the repo. If tests rely on external services, look for config
  files or environment variable usage before hardcoding values.

# If you update this file
- Merge any existing `.github/copilot-instructions.md` content (preserve
  original guidance). If unsure about a conflict, leave a TODO and ask a
  human reviewer.

---
References: see `README.md` in the repository root for the canonical
project description.
