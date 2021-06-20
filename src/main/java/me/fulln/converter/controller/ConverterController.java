package me.fulln.converter.controller;

import me.fulln.converter.CarDto;
import me.fulln.converter.convert.MapStructModel;
import me.fulln.converter.convert.ModelMapperModel;
import me.fulln.converter.convert.SelmaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @author fulln
 * @version 0.0.1
 * @program converter
 * @description
 * @date 2021/6/20 11:16
 **/
@RequestMapping("/mapper")
@RestController
public class ConverterController {

    @Autowired
    @Qualifier("mapStructModel")
    private MapStructModel mapStructModel;


    @Autowired
    @Qualifier("modelMapperModel")
    private ModelMapperModel modelMapperModel;


    @Autowired
    @Qualifier("selmaModel")
    private SelmaModel selmaModel;

    @GetMapping("/thread")
    public String thread(@RequestParam Integer cube) {
        StringBuilder returns = new StringBuilder();
        Date date = new Date();
        returns.append("----------开始时间为:").append(date).append("-----------\n\r\t");

        ForkJoinPool executor = new ForkJoinPool();
        for (int i = 0; i <= 100; i++) {
            executor.invoke(new ForkJoinTask<CarDto>() {

                private static final long serialVersionUID = -3356988710715322451L;

                @Override
                public CarDto getRawResult() {
                    if (cube ==1){
                        return mapStructModel.execute();
                    }else if (cube == 2){
                        return modelMapperModel.execute();
                    }else if (cube ==3){
                       return selmaModel.execute();
                    }
                    return  null;
                }

                @Override
                protected void setRawResult(CarDto value) {

                }

                @Override
                protected boolean exec() {
                    return true;
                }
            });
        }
        Date endDate = new Date();

        returns.append("----------结束时间为: ").append(endDate).append("-----------\n\r\t");
        returns.append("----------相差时间为: ").append(endDate.getTime() - date.getTime()).append("-----------");
        return returns.toString();
    }

}
