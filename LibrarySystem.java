import java.time.LocalDate;
import java.util.*;
public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        library.addBook(new Book("Harry Potter", "J.K. Rowling", "12345", true));
        library.addBook(new Book("Lord of the Rings", "J.R.R. Tolkien", "67890", true));

        System.out.println("---------------Library Management System---------------");

        for (int i = 0; i<2; i++){

            System.out.print("Enter Your Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Your Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            User user = new User(name, age);
            library.addUser(user);

            library.listAvailableBooks();

            System.out.print("Enter the title of the book you want to borrow: ");
            String title = sc.nextLine();
            System.out.println();
            library.borrowBook(user, title);

            System.out.println("--  Borrowing a Book ---");
            user.printBorrowedBooks();

            System.out.println("--- Overdue Books ---");
            user.checkOverDueBook();
            System.out.println();

        // for (User user:library.getUsers()){
        //     user.checkDueDates();
        //     user.checkOverDueBook(/**LocalDate.now().plusDays(15)**/);
        // }

        }

        sc.close();
    }
}
