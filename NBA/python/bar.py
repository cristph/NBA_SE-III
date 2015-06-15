import sys
import numpy as np
from scipy.stats import norm
import matplotlib.pyplot as plt
import math

def get_data1():
    x=sys.argv[1]
    y=x.split(";")
    data = [float(num) for num in y]
    return data

def get_data2():
    x=sys.argv[2]
    y=x.split(";")
    data = [float(num) for num in y]
    return data

#you can write your code here
def draw():
    #get input data
    x = get_data1()
    y = get_data2()
    x_bi=math.log(len(x))/math.log(2)+1;
    y_bi=math.log(len(y))/math.log(2)+1;
    plt.hist(x, bins=x_bi, color='g', label=sys.argv[3],alpha=0.5)
    plt.hist(y, bins=y_bi, color='r', label=sys.argv[4],alpha=0.5)
    plt.legend(loc = 'upper right')
    plt.xlabel(sys.argv[6],fontsize=20)
    plt.ylabel('Frequency')
    plt.title(sys.argv[5])
    #show image
    plt.show();

#the code should not be changed
if __name__ == '__main__':
    draw()