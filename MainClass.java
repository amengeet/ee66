abstract class Geometry{
	public abstract double getArea();
}

class TotalArea{
	Geometry[] tuxing;
	double totalArea = 0;
	public void setTuxing(Geometry[] t) {
		tuxing = t;
	}
	double computerTotalArea() {
		for(int i=0;i<tuxing.length;i++) {
			totalArea = totalArea+tuxing[i].getArea();
		}
		return totalArea;
	}
}

class Circle2 extends Geometry{
	double r;
	Circle2(double r){
		this.r = r;
	}
	public double getArea() {
		return r*r*3.14;
	}
}

class Rect extends Geometry{
	double a,b;
	Rect(double a,double b){
		this.a = a;
		this.b = b;
	}
	public double getArea() {
		return a*b;
	}
	
}

public class MainClass {

	public static void main(String[] args) {
		Geometry[] tuxing = new Geometry[29];
		for(int i=0;i<tuxing.length;i++) {
			//���������Ԫ��һ����Circle�������壬һ����Rect�����壬���÷������getArea���㲻ͬ��״�����
			if(i%2==0) {
				tuxing[i] = new Circle2(10+i);
			}
			else if(i%2==1) {
				tuxing[i] = new Rect(16+i,68);
			}
		}
		TotalArea a = new TotalArea();
		a.setTuxing(tuxing);//��������������鴫��TotalArea
		System.out.println("���֮��Ϊ��"+a.computerTotalArea());
	}
}
