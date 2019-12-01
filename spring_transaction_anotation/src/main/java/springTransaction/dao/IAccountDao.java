package springTransaction.dao;

public interface IAccountDao {

    public void in(String name, Double money);
    public void out(String name, Double money);
}
