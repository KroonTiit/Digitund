package com.digitund.manage.data;

import com.digitund.manage.model.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGroupRepo extends JpaRepository<UserGroup, Long> {

}
