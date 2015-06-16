import sys
import numpy as np
import matplotlib.pyplot as plt
from scipy.stats import t

def get_data():
    x=sys.argv[1]
    y=x.split(";")
    data = [float(num) for num in y]
    return data
    #return [78.1,72.4,76.2,74.3,77.4,78.4,76.0,75.5,76.7,77.3]

#you can write your code here
def cal(IMG_PATH):
    #get input data
    x = get_data()
    #print 'data is : '+str(x)
    sign=0.0
    sum=0.0
    sum_2=0.0

    for num in x:
        sign=sign+1
        sum+=num
        sum_2+=num**2

    x_avg=sum=sum/sign
    sum=sum**2
    sum_2=sum_2/sign

    S=(sign/(sign-1))*(sum_2-sum)
    S=S**0.5

    #print sign
    #print x_avg
    #print S
    print t.interval(alpha=float(sys.argv[2]), df=sign-1, loc=x_avg, scale=S)

#the code should not be changed
if __name__ == '__main__':
    cal('')