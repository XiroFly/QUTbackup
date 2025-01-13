import { getMusicLyric } from '@/request/API/home';
import { createStore } from 'vuex'

export default createStore({
  state: {
    playList: [{ //播放列表
      al: {
        id: 89039055,
        name: "雨爱抖音版",
        pic: 109951164966568500,
        picUrl: "https://p1.music.126.net/2f6UgY8Jc0Dy6jufMdIZeQ==/109951164966568495.jpg",
        pic_str: "109951164966568495"
      },
      id: 1446137141,
      name: "雨爱（抖音版）",
      ar:[{name: "灏灏灏仔"}]
    }],
    playListIndex: 0, //默认下标为0
    isShowPaused : true,//暂停按钮是否显示
    lyric:{},
    currentTime:0
  },
  getters: {
  },
  mutations: {
    //注意index不能越界
    updateIsShowPause(state,value){
      
      state.isShowPaused=value;
    },
    updatePlayingList(state,value){
    state.playList.unshift(value)
     state.playListIndex=0;
     state.isShowPaused=false;//异步问题,play()是异步函数
      // document.getElementsByTagName('audio')[0].play();//双击两次才会执行
   document.getElementsByTagName('audio')[0].autoplay=true;
    
     
    },
    updatePlayListIndex(state,index){
     state.playListIndex=index;
     if(state.isShowPaused){
      document.getElementsByTagName('audio')[0].autoplay=false;
     }
     else{
      document.getElementsByTagName('audio')[0].autoplay=true;
     }
    },
    deletePlayList(state,index){
      if(state.playListIndex>=index&&index!=0){state.playListIndex--;}
       state.playList.splice(index,1)
       
       
    },
    updateLyric(state,value){
    state.lyric=value;
    },
    updateCurrentTime(state,value){
     state.currentTime=value;
    
    }
  },
  actions: {//保存异步方法
   async getLyric(context,id ){
    let res=await getMusicLyric(id)
    console.log(res);
    context.commit('updateLyric',res.data.lrc)
   }
  },
  modules: {
  }
})
