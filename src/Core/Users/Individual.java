package Core.Users;
import Interface.IuserFunctions;
import Core.Human;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
//Done
public class Individual extends Human implements IuserFunctions,Serializable
{
    Transaction record;

    public Individual() {
        record = new Transaction();
    }
    
    
    @Override
    public ArrayList<String> displayTransactions(Object object) throws IOException, ClassNotFoundException {
        return record.showRecords(object);
    }
    
    @Override
    public Object searchAccount(Object object)throws IOException, ClassNotFoundException
    {
       Account obj = (Account) object;
        ArrayList<Account> array;
        ObjectInputStream fromFile = new ObjectInputStream(new FileInputStream("Database\\individuals.bin"));
        array = (ArrayList<Account>) fromFile.readObject();
        fromFile.close();

        for (Account client : array) {
            if (client.getUserName().equals(obj.getUserName())) {
                return client;
            }
        }
        return obj;
    }
}
