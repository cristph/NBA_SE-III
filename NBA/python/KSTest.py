import sys
from scipy.stats import kstest
import numpy as np
import matplotlib.pyplot as plt
import math
from scipy.stats import norm


def ks():
    #data=get_data()
    #data = np.random.normal(0,1,1000)


    w = sys.argv[1]
    data=w.split(";")
    
    
    #plt.plot(data, 'b-')
    #plt.show()

    #data=norm.rvs(13,7,size=1000)

    true_data=[float(num) for num in data]
    #bi=math.log(len(true_data))/math.log(2)+1;
    #plt.hist(true_data, bins=bi, color='g', alpha=0.5)
    #plt.show()

    #print 'data+++'
    #print ddd
    mean=float(sys.argv[2])
    st=float(sys.argv[3])

    test_stat = kstest(true_data, 'norm',(mean,st))
    #c=str(test_stat)
    print test_stat

#the code should not be changed
if __name__ == '__main__':
        ks()