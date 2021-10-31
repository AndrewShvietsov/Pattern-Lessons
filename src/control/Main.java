package control;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;
        while (!isExit) {
            System.out.println("1. Добавление участка\n" +
                    "2. Добавление гражданина\n" +
                    "3. Добавление партии\n" +
                    "4. Указать, что гражданин является кандидатом от определенной партии\n" +
                    "5. Показать избирательные участки (предусмотреть просмотр избирателей,\n" +
                    "добавление избирателя, удаление избирателя)\n" +
                    "6. Показать граждан\n" +
                    "7. Показать партии (предусмотреть просмотр членов партии, добавление,\n" +
                    "удаление)\n" +
                    "8. Выборы – требуется пройти по всем гражданам и у каждого спросить хочет ли\n" +
                    "он проголосовать.\n" +
                    "Если да – попросить выбрать партию и дать результат на избирательный\n" +
                    "участок, к которому относится избиратель.\n" +
                    "9. Показать результаты выборов – показать количество голосов, которые каждая\n" +
                    "партия получила от каждого участка. А также показать сколько получила всего\n" +
                    "каждая партия.\n" +
                    "10. Выход из программы\n");

            String enter = scanner.nextLine();
            switch (enter) {
                case "1": {
                    System.out.println("Enter address");
                    String address = scanner.nextLine();
                    System.out.println("Is Military? (Yes/No)");
                    boolean isMilitary = scanner.nextLine().equalsIgnoreCase("yes");
                    System.out.println("Is Quarantine? (Yes/No)");
                    boolean isQuarantine = scanner.nextLine().equalsIgnoreCase("yes");
                    new VoteDistrict(address, isMilitary, isQuarantine);
                    System.out.println("Vote District created");
                    break;
                }
                case "2": {
                    infoVoteDistrict();
                    System.out.println("Enter full name");
                    String fullName = scanner.nextLine();
                    System.out.println("Enter passport data");
                    String passport = scanner.nextLine();
                    System.out.println("Enter INN code");
                    String inn = scanner.nextLine();
                    System.out.println("Enter birthdate (mm/dd/yyyy)");
                    String birthday = scanner.nextLine();
                    LocalDate localDate = getBirthday(birthday);
                    System.out.println("Is Military? (Yes/No)");
                    boolean isMilitary = scanner.nextLine().equalsIgnoreCase("yes");
                    System.out.println("Is Quarantine? (Yes/No)");
                    boolean isQuarantine = scanner.nextLine().equalsIgnoreCase("yes");
                    System.out.println("Enter vote district number");
                    String voteDistrictNumber = scanner.nextLine();
                    VoteDistrict voteDistrict = findById(voteDistrictNumber);
                    try {
                        new Citizen(fullName, passport, inn, localDate, isMilitary, isQuarantine);
                    } catch (InnException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "3": {
                    break;
                }
                case "4": {
                    break;
                }
                case "5": {
                    break;
                }
                case "6": {
                    break;
                }
                case "7": {
                    break;
                }
                case "8": {
                    break;
                }
                case "9": {
                    break;
                }
                case "10": {
                    FileOutputStream fout = new FileOutputStream(VoteDistrict.data);
                    ObjectOutputStream out = new ObjectOutputStream(fout);
                    out.writeObject(VoteDistrict.getVoteDistrictSet());
                    out.flush();
                    isExit = true;
                    break;
                }
            }
        }
    }

    private static LocalDate getBirthday(String birthday) {
        String[] array = birthday.split("/");
        return LocalDate.of(Integer.parseInt(array[2]), Integer.parseInt(array[0]), Integer.parseInt(array[1]));
    }

    public static void infoVoteDistrict() {
        System.out.println(VoteDistrict.getVoteDistrictSet());
    }

    public static VoteDistrict findById(String id) {
        return VoteDistrict.getVoteDistrictSet().stream().filter(x -> x.getId() == Integer.parseInt(id)).collect(Collectors.toList()).get(0);

    }
}
