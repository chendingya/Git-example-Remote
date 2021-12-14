//
// Created by 15845 on 2021/11/22.
//
#include <stdio.h>
int num[36][36] = {0};
void YangHui(int x, int y);
int main(){
    int a,b;
    int tmp = 0;
    scanf("%d%d", &a, &b);
    //chu shi hua
    for (int i = 1; i < 36; i++) {
        num[i][1] = 0;
        num[i][i] = 0;
    }
    tmp = YangHui(a,b);
    return 0;
}
void YangHui(int x, int y) {
    if (y == 1 || (x == y)) {
        num[x][y] += 1;
    } else {
        num[x][y] = num[x - 1][y - 1] + num[x][y - 1];
    }
}