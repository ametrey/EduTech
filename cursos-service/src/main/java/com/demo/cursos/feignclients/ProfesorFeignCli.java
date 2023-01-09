package com.demo.cursos.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "profesor-service")
@RequestMapping("/profesores")
public interface ProfesorFeignCli {

}
