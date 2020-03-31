package by.ginko.one;

import by.ginko.one.other_profession.SystemAdministrator;
import by.ginko.one.programmers.IProgrammer;
import by.ginko.one.programmers.Junior;
import by.ginko.one.programmers.Senior;
import by.ginko.one.Worker;
import by.ginko.one.programmers.programmer;
import by.ginko.one.serialization.XMLParser;
import by.ginko.one.serialization.jsonSerializer;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

//убрать деньги в конструкторе
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Junior q = new Junior("Vadim", 3, programmer.kind.Back_End);
        Senior q2 = new Senior("Dima", 3, programmer.kind.Front_End);
        SystemAdministrator q3 = new SystemAdministrator("Nik", 3);
        Director director = Director.Create();
        director.SetWorkers(q);
        director.SetWorkers(q2);
        director.SetWorkers(q3);
        director.doSerialization();
        var u = director.GetProgrammerBySpecialization(programmer.kind.Back_End);
        int money = 300;
        for (int i=0; i<director.lst.size(); i++)
        {
            var y = director.lst.get(i);
            y.money = money;
            money -= 100;
        }
        director.printList();
        director.sortByMoney();
        director.printList();



        jsonSerializer js = new jsonSerializer();
        PrintStream writer = new PrintStream("files\\JSONSerialized.json");
        js.serialize(writer, director.lst);
        var qq = js.deserialize();

        boolean b = XMLParser.checkXMLforXSD("files\\obj.xml", "files\\objxsd.xsd");
        System.out.println("XML соответствует XSD : " + b);
        ArrayList<Worker> d = new ArrayList<Worker>();
        if(b) {
            d = XMLParser.xmlParserMethod("files\\obj.xml");
        }
        for(Worker l:d)
        {
            System.out.println(l);
        }
    }
}
