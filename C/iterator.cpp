#include <cstdio>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

int main(){
	vector <int> a;
	//a.push_back(2);
	/*a.push_back(10);
	a.push_back(-1);
	a.push_back(6);
	a.push_back(2);*/
	
	vector <int>::iterator itr1 = a.begin();
	vector <int>::iterator itr2 = a.end();
	for(vector<int>::iterator itr = itr1; itr!= itr2; itr++){
		cout<< *itr << endl;
	}
	sort(itr1,itr2);
	for(vector<int>::iterator itr = itr1; itr!= itr2; itr++){
		cout<< *itr << endl;
	}
}