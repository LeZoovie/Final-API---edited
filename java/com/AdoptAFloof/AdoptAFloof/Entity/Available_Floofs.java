package com.AdoptAFloof.AdoptAFloof.Entity;

import javax.persistence.Column;   
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="available_floofs")
@Getter
@Setter
public class Available_Floofs {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "available_floofs_id")
  private int availableFloofsId;
  
 @Column(name = "age_of_cat")
  private int age;
  
  @Column(name = "name")
  private String name;
  
  @Column(name = "cats_temperament")
  private String Temperament;
  
  @ManyToMany
  @JoinTable(name = "available_floofs_vaccinations",
      joinColumns=@JoinColumn(name = "available_floofs_id"),
      inverseJoinColumns=@JoinColumn(name = "vaccinations_id"))
  private Set<Vaccinations>vaccinations = new HashSet<>();
  
  @OneToMany(mappedBy = "available_floofs")
  @JsonIgnore
      private Set<Adoptee>adoptee = new HashSet<>();
}
