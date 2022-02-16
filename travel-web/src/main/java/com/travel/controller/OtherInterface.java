package com.travel.controller;

import com.travel.reponse.Result;
import com.travel.reponse.form.ArticleForm;
import com.travel.reponse.form.CategoryForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("第三方接口信息")
public interface OtherInterface {

    @ApiOperation("加载所有的分类数据")
    Result cmsCategories();

    @ApiOperation("读取分类下的文章")
    Result cmsArticles(CategoryForm categoryForm);

    @ApiOperation("读取文章内容")
    Result cmsDetail(ArticleForm articleId);
}
