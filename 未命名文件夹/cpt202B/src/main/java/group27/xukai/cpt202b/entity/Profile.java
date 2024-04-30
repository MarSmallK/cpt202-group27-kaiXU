package group27.xukai.cpt202b.entity;

import java.io.Serializable;

/**
 * (Profile)实体类
 *
 * @author makejava
 * @since 2024-04-28 20:23:49
 */
public class Profile implements Serializable {
    private static final long serialVersionUID = -77719346052991765L;

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String gender;

    private String phone;

    private Integer age;

    private String fitnessPreference;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFitnessPreference() {
        return fitnessPreference;
    }

    public void setFitnessPreference(String fitnessPreference) {
        this.fitnessPreference = fitnessPreference;
    }

}

