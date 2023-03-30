package ezen.hang.heritage.register.entity;

import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@ToString
public class Register {
    @Id
    @GeneratedValue

    private Long id;
    @Column
    private String name;
    @Column
    private String userId;
    @Column
    private String password;
    @Column
    private int pnumber;
    @Column
    private String email;
}
