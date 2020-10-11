
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chree
 */
public class HannoiGame {
    Stack<Integer> pole1 = new Stack();
    Stack<Integer> pole2 = new Stack();
    Stack<Integer> pole3 = new Stack();
    int moveCount = 0;
    
    
   //The disks are represented by numbers - the higher the number the larger the disk
    public HannoiGame(int numDiscs){
        for(int i = numDiscs; i > 0; i--){
            pole1.push(i);
        }
    }
      
    public void solveHannoi(){
        if(isDone()){
           return;
        }
        else if(pole1.size() % 2 == 0){
            if(pole2.isEmpty() && !pole1.isEmpty()|| !pole2.isEmpty() && !pole1.isEmpty() && pole1.peek() < pole2.peek()){
                pole2.push(pole1.pop());
                displayMove();
            }
            else if(!pole2.isEmpty() && pole1.isEmpty()|| !pole2.isEmpty() && !pole1.isEmpty() && pole1.peek() > pole2.peek()){
                pole1.push(pole2.pop());
                displayMove();
            }
            
            if(isDone()){
                return;
            }
            
            if(pole3.isEmpty() && !pole1.isEmpty() || !pole3.isEmpty() && !pole1.isEmpty() && pole1.peek() < pole3.peek()){
                pole3.push(pole1.pop());
                displayMove();
            }
            else if(!pole3.isEmpty() && pole1.isEmpty() || !pole3.isEmpty() && !pole1.isEmpty() && pole1.peek() > pole3.peek()){
                pole1.push(pole3.pop());
                displayMove();
            }
            
            if(isDone()){
                return;
            }

            if(pole3.isEmpty() && !pole2.isEmpty() || !pole3.isEmpty() && !pole2.isEmpty() && pole2.peek() < pole3.peek()){
                pole3.push(pole2.pop());
                displayMove();
            }
            else if(!pole3.isEmpty() && pole2.isEmpty() || !pole3.isEmpty() && !pole2.isEmpty() && pole2.peek() > pole3.peek()){
                pole2.push(pole3.pop());
                displayMove();
            }
            
            if(isDone()){
                return;
            }

        }
        else{
            if(pole3.isEmpty() && !pole1.isEmpty() || !pole3.isEmpty() && !pole1.isEmpty() && pole1.peek() < pole3.peek()){
                pole3.push(pole1.pop());
                displayMove();
            }
            else if(!pole3.isEmpty() && pole1.isEmpty() || !pole3.isEmpty() && !pole1.isEmpty() && pole1.peek() > pole3.peek()){
                pole1.push(pole3.pop());
                displayMove();
            }
            
            if(isDone()){
                return;
            }
            
            if(pole2.isEmpty() && !pole1.isEmpty() || !pole2.isEmpty() && !pole1.isEmpty() && pole1.peek() < pole2.peek()){
                pole2.push(pole1.pop());
                displayMove();
            }
            else if(!pole2.isEmpty() && pole1.isEmpty() || !pole2.isEmpty() && !pole1.isEmpty() && pole1.peek() > pole2.peek()){
                pole1.push(pole2.pop());
                displayMove();
            }
            
            if(isDone()){
                return;
            }
            
            if(pole3.isEmpty() && !pole2.isEmpty() || !pole2.isEmpty() && !pole3.isEmpty() && pole2.peek() < pole3.peek()){
                pole3.push(pole2.pop());
                displayMove();
            }
            else if(!pole3.isEmpty() && pole2.isEmpty() || !pole2.isEmpty() && !pole3.isEmpty() && pole2.peek() > pole3.peek()){
                pole2.push(pole3.pop());
                displayMove();
            }  
            
            if(isDone()){
                return;
            } 
        }
        
        solveHannoi();
    }
    
    private void displayMove(){
        moveCount++;
        System.out.println("Move Number:" + moveCount);
        System.out.println("Pole 1: " + pole1);
        System.out.println("Pole 2: " + pole2);
        System.out.println("Pole 3: " + pole3);
        System.out.println();
    }
    
    private boolean isDone(){
        return pole1.isEmpty() && pole2.isEmpty();
    }
}
