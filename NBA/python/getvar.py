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
    sum_1=0
    for x in data:
        sum=sum+x
        sum_1=sum_1+x**2

    avg=sum/len(data)
    avg_2=avg**2
    sum_1=sum_1/len(data)

    S=sum_1-avg_2
    S=S**0.5

    #print avg
    print S



if __name__ == '__main__':
    cal()