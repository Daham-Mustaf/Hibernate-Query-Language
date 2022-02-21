package main.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee_tab")
@ToString
public class Employee {

	@Id
	@Column(name="employee_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer employeeId;
	
	@Column(name="employee_name",length=60,nullable=false)
	private String employeeName;
	
	@Column(name="date_of_joining")
	private Date doj;
	
	@Column(name="salary")
	private Double salary;
	
	@Column(name="bonus")
	private BigDecimal bonus;
	
	@Column(name="designation",length=50)
	private String designation;
	
	@Column(name="email",unique=true,length=50)
	private String email;
	
}