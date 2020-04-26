package problem1;
import java.util.Scanner;

public class CheckNumber {
    public CheckNumber() {
        boolean error = false;
        do {
            error = false;
            try {
                Scanner in = new Scanner(System.in);
                System.out.print("Input a integer number: ");

                int num = in.nextInt();

                boolean parity = false; //четность
                if (num%2 == 0){ //проверка на четность
                    parity = true;
                }

                boolean prime = true; //простое или составное
                int del = 1;
                int count = 0;

                while (del*del <= num){ //проверка на простое
                    if (num%del == 0){
                        count++;
                    }
                    del++;
                }

                if (count != 1){//проверка на простое
                    prime = false;
                }

                System.out.print("Your number ");
                System.out.print(num);
                System.out.print(" is a ");
                if (parity) {
                    if (prime) {
                        System.out.print("even prime number\n");
                    }else{
                        System.out.print("even composite number\n");
                    }
                }else{
                    if (prime) {
                        System.out.print("odd prime number\n");
                    }else{
                        System.out.print("odd composite number\n");
                    }
                }

            } catch (Exception ex) {
                error = true;
                System.out.print("Error! Please write integer value!\n");
            }
        }while(error);
    }
}
