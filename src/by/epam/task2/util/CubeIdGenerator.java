package by.epam.task2.util;

import java.util.UUID;

public class CubeIdGenerator {


    private CubeIdGenerator() {
    }

    private static String counter;

    public static String generateId() {
        return UUID.randomUUID().toString();
    }

}
