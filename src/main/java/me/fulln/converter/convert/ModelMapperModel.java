package me.fulln.converter.convert;

import me.fulln.converter.Car;
import me.fulln.converter.CarDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fulln
 * @version 0.0.1
 * @program converter
 * @description
 * @date 2021/6/20 11:58
 **/
@Service
public class ModelMapperModel implements ConvertDomain {

    private static PropertyMap<Car, CarDto> customField() {
        /**
         * 自定义映射规则
         */
        return new PropertyMap<Car, CarDto>() {
            @Override
            protected void configure() {
                /**使用自定义转换规则*/
                map(source.getNumberOfSeat(), destination.getSeatCount());
            }
        };
    }

    /**
     * 执行
     */
    @Override
    public CarDto execute() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(customField());
        Car car = car();
        List<CarDto> dtoList = modelMapper.map(carList(),new TypeToken<List<CarDto>>() {}.getType());
        System.out.println(dtoList);
        return modelMapper.map(car, CarDto.class);
    }
}
