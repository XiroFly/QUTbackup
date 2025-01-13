<template>
    <div class="musicList">
        <div class="musicTop">
            <div class="title">发现好歌单</div>
            <div class="more">查看更多</div>
        </div>
    </div>
    <div class="musicContent">
        <van-swipe :loop="false" :width="150" class="my-swipe" :show-indicators="false"><!--动态绑定-->
         <van-swipe-item v-for="item in state.musicList" :key="item.id" class="oneSwipe">
        <RouterLink :to="{path:'/songsheet' ,query:{id:item.id}}">
            <img :src="item.picUrl" />
            <span class="playCount">
            <svg class="icon" aria-hidden="true">
            <use xlink:href="#icon-24gl-play"></use>
            </svg>
            <!--播放量-->
            {{changeCount(item.playCount) }}
            </span>
        </RouterLink>
        <!--图片下方字-->
        <span class="name">{{ item.name }}</span>
   
        </van-swipe-item>
        
        </van-swipe>
    </div>
</template>
<script setup>
import {getMusicaList}from "@/request/API/home.js"
import { reactive,onMounted } from "vue";
const state=reactive({
    musicList:[],
})
function changeCount(num){
    if(num>=100000000){
        return (num/100000000).toFixed(2)+'亿'
    }
    else if(num>=10000)
    return (num/100000000).toFixed(2)+'万'
}
onMounted(async()=>{
  let res=await getMusicaList();
  state.musicList=res.data.result;
})
</script>
<!--lang=“less” 可以敲层级关系的样式
scoped 使style内的样式只作用于当前的界面-->
<style lang="less" scoped>
.musicList{
    width: 100%;
    height:1rem;
    padding: 0.2rem;
    .musicTop{
        width:100%;
        height: 0.6rem;
        display: flex;
        justify-content: space-between;
        .title{
            font-size: 0.4rem;
            font-weight: 900;
        }
        .more{
            border:1px solid #ccc;
            text-align: center;
            line-height:  0.6rem;
            padding: 0 0.2rem;
            border-radius: 0.4rem;//添加圆角边框
        }
    }


}
.musicContent{
    width:100%;
    height:4rem;
    .my-swipe{
    height: 100%;
    padding-left:  .16rem;
    .oneSwipe{
      img{
      width: 100%;
      height: 3rem;
      padding: .1rem;
      border-radius: 0.3rem;//添加圆角边框
      }
      .playCount{//播放量
       position: absolute;
       top: .2rem;
       right: .2rem;
       border:1px solid rgb(204, 204, 204);
       background-color: rgba(255,255,255,0.3);
       border-radius: 0.5rem;
       text-align: center;
       display: flex;
       justify-content:center ;
           .icon{
           margin: 2px;
           height: .3rem;
           width: .3rem;
           }
       }
   
     }
    }
}

</style>