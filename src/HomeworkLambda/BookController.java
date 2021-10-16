package HomeworkLambda;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class BookController {
    static Set<Book> bookSet = new TreeSet<>();

    static public boolean isAddBook(Book book) {
        return bookSet.add(book);
    }

    public List<Book> filterBook(Collection<Book> collectionBook, Predicate<Book> condition) {
        return collectionBook.stream().filter(condition).collect(Collectors.toList());
    }

    public List<Book> sortBook(Collection<Book> bookCollection, Comparator<Book> comparatorBook) {
        return bookCollection.stream().sorted(comparatorBook).collect(Collectors.toList());
    }

    public List<Book> requestA(String authorName) {
        List<Book> tempList = filterBook(bookSet, x -> x.author.compareToIgnoreCase(authorName) == 0);
        return sortBook(tempList, (x, y) -> x.publishYear - y.publishYear);
    }

    public List<Book> requestB(String publisherName) {
        return filterBook(bookSet, x -> x.publisher.equalsIgnoreCase(publisherName));
    }

    public List<Book> requestC(int startPublishYear) {
        return filterBook(bookSet, x -> x.publishYear > startPublishYear);
    }

    public List<String> requestD() {
        return bookSet.stream().map(x -> x.author).distinct().sorted().collect(Collectors.toList());
    }

    public List<String> requestE() {
        return bookSet.stream().map(x -> x.publisher).distinct().collect(Collectors.toList());
    }

    public List<Book> requestF(String publisherName) {
        return filterBook(bookSet, x -> x.publisher.equalsIgnoreCase(publisherName));
    }

    public void viewRequestA(Scanner scanner) {
        System.out.println("Enter author name");
        String string = scanner.next();
        System.out.println(requestA(string));
    }

    public void viewRequestB(Scanner scanner) {
        System.out.println("Enter publisher name");
        String string = scanner.next();
        System.out.println(requestB(string));
    }

    public void viewRequestC(Scanner scanner) {
        System.out.println("Enter publish year");
        int integer = Integer.parseInt(scanner.next());
        System.out.println(requestC(integer));
    }

    public void viewRequestD() {
        System.out.println("Author list");
        System.out.println(requestD());
    }

    public void viewRequestE() {
        System.out.println("Book list");
        System.out.println(requestE());
    }

    public void viewRequestF(Scanner scanner) {
        System.out.println("Enter publisher name");
        String string = scanner.next();
        System.out.println(requestF(string));
    }

    static {
//        isAddBook(new Book("1", "1", "11", 1, 5, 10));
//        isAddBook(new Book("2", "2", "22", 2, 6, 11));
//        isAddBook(new Book("3", "3", "33", 3, 7, 12));
//        isAddBook(new Book("4", "4", "44", 4, 8, 13));
//        isAddBook(new Book("4", "4", "44", 4, 8, 13));
//        isAddBook(new Book("4", "4", "44", 4, 8, 13));
//        isAddBook(new Book("5", "5", "55", 5, 9, 14));
//        isAddBook(new Book("6", "6", "66", 6, 99, 15));
//        isAddBook(new Book("7", "7", "77", 7, 111, 16));

//        FileOutputStream fileOutputStream = null;
//        try {
//            fileOutputStream = new FileOutputStream("D:\\file.txt");
//            ObjectOutputStream objectOutputStream
//                    = new ObjectOutputStream(fileOutputStream);
//            objectOutputStream.writeObject(bookSet);
//            objectOutputStream.flush();
//            objectOutputStream.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("D:\\file.txt");
            ObjectInputStream objectInputStream
                    = new ObjectInputStream(fileInputStream);
            bookSet = (TreeSet<Book>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }



}
