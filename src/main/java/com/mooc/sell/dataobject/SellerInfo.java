package com.mooc.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−09-04-10:27
 * @className: com.mooc.sell.dataobject.SellerInfo
 * @description: TODO
 */
@Data
@Entity
public class SellerInfo {

    @Id
    private String sellerId;

    private String username;

    private String password;

    private String openid;
}
