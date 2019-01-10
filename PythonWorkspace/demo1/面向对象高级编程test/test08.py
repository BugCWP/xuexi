from functools import reduce

def chen(x,y):
    return x*y

def prod(lis):
    su=reduce(chen,lis)
    return su

print('3 * 5 * 7 * 9 =', prod([3, 5, 7, 9]))


