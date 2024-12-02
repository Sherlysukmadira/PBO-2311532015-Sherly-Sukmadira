package service;

public class ArrayService {
	public static int[] array = new int[15];  
	public static int currentIndex = 0;
	
    public static void addNumber(int number) throws Exception {
        if (currentIndex >= array.length) {
            throw new Exception("Array sudah penuh!");
        }
        array[currentIndex] = number;
        currentIndex++;
    }

    public int[] getArray() {
        return array;
    }
}
