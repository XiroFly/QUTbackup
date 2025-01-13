import urllib.parse
url="https://api.bilibili.com/x/v2/reply/wbi/main?oid=235563009&type=1&mode=3&pagination_str=%7B%22offset%22:%22%7B%5C%22type%5C%22:1,%5C%22direction%5C%22:1,%5C%22data%5C%22:%7B%5C%22pn%5C%22:2%7D%7D%22%7D&plat=1&web_location=1315875&w_rid=8c358fc1aff77e3f2087cee1419fff49&wts=1701054488"
parsed_url = urllib.parse.urlparse(url)
""" parsed_url:  ParseResult(scheme='https', netloc='api.bilibili.com', path='/x/v2/reply/wbi/main', params='', query='oid=235563009&type=1&mode=3&pagination_str=%7B%22offset%22:%22%7B%5C%22type%5C%22:1,%5C%22direction%5C%22:1,%5C%22data%5C%22:%7B%5C%22pn%5C%22:2%7D%7D%22%7D&plat=1&web_location=1315875&w_rid=8c358fc1aff77e3f2087cee1419fff49&wts=1701054488', fragment='')"""
"""urllib.parse.parse_qs(parsed_url.query):{'oid': ['235563009'], 'type': ['1'], 'mode': ['3'], 'pagination_str': ['{"offset":"{\\"type\\":1,\\"direction\\":1,\\"data\\":{\\"pn\\":2}}"}'], 'plat': ['1'], 'web_location': ['1315875'], 'w_rid': ['8c358fc1aff77e3f2087cee1419fff49'], 'wts': ['1701054488']}"""
query= urllib.parse.unquote(parsed_url.query)
pagination_str = urllib.parse.parse_qs(query).get('pagination_str', [''])[0]#将query字符串段转化为字典并取值,json字符串
print(eval(pagination_str)["offset"])
print(eval(eval(pagination_str)["offset"])["data"]["pn"])
print(urllib.parse.unquote(url))
import json
url='"{\"type\":1,\"direction\":1,\"data\":{\"pn\":2}}'
url1=r'https://api.bilibili.com/x/v2/reply/wbi/main?oid=235563009&type=1&mode=3&pagination_str={"offset":"{\"type\":1,\"direction\":1,\"data\":{\"pn\":2}}"}&plat=1&web_location=1315875&w_rid=8c358fc1aff77e3f2087cee1419fff49&wts=1701054488'.replace("\\",'')
print(url1)