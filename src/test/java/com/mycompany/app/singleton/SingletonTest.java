package com.mycompany.app.singleton;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SingletonTest {
    //checks if singleton has one instance by creating trying to create two instances
    @Test
    public void checksInstance() {
        Singleton singleton = Singleton.getInstance("FOO");
        Singleton anotherInstance = Singleton.getInstance("BAR");
        assertEquals(singleton, anotherInstance);
    }
}
