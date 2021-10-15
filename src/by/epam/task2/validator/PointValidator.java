package by.epam.task2.validator;

public interface PointValidator {

    public static final String POINT_REGEX = "(-?\\d+(\\.\\d+)?(\\s)?,(\\s)?){6}";
    // -?(((\\d)+\\.?(\\d)*)|((\\d)*\\.?(\\d)+)))(\\s)+){6}
    //(-?\\d+(\\.\\d+)?;){6}

    boolean validatePoints(String points);
}
