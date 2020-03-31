package by.ginko.one.other_profession;

import by.ginko.one.Worker;

public class SystemAdministrator extends Worker {
    public SystemAdministrator(String name, int office_hours) {
        super(name, office_hours);
    }
    public SystemAdministrator(){}
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
