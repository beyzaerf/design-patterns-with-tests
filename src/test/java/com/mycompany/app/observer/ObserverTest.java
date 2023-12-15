package com.mycompany.app.observer;

import com.mycompany.app.observer.listeners.EmailNotificationListener;
import com.mycompany.app.observer.listeners.LogOpenListener;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ObserverTest {
    @Mock
    private LogOpenListener logOpenListener;

    @Mock
    private EmailNotificationListener emailNotificationListener;

    private Editor editor;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        editor = new Editor();
    }

    @Test
    public void shouldTriggerLogOpenListenerWhenFileIsOpened() {
        editor.events.subscribe("open", logOpenListener);

        editor.openFile("test.txt");

        verify(logOpenListener);
    }

    @Test
    public void shouldTriggerEmailNotificationListenerWhenFileIsSaved() throws Exception {
        editor.events.subscribe("open", logOpenListener);
        editor.openFile("test.txt");

        editor.events.subscribe("save", emailNotificationListener);

        editor.saveFile();

        verify(emailNotificationListener);
    }

    @Test
    public void shouldThrowExceptionWhenFileNotOpenedFirst() {
        editor.events.subscribe("save", emailNotificationListener);
        assertThrows(Exception.class, () -> editor.saveFile());
    }

    @Test
    public void shouldHandleExceptionWhenFileNotFoundOnOpen() {
        assertDoesNotThrow(() -> editor.openFile("nonexistent.txt"));
    }

    @Test
    public void shouldNotTriggerListenerAfterUnsubscribe() {
        editor.events.subscribe("open", logOpenListener);
        editor.events.unsubscribe("open", logOpenListener);

        editor.openFile("test.txt");

        verify(logOpenListener, never());
    }
}
