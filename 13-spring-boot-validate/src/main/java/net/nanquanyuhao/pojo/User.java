package net.nanquanyuhao.pojo;

import javax.validation.constraints.NotBlank;

/**
 * Created by nanquanyuhao on 2018/11/14.
 */
public class User {

    @NotBlank(message = "用户名不能为空") // 非空校验
    private String name;

    @NotBlank(message = "密码不能为空") // 密码非空校验
    private String password;
    private Integer age;

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

    @Override
    public String toString() {
        return "User [name=" + name + ", password=" + password + ", age="
                + age + "]";
    }

}
