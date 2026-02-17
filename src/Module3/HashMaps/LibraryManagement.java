
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

public class LibraryManagement {

    private static class Book {

        private String bookTitle;
        private String author;
        private int publicationYear;
        private boolean isAvailable;

        public Book(String bookTitle, String author, int publicationYear) {
            this.bookTitle = bookTitle;
            this.author = author;
            this.publicationYear = publicationYear;
            this.isAvailable = true;
        }

        public String getTitle() {
            return this.bookTitle;
        }

        public String getAuthor() {
            return this.author;
        }

        public int getPublicationYear() {
            return this.publicationYear;
        }

        public boolean isAvailability() {
            return this.isAvailable;
        }

        public void setTitle(String title) {
            bookTitle = title;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setYear(int year) {
            publicationYear = year;
        }

        public void setAvailablity(boolean availability) {
            this.isAvailable = availability;
        }

        public boolean checkOut() {
            if (isAvailable) {
                isAvailable = false;
                return true;
            }

            return false;

        }

        public boolean returnBook() {

            if (!isAvailable) {
                isAvailable = true;
                return true;
            }
            return false;
        }

        @Override
        public String toString() {
            return "Name: " + this.bookTitle + "\nAuthor: " + this.author + "\nYear: " + this.publicationYear
                    + "\nAvailability: " + (isAvailable ? "Available" : "Not available");
        }

    }

    private static boolean isValidText(String text) {
        return text != null && !text.trim().isEmpty();
    }

    private static boolean isValidYear(int year) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return year > 1000 && year <= currentYear;
    }

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);

            HashMap<String, Book> library = new HashMap<>();
            boolean runnung = true;
            int choice;
            while (runnung) {
                System.out.println("\n===== Library Management System =====");
                System.out.println("1. Add a book");
                System.out.println("2. View all books");
                System.out.println("3. Search for a book");
                System.out.println("4. Remove a book");
                System.out.println("5. View sorted books");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");

                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("Enter ISBM");
                        String isbn = scanner.nextLine();

                        if (library.containsKey(isbn)) {
                            System.out.println("isbm key already exists in library!");
                            System.out.println("want you to replace? (y/n)");
                            String replace = scanner.nextLine();

                            if (replace.equalsIgnoreCase("y")) {
                                continue;
                            }
                        }

                        System.out.println("Enter title: ");
                        String title = scanner.nextLine();

                        if (!isValidText(title)) {
                            System.out.println("Please enter a valid title");
                            continue;
                        }

                        System.out.println("Enter author name: ");
                        String author = scanner.nextLine();

                        if (!isValidText(author)) {
                            System.out.println("Please enter a valid name");
                            continue;
                        }

                        System.out.println("Enter publication year: ");
                        int year;

                        try {
                            year = Integer.parseInt(scanner.nextLine());
                            if (!isValidYear(year)) {
                                System.out.println("Please enter a valid year");
                                continue;
                            }

                        } catch (NumberFormatException e) {
                            e.getMessage();
                            continue;
                        }

                        Book newBook = new Book(title, author, year);
                        library.put(isbn,newBook);
                         System.out.println("Book added successfully!");



                    default:
                        throw new AssertionError();
                }

            }
        } catch (NumberFormatException e) {
            System.err.println("Number format error: " + e.getMessage());
        }

    }
}
