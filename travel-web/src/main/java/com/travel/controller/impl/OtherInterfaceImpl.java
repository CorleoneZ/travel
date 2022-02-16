package com.travel.controller.impl;

import com.travel.controller.OtherInterface;
import com.travel.exception.CodeEnum;
import com.travel.reponse.Result;
import com.travel.reponse.back.Article;
import com.travel.reponse.back.CmsArticles;
import com.travel.reponse.back.CmsCategories;
import com.travel.reponse.form.CategoryForm;
import com.travel.service.ArticleService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/other")
public class OtherInterfaceImpl implements OtherInterface {

    private List<CmsCategories> cmsCategories;
    private List<CmsArticles> cmsArticles;
    private List<CmsArticles> resA;
    private ArticleService articleService;

    @Override
    @RequestMapping(path = "/category/list", method = RequestMethod.GET)
    public Result cmsCategories() {
        cmsCategories = new ArrayList<>();
        cmsCategories.add(CmsCategories.builder().id(5709).isUse(true).level(1).name("当季推荐").paixu(0).pid(0).shopId(0).userId(7709).build());
        cmsCategories.add(CmsCategories.builder().icon("http://p1-q.mafengwo.net/s16/M00/CB/38/CoUBUl_ax2iAJDppAAFeX7CeYNQ76.jpeg?imageMogr2%2Fthumbnail%2F%21413x233r%2Fgravity%2FCenter%2Fcrop%2F%21413x233%2Fquality%2F100").id(5711).isUse(true).key("国内").level(2).name("呼伦贝尔").paixu(0).pid(5709).pids(",5709,").remark("四季皆宜，夏秋最佳").shopId(0).type("tj").userId(7709).build());
        cmsCategories.add(CmsCategories.builder().icon("http://p1-q.mafengwo.net/s17/M00/D0/D1/CoUBXl_rB26ATff_AAD09ufK4TQ70.jpeg?imageMogr2%2Fthumbnail%2F%21413x233r%2Fgravity%2FCenter%2Fcrop%2F%21413x233%2Fquality%2F100").id(5712).isUse(true).key("亚洲").level(2).name("日本").paixu(0).pid(5709).pids(",5709,").remark("四季皆宜，北海道").shopId(0).userId(7709).build());
        cmsCategories.add(CmsCategories.builder().icon("http://p1-q.mafengwo.net/s16/M00/F6/14/CoUBUl_rB0aAcu2rAAH0oaDx5_g07.jpeg?imageMogr2%2Fthumbnail%2F%21413x233r%2Fgravity%2FCenter%2Fcrop%2F%21413x233%2Fquality%2F100").id(5713).isUse(true).key("海岛").level(2).name("吉普岛").paixu(0).pid(5709).pids(",5709,").remark("11月-次年4月最佳").shopId(0).type("tj").userId(7709).build());
        cmsCategories.add(CmsCategories.builder().icon("http://p1-q.mafengwo.net/s6/M00/3E/DD/wKgB4lLOSm6ACwqaAAgUs5BnOi064.jpeg?imageView2%2F2%2Fw%2F680%2Fq%2F90").id(5719).isUse(true).key("欧洲").level(2).name("阿姆斯特丹").paixu(0).pid(5709).pids(",5709,").remark("安妮故居").shopId(0).type("tj").userId(7709).build());

        cmsCategories.add(CmsCategories.builder().id(5710).isUse(true).level(1).name("热门游记").paixu(0).pid(0).shopId(0).userId(7709).build());
        cmsCategories.add(CmsCategories.builder().icon("http://note.mafengwo.net/mfs/s19/M00/7C/ED/CoNHvGH2KzhKRcOPAAtNKPDX4jQ.jpg?imageMogr2%2Fthumbnail%2F%21440x300r%2Fstrip%2Fgravity%2FCenter%2Fcrop%2F%21440x300%2Fquality%2F90").id(5714).isUse(true).level(2).key("Love").name("2000公里逐雪").paixu(0).pid(5710).pids(",5710,").remark("在纯白的世界说一句：我爱你").shopId(0).userId(7709).build());
        cmsCategories.add(CmsCategories.builder().icon("http://note.mafengwo.net/img/aa/48/cd476d8ddbfb7a8d5815d472033e77d4.jpeg?imageMogr2%2Fthumbnail%2F%21440x300r%2Fstrip%2Fgravity%2FCenter%2Fcrop%2F%21440x300%2Fquality%2F90").id(5715).isUse(true).level(2).key("Decorative").name("无尽风光在新疆").paixu(0).pid(5710).pids(",5710,").remark("新疆 这个美好的名词").shopId(0).userId(7709).build());
        cmsCategories.add(CmsCategories.builder().icon("http://note.mafengwo.net/img/8a/38/889489a71064fa0e0485f0946c6604d9.jpeg?imageMogr2%2Fthumbnail%2F%21440x300r%2Fstrip%2Fgravity%2FCenter%2Fcrop%2F%21440x300%2Fquality%2F90").id(5716).isUse(true).level(2).key("Land").name("南极日记").paixu(0).pid(5710).pids(",5710,").remark("巡游在世界的尽头").shopId(0).userId(7709).build());
        return Result.success(CodeEnum.SUCCESS, cmsCategories);
    }

