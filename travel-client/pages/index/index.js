//index.js
//获取应用实例
const app = getApp()
Page({
  data: {
    imgUrls: [
      '../../images/t2.jpg',
      '../../images/t1.jpg',
      '../../images/t3.jpg'
    ],
    newslist:[], 
    motto: 'Hello World',
    userInfo: {},
    hasUserInfo: false, 
    canIUse: wx.canIUse('button.open-type.getUserInfo')
  },
  
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onLoad: function () {
    // 页面初始化 options为页面跳转所带来的参数
    console.log("index 首页 列表页面数据============================================");
    //调用应用实例的方法获取全局数据
    var that = this;
    //通过原生调取数据
    wx.request({
      url: app.getUrl() + '/api_lunwenlist.do',
      method: "POST",
      header: {
        "content-type": "application/json" 
      },
      success: function (a) {
        console.log("/api_lunwenlist.do >>>>>>>>>>>>>>");
        console.log(a);
        var da = a.data.data;
        that.setData({ "newslist": da });
        console.log("api_lunwenlist.do  end ================================");
      },
      fail: function (err) {
        console.log(err)
      }
    })

    console.log(this.data.data);
   // switch1(this.data.newslist);

    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
    } else if (this.data.canIUse){
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    } else {
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        }
      })
    }
  },

  //论文著作
  tolunwen: function () {
    wx.redirectTo({
      url: "/pages/lunwen/lunwen"
    })
    // console.log(this.data);
  },

  //知识产权
  tozhishichanquan: function () {
    wx.redirectTo({
      url: "/pages/register/register"
    })
    // console.log(this.data);
  },
  getUserInfo: function(e) {
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  }
})
