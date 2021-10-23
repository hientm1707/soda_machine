package utils;

import exceptions.InvalidOptionException;
import exceptions.InvalidQuantityException;

public class Validator {
    private static final int MIN_OPTION = 1;
    private static final int MAX_OPTION = 3;
    private static final int MIN_QUANTITY = 1;
    private static final int MAX_QUANTITY = 5;
    private static final String INVALID_OPTION = "Invalid option, option must be in range [1,3]";
    private static final String QUANTITY_FALLEN_SHORT = "Quantity must be greater than zero";
    private static final String QUANTITY_EXCEEDED = "Exceeded the product quantity allowed";

    private static void validateOption(int option) {
        if (option > MAX_OPTION || option < MIN_OPTION) {
            throw new InvalidOptionException(INVALID_OPTION);
        }
    }

    private static void validateQuantity(int quantity) {
        if (quantity < MIN_QUANTITY) {
            throw new InvalidQuantityException(QUANTITY_FALLEN_SHORT);
        } else if (quantity > MAX_QUANTITY) {
            throw new InvalidQuantityException(QUANTITY_EXCEEDED);
        }
    }

    public static void validateOptionAndQuantity(int option, int quantity){
        validateOption(option);
        validateQuantity(quantity);
    }
}

