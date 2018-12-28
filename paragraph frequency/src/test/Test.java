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
public class Test {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here
  
        String text = "In Vaishnavism Vishnu is identical to the formless metaphysical concept called Brahman, the supreme the Svayam Bhagavan who takes various"
                + "avatars as the preserver protector whenever the world is threatened with evil chaos and destructive forces His avatars most notably include"
                + "Rama in the Ramayana and Krishna in the Mahabharata. He is also known as Narayana , Jagannath , Vasudeva , Vithoba , and Hari. He is one of"
                + "the five equivalent deities worshipped in Panchayatana puja of the Smarta Tradition of Hinduism In Hindu iconography , Vishnu is usually depicted"
                + "as having a pale or dark blue complexion and having four arms. He holds a padma (lotus flower) in his lower left hand, Kaumodaki gada (mace) "
                + "in his lower right hand, Panchajanya shankha (conch) in his upper left hand and the Sudarshana Chakra (discus) in his upper right hand. A"
                + "traditional depiction is Vishnu reclining on the coils of the serpent Shesha, accompanied by his consort Lakshmi, as he dreams the universe "
                + "into reality ";
        
        String[] words = text.split(" ");
        
        FrequencyByConcurrentHashMap.frequencyByConcurrentCollection(words);
        
    }
    
}
