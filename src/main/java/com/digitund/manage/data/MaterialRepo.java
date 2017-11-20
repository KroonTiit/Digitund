package com.digitund.manage.data;

import java.util.List;

import com.digitund.manage.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

	@Repository
	public interface MaterialRepo extends JpaRepository<Material, Long>{
		
		@Query("select s from Material s where s.compMaterialId like ?1 ")
		List<Material> findByCompId(long compId);
	}
