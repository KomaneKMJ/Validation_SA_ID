# Validation_SA_ID
# South African ID Number Validator

A Java application that validates South African ID numbers according to the official specifications, with an interactive user interface.

## Features

- Validates all components of a South African ID number:
  - Correct length (13 digits)
  - Valid date of birth (YYMMDD format)
  - Proper gender designation (0000-4999 for female, 5000-9999 for male)
  - Valid citizenship digit (0 for citizen, 1 for permanent resident)
  - Correct checksum digit (Luhn algorithm verification)
  
- Interactive command-line interface:
  - Continuous input until user exits
  - Detailed validation feedback
  - Breakdown of valid ID numbers (date of birth, gender, citizenship)

- Comprehensive unit tests covering all validation rules

## Requirements

- Java JDK 11 or higher
- Gradle 7.0 or higher (for building)

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/validation_sa_id.git
