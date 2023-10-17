package fa.training.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import fa.training.utils.Validator;

@Entity
@Table(name = "student")
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "student_id")
	@NotNull(message = "is require")
	@Pattern(regexp = Validator.VALID_STUDENT_ID_REGEX, message = "Student Id: 6 digits")
	private String id;

	@Column(name = "student_name")
	@NotNull(message = "is require")
	private String name;

	@Column(name = "phone")
	@Pattern(regexp = Validator.VALID_PHONE_REGEX, message = "Phone: must be at least 10 digits")
	@NotNull(message = "is require")
	private String phone;
	@Column(name = "gender")
	@NotNull(message = "is require")
	private String gender;

	@Column(name = "gpa")
	@Min(value = 0, message = "must be greater than or equal to zero")
	@Max(value = 10, message = "must be less than or equal to 10")
	private double gpa;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id", referencedColumnName = "course_id")
	private Course course;

	public Student() {
	}

	public Student(String name, String phone, String gender, String id, double gpa) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.gender = gender;
		this.gpa = gpa;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return String.format("Student [id=%, name=%, phone=%, gender=%, gpa=%]", id, name, phone, gender, gpa);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
