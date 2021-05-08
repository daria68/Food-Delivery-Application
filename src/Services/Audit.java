package Services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;


public class Audit {
    private static Audit instance = null;
    private static Audit getInstance()
    {
        if(instance == null)
            instance = new Audit();
        return  instance;
    }



    public void scrie(String action){
        try (FileWriter writer = new FileWriter("audit.csv", true);) {
            Timestamp date = new Timestamp(System.currentTimeMillis());
            writer.append(action);
            writer.append(",");
            writer.append(String.valueOf(date));
            writer.append("\n");
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

}
