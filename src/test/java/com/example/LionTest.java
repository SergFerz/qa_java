package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {

    @Mock
    private Feline feline;
    private final String sex;
    private boolean expectedHasMane;

    public LionTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}, {1}")
    public static Object[][] hasMane() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void doesHaveManeWithParametersOkTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        Assert.assertEquals(expectedHasMane, lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void doesHaveManeWhenWrongParametersGotErrorMessageTest() throws Exception {
        Lion lion = new Lion(" ", feline);
        lion.doesHaveMane();
    }

    @Test
    public void getKittensTest() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion("Самка", feline);
        Assert.assertEquals(1, lion.getKittens());
    }
    @Test
    public void getFoodTest() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion("Самец", feline);
        List<String> expectedLionTypeOfFood = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actualLionTypeOfFood = lion.getFood();
        Assert.assertEquals(expectedLionTypeOfFood, actualLionTypeOfFood);
    }
}