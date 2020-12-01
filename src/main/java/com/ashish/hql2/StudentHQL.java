package com.ashish.hql2;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

@Entity(name = "Student_HQL")
@Table(name = "Student_HQL")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class StudentHQL {

	@Id
	private int rollNo;
	
	private String studentName;
	
	private double studentMarks;

	public StudentHQL() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentHQL(int rollNo, String studentName, double studentMarks) {
		super();
		this.rollNo = rollNo;
		this.studentName = studentName;
		this.studentMarks = studentMarks;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public double getStudentMarks() {
		return studentMarks;
	}

	public void setStudentMarks(double studentMarks) {
		this.studentMarks = studentMarks;
	}

	@Override
	public String toString() {
		return "StudentHQL [rollNo=" + rollNo + ", studentName=" + studentName + ", studentMarks=" + studentMarks + "]";
	}
	
	
	
}
