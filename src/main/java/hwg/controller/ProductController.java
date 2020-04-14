package hwg.controller;

import hwg.dao.generate.mapper.CountryMapper;
import hwg.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: hwg
 * @Date: Create in 2020/1/13
 */
@RestController
public class ProductController {
    @Autowired
    private CountryMapper countryMapper;

    @RequestMapping(value = "/consul", method = RequestMethod.GET)
    public Country consul() {
        Country country = countryMapper.selectByPrimaryKey(1);
        return country;
    }
}
