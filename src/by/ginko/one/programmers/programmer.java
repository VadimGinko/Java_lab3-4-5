package by.ginko.one.programmers;

import by.ginko.one.Worker;

public class programmer extends Worker implements IProgrammer {
    private kind type;
    programmer() {
        super();
    }
    public programmer(String name, int office_hours, kind type) {
        super(name, office_hours);
        this.type = type;
    }
    public enum kind
    {
        Front_End,
        Back_End,
        Full_Stack
    }

    public kind getType()
    {
        return type;
    }
}
