def sorting_asc():
    a = int(input())
    s =[]
    arr = ['']*a
    for i in range(a):
        arr[i] = int(input())
    arr = sorted(arr)
    for i in range(len(arr)):
        s.append(arr[i])
    for elem in s:
        print(elem)
sorting_asc()
