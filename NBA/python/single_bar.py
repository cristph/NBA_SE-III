import sys
import numpy as np
from scipy.stats import norm
import matplotlib.pyplot as plt
import math

def get_data():
    x=sys.argv[1]
    y=x.split(";")
    data = [float(num) for num in y]
    return data

#you can write your code here
def draw():
    #get input data
    x = get_data()
    x_bi=math.log(len(x))/math.log(2)+1;

    plt.hist(x, bins=x_bi, color='g', label=sys.argv[2],alpha=0.5)

    plt.legend(loc = 'upper right')

    plt.xlabel(sys.argv[3],fontsize=20)
    plt.ylabel('Frequency')

    plt.title(sys.argv[4])
    #show image
    plt.show();

#the code should not be changed
if __name__ == '__main__':
    draw()