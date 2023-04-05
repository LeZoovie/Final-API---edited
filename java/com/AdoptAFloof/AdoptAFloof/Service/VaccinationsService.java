package com.AdoptAFloof.AdoptAFloof.Service;

import java.util.List;
import com.AdoptAFloof.AdoptAFloof.Entity.Vaccinations;

public interface VaccinationsService {

  
  //Creating or Posting Vaccinations 
  Vaccinations saveVaccinations(Vaccinations available_vaccinations);
  
//GET all of the Vaccinations
  List<Vaccinations>getALLAvailable_Vaccinations();
  
//GET a Vaccination by ID!
  Vaccinations getAvailable_VaccinationsByID(int id);
  
//UPDATE Vaccination
  Vaccinations updateVaccinations(Vaccinations available_vaccinations, int Id);

//Deleting Vaccination
void deleteAvailable_Vaccinations(int Id);

}

