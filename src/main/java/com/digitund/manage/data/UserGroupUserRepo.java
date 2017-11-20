package com.digitund.manage.data;

import com.digitund.manage.model.UserGroupUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGroupUserRepo extends JpaRepository<UserGroupUser, Long>{
	
}
