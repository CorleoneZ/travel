package com.travel.controller;

import com.travel.reponse.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("城市操作入口")
public interface CityController {

    @ApiOperation("返回主要热门城市简介列表")
    Result popCityList();

    @ApiOperation("搜索相关城市")
    Result searchCity(String name);

    @ApiOperation("随机推荐一个城市")
    Result random();

    @ApiOperation("某个城市攻略")
    Result strategy(String name);

    @ApiOperation("推荐城市攻略")
    Result recommend();
}
