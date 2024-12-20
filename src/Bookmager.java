import java.util.ArrayList;
import java.util.Scanner;
public class Bookmager {
    ArrayList<Book> books = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    public void addbook() {
        sc.nextLine();
        System.out.println("Введите название книги: ");
        String title = sc.nextLine();
        sc.nextLine();
        System.out.println("Введите автора книги: ");
        String author = sc.nextLine();
        System.out.println("Введите год издания: ");
        int year = sc.nextInt();
        books.add(new Book(title, author, year));
        System.out.println("Книга добавлена!");
    }

    public void knigiest(){
        if (books.isEmpty()){
            System.out.println("список книг пуст");
        }
        else{
            for(Book book : books) {
                System.out.println(book);
            }
            }

    }

    public void deletebook(){
        System.out.println("введите название книги");
        sc.nextLine();
        String title = sc.nextLine();
        boolean found = false;
        for (int i = 0; i <books.size() ; i++) {
            if(books.get(i).getTitle().equals(title)) {
                books.remove(i);
                found = true;
                System.out.println("книга удалена ");
                break;

            }
            else{
                System.out.println("такой книги нету");
            }
        }
    }


    public void menu(){
        while(true ) {
            System.out.println("Меню");
            System.out.println("1 добавьте книгу ");
            System.out.println("2 Просмотр добавленных книг");
            System.out.println("3 удаление книги");
            System.out.println("4 завершение программы");
            int choise = sc.nextInt();

            switch (choise){
                case 1:
                    addbook();
                    break;
                case 2:
                    knigiest();
                    break;
                case 3:
                    deletebook();
                    break;
                case 4:
                    System.out.println("выход из программы ");
                    return;
                default:
                    System.out.println("вы ввели неверную команду");
            }
        }
    }

}
