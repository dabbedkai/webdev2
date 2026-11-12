package com.webdev2.runner;

import com.webdev2.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LifecycleRunner implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("=== STARTING ENTITY LIFECYCLE DEMO ===");

        // 1. Transient State: Object is created but not associated with Hibernate Persistence Context
        User user = new User("kaizer_dev", "initial@example.com");
        System.out.println("1. Transient: User object created in memory.");

        // 2. Managed State: Persisting the object brings it into the persistence context
        entityManager.persist(user);
        System.out.println("2. Managed: User persisted to database context.");

        // 3. Detached State: Detaching the entity removes it from the persistence context
        entityManager.detach(user);
        System.out.println("3. Detached: User detached from persistence context.");

        // 4. Modify email while detached (this change should NOT be saved to the database)
        user.setEmail("modified_while_detached@example.com");
        System.out.println("4. Modified email while detached: " + user.getEmail());

        // 5. Transaction commits here. Because the entity is detached, the email update is ignored.
        System.out.println("=== END OF LIFECYCLE DEMO ===");
    }
}