import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileCsvReader {
    private static final String COMMA_DELIMITER = ",";

    public static void main(String[] args) {
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader("test.txt"));

            String line="";
            while((line = reader.readLine())!=null){
                readCsv(parseCsvLine(line));
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try{
                if(reader!=null){
                    reader.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public static List<String> parseCsvLine(String line){
        List<String> result = new ArrayList<>();
        if(line != null){
            String[] data = line.split(COMMA_DELIMITER);
            for (String a:data) {
                result.add(a);
            }
        }
        return result;
    }
    public static void readCsv(List<String> list){
        System.out.println(
                "Country [id: " + list.get(0)
                + ", Code: " + list.get(1)
                + ", Name " + list.get(2)
                + "]"
        );
    }
}
