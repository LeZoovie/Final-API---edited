package com.AdoptAFloof.AdoptAFloof.Service;

import java.util.List;      
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.AdoptAFloof.AdoptAFloof.Entity.Adoptee;
import com.AdoptAFloof.AdoptAFloof.Exception.ResourceNotFoundException;
import com.AdoptAFloof.AdoptAFloof.Repository.AR;

@Service
public class AdopteeServiceImpl implements AdopteeService {
  private AR ar;//vr = Vaccinations Repository {
  @Autowired
  public AdopteeServiceImpl(AR ar) {
    super();
    this.ar = ar;
  }
  
  //Save Adoptee
  @Override
  public Adoptee saveAdoptee(Adoptee adoptee) {
    return ar.save(adoptee);
  }

  //get all adoptee's
  @Override
  public List<Adoptee> getALLAvailable_Adoptee() {
    return ar.findAll();
  }
  
//Get Adoptee by ID!
  @Override
  public Adoptee getAvailable_AdopteeByID(int id) {
    return ar.findById(id).orElseThrow(() -> 
    new ResourceNotFoundException("Available_Floofs", "ID", id)
        );
  }

  @Override
  public Adoptee updateAdoptee(Adoptee available_adoptee, int Id) {
    Adoptee existingAvailable_Adoptee = ar.findById(Id).orElseThrow(() ->
    new ResourceNotFoundException("Available_Floofs", "ID", Id)
        );
    
    existingAvailable_Adoptee.setAdoptee(available_adoptee.getAdoptee());
    existingAvailable_Adoptee.setDate(available_adoptee.getDate());
    existingAvailable_Adoptee.setAvailable_floofs(available_adoptee.getAvailable_floofs());
    
    ar.save(existingAvailable_Adoptee);
    return existingAvailable_Adoptee;
    }
  
  @Override
  public void deleteAvailable_Adoptee(int Id) {
    Adoptee existingAvailable_Vaccinations = ar.findById(Id).orElseThrow(() ->
    new ResourceNotFoundException("Available_Vaccinations", "ID", Id)
        );
    ar.delete(existingAvailable_Vaccinations);
    }
}


