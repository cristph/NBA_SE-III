from scipy import stats
from scipy.stats import norm as N
import numpy as np
import matplotlib.pyplot as plt
import sys
import math
from scipy.stats import chi2
def chisquare():
    #A=[16, 18, 16, 14, 12, 12]
    x=get_data()
    x08=0
    x89=0
    x90=0
    x01=0
    x12=0
    x00=0
    mean=0
    var=0
    for num in x:
        if(num<15):
            x08=x08+1
        elif(15<=num<20):
            x89=x89+1
        elif(20<=num<25):
            x90=x90+1
        elif(25<=num<30):
            x01=x01+1
        elif(30<=num<35):
            x12=x12+1
        elif(num>=35):
            x00=x00+1
    #B=[16, 16, 16, 16, 16, 8]
    A=[x08,x89,x90,x01,x12,x00]
    print A
    sum=0
    for num1 in x:
        sum=sum+num1
    mean=sum/len(x)
    for num2 in x:
        var=var+(num2-mean)**2
    var=var/len(x)
    var=var**(0.5)
    B=N(loc=mean,scale=var)
    #print str(stats.chisquare(A))
    #a,b=stats.chisquare(A)
    #print str(a)
    #print str(b)
    #z=np.linspace(B.ppf(0.01),B.ppf(0.99),100)
    #plt.plot(z,B.pdf(z),color='green')
    #plt.show();
    list=B.rvs(len(x))
    print list
    y08=0
    y89=0
    y90=0
    y01=0
    y12=0
    y00=0
    for num3 in list:
        if(num3<15):
            y08=y08+1
        elif(15<=num3<20):
            y89=y89+1
        elif(20<=num3<25):
            y90=y90+1
        elif(25<=num3<30):
            y01=y01+1
        elif(30<=num3<35):
            y12=y12+1
        elif(num3>=35):
            y00=y00+1
    C=[y08,y89,y90,y01,y12,y00]
    #list=[0.93639627,-1.77989443,-0.6025055 ,-1.93231887 , 0.28099596, -0.77795851]
    #print list[0]
    #print list
    sta,pvalue=stats.chisquare(A, f_exp=C)
    p=chi2.ppf(0.95,len(x)-3)
    if(sta>=p):
        print "No"
    else:
        print "Yes"
    #a=raw_input("a num")
def get_data():
    s=sys.argv[1]
    x=s.split(";")
    data=[float(num) for num in x]
    return data
if __name__ == '__main__':
    chisquare()