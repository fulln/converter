package me.fulln.converter.convert;

import me.fulln.converter.CarDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fulln
 * @version 0.0.1
 * @program converter
 * @description
 * @date 2021/6/20 15:05
 **/
@Service
public class BeanUtilsModel implements ConvertDomain {
    /**
     * 执行
     */
    @Override
    public CarDto execute() {
        CarDto dto = new CarDto();
        BeanUtils.copyProperties(car(),dto);
        List<CarDto> carDtoList = new ArrayList<>();
        BeanUtils.copyProperties(carList(),carDtoList);
        return dto;
    }
}
