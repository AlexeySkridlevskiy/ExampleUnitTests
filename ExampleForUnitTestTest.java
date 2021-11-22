package com.example.onlinetestsservice.models;

import com.example.onlinetestsservice.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.mockito.junit.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.assertj.core.api.Assertions.*;
class ExampleForUnitTestTest {

    @Mock
    private exampleUI uiMock;
    @Mock
    private UserRepository repositoryMock;

    @InjectMocks
    private ExampleForUnitTest classUnderTest;

//    @Rule
//    public MockitoRule rule = MockitoJUnit.rule();

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void letsCheckNameLength() {
        User user = new User("1", "1");
        Optional<User> optionalUser = Optional.of(user);
        when(repositoryMock.findByName(Mockito.any())).thenReturn(optionalUser);

        boolean actualResult = classUnderTest.update("1", "Ag");

        assertFalse(actualResult); //assertThat(actualResult).isTrue();
        verify(uiMock).showErrors(Mockito.any());
    }

    @Test
    void nameMustNotAdmin(){
    }

    @Test
    void mustNotUpdateIfUserNotExist(){
    }

    @Test
    void mustUpdateUserIfUserExistsNameIsCorrect(){
    }
}