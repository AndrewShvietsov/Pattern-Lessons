package HomeworkLambda;

import java.io.Serializable;

public class Book implements Comparable<Book>, Serializable {
    private static final long serialVersionUID = 1L;
    final int id;
    String name;
    String author;
    String publisher;
    int publishYear;
    int pageCount;
    int price;
    static private int bookCounter;

    public Book(String name, String author, String publishing, int publishYear, int pageCount, int price) {
        this.id = bookCounter++;
        this.name = name;
        this.author = author;
        this.publisher = publishing;
        this.publishYear = publishYear;
        this.pageCount = pageCount;
        this.price = price;

    }

    @Override
    public String toString() {
        return "Book " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publishing='" + publisher + '\'' +
                ", publishYear=" + publishYear +
                ", pageCount=" + pageCount +
                ", price=" + price +
                '\n';
    }

    @Override
    public int compareTo(Book o) {
        return (name + author + publisher + publishYear).compareTo(o.name + o.author + o.publisher + o.publishYear);
    }
}
