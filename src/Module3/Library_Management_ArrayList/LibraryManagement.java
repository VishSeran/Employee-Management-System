
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class LibraryManagement {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> library = new ArrayList<>();

        // Add some sample books to the library (optional)
        library.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        library.add(new Book("To Kill a Mockingbird", "Harper Lee", 1960));
        library.add(new Book("1984", "George Orwell", 1949));

        boolean running = true;
        while (running) {
            // Display menu options
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add a book");
            System.out.println("2. View all books");
            System.out.println("3. Search for a book by title or author");
            System.out.println("4. Check out a book");
            System.out.println("5. Return a book");
            System.out.println("6. Sort books");
            System.out.println("7. View available books only");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            try {
                int userInput = Integer.parseInt(scanner.nextLine());

                switch (userInput) {
                    case 1:
                        System.out.println("Adding book");
                        addBook(scanner, library);
                        break;

                    case 2:
                        System.out.println("Books are loading...");
                        getBooks(library);
                        break;

                    case 3:
                        System.out.println("Loading...");
                        getBookByName(scanner, library);

                    case 4:
                        System.out.println("Checkout processing...");
                        checkOutBook(scanner, library);

                    case 5:
                        System.out.println("Retrning processing...");
                        returnBackBook(scanner, library);

                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid number input!...try again");
            }

        }

    }

    private static void addBook(Scanner scanner, ArrayList<Book> library) {
        System.out.println("Enter Book Name: ");
        String name = scanner.nextLine();

        System.out.println("\nEnter Author Name: ");
        String author = scanner.nextLine();

        int year = 0;
        boolean validYear = false;
        while (!validYear) {
            System.out.print("Enter publication year: ");
            try {
                year = Integer.parseInt(scanner.nextLine());
                validYear = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid year. Please enter a number.");
            }
        }

        Book newBook = new Book(name, author, year);
        library.add(newBook);

        System.out.println("\nNew book successfully added!");
    }

    private static void getBooks(ArrayList<Book> library) {

        if (library.isEmpty()) {
            System.out.println("Library is empty!");

        } else {
            for (int i = 0; i < library.size(); i++) {

                System.out.println((i + 1) + "." + library.get(i));
            }
        }
    }

    private static void getBookByName(Scanner scanner, ArrayList<Book> library) {
        System.out.println("Enter Book Name (title or author): ");
        String name = scanner.nextLine();

        boolean found = false;

        if (library.isEmpty()) {
            System.err.println("\nLibrary have no books yet");
        } else {
            for (int i = 0; i < library.size(); i++) {
                Book book = library.get(i);

                if (book.getTitle().toLowerCase().contains(name) || book.getAuthor().toLowerCase().contains(name)) {
                    found = true;
                    System.out.println((i + 1) + ". " + book);
                }

            }

            if (!found) {
                System.out.println("No books found matching \"" + name + "\"");
            }
        }

    }

    private static void checkOutBook(Scanner scanner, ArrayList<Book> library) {

        if (library.isEmpty()) {
            System.out.println("\nLibrary is empty");

        } else {
            for (int i = 0; i < library.size(); i++) {
                Book book = library.get(i);

                if (book.isAvailability()) {
                    System.out.println((i + 1) + ". " + book + " available");
                } else {
                    System.out.println((i + 1) + ". " + book + " unavailable");
                }
            }

            try {
                int checkOutNumber = Integer.parseInt(scanner.nextLine());

                if (checkOutNumber < 1 || checkOutNumber > library.size()) {
                    System.out.println("Number should in between 1 and " + library.size());
                } else {
                    Book selectedBook = library.get(checkOutNumber - 1);

                    if (selectedBook.checkOut()) {
                        System.out.println("Book checkout successfully: " + selectedBook);
                    } else {
                        System.out.println("Book is already checkedOut");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number input!");
            }

        }
    }

    private static void returnBackBook(Scanner scanner, ArrayList<Book> library) {
        System.out.println("Enter the book name");

        if (library.isEmpty()) {
            System.out.println("Library is empty now. thank you for ur support!");
            return;
        }

        //show checkpout books
        boolean hasChecked = false;
        for (int i = 0; i < library.size(); i++) {
            Book book = library.get(i);

            if (!book.isAvailability()) {
                System.out.println(i + 1 + ". " + book);
                hasChecked = true;
            }
        }

        if (!hasChecked) {
            System.out.println("No book are currently checkut!");
            return;
        }

        //return a book by selction
        System.out.println("Please enter the number of the book you want to return: ");
        int number = Integer.parseInt(scanner.nextLine());

        try {
            if (number < 1 || number > library.size()) {
                System.out.println("Invalid book number! please try again");
                return;
            }

            Book selectedBook = library.get(number - 1);

            if (selectedBook.returnBook()) {
                System.out.println(selectedBook + " Book return Suucessfull!");
            } else {
                System.out.println("Book return failed!");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input type!");
        }

    }

    private static void sortBook(Scanner scanner, ArrayList<Book> library) {

        System.out.println("Sorting processing...");

        if (library.isEmpty()) {
            System.out.println("Library is empty for now");
            return;
        }

        System.out.println("Select the sort order: ");
        System.out.println("1. Title");
        System.out.println("2. Author");
        System.out.println("3. Publication Year");
        System.out.print("Enter your choice: ");

        try {

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    Collections.sort(library, new Comparator<Book>(){
                        @Override
                        public int compare(Book b1, Book b2){
                            return b1.getTitle().compareToIgnoreCase(b2.getTitle());
                        }
                    });
                    System.out.println("Sorted by title: ");
                    break;

                case 2: 
                    Collections.sort(library, new Comparator<Book> () {
                        @Override
                        public int compare(Book b1, Book b2){
                            return b1.getAuthor().compareToIgnoreCase(b2.getAuthor());
                        }
                    });

                    System.out.println("Sorted by author: ");
                    break;

                case 3:
                    Collections.sort(library, new Comparator<Book>(){
                        @Override
                        public int compare(Book b1, Book b2){
                            return Integer.compare(b1.getPublicationYear(), b2.getPublicationYear());
                        }
                    });
                    System.out.println("Sorted by publication year: ");
                    break;

                default:
                    System.out.println("Invalid choice.");
                    return;
            }

            getBooks(library);


        } catch (NumberFormatException e) {
            System.out.println("Invalid type input!");
        }

    }

}
