import java.util.Arrays;

public class LibraryManagementSystem {

    static class Book {
        private int bookId;
        private String title;
        private String author;

        public Book(int bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        public int getBookId() {
            return bookId;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        @Override
        public String toString() {
            return "Book [ID=" + bookId + ", Title=" + title + ", Author=" + author + "]";
        }
    }

    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String title) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return books[mid];
            }
            if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "Java Programming", "John Doe"),
            new Book(2, "Data Structures", "Jane Smith"),
            new Book(3, "Algorithms", "Alan Turing"),
            new Book(4, "Database Systems", "Grace Hopper")
        };

        Book result1 = linearSearch(books, "Algorithms");
        System.out.println("Linear Search Result: " + (result1 != null ? result1 : "Book not found"));

        Arrays.sort(books, (b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));
        Book result2 = binarySearch(books, "Algorithms");
        System.out.println("Binary Search Result: " + (result2 != null ? result2 : "Book not found"));
    }
}
