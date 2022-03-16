package LGSMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import LGSMS.Dao.AccountDao;
import LGSMS.Model.Account;

@Controller
public class AccountController {
	
	@Autowired
	private AccountDao accountDao;

	@RequestMapping(value = "/view_account", method = RequestMethod.GET)
	
	
	  public String showsAccounts(Model model) {
		List<Account> listAcc= accountDao.getAccounts();;

        model.addAttribute("listAcc", listAcc);

        return "view_account";
    }
}
