import java.util.ArrayList;
import java.util.function.Predicate;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    public void addBook(Book book){
        books.add(book);
    }

    public void addUser(User user){
        users.add(user);
    }

    public ArrayList<User> getUsers(){
        return users;
    }

    public void searchByTitle(String title){
        for (Book book:books){
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())){      //to.lowerclass ni time nk fetch from user to data
                    System.out.println(book.getTitle() + " is found");
            }else{
                System.out.println(book.getTitle() + " is not found");
            }
        }
    }

    public void borrowBook(User user, String title){
        // for (Book book:books){
        //     if (book.getTitle().equalsIgnoreCase(title) && book.isAvailable()){    //equalsignorecase ni time nk cari yg aldy in data 
        //         book.isAvailable = false; 
        //         user.borrowBook(book.getTitle());
        //     }else {
        //         System.out.println("Sorry " + book.getTitle() + " is not available and cannot be found" );
        //     }
        // }

        Predicate<Book> isBookAvailable = book -> book.getTitle().equalsIgnoreCase(title) && book.isAvailable();

        for (Book book: books){
            if(isBookAvailable.test(book)){
                book.setAvailable(false);
                user.borrowBook(book.getTitle());
                System.out.println("Book: " + title + " borrowed successfully by " + user.getName());
                System.out.println();
                return;
            }
        }
        System.out.println("Book: " + title + " is not available or not found");
    }

    public void listAvailableBooks(){
        System.out.println("-----Available Books-----");
        for (Book book:books){
            book.printBookInfo();
        }
    }

    // public void getBorrowedBooksForAllUsers(){
        
    // }


}
