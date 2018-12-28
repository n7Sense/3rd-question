/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.Map;
/**
 *
 * @author nSense
 */
public class FrequencyByConcurrentHashMap {
    
    public static void frequencyByConcurrentCollection(String[] words){
        ConcurrentMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();
        for (String w : words) {
            map.compute(w, (k, v) -> v == null ? 1 : v + 1);
        }
        
        for (Map.Entry e : map.entrySet()) {
            System.out.println(e.getKey() + " = " + e.getValue());
        }
        
    }
}
