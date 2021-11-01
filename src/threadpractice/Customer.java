package threadpractice;

public class Customer implements Runnable {
    private final String name;
    private final int eatingTime;
    private final Thread thread;


    public Customer(String name, int eatingTime) {
        this.name = name;
        this.eatingTime = eatingTime;
        this.thread = new Thread(this);
    }

    public String getName() {
        return name;
    }

    public int getEatingTime() {
        return eatingTime;
    }

    public boolean isFullOfEat() {
        return this.thread.isAlive();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", eatingTime=" + eatingTime +
                '}';
    }

    public void eating() {
        System.out.println(name + " is eating");
        this.thread.start();
    }

    @Override
    public void run() {
        eating();
        try {
            wait(eatingTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " finish eating");
    }
}
