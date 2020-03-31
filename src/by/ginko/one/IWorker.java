package by.ginko.one;

public abstract class IWorker
{
    protected int money;
    public int office_hours;
    public String name;
    IWorker() {}
    public IWorker(String name, int office_hours)
    {
        this.office_hours = office_hours;
        this.money = 0;
        this.name = name;
    }
    public void ShowSalary()
    {
        System.out.println("Зарплата: " + money);
    }

    public void SetSalary() {
    }
}
