var app = getApp();
// pages/strategy/strategy.js
Page({

  data: {
    // detailNews:{}
    title:'广州',
    articleId:0,
    newsdetail:{},
    newsId:0,
    pingluncontent:'',
    getList:[
      {
        image:'https://cwag-dingding-app.oss-cn-beijing.aliyuncs.com/huashan1.jpg',
      },
      {
        image:'https://img0.baidu.com/it/u=607507856,3841653179&fm=26&fmt=auto&gp=0.jpg',
      },
      {
        image:'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fb4-q.mafengwo.net%2Fs8%2FM00%2FC1%2F6D%2FwKgBpVYSRe6AedqoAAiPNaoGG8831.jpeg%3FimageView2%2F2%2Fw%2F680%2Fq%2F90&refer=http%3A%2F%2Fb4-q.mafengwo.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1632554666&t=601af28b306fa9c290662ab902627e96',
      },
    ],
    indicatorDots: true,
    autoplay: true,
    interval: 5000,
    duration: 800
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

  //跳转☞地图
  openMapTap: function () {
    wx.navigateTo({
      url: '../map/map'
    })
  },
    // 跳转☞游玩攻略
    openStrategy:function(){
      wx.navigateTo({
        url: '/pages/safe/safe'
      })
      // wx.showToast({
      //   title: '暂无数据',
      //   image:'/img/none.png'
  
      // })
    },

      // 跳转☞详情
  onclick:function() {
    wx.navigateTo({
      url: '/pages/details/details'
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