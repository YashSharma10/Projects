import java.util.*;
import java.util.Random;
public class RockPaperScissors {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random number = new Random();

        System.out.println("-----     ROCK PAPER SCISSORS      -----");
        
        int comp_choice = number.nextInt(3);

        System.out.println("1 = Rock \n2 = Paper \n3 = Scissors");
        System.out.print("Enter number of your choice : ");
        int user_choice = sc.nextInt();

        System.out.println("Your choice = "+user_choice);
        System.out.println("Computer Choice = "+comp_choice);

        if(comp_choice == user_choice){
            System.out.println("--     RESULT = GAME DRAW     --");
        }
        else if(comp_choice == 1){
            if(user_choice == 2){
                System.out.println("--     RESULT = YOU WON     --");
            }
            else if(user_choice == 3){
                System.out.println("--     RESULT = YOU LOSE     --");
            }
        }
        else if(comp_choice == 2){
            if(user_choice == 1){
                System.out.println("--     RESULT = YOU LOSE     --");
            }
            else if(user_choice == 3){
                System.out.println("--     RESULT = YOU WON     --");
            }
        }
        else if(comp_choice == 3){
            if(user_choice == 1){
                System.out.println("--     RESULT = YOU WON     --");
            }
            else if(user_choice == 2){
                System.out.println("--     RESULT = YOU LOSE     --");
            }
        }

    }
}
