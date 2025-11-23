# $Stimulating Flight Academy $
![Project Status](https://img.shields.io/badge/status-Under%20Development-yellow)
![💻 Java](https://img.shields.io/badge/Java-100%25-blue)

Short description
- A software simulation of a flight training academy that models training scenarios, records trainee progress, and provides instructor tools and reports. The UI is built with JavaFX FXML and designed using Scene Builder.

Status
- Development: Under development — core simulation and UI work in progress.  

## Features
- Configurable training scenarios and flight modules  
- Instructor workflows: scheduling, session control, debriefing  
- Simulation controls (weather, failure modes, scenario parameters)  
- Training logs, performance metrics, and basic analytics  
- Exportable session reports (CSV/PDF)  
- UI designed with JavaFX FXML via Scene Builder

## Tech Stack
- Primary: 💻 Java — 100%  
- UI / Design: JavaFX (FXML) — Scene Builder used for visual UI editing  
- Recommended build tools: Maven or Gradle (optional)  
- Runtime: Java 23 and JavaFX SDK

## Roles
- Admin — manage users, roles, system settings, and global configuration  
- Instructor — plan and run training sessions, monitor trainees, perform debriefs  
- Trainee — participate in training scenarios, view personal progress, and feedback  
- Scheduler / Coordinator — create and manage session schedules, assign instructors and simulators  
- Simulator Technician — configure simulator parameters, load scenarios, and troubleshoot simulator software  
- Maintenance Engineer — perform system updates, backups, hardware maintenance, and security patches  
- Analyst — aggregate training data, run performance analyses, and produce reports (CSV/PDF)  
- Observer / Examiner — view-only access for auditors, examiners, external reviewers, or stakeholders

## Quick start
```bash
git clone https://github.com/mohona201/stimulatingFlightAcademy.git
cd stimulatingFlightAcademy

# If the project uses Maven:
# mvn clean install
# mvn exec:java -Dexec.mainClass="your.main.Class"

# If the project uses Gradle:
# ./gradlew build
# ./gradlew run

# Simple compile & run (replace your.package.Main with the actual main class):
javac -d out $(find src -name "*.java")
# If using JavaFX modules, add module path as needed:
# java --module-path /path/to/javafx/lib --add-modules javafx.controls,javafx.fxml -cp out your.package.Main
```

Notes
- Open .fxml files in Scene Builder to visually edit the UI.  
- If JavaFX is external to your JDK, download the JavaFX SDK and include it on the module/class path when running.

## Repository
- mohona201/stimulatingFlightAcademy — https://github.com/mohona201/stimulatingFlightAcademy

## Contact
- Maintainer / Repo owner: mohona201 — https://github.com/mohona201
