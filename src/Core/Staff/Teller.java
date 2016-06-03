package Core.Staff;

import Core.Users.Transaction;
import Core.Users.Account;
import Core.Users.Company;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Teller extends Staff implements Serializable{

    Transaction record;

    public Teller() {
        record = new Transaction();
    }

    public Object searchAccount(Object object) throws IOException, ClassNotFoundException {
        try {
            Account x = (Account) object;
            ObjectInputStream readFile = new ObjectInputStream(new FileInputStream("Database\\individuals.bin"));
            ArrayList<Account> arrList = (ArrayList<Account>) readFile.readObject();
            for (Account temp : arrList) {
                if (temp.getUserName().equals(x.getUserName())) {
                    return temp;
                }
            }
        } catch (ClassCastException e) {
            Company x = (Company) object;
            ObjectInputStream readFile = new ObjectInputStream(new FileInputStream("Database\\companies.bin"));
            ArrayList<Company> arrList = (ArrayList<Company>) readFile.readObject();
            for(Company temp : arrList)
            {
                if(temp.getUserName().equals(x.getUserName()))
                {
                    return temp;
                }
            }
        }
        return object;
    }

    public void deposit(Object object, double moneyAmount) throws IOException, ClassNotFoundException {
        String Name;
        double newBalance;
        int i;
        try { // individual

            Account obj = (Account) object;
            Name = obj.getUserName();
            ObjectInputStream fromFile = new ObjectInputStream(new FileInputStream("Database\\individuals.bin"));
            ArrayList<Account> array;
            array = (ArrayList<Account>) fromFile.readObject();
            fromFile.close();
            for (i = 0; i < array.size(); i++) {
                if (array.get(i).getUserName().equals(Name)) {
                    newBalance = array.get(i).getMoneyBalance() + moneyAmount;
                    array.get(i).setMoneyBalance(newBalance);
                    record.saveRecord(object, 1, moneyAmount, null);
                    array.get(i).setMakeDeposit(true);
                    
                }
            }
            ObjectOutputStream inFile = new ObjectOutputStream(new FileOutputStream("Database\\individuals.bin"));
            inFile.writeObject((ArrayList<Account>) array);
            inFile.close();
            array.clear();

        } catch (ClassCastException e) { // company
            Company obj = (Company) object;
            Name = obj.getUserName();
            ObjectInputStream fromFile = new ObjectInputStream(new FileInputStream("Database\\companies.bin"));
            ArrayList<Company> array;
            array = (ArrayList<Company>) fromFile.readObject();
            fromFile.close();

            for (i = 0; i < array.size(); i++) {
                if (array.get(i).getUserName().equals(Name)) {
                    newBalance = array.get(i).getMoneyBalance() + moneyAmount;
                    array.get(i).setMoneyBalance(newBalance);
                    record.saveRecord(object, 1, moneyAmount, null);
                }
            }
            ObjectOutputStream inFile = new ObjectOutputStream(new FileOutputStream("Database\\companies.bin"));
            inFile.writeObject((ArrayList<Company>) array);
            inFile.close();
            array.clear();
        }
    }

    public void withDraw(Object object, double moneyAmount) throws IOException, ClassNotFoundException {
        String Name;
        double newBalance;
        int i;
        try { // individual
            Account obj = (Account) object;
            Name = obj.getUserName();
            ObjectInputStream fromFile = new ObjectInputStream(new FileInputStream("Database\\individuals.bin"));
            ArrayList<Account> array;
            array = (ArrayList<Account>) fromFile.readObject();
            fromFile.close();
            for (i = 0; i < array.size(); i++) {
                if (array.get(i).getUserName().equals(Name)) {
                    newBalance = array.get(i).getMoneyBalance() - moneyAmount;
                    array.get(i).setMoneyBalance(newBalance);
                    record.saveRecord(object, 2, moneyAmount, null);
                    array.get(i).setMakeWithdraw(true);
                    
                }
            }
            ObjectOutputStream inFile = new ObjectOutputStream(new FileOutputStream("Database\\individuals.bin"));
            inFile.writeObject((ArrayList<Account>) array);
            inFile.close();
            array.clear();
        } catch (ClassCastException e) { // company
            Company obj = (Company) object;
            Name = obj.getUserName();
            ObjectInputStream fromFile = new ObjectInputStream(new FileInputStream("Database\\companies.bin"));
            ArrayList<Company> array;
            array = (ArrayList<Company>) fromFile.readObject();
            fromFile.close();

            for (i = 0; i < array.size(); i++) {
                if (array.get(i).getUserName().equals(Name)) {
                    newBalance = array.get(i).getMoneyBalance() - moneyAmount;
                    array.get(i).setMoneyBalance(newBalance);
                    record.saveRecord(object, 2, moneyAmount, null);
                }
            }
            ObjectOutputStream inFile = new ObjectOutputStream(new FileOutputStream("Database\\companies.bin"));
            inFile.writeObject((ArrayList<Company>) array);
            inFile.close();
            array.clear();
        }

    }

    public boolean Transfer(Object fromObject, Object toObject, double balance) throws IOException, FileNotFoundException, ClassNotFoundException {
        try {
            Account fromIndividual = (Account) fromObject;
            Account toIndividual = (Account) toObject;
            if (fromIndividual.getMoneyBalance() >= balance && fromIndividual.getMoneyBalance() > 0) {
                withDraw(fromIndividual, balance);
                deposit(toIndividual, balance);
                record.saveRecord(fromObject, 3, balance, toObject);
            } else {
                return false;
            }

        } catch (ClassCastException e) {
            Company fromCompany = (Company) fromObject;
            Company toCompany = (Company) toObject;
            if (fromCompany.getMoneyBalance() >= balance && fromCompany.getMoneyBalance() > 0) {
                withDraw(fromCompany, balance);
                deposit(toCompany, balance);
                record.saveRecord(fromObject, 3, balance, toObject);
            }
        }
        return false;

    }
}
