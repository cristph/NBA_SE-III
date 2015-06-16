import sys
import numpy as np
import matplotlib.pyplot as plt
import math
from scipy.stats import norm
def get_data1():
    s=sys.argv[1]
    
    data=float(s)
    return data
def get_data2():
    s=sys.argv[2]
    
    data=float(s)
    return data
def draw():
    x=get_data1()
    y=get_data2()
    B=norm(loc=x,scale=y)
    z=np.linspace(B.ppf(0.01), B.ppf(0.99),100)
    plt.plot(z, B.pdf(z),color="green")
    plt.show()
if __name__ == '__main__':
    draw()