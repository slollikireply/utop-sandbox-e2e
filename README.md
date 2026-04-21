# utop-sandbox-e2e

End-to-end fixture for the [UTOP Agent](https://github.com/kireply/KiDE-Utop).

## Purpose

A small Java/Maven project with intentionally **weak** unit tests so PITest
reports many `SURVIVED` mutations. UTOP picks those up and proposes
strengthened tests via the LLM.

## Layout

| File | Role |
|---|---|
| `pom.xml` | Maven + JUnit 5 + PITest 1.17 |
| `src/main/java/com/example/PriceCalculator.java` | Discount, tax, totals (numeric ops → MATH mutations) |
| `src/main/java/com/example/UserValidator.java` | Age & username boundary checks (CONDITIONALS_BOUNDARY mutations) |
| `src/test/java/com/example/PriceCalculatorTest.java` | Mostly weak: `assertNotEquals(0,…)`, no-assert, `Double.isFinite` |
| `src/test/java/com/example/UserValidatorTest.java` | Mostly weak: single happy-path values that miss boundaries |

## Why weak tests?

UTOP's mutation analyzer filters for `status == "SURVIVED"`. Tests that
never execute a method produce `NO_COVERAGE` and are silently dropped.
For UTOP to do real work, the methods must be **called** (so mutations
are covered) **with assertions too permissive to detect them** (so
mutations survive).

## Running PITest locally

```bash
mvn test
mvn org.pitest:pitest-maven:mutationCoverage
# → target/pit-reports/index.html
```

A healthy run reports a mix of `KILLED` (the strong assertions) and
`SURVIVED` (the weak ones). UTOP only acts on `SURVIVED`.

<!-- E2E run trigger 20260421-095725 -->
