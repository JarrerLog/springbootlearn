package com.vndustrybackend.vndustrybackend.Dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServerDTO {
    private String name;
    private int ping;
    private String ip;
    private String desc;
    private String map;
    private int wave;
    private String modeName;
    private String id;
}
