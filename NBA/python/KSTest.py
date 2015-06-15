import sys
from scipy.stats import kstest
import numpy as np
import matplotlib.pyplot as plt
import math


def ks():
    #data=get_data()
    #data = np.random.normal(0,1,1000)
    w = sys.argv[1]
    data=w.split(";")
    #plt.plot(data, 'b-')
    #plt.show()

    true_data=[float(num) for num in data]
    bi=math.log(len(true_data))/math.log(2)+1;
    plt.hist(true_data, bins=bi, color='g', alpha=0.5)
    plt.show()

    #print 'data+++'
    #print ddd
    test_stat = kstest(true_data, 'norm')
    #c=str(test_stat)
    print test_stat

#the code should not be changed
if __name__ == '__main__':
        ks()