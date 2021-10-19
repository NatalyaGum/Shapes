package by.epam.task2.validator;

public interface PointValidator {

    public static final String POINT_REGEX = "(-?\\d+(\\.\\d+)?(\\s)?,(\\s)?){6}";

    boolean validatePoints(String points);
}
