package com.cos.jwtEx01.model;

import javax.persistence.*;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String password;
    private String roles;



    
    //ENUM으로 안하고, 로 구분해서 ROLE을 입력 => 파싱
    //콤마를 이용해서 입력 - DB원자성을 의도적으로 사용
    public List<String> getRoleList(){
    	
        if(this.roles.length() > 0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }


}
