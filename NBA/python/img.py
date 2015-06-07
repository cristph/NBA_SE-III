import sys
import numpy as np
import matplotlib.pyplot as plt

def get_data():
    x=sys.argv[2]
    y=x.split(";")
    return y

#you can write your code here
def draw(IMG_PATH):
    #get input data
    x = get_data()
    #print 'data is : '+str(x)
    # the line chart of the data
    plt.plot(x, 'b-')
    #show image
    plt.savefig(IMG_PATH)

#the code should not be changed
if __name__ == '__main__':
    if len(sys.argv)==1:
        print 'error'
    else:
        #the path of image to show
        IMG_PATH = sys.argv[1]
        draw(IMG_PATH)