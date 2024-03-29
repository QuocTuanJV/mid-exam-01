package com.tuanlq.midexam.controller;

import com.tuanlq.midexam.model.Department;
import com.tuanlq.midexam.model.Employee;
import com.tuanlq.midexam.services.DepartmentService;
import com.tuanlq.midexam.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DepartmentController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public ModelAndView listDepartment(){
        Iterable<Department> departments = departmentService.findAll();
        ModelAndView modelAndView = new ModelAndView("/department/list");
        modelAndView.addObject("departments",departments);
        return  modelAndView;
    }
    @GetMapping("create-department")
    public ModelAndView getFormCreateDepartment(){
        ModelAndView modelAndView = new ModelAndView("/department/create");
        modelAndView.addObject("department", new Department());
        return modelAndView;
    }

    @PostMapping("create-department")
    public ModelAndView saveDepartment(@ModelAttribute Department department){
        departmentService.save(department);
        ModelAndView modelAndView = new ModelAndView("/department/create");
        modelAndView.addObject("department", new Department());
        modelAndView.addObject("message","New department created successfully");
        return modelAndView;
    }

    @GetMapping("/delete-department/{id}")
    public ModelAndView loadFormDelete(@PathVariable Long id){
        Department department = departmentService.findById(id);
        if(department != null) {
            ModelAndView modelAndView = new ModelAndView("/department/delete");
            modelAndView.addObject("department", department);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-department")
        public String deleteDepartment(@ModelAttribute("department") Department department){
            departmentService.remove(department.getId());
            return "redirect:departments";
    }

     @GetMapping("/edit-department/{id}")
    public ModelAndView getFormEditDepartment(@PathVariable Long id){
        Department department = departmentService.findById(id);
        if(department !=null){
            ModelAndView modelAndView = new ModelAndView("/department/edit");
            modelAndView.addObject("department", department);
            return modelAndView;
        } else{
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
    @PostMapping("/edit-department")
    public ModelAndView updateDepartment(@ModelAttribute Department department)
    {
        departmentService.save(department);
        ModelAndView modelAndView = new ModelAndView("/department/edit");
        modelAndView.addObject("department",department);
        modelAndView.addObject("message", "Department update successfully");
        return modelAndView;
    }
    @GetMapping("/view-department/{id}")
    public ModelAndView viewDepartment(@PathVariable Long id)
    {
        Department department = departmentService.findById(id);
        if(department == null){
            ModelAndView modelAndView = new ModelAndView("/error.404");
        }
        Iterable<Employee> employees = employeeService.findAllByDepartment(department);
        ModelAndView modelAndView = new ModelAndView("/department/view");
        modelAndView.addObject("department",department);
        modelAndView.addObject("employees",employees);
        return modelAndView;
    }







}
