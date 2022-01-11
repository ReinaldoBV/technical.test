package com.azurian.technical.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * The Class InitData.
 */
@Component
public class InitData {

    /** The repo. */
    @Autowired
    private PersonRepository repo;

    /**
     * App ready.
     *
     * @param event the event
     */
    @EventListener
    public void appReady(ApplicationReadyEvent event) {

        repo.save(new Person(1l, "nombre1", "apellido1"));
        repo.save(new Person(2l, "nombre2", "apellido2"));
        repo.save(new Person(3l, "nombre3", "apellido3"));
        repo.save(new Person(4l, "nombre4", "apellido4"));
        repo.save(new Person(5l, "nombre5", "apellido5"));
        repo.save(new Person(6l, "nombre6", "apellido6"));
        repo.save(new Person(7l, "nombre7", "apellido7"));
        repo.save(new Person(8l, "nombre8", "apellido8"));
        repo.save(new Person(9l, "nombre9", "apellido9"));
        repo.save(new Person(10l, "nombre10", "apellido10"));
        repo.save(new Person(11l, "nombre11", "apellido11"));
        repo.save(new Person(12l, "nombre12", "apellido12"));
        repo.save(new Person(13l, "nombre13", "apellido13"));
        repo.save(new Person(14l, "nombre14", "apellido14"));
        repo.save(new Person(15l, "nombre15", "apellido15"));
        repo.save(new Person(16l, "nombre16", "apellido16"));
        repo.save(new Person(17l, "nombre17", "apellido17"));
        repo.save(new Person(18l, "nombre18", "apellido18"));
        repo.save(new Person(19l, "nombre19", "apellido19"));
        repo.save(new Person(20l, "nombre20", "apellido20"));
        repo.save(new Person(21l, "nombre21", "apellido21"));
        repo.save(new Person(22l, "nombre22", "apellido22"));
        repo.save(new Person(23l, "nombre23", "apellido23"));
        repo.save(new Person(24l, "nombre24", "apellido24"));
        repo.save(new Person(25l, "nombre25", "apellido25"));
    }
}
