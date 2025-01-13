<template>
  <img :src="props.music.al.picUrl" class="bgimg" alt=""/>
 <div class="top">
    <div class="topleft">
        <svg class="icon" aria-hidden="true"  @click="$emit('close')" >
      <use  xlink:href="#icon-zuojiantou"></use>
      </svg>
      <div class="name">     
        <div class="a"><marquee>{{ props.music.name }}</marquee></div>
        <div class="b">
        <span v-for="item of props.music.ar" :key="item">{{ item.name }}</span>
        <svg class="icon" aria-hidden="true"  >
      <use  xlink:href="#icon-youjiantou"></use>
      </svg>
    </div> 
    </div>
     
    </div>
    <div class="topright">
        <svg class="icon" aria-hidden="true"   @click="showShare = true" >
      <use  xlink:href="#icon-fenxiang"></use>
      </svg>
    </div>  
 </div>
 <div class="content">
 <img src="@/assets/磁针.png" alt="" :class="(props.isShowPaused == false?'img_cizhen_active':'img_cizhen')"/>
 <img src="@/assets/cycle.png" alt="" class="img_cycle"/>
 <img :src="props.music.al.picUrl" alt="" class="pic" :class="(props.isShowPaused == false?'pic_active':'pic_paused')"/>
 </div>
 <!--歌词-->
 <div class="lyric" ref="musicLyric">
  <p v-for="item in Lyric" :key="item" :class="(props.currentTime*1000>=item.time&&props.currentTime*1000<item.pre?'active':'')">{{item.lrc}}</p>




 </div>
 <!--播放按钮-->
<div class="play">
  <svg class="icon" aria-hidden="true" v-if="props.isShowPaused" @click="$emit('changePlay')" >
      <use  xlink:href="#icon-24gf-play"></use>
      </svg>
      <svg class="icon" aria-hidden="true" v-else @click="$emit('changePlay')" >
      <use  xlink:href="#icon-24gf-pause2"></use>
      </svg>
</div>
 <van-share-sheet
  v-model:show="showShare"
  title="立即分享给好友"
  :options="options"
  @select="onSelect"
/>
</template>
<script setup>
import { ref ,computed,watch} from 'vue';
const props= defineProps(['music','isShowPaused','lyric','currentTime'])
const showShare = ref(false);
    const options = [
      { name: '微信', icon: 'wechat' },
      { name: '微博', icon: 'weibo' },
      { name: '复制链接', icon: 'link' },
      { name: '分享海报', icon: 'poster' },
      { name: '二维码', icon: 'qrcode' },
    ];
    const onSelect = (option) => {
      showToast(option.name);
      showShare.value = false;
    };

const Lyric=computed(()=>{
  let arr;
   if(props.lyric.lyric){
    arr=props.lyric.lyric.split(/[(\r\n)\r\n]+/).map((item,i)=>{
      let min=item.slice(item.indexOf('[')+1,item.indexOf(':'))
      let sec=item.slice(item.indexOf(':')+1,item.indexOf('.'))
      let mill=item.slice(item.indexOf('.')+1,item.indexOf(']'))
      let lrc=item.slice(item.indexOf(']')+1,item.length)
      let time=parseInt(min)*60*1000+parseInt(sec)*1000+parseInt(mill)
      return {min,sec,mill,lrc,time}
    })
   }
   arr.forEach((item,i) => {
    if(i===arr.length-1){
      item.pre=0
    }
    else{
      item.pre=arr[i+1].time
    }
   });
   return arr;
})
const musicLyric=ref()
watch(musicLyric,()=>{
  console.log('22222');
  let p=document.querySelector("p.active")
  console.log(p.offsetTop);//加括号看到引用
  console.log(musicLyric)
 if(p&&p.offsetTop>300){
  musicLyric.scrollTop=p.offsetTop-300
 }

 })
</script>
<style lang="less" scoped>
.bgimg{
  height: 100%;
  width: 100%;
  position: absolute;
  z-index: -1;
  filter: blur(1.4rem);

}
.top{
    height: 1rem;
    width: 100%;
    display: flex;
    justify-content: space-between;
    align-items: center;
    .topleft{
        height: 100%;
        width: 70%;
        display: flex;
        
        align-items: center;
        .name{
          margin-left: 1rem;
          
          .b{
            font-size: .1rem;
            color: #999;
            height: 40%;
            display: flex;
            justify-content: space-between;
            align-items: center;
            .icon{
                height: .2rem;
                width: 0.2rem;
            }
          }
          .a{
            font-size:.16rem;
            
          }
        }
    }
    .topright{
      margin-right: 0.4rem;
    }
}
.content{
  width: 100%;
  height: 9rem;
  display: flex;
  flex-direction:column;
  align-items: center;
  position: relative;
  .img_cizhen{
    width: 2rem;
    height: 3rem;
    position: absolute;
    left: 46%;
    transform-origin: 0 0;
    transform: rotate(-12deg);//转动度数
    transition: all 1.5s;  //过度渐变属性
    
  }
  .img_cizhen_active{
    width: 2rem;
    height: 3rem;
    position: absolute;
    left: 46%;
    transform-origin: 0 0;
    transform: rotate(0deg);//转动度数
    transition: all 0.5s;
     
    
  }
  .img_cycle{ 
    width: 5rem;
    height: 5rem;
    position: absolute;
    bottom: 2.3rem;
    z-index: -1;
  }
  .pic{
    width:3.2rem;
    height: 3.2rem;
    border-radius: 50%;
    position: absolute;
    bottom: 3.14rem;
    animation: rotate_pic 10s linear infinite   ; //设置规则： 匀速 无限循环,简写
   // animation-delay : 1.25s;延迟播放
  }
  //动画
  .pic_active{
    animation-play-state: running;
  }
  .pic_paused{
    animation-play-state: paused;
  }
  @keyframes rotate_pic {//关键帧
    0%{
      transform: rotateZ(0deg);
    }
    100%{
      transform: rotateZ(360deg);
    }
  }
}
.play{
  height: 2rem;
  width: 100%;
  display: flex;
  flex-direction:column;
  align-items: center;
  position: absolute;
  bottom: 0px;
   .icon{
    fill: white;
    height: 1rem;
    width: 1rem;
    position: absolute;
    bottom: 1rem;
   }
}
.lyric{
   width: 100%;
   height: 3rem;
   display: flex;
   flex-direction: column;
   align-items: center;
   overflow: scroll;//防溢出
   scroll-behavior: smooth;
   p{
    color: rgb(201, 201, 201);
    margin-bottom: 0.04rem;
   
    }
    .active{
      color :white;
      font-size: 0.4rem;

   }
}
</style>