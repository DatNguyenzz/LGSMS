package LGSMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import LGSMS.Dao.AccountDao;
import LGSMS.Model.Account;
import LGSMS.Service.AccountService;

@Controller
public class AccountController {
	
	@Autowired

	private AccountService accountService;

	//	@GetMapping("/adminManageAccount")
	@RequestMapping(value = {"/adminManageAccount"}, method = RequestMethod.GET)
	  public String showsAccounts(Model model) {
		List<Account> listAcc= accountService.showAll();
		
        model.addAttribute("listAcc", listAcc);

        return "admin_manage_account";
    }
	
	
	
	@RequestMapping(value = {"/adminManageAccount"}, method = RequestMethod.PUT)
	 public String showsAccountByID(Model model,@RequestParam("accountId") int id,
			 @RequestParam("fullName") String fullName,@RequestParam("email") String email, 
			 @RequestParam("roles") String roleName ) {
		
		
	        model.addAttribute("acc",  accountService.getAccID(id));

	        return "admin_manage_account";
	    }
	
}
