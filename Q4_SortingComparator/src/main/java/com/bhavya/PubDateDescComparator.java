package com.bhavya;

import java.util.Comparator;

class PubDateDescComparator implements Comparator<Book> {
    @Override
    public int compare(Book b1, Book b2) {
//        int yearCompare = Integer.compare(b2.getYear(), b1.getYear()); // Reverse order
        int yearCompare = b2.getYear() - b1.getYear();
        if (yearCompare == 0) {
            return b1.getTitle().compareTo(b2.getTitle()); // Sort by title if years are same
        }
        return yearCompare;
    }
}
