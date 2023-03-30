package ezen.hang.heritage.register.controller;

import ezen.hang.heritage.register.dto.RegisterForm;
import ezen.hang.heritage.register.entity.Register;
import ezen.hang.heritage.register.repository.RegisterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class registerController {
    @Autowired
    private RegisterRepository registerRepository;

    @GetMapping("/fragments/register")
    public String registerAccount(){
        return "fragments/register";
    }

    @PostMapping("/fragments/createAccount")
    public String createAccount(RegisterForm form){
        log.info(form.toString());

        Register register = form.toEntity();
        log.info(register.toString());

        Register saved = registerRepository.save(register);
        log.info(saved.toString());


        return "";
    }
}
