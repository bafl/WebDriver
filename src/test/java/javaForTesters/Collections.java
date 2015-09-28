package javaForTesters;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * WebDriver
 * Created by Bartek on 23.08.2015.
 */
public class Collections {

    @Test
    public void usersTest() {
        Collection<User> users = new <User>ArrayList();
        Assert.assertEquals(0, users.size());
        Assert.assertTrue(users.isEmpty());

        User bafl = new User();
        User jost = new User();

        users.add(bafl);
        users.add(jost);

        Assert.assertEquals(2, users.size());
        Assert.assertFalse(users.isEmpty());

        Collection<User> anotherUsers = new ArrayList<>();
        User secBafl = new User();
        User secJost = new User();

        anotherUsers.add(secBafl);
        anotherUsers.add(secJost);

        users.addAll(anotherUsers);

        Assert.assertTrue(users.containsAll(anotherUsers));

        for (User asd : users){
            System.out.println(asd);
        }
        users.removeAll(anotherUsers);
        System.out.println(anotherUsers);
        System.out.println(users);

        Collection<String> duplicateTest = new ArrayList<>();
        duplicateTest.add("as");
        duplicateTest.add("as");
        System.out.println(duplicateTest);
    }

}
