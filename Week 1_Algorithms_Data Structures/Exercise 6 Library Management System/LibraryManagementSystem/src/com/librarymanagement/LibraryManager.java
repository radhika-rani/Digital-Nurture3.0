package com.librarymanagement;

import java.util.Arrays;

public class LibraryManager {
    private Book[] books;

    public LibraryManager(Book[] books) {
        this.books = books;
        // Sort books by title for binary search
        Arrays.sort(this.books, (b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));
    }

    // Linear Search
    public Book linearSearch(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Binary Search
    public Book binarySearch(String title) {
        int low = 0;
        int high = books.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = books[mid].getTitle().compareToIgnoreCase(title);

            if (cmp == 0) {
                return books[mid];
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}
