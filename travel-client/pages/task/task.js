var app = getApp();
// pages/article/article.js
Page({
 
  data: {
    Scenic: {},
    Name: "",
    Description: "",
    Strategy: "",
    Connection: "",
  },
  /**
   * Lifecycle function--Called when page load
   */
  onLoad: function () {
    //调用应用实例的方法获取全局数据
    var that = this;
    //通过原生调取数据
    wx.request({ 
      url: app.getUrl() + '/city/random',
      method: "GET",
      header: {
        "content-type": "application/json"
      },
      success: function (res) {
        var da = res.data.data;
        that.setData({ "Scenic": da.Scenic });
        that.setData({ "Name": da.Name});
        that.setData({ "Description": da.Description});
        that.setData({ "Strategy": da.Strategy});
        that.setData({ "Connection": da.Connection});
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