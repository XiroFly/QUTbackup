//歌单详情页接口
import service from "..";//axios实例:service
export function getSongSheet(id){
    return service({
        method:'get',
        url:`/playlist/detail?id=${id}`,
    })
   
}
export function getSongSheetDetails(id){
    return service({
        method:'get',
        url:`/playlist/detail/dynamic?id=${id}`
    })
}
export function getSongSheetList(id){
    return service({
        method:'get',
        url:`/playlist/track/all?id=${id}&limit=50&offset=0`
    })
}