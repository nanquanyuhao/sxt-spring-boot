package net.nanquanyuhao.pojo;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * Created by nanquanyuhao on 2018/11/14.
 */
public class User {

    @NotBlank(message = "用户名不能为空") // 非空校验
    @Length(min = 2, max = 6, message = "最小长度为2位，最大长度为6位")
    private String name;

    @NotEmpty
    private String password;

    @Min(value = 15)
    private Integer age;

    @Email
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", password=" + password + ", age="
                + age + "]";
    }

}
