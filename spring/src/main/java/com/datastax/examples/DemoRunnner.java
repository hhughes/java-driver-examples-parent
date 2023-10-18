package com.datastax.examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;
import java.util.logging.Logger;

@Component
public class DemoRunnner implements CommandLineRunner {

    private static Logger log = Logger.getLogger(DemoRunnner.class.getName());

    @Autowired
    private ApplicationContext context;

    @Autowired
    private InventoryOperations inventory;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("sprung");

        try {
            inventory.save(Widget.builder()
                    .id(UUID.randomUUID())
                    .type(new Random().nextBoolean() ? Widget.Type.A : Widget.Type.B)
                    .notes(String.format("created: %s", System.currentTimeMillis())).build());
            inventory.findAll().forEach(widget -> log.info(String.format("Found widget %s", widget)));
        } finally {
            SpringApplication.exit(context, () -> 0);
        }
    }
}
