package com.AdoptAFloof.AdoptAFloof.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="adoptee")
@Getter
@Setter
public class Adoptee {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "adoptee_id")
  private int adopteeId;
  

  @Column(name = "name_of_adoptee")
  private String Adoptee;

  @Column(name = "date_of_adoption")
  private String Date;

  @ManyToOne
      @JoinColumn(name = "available_floofs_id")
 
 private Available_Floofs available_floofs;

  }