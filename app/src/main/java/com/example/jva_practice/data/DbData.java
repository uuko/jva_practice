package com.example.jva_practice.data;

import com.example.jva_practice.App;
import com.example.jva_practice.db.MainDBDataBase;
import com.example.jva_practice.db.UserTable;

public class DbData {
    static MainDBDataBase db= App.getMainDatabase();

   public static DataSource<?> of(Class<?> classZ)  {
       if (classZ.isAssignableFrom(UserTable.class)){
            return new UserDbData(db.userDbDao());
       }
       else
           throw new IllegalArgumentException("Unsupported data type");
   }

   public static void clearDb(){
       db.clearAllTables();
   }
}
