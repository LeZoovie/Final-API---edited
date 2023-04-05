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
import com.AdoptAFloof.AdoptAFloof.Entity.Vaccinations;
import com.AdoptAFloof.AdoptAFloof.Service.VaccinationsService;

@RestController
@RequestMapping("/Vaccinations")
public class VaccinationsController {

  private VaccinationsService Service;
  @Autowired
  public VaccinationsController(VaccinationsService Service) {
    super();
    this.Service = Service;
  }
  //This is Creating or Posting a new Floof!
  @PostMapping()
  public ResponseEntity<Vaccinations> saveFloof(@RequestBody Vaccinations vaccinations){
    return new ResponseEntity<Vaccinations>(Service.saveVaccinations(vaccinations),
        HttpStatus.CREATED);
  }
  
  //GETTING all available floofs
  @GetMapping
  public List<Vaccinations> getAllAvailable_Floofs(){
    return Service.getALLAvailable_Vaccinations();
  }
  
  @GetMapping("{vaccinations_id}")
  public ResponseEntity<Vaccinations> getAvailable_FloofsByID(@PathVariable("vaccinations_id") int available_floofsId){
    return new ResponseEntity<Vaccinations>(Service.getAvailable_VaccinationsByID(available_floofsId), HttpStatus.CREATED);
  }
  
  @PutMapping("{vaccinations_id}")
  //Updating our available_Floofs
  public ResponseEntity<Vaccinations> updateAvailable_Floofs(@PathVariable("vaccinations_id") int available_floofsId,
  @RequestBody Vaccinations available_floofs){ //change to vaccinations V
    return new ResponseEntity<Vaccinations>(Service.updateVaccinations(available_floofs, available_floofsId), HttpStatus.OK);
  }
  
  //deleting available_floof
  @DeleteMapping("{vaccinations_id}")
  public ResponseEntity<String> deleteAvailable_Floofs(@PathVariable("vaccinations_id") int available_floofsId){
    Service.deleteAvailable_Vaccinations(available_floofsId);
    return new ResponseEntity<String>("Available_Floof has been adopted :) ", HttpStatus.OK);
  }
}


