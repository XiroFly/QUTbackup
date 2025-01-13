<template>
    <div class="itemMusicList">
        <div class="itemListTop">
        <div class="listLeft">
         <svg class="icon"    aria-hidden="true">
         <use xlink:href="#icon-yinlechangpian"></use>
         </svg>
         <span>
            播放全部<span>(共{{ SongSheetList.length }}首)</span>
         </span>
        </div>
        <div class="listRight">
            <svg class="icon"    aria-hidden="true">
         <use xlink:href="#icon-gedan"></use>
         </svg>
        </div>  
        </div>
       <div class="itemList">
        <div class="item" v-for="(item,i) in SongSheetList" :key="i">
        <div class="itemLeft" @click="playMusic(item)">
            <span class="leftSpan">{{ i+1 }}</span>
            <div>
                 <!--拿作曲名-->
                <p>{{item.name}}</p>
                <!--拿作者名-->
                <span v-for="(item1,index) in item.ar" :key="index">{{ item1.name }}</span>
            </div>
        </div>
        <div class="itemRight">
            <svg class="icon bofang" aria-hidden="true" v-if='item.mv !=0'><!--有mv-->
            <use xlink:href="#icon-shipin"></use>
          </svg>
          <svg class="icon liebiao" aria-hidden="true">
            <use xlink:href="#icon-liebiao2"></use>
          </svg>
        </div>
        </div>
       </div>
      
    </div>
</template>
<script setup>
import { useStore } from 'vuex';
const props = defineProps(['SongSheetList'])
if((props.SongSheetList=="")){
    props.SongSheetList=JSON.parse(sessionStorage.getItem('itemDetial').SongSheetList)
 }
const store=useStore()


 function  playMusic(item){
    store._mutations.updatePlayingList[0](item)
   
    };
    
</script>
<style lang="less" scoped>
.itemMusicList {
  width: 100%;
 
  background-color: #fff;
  padding: 0 0.2rem;
  margin-top: 0.2rem;
  border-top-left-radius: 0.4rem;//圆角矩形
  border-top-right-radius: 0.4rem;
  .itemListTop {
    width: 100%;
    height: 1rem;
    display: flex;
    justify-content: space-between;//两端对齐
    align-items: center;
    .listLeft {
      width: 3rem;
      height: 100%;
      display: flex;
      justify-content: space-between;
      align-items: center;
      .icon {
        stroke: #333333;
        stroke-width: 20;
      }
      span {
        font-weight: 700;
        span {
          font-weight: 400;
          font-size: 0.24rem;
          color: #999;
        }
      }
    }
    .listRight {
      display: flex;
      align-items: center;
      background-color: red;
      padding: 0.2rem;
      border-radius: 0.4rem;
      color: #fff;
      .icon {
        width: 0.3rem;
        height: 0.3rem;
        fill: #fff;
        margin-right: 0.1rem;
        stroke: #fff;
        stroke-width: 50;
      }
    }
  }
  .itemList {
    width: 100%;
    .item {
      width: 100%;
      height: 1.4rem;
      display: flex;
      justify-content: space-between;
      align-items: center;
      .itemLeft {
        width: 85%;
        height: 100%;
        display: flex;
        align-items: center;
        .leftSpan {
          display: inline-block;
          width: 0.2rem;
          text-align: center;
        }
        div {
          p {//作曲名
            width: 4.54rem;
            height: .4rem;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
            font-weight: 700;
          }
          span{//作者名
            font-weight: 400;
            font-size: .24rem;
            color: #999;
          }
          margin-left: 0.3rem;
        }
      }
      .itemRight{
        width: 20%;
        height: 100%;
        display: flex;
        // justify-content: space-between;
        align-items: center;
        position: relative;
        .icon{
          fill: #999;
        }
         .bofang{
            position: absolute;
            left: 0;
          }
         .liebiao{
            position: absolute;
            right: 0;
          }
      }
    }
  }
}
</style>
