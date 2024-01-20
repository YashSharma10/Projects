import java.util.*;
public class calculator{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("-----     CALCULATOR     -----");
        System.out.println("1. ADDITION\n2. SUBTRACTION\n3. MULTIPLICATION\n4. DIVISION\n5. REMAINDER\n6. FACTORIAL\n" );

        System.out.print("Enter First Number : ");
        int a = sc.nextInt();
        System.out.print("Enter Second Number : ");
        int b = sc.nextInt();
        System.out.print("Please select the Operation With given Number : ");
        int c = sc.nextInt();

        switch(c){
            case 1 : 
            System.out.println("Sum = "+(a+b));
            break;
            case 2 : 
            System.out.println("Difference = "+(a-b));
            break;
            case 3 : 
            System.out.println("Product = "+(a*b));
            break;
            case 4 : 
            System.out.println("Quotient = "+(a/b));
            break;
            case 5 : 
            System.out.println("Remainder = "+(a%b));
            break;

        }


    }
}