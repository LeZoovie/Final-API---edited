package com.AdoptAFloof.AdoptAFloof.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.AdoptAFloof.AdoptAFloof.Entity.Adoptee;
import com.AdoptAFloof.AdoptAFloof.Service.AdopteeService;

@RestController
@RequestMapping("/Adoptee")

public class AdopteeController {

  private AdopteeService Service;
  @Autowired
  public AdopteeController(AdopteeService Service) {
    super();
    this.Service = Service;
  }
  //This is Creating or Posting a new Adoptee
  @PostMapping()
  public ResponseEntity<Adoptee> saveFloof(@RequestBody Adoptee adoptee){
    return new ResponseEntity<Adoptee>(Service.saveAdoptee(adoptee),
        HttpStatus.CREATED);
  }
  
  //GETTING all Adoptees
  @GetMapping
  public List<Adoptee> getAllAvailable_Floofs(){
    return Service.getALLAvailable_Adoptee();
  }
  
  @GetMapping("{adoptee_id}")
  public ResponseEntity<Adoptee> getAvailable_FloofsByID(@PathVariable("adoptee_id") int available_floofsId){
    return new ResponseEntity<Adoptee>(Service.getAvailable_AdopteeByID(available_floofsId), HttpStatus.CREATED);
  }
  
  @PutMapping("{adoptee_id}")
  //Updating our available_Floofs
  public ResponseEntity<Adoptee> updateAvailable_Floofs(@PathVariable("adoptee_id") int available_floofsId,
  @RequestBody Adoptee available_adoptee){ 
    return new ResponseEntity<Adoptee>(Service.updateAdoptee(available_adoptee, available_floofsId), HttpStatus.OK);
  }
  
  //deleting available_floof
  @DeleteMapping("{adoptee_id}")
  public ResponseEntity<String> deleteAvailable_Floofs(@PathVariable("adoptee_id") int available_floofsId){
    Service.deleteAvailable_Adoptee(available_floofsId);
    return new ResponseEntity<String>("Available_Floof has been adopted :) ", HttpStatus.OK);
  }
}

