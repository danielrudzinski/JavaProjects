public class Book {
    String title;
    String author;
    int year;
    boolean isAvaible;
    int condition ;

    public Book(String title, String author, int year, boolean isAvaible, int condition) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isAvaible = isAvaible;
        this.condition = condition;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isAvaible() {
        return isAvaible;
    }

    public void setAvaible(boolean avaible) {
        isAvaible = avaible;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", isAvaible=" + isAvaible +
                ", condition=" + condition +
                '}';
    }
}
