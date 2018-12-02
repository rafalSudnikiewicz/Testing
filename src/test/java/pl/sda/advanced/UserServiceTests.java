package pl.sda.advanced;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import pl.sda.advanced.users.UserInMemoryDatabase;
import pl.sda.advanced.users.UserService;
import static org.junit.Assert.assertEquals;

public class UserServiceTests {
    private UserInMemoryDatabase userInMemoryDatabase;
    private UserService userService;

    @Before
    public void setUp() throws Exception {
        userInMemoryDatabase = Mockito.mock(UserInMemoryDatabase.class);
        userService = new UserService(userInMemoryDatabase);
    }

    @Test
    public void assumptionTest() {
        assertEquals(0, userInMemoryDatabase.getUsersCount());
    }
}

