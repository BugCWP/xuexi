def product(*numbers):
    num=1
    for x in numbers:
        num=num*x;
    return num

x=product(1,2,3,4,5,6)

print(x)