    @Override
    @RequestMapping(path = "/news/list", method = RequestMethod.POST)
    public Result cmsArticles(@RequestBody CategoryForm categoryForm) {
        cmsArticles = new ArrayList<>();
        resA = new ArrayList<>();
        int cateId = categoryForm.getCategoryId();
        cmsArticles.add(CmsArticles.builder().categoryId(5711).commentNumber(158).dateAdd("2019-10-17 10:56:38").dateUpdate("2022-02-15 19:22:33").descript("四季皆宜，夏秋最佳").hasTourJourney(false).id(18168)
                .isDraft(false).isRecommend(true).keywords("国内").numberFav(0).paixu(0).pic("http://p1-q.mafengwo.net/s16/M00/CB/38/CoUBUl_ax2iAJDppAAFeX7CeYNQ76.jpeg?imageMogr2%2Fthumbnail%2F%21413x233r%2Fgravity%2FCenter%2Fcrop%2F%21413x233%2Fquality%2F100").status(2).statusStr("审核通过")
                .title("呼伦贝尔").uid(0).unusefulNumber(0).usefulNumber(1).userId(7709).views(2532).build());
        /*cmsArticles.add(CmsArticles.builder().categoryId(5711).commentNumber(141).dateAdd("2019-10-17 10:55:59").dateUpdate("2022-02-15 19:22:33").descript("四季皆宜，夏秋最佳").hasTourJourney(false).id(18167)
                .isDraft(false).isRecommend(true).keywords("香港，澳门").numberFav(0).paixu(0).pic("https://dcdn.it120.cc/2019/10/17/dba5e0ec-bea2-4d64-ae09-09056c7d8d5b.jpeg").status(2).statusStr("审核通过")
                .title("体验一下港澳人民的生活").uid(0).unusefulNumber(0).usefulNumber(0).userId(7709).views(1781).build());
        cmsArticles.add(CmsArticles.builder().categoryId(5711).commentNumber(148).dateAdd("2019-10-17 10:32:15").dateUpdate("2022-02-15 19:22:58").descript("香港游乐园").hasTourJourney(false).id(18165)
                .isDraft(false).isRecommend(true).keywords("香港，街拍").numberFav(1).paixu(0).pic("https://dcdn.it120.cc/2019/10/17/6281d6a0-c67a-4b0a-8cde-6065da7543f3.jpeg").status(2).statusStr("审核通过")
                .title("香港游乐园").uid(0).unusefulNumber(0).usefulNumber(0).userId(7709).views(1768).build());
        cmsArticles.add(CmsArticles.builder().categoryId(5711).commentNumber(114).dateAdd("2019-10-17 10:57:24").dateUpdate("2022-02-15 13:30:57").descript("高冷才能看出本质").hasTourJourney(false).id(18169)
                .isDraft(false).isRecommend(false).keywords("摄影的本质").numberFav(0).paixu(0).pic("https://dcdn.it120.cc/2019/10/17/093e86e1-665a-4af7-8e9c-6308492555f8.jpeg").status(2).statusStr("审核通过")
                .title("高冷才能看出本质").uid(0).unusefulNumber(0).usefulNumber(0).userId(7709).views(678).build());
        cmsArticles.add(CmsArticles.builder().categoryId(5711).commentNumber(108).dateAdd("2019-10-17 10:54:54").dateUpdate("2022-02-15 13:30:30").descript("澳门的奢华").hasTourJourney(false).id(18166)
                .isDraft(false).isRecommend(false).keywords("澳门，街拍").numberFav(0).paixu(0).pic("https://dcdn.it120.cc/2019/10/17/4903ce8c-09cd-458e-a83a-b511ef752b4b.jpeg").status(2).statusStr("审核通过")
                .title("澳门的奢华").uid(0).unusefulNumber(0).usefulNumber(0).userId(7709).views(436).build());
        cmsArticles.add(CmsArticles.builder().categoryId(5711).commentNumber(110).dateAdd("2019-10-17 10:31:18").dateUpdate("2022-02-12 23:25:02").descript("义乌新光辉街拍").hasTourJourney(false).id(18164)
                .isDraft(false).isRecommend(false).keywords("街拍，义乌").numberFav(0).paixu(0).pic("https://dcdn.it120.cc/2019/10/17/e4b804b8-594d-4be0-a8be-954e8880f134.jpeg").status(2).statusStr("审核通过")
                .title("义乌新光汇").uid(0).unusefulNumber(0).usefulNumber(0).userId(7709).views(337).build());*/
        cmsArticles.add(CmsArticles.builder().categoryId(5712).commentNumber(109).dateAdd("2019-11-10 14:05:32").dateUpdate("2022-02-15 13:31:09").descript("亚洲").hasTourJourney(false).id(19994)
                .isDraft(false).isRecommend(false).keywords("亚洲").numberFav(0).paixu(0).pic("http://p1-q.mafengwo.net/s17/M00/D0/D1/CoUBXl_rB26ATff_AAD09ufK4TQ70.jpeg?imageMogr2%2Fthumbnail%2F%21413x233r%2Fgravity%2FCenter%2Fcrop%2F%21413x233%2Fquality%2F100").status(2).statusStr("审核通过")
                .title("日本").uid(0).unusefulNumber(0).usefulNumber(0).userId(7709).views(645).build());
        cmsArticles.add(CmsArticles.builder().categoryId(5713).commentNumber(157).dateAdd("2019-10-17 10:58:02").dateUpdate("2022-02-15 13:31:09").descript("海岛").hasTourJourney(false).id(18170)
                .isDraft(false).isRecommend(true).keywords("海岛").numberFav(0).paixu(0).pic("http://p1-q.mafengwo.net/s16/M00/F6/14/CoUBUl_rB0aAcu2rAAH0oaDx5_g07.jpeg?imageMogr2%2Fthumbnail%2F%21413x233r%2Fgravity%2FCenter%2Fcrop%2F%21413x233%2Fquality%2F100").status(2).statusStr("审核通过")
                .title("吉普岛").uid(0).unusefulNumber(0).usefulNumber(0).userId(7709).views(2036).build());


        cmsArticles.add(CmsArticles.builder().categoryId(5714).commentNumber(29).dateAdd("2021-04-24 19:05:21").dateUpdate("2022-02-15 16:27:45").descript("在纯白的世界说一句：我爱你").hasTourJourney(false).id(71245)
                .isDraft(false).isRecommend(true).keywords("Love").numberFav(0).paixu(0).pic("http://note.mafengwo.net/mfs/s19/M00/7C/ED/CoNHvGH2KzhKRcOPAAtNKPDX4jQ.jpg?imageMogr2%2Fthumbnail%2F%21440x300r%2Fstrip%2Fgravity%2FCenter%2Fcrop%2F%21440x300%2Fquality%2F90").status(2).statusStr("审核通过")
                .title("2000公里逐雪").uid(0).unusefulNumber(0).usefulNumber(0).userId(7709).views(768).build());
        cmsArticles.add(CmsArticles.builder().categoryId(5715).commentNumber(7).dateAdd("2021-04-24 18:49:17").dateUpdate("2022-02-15 16:27:45").descript("新疆 这个美好的名词").hasTourJourney(false).id(71244)
                .isDraft(false).isRecommend(true).keywords("Decorative").numberFav(0).paixu(0).pic("http://note.mafengwo.net/img/aa/48/cd476d8ddbfb7a8d5815d472033e77d4.jpeg?imageMogr2%2Fthumbnail%2F%21440x300r%2Fstrip%2Fgravity%2FCenter%2Fcrop%2F%21440x300%2Fquality%2F90").status(2).statusStr("审核通过")
                .title("无尽风光在新疆").uid(0).unusefulNumber(0).usefulNumber(0).userId(7709).views(105).build());
        cmsArticles.add(CmsArticles.builder().categoryId(5716).commentNumber(29).dateAdd("2021-04-24 19:05:21").dateUpdate("2022-02-15 16:27:45").descript("巡游在世界的尽头").hasTourJourney(false).id(71245)
                .isDraft(false).isRecommend(true).keywords("Land").numberFav(0).paixu(0).pic("http://note.mafengwo.net/img/8a/38/889489a71064fa0e0485f0946c6604d9.jpeg?imageMogr2%2Fthumbnail%2F%21440x300r%2Fstrip%2Fgravity%2FCenter%2Fcrop%2F%21440x300%2Fquality%2F90").status(2).statusStr("审核通过")
                .title("南极日记").uid(0).unusefulNumber(0).usefulNumber(0).userId(7709).views(405).build());
        /*cmsArticles.add(CmsArticles.builder().categoryId(5714).commentNumber(29).dateAdd("2021-04-24 19:05:21").dateUpdate("2022-02-15 16:27:45").descript("蓝牙耳机拍摄").hasTourJourney(false).id(71245)
                .isDraft(false).isRecommend(true).keywords("蓝牙耳机拍摄").numberFav(0).paixu(0).pic("https://dcdn.it120.cc/2021/04/24/c32258e6-74bd-49f4-b309-753f0f6e3c70.jpg").status(2).statusStr("审核通过")
                .title("蓝牙耳机拍摄").uid(0).unusefulNumber(0).usefulNumber(0).userId(7709).views(768).build());
        cmsArticles.add(CmsArticles.builder().categoryId(5714).commentNumber(29).dateAdd("2021-04-24 19:05:21").dateUpdate("2022-02-15 16:27:45").descript("蓝牙耳机拍摄").hasTourJourney(false).id(71245)
                .isDraft(false).isRecommend(true).keywords("蓝牙耳机拍摄").numberFav(0).paixu(0).pic("https://dcdn.it120.cc/2021/04/24/c32258e6-74bd-49f4-b309-753f0f6e3c70.jpg").status(2).statusStr("审核通过")
                .title("蓝牙耳机拍摄").uid(0).unusefulNumber(0).usefulNumber(0).userId(7709).views(768).build());
        cmsArticles.add(CmsArticles.builder().categoryId(5714).commentNumber(29).dateAdd("2021-04-24 19:05:21").dateUpdate("2022-02-15 16:27:45").descript("蓝牙耳机拍摄").hasTourJourney(false).id(71245)
                .isDraft(false).isRecommend(true).keywords("蓝牙耳机拍摄").numberFav(0).paixu(0).pic("https://dcdn.it120.cc/2021/04/24/c32258e6-74bd-49f4-b309-753f0f6e3c70.jpg").status(2).statusStr("审核通过")
                .title("蓝牙耳机拍摄").uid(0).unusefulNumber(0).usefulNumber(0).userId(7709).views(768).build());*/

        if (cateId == 5709) {
            for (CmsArticles s : cmsArticles) {
                if (s.getCategoryId() == 5711 || s.getCategoryId() == 5712 || s.getCategoryId() == 5713) {
                    resA.add(s);
                }
            }
        } else if (cateId == 5710) {
            for (CmsArticles s : cmsArticles) {
                if (s.getCategoryId() == 5714 || s.getCategoryId() == 5715 || s.getCategoryId() == 5716) {
                    resA.add(s);
                }
            }
        } else {
            for (CmsArticles s : cmsArticles) {
                if (s.getCategoryId() == categoryForm.getCategoryId()) {
                    resA.add(s);
                }
            }
        }

        return Result.success(CodeEnum.SUCCESS, resA);
    }

    @Override
    public Result cmsDetail(int articleId) {
        articleService.initArticle();
        Article article = articleService.getArticle(articleId);
        return Result.success(CodeEnum.SUCCESS, article);
    }
}
