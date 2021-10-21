package by.epam.task2.parser.impl;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class ParserImplTest {

    ParserImpl parser;

    @BeforeMethod
    public void initialize() {
        parser = new ParserImpl();}


    @Test
    public void testParseCoordinate() {
        List<String> strings = new ArrayList<String>();
        strings.add("");
        strings.add("1, 1, 10, 1, 1, -1,");
        strings.add("2.0, 3, 4, 2.0, 3, 0.1,");
        strings.add("1d, 12.1");

        List<Double> actual = parser.parseCoordinate(strings);

        List<Double> expected = new ArrayList<>();
        expected.add(1.0);
        expected.add(1.0);
        expected.add(10.0);
        expected.add(1.0);
        expected.add(1.0);
        expected.add(-1.0);
        expected.add(2.0);
        expected.add(3.0);
        expected.add(4.0);
        expected.add(2.0);
        expected.add(3.0);
        expected.add(0.1);

        Assert.assertEquals(actual, expected);

    }}
