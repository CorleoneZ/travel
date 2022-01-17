package com.travel.controller.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.travel.controller.CityController;
import com.travel.entity.City;
import com.travel.entity.CityScenic;
import com.travel.entity.Strategy;
import com.travel.entity.UserExperience;
import com.travel.exception.CodeEnum;
import com.travel.orm.mapper.CityMapper;
import com.travel.orm.mapper.CityScenicMapper;
import com.travel.orm.mapper.StrategyMapper;
import com.travel.orm.mapper.UserExperienceMapper;
import com.travel.reponse.Result;
import com.travel.reponse.back.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/v1/city")
public class CityControllerImpl implements CityController {

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private CityScenicMapper cityScenicMapper;

    @Autowired
    private StrategyMapper strategyMapper;

    @Autowired
    private UserExperienceMapper userExperienceMapper;

    @Override
    @RequestMapping(path = "/pop", method = RequestMethod.GET)
    public Result popCityList() {

        List<City> list = new ArrayList<>();
        list = cityMapper.selectList(new QueryWrapper<City>().eq("pop",1));

        List<PopCity> pops = new ArrayList<>();
        for (City a : list) {
            pops.add(PopCity.builder().
                    name(a.getCityName()).
                    description(a.getDetail()).build());
        }
        return Result.success(CodeEnum.SUCCESS, pops);
    }

    @Override
    @RequestMapping(path = "/search/{name}", method = RequestMethod.GET)
    public Result searchCity(@PathVariable String name) {
        try {
            City city = cityMapper.selectOne(new QueryWrapper<City>().eq("city_name", name));
            List<CityScenic> list = cityScenicMapper.selectList(new QueryWrapper<CityScenic>().eq("city", name));
            List<Scenic> scenicList = new ArrayList<>();
            for (CityScenic s : list) {
                scenicList.add(Scenic.builder().name(s.getScenic()).detail(s.getDetail()).build());
            }
            SearchCity searchCity = SearchCity.builder()
                    .name(city.getCityName())
                    .detail(city.getDetail())
                    .scenicList(scenicList).build();

            return Result.success(CodeEnum.SUCCESS, searchCity);
        } catch (Exception e) {
            return Result.fail(CodeEnum.COMMON_ERROR);
        }
    }

    @Override
    @RequestMapping(path = "/random", method = RequestMethod.GET)
    public Result random() {
        RandomCity randomCity = new RandomCity();
        List<City> cityList = cityMapper.selectList(new QueryWrapper<City>());
        Random random = new Random();
        int rand = random.nextInt(cityList.size());

        //city detail
        for (int i = 0; i < cityList.size();++i) {
            if (i == rand) {
                String cityName = cityList.get(i).getCityName();
                randomCity.setName(cityName);
                randomCity.setDescription(cityList.get(i).getDetail());
                randomCity.setConnection(cityList.get(i).getConnectionCity());
            }
        }
        //city scenic
        List<Scenic> scenicList = new ArrayList<>();
        List<CityScenic> cityScenics = cityScenicMapper.selectList(new QueryWrapper<CityScenic>().eq("city", randomCity.getName()));
        for (CityScenic s : cityScenics) {
            scenicList.add(Scenic.builder().name(s.getScenic())
                    .detail(s.getDetail()).build());
        }
        randomCity.setScenicList(scenicList);
        //city strategy
        Strategy strategy = strategyMapper.selectOne(new QueryWrapper<Strategy>().eq("city", randomCity.getName()));
        randomCity.setStrategy(strategy);

        return Result.success(CodeEnum.SUCCESS, randomCity);
    }

    @Override
    @RequestMapping(path = "/strategy/{name}", method = RequestMethod.GET)
    public Result strategy(@PathVariable String name) {
        try {
            Strategy strategy = strategyMapper.selectOne(new QueryWrapper<Strategy>().eq("city", name));
            CityStrategy cityStrategy = CityStrategy.builder()
                    .name(name)
                    .title(strategy.getTitle())
                    .strategy(strategy.getStrategy())
                    .foods(strategy.getFoods())
                    .remark(strategy.getRemark())
                    .build();

            return Result.success(CodeEnum.SUCCESS, cityStrategy);
        } catch (Exception e) {
            return Result.fail(CodeEnum.COMMON_ERROR);
        }
    }

    @Override
    @RequestMapping(path = "/recommend", method = RequestMethod.GET)
    public Result recommend() {
        List<Strategy> strategies = strategyMapper.selectList(new QueryWrapper<Strategy>().eq("pop",1));
        List<CityStrategy> cityStrategies = new ArrayList<>();
        for (Strategy s : strategies) {
            cityStrategies.add(CityStrategy.builder()
                    .name(s.getCity())
                    .title(s.getTitle())
                    .strategy(s.getStrategy())
                    .foods(s.getFoods())
                    .remark(s.getRemark()).build());
        }
        return Result.success(CodeEnum.SUCCESS, cityStrategies);
    }

    @Override
    @RequestMapping(path = "/light/{name}/{city}", method = RequestMethod.POST)
    public void light(@PathVariable String name, @PathVariable String city) {
        UserExperience experience = UserExperience.builder().username(name).city(city).build();
        userExperienceMapper.insert(experience);
        System.out.println(city);
        System.out.println(name);
    }

    @Override
    @RequestMapping(path = "/gone/{name}", method = RequestMethod.GET)
    public Result goneCity(@PathVariable String name) {
        List<UserExperience> list = new ArrayList<UserExperience>();
        Set<UserExperience> set = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();
        list = userExperienceMapper.selectList(new QueryWrapper<UserExperience>().eq("username",name));
        for (UserExperience s : list) {
            set.add(s);
        }

        for (UserExperience s : set) {
            stringBuilder.append(s.getCity());
            stringBuilder.append(" ");
        }
        System.out.println(stringBuilder.toString());
        return Result.success(CodeEnum.SUCCESS,stringBuilder.toString());
    }

}
