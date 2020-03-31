package by.ginko.one;
import by.ginko.one.programmers.programmer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.sql.Driver;
import java.util.*;

public class Director implements Serializable
{
    private Director(){max_size_workers = 20;}
    private int max_size_workers;
    private int size;
    static Director main;
    public List<Worker> lst= new ArrayList<Worker>();


    static Director Create()
    {
        if(main == null)
            Director.main = new Director();
        return main;
    }
    public void SetWorkers(Worker val)
    {
        size++;
        if(size <= max_size_workers)
            lst.add(val);
        else
            System.out.println("Превышено максимальное число работников");
    }
    public void RemoveWorkers(Worker val)
    {
        size--;
        if(size >= 0)
            lst.remove(val);
        else
            System.out.println("Работников нет");
    }

    public void SetCount()
    {
        System.out.println("Количество работников: " + lst.size());
    }

    public void printList()
    {
        for (Worker i:
             lst) {
            System.out.println(i.name);
        }
    }

    public ArrayList<programmer> GetProgrammerBySpecialization(programmer.kind spec)
    {
        ArrayList<programmer> ret = new ArrayList<programmer>();
        for ( var y: lst) {
            if(y instanceof  programmer) {
                programmer spam = (programmer)y;
                if(spam.getType() == spec)
                {
                    ret.add(spam);
                }
            }
        }
        return ret;
    }

    public void sortByMoney()
    {
        Collections.sort(lst,Director.compare_by_money);
    }

    public static  final Comparator<Worker> compare_by_money = new Comparator<Worker>() {
        @Override
        public int compare(Worker o1, Worker o2) {
            return o1.money - o2.money;
        }
    };

    public void doSerialization() throws FileNotFoundException {
        FileOutputStream fos1 = new FileOutputStream("files\\ser.xml");
        java.beans.XMLEncoder xe1 = new java.beans.XMLEncoder(fos1);
        xe1.writeObject(lst);
        xe1.close();
    }
}
