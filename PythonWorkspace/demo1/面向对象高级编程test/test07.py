import math
def normalize(name):
    name=name.title();
    return name

print(list(map(normalize,['adam', 'LISA', 'barT'])))