mvn clean :

The phase executed is clean (also called "default-clean").
The target/ folder is deleted (or does not exist if this is the first command).


mvn test :

The phases executed are:
    - process-resources (copy resources)
    - compile (compile source code)
    - process-test-resources (copy test resources)
    - test-compile (compile test code)
    - test (run tests)

Several folders appear inside target/:

    classes/ : compiled .class files from source code
    test-classes/ : compiled .class files from test code
    surefire-reports/ : test reports (XML and TXT files)
    maven-status/ : files listing compiled and used files during build


mvn package :

The phases executed include all phases from mvn test plus:
    - package (creates the project archive, e.g., a .jar file)

In addition to files created by mvn test, the target/ folder also contains:
    - The project’s .jar (or other archive type) file
    - A maven-archiver/ folder containing a pom.properties file with project details (artifactId, groupId, version)


Hypothesis about mvn verify:
The verify phase runs everything done by package (compilation, tests, packaging).
