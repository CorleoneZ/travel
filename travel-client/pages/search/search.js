var app = getApp();
// pages/article/article.js
Page({

  /**
   * Page initial data
   */
  data: {
    imgUrls: [
      '../../images/details/display.png'
    ],
    newslist: [],
    cityName: "",
    cityDetail: "",
  },

  nameInput: function (e) {
    this.setData({
      cityName: e.detail.value
    })
  },
 
  /**
   * Lifecycle function--Called when page load
   */
  search: function () {
    app.globalData.city = this.data.cityName
    console.log("name: " + app.globalData.city)
    // 页面初始化 options为页面跳转所带来的参数
    //调用应用实例的方法获取全局数据
    console.log(this.data);
    if (this.data.cityName == '' || this.data.cityName == undefined ) {
      wx.showModal({
        title: '系统提示',
        content: '搜索城市名称不能为空！',
        showCancel: false,
        confirmText: '知道了',
        success: function (res) {
          if (res.confirm) {
            console.log('用户点击确定')
          }
        }
      })
    } else {
      var that = this;
      wx.request({ 
        url: app.getUrl() + 'city/search/' + that.data.cityName,
        method: "GET",
        header: {
          "content-type": "application/json"
        },
        success: function (res) {
          console.log(res);
          //搜索成功！
          if (res.data.code == 200) {
            wx.setStorage({
              key: "cityName",
              data: res.data.id
            })
            wx.showToast({
              title: '搜索成功！',
              icon: 'success',
              complete: function() {
                wx.navigateTo({
                  url: '/pages/scenic/scenic'
                })
              }
            })
          } else {
            wx.showModal({
              title: '系统提示',
              content: '输入的城市不正确！',
              showCancel: false,
              confirmText: '知道了',
              success: function (res) {
                that.setData({
                  name: '',
                  pass: ''
                })
              }
            })
          }
        },
        fail: function (err) {
          console.log(err)
        }
      })
    }
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