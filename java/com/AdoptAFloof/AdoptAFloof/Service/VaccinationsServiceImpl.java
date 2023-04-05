package com.AdoptAFloof.AdoptAFloof.Service;

import java.util.List;     
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.AdoptAFloof.AdoptAFloof.Entity.Vaccinations;
import com.AdoptAFloof.AdoptAFloof.Exception.ResourceNotFoundException;
import com.AdoptAFloof.AdoptAFloof.Repository.VR;
@Service
public class VaccinationsServiceImpl implements VaccinationsService {
  private VR vr;//vr = Vaccinations Repository {
  
  @Autowired
  public VaccinationsServiceImpl(VR vr) {
    super();
    this.vr = vr;
  }
  
  //Save Available Floofs
  @Override
  public Vaccinations saveVaccinations(Vaccinations vaccinations) {
    return vr.save(vaccinations);
  }

  //get all available floofs
  @Override
  public List<Vaccinations> getALLAvailable_Vaccinations() {
    return vr.findAll();
  }
  
//Get Vaccinations by ID!
  @Override
  public Vaccinations getAvailable_VaccinationsByID(int id) {
    return vr.findById(id).orElseThrow(() -> 
    new ResourceNotFoundException("Available_Floofs", "ID", id)
        );
  }

  @Override
  public Vaccinations updateVaccinations(Vaccinations available_vaccinations, int Id) {
    Vaccinations existingAvailable_Vaccinations = vr.findById(Id).orElseThrow(() ->
    new ResourceNotFoundException("Available_Floofs", "ID", Id)
        );
    
    existingAvailable_Vaccinations.setVaccination(available_vaccinations.getVaccination());
    existingAvailable_Vaccinations.setDate(available_vaccinations.getDate());
    
    vr.save(existingAvailable_Vaccinations);
    return existingAvailable_Vaccinations;
    }
  
  @Override
  public void deleteAvailable_Vaccinations(int Id) {
    Vaccinations existingAvailable_Vaccinations = vr.findById(Id).orElseThrow(() ->
    new ResourceNotFoundException("Available_Vaccinations", "ID", Id)
        );
    vr.delete(existingAvailable_Vaccinations);
    }
  }
  

