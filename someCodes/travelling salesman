package mcm;

import java.util.Scanner;

public class travelling {
    int city[][];
    int numberOfCities;
    int dp[][];
    Scanner s=  new Scanner(System.in);
    public travelling(int n){
        numberOfCities = n;
        city = new int[n][n];
        dp = new int[n][n];
        input();
        travel_dp(0,0);
    }
    public int set(int x, int i){
        return x = x & 1 << i;
    }
    public int clear(int x, int i){
        int c = 0;
        c = c & 1 << i;
        c = ~c;
        return x = x & c;
    }
    public void input(){
        for(int i = 0 ; i < numberOfCities; i++){
            int x = s.nextInt();
            int y = s.nextInt();
            city[x][y] = s.nextInt();
        }
    }
    public int travel_dp(int x, int node){
        if(x == Math.pow(2,numberOfCities)) return city[node][0];
        x = set(x,node);
        int min = 1 << 28;
        for(int i = 0 ; i < numberOfCities; i++){
            if(city[node][i] != 0){
                min = Math.min(min, travel_dp(x,i) + city[node][i]);
                clear(x,node);
            }
        }
        return min;
    }
    
}
