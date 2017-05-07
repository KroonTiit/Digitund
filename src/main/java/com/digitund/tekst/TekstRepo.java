package com.digitund.tekst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TekstRepo extends JpaRepository<Tekst, Long>{
}
