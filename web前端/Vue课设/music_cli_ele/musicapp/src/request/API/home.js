import service from "..";
//返回获取数据的配置对象
export function getBanner(){
    //获取轮播图
    return service({
        method:'get',
        url:"banner?type=2",//url!=URL绝对路径


    })
}
export function getMusicaList(){
    return service({
        method:'get',
        url:"/personalized?limit=10",
    })
}
//获取歌词
export function getMusicLyric(id){
    return service({
        method:'get',
        url:`/lyric?id=${id}`,
        
    })
}
