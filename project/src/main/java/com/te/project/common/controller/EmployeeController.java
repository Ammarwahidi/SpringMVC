package com.te.project.common.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.project.common.dao.EmployeeDao;
import com.te.project.common.dto.Employeebean;
import com.te.project.common.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@GetMapping("/empLogin")
	public String getLoginForm() {
		return "empLogin";
	}

	@PostMapping("/empLogin")
	public String authenticate(int id, String password, HttpServletRequest request, ModelMap map) {
		Employeebean employeebean = service.authenticate(id, password);
		if (employeebean != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("emp", employeebean);
			return "nav";

		} else {
			map.addAttribute("errMsg", "Invalid cretential");
			return "empLogin";
		}

	}// end of athuncicate

	@GetMapping("/Search")
	public String getSearchForm(ModelMap map, HttpSession session) {
		if (session.getAttribute("emp") != null) {
			return "Search";

		} else {
			map.addAttribute("errrMsg", "please login first");
			return "empLogin";
		}

	}// end of getSearchForm

	@GetMapping("/search1")
	public String searchEmp(int id, ModelMap map,
			@SessionAttribute(name = "emp", required = false) Employeebean employeebean) {

		if (employeebean != null) {
			Employeebean employeebean2 = service.getEmployee(id);
			if (employeebean2 != null) {
				map.addAttribute("data", employeebean2);

			} else {
				map.addAttribute("msg", "data not found for id:" + id);
			}
			return "Search";
		} else {
			map.addAttribute("errMsg", "Please Login first");
			return "empLogin";
		}

	}// end of searchEmp

	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap map) {
		session.invalidate();
		map.addAttribute("msg", "logout Succesfully");
		return "empLogin";
	}// end of logOut
	
	
	@GetMapping("/ShowDelete")
	public String deleteForm(@SessionAttribute(name = "emp", required = false) Employeebean bean, ModelMap map) {

		if (bean != null) {
			return "Delete";
		} else {
			map.addAttribute("errmsg", "Please Login First");
			return "empLogin";
		}

	}//end of showDelete

	@GetMapping("/delete")
	public String deleteEmployee(int id, @SessionAttribute(name = "emp", required = false) Employeebean bean,
			ModelMap modelMap) {

		if (bean != null) {
			
			if (service.getDeleteEmp(id)) {
				modelMap.addAttribute("msg", "deleted successfully");
			} else {
				modelMap.addAttribute("errMsg", "Entered Id Does Not Exist");
			}
			return "Delete";
		} else {
			modelMap.addAttribute("errMsg", "Please Login First");
			return "empLogin";
		}

	}// end of deleteEmployee();

	@GetMapping("/AllEmployee")
	public String getAllEmployee(@SessionAttribute(name = "emp", required = false) Employeebean bean,
			ModelMap modelMap) {
		if (bean != null) {
			List<Employeebean> beans = service.getAllEmployee();
			if (bean != null) {
				modelMap.addAttribute("bean", beans);
			} else {
				modelMap.addAttribute("Msg", "NO Employee Found");
			}
			return "AllEmployee";
		} else {
			modelMap.addAttribute("errMsg", "Please Login First");
			return "empLogin";
		}
	}// end of getALLEmployee()

	@GetMapping("/addEmployee")
	public String getAddEmployeeForm(@SessionAttribute(name = "emp", required = false) Employeebean bean,
			ModelMap modelMap) {
		if (bean != null) {
			return "add";
		} else {
			modelMap.addAttribute("errMsg", "Please Login First");
			return "empLogin";
		}
	}// end of getAddEmployeeFOrm();

	@PostMapping("/addEmployee")
	public String addEmployee(@SessionAttribute(name = "emp", required = false) Employeebean bean, ModelMap modelMap) {
		if (bean != null) {
			if (service.getAllEmployee() != null) {
				modelMap.addAttribute("msg", "added successfully");
			} else {
				modelMap.addAttribute("errMsg", "this Employee Record Already exists!");
			}
			return "add";
		} else {
			modelMap.addAttribute("errMsg", "Please Login First");
			return "empLogin";
		}
	}// end of addEmployee()

}// end of class
