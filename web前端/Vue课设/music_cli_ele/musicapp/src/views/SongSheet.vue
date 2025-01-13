<!--歌单详情页，先获取数据，在渲染页面-->
<template>
    <TheTop 
    :playlist="state.playlist" 
    :detials="state.singleSheetDetials"
    ></TheTop>
    <TheBottum
    :SongSheetList="state.SongSheetList"
    ></TheBottum>
</template>
<script setup>
import { useRoute } from 'vue-router';//this.$route
import { onBeforeMount,reactive } from 'vue';
import {getSongSheet, getSongSheetDetails,getSongSheetList}from '@/request/API/SongSheet'
import  TheTop  from '@/components/SongSheet/TheTop.vue'//引入组件不加括号
import TheBottum from '@/components/SongSheet/TheBottum.vue';
const state=reactive({
    
    playlist:{},
    singleSheetDetials:{},
    SongSheetList:[],

});
onBeforeMount(async()=>{//在挂载前调用，用onMount组件未得到数据就开始渲染
 let id=useRoute().query.id;
 let res =await getSongSheet(id);
 let res1=await getSongSheetDetails(id);
 let res2=await getSongSheetList(id);
 console.log(state.playlist)
 console.log(res1.data)
 console.log(res2)
 

 state.singleSheetDetials=res1.data
 state.playlist=res.data.playlist;
 state.SongSheetList=res2.data.songs;
 
//console.log(res2.data.songs.length)
sessionStorage.setItem('itemDetial',JSON.stringify(state))//在页面渲染时未拿到数据

})
</script>
