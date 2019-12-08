package com.lml.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Emp implements Serializable {
    private String id;
    private String name;
    private String salary;
    private String age;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date bir;
    private String dept_id;
}
