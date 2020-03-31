package by.ginko.one;

public class Worker extends IWorker
{
    public Worker() {
        super();
    }
    public Worker(String name, int office_hours) {
        super(name, office_hours);
    }
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void setofficehours(int hours)
    {
        this.office_hours = hours;
    }
}
