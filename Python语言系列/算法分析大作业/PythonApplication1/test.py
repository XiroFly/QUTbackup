import random
import time
h=int(input("height:\n"))
array=[[random.randint(-1000,1000) for _ in range(0,i)] for i in range(1,h+1)]
def dp():
    arrays=[[-2]*i for i  in range(1,h+1)]
    #array[x][y]=max{array[x-1][y],array[x]+[y+1]}
    arrays[0][0]=0 #-1=l,1=r,0=mid
    try:
       for x in range(1,h):
            for y in range(0,x+1):
                if y==0:    
                    array[x][y]+=array[x-1][y]
                    arrays[x][0]=0
                elif y==x:
                    array[x][y]+=array[x-1][x-1]
                    arrays[x][y]=-1
                else:
                    if array[x-1][y]>array[x-1][y-1]:
                        arrays[x][y]=0
                        array[x][y]+=array[x-1][y]
                    else:
                        array[x][y]+=array[x-1][y-1]
                        arrays[x][y]=-1
    except:print(x,y)
       
    for x in range(0,h):
            print(arrays[x]) 
dp()