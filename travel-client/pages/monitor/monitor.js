const app = getApp()
Page({
  data: {
    nickName: '',
    userInfoAvatar: '',
    array1: {},
    array2: {},
    array3: {},
    array4: {},
    sum: {},
    sex: [
      { name: '0', value: '男', checked: true },
      { name: '1', value: '女', checked: false },
    ],
    gender: 0,
    weight: 0,
    systolic: 0,
    diastolic: 0,
    heart: 0,
  },

  onLoad: function (options) {
    var array1 = []
    var array2 = []
    var array3 = []
    var array4 = []
    var that = this;
    for (var i = 40; i < 150; i++) {
      array1.push(i);
    }
    for (var j = 80; j < 200; j++) {
      array2.push(j);
    }
    for (var k = 50; k < 120; k++) {
      array3.push(k);
    }
    for (var p = 50; p < 160; p++){
      array4.push(p);
    }
    this.setData({
      array1: array1,
      array2: array2,
      array3: array3,
      array4: array4,
    })

    wx.getUserInfo({
      success: function (res) {
        // success  
        that.setData({
          nickName: res.userInfo.nickName,
          userInfoAvatar: res.userInfo.avatarUrl,
        })
      },
      fail: function () {
        // fail  
        console.log("获取失败！")
      },
      complete: function () {
        // complete  
        console.log("获取用户信息完成！")
      }
    })

    wx.getStorage({
      key: 'infoGender',
      success: function (res) {
        if (res.data) {
          var sex = that.data.sex
          sex[res.data].checked = true
          sex[1 - res.data].checked = false
          that.setData({
            gender: res.data,
            sex: sex
          })
        }
      }
    })

    wx.getStorage({
      key: 'infoWeight',
      success: function (res) {
        if (res.data) {
          that.setData({
            weight: res.data
          })
        }
      }
    })

    wx.getStorage({
      key: 'infosystolic',
      success: function (res) {
        if (res.data) {
          that.setData({
            systolic: res.data
          })
        }
      }
    })

    wx.getStorage({
      key: 'infodiastolic',
      success: function (res) {
        if (res.data) {
          that.setData({
            diastolic: res.data
          })
        }
      }
    })

    wx.getStorage({
      key: 'infoheart',
      success: function (res) {
        if (res.data) {
          that.setData({
            heart: res.data
          })
        }
      }
    })

  },

  sexChange: function (e) {
    console.log('性别：', e.detail.value)
    this.setData({
      gender: e.detail.value
    })
    try {
      wx.setStorage({ key: 'infoGender', data: parseInt(e.detail.value) })
    } catch (e) {

    }
  },
  
  bindWeightChange: function (e) {
    console.log('weight值', this.data.array1[e.detail.value])
    this.setData({
      weight: this.data.array1[e.detail.value]
    })
    try {
      wx.setStorage({ key: 'infoWeight', data: this.data.array2[e.detail.value] })
    } catch (e) {
    }
  },

  bindsystolicChange: function (e) {
    console.log('systolic值', this.data.array2[e.detail.value])
    this.setData({
      systolic: this.data.array2[e.detail.value]
    })
  },

  binddiastolicChange: function (e) {
    console.log('diastolic值', this.data.array3[e.detail.value])
    this.setData({
      diastolic: this.data.array3[e.detail.value]
    })
  },

  bindheartChange: function (e) {
    console.log('heart值', this.data.array4[e.detail.value])
    this.setData({
      heart: this.data.array4[e.detail.value]
    })
  },

  consume: function (e) {
    var weight = parseInt(this.data.weight);
    var systolic = parseInt(this.data.systolic);
    var diastolic = parseInt(this.data.diastolic);
    var heart = parseInt(this.data.heart);
    var sex = this.data.gender;
    console.log("weight:", weight);
    console.log("systolic:", systolic);
    console.log("diastolic:", diastolic);
    console.log("heart:", heart);

    //男女所占比重  
    var A;
    //计算A
    if (sex == 0) {
      A = 0.0127 * weight - 0.0698;
    }
    else if (sex == 1) {
      A = 0.0126 * weight - 0.0461;
    }
    console.log("A:", A)

    
    //高压低压心率分别占比指数
    var w;
    var s;
    var d;
    var h;

    if (weight >= 40 && weight <= 60){
      w = 80;
    }else if (weight >= 61 && weight <= 80){
      w = 85;
    }else if (weight >= 81 && weight <= 100){
      w = 70;
    }else if (weight >= 101 && weight <= 120){
      w = 60;
    }else if (weight >= 121 && weight <= 140){
      w = 50;
    }else if (weight >= 141 && weight <= 150){
      w = 40;
    }
    console.log("w:", w);

    if (systolic >= 80 && systolic <= 100) {
      s = 100;
    } else if (systolic >= 101 && systolic <= 120){
      s = 80;
    } else if (systolic >= 121 && systolic <= 140) {
      s = 60;
    } else if (systolic >= 141 && systolic <= 160) {
      s = 40;
    } else if (systolic >= 161 && systolic <= 180) {
      s = 20;
    } else if (systolic >= 181 && systolic <= 200) {
      s = 10;
    }
    console.log("s:", s)

    if (diastolic >= 50 && diastolic <= 60) {
      d = 80;
    }else if (diastolic >= 61 && diastolic <= 80){
      d = 100;
    } else if (diastolic >= 81 && diastolic <= 90) {
      d = 60;
    } else if (diastolic >= 91 && diastolic <= 100) {
      d = 40;
    } else if (diastolic >= 101 && diastolic <= 110) {
      d = 20;
    } else if (diastolic >= 111 && diastolic <= 120) {
      d = 10;
    }
    console.log("d:",d);

    if(heart >= 50 && heart <= 55){
      h = 40;
    }else if (heart >= 56 && heart <= 70){
      h = 100;
    }else if (heart >= 71 && heart <= 100){
      h = 80;
    }else if (heart >= 101 && heart <= 140){
      h = 60;
    }else if (heart >= 141 && heart <= 160){
      h = 40;
    }

    var dx = s * 0.35 + d * 0.35 + h * 0.15 + w * 0.15;
    this.data.dx = dx;
    console.log("dx:", dx)

    this.setData({
      daixie: this.data.dx
    })
  }

});