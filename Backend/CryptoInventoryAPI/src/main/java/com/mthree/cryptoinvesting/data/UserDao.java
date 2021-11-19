package com.mthree.cryptoinvesting.data;

import com.mthree.cryptoinvesting.model.Users;

import java.util.List;

/**
 * @author Kristi
 * @version 11/19/2021
 */
public interface UserDao {

    /**
     * Adds a new user to the table with all fields when they sign up.
     * @param user The user to be added to the database.
     * @return The user that was added.
     */
    Users addUser(Users user);

    /**
     * Returns a list of all users in the system.
     * @return List of all users in the database.
     */
    List<Users> getAllUsers();

    /**
     * Retruns a specific user based on their unique user id.
     * @param userId The unique id of the specified user.
     * @return The user based on its specific id.
     */
    Users getUserById(int userId);

}
