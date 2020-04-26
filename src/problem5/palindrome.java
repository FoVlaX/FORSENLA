package problem5;

import java.util.Scanner;

public class palindrome {
    public palindrome(){
        boolean error = false;
        do {
            error = false;
            try {

                Scanner in = new Scanner(System.in);
                System.out.print("Введите целое число N (N<=100): ");
                int num = in.nextInt();
                if (num > 100){
                    error = true;
                    System.out.print("Ошибка! N не должно превышать 100! Попробуйте еще раз!");
                }else {
                    for (int i = 0; i < num; i++) {
                        String str = String.valueOf(i);
                        StringBuffer buffer = new StringBuffer(str);
                        if (buffer.toString().compareTo(buffer.reverse().toString()) == 0){ //если строка полиндром
                            System.out.println(str);
                        }
                    }
                }
            } catch (Exception ex) {
                error = true;
                System.out.print("Ошибка! N должно быть целым числом! Попробуйте еще раз!\n");
            }
        }while(error);
    }

}
