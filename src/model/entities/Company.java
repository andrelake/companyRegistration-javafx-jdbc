package model.entities;

public class Company {

	private Integer id;
	private Integer type;
	private String name;
	private String adress;
	private String city;
	private String phone;
	private String email;
	private String fantasyName;
	private String mainCategory;
	private String nationalId;
	private String legalStatus;
	private Integer totalEmployees;
	private String admName;
	
	public Company() {
	}
	
	public Company(Integer id, Integer type, String name, String adress, String city, String phone, String email,
			String fantasyName, String mainCategory, String nationalId, String legalStatus, Integer totalEmployees,
			String admName) {

		this.id = id;
		this.type = type;
		this.name = name;
		this.adress = adress;
		this.city = city;
		this.phone = phone;
		this.email = email;
		this.fantasyName = fantasyName;
		this.mainCategory = mainCategory;
		this.nationalId = nationalId;
		this.legalStatus = legalStatus;
		this.totalEmployees = totalEmployees;
		this.admName = admName;
	}
	
	public Company(Integer id, Integer type, String name) {
		this.id = id;
		this.type = type;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFantasyName() {
		return fantasyName;
	}

	public void setFantasyName(String fantasyName) {
		this.fantasyName = fantasyName;
	}

	public String getMainCategory() {
		return mainCategory;
	}

	public void setMainCategory(String mainCategory) {
		this.mainCategory = mainCategory;
	}

	public String getNationalId() {
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	public String getLegalStatus() {
		return legalStatus;
	}

	public void setLegalStatus(String legalStatus) {
		this.legalStatus = legalStatus;
	}

	public Integer getTotalEmployees() {
		return totalEmployees;
	}

	public void setTotalEmployees(Integer totalEmployees) {
		this.totalEmployees = totalEmployees;
	}

	public String getAdmName() {
		return admName;
	}

	public void setAdmName(String admName) {
		this.admName = admName;
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
		Company other = (Company) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", type=" + type + ", name=" + name + ", adress=" + adress + ", city=" + city
				+ ", phone=" + phone + ", email=" + email + ", fantasyName=" + fantasyName + ", mainCategory="
				+ mainCategory + ", nationalId=" + nationalId + ", legalStatus=" + legalStatus + ", totalEmployees="
				+ totalEmployees + ", admName=" + admName + "]";
	}
}
