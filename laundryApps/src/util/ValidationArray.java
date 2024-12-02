package util;

import error.ValidationException;

public class ValidationArray {
    public static int ValidateArrayIndex(int[] array, int index) throws ValidationException {
        if (index < 0 || index >= array.length) {
            throw new ValidationException("Index " + index + " tidak ditemukan dalam array");
        }
        return array[index];
    }
}
