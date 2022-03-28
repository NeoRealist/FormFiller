/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package by.bobruisk.zhelnov.myproject.mavenproject1;

/**
 *
 * @author Anton
 */
public class User {
	private long id;
    private FullName fullName;
    private String email;    
    private String speciality;
    private String organizationName;
    private String departmentName;
    private String password;

    public User(FullName fullName, String speciality, String organizationName, String departmentName,String email, String password) {
        this.fullName = fullName;       
        this.organizationName = organizationName;
        this.departmentName = departmentName;
        this.speciality = speciality;
        this.email = email;
        this.password = password;
    }
    public User() {

    }
    
    
    
    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	/**
     * @return the fullName
     */
    public FullName getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the speciality
     */
    public String getSpeciality() {
        return speciality;
    }

    /**
     * @param speciality the speciality to set
     */
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    /**
     * @return the organizationName
     */
    public String getOrganizationName() {
        return organizationName;
    }

    /**
     * @param organizationName the organizationName to set
     */
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    /**
     * @return the departmentName
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * @param departmentName the departmentName to set
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    

    @Override
    public String toString() {
        return "id=" + id + ", fullname=" + fullName + ", email=" + email + ", speciality=" + speciality + ", organizationName=" + organizationName + ", departmentName=" + departmentName + ", password=" + password;
    }
    
    
    
    
    
    
    
}
