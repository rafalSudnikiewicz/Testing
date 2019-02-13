package pl.sda.advanced;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import pl.sda.advanced.users.Sex;
import pl.sda.advanced.users.User;
import pl.sda.advanced.users.UserInMemoryDatabase;
import pl.sda.advanced.users.UserService;

import java.util.Optional;

import static org.mockito.Mockito.*;

import static org.junit.Assert.assertEquals;
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTests {

    UserService userService;

    @Mock
    UserInMemoryDatabase database;

    @Before
    public void setUp(){
        userService = new UserService(database);
    }

    @Test
    public void ifUserDoesntExistHeCanBeRegistered(){
        //Given
        when(database.getByEmail("ferdinando@gmail.com")).thenReturn(Optional.empty());
        //When
        userService.register("Ferdek","ferdinando@gmail.com","1234",55, Sex.MALE);

        //Then
        verify(database,times(1)).add(any());
    }

    @Test
    public void ifUserExistsCannotBeRegistered(){
        //Given
        when(database.getByEmail("ferdinando@gmail.com")).thenReturn(Optional.empty());
        //When
        userService.register("Ferdek","ferdinando@gmail.com","1234",55, Sex.MALE);

        //Then
        verify(database,times(1)).add(any());
    }


}

