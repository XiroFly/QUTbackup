<template>
  <router-view/>
  <FooterPlayer></FooterPlayer>
  
</template>
<script setup>
import FooterPlayer from './components/FooterPlayer.vue';//播放器为全局组件

</script>
<style lang="less">
*{//整体调整
  margin: 0;
  padding: 0;
  box-sizing: border-box;//元素的总高度和宽度包含内边距和边框,设置内边距不会撑开盒子
}
.icon{
  width:.5rem;
  height:.5rem;
}
a{
  color:black;
}
</style>
