package Core.Staff;
import Core.Human;
import java.io.Serializable;

public class Staff extends Human implements Serializable
{
    protected double salary;
    protected String firstName;
    protected String lastName;
    protected String Position;
    protected String staffID;

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getPosition()
    {
        return Position;
    }

    public void setPosition(String Position)
    {
        this.Position = Position;
    }

    public String getStaffID()
    {
        return staffID;
    }

    public void setStaffID(String staffID) {
       int z = 0;
       for (int i = 1; i < staffID.length(); i++) {
           z = z * 10;
           z = z + Integer.parseInt("" + staffID.charAt(i));
       }
       z++;
       staffID = "" + staffID.charAt(0) + z;

       this.staffID = staffID;
    }
    
    public String getProfilePicture()
    {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture)
    {
        this.profilePicture = profilePicture;
    }
}
