# SkillPilots: Thymeleaf Form Validation Error Feedback

## Run
Requirements: Java 17 and Maven. Extract the ZIP, open this folder in VS Code, then run:
`mvn spring-boot:run`
Open http://localhost:8080/books

## Task steps covered
1. `Book.java` uses `@NotBlank` and `@Size` on title and author.
2. Controller methods use `@Valid` and `BindingResult`.
3. If `bindingResult.hasErrors()` is true, controller returns the form view.
4. Thymeleaf `#fields.hasErrors(...)` and `th:errors` show messages next to each input.
5. Test by submitting blank values or one-character values, then submit valid values.

## Files
- `Book.java`: model validation annotations
- `BookController.java`: form handling and BindingResult
- `book-form.html`: inline validation error messages
- `books.html`: list, edit and delete actions

The project uses an in-memory H2 database; records reset when the app stops.
