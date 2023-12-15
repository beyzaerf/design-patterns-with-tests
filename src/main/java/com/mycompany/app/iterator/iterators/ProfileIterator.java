package com.mycompany.app.iterator.iterators;

import com.mycompany.app.iterator.Profile;

public interface ProfileIterator {
    boolean hasNext();
    Profile getNext();
    void reset();
}
