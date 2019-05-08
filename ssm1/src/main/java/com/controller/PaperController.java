package com.controller;
import com.pojo.Paper;
import com.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
@Controller
@RequestMapping("/a")
public class PaperController {
    @Autowired
    private PaperService paperService;
    int code;
    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String getUser(ModelMap modelMap) {
        try {
            List<Paper> users = paperService.queryAllPaper();
                if(users.size()!=0){
                    code=0;
            modelMap.addAttribute("users", users);
            modelMap.addAttribute("code",code);
                return "userlist";
            }else{
            code=-101;
            modelMap.addAttribute("code",code);
            return "result";
            }
        } catch (Exception e) {
            code=-1000;
            modelMap.addAttribute("code",code);
            e.printStackTrace();
            return "result";
        }
    }
    //查询id
    @RequestMapping(value = "/student/{id}",method = RequestMethod.GET)
    public String getUserById(@PathVariable("id") int id,ModelMap modelMap) {
        try{
            List<Paper> users = paperService.getUserById(id);
            if(users.size()>0){
                code= 0;
                modelMap.addAttribute("code", code);
                modelMap.addAttribute("users",users);
                return "userlist";
            }else{
                code=-101;
                modelMap.addAttribute("code",code);
                return "result";
            }
        }catch (Exception e){
            code=-400;
            modelMap.addAttribute("code",code);
            return "result";
        }
    }
//    @RequestMapping(value = "/studentadd",method = RequestMethod.GET)
//    public ModelAndView addPage(){
//        ModelAndView mav=new ModelAndView("add");
//        return mav;
//    }
//    @RequestMapping(value = "/student",method = RequestMethod.POST)
//    public  String createUser(@RequestParam("name")String name,@RequestParam("id") int id ,ModelMap modelMap){
//       Paper paper=new Paper();
//        paper.setName(name);
//        paper.setId(id);
//        if(paper.getId()!=0&&paper.getName()!=null){
//            code=paperService.addPaper(paper)?0:-300;
//            modelMap.addAttribute("code",code);
//            return "result";
//        }else{
//            code=-300;
//            modelMap.addAttribute("code",code);
//            return "result";
//        }
//    }
    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public  String add(@RequestParam("name")String name,ModelMap modelMap){
        Paper paper=new Paper();
        paper.setName(name);
        if(paper.getName()!=null){
            code=paperService.addPaper(paper)?0:-300;
            modelMap.addAttribute("code",code);
            return "add";
        }else{
            code=-300;
            modelMap.addAttribute("code",code);
            return "add";
        }
    }
    @RequestMapping(value = "/student/{id}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") int id, ModelMap modelMap){
        code=paperService.deletePaperById(id)?0:-200;
        modelMap.addAttribute("code",code);
        return "result";
    }
//    @RequestMapping(value = "/studentput/{id}",method = RequestMethod.GET)
//    public ModelAndView updatePage(@PathVariable("id")int id){
//        Paper paper=paperService.getUserById(id).get(0);
//        ModelAndView mav=new ModelAndView("update","usertoput",paper);
//        return mav;
//    }
    @RequestMapping(value = "/student/{id}",method = RequestMethod.PUT)
    public String update(@PathVariable("id")int id,@RequestParam("name")String name,ModelMap modelMap){
        Paper paper=new Paper();
        paper.setId(id);
        paper.setName(name);
        //paperService.updatePaper(paper);
        code=paperService.updatePaper(paper)?0:-500;
        //ModelAndView mav=new ModelAndView("update","usertoput",paper);
        modelMap.addAttribute("code",code);
        return "update";
    }
}
