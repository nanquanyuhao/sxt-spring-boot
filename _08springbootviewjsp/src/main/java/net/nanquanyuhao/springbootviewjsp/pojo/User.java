package net.nanquanyuhao.springbootviewjsp.pojo;

/**
 * Created by nanquanyuhao on 2018/11/13.
 */
public class User {

    private Integer userid;
    private String username;
    private Integer userage;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserage() {
        return userage;
    }

    public void setUserage(Integer userage) {
        this.userage = userage;
    }

    public User(Integer userid, String username, Integer userage) {
        super();
        this.userid = userid;
        this.username = username;
        this.userage = userage;
    }

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }
}
