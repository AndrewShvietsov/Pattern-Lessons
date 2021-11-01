package threadpractice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Table extends Thread {
    private final String tableType;
    private final List<Customer> customerList = new ArrayList<>();
    private final int placeCount;

    public Table(String tableType, int placeCount) {
        this.tableType = tableType;
        this.placeCount = placeCount;
        this.start();
    }

    public String getTableType() {
        return tableType;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public int getPlaceCount() {
        return placeCount;
    }

    @Override
    public String toString() {
        return "Table{" +
                "tableType='" + tableType + '\'' +
                ", customersCount=" + customerList +
                ", placeCount=" + placeCount +
                '}';
    }

    public int getFreePlace() {
        return placeCount - customerList.size();
    }

    public boolean isSitCustomer(Customer customer) {
        boolean isResult = false;
        if (getFreePlace() > 0) {
            customerList.add(customer);
            isResult = true;
        }
        return isResult;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Table name is " + tableType + " Whole places " + placeCount);
            System.out.println("Free places - " + getFreePlace());
            List<Customer> list = new ArrayList<>();
            list.addAll(customerList);
            for (Customer tempCustomer : list) {
                if (!tempCustomer.isFullOfEat()) {
                    customerList.remove(tempCustomer);
                }
            }
        }
    }
}
