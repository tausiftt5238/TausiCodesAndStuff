#include <cstdio>
#include <set>
#include <iostream>
using namespace std;

int main(){
	set <int> mySet;
	mySet.insert(10);
	mySet.insert(2);
	mySet.insert(20);
	set <int> :: iterator it;
	it = mySet.find(20);
	pair <set <int>::iterator, bool> whatIGot;
	whatIGot = mySet.insert(20);
	cout << *(whatIGot.first) << " " << whatIGot.second <<endl;
	whatIGot = mySet.insert(30);
	cout << *(whatIGot.first) << " " << whatIGot.second <<endl;
	
	//cout << *it <<endl;
	return 0;
}