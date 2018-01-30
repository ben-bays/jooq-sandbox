package com.p202.jsx.user.dao;

import com.p202.jsx.jooq.iam.tables.records.UserRecord;

import java.util.List;

public interface UserDao {

    /**
     * Lookup a {@link UserRecord} by the primary key
     */
    UserRecord getUser(final long userId);

    /**
     * Retrieve all {@link UserRecord}s in the system.
     */
    List<UserRecord> getUsers();
}
