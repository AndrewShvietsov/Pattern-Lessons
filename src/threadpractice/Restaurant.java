package threadpractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Restaurant extends Thread {
    private final List<Table> tableList = new ArrayList<>();
    private final Queue<Customer> customerList = new LinkedList<>();

    {
        Table table1 = new Table("Table 1", 4);
        Table table2 = new Table("Table 2", 5);
        Table table3 = new Table("Table 3", 6);
        Table table4 = new Table("Table 4", 7);
        tableList.add(table1);
        tableList.add(table2);
        tableList.add(table3);
        tableList.add(table4);
        Customer customer1 = new Customer("Bob", 500);
        Customer customer2 = new Customer("Tom", 600);
        Customer customer3 = new Customer("Sam", 200);
        Customer customer4 = new Customer("Adam", 300);
        Customer customer5 = new Customer("Liam", 400);
        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);
        customerList.add(customer4);
        customerList.add(customer5);
    }



    @Override
    public void run() {
        boolean isExit = false;
        while (!isExit) {
            for (Table tempTable : tableList) {
            if (tempTable.isSitCustomer(customerList.peek())) {
                customerList.poll();
                }
            }
        if (customerList.size() == 0) {
            isExit = true;
        }
        }
    }
}
