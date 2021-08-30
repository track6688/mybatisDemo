package org.example.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author guojz
 */
@Data
public class User {
    private Long id;
    private String userName;
    private Integer age;
    private Date createTime;
}

