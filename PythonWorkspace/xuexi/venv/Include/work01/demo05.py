list=['123321','234323','123454321']
def fanzhuan(s):
    i=s.reverse();
    if i==s:
        return true
    else:
        return false
r=filter(fanzhuan,list)
for j in r:
    print(j)