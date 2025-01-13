# 创建15行27列的随机二维数组（矩阵）X和Y；

import numpy as np
x=np.random.rand(15,27)
y=np.random.rand(15,27)
print(x[11],end='\n')
print(x[...,7],end='\n')
print(x[4,9],end='\n')
print(x.ndim,end='\n')
# -输出第12行的元素；
# -输出第8列的元素；
# -输出第5行第10列的元素；
# -输出数组的维数；
# -输出数组的行列数；
print(x.shape,end='\n')
# -输出数组的元素的个数；
print(x.size,end='\n')
# -改变数组的形状为45行1列；
a=x.copy()
a.resize((45,1))
print(a,end='\n')
# -改变数组的形态为5行6列，输出损失掉的数据；
b= np.split(a,[30],0)
a=b[0].reshape((5,6))
print(b[1].reshape((15)))
# -从垂直方向堆叠X和Y；
print(np.vstack((x,y)),end='end\n')
# -从水平方向堆叠X和Y；
print(np.hstack((x,y)),end='end\n')
# -计算并输出X、Y对应元素的+、-、*、/等运算结果；
print(x+y,end='end\n')
print(x-y,end='end\n')
print(x*y,end='end\n')
print(x/y,end='end\n')
# -计算并输出X、Y垂直、水平方向上的最大值、最小值、标准差、方差等信息；
#沿轴axis0（y轴）的最大值
print(np.max(x, axis=0),end='end\n')
print( np.min(x, axis=1),end='end\n')
print(np.std(x, axis=0),end='end\n')
print(np.var(x, axis=1),end='end\n')
# -对X、Y中的数据分别进行正排序和逆排序；
print(x.sort(),end='end\n')
print(y.sort(),end='end\n')
print(-np.sort(-x),end='end\n')
print(-np.sort(-y),end='end\n')
# -已知方程组
# 31x+48y=100
# 15x-17y=23
# 利用numpy模块中的函数求解该方程组。
A = np.array([[31, 48], [15, -17]])
B = np.array([100, 23])
solution = np.linalg.solve(A, B)
print("方程组的解:", solution)
# -利用常用的随机分布函数生成数据，并绘图显示。
import matplotlib.pyplot as plt

data = np.random.normal(0, 1, 1000)  # 生成1000个服从标准正态分布的随机数
plt.hist(data, bins=20, color='b', alpha=0.5)
plt.title("随机分布数据的直方图")
plt.show()
