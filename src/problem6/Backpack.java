package problem6;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import  java.lang.Math;
public class Backpack {

    static class Item implements Comparable<Item>{
        int weight;
        int cost;
        Item(int w, int c){
            weight = w;
            cost = c;
        }
        public int compareTo(Item p){
            if (cost!=p.cost){
                return p.cost - cost;
            }else{
                return p.weight - weight;
            }

        }
    }

    public static void run(){
        boolean error = false;
        do {
            error = false;
            try {
                System.out.print("Введите количество вещей и вместимость рюкзака: "); //эффективность О(n*k);
                Scanner in = new Scanner(System.in);
                int n = in.nextInt();
                int k = in.nextInt();

                int []W = new int[k+1]; //массив стимостей для всех возможных весов
                boolean [][]bool = new boolean[k+1][n]; //массив для хранения положенных предметов для каждого веса

                Item[] items = new Item[n]; //предметы
                System.out.print("\nВведите значения веса и стоимости для ");
                System.out.print(n);
                System.out.print(" вещей:\n");

                for (int i=0;i<n;i++){ //вводим набор вещей
                    items[i] = new Item(0,0);
                    items[i].weight = in.nextInt();
                    items[i].cost = in.nextInt();
               }


                for (int w = 1;w<=k;w++){ //динамика
                    W[w] =W[w-1];
                    bool[w] = bool[w-1].clone();
                    for (int i=0;i<n;i++){
                        if (items[i].weight <= w) //если можем положить предмет не превышая вес w
                        {
                            if (W[w] < W[w - items[i].weight]+items[i].cost && !bool[w - items[i].weight][i]) { //смотрим если предмета i нет в рюкзаке и если бы положили предмет i в рюкзак, и соимость всех предметов при этом бы возрасла обновляем текущее значение стоимости и предметы для текущего веса.
                                W[w] = W[w - items[i].weight] + items[i].cost;
                                bool[w] = bool[w - items[i].weight].clone();
                                bool[w][i] = true;
                            }
                        }
                    }
                }
                System.out.println("Максимальная стоимость: ");
                System.out.println(W[k]); //max cost
                System.out.println("Вещи, которые положили в рюкзак: ");
                for (int i =0;i<n;i++){
                    if (bool[k][i]){
                        System.out.print(items[i].weight);
                        System.out.print(" ");
                        System.out.println(items[i].cost);
                    }
                }
            } catch (Exception ex) {
                error = true;

                System.out.println(ex.getMessage());
                System.out.print("Ошибка! Введите корректные данные!\n");
            }
        }while(error);
    }
}
