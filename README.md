# School Stuff

> Just sum random repo I needed for school. Enjoy that random weird ass code ig?

## Maven setup (IntelliJ)

This repo now includes a `pom.xml`, so you can import it as a Maven project.

1. In IntelliJ, open the folder `School-Stuff`.
2. If prompted, click **Load Maven Project** (or right-click `pom.xml` -> **Add as Maven Project**).
3. Wait for dependency/project sync to finish.

### Run from terminal

```powershell
mvn clean compile
mvn exec:java
```

### Notes

- Maven is configured to compile the `tutelini` package first.
- The app entry point is `dev.kalarianathecila.schoolStuff.tutelini.Draw`.
