package com.example.dj.roomexample;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by DJ on 20/03/2018.
 */

// Data access object class


@Dao
public interface MyDao {


    @Insert
    public void addUser(User user);


    @Query("select * from users")
    public List<User> getUsers();


    @Delete
    public void deleteUser(User user);


    @Update
    public void updateUser(User user);



}
