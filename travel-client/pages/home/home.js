const app = getApp();
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
    pingluncontent:''
  },
 
  /**
   * Lifecycle function--Called when page load
   */
  onLoad: function () {
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