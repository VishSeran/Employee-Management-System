package Module3.Library Management by ArrayList;

public class Book {

    private String bookTitle;
    private String author;
    private String genre;
    private int publicationYear;
    private boolean isAvailable;

    public Book(String bookTitle, String author, String genre, int publicationYear) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.isAvailable = true;
    }

    public String getTitle() {
        return this.bookTitle;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getGenre() {
        return this.genre;
    }

    public int getPublicationYear() {
        return this.publicationYear;
    }

    public boolean getAvailability() {
        return this.isAvailable;
    }

    public void setTitle(String title) {
        bookTitle = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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
        return "Name: " + this.bookTitle + "/nAuthor: " + this.author + "/nYear: " + this.publicationYear
                + "/nAvailability: " + (isAvailable ? "Available" : "Not available");
    }

}
