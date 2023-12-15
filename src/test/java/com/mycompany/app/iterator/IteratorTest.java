package com.mycompany.app.iterator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.mycompany.app.iterator.iterators.FacebookIterator;
import com.mycompany.app.iterator.socialnetworks.Facebook;
import com.mycompany.app.iterator.socialnetworks.LinkedIn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

public class IteratorTest {
    @Mock
    private Profile profile1;
    @Mock
    private Profile profile2;
    @Mock
    private Facebook facebook;
    @Mock
    private LinkedIn linkedIn;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

        when(profile1.getEmail()).thenReturn("user1@example.com");
        when(profile2.getEmail()).thenReturn("user2@example.com");
    }

    @Test
    public void testFacebookIterator() {
        FacebookIterator iterator = new FacebookIterator(facebook, "friends", profile1.getEmail());
    }

}
