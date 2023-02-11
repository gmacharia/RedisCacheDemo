/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.redis.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author kobe
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movies implements Serializable{
    private long id;
    private String title;
    private String description;
    private String genre;
    
}

/*{
    "id": 1,
    "title": "Who Killed My Family",
    "description": "A mans family is killed and he goes back for revenge",
    "genre": "Action"
}*/