#回数是指从左向右读和从右向左读都是一样的数，例如12321，909。请利用filter()筛选出回数：

def f1(s):
    n=0
    while n<len(chr(s)):
        if(s[n]!=s[len(s)-1-n]):
            return False
    return True


print(list(filter(f1,list(range(10,1000000)))))
