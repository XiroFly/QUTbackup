import requests
import datetime
import csv
import pandas as pd
import time
import urllib.parse
# f=open("data.csv",mode="a",encoding="utf-8",newline='')
data=pd.DataFrame(columns=["昵称","性别","sign","评论","时间","ip属地"])
header={'cookie':"i-wanna-go-back=-1; buvid4=0545A148-5338-954B-9AE8-7CFE09D1F71415134-022052722-UEFJsUwovmmgu2u8957YxQ%3D%3D; buvid_fp_plain=undefined; DedeUserID=298020112; DedeUserID__ckMd5=8fb96bc434913728; CURRENT_BLACKGAP=0; LIVE_BUVID=AUTO1616542308186123; rpdid=|(u)~mRm|)Ru0J'uYY)lmRkul; is-2022-channel=1; hit-new-style-dyn=1; CURRENT_PID=4b251580-cd51-11ed-afc0-859ae837a3bb; buvid3=5FA10D4F-3F72-2D46-10F2-693DBEE7B3D078029infoc; b_nut=1685247078; _uuid=C5C18868-F4F6-4FF2-183A-10A88E21F761378678infoc; hit-dyn-v2=1; FEED_LIVE_VERSION=V8; b_ut=5; CURRENT_FNVAL=4048; enable_web_push=DISABLE; header_theme_version=CLOSE; CURRENT_QUALITY=80; fingerprint=7529e1343c449f96a11ef9679311b621; home_feed_column=5; browser_resolution=1536-703; SESSDATA=f75b69f6%2C1716470009%2C14d3f%2Ab1CjALyugIv7rxfmhQY0IZdBTsWtafwdmNoKtCFfd4Ja0zTaJtMTABaem6UZ_iVQnjZWYSVmVFR0RiTnhScVowTVVSTVJnYWJNUkh2QjdhSWVzRDB1WWZmVml2YzN2MjVrZ20wRUdhQWdhaHhQb284Rmg3UmlKOGVNWnVJVlJ4NXFLRjdtdWFiRWxnIIEC; bili_jct=ddc14420c2b2c7b89e125e6970ff599d; bili_ticket=eyJhbGciOiJIUzI1NiIsImtpZCI6InMwMyIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MDEyNTI0NTAsImlhdCI6MTcwMDk5MzE5MCwicGx0IjotMX0.Fy6iYphZhhp58cRfcJMet_KWxMmenkqnPhCzyQWI2z8; bili_ticket_expires=1701252390; PVID=1; buvid_fp=7529e1343c449f96a11ef9679311b621; b_lsid=93F810338_18C0E8A08E1; sid=7ssj5ca9; bp_video_offset_298020112=868478546602885145"
       ,"Referer":"https://www.bilibili.com/video/BV17e411X7Ym/?spm_id_from=333.1007.tianma.1-2-2.click&vd_source=cac7dc1a1fd8307d56a2ca1c33f21a05"
       ,"User-Agent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36"
        }
url='https://api.bilibili.com/x/v2/reply/wbi/main?oid=235563009&type=1&mode=3&pagination_str=%7B%22offset%22:%22%7B%5C%22type%5C%22:1,%5C%22direction%5C%22:1,%5C%22data%5C%22:%7B%5C%22pn%5C%22:2%7D%7D%22%7D&plat=1&web_location=1315875&w_rid=8c358fc1aff77e3f2087cee1419fff49&wts=1701054488'#w_rid=0c1bda5d3a8fb61e811bbd36efaccc24&wts=1701059484,请求id，时间戳
url1=r'https://api.bilibili.com/x/v2/reply/wbi/main?oid=235563009&type=1&mode=3&pagination_str={"offset":"{\"type\":1,\"direction\":1,\"data\":{\"pn\":2}}"}&plat=1&web_location=1315875&w_rid=8c358fc1aff77e3f2087cee1419fff49&wts=1701054488'.replace("\\",'')
url=urllib.parse.unquote(url)
print(url==url1)
# url=urllib.parse.quote(url)
response=requests.get(url=url,headers=header)
json_data=response.json()
try:
    for i in json_data["data"]["replies"]:
        dic={
            "昵称":i["member"]["uname"],
            "性别":i["member"]["sex"],
            "sign":i["member"]["sign"],
            "评论":i["content"]["message"],
            "时间": str(datetime.datetime.fromtimestamp(i["ctime"])),
            "ip属地":i["reply_control"]["location"].split("：")[-1]
        }
        data.loc[len(data)]=dic
except:
    print(f"error______:{json_data}")
    
print(data)
data.to_csv("data.csv")
def get_next_url(url):
    url=urllib.parse.unquote(url)
    parsed_url = urllib.parse.urlparse(url)
    pagination_str = urllib.parse.parse_qs(parsed_url.query).get('pagination_str', [''])[0]
    arg=eval(eval(pagination_str)["offset"])['data']['pn']+1
    new_url = r"https://api.bilibili.com/x/v2/reply/wbi/main?oid=235563009&type=1&mode=3&pagination_str={'offset':'{\"type\":1,\"direction\":1,\"data\":{\"pn\":3}}'}&plat=1&web_location=1315875&w_rid=8c358fc1aff77e3f2087cee1419fff49&wts=1701054488"
    ##https://api.bilibili.com/x/v2/reply/wbi/main?oid=235563009&type=1&mode=3&pagination_str=
    # {"offset":"{\"type\":1,\"direction\":1,\"data\":{\"pn\":2}}"}&plat=1&web_location=1315875
    # &w_rid=8c358fc1aff77e3f2087cee1419fff49&wts=1701054488
    return new_url
    
    
    
    
