package com.example.jva_practice.util;

import com.example.jva_practice.data.Users;
import com.example.jva_practice.db.UserTable;

import java.util.ArrayList;
import java.util.List;

public class DBUtils {
    public static UserTable toMainTable(Users users) {
        UserTable mainTable =
                new UserTable(users.getName(),
                        users.getUsername(),
                        users.getEmail(),
                        users.getPhone(),
                        users.getWebsite());
        return mainTable;
    }
    public static Users toUsers(UserTable users) {
        Users mainTable =
                new Users(users.getName(),
                        users.getUsername(),
                        users.getEmail(),
                        users.getPhone(),
                        users.getWebsite());
        return mainTable;
    }

    public static List<UserTable> toUserTableList(List<Users> usersList) {
        List<UserTable> tableList = new ArrayList<>();
        for (Users users : usersList) {
            tableList.add(toMainTable(users));
        }
        return tableList;
    }

    public static List<Users> toUsersList(List<UserTable> usersList) {
        List<Users> tableList = new ArrayList<>();
        for (UserTable users : usersList) {
            tableList.add(toUsers(users));
        }
        return tableList;
    }
    public static List<?> entityToList(List<?> usersList) {
        List<UserTable> tableList = new ArrayList<>();
        for (Object users : usersList) {
            if (users instanceof Users)
                tableList.add(toMainTable((Users) users));
        }
        return tableList;
    }
}
