package problem4;

import java.util.Scanner;

public class text {
    public static void run(){
        boolean error = false;
        do {
            error = false;
            try {
                Dictionary.dictionary dict = new Dictionary.dictionary();
                Scanner in = new Scanner(System.in);
                System.out.print("Введите текст (для окончания ввода введите пустую строку(нажать Enter 2 раза)): ");
                String str = "";
                String s = "";
                do {
                    s = in.nextLine();
                    str += s+"\n";
                }while(s.compareTo("") != 0);

                String[] words = str.trim().split(" |\\,|\\.|\\:|\\;|\n|\\!|\\(|\\)|\\{|\\}|\\[|\\]|\\-"); //извлекаем слова из предложения
                for(int i=0;i<words.length;i++){
                    String w = words[i];
                    if (w.compareTo("") != 0) {
                        dict.add(w.toUpperCase()); //добавляем слово в словарь, все слова добавляются в ОДНОМ регистре т.к. в задаче не учитывается регистр слов
                    }
                }
                System.out.print("Введите искомое слово: ");

                String word = in.nextLine();
                System.out.print("Слово ");
                System.out.print(word);
                System.out.print(" встречается в тексте ");
                System.out.print(dict.Search(word.toUpperCase())); //ищем сколько слово встрчается раз в словаре
                System.out.print(" раз.\n");

            } catch (Exception ex) {
                error = true;
                System.out.print("Ошибка! Попробуйте еще раз!\n");
            }
        }while(error);
    }
}
