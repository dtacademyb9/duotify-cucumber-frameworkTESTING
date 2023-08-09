package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CSVReader {


    public static List<List<String>> readFromCSVFile(String filePath){

        List<List<String>> list = new ArrayList<>();
        try {
            list = Files.lines(Path.of(filePath))
                    .map(s -> new ArrayList<>(Arrays.asList(s.split(","))))
                    .collect(Collectors.toList());
        } catch(IOException e){
            throw new RuntimeException(e);
        }


        return list;

    }




}
