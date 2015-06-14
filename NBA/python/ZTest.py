import sys
import numpy as np
import matplotlib.pyplot as plt
from scipy.stats import norm

def get_data1():
    #x=sys.argv[2]
    #y=x.split(";")
    data = np.random.normal(0,1,100)
    #return data
    return [78.1,72.4,76.2,74.3,77.4,78.4,76.0,75.5,76.7,77.3]


def get_data2():
    data = np.random.normal(0,1,100)
    #return data
    return [79.1,81.0,77.3,79.1,80.0,79.1,79.1,77.3,80.2,82.1]

#amuse H0:u1-u2>=0
#if Z<= -Za,then deny H0
#you can write your code here
def cal(IMG_PATH):
    #get input data
    x = get_data1()
    y = get_data2()
    #print 'data is : '+str(x)

    #calculate x
    sign_x=0.0
    sum_x=0.0
    sum_x2=0.0

    for num_x in x:
        sign_x=sign_x+1
        sum_x+=num_x
        sum_x2+=num_x**2

    x_avg=sum_x=sum_x/sign_x
    sum_x=sum_x**2
    sum_x2=sum_x2/sign_x

    S1=(sign_x/(sign_x-1))*(sum_x2-sum_x)
    #S1=S1**0.5

    #calculate y
    sign_y=0.0
    sum_y=0.0
    sum_y2=0.0

    for num_y in y:
        sign_y=sign_y+1
        sum_y+=num_y
        sum_y2+=num_y**2

    y_avg=sum_y=sum_y/sign_y
    sum_y=sum_y**2
    sum_y2=sum_y2/sign_y

    S2=(sign_y/(sign_y-1))*(sum_y2-sum_y)
    #S2=S2**0.5

    #S1=3
    #S2=2
    Z=(x_avg-y_avg)/((S1/sign_x+S2/sign_y)**0.5)

    #print sign
    #print x_avg
    print Z

    cmp = norm.ppf(q=0.05);
    print cmp

#the code should not be changed
if __name__ == '__main__':
    cal('')