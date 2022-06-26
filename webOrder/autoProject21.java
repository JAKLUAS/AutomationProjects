package webOrder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class autoProject21 {

    public static List<String[]> read(String fileName) throws IOException {

            List<String[]> list = new ArrayList<>();

            BufferedReader br = new BufferedReader(new FileReader("DATA.csv"));

            String line;

            while ((line = br.readLine()) != null){
                String[] eachLine = line.split(",");
                list.add(eachLine);
            }

            return list;


        }
    }

