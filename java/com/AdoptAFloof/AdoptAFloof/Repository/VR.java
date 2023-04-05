package com.AdoptAFloof.AdoptAFloof.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.AdoptAFloof.AdoptAFloof.Entity.Vaccinations;

@Repository
public interface VR extends JpaRepository<Vaccinations, Integer>{

}
