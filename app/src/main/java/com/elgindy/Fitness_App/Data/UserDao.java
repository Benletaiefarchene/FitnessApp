package com.elgindy.Fitness_App.Data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.elgindy.Fitness_App.Model.User;


@Dao
public interface UserDao {
    @Query("SELECT * FROM User where userName= :username and password= :password")
    User getUser(String username, String password);

    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);
}
