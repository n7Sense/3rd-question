/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author nSense
 */
public class FrequencyByMap {
    
    public static void frequenceByMap(String[] words){
        
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            Integer n = map.get(w);
            n = (n == null) ? 1 : ++n;
            map.put(w, n);
        }
        Set set = map.keySet();
        Collection collection  = map.values();
        Set entrySet = map.entrySet();
        Iterator itr = entrySet.iterator();
        
        while(itr.hasNext()){
            Map.Entry e = (Map.Entry)itr.next();
            System.out.println(e.getKey()+"\t\t\t:"+e.getValue());
        }
    }
    
   
}
