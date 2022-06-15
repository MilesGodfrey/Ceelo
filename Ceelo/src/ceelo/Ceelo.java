/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceelo;
/**
 *
 * 
 */

import java.util.Scanner;
public class Ceelo {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        String str = "y";
        double money = 100.0;
        while (str.equalsIgnoreCase("y")){
           
        int hand[] = hand();
        for (int i = 0; i<hand.length;){
            System.out.print(hand[i]+" ");
            i++;
        }
        
        int value = handCheck(hand);
        if (hand[0] + hand[1] + hand[2] == 6 && hand[0] != hand[1] && hand[0] !=4 && hand[1] != 4 && hand[2] != 4){ // these strange looking ifs are here to check for a 456 hand (instant win) or a 123 hand (instant lose) 
                                                                                                                    //I could use a sort. However, you still have to check the hand at the same time so I see no reason why that 
                                                                                                                    //code would be faster. 
            System.out.println("lose");
            money = 0;
        }
        else if (hand[0] + hand[1] + hand[2] == 15 && hand[0] != hand[1] && hand[0] != hand[2] && hand[1] != hand[2]){
            System.out.println("WIN!!!");
            money = money * 2;
        }
        else{
        System.out.println("\nvalue is "+value);
        System.out.println("----------------");
        java.util.concurrent.TimeUnit.SECONDS.sleep(1);
       
       
        if (value != 0){
        int opponentvalue = opponent();
            System.out.println("\nopponents value: "+opponentvalue);
            if (value == opponentvalue){
            System.out.println("DRAW");
        }
            else if(value > opponentvalue){
                System.out.println("YOU WIN");
                money = money * 2;
            }
            else{
                System.out.println("YOU FAIL");
                money = 0;
            }
            
        }
       
        }
       
        System.out.println("$"+money+"\nRoll again? (y/n):");
        str = input.next();
        }
    }
    public static int roll(){
        int dice = (int)(Math.random()*6+1);
        return dice;
    }
    public static int[] hand(){  //creating random dice rolls 
        int[] hand = new int[3];
        hand[0] = (int)(Math.random()*6+1);
        hand[1] = (int)(Math.random()*6+1);
        hand[2] = (int)(Math.random()*6+1);
        return hand;
    }
    public static int handCheck(int[] hand){ //checks if there is a value to your hand and what the value is.
        int value = 0;
        int dice1 = hand[0];
        int dice2 = hand[1];
        int dice3 = hand[2];
        if (dice1 == dice2){
            value = dice3;
        }
        else if (dice1 == dice3){
            value = dice2;
        }
        else if (dice2 == dice3){
            value = dice1;
        }
       

        return value;
    }
   
    public static int opponent() throws InterruptedException{  // this is the bot opponent. Ceelo is all chance so the bot difficulty will be no different then on the street.
        int value;
        do {
        int hand[] = hand();
            System.out.println("\n Opponent's Hand ");
        for (int i = 0; i<hand.length;){
            System.out.print(hand[i]+" ");
            i++;
        }
        value = handCheck(hand);
        java.util.concurrent.TimeUnit.SECONDS.sleep(1);// slowed for effect 
        if (hand[0] + hand[1] + hand[2] == 6 && hand[0] != hand[1] && hand[0] !=4 && hand[1] != 4 && hand[2] != 4){  // again with this craziness 
            System.out.println("opponent loss");
        }
        else if (hand[0] + hand[1] + hand[2] == 15 && hand[0] != hand[1] && hand[0] != hand[2] && hand[1] != hand[2]){
            System.out.println("Oponnent Win");
        }
       
        }while (value == 0);
       
        return value;
    }
   
}


