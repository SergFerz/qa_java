package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class FelineTest {

    private Feline feline;

    private final int expectedKittens;
    private final int countKittens;

    public FelineTest(int expectedKittens, int countKittens) {
        this.expectedKittens = expectedKittens;
        this.countKittens = countKittens;
    }

    @Before
    public void init() {
        feline = new Feline();
    }

    @Test
    public void eatMeatTest() throws Exception {
        List<String> expectedLionTypeOfFood = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actualLionTypeOfFood = feline.eatMeat();
        Assert.assertEquals(expectedLionTypeOfFood, actualLionTypeOfFood);
    }

    @Test
    public void getFamilyTest() {
        String expectedString = "Кошачьи";
        Assert.assertEquals(expectedString, feline.getFamily());
    }

    @Test
    public void getKittensWithoutParameterTest() {
        int expectedKittens = 1;
        Assert.assertEquals(expectedKittens, feline.getKittens());
    }

    @Parameterized.Parameters
    public static Object[][] gatParameters() {
        return new Object[][] {
                {0, 0},
                {1, 1},
                {2, 2}
        };
    }

    @Test
    public void getKittensWithParameterTest() {
        int actualKittens = feline.getKittens(countKittens);
        Assert.assertEquals(expectedKittens, actualKittens);
    }
}