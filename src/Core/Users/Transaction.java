package Core.Users;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Transaction implements Serializable{

    Date transactionDate;

    public void saveRecord(Object fromObject, int transactionType, double balance, Object toObejct) throws FileNotFoundException, IOException, ClassNotFoundException {
       String fileName;
        String sentence;
        ArrayList<String> arr = new ArrayList();
        transactionDate = new Date();
        if (transactionType == 1) {
            try { // individuals
                Account obj = (Account) fromObject;
                fileName = "Database\\Transactions\\Individuals\\" + obj.getUserName() + ".bin";

                sentence = String.format("You made a deposit with %.2f L.E at %s", balance, transactionDate.toString());
                try {
                    ObjectInputStream fromFile = new ObjectInputStream(new FileInputStream(fileName));
                    arr = (ArrayList<String>) fromFile.readObject();
                    fromFile.close();
                } catch (IOException | ClassNotFoundException e) {               
                }
                arr.add(sentence);
                ObjectOutputStream inFile = new ObjectOutputStream(new FileOutputStream(fileName));
                inFile.writeObject(arr);
                inFile.close();
                arr.clear();
                
            } catch (ClassCastException e) { // Companies
                Company comp = (Company) fromObject;
                fileName = "Database\\Transactions\\Companies\\" + comp.getUserName() + ".bin";
                sentence = String.format("You made a deposit with %.2f L.E at %s", balance, transactionDate.toString());
                try {
                    ObjectInputStream fromFile = new ObjectInputStream(new FileInputStream(fileName));
                    arr = (ArrayList<String>) fromFile.readObject();
                    fromFile.close();
                } catch (IOException | ClassNotFoundException ee) {
                }
                arr.add(sentence);
                ObjectOutputStream inFile = new ObjectOutputStream(new FileOutputStream(fileName));
                inFile.writeObject((ArrayList<String>) arr);
                inFile.close();
                arr.clear();
            }
        } else if (transactionType == 2) {
            try { // individuals
                Account acc = (Account) fromObject;
                fileName = "Database\\Transactions\\Individuals\\" + acc.getUserName() + ".bin";
                sentence = String.format("You made a withdraw  with %.2f L.E at %s", balance, transactionDate.toString());
                try {
                    ObjectInputStream fromFile = new ObjectInputStream(new FileInputStream(fileName));
                    arr = (ArrayList<String>) fromFile.readObject();
                    fromFile.close();
                } catch (IOException | ClassNotFoundException e) {
                }
                arr.add(sentence);
                ObjectOutputStream inFile = new ObjectOutputStream(new FileOutputStream(fileName));
                inFile.writeObject((ArrayList<String>) arr);
                inFile.close();
                arr.clear();

            } catch (ClassCastException e) { // Companies
                Company comp = (Company) fromObject;
                fileName = "Database\\Transactions\\Companies\\" + comp.getUserName() + ".bin";
                sentence = String.format("You made a withdraw  with %.2f L.E at %s", balance, transactionDate.toString());
                try {
                    ObjectInputStream fromFile = new ObjectInputStream(new FileInputStream(fileName));
                    arr = (ArrayList<String>) fromFile.readObject();
                    fromFile.close();
                } catch (IOException | ClassNotFoundException ee) {
                }
                arr.add(sentence);
                ObjectOutputStream inFile = new ObjectOutputStream(new FileOutputStream(fileName));
                inFile.writeObject((ArrayList<String>) arr);
                inFile.close();
                arr.clear();
            }
        } else if (transactionType == 3) {
            try { // individuals
                Account from = (Account) fromObject;
                Account to = (Account) toObejct;
                String fullName = from.getFirstName() + " " + from.getLastName();
                fileName = "Database\\Transactions\\Individuals\\" + from.getUserName() + ".bin";
                sentence = String.format("You have transferred %.2f to %s at %s", balance, fullName, transactionDate.toString());
                try {
                    ObjectInputStream fromFile = new ObjectInputStream(new FileInputStream(fileName));
                    arr = (ArrayList<String>) fromFile.readObject();
                    fromFile.close();
                } catch (IOException | ClassNotFoundException e) {
                }
                arr.add(sentence);
                ObjectOutputStream inFile = new ObjectOutputStream(new FileOutputStream(fileName));
                inFile.writeObject((ArrayList<String>) arr);
                inFile.close();
                arr.clear();
                String fullName2 = to.getFirstName() + " " + to.getLastName();
                fileName = "Database\\Transactions\\Individuals\\" + to.getUserName() + ".bin";
                sentence = String.format("A %.2f has been transferred to your account from %s at %s", balance, fullName2, transactionDate.toString());
                try {
                    ObjectInputStream fromFile = new ObjectInputStream(new FileInputStream(fileName));
                    arr = (ArrayList<String>) fromFile.readObject();
                    fromFile.close();
                } catch (IOException | ClassNotFoundException e) {
                }
                arr.add(sentence);
                ObjectOutputStream inFile2 = new ObjectOutputStream(new FileOutputStream(fileName));
                inFile2.writeObject((ArrayList<String>) arr);
                inFile2.close();
                arr.clear();
            } catch (ClassCastException e) { // Companies
                
                Company from = (Company) fromObject;
                Company to = (Company) toObejct;
                fileName = "Database\\Transactions\\Companies\\" + from.getUserName()+ ".bin";
                sentence = String.format("You have transferred %.2f to %s at %s", balance, to.getName(), transactionDate.toString());
                try {
                    
                    ObjectInputStream fromFile = new ObjectInputStream(new FileInputStream(fileName));
                    arr = (ArrayList<String>) fromFile.readObject();  
                    fromFile.close();
                } catch (IOException | ClassNotFoundException ee) {
                }
                arr.add(sentence);
                ObjectOutputStream inFile = new ObjectOutputStream(new FileOutputStream(fileName));
                inFile.writeObject(arr);
                inFile.close();
                arr.clear();
                fileName = "Database\\Transactions\\Companies\\" + to.getUserName()+ ".bin";
                sentence = String.format("A %.2f has been transferred to your account from %s at %s", balance, from.getName(), transactionDate.toString());
                try {
                    ObjectInputStream fromFile = new ObjectInputStream(new FileInputStream(fileName));
                    arr = (ArrayList<String>) fromFile.readObject();
                    fromFile.close();
                } catch (Exception ee) {
                }
                arr.add(sentence);
                ObjectOutputStream inFile2 = new ObjectOutputStream(new FileOutputStream(fileName));
                inFile2.writeObject((ArrayList<String>) arr);
                inFile2.close();
                arr.clear();
            }

        }

    }

    public ArrayList<String> showRecords(Object object) throws IOException, ClassNotFoundException {
        
        String fileName;
        ArrayList<String> array;
        try { // individual
            Account obj = (Account) object;
            fileName = "Database\\Transactions\\Individuals\\" + obj.getUserName() + ".bin";
            
            ObjectInputStream fromFile = new ObjectInputStream(new FileInputStream(fileName));
            
            array = (ArrayList<String>) fromFile.readObject();
            fromFile.close();

        } catch (ClassCastException e) { // company
            
            Company obj = (Company) object;
            fileName = "Database\\Transactions\\Companies\\" + obj.getUserName() + ".bin";

            ObjectInputStream fromFile = new ObjectInputStream(new FileInputStream(fileName));
            array = (ArrayList<String>) fromFile.readObject();
            fromFile.close();

        }
        return array;
    }
}
