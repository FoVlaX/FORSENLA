package problem3;
import java.util.Scanner;
import java.lang.String;

public class words {


    public words(){

        boolean error = false;
        do {
            error = false;
            try {
                Dictionary.dictionary dict = new Dictionary.dictionary(); //создаем словарь
                Scanner in = new Scanner(System.in);
                System.out.print("Введите предложение: ");
                String str = in.nextLine(); //вводим предложение
                String[] swords = str.trim().split(" "); //получаем слова из предложения
                for(int i=0;i<swords.length;i++){
                    if (swords[i].compareTo("")!=0) {
                        dict.add(swords[i]); //помещаем слова в словарь
                    }
                }
                System.out.print("Кол-во слов ");
                System.out.println(dict.getCount());
                dict.print(); //выводим слова в алфавитном (отсортированном виде) порядке
                System.out.print("\n");
            } catch (Exception ex) {
                error = true;
                System.out.print("Ошибка! Попробуйте еще раз!\n");
            }
        }while(error);
    }
}
