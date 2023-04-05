package com.AdoptAFloof.AdoptAFloof.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore; 
import javax.persistence.Column;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="vaccinations")
@Getter
@Setter
public class Vaccinations {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int vaccinationsId;

@Column(name = "vaccination")
private String Vaccination;

@Column(name = "date_of_vaccination")
private String Date;

@ManyToMany(mappedBy = "vaccinations")
@JsonIgnore
    private Set<Available_Floofs>availableFloofs = new HashSet<>();
}
