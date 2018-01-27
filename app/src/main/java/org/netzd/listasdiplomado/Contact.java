package org.netzd.listasdiplomado;

/**
 * Created by Alumno12 on 27/01/18.
 */

public class Contact {
    private int id = 0;
    private String name = null;
    private String school = null;
    private String address = null;
    private int age = 0;

    public Contact() {
    }

    public Contact(int id, String name, String school) {
        this.id = id;
        this.name = name;
        this.school = school;
    }

    public Contact(int id, String name, String school, String address, int age) {
        this.id = id;
        this.name = name;
        this.school = school;
        this.address = address;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //Buenas practicas


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (id != contact.id) return false;
        if (age != contact.age) return false;
        if (!name.equals(contact.name)) return false;
        if (school != null ? !school.equals(contact.school) : contact.school != null) return false;
        return address != null ? address.equals(contact.address) : contact.address == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + (school != null ? school.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}
