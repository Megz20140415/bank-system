package Core.Staff;

import Core.Users.Account;
import Core.Users.Company;
import Interface.IfileManager;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class accountManager extends Staff implements IfileManager {

    @Override
    public boolean createAccount(Object object) throws IOException, ClassNotFoundException {
        ObjectInputStream file = new ObjectInputStream(new FileInputStream("Database\\login.bin"));
        ArrayList<String> arrList_log = new ArrayList<>();
        HashMap<String, ArrayList<String>> hash_log = (HashMap<String, ArrayList<String>>) file.readObject();
        file.close();
        try {
            //createAccount in individuals Files
            Account account = (Account) object;
            try {

                ObjectInputStream readFile = new ObjectInputStream(new FileInputStream("Database\\individuals.bin"));
                ArrayList<Account> arrList = (ArrayList<Account>) readFile.readObject();
                String id = "I";

                for (Account p : arrList) {

                    id = p.getAccountID();
                    if (account.getUserName().equals(p.getUserName())) {
                        return false;
                    }
                }

                account.setAccountID(id);
                arrList.add(account);
                readFile.close();
                ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream("Database\\individuals.bin"));
                writeFile.writeObject(arrList);
                writeFile.close();
            } catch (EOFException | FileNotFoundException e) {
                account.setAccountID("I");
                ArrayList<Account> arrList = new ArrayList<>();
                arrList.add(account);
                ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream("Database\\individuals.bin"));
                writeFile.writeObject(arrList);
                writeFile.close();
            }

            //create transactionFile
            ObjectOutputStream writeTransFile = new ObjectOutputStream(new FileOutputStream("Database\\Transactions\\Individuals\\" + account.getUserName() + ".bin"));
            writeTransFile.close();

            arrList_log.add(account.getPassword());

            arrList_log.add(account.getAccountID());
            hash_log.put(account.getUserName(), arrList_log);

        } catch (ClassCastException e) {
            Company company = (Company) object;
            try {

                //createAccount in individuals Files
                ObjectInputStream readFile = new ObjectInputStream(new FileInputStream("Database\\companies.bin"));
                ArrayList<Company> arrList = (ArrayList<Company>) readFile.readObject();
                String id = "C";
                for (Company p : arrList) {

                    id = p.getCompanyID();

                    if (company.getUserName().equals(p.getUserName())) {

                        return false;
                    }
                }
                company.setCompanyID(id);
                arrList.add(company);
                readFile.close();
                ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream("Database\\companies.bin"));
                writeFile.writeObject(arrList);
                writeFile.close();
            } catch (EOFException | FileNotFoundException z) {
                company.setCompanyID("C");
                ArrayList<Company> arrList = new ArrayList<>();
                arrList.add(company);
                ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream("Database\\companies.bin"));
                writeFile.writeObject(arrList);
                writeFile.close();
            }
            //create transactionFile
            ObjectOutputStream writeTransFile = new ObjectOutputStream(new FileOutputStream("Database\\Transactions\\Companies\\" + company.getUserName() + ".bin"));
            writeTransFile.close();

            arrList_log.add(company.getPassword());
            arrList_log.add(company.getCompanyID());
            hash_log.put(company.getUserName(), arrList_log);

        } finally {
            ObjectOutputStream fileWriter2 = new ObjectOutputStream(new FileOutputStream("Database\\login.bin"));
            fileWriter2.writeObject(hash_log);
            fileWriter2.close();
        }

        return true;
    }

    @Override
    public void deleteAccount(Object object) throws IOException, ClassNotFoundException {
        String userName = "";
        try {
            Account account = (Account) object;
            userName = account.getUserName();

            ObjectInputStream fileScanner = new ObjectInputStream(new FileInputStream("Database\\individuals.bin"));
            ArrayList<Account> arrList = (ArrayList<Account>) fileScanner.readObject();
            fileScanner.close();

            ArrayList<Account> templist = new ArrayList<>();
            for (Account acc : arrList) {
                if (!account.getUserName().equals(acc.getUserName())) {
                    templist.add(acc);
                }
            }
            ObjectOutputStream fileWriter1 = new ObjectOutputStream(new FileOutputStream("Database\\individuals.bin"));
            fileWriter1.writeObject(templist);
            fileWriter1.close();

            new File("Database\\Transactions\\Individuals\\" + userName + ".bin").delete();
        } catch (ClassCastException e) {
            Company company = (Company) object;
            userName = company.getUserName();

            ObjectInputStream fileScanner = new ObjectInputStream(new FileInputStream("Database\\companies.bin"));
            ArrayList<Company> arrList = (ArrayList<Company>) fileScanner.readObject();
            fileScanner.close();

            ArrayList<Company> templist = new ArrayList<>();
            for (Company com : arrList) {
                if (!company.getUserName().equals(com.getUserName())) {
                    templist.add(com);
                }
            }
            ObjectOutputStream fileWriter1 = new ObjectOutputStream(new FileOutputStream("Database\\companies.bin"));
            fileWriter1.writeObject(templist);
            fileWriter1.close();

            new File("Database\\Transactions\\Companies\\" + userName + ".bin").delete();

        } finally {
            ObjectInputStream file = new ObjectInputStream(new FileInputStream("Database\\login.bin"));
            HashMap<String, ArrayList<String>> hash_log = (HashMap<String, ArrayList<String>>) file.readObject();
            file.close();
            hash_log.remove(userName);

            ObjectOutputStream fileWriter2 = new ObjectOutputStream(new FileOutputStream("Database\\login.bin"));
            fileWriter2.writeObject(hash_log);
            fileWriter2.close();

        }
    }

    @Override
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

    @Override
    public void updateAccount(Object object) throws IOException, ClassNotFoundException {
        String username = "", password = "", ID = "";
        try {
            Account x = (Account) object;
            username = x.getUserName();
            password = x.getPassword();
            ID = x.getAccountID();
            ObjectInputStream readFile = new ObjectInputStream(new FileInputStream("Database\\individuals.bin"));
            ArrayList<Account> arrList = (ArrayList<Account>) readFile.readObject();
            ArrayList<Account> Templist = new ArrayList<>();
            for (Account temp : arrList) {
                if (temp.getUserName().equals(x.getUserName())) {
                    Templist.add(x);
                } else {
                    Templist.add(temp);
                }
            }
            ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream("Database\\individuals.bin"));
            writeFile.writeObject(Templist);
            writeFile.close();

        } catch (ClassCastException e) {
            Company x = (Company) object;
            username = x.getUserName();
            password = x.getPassword();
            ID = x.getCompanyID();
            ObjectInputStream readFile = new ObjectInputStream(new FileInputStream("Database\\companies.bin"));
            ArrayList<Company> arrList = (ArrayList<Company>) readFile.readObject();
            ArrayList<Company> Templist = new ArrayList<>();
            for (Company temp : arrList) {
                if (temp.getUserName().equals(x.getUserName())) {
                    Templist.add(x);
                } else {
                    Templist.add(temp);
                }
            }
            ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream("Database\\companies.bin"));
            writeFile.writeObject(Templist);
            writeFile.close();
        } finally {
            ObjectInputStream file = new ObjectInputStream(new FileInputStream("Database\\login.bin"));
            ArrayList<String> arrList_log = new ArrayList<String>();
            HashMap<String, ArrayList<String>> hash_log = (HashMap<String, ArrayList<String>>) file.readObject();
            file.close();
            arrList_log.add(password);
            arrList_log.add(ID);
            hash_log.put(username, arrList_log);
            ObjectOutputStream fileWriter2 = new ObjectOutputStream(new FileOutputStream("Database\\login.bin"));
            fileWriter2.writeObject(hash_log);
            fileWriter2.close();

        }
    }
}
