package pl.dmuszynski.accountservice;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import pl.dmuszynski.accountservice.domain.User;

/**
 * Unit test for simple App.
 */
public class AccountServiceApplicationTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void userCreateTest(){
        User user = new User.Builder(1,"das", "dasd","dad")
                .build();

        System.out.println(user);
    }
}
