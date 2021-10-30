import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

class Passanger
{
	int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getFare() {
		return fare;
	}

	public void setFare(float fare) {
		this.fare = fare;
	}
	float fare;
	public Passanger(int id, float fare)
	{
		this.id=id;
		this.fare=fare;
	}
}

class Count{
	int id;
	 public Count(int id) {
		 super();
		 this.id=id;
	 }
	 
	 public Count() {
		 
	 }
	 
	 public int getId() {
		return this.id;
	} 
	 
	 public void setId(int id) {
		 this.id=id;
	 }
}
class BusProb {

	public String output(int capacity, int stops, List<String> listOfInputStrings, String query)
	{
		String outstring="";
		ArrayList<Passanger> passanger= new ArrayList<Passanger>();
		List<String>passList=new ArrayList<String>();
		if (query.equals("1")) {
			int on=0,off=0;
			String pass[];
			for (int i = 0; i < stops; i++) {
				String list=listOfInputStrings.get(i);
				pass=list.split(" ");
				for (int j = 0; j < pass.length; j++) {
					if (pass[j].contains("+")) {
						on++;
					}
					else if (pass[j].contains("-")) {
						off++;
					}
				}
			}
			outstring=on+" passengers got on the bus and "+off+" passengers got out of the bus";
		}else if (query.equals("2")) {
			double fare1=0,fare2,fare3=0;
			int fare1Pass=0,fare2Pass=0,fare3Pass=0,totalPass=0,in=0,out=0;
			String pass[];
			DecimalFormat df = new DecimalFormat("###.#");
			fare1=capacity+(capacity*0.6);
			fare2=capacity+(capacity*0.3);
			fare3=capacity;
			for (int i = 0; i < stops; i++) {
				String list = listOfInputStrings.get(i);
				pass=list.split(" ");
				in=0;
				out=0;
				for (int j = 0; j < pass.length; j++) {
					if (pass[j].contains("+")) {
						in++;
					}else if (pass[j].contains("-")) {
						out++;
					}
				}
				totalPass=totalPass+in-out;
				if (totalPass<= Math.ceil(((double)capacity/4))) {
					fare1Pass+=in;
				}
				else if (totalPass> Math.ceil(((double)capacity/4)) && totalPass<= Math.ceil(((double)capacity/2))) {
					fare2Pass+=in;
				}else if (totalPass> Math.ceil(((double)capacity/2))) {
					fare3Pass+=3;
				}
			}
			outstring=fare1Pass+" passengeers traveled with a fare of "+Double.valueOf(df.format(fare1))+", "+fare2Pass+" Passengers traveled with a fare of "+fare2+" and "+fare3Pass+" passengers traveld with a fare of "+fare3;
		}else if (query.split(",")[0].equals("3")) {
			int qPassId=Integer.parseInt(query.split(",")[1].trim());
			System.out.println(qPassId);
			double passFare=0;
			boolean passIn=false;
			double fare1=0,fare2=0,fare3=0;
			int totalPass=0,in=0,out=0;
			String pass[];
			fare1=capacity+(capacity*0.6);
			fare2=capacity+(capacity*0.3);
			fare3=capacity;
			for (int i = 0; i < stops; i++) {
				String list = listOfInputStrings.get(i);
				pass=list.split(" ");
				in=0;
				out=0;
				for (int j = 0; j < pass.length; j++) {
					if (pass[j].contains("+"+qPassId)) {
						passIn=true;
					}
					else if (pass[j].contains("-"+qPassId)) {
						passIn=false;
					}

					if (pass[j].contains("+")) {
						in++;
					}else if (pass[j].contains("-")) {
						out++;
					}
				}
				totalPass=totalPass+in-out;
				System.out.println("STOP :"+(i+1)+" "+totalPass);
				if (totalPass<=Math.ceil(((double)capacity/4))) {
					if(passIn) {
						passFare+=fare1;
						passIn=false;
						System.out.println("fare_1");
					}
				}else if (totalPass>Math.ceil(((double)capacity/4)) && totalPass<=Math.ceil(((double)capacity/2))) {
					if(passIn) {
						passFare+=fare2;
						passIn=false;
						System.out.println("fare_2");
					} 
				}
				else if (totalPass>Math.ceil(((double)capacity/2))) {
					if(passIn) {
						passFare+=fare2;
						passIn=false;
						System.out.println("fare_2");
					}
				}
			}
			outstring="Passenger "+qPassId+" spent a total fare of "+passFare;
		}else if (query.split(",")[0].equals("4")) {
			ArrayList<Count>count = new ArrayList<Count>();
			int qPassId=Integer.parseInt(query.split(",")[1].trim());
			passanger.clear();
			String pass[];
			int passId,sum=0;
			for (int i = 0; i < stops; i++) {
				String list = listOfInputStrings.get(i);
				pass=list.split(" ");
				for (int j = 0; j < pass.length; j++) {
					if (pass[j].contains("+"+qPassId)) {
						count.add(new Count(Integer.parseInt(pass[j].substring(1))));
					}
				}
			}for (int i=0;i<count.size();i++) {
				if (count.get(1).getId()==qPassId) {
					sum++;
				}
			}
			outstring="Passenger "+qPassId+" has got on the bus for "+sum+" times";
		}else if (query.split(",")[0].equals("5")) {
			int qPassId=Integer.parseInt(query.split(",")[1].trim());
			System.out.println(qPassId);
			String pass[];
			int passId,sum=0;
			for (int i = 0; i < stops; i++) {
				String list=listOfInputStrings.get(i);
				pass=list.split(" ");
				for (int j = 0; j < pass.length; j++) {
					if (pass[j].contains(String.valueOf(qPassId))) {
						sum++;
					}
				}
			}
			System.out.println(sum);
			if (sum%2==0) {
				outstring="Passenger "+qPassId+" was not inside the bus at the end of the trip";
			}
				else {
					outstring="Passenger "+qPassId+" was inside the bus at the end of the trip";
				}
			}
			return outstring;
		}
	}


