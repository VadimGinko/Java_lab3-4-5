package by.ginko.one.other_profession;

import by.ginko.one.Worker;

public class Marketer extends Worker {
    public  Marketer() {}
    public Marketer(String name, int office_hours)
    {
        super(name, office_hours);
    }

    public void SetSalary(int money)
    {
        if(money >= 1500 && money <= 3000)
        {
            this.money = money;
        }
        else
        {
            System.out.println("Неверная сумма");
        }
    }
}
