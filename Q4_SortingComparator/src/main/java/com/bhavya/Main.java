package com.bhavya;
import java.util.Comparator;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Natural Ordering:");
//        Set<Book> naturalOrder = SetDemo.treeSetDemo(null);
        Set<com.bhavya.Book> naturalOrder = SetDemo.treeSetDemo(null);
//        for (Book book : naturalOrder) {
        for (com.bhavya.Book book : naturalOrder) {
            System.out.println(book);
        }

        System.out.println("\nAscending Order (By Year):");
        PubDateAscComparator mycom = new PubDateAscComparator();
        Set<com.bhavya.Book> ascOrder = SetDemo.treeSetDemo(new PubDateAscComparator());
        for (Book book : ascOrder) {
            System.out.println(book);
        }

        System.out.println("\nDescending Order (By Year):");
        Set<com.bhavya.Book> descOrder = SetDemo.treeSetDemo(new PubDateDescComparator());
        for (com.bhavya.Book book : descOrder) {
            System.out.println(book);
        }
    }
}
