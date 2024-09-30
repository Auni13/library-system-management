import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Period;

public class User {
    private String name;
    private int age;
    private ArrayList<String> borrowedBooks = new ArrayList<>();
    private Map<String, LocalDate> borrowedBooksDueDate = new HashMap<>();

    public User(String name, int age){
        this.name = name;
        this.age = age;
    }


    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void borrowBook(String bookTitle){
        borrowedBooks.add(bookTitle);
        borrowedBooksDueDate(bookTitle);
        System.out.println( bookTitle + " has been borrowed");
    }

    public void returnBook(String bookTitle){
        if(borrowedBooks.remove(bookTitle)){
            System.out.println(bookTitle + " sucessfully removed");
        }else{
            System.out.println(bookTitle + " failed to remove");
        }
    }

    public void printBorrowedBooks(){
        System.out.println("List of Borrowed Books");
        System.out.println(borrowedBooks);
        System.out.println();
    }

    public void borrowedBooksDueDate(String bookTitle){
        LocalDate currentDate = LocalDate.now();
        LocalDate dueDate = currentDate.plusDays(14);

        borrowedBooksDueDate.put(bookTitle, dueDate);
        System.out.println(bookTitle + " is due on " + dueDate);
    }

    public void checkDueDates(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-dd-yyyy");

        for (String book: borrowedBooks){
            LocalDate dueDate = borrowedBooksDueDate.get(book);

            System.out.println("Book: " + book +
                                "\nDue Date: " + dueDate.format(formatter));
        }
    }
    public void checkOverDueBook(){
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-dd-yyyy");
        boolean hasOverdueBooks = false;

        for (String book: borrowedBooks){
            LocalDate dueDate = borrowedBooksDueDate.get(book);

            if(currentDate.isAfter(dueDate)){
                long daysOverdue = Period.between(dueDate, currentDate).getDays();
                System.out.println("Book: " + book + " is overdue by " + daysOverdue + " days");
                hasOverdueBooks = true;
            }
        }

        if (!hasOverdueBooks) {
            System.out.println("No overdue books");
        }
    }

}