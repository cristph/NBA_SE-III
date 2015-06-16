#encoding:UTF-8
import sgmllib
import urllib2,urllib
import datetime
from sgmllib import SGMLParser
from urllib2 import urlopen
import sys

class MySGMLParser(SGMLParser):
    #重写SGMLParser模块中的reset函数，
    def reset(self):
        #调用原来的函数resert
        SGMLParser.reset(self)
        #数据存放的位置
        self.data = []
        self.lable = False
        self.url = []


    #查找的标签(start_ +　标签）表示查找的那个标签（参数是固定的）
    def start_a(self,attrs):
        #查找对象的标签里面的属性(此处用到了列表解析)
        href = [v for k,v in attrs if k == 'href']
        #判断href是不是存在
        if href:
            self.url.extend(href)
        self.lable = True


    #查找结束的标志
    def end_a(self):
        self.lable = False
    #处理信息数据的地方
    def handle_data(self,data):
        #判断标签数不超找完毕
        if self.lable:
            data = data.strip()
            self.data.append(data)


class ParserData():
    def __init__(self,urlpath):
        self.urlpath = urlpath
        self.isNull = 0
        self.urlData = []
        self.dealData()
        self.setSame()
        
    #读取url路径的
    def readData(self):
        data = None
        #访问的地址是不是存在,不存在侧抛出异常
        try:
            data = urllib.urlopen(self.urlpath)
        except IOError,e:
            #print u'地址不存在'
            #不处理
            self.isNull = 1
        return data


    #处理数据
    def dealData(self):
        #对上述的类实例化
        parser = MySGMLParser()
        #获取访问url的对象
        data = self.readData()
        if self.isNull == 1:

            return
        if data != None:
            #   调用定义在 SGMLParser 中的 feed 方法，将 HTML 内容放入分析器中(feed传值为字符串)
            parser.feed(data.read())
            self.closeData(data,parser,)
            #遍历查找的数据
            for i in parser.url:
                if i.startswith('/games/201'):
                    i = i.strip();
                    self.urlData.append('http://www.nba.com'+i)



    def closeData(self,data,parser):
        parser.close()
        data.close()

    def setSame(self):
        self.urlData = list(set(self.urlData))


class MyListParser(SGMLParser):
    def reset(self):
        #调用原来的函数resert
        SGMLParser.reset(self)
        #数据存放的位置
        self.point = None
        self.data1 = []
        self.data2 = []
        self.pdata = []
        self.dataline = None
        self.isTable = False 
        self.isDiv = False
        self.isSelect = False
        self.isPoint = False
        self.isPlayer = False
        self.isLine = False
        self.isMain = False
        self.isH1 = False
        self.isTd = False
        self.isAP = False
        self.tempData = []
    def start_div(self,attrs):
        v = [v for k,v in attrs if k == 'id']
        for m in v:
            if m == 'nbaGIGameScore':
                self.isDiv = True

    def end_div(self):
        if self.isAP:
            self.isDiv = False
        pass

    def handle_data(self,data):
        #获得比分
        if self.isDiv:
            if self.isH1:
                data = data.strip()
                if self.isSelect == False:
                    self.point = data
                    self.isSelect = True
                else:
                    self.point = self.point+'-'+data
                    self.isAP = True
        #获得每一节的比分
        if self.isPoint:
            if self.isTd:
                if data.strip()!='':
                    self.pdata.append(data.strip())
                
        #获得球员
        if self.isPlayer:
            if self.isTd:
                data = data.strip()               
                self.tempData.append(data)


    def start_table(self,attrs):
        value = [v for k,v in attrs if k == 'class']

        for m in value:
            if m.startswith('nbaGIRegul'):
                self.isPoint = True
        
        value1 = [v for k,v in attrs if k == 'id']

        for m1 in value1:
            if m1 == 'nbaGITeamStats':
                self.isPlayer = True


    def end_table(self):
        if self.isPlayer:
            self.isMain = True
        self.isPlayer = False
        self.isPoint = False

    def start_tr(self,attrs):
        if self.isPoint:
            self.isLine = True
        if self.isPlayer:
            value = [v for k,v in attrs if k == 'class']
            for m in value:
                if m == 'odd' or m == 'even':
                    self.isLine = True

    def end_tr(self):
        if self.isPlayer:
            if self.tempData !=[]:
                if self.isMain:
                    self.data2.append(self.tempData)
                else:
                    self.data1.append(self.tempData)

        self.isLine = False
        self.tempNum = 0
        self.tempData = []

    def start_h1(self,attrs):
        self.isH1 = True

    def end_h1(self):
        self.isH1 = False

    def start_td(self,attrs):
        if self.isLine:
            self.isTd = True
        value = [v for k,v in attrs if k == 'class']
        for m in value:
            if m == 'nbaGIQtrPts':
                self.isPoint = True

    def end_td(self):
        self.isTd = False



