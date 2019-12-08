package com.lml.controller;

import com.lml.entity.Emp;
import com.lml.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("emp")
public class EmpController {
    @Autowired
    private EmpService empService;

    @RequestMapping("queryByPage")
    public String queryByPage(HttpServletRequest request, Integer nowPage, Integer endPage) {
        Integer num = empService.queryNum();
        if (nowPage == null) {
            nowPage = 1;
        }

        if (num % 3 == 0) {
            endPage = num / 3;
        } else {
            endPage = num / 3 + 1;
        }
        List<Emp> list = empService.queryByPage(nowPage * 3 - 3, 3);
        request.setAttribute("list", list);
        request.setAttribute("nowPage", nowPage);
        request.setAttribute("endPage", endPage);
        return "/emp/emplist";
    }

    @RequestMapping("add")
    public String add(Emp emp) {
        emp.setId(UUID.randomUUID().toString());
        empService.add(emp);
        return "redirect:/emp/queryByPage";
    }

    @RequestMapping("delete")
    public String delete(String id) {
        empService.delete(new Emp().setId(id));
        return "redirect:/emp/queryByPage";
    }

    @RequestMapping("update")
    public String update(Emp emp) {
        empService.update(emp);
        return "redirect:/emp/queryByPage";
    }

    @ResponseBody
    @RequestMapping("queryOne")
    public Emp queryOne(Emp emp) {
        return empService.queryOne(emp);
    }
}
