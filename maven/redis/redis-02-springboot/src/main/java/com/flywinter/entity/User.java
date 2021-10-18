package com.flywinter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/8/5 17:03
 * Description:
 */
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
//再企业中，我们所有的pojo都会序列化
public class User  implements Serializable{
    private String name;
    private int age;
}
