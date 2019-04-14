a = int(input())
b = len(str(a))
c = a - 9*b

d = []

for i in range(c, a):
    if i >= 0:
        d.append(i)

g = []

for i in d:
    e = len(str(i))
    f = 0
    for j in range(e):
        f += int(str(i)[j])
    f += i
    g.append(f)

check = 0
for i in range(len(g)):
   if g[i] == a:
       check = 1
       print(d[i])
       break

if check == 0:
    print(0)
