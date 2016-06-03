package Interface;

public interface IfileManager
{
    public boolean createAccount(Object object)throws Exception ;
    public void deleteAccount(Object object)throws Exception;
    public Object searchAccount(Object object)throws Exception;
    public void updateAccount(Object object)throws Exception;
}
