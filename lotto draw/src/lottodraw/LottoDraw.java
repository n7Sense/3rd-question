/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lottodraw;

/**
 *
 * @author nSense
 */
public class LottoDraw {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] lottery = new int[6];
    int randomNum;

    for (int i = 0; i < 6; i++) {
        
        //Random number created here.
        randomNum = (int) (Math.random() * 50);
        for (int x = 0; x < i; x++) {
            // Here, code checks if same random number generated before.
            if (lottery[i] == randomNum){
                //If random number is same, another number generated.
                randomNum = (int) (Math.random() * 100);
            }
        }
        lottery[i] = randomNum;
    }

    for (int i = 0; i < lottery.length; i++)
        System.out.print(lottery[i] + " ");
    }
    
}
