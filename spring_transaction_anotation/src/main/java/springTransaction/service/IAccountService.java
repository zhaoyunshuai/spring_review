package springTransaction.service;

public interface IAccountService {
    public void transfer(String outUsername, String inUsername, Double money);
}
