package javaForTesters;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * WebDriver
 * Created by Bartek on 23.08.2015.
 */
public class Lists {

    @Test
    public void listTest() {
        List<String> days = new ArrayList<>();
        days.add(0, "Pon");
        print(days);
        days.add("Wt");
        print(days);
        Assert.assertEquals("Wt", days.get(1));
        days.add("Śr");
        days.add(0, "Do usunięcia");
        print(days);
        days.remove(0);
        print(days);

        Assert.assertEquals(1, days.indexOf("Wt"));

        days.set(1, "new");
        Assert.assertEquals("new", days.get(1));
        print(days);
        days.remove("new");
        print(days);
    }

    @Test
    public void listExercise() {
        List<User> listOfUsers = new ArrayList<>();
        User bafl = new User();
        User jost = new User();

        listOfUsers.add(bafl);
        listOfUsers.add(jost);
    }

    public void print(Object input) {
        System.out.println(input.toString());
    }
}
