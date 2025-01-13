<!--导航组件-->
<template>
<div class="topNav">
    <div class="topLeft">
      <svg class="icon" aria-hidden="true">
      <use xlink:href="#icon-liebiao2"></use>
      </svg>
    </div>
   <div class="topContent">
           <span>我的</span>
           <span class="active">发现</span>
           <span>云村</span>
           <span>视频</span>
  </div>
  <div class="topRight">
      <svg class="icon" aria-hidden="true">
      <use xlink:href="#icon-fangdajing"></use>
      </svg>
  </div>
</div>
</template>
<style lang="less" scoped>
    .topNav{
      width:100%;
      padding: .2rem;
      height: 1rem;
      display:flex;//弹性布局
      justify-content: space-between;//两端对齐
      align-items: center;
      .topContent{
          width:65%;
          height: 100%;
          display: flex;
          justify-content: space-around;
          //align-items: center;
          font-size: .36rem;
          .active{
            font-weight: 900;
          }
      }
    }
</style>