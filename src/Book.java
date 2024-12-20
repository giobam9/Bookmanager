public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title,String author,int year){
        this.title = title;
        this.author = author;
        this.year = year;

    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    public String toString(){
        return "Название: " + title + "\nАвтор: " + author + "\nГод:" +year;
    }
}
