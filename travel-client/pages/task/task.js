const app = getApp()
var util = require('../../utils/util.js');
// pages/index/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
  theday:"",
  day:"10",
  des:"",
  statu:"",
  city:"",
  list:{},
  strategy:"",
  connection:"",
  },

  /**
   * 生命周期函数--监听页面加载
   */
  getToday: function () {
    let day =  util.formatTime(new Date()) ;
    let theday=day;  
    console.log(theday);
    this.setData({
     theDay:theday
    })
  },
  onLoad: function (options) {
  this.getToday();
  },
  getinformation: function(res){
    wx.request({
      url: app.getUrl() + '/city/random',
      method:"GET",
      success:(res)=>{
        console.log(res);
        this.setData({
          city:res.data.data.Name,
          des:res.data.data.Description,
          strategy:res.data.data.Strategy,
          statu:2,
          list:res.data.data.Scenic,
          connection:res.data.data.Connection
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