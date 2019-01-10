def trim(s):
    if s[0]==" ":
        s=s[1:]
        return trim(s)
    elif s[-1]==" ":
        s=s[0:len(s)-1]
        return trim(s)
    else:
        print(s)

trim("  adada  ")
