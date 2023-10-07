package com.entity;

public class leader {

	protected int id;
	private String Name;

	private String email;
	private String Phonenumber;
	private String password;

	public leader() {
		super();
		// TODO Auto-generated constructor stub
	}
//select e1.*, e2.empname as leader name  from emp as e1 , emp as e2  where e1.emp_leader_id=XYZ and e1.emp_id=e2.emp_id
	public leader(String Name,  String email, String Phonenumber,
			String password) {
		super();
		this.Name = Name;
		this.email = email;
		this.Phonenumber = Phonenumber;
		this.password = password;
	}

//	public leader(int id, String Name, String email,
//			String Phonenumber, String password) {
//		super();
//		this.id = id;
//		this.Name = Name;
//		this.email = email;
//		this.Phonenumber = Phonenumber;
//		this.password = password;
//	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return Phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		Phonenumber = phonenumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}
