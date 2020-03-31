package by.ginko.one.serialization;


import java.awt.print.PrinterAbortException;
import java.io.*;
import java.lang.reflect.Type;
import java.util.List;
import java.util.ArrayList;

import by.ginko.one.Worker;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class jsonSerializer {

    public void serialize(PrintStream writer,List<Worker> carList)
    {

        try {
            Gson gson = new Gson();
            writer.println(gson.toJson(carList));
        }
        catch (Exception ex)
        {
            ex.toString();
        }
    }

    public List<Worker> deserialize() throws FileNotFoundException {
        Reader eadr = new FileReader("files\\JSONSerialized.json");
        Gson gson = new Gson();
        List<Worker> Des = new ArrayList<Worker>();
        Type genDeser = new TypeToken<List<Worker>>() {}.getType();
        Des = gson.fromJson(eadr,genDeser);
        System.out.println("               Deserialized");
        for (Worker f:Des) {
            System.out.println(f);;
        }
        return Des;
    }
}
