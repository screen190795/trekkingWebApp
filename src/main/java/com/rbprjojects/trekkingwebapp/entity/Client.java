
  package com.rbprjojects.trekkingwebapp.entity;
  
  

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column; import javax.persistence.Entity; import
  javax.persistence.GeneratedValue; import javax.persistence.GenerationType;
  import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
  import javax.persistence.Table;
  
  @Entity
  
  @Table(name = "Client") public class Client {
  
  @Id
  
  @GeneratedValue(strategy = GenerationType.AUTO) private long id;
  
  @NotBlank(message = "First Name is mandatory")
  
  @Column(name="FirstName", length = 128) private String firstName;
  
  @NotBlank(message = "Last Name is mandatory")
  
  @Column(name="LastName", length = 128) private String lastName;
  
  @NotBlank
  
  @Column(name="MiddleName", length = 128) private String middleName;
  
  @Column(name="Age") private Integer age;
  
  //@Column(name="Sex") //private ENUM sex;
  
  @Column(name="Description", length =128) private String description;
  
  
  
  public Client() { }
  
  public long getId() { return id; }
  
  public void setId(long id) { this.id = id; }
  
  public String getFirstName() { return firstName; }
  
  public void setFirstName(String firstName) { this.firstName = firstName; }
  
  public String getLastName() { return lastName; }
  
  public void setLastName(String lastName) { this.lastName = lastName; }
  
  public String getMiddleName() { return middleName; }
  
  public void setMiddleName(String middleName) { this.middleName = middleName;
  }
  
  public Integer getAge() { return age; }
  
  public void setAge(Integer age) { this.age = age; }
  
  public String getDescription() { return description; }
  
  public void setDescription(String description) { this.description =
  description; }
  
  @Override public String toString() { return "Client [id=" + id +
  ", firstName=" + firstName + ", lastName=" + lastName + ", middleName=" +
  middleName + ", age=" + age + ", description=" + description + "]"; }
  
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable
  private Set<Route> routes;
  }
 