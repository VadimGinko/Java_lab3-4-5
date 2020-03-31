package by.ginko.one.programmers;

public class Junior extends programmer  {

    public Junior(){}
    public Junior(String name, int office_hours, kind type)
    {
        super(name, office_hours, type);
    }

    public void SetSalary(int money)
    {
        if(money >= 0 && money <= 1000)
        {
            this.money = money;
        }
        else
        {
            System.out.println("Неверная сумма");
        }
    }
}
