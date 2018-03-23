#-*- coding: utf-8 -*-
import cookielib
import urllib2
import urllib
from pip._vendor.requests.api import request
import json
from bs4 import BeautifulSoup







tcode=1
def fans(uname,clcode):
    global tcode

    hosturl='https://mp.weixin.qq.com/cgi-bin/login'
    posturl='https://mp.weixin.qq.com/cgi-bin/login'

    cj=cookielib.LWPCookieJar()
    cookie_support=urllib2.HTTPCookieProcessor(cj)
    opener=urllib2.build_opener(cookie_support,urllib2.HTTPHandler)
    urllib2.install_opener(opener)



    h=urllib2.urlopen(hosturl)


    headers = {
        'Accept':'*/*',
        'Accept-Encoding':'gzip, deflate',
        'Accept-Language':'zh-CN,zh;q=0.8',
        'Connection':'keep-alive',
        'Content-Length':clcode,
        'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8',
        'Host':'mp.weixin.qq.com',
        'Origin':'https://mp.weixin.qq.com',
        'Referer':'https://mp.weixin.qq.com/',
        'User-Agent':'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36',
        'X-Requested-With':'XMLHttpRequest'
        }
    postdata = {'username':uname,'pwd':'2caccf67b1b6925d3853fd5a663e4171','imgcode':'','f':'json'}
    postdata2 = urllib.urlencode(postdata)


    request1=urllib2.Request(posturl,postdata2,headers)
    try:
        response1=urllib2.urlopen(request1,timeout=10)
        text1=response1.read()
        trapcode=response1.getcode()
        recontent=json.loads(text1) 
        RedirectUrl=recontent['redirect_url']
        token=RedirectUrl.split('token=')[1]
        
        
        
        
        #print token,RedirectUrl
    

        response2=urllib2.urlopen(hosturl+RedirectUrl)
        text2=response2.read()

        soup=BeautifulSoup(text2,'html.parser',from_encoding='utf-8')
        em_nodes =soup.find_all("em",class_="number")
        name1=soup.find("a",class_="nickname")
        tcode=1
        print name1.get_text(),'\t\t',em_nodes[2].get_text()
    except Exception,e:
        tcode=0
        
        
        
            


    
    

    return



#v=open('E:\pyy\h1.txt','r')
#newlines=[]
#for l1 in open('E:\pyy\h1.txt','r'):
    #l1=v.readline()
    #newlines.insert(0, '%s' %l1)
    #print l1
#for a in newlines:
    #fans(a)
    
 
    
l=[






]

for i in l:
    #print i
    fans(i,'78')
    if tcode==0:
        fans(i, '80')
        if tcode==0:
             fans(i, '79')
             if tcode==0:
                 print i,'\tfailed','\ttcode:\t',tcode
                 tcode=1
        


