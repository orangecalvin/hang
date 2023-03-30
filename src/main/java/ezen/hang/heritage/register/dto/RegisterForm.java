package ezen.hang.heritage.register.dto;

import ezen.hang.heritage.register.entity.Register;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class RegisterForm {

    private String name;
    private String userId;
    private String password;
    private int pnumber;
    private String email;


    public Register toEntity() {
        return new Register(null, name, userId, password, pnumber, email);
    }
}

