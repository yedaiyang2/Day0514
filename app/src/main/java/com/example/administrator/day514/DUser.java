package com.example.administrator.day514;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2018/5/14 0014.
 */
@Entity//用于标识这是一个需要Greendao帮我们生成代码的bean
public class DUser {
    @Id(autoincrement = true)//标明主键，括号里可以指定是否自增
    private Long id;
    @NotNull //非空
    private String name;
    private String age;
    @Generated(hash = 212177181)
    public DUser(Long id, @NotNull String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    @Generated(hash = 2086853187)
    public DUser() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAge() {
        return this.age;
    }
    public void setAge(String age) {
        this.age = age;
    }
}
