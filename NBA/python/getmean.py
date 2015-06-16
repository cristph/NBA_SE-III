import sys
from scipy.stats import norm

def getData():
    x=sys.argv[1]
    y=x.split(";")
    data=[float(n) for n in y]
    #data=norm.rvs(13,7,size=1000)
    return data

def cal():
    data=getData()

    sum=0
    for x in data:
        sum=sum+x

    avg=sum/len(data)
    print avg



if __name__ == '__main__':
    cal()