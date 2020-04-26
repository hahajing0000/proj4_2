package com.zy.storage.greendao.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import org.greenrobot.greendao.annotation.Generated;

/**
 * @author:zhangyue
 * @date:2020/4/25
 */
@Entity
public class TestEntity {

    @Id(autoincrement = true)
    private Long id;

    private String username;

    private String other;

    @Generated(hash = 2146200476)
    public TestEntity(Long id, String username, String other) {
        this.id = id;
        this.username = username;
        this.other = other;
    }

    @Generated(hash = 1020448049)
    public TestEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", other='" + other + '\'' +
                '}';
    }
}
