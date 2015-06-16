import sys
import numpy as np
import matplotlib.pyplot as plt
import math
def get_data():
    s=sys.argv[1]
    x=s.split(";")
    data=[float(num) for num in x]
    return data
def draw():
    x=get_data()
    x_bi=math.log(len(x))/math.log(2)+1;
    plt.hist(x,color="g",bins=x_bi,alpha=0.3)
    plt.show()

if __name__ == '__main__':
    draw()