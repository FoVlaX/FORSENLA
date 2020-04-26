package problem2;

import java.util.Scanner;

public class NOKandNOD {

    private int NOD(int A, int B){ //найдем наибольший общий делитель
        while (A != B){
            if (A > B){
                A -= B;
            } else {
                B -= A;
            }
        }
        return A;
    }

    private int NOK(int A, int B){ // найдем наименьшее общее кратное
        return B*A/NOD(A,B);
    }

    public NOKandNOD() { //основная функция задачи
        boolean error = false;
        do {
            error = false;
            try {
                Scanner in = new Scanner(System.in);
                System.out.print("Input a two integer number: ");

                int num1 = in.nextInt();
                int num2 = in.nextInt();
                if (num1 > 0 && num2 > 0) {
                    System.out.print("Least common multiple: ");
                    System.out.print(NOK(num1, num2));
                    System.out.print("\n");
                    System.out.print("Greatest common factor: ");
                    System.out.print(NOD(num1, num2));
                    System.out.print("\n");
                }else{
                    error = true;
                    System.out.print("Error! One or two numbers are zero. Please try again!\n");
                }


            } catch (Exception ex) {
                error = true;
                System.out.print("Error! Please write two integer values!\n");
            }
        }while(error);
    }
}
