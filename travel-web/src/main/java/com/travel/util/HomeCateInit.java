package com.travel.util;

import com.travel.reponse.back.Article;

import java.util.ArrayList;
import java.util.List;

public class HomeCateInit {

    private static List<Article> articleList;

    public static List<Article> init() {
        articleList = new ArrayList<>();
        articleList.add(Article.builder().categoryId(5711).commentNumber(157).content(ArticleDetail.D_18168.getDetail()).dateAdd("2019-10-17 10:58:02").dateUpdate("2022-02-16 14:07:19").descript("四季皆宜，夏秋最佳").hasTourJourney(false).id("18168").isDraft(false)
                .isRecommend(true).keywords("国内").numberFav(0).paixu(0).pic("http://p1-q.mafengwo.net/s16/M00/CB/38/CoUBUl_ax2iAJDppAAFeX7CeYNQ76.jpeg?imageMogr2%2Fthumbnail%2F%21413x233r%2Fgravity%2FCenter%2Fcrop%2F%21413x233%2Fquality%2F100")
                .status(2).statusStr("审核通过").title("呼伦贝尔").uid(0).unusefulNumber(0).usefulNumber(0).userId(7709).build());
        articleList.add(Article.builder().categoryId(5712).commentNumber(666).content(ArticleDetail.D_19994.getDetail()).dateAdd("2019-10-17 10:58:02").dateUpdate("2022-02-16 14:07:19").descript("四季皆宜，北海道").hasTourJourney(false).id("19994").isDraft(false)
                .isRecommend(true).keywords("亚洲").numberFav(0).paixu(0).pic("http://p1-q.mafengwo.net/s17/M00/D0/D1/CoUBXl_rB26ATff_AAD09ufK4TQ70.jpeg?imageMogr2%2Fthumbnail%2F%21413x233r%2Fgravity%2FCenter%2Fcrop%2F%21413x233%2Fquality%2F100")
                .status(2).statusStr("审核通过").title("日本").uid(0).unusefulNumber(0).usefulNumber(0).userId(7709).build());
        articleList.add(Article.builder().categoryId(5713).commentNumber(267).content(ArticleDetail.D_18170.getDetail()).dateAdd("2019-10-17 10:58:02").dateUpdate("2022-02-16 14:07:19").descript("11月-次年4月最佳").hasTourJourney(false).id("18170").isDraft(false)
                .isRecommend(true).keywords("海岛").numberFav(0).paixu(0).pic("http://p1-q.mafengwo.net/s16/M00/F6/14/CoUBUl_rB0aAcu2rAAH0oaDx5_g07.jpeg?imageMogr2%2Fthumbnail%2F%21413x233r%2Fgravity%2FCenter%2Fcrop%2F%21413x233%2Fquality%2F100")
                .status(2).statusStr("审核通过").title("吉普岛").uid(0).unusefulNumber(0).usefulNumber(0).userId(7709).build());

        articleList.add(Article.builder().categoryId(5714).commentNumber(29).content(ArticleDetail.D_71245.getDetail()).dateAdd("2019-10-17 10:58:02").dateUpdate("2022-02-16 14:07:19").descript("在纯白的世界说一句：我爱你").hasTourJourney(false).id("71245").isDraft(false)
                .isRecommend(true).keywords("Love").numberFav(0).paixu(0).pic("http://note.mafengwo.net/mfs/s19/M00/7C/ED/CoNHvGH2KzhKRcOPAAtNKPDX4jQ.jpg?imageMogr2%2Fthumbnail%2F%21440x300r%2Fstrip%2Fgravity%2FCenter%2Fcrop%2F%21440x300%2Fquality%2F90")
                .status(2).statusStr("审核通过").title("2000公里逐雪").uid(0).unusefulNumber(0).usefulNumber(0).userId(7709).build());
        articleList.add(Article.builder().categoryId(5715).commentNumber(899).content(ArticleDetail.D_71244.getDetail()).dateAdd("2019-10-17 10:58:02").dateUpdate("2022-02-16 14:07:19").descript("新疆 这个美好的名词").hasTourJourney(false).id("71244").isDraft(false)
                .isRecommend(true).keywords("Decorative").numberFav(0).paixu(0).pic("http://note.mafengwo.net/img/aa/48/cd476d8ddbfb7a8d5815d472033e77d4.jpeg?imageMogr2%2Fthumbnail%2F%21440x300r%2Fstrip%2Fgravity%2FCenter%2Fcrop%2F%21440x300%2Fquality%2F90")
                .status(2).statusStr("审核通过").title("无尽风光在新疆").uid(0).unusefulNumber(0).usefulNumber(0).userId(7709).build());
        articleList.add(Article.builder().categoryId(5716).commentNumber(984).content(ArticleDetail.D_71247.getDetail()).dateAdd("2019-10-17 10:58:02").dateUpdate("2022-02-16 14:07:19").descript("巡游在世界的尽头").hasTourJourney(false).id("71247").isDraft(false)
                .isRecommend(true).keywords("Land").numberFav(0).paixu(0).pic("http://note.mafengwo.net/img/8a/38/889489a71064fa0e0485f0946c6604d9.jpeg?imageMogr2%2Fthumbnail%2F%21440x300r%2Fstrip%2Fgravity%2FCenter%2Fcrop%2F%21440x300%2Fquality%2F90")
                .status(2).statusStr("审核通过").title("南极日记").uid(0).unusefulNumber(0).usefulNumber(0).userId(7709).build());


        return articleList;
    }
}
