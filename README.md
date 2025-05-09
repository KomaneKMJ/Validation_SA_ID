📝 South African ID Number Validator
Java
Gradle

A Java application that validates South African ID numbers according to the official specifications, with an interactive user interface.

✨ Features
✅ Comprehensive Validation:

Correct length (13 digits)

Valid date of birth (YYMMDD format)

Proper gender designation (0000-4999 for female, 5000-9999 for male)

Valid citizenship digit (0 for citizen, 1 for permanent resident)

Correct checksum digit (Luhn algorithm verification)

💻 Interactive CLI:

Continuous input until user exits

Detailed validation feedback

Breakdown of valid ID numbers (date of birth, gender, citizenship)

🧪 Test Coverage:

Comprehensive unit tests covering all validation rules

⚙️ Requirements
☕ Java JDK 11 or higher

🛠️ Gradle 7.0 or higher (for building)

🚀 Installation & Usage

1. Clone the repository:
git clone https://github.com/komaneKMJ/validation_sa_id.git
cd validation_sa_id

2.Build the project:
./gradlew build

3. Run the application:
 ./gradlew run

🏗️ Project Structure

📦 validation_sa_id
├── 📂 src
│   ├── 📂 main/java        # Main application code
│   └── 📂 test/java        # Unit tests
├── 📜 build.gradle         # Gradle build configuration
├── 📜 settings.gradle      # Project settings
└── 📜 README.md            # This file
