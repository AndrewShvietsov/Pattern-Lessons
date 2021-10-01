package University;

public class Course {
    public static void main(String[] args) {
        Employer employer = new Employer(new CompleteWork() {
            @Override
            public void doWork() {
                System.out.println("Read lecture");
            }
        });
        employer.doWork();
        employer.setDelegate(new Student());
        employer.doWork();
    }
}
