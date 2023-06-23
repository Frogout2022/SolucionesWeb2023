package com.proyecto.t2.controller.sistema;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("intranet/combo")
public class ComboController {

    @RequestMapping("/")
    public String inicio(){
        return "sistema/combo";
    }
}
