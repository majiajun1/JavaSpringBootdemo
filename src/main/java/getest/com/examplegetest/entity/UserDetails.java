package com.examplegetest.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lbw
 * @since 2025-02-02
 */
@TableName("user_details")
public class UserDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer uid;

    private String address;

    private String phone;

    private String sex;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
        "uid = " + uid +
        ", address = " + address +
        ", phone = " + phone +
        ", sex = " + sex +
        "}";
    }
}
