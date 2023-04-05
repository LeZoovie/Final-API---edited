package com.AdoptAFloof.AdoptAFloof.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.AdoptAFloof.AdoptAFloof.Entity.Available_Floofs;

@Repository
public interface FR extends JpaRepository<Available_Floofs, Integer> {
  

}
