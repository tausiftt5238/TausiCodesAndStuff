#include <cstdio>
#include <cstring>
#include <cmath>
#include <cstdlib>
class Coordinate{
public:
	int x;
	int y;
};
class Line{
public:
	double a,b,c;
	Coordinate P,Q;
	Line(Coordinate p,Coordinate q){
		P = p;
		Q = q;
	}
	void calculate(){
		double d = P.x * Q.y - P.y * Q.x;
		double d_a = Q.y - P.y;
		double d_b = P.x - Q.x;
		a = d_a/d;
		b = d_b/d;
		c = -(P.x * a + P.y * b);	
	}
	void print(){
		printf("%lfx + %lfy + %lf = 0\n",a,b,c);
	}
};

int main(){
	Coordinate P,Q;
	P.x = 4;
	P.y = -5;
	Q.x = 6;
	Q.y = 1;
	Line z(P,Q);
	z.calculate();
	z.print();
	return 0;
}