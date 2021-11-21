// pages/register/register.js
//添加app的引用
var app = getApp();
Page({

  /**
   * Page initial data
   */
  data: {
    //定义变量
    name: '',
    password: '',
    email: '',
    title: '',
    hobby: '',
  },
  //获取form中的数据事件
  nameInput: function (e) {
    this.setData({
      name: e.detail.value
    })
  },
  passwordInput: function (e) {
    this.setData({
      password: e.detail.value
    })
  },

  emailInput: function (e) {
    this.setData({
      email: e.detail.value
    })
  },
  titleInput: function (e) {
    this.setData({
      title: e.detail.value
    })
  },
  hobbyInput: function (e) {
    this.setData({
      hobby: e.detail.value
    })
  },

  /**
   * Lifecycle function--Called when page load
   */
  onLoad: function (options) {

  },
  //用户注册
  reg: function () {
    console.log(this.data);
    if (this.data.name == '' || this.data.name == undefined || this.data.password == '' || this.data.password == undefined || this.data.email == '' || this.data.email == undefined || this.data.title == '' || this.data.title == undefined || this.data.hobby == '' || this.data.hobby == undefined) {
      wx.showModal({
        title: '系统提示',
        content: '用户名、密码、态度、邮箱、爱好！',
        showCancel: false,
        confirmText: '确认',
        success: function (res) {
          if (res.confirm) {
            console.log('用户点击确定')
          }
        }
      })
    } else {
      //请求注册
      var that = this;
      wx.request({
        url: app.getUrl() + '/user/register',
        method: 'POST',
        data:{
          "Username": that.data.name,
          "Password": that.data.password,
          "Email": that.data.email,
          "Title": that.data.title,
          "Hobby": that.data.hobby

        },
        success: function (res) {
          console.log("===================");
          console.log(res);
          if (res.data.code == 200) {
            wx.showToast({
              title: '注册成功',
              icon: 'success',
              complete: function () {
                wx.redirectTo({
                  url: "/pages/login/login"
                })
              }
            })
          } else if (res.data.code == 302) {
            wx.showModal({
              title: '系统提示',
              content: '用户名已经存在！',
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
        },
        complete: function () {
          // complete
        }
      })
    }
  },

  //用户登录
  todenglu: function () {
    wx.redirectTo({
      url: "/pages/login/login"
    })
    // console.log(this.data);
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