//
//  main.cpp
//  STAL_inwon
//
//  Created by inwon on 2018. 10. 14..
//  Copyright © 2018년 inwon. All rights reserved.
//

#include <iostream>
using namespace std;

void merge(int start, int end, int middle,int array[]){
    int arraytmp[end-start+1];
    int tmp=0;
    int starttmp = start;
    int middletmp = middle;
    while(true){
        if(array[start]<array[middle]&&start<middletmp){
            arraytmp[tmp]=array[start];
            tmp++;
            start++;
        }else if(array[middle]<array[start]&&middle<end){
            arraytmp[tmp]=array[middle];
            tmp++;
            middle++;
        }
        
        if(start>=middletmp&&middle<end){
            arraytmp[tmp]=array[middle];
            tmp++;
            middle++;
        }else if(middle>=end&&start<middletmp){
            arraytmp[tmp]=array[start];
            tmp++;
            start++;
        }else{
            break;
        }
    }
    for(int i = start; i<=end; i++){
        array[i] = arraytmp[i-start];
    }
    return;
}

void devide(int start, int end,int array[]){
    int middle = (start+end)/2;
    if(end>start){
        devide(start,middle,array);
        devide(middle+1,end,array);
        merge(start,end,middle+1,array);
    }
        return;
    
}



int main(void) {
    int n;

    cin>>n;
    
    int start=0;
    int end=n;
    
    int array[n];
    
    for(int i =0; i<n; i++){
        cin>>array[i];
    }
    
    devide(start,end-1,array);
    
    for(int i =0; i<end; i++){
        cout<<array[i]<<endl;
    }
    
    
    return 0;
}
