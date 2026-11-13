# Lab 8 - Persistence Debugging Report

## 1. Stack Trace Analysis
The stack trace revealed a `DataIntegrityViolationException` and a `PropertyValueException`. This was triggered because the application attempted to persist a `Pet` entity with a `null` value in the `microchipNumber` field, which directly violated the `@Column(nullable = false)` constraint. Additionally, an identifier generation issue occurred because the primary key (`id`) lacked the `@GeneratedValue` annotation, leaving Hibernate unable to auto-assign primary key values.

## 2. SQL Log Confirmation
With SQL logging enabled (`spring.jpa.show-sql=true` and DEBUG level logging), the output showed that Hibernate attempted to execute an `INSERT` statement with a `NULL` value for the microchip column. The database rejected the operation instantly due to the column constraint violation, aborting the transaction before any valid records were committed.

## 3. Exact Fixes Applied
To resolve these defects and make the code fully functional:
- Added the `@GeneratedValue(strategy = GenerationType.IDENTITY)` annotation to the primary key (`id`) in the `Pet` model.
- Restored the missing `species` field to the `Pet` entity class with proper column mapping.
- Updated the service test call to assign a valid, unique string value to `microchipNumber` instead of `null` prior to invoking `petRepository.save(p)`.