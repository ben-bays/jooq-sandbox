package com.p202.jsx.user.dao.impl;

import com.p202.jsx.jooq.iam.tables.User;
import com.p202.jsx.jooq.iam.tables.records.UserRecord;
import com.p202.jsx.user.dao.UserDao;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final DSLContext create;

    @Autowired
    public UserDaoImpl(final DSLContext create) {
        this.create = create;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord getUser(final long userId) {
        return create
                .selectFrom(User.USER)
                .where(User.USER.ID.eq(userId))
                .fetchOne()
                .into(UserRecord.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UserRecord> getUsers() {
        return new ArrayList<>(create.selectFrom(User.USER).fetch());
    }
}
