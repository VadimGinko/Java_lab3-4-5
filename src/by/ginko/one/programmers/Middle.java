package by.ginko.one.programmers;

public class Middle extends programmer  {
    public Middle(String name, int office_hours, kind type) {
        super(name, office_hours, type);
    }

    public void SetSalary(int money)
    {
        if(money >= 1000 && money <= 2000)
        {
            this.money = money;
        }
        else
        {
            System.out.println("Неверная сумма");
        }
    }
}
