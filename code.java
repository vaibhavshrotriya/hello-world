//AccountDebitor.java
public class AccountDebitor{
	private ACCOUNT _user;
  public void debitAccount(String accNo, Double amount){
   //Logic for debiting 'amount' from account number 'accNo'
  	_user = ACCOUNT.getAccount(accNo);
  	_user.setAmount(_user.getAmount() - amount);
  } 
}
//AccountCreditor.java
public class AccountCreditor{
	private ACCOUNT _user;
  public void creditAccount(String accNo, Double amount){
   //Logic for crediting 'amount' into account number 'accNo'
  	_user = ACCOUNT.getAccount(accNo);
  	_user.setAmount(_user.getAmount() + amount);
  } 
}
//BankingFacade.java
public class BankingFacade{
  AccountCreditor creditor=new AccountCreditor();
  AccountDebitor debitor=new AccountDebitor();
  public void onlineTransfer(String fromAcc, String toAcc, Double amount){
    debitor.debitAccount(fromAcc, amount);
    creditor.creditAccount(toAcc, amount);
  }
  public void atmWithdrawal(String fromAcc, Double amount){
    debitor.debitAccount(fromAcc, amount);
  } 
}
//Client.java
public class Client{
  private BankingFacade facade;
  public Client(BankingFacade facade){
    this.facade=facade;
  }  
  public static void main(String args[]){
    BankingFacade facade=new BankingFacade();
    facade.onlineTransfer("1001","1002",10000.00);
    facade.atmWithdrawal("1001",1000.00);
  } 
}