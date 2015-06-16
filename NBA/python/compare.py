import sys
import numpy as np
import matplotlib.pyplot as plt
import math
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
def draw():
    #get input data
    x=get_data1()
    y=get_data2()
    #x=[23,14]
    #y=[24,24]
    ind=np.arange(2)
    width=0.35
    fig,ax=plt.subplots()
    rects1=ax.bar(ind,x,width,color="r")
    rects2=ax.bar(ind+width,y,width,color="g")
    
    #print 'data is : '+str(x)
    # the histogram of the data
    #x_bi=math.log(len(x))/math.log(2)+1;
    #y_bi=math.log(len(y))/math.log(2)+1;
    ax.set_xticks(ind+width)
    ax.set_xticklabels(("mean","var"))
    ax.legend((rects1[0],rects2[0]),(sys.argv[3],sys.argv[4]))
    ax.set_title("compare on "+sys.argv[5])
    plt.show()
    if(x[0]>y[0]):
        print "good1"
    else:
        print "bad1"
    if(x[1]<y[1]):
        print "good2"
    else:
        print "bad2"
    #plt.bar(x,color="r",bins=x_bi,alpha=0.5) #bins=10, color='g', alpha=0.5)
    #plt.bar(y,color="g",bins=y_bi,alpha=0.3)
    ##plt.hist(y, bins=10, color='r', alpha=0.5)
    #plt.show()
    #show image
    #plt.savefig(IMG_PATH)
if __name__ == '__main__':
    draw()