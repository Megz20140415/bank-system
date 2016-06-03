package Core.Users;
import java.io.Serializable;
import java.util.Date;
//Done
public class creditCard implements Serializable
{
    private Date expirationDate;
    private int creditCardNumber;
    private int CVC;
    
    public Date getExpirationDate()
    {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate)
    {
        this.expirationDate = expirationDate;
        //Two years from nw
    }

    public int getCreditCardNumber()
    {
        return creditCardNumber;
    }

    public void setCreditCardNumber(int creditCardNumber)
    {
        //Delete this line when you create the random function
        this.creditCardNumber = creditCardNumber;
        //Generates random number for credit card number
    }

    public int getCVC()
    {
        return CVC;
    }

    public void setCVC(int CVC)
    {
        //Delete this line when you create the random function
        this.CVC = CVC;
        //Generate random number (4 digits)
    }
}
