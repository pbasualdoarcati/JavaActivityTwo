```markdown
# Java Library - Readme

In this project, a series of validations have been implemented to ensure the integrity and proper functioning of various features. Below, the logic used in each function is described:

## Features and Validations

### 1. registerPerson()
- **Validation Logic:**
  - Ensures that the information for the new user is not empty.
  - Validates the provision of essential data such as name, identification, etc.

### 2. addBook()
- **Validation Logic:**
  - Validates that the information for the book to be added is complete.
  - Ensures that no null or empty data is entered.

### 3. searchBook()
- **Validation Logic:**
  - Checks that the title of the book to search is not null or empty.
  - Ensures the existence of the book before displaying its information.

### 4. deleteBook()
- **Validation Logic:**
  - Validates that the title of the book to be deleted is not null or empty.
  - Confirms the existence of the book before proceeding with deletion.

### 5. rentABook()
- **Validation Logic:**
  - Verifies that both the title of the book and the user's name are not null or empty.
  - Ensures the existence of both the user and the book before processing the loan.

### 6. returnABook()
- **Validation Logic:**
  - Validates that both the title of the book and the user's name are not null or empty.
  - Ensures the existence of both the user and the book before processing the return.

### 7. showMenu()
- **Validation Logic:**
  - Ensures the selection of a valid menu option.
  - Handles program exit if an invalid option is selected.

These validations are implemented to enhance the robustness and usability of the program, ensuring that the provided data is consistent and that operations are carried out securely and efficiently.
```
