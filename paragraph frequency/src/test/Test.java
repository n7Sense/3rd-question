/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;


/**
 *
 * @author nSense
 */
public class Test {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) throws IOException{
       
        String filePath = System.getProperty("user.dir")+"/src/test/paragraph.txt";
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8)){
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
 
        String content =  contentBuilder.toString();
        String[] words = content.split(" ");
        
        
        FrequencyByAlgorithm.frequencyByAlgorithm(content);
        
            /*
               ** OR By> Frequency By ConcurrentHashMap
            */
        //FrequencyByConcurrentHashMap.frequencyByConcurrentCollection(words);
        
            /*
                ** OR By> Frequency By Concurrent Collection
            */
        //FrequencyByConcurrentHashMap.frequencyByConcurrentCollection(words);
        
        
    }
    
}
