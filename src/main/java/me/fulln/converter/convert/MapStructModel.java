package me.fulln.converter.convert;

import com.alibaba.fastjson.JSON;
import me.fulln.converter.Car;
import me.fulln.converter.CarDto;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author fulln
 * @version 0.0.1
 * @program converter
 * @description
 * @date 2021/6/20 11:48
 **/
@Service
public class MapStructModel implements ConvertDomain{

    /**
     * 执行
     *
     */
    @Override
    public CarDto execute() {
        Car car =car();
        car.setMake(UUID.randomUUID().toString());
        car.setNumberOfSeat(RandomUtils.nextInt());
        CarDto convert = CarMapper.MAPPER.convert(car);
        List<Car> carList = carList();
        List<CarDto> dtoList = CarMapper.MAPPER.convertList(carList);
        System.out.println(JSON.toJSON(dtoList));
        return convert;
    }
}
