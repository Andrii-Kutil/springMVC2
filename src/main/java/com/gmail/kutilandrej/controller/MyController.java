package com.gmail.kutilandrej.controller;

import com.gmail.kutilandrej.entity.Human;
import com.gmail.kutilandrej.service.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

  @Autowired
  private HumanService humanService;

  @RequestMapping("/")
  public String showAllHuman(Model model) {
    model.addAttribute("allHumans", humanService.getAllHumans());
    return "allHumans";
  }

  @RequestMapping("/addHuman")
  public String addHuman(Model model) {
    model.addAttribute("human", new Human());
    return "addHuman";
  }

  @RequestMapping("/saveHuman")
  public String saveHuman(@ModelAttribute("human") Human human) {
    humanService.saveHuman(human);
    return "redirect:/";
  }

  @RequestMapping("/updateHuman")
  public String updateHuman(@RequestParam("humanId") int id, Model model) {
    model.addAttribute("human", humanService.getHuman(id));
    return "addHuman";
  }

  @RequestMapping("/deleteHuman")
  public String deleteHuman(@RequestParam("humanId") int id) {
    humanService.deleteHuman(id);
    return "redirect:/";
  }
}
