import axios from "axios";
let service=axios.create({//创建axios实例:service
    baseURL:"http://localhost:3000/",
    timeout:3000,//返回数据截止时间

})
export default service;