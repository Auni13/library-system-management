public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    //constructor
    public Book(String title, String author, String isbn, boolean isAvailable){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    public String getTitle(){
        return title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getIsbn(){
        return isbn;
    }

    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public boolean getAvailable(){
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable){
        this.isAvailable = isAvailable;
    }


    public boolean isAvailable(){
        if (isAvailable){
            isAvailable = true;
        }else{
            isAvailable = false;
        }

        return isAvailable;
    }

    public void printBookInfo(){
        System.out.println("Title: " + title +
                            ", Author: " + author +
                            ", ISBN: " + isbn + 
                            ", Available: " + isAvailable());
        System.out.println();
    }
}


