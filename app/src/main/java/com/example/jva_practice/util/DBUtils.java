package com.example.jva_practice.util;

import com.example.jva_practice.data.Users;
import com.example.jva_practice.db.MainTable;

import java.util.ArrayList;
import java.util.List;

public class DBUtils {
    public static MainTable toMainTable(Users users) {
        MainTable mainTable =
                new MainTable(users.getName(),
                        users.getUsername(),
                        users.getEmail(),
                        users.getPhone(),
                        users.getWebsite());
        return mainTable;
    }

    public static List<MainTable> toMainTableList(List<Users> usersList) {
        List<MainTable> tableList = new ArrayList<>();
        for (Users users : usersList) {
            tableList.add(toMainTable(users));
        }
        return tableList;
    }
}
