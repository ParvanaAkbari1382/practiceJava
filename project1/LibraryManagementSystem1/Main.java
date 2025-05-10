import java.util.ArrayList;
import java.util.List;
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

class LibrarySystem{
    private List<LibraryItems> items= new ArrayList<>();
    
    void addItem(LibraryItems item){
        items.add(item);
    }

    void removeItem(LibraryItems item){
        items.remove(item);
    }
    void showItems(){
        for (LibraryItems item : items){
            item.displayInfo();
            System.out.println("the item is available: " + item.isAvailable());
            System.out.println("-");
        }
    }
    void borrowItem(int id){
        for(LibraryItems item : items){
            if (item.id == id && item.isAvailable()){
                item.borrowItem();
                System.out.println("items is borrowed : "+ item.title);
            }
        }
        System.out.println(" item is not avaialable ");
    }

    public void returnItem(int id ){
        for (LibraryItems item: items){
            if (item.id == id && !item.isAvailable()){
                item.returnItem();
                System.out.println("item is returned : " + item.title);
            }
        }
        System.out.println("item is not borrowed ! ");
    }
}
public class Main {
    public static void main(String[] args) {
        Book book1 = new Book (1, "48 laws of power" , "Robert Greene");
        book1.displayInfo();
        System.out.println("the book is available: " + book1.isAvailable);

        LibrarySystem library= new LibrarySystem();
        library.addItem(book1);
        library.showItems();
        library.borrowItem(1);
        library.showItems();
    }
}
