package com.mystudy.spring.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@Entity
public class User
{
    @Id
    @NotNull
    @GeneratedValue(generator = "jpa-uuid")
    private String id;

    @NotNull
    private String userName;

    private Integer age;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }
}
