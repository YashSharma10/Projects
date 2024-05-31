package org.ncu.healthcare;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ncu.healthcare.entity.User;
import org.ncu.healthcare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @BeforeEach
    public void setUp() {
        // Clean up database before each test
        userService.findAll().forEach(user -> userService.delete(user));
    }

    @Test
    public void testSaveUser() {
        User user = UserTestUtils.generateRandomUser();
        userService.save(user);

        Optional<User> retrievedUser = Optional.ofNullable(userService.findById(user.getUserId()));
        assertTrue(retrievedUser.isPresent());
        assertEquals(user.getUsername(), retrievedUser.get().getUsername());
    }

    @Test
    public void testFindAllUsers() {
        User user1 = UserTestUtils.generateRandomUser();
        User user2 = UserTestUtils.generateRandomUser();
        userService.save(user1);
        userService.save(user2);

        List<User> users = userService.findAll();
        assertEquals(2, users.size());
    }

    @Test
    public void testFindUserById() {
        User user = UserTestUtils.generateRandomUser();
        userService.save(user);

        User retrievedUser = userService.findById(user.getUserId());
        assertNotNull(retrievedUser);
        assertEquals(user.getUsername(), retrievedUser.getUsername());
    }

    @Test
    public void testUpdateUser() {
        User user = UserTestUtils.generateRandomUser();
        userService.save(user);

        user.setUsername("updatedUsername");
        userService.update(user);

        User updatedUser = userService.findById(user.getUserId());
        assertNotNull(updatedUser);
        assertEquals("updatedUsername", updatedUser.getUsername());
    }

    @Test
    public void testDeleteUser() {
        User user = UserTestUtils.generateRandomUser();
        userService.save(user);

        userService.delete(user);
        User deletedUser = userService.findById(user.getUserId());
        assertNull(deletedUser);
    }
}
