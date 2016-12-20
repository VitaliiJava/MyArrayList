package com.lviv.list;
/*
*1) добавление элементов.
2) изменение/удаление элементов по индексу.
3) увеличение листа на заданное количество элементов.
4) уменьшение листа до заданного количество элементов.
5) вывод элементов в консоль в прямом и обратном порядке.
6) сортировка листа.

При удалении элемента не обнулять его, а удалять физически.
Использовать абстрактный класс, интерфейсы и наследников. Также использовать переопределение.
Начальную размерность листа юзер вводит с консоли. Создать меню для работы с листом из консоли.
Update:
      Организовать логирование операций. Формат логов: дата - название операции - данные
      В меню добавить пункт вывода логов в консоль
*/

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static String key;

    public static String getKey() {
        return key;
    }

    public static void main(String[] args) throws IOException {
        MyList myList = new MyList();

        while (true) {
            myList.menu();
            key = scanner.next();
            switch (key) {
                case "1": {
                    System.out.println("Input element that you want to add(Capacity)");
                    int element = scanner.nextInt();
                    myList.addIncreaseCapacityDouble(element);
                    break;
                }
                case "2": {
                    System.out.println("Input element that you want to add(One)");
                    int element = scanner.nextInt();
                    myList.addIncreaseCapacityForOne(element);
                    break;
                }
                case "3": {
                    System.out.println("Input index of element that you want to remove");
                    int index = scanner.nextInt();
                    myList.remove(index);
                    break;
                }
                case "4": {
                    System.out.println("Input index of element that you want to change");
                    int index = scanner.nextInt();
                    int element = scanner.nextInt();
                    myList.changeElementOfArray(index, element);
                    break;
                }
                case "5": {
                    System.out.println("Input number that you want to increase array");
                    int number = scanner.nextInt();
                    myList.increaseList(number);
                    break;
                }
                case "6": {
                    System.out.println("Input number of element that you want to cut");
                    int number = scanner.nextInt();
                    myList.cutList(number);
                    break;
                }
                case "7": {
                    myList.printList();
                    break;
                }
                case "8": {
                    myList.sortList();
                    break;
                }
                case "9": {
                    System.out.println("Input index of element that you want to see");
                    int index = scanner.nextInt();
                    System.out.println(myList.getElement(index));
                    break;
                }
                case "10": {
                    myList.showLogList();
                    break;
                }
                case "11":
                    return;
                default:
                    return;
            }
        }
    }
}
