package com.example.jva_practice.db.post;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

import com.example.jva_practice.db.UserTable;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Maybe;

@Dao
public interface PostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public Completable insertAll(List<PostTable> users);

    @RawQuery
    Maybe<List<PostTable>> rawQuery(SupportSQLiteQuery query);

    @Delete
    Completable deleteAll(List<PostTable> users);

    @Query("delete from posts where pkId in (:pkid)")
    Completable deleteAllById(List<Integer> pkid);
}
