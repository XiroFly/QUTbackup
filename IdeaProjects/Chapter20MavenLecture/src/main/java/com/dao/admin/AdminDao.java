package com.dao.admin;

import com.po.AUser;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao {
    Integer findAUserCount(AUser aUser);
}
