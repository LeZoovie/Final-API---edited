package com.AdoptAFloof.AdoptAFloof.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.AdoptAFloof.AdoptAFloof.Entity.Adoptee;

@Repository
public interface AR extends JpaRepository<Adoptee, Integer>{ 
}
