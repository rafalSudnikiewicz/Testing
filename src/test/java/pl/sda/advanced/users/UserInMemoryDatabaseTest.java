package pl.sda.advanced.users;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import sun.plugin.dom.exception.InvalidStateException;

import java.util.Optional;

import static org.junit.Assert.*;

public class UserInMemoryDatabaseTest {

    private UserInMemoryDatabase database;
    private User user = new User("Ferdek", "1234", "ferdinando@gmail.com", 52, Sex.MALE);
    private User user2 = new User("Marian", "1111", "mariano@gmail.com", 54, Sex.MALE);

    @Before
    public void setUp() {
        database = new UserInMemoryDatabase();
//        user = new User("Ferdek", "1234", "ferdinando@gmail.com", 52, Sex.MALE);
//        user2 = new User("Marian", "1111", "mariano@gmail.com", 54, Sex.MALE);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void constructorTest() {
        assertEquals(0, database.getUsersCount());
    }

//////////////////////Testing method add()//////////////////////////////////////////////////////////

    @Test
    public void addingNewUserShouldGiveTotalNumberOf1Users() {
        //When
        database.add(user);
        //Then
        assertEquals(1, database.getUsersCount());
    }

    @Test
    public void addingNewUserShouldGiveTotalNumberOfUsersDifferentOf2() {
        //When
        database.add(user);
        //Then
        assertNotEquals(2, database.getUsersCount());
    }

    @Test//(expected = InvalidStateException.class)
    public void adding2TimesTheSameNewUserShouldThrowException() {
        //When
        expectedException.expect(InvalidStateException.class);
        expectedException.expectMessage("User already exists");
        database.add(user);
        database.add(user);
        //Then

    }

    @Test
    public void addingNullUserShouldGiveTotalNumberOf0Users() {
        //When
        database.add(null);
        //Then
        assertEquals(0, database.getUsersCount());
    }

//////////////////////Testing method getByID()//////////////////////////////////////////////////////////

    @Test
    public void gettingByIDShouldGiveProperUser() {
        //When

        database.add(user);
        //Then
        assertEquals(user, database.getById(user.getId()));
    }

    @Test
    public void gettingByIDShouldNotGiveDifferentUser() {
        //When
        database.add(user);
        //Then
        assertNotEquals(user2, database.getById(user.getId()));
    }

    @Test(expected = InvalidStateException.class)
    public void gettingByIDShouldTrhowExceptionWhenUserNotFound() {

        //Then
        database.getById(user.getId());
    }
//////////////////////Testing method getByEmail()//////////////////////////////////////////////////////////

    @Test
    public void gettingByEmailShouldGiveProperUser() {
        //When
        database.add(user);
        //Then
        assertEquals(user, database.getByEmail(user.getEmail()).get());
    }

    @Test
    public void gettingByEmailShouldNotGiveDifferentUser() {
        //When
        database.add(user);
        //Then
        assertNotEquals(user2, database.getByEmail(user.getEmail()).get());
    }

    @Test
    public void gettingByEmailShouldGiveOptionalEmptyWhenUserNotFound() {
        //When
        database.add(user);
        //Then
        assertEquals(Optional.empty(), database.getByEmail(user2.getEmail()));
    }
}