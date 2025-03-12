package com.newgen.Productrestapi.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class Post {
    private int id;
    private int userId;
    private String title;
    private String body;
}
