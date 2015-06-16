import sys
import matplotlib.pyplot as plt
import numpy as np
from scipy import stats
from scipy.stats import f

def linregress1():
    x = get_data1()
    y = get_data2()
    
    #x = np.linspace(-5, 5, num=150)
    #y = x + np.random.normal(size=x.size)
    slope, intercept, r_value, p_value, std_err = stats.linregress(x,y)
    #print slope, intercept, r_value, p_value, std_err
    p=f.ppf(0.95,1,len(x)-2)
    #print p
    var=0
    sum=0
    mean=0
    var2=0
    var3=0
    for num in y:
        sum=sum+num
    mean=sum/len(y)
    for num2 in y:
        var=var+(num2-mean)**2
    for num3 in x:
        var2=var2+(slope*num3+intercept-mean)**2
    var3=var-var2
    #print var3,var2,var
    f_value=(var2/var3)*(len(y)-2)
    if(f_value>p):
        if(r_value**2>0.5):
            print "Yes"
        else:
            print "No"
    else:
        print "No"
    
    #print x
    #print y
    print str(slope)
    print str(intercept)
    plt.plot(x, y,'b.')
    plt.plot(x, slope * x + intercept,'r-')
    plt.show()
def get_data1():
    s=sys.argv[1]
    x=s.split(";")
    data=[float(num) for num in x]
    return data
def get_data2():
    s=sys.argv[2]
    x=s.split(";")
    data=[float(num) for num in x]
    return data
if __name__ == '__main__':
    linregress1()      