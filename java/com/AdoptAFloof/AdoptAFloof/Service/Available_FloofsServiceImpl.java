package com.AdoptAFloof.AdoptAFloof.Service;

import java.util.List;   
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.AdoptAFloof.AdoptAFloof.Entity.Available_Floofs;
import com.AdoptAFloof.AdoptAFloof.Exception.ResourceNotFoundException;
import com.AdoptAFloof.AdoptAFloof.Repository.FR;

@Service
public class Available_FloofsServiceImpl implements Available_FloofsService {
  private FR fr;//fr = Floof Repository
  
  @Autowired
  public Available_FloofsServiceImpl(FR fr) {
    super();
    this.fr = fr;
  }
  
  //Save Available Floofs
  @Override
  public Available_Floofs saveAvailable_Floofs(Available_Floofs available_floofs) {
    return fr.save(available_floofs);
  }

  //get all available floofs
  @Override
  public List<Available_Floofs> getALLAvailable_Floofs() {
    return fr.findAll();
  }
//Get floof by ID!
  @Override
  public Available_Floofs getAvailable_FloofsByID(int id) {
    return fr.findById(id).orElseThrow(() -> 
    new ResourceNotFoundException("Available_Floofs", "ID", id)
        );
  }

  @Override
  public Available_Floofs updateAvailable_Floofs(Available_Floofs available_floofs, int Id) {
    Available_Floofs existingAvailable_Floofs = fr.findById(Id).orElseThrow(() ->
    new ResourceNotFoundException("Available_Floofs", "ID", Id));
    
    existingAvailable_Floofs.setName(available_floofs.getName());
    existingAvailable_Floofs.setAge(available_floofs.getAge());
    existingAvailable_Floofs.setTemperament(available_floofs.getTemperament());
    existingAvailable_Floofs.setVaccinations(available_floofs.getVaccinations());
    existingAvailable_Floofs.setAdoptee(available_floofs.getAdoptee());
    
    fr.save(existingAvailable_Floofs);
    return existingAvailable_Floofs;
  }
  @Override
  public void deleteAvailable_Floofs(int Id) {
    Available_Floofs existingAvailable_Floofs = fr.findById(Id).orElseThrow(() ->
    new ResourceNotFoundException("Available_Floofs", "ID", Id)
        );
    fr.delete(existingAvailable_Floofs);
  }
  }