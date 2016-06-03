package Core.Staff;

import Core.Users.companyType;
import Core.Users.individualType;
import Interface.IfileManager;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class loanEmployee extends Staff implements IfileManager {

    @Override
    public boolean createAccount(Object object) throws IOException, ClassNotFoundException {
        try {
            individualType Account = (individualType) object;
            ArrayList<individualType> arrList;
            try {
                ObjectInputStream readFile = new ObjectInputStream(new FileInputStream("Database\\Borrowers\\individuals.bin"));
                arrList = (ArrayList<individualType>) readFile.readObject();
                readFile.close();
                String ID = "";
                for (individualType temp : arrList) {
                    ID = temp.getBorrowerID();
                    if (temp.getSSN().equals(Account.getSSN())) {
                        return false;
                    }
                }
                Account.setBorrowerID(ID);
                arrList.add(Account);
                ObjectOutputStream WriteFile = new ObjectOutputStream(new FileOutputStream("Database\\Borrowers\\individuals.bin"));
                WriteFile.writeObject(arrList);
                WriteFile.close();
            } catch (EOFException | FileNotFoundException z) {
                arrList = new ArrayList<>();
                Account.setBorrowerID("BI");
                arrList.add(Account);
                ObjectOutputStream WriteFile = new ObjectOutputStream(new FileOutputStream("Database\\Borrowers\\individuals.bin"));
                WriteFile.writeObject(arrList);
                WriteFile.close();
            }
        } catch (ClassCastException e) {
            companyType Account = (companyType) object;
            ArrayList<companyType> arrayList;
            try {
                ObjectInputStream readFile = new ObjectInputStream(new FileInputStream("Database\\Borrowers\\companies.bin"));
                arrayList = (ArrayList<companyType>) readFile.readObject();
                readFile.close();
                String ID = "";
                for (companyType temp : arrayList) {
                    ID = temp.getBorrowerID();
                    if (temp.getName().equals(Account.getName())) {
                        return false;
                    }
                }
                Account.setBorrowerID(ID);
                arrayList.add(Account);
                ObjectOutputStream WriteFile = new ObjectOutputStream(new FileOutputStream("Database\\Borrowers\\companies.bin"));
                WriteFile.writeObject(arrayList);
                WriteFile.close();

            } catch (FileNotFoundException | EOFException z) {
                arrayList = new ArrayList<>();
                Account.setBorrowerID("BC");
                arrayList.add(Account);
                ObjectOutputStream WriteFile = new ObjectOutputStream(new FileOutputStream("Database\\Borrowers\\companies.bin"));
                WriteFile.writeObject(arrayList);
                WriteFile.close();

            }

        }
        return true;
    }

    @Override
    public void deleteAccount(Object object) throws IOException, ClassNotFoundException {
        try {
            individualType Account = (individualType) object;
            ArrayList<individualType> arrList;
            ArrayList<individualType> temparr = new ArrayList<>();
            ObjectInputStream readFile = new ObjectInputStream(new FileInputStream("Database\\borrowers\\individuals.bin"));
            arrList = (ArrayList<individualType>) readFile.readObject();
            readFile.close();
            for (individualType temp : arrList) {
                if (!temp.getSSN().equals(Account.getSSN())) {
                    temparr.add(temp);
                }
            }
            ObjectOutputStream WriteFile = new ObjectOutputStream(new FileOutputStream("Database\\borrowers\\individuals.bin"));
            if (!temparr.isEmpty()) {
                WriteFile.writeObject(temparr);
            }
            WriteFile.close();
        } catch (ClassCastException e) {
            companyType Account = (companyType) object;
            ArrayList<companyType> arrList;
            ArrayList<companyType> temparr = new ArrayList<>();
            ObjectInputStream readFile = new ObjectInputStream(new FileInputStream("Database\\borrowers\\companies.bin"));
            arrList = (ArrayList<companyType>) readFile.readObject();
            readFile.close();
            for (companyType temp : arrList) {
                if (!temp.getName().equals(Account.getName())) {
                    temparr.add(temp);
                }
            }
            ObjectOutputStream WriteFile = new ObjectOutputStream(new FileOutputStream("Database\\borrowers\\companies.bin"));
            if (!temparr.isEmpty()) {
                WriteFile.writeObject(temparr);
            }
            WriteFile.close();
        }
    }

    @Override
    public Object searchAccount(Object object) throws IOException, ClassNotFoundException {
        try {
            try {
                individualType Account = (individualType) object;
                ArrayList<individualType> arrList;
                ObjectInputStream readFile = new ObjectInputStream(new FileInputStream("Database\\borrowers\\individuals.bin"));
                arrList = (ArrayList<individualType>) readFile.readObject();
                readFile.close();
                for (individualType temp : arrList) {
                    if (temp.getSSN().equals(Account.getSSN())) {
                        return temp;
                    }
                }
            } catch (EOFException x) {
                return object;
            }
        } catch (ClassCastException e) {
            try {
                companyType Account = (companyType) object;
                ArrayList<companyType> arrList;
                ObjectInputStream readFile = new ObjectInputStream(new FileInputStream("Database\\borrowers\\companies.bin"));
                arrList = (ArrayList<companyType>) readFile.readObject();
                readFile.close();
                for (companyType temp : arrList) {
                    if (temp.getName().equals(Account.getName())) {
                        return temp;
                    }
                }
            } catch (EOFException x) {
                return object;
            }

        }
        return object;
    }

    @Override
    public void updateAccount(Object object) throws IOException, ClassNotFoundException {
        int counter = 0;
        try {
            individualType Account = (individualType) object;
            ObjectInputStream readFile = new ObjectInputStream(new FileInputStream("Database\\Borrowers\\individuals.bin"));
            ArrayList<individualType> arrList = (ArrayList<individualType>) readFile.readObject();

            readFile.close();
            for (individualType temp : arrList) {
                if (temp.getSSN().equals(Account.getSSN())) {
                    arrList.set(counter, Account);
                }
                counter++;
            }
            ObjectOutputStream WriteFile = new ObjectOutputStream(new FileOutputStream("Database\\Borrowers\\individuals.bin"));
            WriteFile.writeObject(arrList);
            WriteFile.close();

        } catch (ClassCastException e) {
            companyType company = (companyType) object;
            ObjectInputStream readFile = new ObjectInputStream(new FileInputStream("Database\\Borrowers\\companies.bin"));
            ArrayList<companyType> arrList = (ArrayList<companyType>) readFile.readObject();
            readFile.close();

            for (companyType temp : arrList) {
                if (temp.getName().equals(company.getName())) {
                    arrList.set(counter, company);
                }
            }

            ObjectOutputStream WriteFile = new ObjectOutputStream(new FileOutputStream("Database\\Borrowers\\companies.bin"));
            WriteFile.writeObject(arrList);
            WriteFile.close();
        }
    }

    public boolean acceptLoanRequest(double loanBalance, double salary) {
        //TODO
        return false;
    }

    public boolean repayLoan(Object object, double money) throws IOException, ClassNotFoundException {
        int counter = 0;
        double checkMoney;
        try {
            individualType Account = (individualType) object;
            checkMoney = Account.getLoanBalance() - money;

            if (checkMoney < 0.0) {
                return false;
            }
            Account.setLoanBalance(checkMoney);
            ObjectInputStream readFile = new ObjectInputStream(new FileInputStream("Database\\borrowers\\individuals.bin"));
            ArrayList<individualType> arrList = (ArrayList<individualType>) readFile.readObject();
            readFile.close();
            for (individualType temp : arrList) {
                if (temp.getSSN().equals(Account.getSSN())) {
                    arrList.set(counter, Account);
                }
                counter++;
            }
            if (checkMoney == 0.0) {
                arrList.remove(Account);
            }
            ObjectOutputStream WriteFile = new ObjectOutputStream(new FileOutputStream("Database\\Borrowers\\individuals.bin"));
            WriteFile.writeObject(arrList);
            WriteFile.close();

        } catch (ClassCastException e) {

            companyType company = (companyType) object;
            checkMoney = company.getLoanBalance() - money;
            if (checkMoney < 0.0) {
                return false;
            }
            company.setLoanBalance(checkMoney);
            ObjectInputStream readFile = new ObjectInputStream(new FileInputStream("Database\\Borrowers\\companies.bin"));
            ArrayList<companyType> arrList = (ArrayList<companyType>) readFile.readObject();
            readFile.close();

            for (companyType temp : arrList) {
                if (temp.getName().equals(company.getName())) {
                    arrList.set(counter, company);
                }
            }
            if (checkMoney == 0.0) {
                arrList.remove(counter);
            }
            ObjectOutputStream WriteFile = new ObjectOutputStream(new FileOutputStream("Database\\Borrowers\\companies.bin"));
            WriteFile.writeObject(arrList);
            WriteFile.close();
        }

        return true;
    }
}
