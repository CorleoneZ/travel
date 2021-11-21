//添加app的引用
var app = getApp();
var sliderWidth = 96; // 需要设置slider的宽度，用于计算中间位置

Page({
  data: {
    tabs: ["登陆", "注册"],
    activeIndex: 1,
    sliderOffset: 0,
    //定义变量
    name: '',
    pass: '',
    sliderLeft: 0
  },
  onLoad: function () {
    var that = this;
    wx.getSystemInfo({
      success: function (res) {
        that.setData({
          sliderLeft: (res.windowWidth / that.data.tabs.length - sliderWidth) / 2,
          sliderOffset: res.windowWidth / that.data.tabs.length * that.data.activeIndex
        });
      }
    });
  },
  login: function () {
    console.log(this.data);
    if (this.data.name == '' || this.data.name == undefined || this.data.pass == '' || this.data.pass == undefined) {
      wx.showModal({
        title: '系统提示',
        content: '用户名或密码不能为空！',
        showCancel: false,
        confirmText: '知道了',
        success: function (res) {
          if (res.confirm) {
            console.log('用户点击确定')
          }
        }
      })
    } else {
      //请求登录
      var that = this;
      wx.request({
        url: app.getUrl() + '/user/login',
        data:{
          "Username": that.data.name,
          "Password": that.data.pass
        },
        method: 'POST',
        success: function (res) {
          console.log("===================");
          console.log(res);
          // 登录成功
          if (res.data.code == 200) {
            wx.setStorage({
              key: "Username",
              data: res.data.id
            })
            //全局存储
            // 可以将 res 发送给后台解码出 unionId
            app.globalData.userInfo = res.data.data;
            console.log("userinfo : " + res.data.data);
            wx.showToast({
              title: '登陆成功',
              icon: 'success',
              complete: function () {
                wx.switchTab({
                  url: '/pages/home/home'
                })
              }
            })

          } else {
            wx.showModal({
              title: '系统提示',
              content: '用户名或密码不正确！',
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
        fail: function () {
          // fail
          console.log("错误")
        },
        complete: function () {
          // complete
          console.log("complete")
        }
      })
    }
  },
//用户注册
  reg: function () {
    wx.redirectTo({
      url: "/pages/register/register"
    })                                                                                                         
   // console.log(this.data);
  },

//获取form中的数据事件
  nameInput: function (e) {
    this.setData({
      name: e.detail.value
    })
  },
  passwordInput: function (e) {
    this.setData({
      pass: e.detail.value
    })
  },


  
  tabClick: function (e) {
    this.setData({
      sliderOffset: e.currentTarget.offsetLeft,
      activeIndex: e.currentTarget.id
    });
  }
});