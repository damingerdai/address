package org.daming.address.web;

import org.daming.address.pojo.Province;
import org.daming.address.service.IProvinceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ApiController {

    private IProvinceService provinceService;

    @GetMapping("provinces")
    public List<Province> listProvince() {
        return this.provinceService.listProvinces();
    }

    public ApiController(IProvinceService provinceService) {
        super();
        this.provinceService = provinceService;
    }
}
