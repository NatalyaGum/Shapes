package by.epam.task2.validator.impl;

import by.epam.task2.validator.PointValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PointValidatorImpl {
    public boolean validatePoints(String points){
        Pattern pattern = Pattern.compile(PointValidator.POINT_REGEX);
        Matcher matcher = pattern.matcher(points);

        return matcher.matches();
    };
}
