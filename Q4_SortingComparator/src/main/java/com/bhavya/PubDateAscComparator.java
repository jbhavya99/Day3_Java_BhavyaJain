package com.bhavya;

import java.util.Comparator;

class PubDateAscComparator implements Comparator<Book> {
    @Override
    //comparing two objects
    public int compare(Book b1, Book b2) {
//        int yearCompare = Integer.compare(b1.getYear(), b2.getYear());
        int yearCompare = b1.getYear() - b2.getYear();
        if (yearCompare == 0) {
            return b1.getTitle().compareTo(b2.getTitle()); // Sort by title if years are same
        }
        return yearCompare;//if
    }
}

