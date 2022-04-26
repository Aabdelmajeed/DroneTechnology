package com.drone.droneTechnology.utils;

public final class ExceptionsUtils {

    public static final String ACCESS_EXCEPTION_MESSAGE = "Error Occured While Accessing Database";

    private ExceptionsUtils() throws IllegalAccessException {
        throw new IllegalAccessException("Exception utils constant class");
    }
}
