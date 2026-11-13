# WEBDEV2 - Week 9 Lab Answers

Name: Kaizer David R. Palabay
Student ID: 2510997
GitHub repo: https://github.com/kaizer/webdev2
Date submitted: November 13, 2026

---

## Task 1 - One-to-One + One-to-Many Mappings

**Approach / explanation:**
For the one-to-one mapping, `User` is designated as the owning side using `@JoinColumn(name = "profile_id")`, while `UserProfile` maps the inverse side with `mappedBy = "profile"`. For the one-to-many relationship, `Department` holds a collection of `Employee` entities mapped by `department` with cascade and orphan removal enabled, while helper methods ensure both sides of the relationship remain synchronized in memory.

**Code / endpoint(s) used (if applicable):**
```java
@OneToMany(mappedBy = "department", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true, fetch = FetchType.LAZY)
private List<Employee> employees = new ArrayList<>();