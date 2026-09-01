# School Stuff

> Just sum random repo I needed for school. Enjoy that random weird ass code ig?

## Maven setup (IntelliJ)

This repo uses a standard Maven layout now:

- `src/main/java` for Java sources
- `src/main/resources` for resources (like the turtle icon)
- `src/test/java` reserved for tests

### Import in IntelliJ

1. Open the folder `School-Stuff`.
2. If prompted, click **Load Maven Project** (or right-click `pom.xml` -> **Add as Maven Project**).
3. Wait for Maven sync to finish.

### Build and run

```powershell
mvn clean compile
mvn exec:java
```

### Entry point

- Main class: `dev.kalarianathecila.schoolStuff.tutelini.Draw`
