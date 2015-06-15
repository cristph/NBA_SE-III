import sys
import numpy as np
from scipy.stats import norm
import matplotlib.pyplot as plt

def get_data():
    # example data
    mu = 100 # mean of distribution
    sigma = 15 # standard deviation of distribution
    print np.random.rand(10)
    x = mu + sigma * np.random.randn(180)
    return x

#you can write your code here
def draw(IMG_PATH):
    #get input data
    x = get_data()
    print 'data is : '+str(x)
    # the histogram of the data
    fig, ax = plt.subplots(1, 1)

    ax.hist(x, bins=22, color='g', alpha=0.5)
    z=100 + 15 * np.random.randn(180)
    #ax.plot(x, z)
    #show image
    plt.show();
    plt.savefig(IMG_PATH)

#the code should not be changed
if __name__ == '__main__':
    draw('D:\\bar.png')