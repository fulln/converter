package me.fulln.converter.convert;

import me.fulln.converter.Car;
import me.fulln.converter.CarDto;

import java.util.Arrays;
import java.util.List;

/**
 * @author fulln
 * @version 0.0.1
 * @program converter
 * @description
 * @date 2021/6/20 11:22
 **/
public interface ConvertDomain {

    default Car car(){
        return new Car("转换测试", 11, "DD");
    }

    default List<Car> carList(){
        return  Arrays.asList(new Car("1", 1, "21"),
                new Car("2", 2, "22"),
                new Car("2", 3, "23"));
    }

    /**
     * 执行
     *
     */
    CarDto execute();
}
