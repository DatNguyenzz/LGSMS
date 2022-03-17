package LGSMS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import LGSMS.Dao.AccountDao;
import LGSMS.Model.Account;

@Service
public class AccountService {

	@Autowired
	private AccountDao accountDao;

	public List<Account> showAll(){
		return accountDao.getAccounts();
	}
	
	public Account getAccID(int  accountId) {
		return accountDao.getAccountByid( accountId);
	}
	
}
