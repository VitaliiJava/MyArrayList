package com.lviv.list;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 * The class is created for storing and handle of information about user
 */

public class MyList implements PowerfulListable {

    private int capacity = scanner.nextInt();//size of array
    private int[] arrayList = new int[capacity];
    private int size = 0;//pointer for last element of array

    static {
        System.out.println("Input length of array por favor! ");
    }

    private static final String FILE_NAME = "./LogsFromList.txt";

    public static String getFileName() {
        return FILE_NAME;
    }

    private static final Scanner scanner = new Scanner(System.in);

    {

        String log = new Date() + " first length of array = " + capacity + "\n";
        try {
            writeLogToFile(log);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addIncreaseCapacityDouble(int element) {
        String log;
        if (size < capacity) {
            arrayList[size] = element;
        } else {
            int temporaryArray[] = new int[capacity];
            for (int i = 0; i < size; i++) {
                temporaryArray[i] = arrayList[i];
            }
            capacity = capacity << 1;
            arrayList = new int[capacity];
            for (int i = 0; i < size; i++) {
                arrayList[i] = temporaryArray[i];
            }
            arrayList[size] = element;
        }
        size++;
        if (size < capacity) {
            log = new Date() + " add " + element + " element to MyList\n";
        } else {
            log = new Date() + " add " + element + " element to MyList and increase capacity for double" + capacity + "\n";
        }
        try {
            writeLogToFile(log);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addIncreaseCapacityForOne(int element) {
        String log;
        if (size < capacity) {
            arrayList[size] = element;
        } else {
            int arrayTemp[] = new int[arrayList.length + 1];
            for (int j = 0; j < arrayList.length; j++) {
                arrayTemp[j] = arrayList[j];
                if (j + 1 == arrayTemp.length - 1) {
                    arrayTemp[j + 1] = element;
                }
            }
            arrayList = new int[arrayTemp.length];
            for (int i = 0; i < arrayTemp.length; i++) {
                arrayList[i] = arrayTemp[i];
            }
            arrayList[size] = element;
        }
        size++;
        if (size < capacity) {
            log = new Date() + " add " + element + " element to MyList \n";
        } else {
            log = new Date() + " add " + element + " element to MyList and increase capacity for 1(capacity = " + capacity + ")\n";
        }
        try {
            writeLogToFile(log);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int index) {
        int number = getElement(index);
        int arrayTempOne[] = Arrays.copyOfRange(arrayList, 0, index);
        int arrayTempTwo[] = Arrays.copyOfRange(arrayList, index + 1, arrayList.length);
        int arrayTempFinal[] = new int[arrayTempOne.length + arrayTempTwo.length];
        for (int i = 0; i < arrayTempOne.length | i < arrayTempTwo.length; i++) {
            if (i < arrayTempOne.length) {
                arrayTempFinal[i] = arrayTempOne[i];
            }
            if (i < arrayTempTwo.length) {
                arrayTempFinal[i + arrayTempOne.length] = arrayTempTwo[i];
            }
        }
        arrayList = new int[arrayTempFinal.length];
        for (int i = 0; i < arrayTempFinal.length; i++) {
            arrayList[i] = arrayTempFinal[i];
        }
        String log = new Date() + " remove " + index + " element from MyList, value = " + number + "\n";
        try {
            writeLogToFile(log);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeElementOfArray(int index, int element) {
        int changedElement = 0;
        int valueBeforeChange = 0;
        for (int i = 0; i < arrayList.length; i++) {
            if (i == index) {
                valueBeforeChange = arrayList[i];
                arrayList[i] = element;
                changedElement = arrayList[i];
            }
        }
        printList();
        String log = new Date() + " change " + index + " element from " + valueBeforeChange + " value to " + changedElement + " value" + "\n";
        try {
            writeLogToFile(log);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void increaseList(int count) {
        int from = arrayList.length;
        int arrayTemp[] = new int[arrayList.length + count];
        for (int j = 0; j < arrayList.length; j++) {
            arrayTemp[j] = arrayList[j];
        }
        arrayList = new int[arrayTemp.length];
        for (int i = 0; i < arrayTemp.length; i++) {
            arrayList[i] = arrayTemp[i];
        }
        printList();
        String log = new Date() + " increase capacity of MyList from " + from + " to " + (from + count) + "\n";
        try {
            writeLogToFile(log);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cutList(int count) {
        int from = arrayList.length;
        int arrayTemp[] = Arrays.copyOf(arrayList, arrayList.length - count);
        arrayList = new int[arrayTemp.length];
        for (int i = 0; i < arrayTemp.length; i++) {
            arrayList[i] = arrayTemp[i];
        }
        printList();
        String log = new Date() + " cut capacity of MyList from " + from + " to " + (from - count) + "\n";

        try {
            writeLogToFile(log);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printList() {
        System.out.println("If you want to see ASC list press 1 or DESC list press 2");
        String log = null;
        int number = scanner.nextInt();
        if (number == 1) {
            for (int i = 0; i < arrayList.length; i++) {
                System.out.print(arrayList[i] + " ");
            }
        } else if (number == 2) {
            for (int i = arrayList.length - 1; i >= 0; i--) {
                System.out.print(arrayList[i] + " ");
            }
        } else {
            System.out.println("Input correct number");
        }
        if (arrayList.length == 0) {
            System.out.println("NO elements of array");
        }
        if (number == 1) {
            log = new Date() + " print MyList ASC for " + arrayList.length + " elements\n";
        } else if (number == 2) {
            log = new Date() + " print MyList DESC for " + arrayList.length + " elements\n";
        }
        try {
            writeLogToFile(log);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sortList() {
        String log = null;
        System.out.println(" If you want to sort ASC list press 1 DESC list press 2");
        int number = scanner.nextInt();
        if (number == 1) {
            for (int i = arrayList.length - 1; i >= 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (arrayList[j] < arrayList[j + 1]) {
                        int temp = arrayList[j];
                        arrayList[j] = arrayList[j + 1];
                        arrayList[j + 1] = temp;
                    }
                }
                System.out.print(arrayList[i] + " ");
            }
        } else if (number == 2) {
            for (int i = arrayList.length - 1; i >= 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (arrayList[j] > arrayList[j + 1]) {
                        int temp = arrayList[j];
                        arrayList[j] = arrayList[j + 1];
                        arrayList[j + 1] = temp;
                    }
                }
                System.out.print(arrayList[i] + " ");
            }
        } else {
            System.out.println("Input correct number");
        }
        if (arrayList.length == 0) {
            System.out.println("NO elements of array");
        }
        if (number == 1) {
            log = new Date() + " sort MyList ASC for " + arrayList.length + " elements\n";
        } else if (number == 2) {
            log = new Date() + " sort MyList DESC for " + arrayList.length + " elements\n";
        }
        try {
            writeLogToFile(log);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getElement(int index) throws IndexOutOfBoundsException {
        String log = new Date() + " get " + index + " element from MyList\n";
        try {
            writeLogToFile(log);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (index < size) {
            return arrayList[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void showLogList() throws IOException {
        Path path = FileSystems.getDefault().getPath("./LogsFromList.txt");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }


    @Override
    public void writeLogToFile(String string) throws Exception {
        Path path = FileSystems.getDefault().getPath("./LogsFromList.txt");
        String infoFromUser = string;
        Files.write(path, infoFromUser.getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);

    }

    public void menu() {
        String log = null;
        int choose = 0;
        System.out.println("\n ”`”*°•. `”*°••°*”` .•°*”`”*°•. ");
        System.out.println("•°*”`.•°*”`*MENU*`”*°•.`”*°•.");
        System.out.println(".•°*”` .•°*”` .•°*”` `”*°•. `”*°•. `”*°");
        System.out.println("1) Add element to list( capacity ).");
        System.out.println("2) Add element to list(increase on 1).");
        System.out.println("3) Delete element by index (from list) .");
        System.out.println("4) Change element by index (from list).");
        System.out.println("5) Increase the list on some quantity of elements.");
        System.out.println("6) Cut the list on some quantity of elements.");
        System.out.println("7) Output elements to the console in direct and reverse order.");
        System.out.println("8) Sort list.");
        System.out.println("9) Output elements to the console by index.");
        System.out.println("10) Output logs to the console.");
        System.out.println("11) Exit.\n");
        for (int i = 0; i < 12; i++) {
            if (String.valueOf(i).equals(Main.getKey())) {
                choose = i;
            }
        }
        log = new Date() + "choose " + choose + " Menu item\n";
        try {
            writeLogToFile(log);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
