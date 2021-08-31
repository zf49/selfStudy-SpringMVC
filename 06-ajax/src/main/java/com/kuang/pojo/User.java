package com.kuang.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.cert.CertificateExpiredException;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

          private String name;
          private int age;
          private String sex;


}