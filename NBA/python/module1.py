from scipy.stats import kstest
import numpy as np

def get_data():
    x=sys.argv[2]
    y=x.split(";")
    return y


def ks():
    #data=get_data()
    data = np.random.normal(0,1,1000)
    test_stat = kstest(data, 'norm')
    print test_stat

#the code should not be changed
if __name__ == '__main__':
    if len(sys.argv)==1:
        print 'error'
    else:
        #the path of image to show
        ks()