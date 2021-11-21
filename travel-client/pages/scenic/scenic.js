var app = getApp()
Page({
  data:{
    Name: '',
    Detail: "",
    Scenic: [],
  },

  onLoad: function () {
    var that = this;
    // 页面初始化 options为页面跳转所带来的参数
    //通过原生调取数据
    wx.request({ 
      url: app.getUrl() + '/city/search/' + app.globalData.city,
      data: {},
      method: "GET",
      header: {
        "content-type": "application/json"
      },
      success: function (res) {
        console.log(res);
        var city = res.data.data.Name;
        var detail = res.data.data.Detail;
        var list = res.data.data.ScenicList;
        that.setData({ "Secnic": list });
        that.setData({ "Name": city});
        that.setData({"Detail": detail});
      },
      fail: function (err) {
        console.log(err)
      }
    })
  },
  onShow:function(){
    // 页面显示
  },
  onHide:function(){
    // 页面隐藏
  },
  onUnload:function(){
    // 页面关闭
  }

})
