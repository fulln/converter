package me.fulln.converter.convert;

import fr.xebia.extras.selma.Field;
import fr.xebia.extras.selma.Mapper;
import me.fulln.converter.Car;
import me.fulln.converter.CarDto;

import java.util.List;

/**
 * @author fulln
 * @version 0.0.1
 * @program converter
 * @description
 * @date 2021/6/20 13:30
 **/
@Mapper(
        withCustomFields = {
                @Field({"Car.numberOfSeat", "seatCount"})
        }
)
public interface SelmaMapper {

        CarDto convert(Car car);

        List<CarDto> convertList(List<Car> cars);
}
