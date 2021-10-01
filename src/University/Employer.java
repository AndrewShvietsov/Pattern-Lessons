package University;

public class Employer implements CompleteWork {
    CompleteWork delegate;

    public Employer(CompleteWork delegate) {
        this.delegate = delegate;
    }

    @Override
    public void doWork() {
        delegate.doWork();
    }

    public void setDelegate(CompleteWork delegate) {
        this.delegate = delegate;
    }
}
