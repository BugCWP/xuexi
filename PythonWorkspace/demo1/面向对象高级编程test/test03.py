# -*- coding: utf-8 -*-

import math

def quadratic(a, b, c):
    if not isinstance(a,(int,float)):
        raise TypeError('bad operand type')
    elif not isinstance(b,(int,float)):
        raise TypeError('bad operand type')
    elif not isinstance(c, (int, float)):
        raise TypeError('bad operand type')
    x1=(-b+math.sqrt(b*b-4*a*c))/(4*a)
    x2=(-b-math.sqrt(b*b-4*a*c))/(4*a)
    return x1,x2

print(quadratic(1,2,1))