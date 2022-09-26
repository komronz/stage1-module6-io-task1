package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;


public class FileReader {

    public Profile getDataFromFile(File file) {
        HashMap<String, String> map = new HashMap<>();
        String line;
        try {
            BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file));
            while ((line = bufferedReader.readLine()) != null){
                String[] keyValuePair = line.split(":",2);
                String key = keyValuePair[0];
                String value = keyValuePair[1];
                map.put(key,value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Profile(map.get("Name"),
                Integer.valueOf(map.get("Age")),
                map.get("Email"),
                Long.valueOf(map.get("Phone")));
    }
}
