package me.fulln.converter;

import lombok.Data;

import java.io.Serializable;

@Data
public class CarDto implements Serializable {
    private String make;
    private Integer seatCount;
    private String type;
}