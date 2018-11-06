import sys
a = int(sys.stdin.readline())
q=[]
for _ in range(a):
    arr = sys.stdin.readline().split()
    if arr[0] == 'push':
        q.append(arr[1])
    elif arr[0] == 'pop':
        if q: print(q.pop(0))
        else: print(-1)
    elif arr[0] == 'size':
        print(len(q))
    elif arr[0] == 'empty':
        print(1-int(bool(q)))
    elif arr[0] == 'front':
        if q: print(q[0])
        else: print(-1)
    elif arr[0] == 'back':
        if q: print(q[-1])
        else: print(-1)
    else:
        pass
