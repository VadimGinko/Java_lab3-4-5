package by.ginko.one.other_profession;

import by.ginko.one.Worker;
import by.ginko.one.programmers.programmer;

public class Engineer extends Worker {
    public Engineer(){}
    public Engineer(String name, int office_hours) {
        super(name, office_hours);
    }

    public void SetSalary(int money)
    {
        if(money >= 1000 && money <= 3000)
        {
            this.money = money;
        }
        else
        {
            System.out.println("Неверная сумма");
        }
    }
}
