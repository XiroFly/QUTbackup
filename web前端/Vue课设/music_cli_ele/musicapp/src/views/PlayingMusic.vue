<template>
    <div class="total">
     <div class="top">
        <svg class="icon" aria-hidden="true" @click="$router.go(-1)">
      <use xlink:href="#icon-zuojiantou"></use>
      </svg>
     </div>
    <div class="bottom"  v-for="(item,index) in data.playList" :key="index" >
      <div class="left">
        <span class="index">{{ index }}</span>
      <span class="name">  {{ item.name }}</span>
    </div>
      <svg class="icon" aria-hidden="true" @click="useStore()._mutations.deletePlayList[0](index)">
      <use xlink:href="#icon-cuohao"></use>
      </svg>
    </div>
    </div>
</template>
<script setup>
import { useStore } from 'vuex';
const data=useStore()._state.data

</script>
<style lang="less" scoped>
.total{
    border: 1px solid #999;
   border-top-right-radius: 0.3rem;
    border-top-left-radius: 0.3rem;
    background-color: white;
    margin-top: 1rem;
    margin-left: 0.5rem;
    margin-right: 0.5rem;
    .top{
        width: 100%;
        height:1rem;
        .icon{
            height: 0.8rem;
            width: 0.8rem;
        }

    }
    .bottom{
        width: 100%;
        height: 0.6rem;
        display: flex;
        justify-content: space-between;
         .left{
         height: 100%;
         width:70%;
         display: flex;
        justify-content: space-between;
        .index{
         font-size: 200;
         color: #999;
         align-items: center;
         margin-left: 0.4rem;
        }
        .name{
         font-size: 800;
         align-items: center;
        }
         };
         .icon{
            padding-bottom: .08rem;
            width: 30%;
            height: 100%;
            align-items: center;
         }
    }
}

</style>