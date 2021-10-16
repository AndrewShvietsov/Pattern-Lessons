package HomeworkLambda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookController bookController = new BookController();
        System.out.println("a - request A");
        System.out.println("b - request B");
        System.out.println("c - request C");
        System.out.println("d - request D");
        System.out.println("e - request E");
        System.out.println("f - request F");
        System.out.println("x - Exit");
        boolean isExit = true;
        while (isExit) {
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.next();
            switch (choice) {
                case "a": {
                    bookController.viewRequestA(scanner); break;
                }
                case "b": {
                    bookController.viewRequestB(scanner); break;
                }
                case "c": {
                    bookController.viewRequestC(scanner); break;
                }
                case "d": {
                    bookController.viewRequestD(); break;
                }
                case "e": {
                    bookController.viewRequestE(); break;
                }
                case "f": {
                    bookController.viewRequestF(scanner); break;
                }
                case "x": {
                    isExit = false;
                    System.out.println("Game over");
                    break;
                }
                default:
                    System.out.println("Enter mistake!");
            }
        }
    }
}