class WriteUrl():
    #将一个html写入文件
    def __init__(self,urlpath,divname):
        self.html = urllib.urlopen(urlpath).read()
        myL = urlpath.split('/games/')
        myList = myL[1].split('/')
        team = myList[1]
        time = myList[0]
        self.team1 = team[:3]
        self.team2 = team[-3:]
        self.year = time[:4]
        self.mouth = time[4:6]
        self.day = time[-2:]
        self.sesion = None
        if int(self.mouth)>8:
            self.sesion = self.intToStr(int(self.year))[-2:]+'-'+self.intToStr(int(self.year)+1)[-2:]
            pass
        else:
            self.sesion = self.intToStr(int(self.year)-1)[-2:]+'-'+self.intToStr(int(self.year))[-2:]
        tempName = divname+self.sesion+'_'+self.intToStr(self.mouth)+'-'+self.intToStr(self.day)+'_'+self.team1+'-'+self.team2+'.txt'
        #用这个文件名打开
        self.file = open(tempName,'w')
        self.table = MyListParser()
        self.table.feed(self.html)
        self.wFile()
        
    def intToStr(self,num):
        try:
            return '%d'%(num)
        except:
            return num

    def wFile(self):
        #将数组中的东西写为txt
        temp = self.intToStr(self.mouth)+'-'+self.intToStr(self.day)+';'+self.team1+'-'+self.team2+';'+self.table.point+'\n'
        self.file.write(temp)
        numP = len(self.table.pdata)/2
        try:
            temp = self.intToStr(self.table.pdata[0])+'-'+self.intToStr(self.table.pdata[0+numP])+';'+self.intToStr(self.table.pdata[1])+'-'+self.intToStr(self.table.pdata[1+numP])+';'+self.intToStr(self.table.pdata[2])+'-'+self.intToStr(self.table.pdata[2+numP])+';'+self.intToStr(self.table.pdata[3])+'-'+self.intToStr(self.table.pdata[3+numP])+';\n'
        except:
            temp = str(0)+'-'+str(0)+';'+str(0)+'-'+str(0)+';'+str(0)+'-'+str(0)+';'+str(0)+'-'+str(0)+'\n'
        self.file.write(temp)
        self.writeLP(self.team1,self.table.data1)
        self.writeLP(self.team2,self.table.data2)

        self.file.close()
        

    def writeLP(self,name,list):
        self.file.write(name+'\n')
        for a in list:
            #每个a是一个数组，记录了球员的信息
            if len(a)<4:
                continue
            if len(a)==17:

                shot = a[3].split('-')
                three = a[4].split('-')
                free = a[5].split('-')
                temp = a[0]+';'+a[1]+';'+a[2]+';'+shot[0]+';'+shot[1]+';'+three[0]+';'+three[1]+';'+free[0]+';'+free[1]+';'+a[7]+';'+a[8]+';'+a[9]+';'+a[10]+';'+a[12]+';'+a[14]+';'+a[13]+';'+a[11]+';'+a[16]+'\n'
                self.file.write(temp)
            if len(a)==16:
                shot = a[2].split('-')
                three = a[3].split('-')
                free = a[4].split('-')
                try:
                    temp = a[0]+';;'+a[1]+';'+shot[0]+';'+shot[1]+';'+three[0]+';'+three[1]+';'+free[0]+';'+free[1]+';'+a[6]+';'+a[7]+';'+a[8]+';'+a[9]+';'+a[11]+';'+a[13]+';'+a[12]+';'+a[10]+';'+a[15]+'\n'
                except:
                     temp = a[0]+';;'+a[1]+';'+'0'+';'+'0'+';'+'0'+';'+'0'+';'+'0'+';'+'0'+';'+a[6]+';'+a[7]+';'+a[8]+';'+a[9]+';'+a[11]+';'+a[13]+';'+a[12]+';'+a[10]+';'+a[15]+'\n'
                self.file.write(temp)


class WriteAll():

    def __init__(self,start,end,divname):
        #日期为2015-06-04这种类型的
        self.url ='http://www.nba.com/gameline/'
        self.start = start
        self.end = end
        self.div = divname
        self.dealYear()


    def dealYear(self):
        l1 = self.start.split('-')
        l2 = self.end.split('-')
        d1 = datetime.datetime(int(l1[0]),int(l1[1]),int(l1[2]))
        d2 = datetime.datetime(int(l2[0]),int(l2[1]),int(l2[2]))
        print 'd1:',d1,'d2:',d2
        while (d2-d1).days >=0:
            string = str(d1).split(' ')
            stri = string[0].split('-')
            name = self.url+stri[0]+stri[1]+stri[2]+'/'
            self.dealDay(name)
            print 'name:',name
            d1 = d1 + datetime.timedelta(days = 1)
            pass


    def dealDay(self,url):
        table = ParserData(url)
        print table.urlData
        for v in table.urlData:
            temp = WriteUrl(v,self.div)
        pass

#get1.WriteAll('2014-10-01','2015-06-13','/Users/xinlin/Documents/python-place/match/')

if __name__ == '__main__':
    #WriteAll('2015-06-01',sys.argv[1],sys.argv[2])

    start = sys.argv[1]
    l1 = start.split('-')
    d1 = datetime.datetime(int(l1[0]),int(l1[1]),int(l1[2]))
    d2 = datetime.datetime.now()
    d1 = d1 +datetime.datetime.timedelta(days = 1)
    string1 = str(d1).split(' ')
    str1 = string1[0]
    string2 = str(d2).split(' ')
    str2 = string2[0]
    div = sys.argv[2]
    WriteAll(str1,str2,div)




