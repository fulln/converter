package me.fulln.converter.convert;

import fr.xebia.extras.selma.Selma;
import me.fulln.converter.CarDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fulln
 * @version 0.0.1
 * @program converter
 * @description
 * @date 2021/6/20 13:32
 **/
@Service
public class SelmaModel implements ConvertDomain {
    /**
     * 执行
     */
    @Override
    public CarDto execute() {
        // Get SelmaMapper
        SelmaMapper mapper = Selma.builder(SelmaMapper.class).build();
        List<CarDto> carDtos = mapper.convertList(carList());
        System.out.println(carDtos);
        // Map my InBean
        return mapper.convert(car());
    }
}
