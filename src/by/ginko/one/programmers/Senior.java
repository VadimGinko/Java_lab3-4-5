package by.ginko.one.programmers;

public class Senior extends programmer {
    public Senior(String name, int office_hours, kind type) {
        super(name, office_hours, type);
    }
    public Senior(){
        super();
    }
    public void SetSalary(int money)
    {
        if(money >= 2000 && money <= 4000)
        {
            this.money = money;
        }
        else
        {
            System.out.println("Неверная сумма");
        }
    }
}
