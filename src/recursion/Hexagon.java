package recursion;

public class Hexagon {
	public String color;
	public char[] sideColor = new char[6];

	public Hexagon(String color) {
		this.color = removeNumber(color);
		fillColor(color);
	}
	
	public String removeNumber(String number){
		return number.substring(2);
	}

	public void canRotate() {
		char newColor = sideColor[0];
		for (int i = 1 ; i < sideColor.length ; i++){
			sideColor[i-1] = sideColor[i];
		}
		sideColor[sideColor.length - 1] = newColor;
		
		color = "";
		
		for(int i = 0; i < sideColor.length ; i++){
			color += sideColor[i] + "";
		}
		setColor(color);
	}
	
	public void fillColor(String colorFill){
		for (int i = 0 ; i < sideColor.length ; i++){
			sideColor[i] = colorFill.charAt(i+2);
		}
	}
	
	public char iceCream(int n){
		return sideColor[n];
	}
	
	public void setColor(String Color){
		this.color = color;
	}

	public String toString(){
		return color;
	}
}

