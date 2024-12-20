import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BookmanagerGui {
    private ArrayList<Book> books = new ArrayList<>();
    private JFrame frame;
    private JTextArea outputArea;

    public BookmanagerGui() {
        frame = new JFrame("Система учёта книг");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(new BorderLayout());

        // Панель для кнопок
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10));

        JButton addBookButton = new JButton("Добавить книгу");
        JButton viewBooksButton = new JButton("Просмотр книг");
        JButton deleteBookButton = new JButton("Удалить книгу");

        buttonPanel.add(addBookButton);
        buttonPanel.add(viewBooksButton);
        buttonPanel.add(deleteBookButton);

        // Область для вывода информации
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Добавление обработчиков событий
        addBookButton.addActionListener(e -> addBook());
        viewBooksButton.addActionListener(e -> viewBooks());
        deleteBookButton.addActionListener(e -> deleteBook());

        frame.setVisible(true);
    }

    private void addBook() {
        String title = JOptionPane.showInputDialog(frame, "Введите название книги:");
        if (title == null || title.trim().isEmpty()) return;

        String author = JOptionPane.showInputDialog(frame, "Введите автора книги:");
        if (author == null || author.trim().isEmpty()) return;

        String yearStr = JOptionPane.showInputDialog(frame, "Введите год издания:");
        if (yearStr == null || yearStr.trim().isEmpty()) return;

        try {
            int year = Integer.parseInt(yearStr);
            books.add(new Book(title, author, year));
            outputArea.append("Книга добавлена: " + title + "\n");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Некорректный год!", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void viewBooks() {
        if (books.isEmpty()) {
            outputArea.append("Список книг пуст.\n");
        } else {
            outputArea.append("Список книг:\n");
            for (Book book : books) {
                outputArea.append(book + "\n");
            }
        }
    }

    private void deleteBook() {
        String title = JOptionPane.showInputDialog(frame, "Введите название книги для удаления:");
        if (title == null || title.trim().isEmpty()) return;

        boolean found = false;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(title)) {
                books.remove(i);
                outputArea.append("Книга удалена: " + title + "\n");
                found = true;
                break;
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(frame, "Книга с таким названием не найдена!", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new BookmanagerGui();
    }
}

class Books {
    private String title;
    private String author;
    private int year;

    public Books(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Название: " + title + ", Автор: " + author + ", Год: " + year;
    }

}
