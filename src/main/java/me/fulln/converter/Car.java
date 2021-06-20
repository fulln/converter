package me.fulln.converter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author fulln
 * @version 0.0.1
 * @program converter
 * @description
 * @date 2021/6/16 1:12
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car implements  Serializable {
    private static final long serialVersionUID = -503109479813317444L;
    private String make;
    private Integer numberOfSeat;
    private String type;
}