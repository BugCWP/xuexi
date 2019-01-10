#汉诺塔解决方案

def move(n,a,b,c):
    if(n==1):
        print(a+"-->"+c)
    else:
        move(n-1,"A","C","B")
        print(a+"-->"+c)
        move(n-1,"B","A","C")

move(10,"A","B","C")
