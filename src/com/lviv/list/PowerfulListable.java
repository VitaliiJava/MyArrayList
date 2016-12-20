package com.lviv.list;


public interface PowerfulListable {

    public void addIncreaseCapacityDouble(int element);

    public void addIncreaseCapacityForOne(int element);

    public void remove(int index);

    public void changeElementOfArray(int index, int element);

    public void increaseList(int count);

    public void cutList(int count);

    public void printList();

    public void sortList();

    public int getElement(int index) throws IndexOutOfBoundsException;

    public void showLogList() throws Exception;

    public void writeLogToFile(String string) throws Exception;

}
