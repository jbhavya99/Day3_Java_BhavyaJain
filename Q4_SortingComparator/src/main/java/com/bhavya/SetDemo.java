package com.bhavya;

import java.util.*;

class SetDemo {
    public static Set<Book> treeSetDemo(Comparator<Book> comparator) {
        Set<Book> set;
        if (comparator == null) {
            set = new TreeSet<>(); // Natural ordering (by title)
        } else {
            set = new TreeSet<>(comparator);
        }

        set.add(new Book("Effective Java", "Joshua Bloch", 2008));
        set.add(new Book("Harry Potter", "J.K.Rowling", 1997));
        set.add(new Book("Walden", "Henry David Thoreau", 1854));
        set.add(new Book("The Last Lecture", "Randy Pausch", 2008));

        return set;
    }
}

