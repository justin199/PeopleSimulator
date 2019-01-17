import java.util.ArrayList;


class Person {
	public int age;
	private String name;
    private int birthday;
    private String gender;
    public String place;
    public Person spouse;
    public int thisPopulation;
    private ArrayList <Integer> haves = new ArrayList <Integer>();
    private ArrayList <Integer> wants = new ArrayList <Integer>();
    private boolean married = false;
    public int IQ = bellCurve(100,15);
    public int income = bellCurve(53719,30000);
    public int points = 0;
    public int mill = bellCurve(50,25);

	public Person(int age, String name,String gender,int birthdate,String place) {
		this.name = name;
		this.age = age;
        this.birthday = birthdate;
        this.gender = gender;
        this.place = place;
        this.spouse = null;
        for(int i = 0; i < 10; i++){
            haves.add((int)(Math.random()*10));
            wants.add((int)(Math.random()*10));
        }
    }
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void hadBirthday() {
		age++;
	}

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getGender(){
        return gender;
    }

    public int getBirthday(){
        return birthday;
    }

    public ArrayList <Integer> getHaves(){
        return haves;
    }
    public ArrayList <Integer> getWants(){
        return wants;
    }

    public boolean isMarried(){
        return married;
    }

    public void gotMarriedTo(Person spouse){
        this.spouse = spouse;
    }

    public Person getSpouse(){
        if(spouse != null){
            return spouse;
        }else{
            return null;
        }
    }

     public static int bellCurve(int mean, int sd) {
		// make nombors gud
	    int i = mean - (3*sd);
	    int j = mean + (3*sd);
		int x = i;
		for(int c = i; c < j; c++) {
			double l = Math.random();
			if(l >= 0.5) {
				x++;
			}
		}
		return x;
     }

    public int calcIQ() {
        if(Math.random() < 0.4){
            /* hardWorking */
            IQ = IQ + 10;
        } else if (Math.random() < 0.14){
            /* Temp Education */
            IQ = IQ - 15;
        } else if(Math.random() < 0.39){
            /* Practice an Art */
            IQ = IQ + 5;
        } else if(Math.random() < 0.22){
            /* Exercise */
            IQ = IQ + 5;
        } else if(Math.random() < 0.35){
            /* Has connections/mentors */
            IQ = IQ + 20;
        }
        return IQ;
    }

    public int calcIncome(){
        if(age >= 20){
        if(IQ > 100 && IQ < 115){
            points = IQ - 100; /* Points above average for average people */
            if(Math.random() > 0.75){
                 income = income + (4262 * points);
            } else if(Math.random() < 0.75){
                income = income + (2002 * points);
            }
        } else if(IQ > 115 && IQ < 130){
            points = IQ - 100; /* Points above average for smarter than average people */
            if(Math.random() > 0.75){
                 income = income + (8362 * points);
            } else if(Math.random() < 0.75){
                income = income + (4802 * points);
            }
        } else if(IQ > 130){
            points = IQ - 100; /* Points above average for gifted IQ's */
            if(Math.random() > .60){
                income = income + (8066 * points);
            }
            income = income + (5956 * points);
        } else if(IQ < 100){
            points = 100 - IQ; /* Points below average for dumb people */
            income = income - (1502 * points);
        }  else if(mill >= 60){
            /* Millionare */
            if(bellCurve(100,25) < 60){
            income = income + bellCurve(1250000,500000);
            } else if((bellCurve(100,25) > 60)){
            income = income + bellCurve(5505000,2500000);
            }
        }   //age affecting income
            }
            else if(age > 15 && age < 20){
                income = bellCurve(10000,2000);
            } else if(age < 15){
                income = 0;
            }
            return income;
        }
    public String getPlace(){
         return this.place;
     }
     public String changePlaceTo(String newPlace){
         this.place = newPlace;
         return ("Person " + this.name + "moved to " + newPlace);
     }
}