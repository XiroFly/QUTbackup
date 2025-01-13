<template>
    <img :src="playlist.coverImgUrl" alt="" class="bgimg">
    <div class="theTop">
        
        <div class="itemLeft">
        <svg class="icon" aria-hidden="true" @click="$router.go(-1)">
      <use xlink:href="#icon-zuojiantou"></use>
      </svg>
     <span>歌单</span>
    </div>
    <div class="itemRight">
        <svg class="icon" aria-hidden="true">
      <use xlink:href="#icon-fangdajing"></use>
      </svg>
      <svg class="icon" aria-hidden="true">
      <use xlink:href="#icon-liebiao2"></use>
      </svg>
    </div>
</div>
 <div class="theMid">
 
<img :src="playlist.coverImgUrl" alt="" class="midLeft">
<div class="midRight">
    <div class="top">{{playlist.description }}</div>
    <div class="mid">
        <img :src="playlist.creator.avatarUrl" alt="" class="midRightImg"> 
         <span style="margin: 0.1rem;">{{ playlist.creator.nickname }}</span> 
    </div>
    <div class="end">
        <span v-for="item in playlist.tags" :key="item">{{ item }}</span>
    </div>
</div>
</div>
<div class="theBottom">
   <div class="an-icon"> <svg class="icon"    aria-hidden="true">
      <use xlink:href="#icon-xiaoxi"></use>
      </svg>
      <span>{{ detials.commentCount}}</span>
    </div>
    <div class="an-icon"> <svg class="icon"   aria-hidden="true">
      <use xlink:href="#icon-fenxiang"></use>
      </svg>
      <span>{{ detials.shareCount}}</span>
    </div>
    <div class="an-icon"> <svg class="icon"   aria-hidden="true" >
      <use xlink:href="#icon-xiazai-wenjianxiazai-05"></use>
      </svg>
      <span>下载</span>
    </div>
    <div class="an-icon" v-if="booked==true"  @click="isBooked()"> 
        <svg class="icon" aria-hidden="true"   >
      <use  xlink:href="#icon-shoucang"></use>
      </svg>
      <span>{{ playlist.subscribedCount }}</span>
    </div>
    <div class="an-icon" v-else-if="booked==false"  @click="isBooked()"> 
        <svg class="icon" aria-hidden="true"   >
      <use  xlink:href="#icon-shoucang1"></use>
      </svg>
      <span>{{ playlist.subscribedCount }}</span> 
    </div>
</div>
</template>
<script setup>
import { ref } from 'vue';
 const props = defineProps(['playlist','detials',])
 if((props.playlist.creator=="")){
    props.playlist.creator=JSON.parse(sessionStorage.getItem('itemDetial').playlist).creator
 }
 let booked=ref(true)
function isBooked(){
    booked.value=!booked.value
}
</script>
<style lang="less" scoped>


.theTop{
  height: 1rem;
  width: 100%;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: .2rem;
  
  .itemLeft,.itemRight{
    width: 20%;
    height: 100%;
    display: flex;
   justify-content: space-between;
   align-items: center;
   
   span{
    font-size: .4rem;
    color: white;
   }
   
  }
 
}
.bgimg{
    width: 100%;
    height: 5rem;
    position: fixed;
    top: 0;
    left: 0;
    z-index: -1;//一个元素在叠加顺序上的上下立体关系。
   filter: blur(20px);//虚化背景
  }
  .theMid{
    width: 100%;
    height:3rem;
    display: flex;
    justify-content: space-between;
    .midLeft{
        height: 100%;
        width: 3rem;
       margin: .2rem;
        border-radius: 0.2rem;

    }
    .midRight{
        height: 100%;
        width:3rem;
       margin: 0.2rem;
        .top{
            height: 0.8rem;
            width:3rem ;
            overflow:hidden;
            font-size: 100;
            color: white;
        }
        .mid{
           padding-top: 0.3rem;
           color:rgba(255, 255,255, 0.5);
            height: 1.2rem;
            width:100%;
            display: flex;
            justify-content:left ;
            text-align: center;
            .midRightImg{
                height: 0.6rem;
                width: 0.6rem;
                border-radius: 0.5rem;
            }
            
        }
        .end{
            color:rgba(255, 255,255, 0.4);
            height: 1rem;
            width:3rem ;
            overflow:hidden;
        }

    }
  }
  .theBottom{
    margin-top: .3rem;
    margin-bottom: .2rem;
    color: white;
    height: 1.5rem;
    width: 100%;
    display: flex;
    justify-content: space-around;
    align-items: center;
    .an-icon{
       height: 100%;
       width: 1.5rem;
        display: flex;
        flex-direction: column;
        align-items: center;
        .icon{
            height: 0.8rem;
            width: 0.8rem;
        fill:#fff;//填充颜色
        color: white;
   }
    }
  }
</style>