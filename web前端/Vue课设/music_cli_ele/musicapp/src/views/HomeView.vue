<!--这是视图组件-->
<template>
  <TopNav></TopNav>
 <SwiperTop></SwiperTop>
 <Iconlist></Iconlist>
<MusicList></MusicList>
</template>

<script>
// @ is an alias to /src
import TopNavVue from '@/components/home/TopNav.vue';//@代表src
import SwiperTop from '@/components/home/SwiperTop.vue';
import Iconlist from '@/components/home/Iconlist.vue';
import MusicList from '@/components/home/MusicList.vue';
export default {
  name: 'HomeView',
  components: {
   TopNav:TopNavVue,
  SwiperTop,
  Iconlist,
  MusicList

  }
}

</script>
