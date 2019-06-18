package org.daming.address.web;

import org.daming.address.pojo.City;
import org.daming.address.pojo.Province;
import org.daming.address.service.ICityService;
import org.daming.address.service.IProvinceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ApiController {

    private IProvinceService provinceService;
    private ICityService cityService;

    @GetMapping("provinces")
    public List<Province> listProvinces() {
        return this.provinceService.listProvinces();
    }


    @GetMapping("province/{code}")
    public Province getProvince(@PathVariable String code) {
        return this.provinceService.getProvince(code);
    }

    @GetMapping("cities")
    public List<City> listCities() {
        return this.cityService.listCities();
    }

    @GetMapping("city/{code}")
    public City getCity(@PathVariable String code) {
        return this.cityService.getCity(code);
    }

    public ApiController(IProvinceService provinceService,ICityService cityService) {
        super();
        this.provinceService = provinceService;
        this.cityService = cityService;
    }
}
