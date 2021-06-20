package me.fulln.converter.convert;

import me.fulln.converter.Car;
import me.fulln.converter.CarDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

/**
 * @author fulln
 * @version 0.0.1
 * @program converter
 * @description mapStruct的工具类转换
 * @date 2021/6/16 1:14
 **/
@Mapper
//@Mapper(componentModel = "spring")
public interface CarMapper extends Converter<Car, CarDto> {

    CarMapper MAPPER = Mappers.getMapper(CarMapper.class);

    @Mapping(target = "seatCount", source = "numberOfSeat")
    @Override
    CarDto convert(Car car);
    /**
     * list 转换
     * @param cars
     * @return
     */
    List<CarDto> convertList(List<Car> cars);
}
