def push(n):
    arr.append(n)

def pop():
    try:
        print(arr.pop())
    except:
        print(-1)

def size():
    return len(arr)

def empty():
    if size() == 0:
        a = 1
    else:
        a = 0
    print(a)

def top():
    try:
        print(arr[-1])
    except:
        print(-1)


a = int(input())
arr = []
for _ in range(a):
    cmd = input().split()
    if cmd[0] == 'push':
        push(cmd[1])
    elif cmd[0] == 'pop':
        pop()
    elif cmd[0] == 'size':
        print(size())
    elif cmd[0] == 'empty':
        empty()
    elif cmd[0] == 'top':
        top()
