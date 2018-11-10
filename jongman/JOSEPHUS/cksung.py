#!/usr/bin/env python3
# -*- coding: utf-8 -*-
#https://algospot.com/judge/problem/read/JOSEPHUS
####어레이리스트
def josephus():
    N, k = input().split()
    N, k = int(N), int(k)
    lst = []
    klst = []
    for i in range(1,N+1):
        lst.append(i)
        
    cnt = 1
    while len(lst) != 2:
        for i in lst:
            if (cnt +k)%3 == 1:
                klst.append(i)
            cnt += 1

        for j in klst:
            lst.remove(j)
            klst = []
    print(lst[0],lst[1])

a = int(input())
for i in range(a):
    josephus()


#####원형링크드리스트
def lst(n):
    lst = []
    for i in range(n):
        lst.append(i+1)
    return lst

def next_list(lst):
    list_next = lst[1:]
    list_next.append(lst[0])
    return list_next

def josephus2():
    n, k = input().split()
    n, k = int(n), int(k)
    a = lst(n)
    a.remove(a[0])
    while(len(a) != 2):
        for i in range(0,k-1):
            a = next_list(a)
            #print(a)
        a.remove(a[0])
        #print(a)
        #print(len(a))
    a.sort()
    print(a)

def solve():
    a = int(input())
    for i in range(a):
        josephus2()
solve()
