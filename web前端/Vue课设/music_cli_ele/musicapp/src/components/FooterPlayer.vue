<template>
    <div class="FooterPlayer"> 
    <div class="footerLeft" @touchstart="date=$event.changedTouches[0].clientX" @touchend="switchMusic($event)" @click="toMusicDetial()"><!--回调函数有$event-->   
        <img :src="state.playList[state.playListIndex].al.picUrl" alt=""/>
    <div>
      <p>{{ state.playList[state.playListIndex].name }}</p>
      <span>横滑切换上下首</span>
    </div>
    </div> 
  

    <div class="footerRight">
        <svg class="icon" aria-hidden="true" @click="play()" v-if="state.isShowPaused">
      <use xlink:href="#icon-kaishi"></use>
      </svg>
      <svg class="icon" aria-hidden="true" @click="play()" v-else>
      <use xlink:href="#icon-zanting"></use>
      </svg>
       
      <RouterLink to="/PlayingMusic">
        <svg class="icon" aria-hidden="true"  >
      <use xlink:href="#icon-gedan"></use>
      </svg>
      
      </RouterLink>
        
      
    </div>
    </div>
    <div>
        <audio  @timeupdate="updateTime()"  ref="audio" :src=" `https://music.163.com/song/media/outer/url?id=${state.playList[state.playListIndex].id}.mp3`"></audio>
    </div>
    <!--弹窗-->
    <van-popup v-model:show="show" position="bottom" :style="{ height: '100%', width:'100%'}"   >
   <MusicDetial 
   :music="state.playList[state.playListIndex]" 
   :isShowPaused="state.isShowPaused"
   :lyric="state.lyric"
   :currentTime="state.currentTime"
   @changePlay="play()"
   
   
   @close=" show = false;"></MusicDetial>
    </van-popup>
</template>
<script setup >
import { useStore } from 'vuex';
import { ref,onUpdated,onMounted } from 'vue';
import MusicDetial from '@/components/MusicDetial.vue'

const store=useStore()
const state = store._state.data;//注意名字
// console.log(store._mutations)

const pause=store._mutations.updateIsShowPause[0];//选项加_，函数在数组里
const   updatePlayListIndex=store._mutations.updatePlayListIndex[0];
const audio=ref()
console.log(audio)
function updateTime(){
   
        store._mutations.updateCurrentTime[0](audio.value.currentTime)
}
function play(){
    if(audio.value.paused)
    {audio.value.play();
    pause(audio.value.paused)
    
}
    else {
        audio.value.pause();
        pause(audio.value.paused)
       
    }
}
const date=ref(0);
function switchMusic(e){
    console.log('aa')
    date.value=e.changedTouches[0].clientX-date.value
    if(date.value>80){
   //上一首
    if(state.playListIndex==0){updatePlayListIndex(state.playList.length-1)}
    
    else{updatePlayListIndex(state.playListIndex-1);}
}
    if(date.value<-80){
    //下一首
    updatePlayListIndex((state.playListIndex+1)% state.playList.length)
   
    }
}
const show = ref(false);
function toMusicDetial(){
    show.value = true;
}
onMounted(()=>{
    store.dispatch('getLyric',state.playList[state.playListIndex].id)
    
})
onUpdated(()=>{
    store.dispatch('getLyric',state.playList[state.playListIndex].id)
})

</script>
<style lang="less" scoped>
.FooterPlayer{
    width: 100%;
    height: 1.4rem;
 position : fixed;
 bottom:0;
 border-top:1px solid #999;
 background-color: white;
 display: flex;
 justify-content: space-between;
    
    .footerLeft{
    width: 60%;
    height: 100%;
    display: flex;
    padding: 0.2rem;
    justify-content: space-around;
    align-items: center;
   
    img{
        width: 1rem;
        height: 1rem;
        border-radius: 50%;
    }
    }
 
 .footerRight{
    margin-right: .2rem;
        width: 20%;
        height:100%;
        display: flex;
        justify-content: space-between;
        align-items: center;
        .icon{
          width: 0.6rem; 
          height: 0.6rem;
        }
    }

}
</style>

