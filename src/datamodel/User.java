package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id  // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id") // specify the column name. Without it, it will use method name
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private Integer age;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "history1")
	private Integer history1;
	
	@Column(name = "history2")
	private Integer history2;
	
	@Column(name = "history3")
	private Integer history3;
	
	public User()
	{
	}

	public User(Integer id, String name, Integer age, String gender, String email, String address) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.address = address;
	}

	public User(String name, Integer age, String gender, String email, String address) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.address = address;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public Integer getHistory1() {
		return history1;
	}

	public void setHistory1(Integer history1) {
		this.history1 = history1;
	}
	
	public Integer getHistory2() {
		return history2;
	}

	public void setHistory2(Integer history2) {
		this.history2 = history2;
	}
	
	public Integer getHistory3() {
		return history3;
	}

	public void setHistory3(Integer history3) {
		this.history3 = history3;
	}
	

	@Override
	public String toString() {
		return "Employee: " + this.id + ", " + this.name + ", " + this.age;
	}
}