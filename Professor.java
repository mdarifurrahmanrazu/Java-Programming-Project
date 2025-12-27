
package University.Management.System;

public class Professor extends Person {
    
    private String department;

    public Professor(String id, String name, String email, String department) {
        super(id, name, email);
        this.department = department;
    }

    @Override
    public void displayInfo() {
        System.out.println("Professor ID: " + id + ", Name: " + name + ", Dept: " + department);
    }

    public String getName() {
    return name;
    }

    public String getId() {
    return id;
    }
}


