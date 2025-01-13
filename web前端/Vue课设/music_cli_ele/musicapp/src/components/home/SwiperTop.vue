<template>
  <div id="swiperTop">
     <!--懒加载-->
  <van-swipe :autoplay="3000" lazy-render >
  <van-swipe-item v-for="image in state.images" :key="image">
    <img :src="image.pic" />
  </van-swipe-item>
</van-swipe>
  </div>

</template>
<script>
//import axios from 'axios'
import { reactive,onMounted } from 'vue';
import {getBanner} from '@/request/API/home.js'
export default{
    setup() {

    const state =reactive({
     images: [

    ]});
    onMounted(async()=>{
      // axios.get('http://localhost:3000/banner?type=2').then((res)=>{
      // console.log(res);
      // state.iamges=res.data.pic;
      let res=await  getBanner();// async 用于申明一个 function 是异步的，而 await 用于等待一个异步方法执行完成。
      state.images=res.data.banners;
    });
      
    
  
    return { state }
}
}

</script>
<style lang="less" >
#swiperTop{

  .van-swipe{
    width: 100%;
    height: 4rem;

    .van-swipe__track{
      .van-swipe-item{
        padding:0.2rem;
        img{
          width: 100%;
          height: 100%;
          border-radius: 0.3rem;//添加圆角边距
        }
      }

    }
    .van-swipe__indicator--active{
    background-color: rgb(219,130,130);
    }
  }
}


</style>
