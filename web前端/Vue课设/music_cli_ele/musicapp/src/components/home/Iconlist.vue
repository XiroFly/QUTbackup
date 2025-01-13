<template>
   <div class="iconList">
     <!----------------------------------->
   <div class="iconItem">
    <svg class="icon" aria-hidden="true">
      <use xlink:href="#icon-iconlogo"></use>
      </svg>
      <span>每日推荐</span>
   </div>
   <!----------------------------------->
   <div class="iconItem">
    <svg class="icon" aria-hidden="true">
      <use xlink:href="#icon-dianshiji"></use>
      </svg>
      <span>私人FM</span>
   </div>
    <!----------------------------------->
   <div class="iconItem">
    <svg class="icon" aria-hidden="true">
      <use xlink:href="#icon-gedan"></use>
      </svg>
      <span>歌单</span>
   </div>
    <!----------------------------------->
   <div class="iconItem">
    <svg class="icon" aria-hidden="true">
      <use xlink:href="#icon-paihangbang"></use>
      </svg>
      <span>排行榜</span>
   </div>
    <!----------------------------------->
   </div>
</template>
<style lang="less" scoped>
   .iconList{
    margin-top: .2rem;
    width: 100%;
    height: 2rem;
    display: flex;
    justify-content: space-around;
    align-items: center;
    .iconItem{
        width: 25%;
        height: 100%;
        display: flex;
        flex-direction: column;
        align-items: center;
        .icon{
            width: 1rem;
            height: 1rem;

        }

    }
   }
</style>