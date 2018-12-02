package pl.sda.advanced;

import org.junit.Before;
import org.junit.Test;
import pl.sda.advanced.users.Sex;
import pl.sda.advanced.users.User;
import pl.sda.advanced.users.UserInMemoryDatabase;
import sun.plugin.dom.exception.InvalidStateException;

import java.util.UUID;

import static org.junit.Assert.*;

public class UserInMemoryDatabaseTests {

    private UserInMemoryDatabase userInMemoryDatabase;

    @Before
    public void setUp() {
        userInMemoryDatabase = new UserInMemoryDatabase();
    }

    @Test
    public void addingOneUserShouldIncreaseTheAmountOfUsers() {
        // Given
        User user = new User("ASD", "sadasdas", "sad@asfaf.pl",
                20, Sex.MALE);


        // When
        userInMemoryDatabase.add(user);

        // Then
        assertEquals(1, userInMemoryDatabase.getUsersCount());
    }

    @Test
    public void addingOneUserShouldIncreaseTheAmountOfUsersNegative() {
        // Given
        userInMemoryDatabase = new UserInMemoryDatabase();
        User user = new User("ASD", "sadasdas", "sad@asfaf.pl",
                20, Sex.MALE);


        // When
        userInMemoryDatabase.add(user);

        // Then
        assertNotEquals(2, userInMemoryDatabase.getUsersCount());
        assertFalse(userInMemoryDatabase.getUsersCount() != 1);
    }

    @Test
    public void inMemoryDatabaseShouldInitiallyBeEmpty() {
        // When
        int currentUsersCount = userInMemoryDatabase.getUsersCount();

        // Then
        assertEquals(0, currentUsersCount);
        assertFalse(userInMemoryDatabase.getUsersCount() != 0);
    }

    @Test
    public void addingShouldNotBePossibleWhenTheUserIsNull() {
        // Given
        User user = null;

        // When
        userInMemoryDatabase.add(user);

        // Then
        assertEquals(0, userInMemoryDatabase.getUsersCount());
    }

    @Test
    public void getByIdShouldReturnGivenUserByItsId() {
        // Given
        User user = new User("ASD", "sadasdas", "sad@asfaf.pl",
                20, Sex.MALE);
        userInMemoryDatabase.add(user);

        // When
        User returnedUser = userInMemoryDatabase.getById(user.getId());

        // Then
        assertSame(user, returnedUser);
        assertEquals(user.getId(), returnedUser.getId());
    }

    @Test(expected = InvalidStateException.class)
    public void ifTheresNoUserWithGivenIdExceptionShouldBeThrown() {
        // Given
        User user = new User("ASD", "sadasdas", "sad@asfaf.pl",
                20, Sex.MALE);
        userInMemoryDatabase.add(user);

        // When
        User returnedUser = userInMemoryDatabase.getById(UUID.randomUUID());

        // Then
        assertNull(returnedUser);
    }
}
