import java.util.ArrayList;
import java.util.List;

public class Library {
    List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }
    public void addBook(Book book){
        books.add(book);


    }
    public void deleteBook(Book book){
        books.remove(book);
    }
    public void showAvaible(){
       for(Book book : books){
           if(book.isAvaible==true){
               System.out.println(book);
           }
       }
    }
    public void showNotAvaible(){
        for(Book book : books){
            if(book.isAvaible==false){
                System.out.println(book);
            }
        }
    }
    public void returnBook(String title,int condition){
        for(Book book : books) {
            if (book.isAvaible == false && book.condition==condition) {
                if (book.getTitle() == title) {
                    book.isAvaible = true;
                    System.out.println("Okay u returned a book");
                }
                else System.out.println("This book have worse condition, u have to pay ");

            }
        }

    }
    public void rentBook(String title){
        for(Book book: books){
            if(book.getTitle()==title){
                if(book.isAvaible==true){
                    System.out.println("Sure u can rent this book");
                    book.isAvaible=false;
                }
                else System.out.println("Sorry this book is already rented");
            }
        }
    }
    public void searchBook(String titleorauthor){
        boolean found =false;
        for(Book book: books) {
        if(book.getTitle()==titleorauthor){
            System.out.printf("We have this book: \n");
            System.out.println(book);
            found=true;
            } else if (book.getAuthor()==titleorauthor) {
            System.out.printf("We have this book: \n");
            System.out.println(book);
            found=true;


        }
        }
        if(found==false){
            System.out.println("We dont have this book");
        }
        }

    }


