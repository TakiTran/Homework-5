/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import static java.util.stream.Collectors.toMap;
import java.util.stream.Stream;

/**
 *
 * @author daohy
 */
public class HomeWork5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        File file = null;
        Map<String, Integer> characterMap = new HashMap<String, Integer>();
        Map<String, Integer> sorted = new HashMap<String, Integer>();
        try {
            BufferedReader br = new BufferedReader (new FileReader("BTVN-5.txt"));
            String line;
            String [] arrCharacter = null;
            while ( (line = br.readLine()) != null) {
                line =line.trim();
                if( !line.equals("") ) {
                    arrCharacter = line.toLowerCase().split("\\W+");
                    for(String character : arrCharacter) {
                        if(characterMap.containsKey(character)){
                            characterMap.put(character,characterMap.get(character)+1);
                        }else{
                            characterMap.put(character,1);
                        }    
                    }
                } 
            }
            sorted = characterMap.entrySet()
                        .stream()
                        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                        .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,LinkedHashMap::new)); 
            
            for (Map.Entry<String, Integer> item : sorted.entrySet()) {
                System.out.println(item.getKey()+ " " + item.getValue());
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
        long estimatedTime = System.currentTimeMillis()- startTime;
        System.out.println("BUILD SUCCESSFUL: " + estimatedTime + " ms");
    }
    
}
