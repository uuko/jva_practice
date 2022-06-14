package com.example.jva_practice.db;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface UserDbDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public Completable insertAll(List<UserTable> users);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public Completable insertAllPrivateData(List<UserTable> friends);

    @Delete
    public Completable deleteAll(List<UserTable> userTables);

    @Query("DELETE FROM UserTable")
    public void deleteAll();

    @Delete
    Completable deletePrivateDatas(List<UserTable> photoEntityList);

    @Delete
    public Completable deleteUsers(UserTable... users);

    @Query("SELECT * FROM UserTable")
    Single<List<UserTable>> getAll();

    @Query("DELETE FROM UserTable WHERE id = :id")
    public Completable deleteAlertByUserId(String id);
    @Query("SELECT * FROM UserTable WHERE id = :qbeeId " )
    Single<List<UserTable>> loadAllSharedDataByQbeeID(int qbeeId);
//    @Query("SELECT * FROM PRIVATE_ENTITY")
//    Single<List<PhotoEntity>> loadAllPrivateData();
//    @Query("SELECT * FROM PRIVATE_ENTITY WHERE folder_content =(:folder_content) AND " + "item_id = (:item_id) LIMIT 1")
//    Flowable<PhotoEntity> findOneUserNam(String folder_content,String item_id);
}