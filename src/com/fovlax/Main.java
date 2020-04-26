package com.fovlax;
import problem1.CheckNumber;
import problem2.NOKandNOD;
import problem3.words;
import problem4.text;
import problem5.palindrome;
import problem6.Backpack;


public class Main {

    static class problem{
        public problem(){

        }
        public void run(int i){ //запустить Задачу №i
            switch (i){
                case 1:     CheckNumber.run(); break; //первая задача определить четное, нечетное, простое или составное число
                case 2:     NOKandNOD.run();   break; //вторая задача найти НОД и НОК двух чисел
                case 3:     words.run();       break; //задание 3 вывести слова в отсортированном виде каждое слово с заглавной буквы
                case 4:     text.run();        break; //задание 4 вывести сколько раз слово встречается в тексе
                case 5:     palindrome.run();  break; //задание 5 найти все полиндромы от 0 до N (N<=100)
                case 6:     Backpack.run();    break;//задание 6 - заполнить рюкзак оптимально
                default:    System.out.println("Нет такой задачи!");  break;
            }
        }
    }


    public static void main(String[] args) {
        problem problems = new problem();
        problems.run(1); //Задание 1
        problems.run(2); //Задание 2
        problems.run(3); //Задание 3
        problems.run(4); //Задание 4
        problems.run(5); //Задание 5
        problems.run(6); //Задание 6
    }
}
