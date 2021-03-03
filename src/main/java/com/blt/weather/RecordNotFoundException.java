package com.blt.weather;

import java.util.function.Supplier;

/**
 * @author fatih
 */
public class RecordNotFoundException extends Exception {
    public RecordNotFoundException(String message) {
        super(message);
    }
}
