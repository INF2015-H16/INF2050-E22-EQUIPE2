/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarefactoring1;
/**
 *
 * @author zzaier
 */
import java.util.Date;

public class PartTime extends Employee {

    String partTime_id;

    String lastName;
    String firstName;
    Date dateBirth;

    public PartTime(String n, String p, Date d) {
        this.lastName = n;
        this.firstName = p;
        this.dateBirth = d;
        this.partTime_id = createPartTimeId(n, p, d);
    }

    public String createPartTimeId(String lName, String fName, Date date) {
        String end = concatDate(date);
        return lName.substring(0, 3) + fName.charAt(0) + end;
    }

    private String concatDate(Date date) {
        return date.getYear() + "-" + date.getMonth();
    }

    public String getPartTimeId() {
        return partTime_id;
    }

    public void setPartTimeId(String partTime_id) {
        this.partTime_id = partTime_id;
    }

    public void isSupervisedBy(Permanent permanent) {
        permanent.partTimes.add(this);
    }
}
   