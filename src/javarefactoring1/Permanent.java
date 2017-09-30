/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zzaier
 */
import java.util.ArrayList;
import java.util.List;

public class Permanent extends Employee {

    List<PartTime> partTimes = new ArrayList<PartTime>();
    String photoUrl;

    public Permanent(String lastName, String firstName) {

        String employeeID = lastName.toUpperCase().trim().substring(1, 3)
                + firstName.toUpperCase().trim().substring(1, 3);

        System.out.println("New Permanent Employee" + employeeID);
    }

    public void setPhotoUrl(String photoName) {

        this.photoUrl = "/photos/employees/permanent/" + photoName;
    }

}
