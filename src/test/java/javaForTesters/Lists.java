package javaForTesters;

import com.qcadoo.selenium.navigation.LogInTest;
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
        List<String> days = new ArrayList<String>();
        days.add(0, "Pon");
        LogInTest.print(days);
        days.add("Wt");
        LogInTest.print(days);
        Assert.assertEquals("Wt", days.get(1));
        days.add("Śr");
        days.add(0, "Do usunięcia");
        LogInTest.print(days);
        days.remove(0);
        LogInTest.print(days);

        Assert.assertEquals(1, days.indexOf("Wt"));

        days.set(1, "new");
        Assert.assertEquals("new", days.get(1));
        LogInTest.print(days);
        days.remove("new");
        LogInTest.print(days);


    }

    @Test
    public void listExercise(){
        List<User> listOfUsers = new ArrayList<User>();
        User bafl = new User();
        User jost = new User();

        listOfUsers.add(bafl);
        listOfUsers.add(jost);


    }

}
