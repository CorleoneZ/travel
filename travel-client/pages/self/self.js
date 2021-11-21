//添加app的引用
var app = getApp();
var sliderWidth = 96; // 需要设置slider的宽度，用于计算中间位置

Page({
  data: {
    //定义变量
    name: '',
    email: '',
    title: '',
    hobby:'',
    sliderLeft: 0
  },
  onLoad: function () {
    var that = this;
    console.log("app.globalData.userInfo ： " + app.globalData.userInfo);
    that.setData({
      name: app.globalData.userInfo.name
    });
    that.setData({
      email: app.globalData.userInfo.email
    });
    that.setData({
      title: app.globalData.userInfo.title
    });
    that.setData({
      hobby: app.globalData.userInfo.hobby
    })
  },
//用户登录
  todenglu: function () {
    wx.redirectTo({
      url: "/pages/login/login"
    })                                                                                                         
   // console.log(this.data);
  },
});