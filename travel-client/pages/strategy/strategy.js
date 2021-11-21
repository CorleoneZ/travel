var app = getApp();
// pages/strategy/strategy.js
Page({

  data: {
    // detailNews:{}
    articleId:0,
    newsdetail:{},
    newsId:0,
    pingluncontent:''
  },
 
  onLoad: function () {
    // 页面初始化 options为页面跳转所带来的参数
    console.log("lunwen 首页 列表页面数据============================================");
    //调用应用实例的方法获取全局数据
    var that = this;
    //通过原生调取数据
    wx.request({ 
      url: app.getUrl() + '/city/recommend',
      method: "GET",
      header: {
        "content-type": "application/json"
      },
      success: function (a) {
        console.log(a);
        var da = a.data.data;
        that.setData({ "newsdetail": da });
        console.log(da);
      },
      fail: function (err) {
        console.log(err)
      }
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