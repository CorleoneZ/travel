const app = getApp();
const WXAPI = require('apifm-wxapi')
const maxSmallCategoryNumber = 3; // 二级分类每列最多显示多少个
// pages/article/article.js
Page({

  /**
   * Page initial data
   */
  data: {
    // detailNews:{}
    articleId:0,
    newsdetail:{},
    newsId:0,
    pingluncontent:'',
    cmsCategories: undefined, // 分类列表
    cmsRecommendCategories: undefined, // 推荐的分类列表
  },
 
  /**
   * Lifecycle function--Called when page load
   */
   async onLoad(option) {
    var that = this;
    // 页面初始化 options为页面跳转所带来的参数
    //通过原生调取数据
    wx.request({ 
      url: app.getUrl() + '/city/pop',
      data: {},
      method: "GET",
      header: {
        "content-type": "application/json"
      },
      success: function (res) {
        console.log(res);
        var da = res.data.data;
        that.setData({ "newsdetail": da });
        //for (var i = 0; i < da.length - 1; i++ ) {}
      },
      fail: function (err) {
        console.log(err)
      }
    });

    // 加载所有的分类数据
    const cmsCategories = await WXAPI.cmsCategories();
    if (cmsCategories.code == 200) {
      const _cmsCategories = cmsCategories.data; // 所有分类数据
      // 筛选推荐的分类
      const cmsRecommendCategories = _cmsCategories.filter(entity => {
        return entity.type == 'tj';
      });
      // 一级分类下面，构造 swiper-item 数组
      _cmsCategories.filter(entity => {
        return entity.level == 1;
      }).forEach(bigCategory => {
        let tmpNumber = 0;
        bigCategory.swiperItems = [];
        bigCategory.swiperItems.push([]);
        const smallCategories = _cmsCategories.filter(entity => {
          return entity.pid == bigCategory.id;
        });
        while (smallCategories && smallCategories.length > 0) {
          const small = smallCategories.splice(0, 1);
          let swiperItemsLength = bigCategory.swiperItems.length;
          if (bigCategory.swiperItems[swiperItemsLength - 1].length >= maxSmallCategoryNumber) {
            bigCategory.swiperItems.push([]);
            swiperItemsLength++;
          }
          bigCategory.swiperItems[swiperItemsLength - 1].push(small[0]);
        }
      });
      this.setData({
        cmsCategories: _cmsCategories,
        cmsRecommendCategories: cmsRecommendCategories
      });
    }
    // 设置小程序名称
    wx.setNavigationBarTitle({
      title: wx.getStorageSync('mallName')
    })
  },


  goArticleList(e){
    wx.navigateTo({
      url: '/pages/classify/classify?pid=' + e.currentTarget.dataset.id
    })
  },

  /**
   * Lifecycle function--Called when page is initially rendered
   */
  onReady: function () {

  },

  /**
   * Lifecycle function--Called when page show
   */
  onShow: function () {

  },

  /**
   * Lifecycle function--Called when page hide
   */
  onHide: function () {

  },

  /**
   * Lifecycle function--Called when page unload
   */
  onUnload: function () {

  },

  /**
   * Page event handler function--Called when user drop down
   */
  onPullDownRefresh: function () {

  },

  /**
   * Called when page reach bottom
   */
  onReachBottom: function () {

  },

  /**
   * Called when user click on the top right corner to share
   */
  onShareAppMessage: function () {

  }
})