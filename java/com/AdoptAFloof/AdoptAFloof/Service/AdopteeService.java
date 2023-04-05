package com.AdoptAFloof.AdoptAFloof.Service;

import java.util.List;
import com.AdoptAFloof.AdoptAFloof.Entity.Adoptee;

public interface AdopteeService {

 //Creating or Posting Adoptee
  Adoptee saveAdoptee(Adoptee available_Adoptee);
  
//GET all of the Adoptees
  List<Adoptee>getALLAvailable_Adoptee();
  
//GET a Adoptee by ID!
  Adoptee getAvailable_AdopteeByID(int id);
  
//UPDATE Adoptee
  Adoptee updateAdoptee(Adoptee available_Adoptee, int Id);

//Deleting Adoptee
void deleteAvailable_Adoptee(int Id);
}
