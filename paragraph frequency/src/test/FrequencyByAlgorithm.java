/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author nSense
 */
public class FrequencyByAlgorithm {
      
    public static String [] getUniqueWords(String[] words) {
        
        String[] uniqueWords = new String[words.length];
        uniqueWords[0] = words[0];
        int index = 1;
        boolean wordAlreadyExists = false;
        
        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j <= index; j++) {
                if (words[i].equals(uniqueWords[j])) {
                    wordAlreadyExists = true;
                }
            }
            if (!wordAlreadyExists) {
                uniqueWords[index] = words[i];
                index++;
            }
            wordAlreadyExists = false;
        }
        return uniqueWords;
    }
    
     public static void frequencyByAlgorithm(String text){
         
        String[] keys = text.split(" ");
        String[] uniqueKeys;
        int count = 0;
        System.out.println("Words \t\t\tFrequency\n");
        uniqueKeys = getUniqueWords(keys);
        
        for (String key : uniqueKeys) {
            if (null == key) {
                break;
            }
            for (String s : keys) {
                if (key.equals(s)) {
                    count++;
                }
            }
            System.out.println(key+"\t\t\t:"+count);
            count = 0;
        }
         
    }
}
