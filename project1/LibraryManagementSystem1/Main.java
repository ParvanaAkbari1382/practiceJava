
abstract class LibraryItems{
    protected String title ;
    protected int id;
    protected boolean isAvailable= true;
   
    public LibraryItems ( int id, String title){
        this.id = id;
        this.title = title;
        
    }
    public boolean isAvailable(){
        return isAvailable;
    }
    public void borrowItem(){
        isAvailable= false;
    }
    public void returnItem(){
        isAvailable = true;

    }
    public abstract void displayInfo();

}
class Book extends LibraryItems{

    private String author;

    public Book (int id , String title, String author){
        super(id, title);
        this.author= author;
    }
    public void displayInfo(){
        System.out.println("book id: "+ id);
        System.out.println("book title: "+ title );
        System.out.println("book author :  " + author);

    }
}


public class Main {
    public static void main(String[] args) {
        Book book1 = new Book (1, "48 laws of power" , "Robert Greene");
        book1.displayInfo();
        System.out.println("the book is available: " + book1.isAvailable);
    }
}
