<template>
  <div class="login">
    <div class="loginTop">欢迎登录</div>
    <div class="loginContent">
      <input
        type="text"
        name="phone"
        class="phone"
        v-model="phone"
        placeholder="请输入手机号码"
      />
      <input
        type="password"
        name="passworld"
        class="passworld"
        v-model="password"
        placeholder="请输入密码"
      />
      <button class="btn" @click="Login">登录</button>
    </div>
  </div>
</template>
<script>
import {getLoginUser} from '@/request/api/home.js'
export default {
    data(){
        return{
            phone:'',
            password:''
        }
    },
    methods:{
        Login:async function(){
          let res= await this.$store.dispatch('getLogin',{phone:this.phone,password:this.password})
          console.log(res);
          if(res.data.code===200){//如果返回的code等于200，说明登录成功，就跳转个人中心页面
          this.$store.commit('updateIsLogin',true)
          this.$store.commit('updateToken',res.data.token)
          let result=await getLoginUser(res.data.account.id)
          console.log(result);
          this.$store.commit('updateUser',result)
          this.$router.push('/infoUser')
          }else{
              alert("手机号码或者密码错误")
              this.password=''
          }
        }
    }

}
</script>
<style lang="less" scoped>
.login {
  width: 100%;
  height: 13.34rem;
  padding: 0.2rem;
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: rgb(248, 97, 97);
  .loginTop {
    margin-top: 1rem;
    font-size: 1rem;
    color: #fff;
  }
  .loginContent {
    width: 100%;
    height: 300px;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-around;
    margin-top: 2rem;
    .phone,
    .passworld {
      width: 5rem;
      height: 1rem;
      border: 0.02rem solid #999;
    }
    .btn{
        width: 2rem;
        height: .6rem;
    }
  }
}
</style>
