package com.elgindy.Fitness_App.Data;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.elgindy.Fitness_App.Model.User;


@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDataBase extends RoomDatabase {

    public abstract UserDao getUserDao();

}

