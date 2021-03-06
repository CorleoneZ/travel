// pages/str_detail/str_detail.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    statu:"",
    list:{},
    strategy:"",
    connection:"",
    cityName: "",
    foods: "",
    remark: "",
    title: "",
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },
  nameInput: function (e) {
    this.setData({
      cityName: e.detail.value
    })
  },
  getinformation: function(res){
    var that = this;
    wx.request({
      url: app.getUrl() + 'city/strategy/' + that.data.cityName,
      method:"GET",
      success:(res)=>{
        console.log(res);
        this.setData({
          strategy:res.data.data.Strategy,
          statu:2,
          foods:res.data.data.foods,
          remark:res.data.data.remark,
          title:res.data.data.title
        })
      }
    })
    },
    inquire: function(res){
      this.setData({statu:1});
      this.getinformation();
    },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})