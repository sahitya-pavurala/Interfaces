/**
Program to create cars engines and wheels and adding engines and wheels to cars 
@author : Sahitya Pavurala
//ID : 0490373
//HW 04
*/


/** Car is the class which constructs cars*/
class Car implements Cloneable, Comparable<Car>
{	
	/**Company is the member of type string which holds the company of the car*/
	private String company;
	/**Company is the member of type Engine which holds the engine of the car*/
	private Engine engine;
	/**Company is the member of type int which holds the number of wheels of the car*/
	private int numWheels;
	/**Company is the member of type Wheel[] which holds the wheels of the car*/
	private Wheel[] wheels;
	/** Car(String company,int numWheels,String brand,double radius,String engineType,double horsepower) is a constructor which constructs the car
	 @param		company		company of the car
				numWheels	number of wheels of the car
				brand		brand of the wheel used
				radius 		radius of the wheel
				engineType	type of engine used
				horsepower	power of the engine
	 */
	public Car(String company,int numWheels,String brand,double radius,String engineType,double horsepower)
	{
		this.company=company;
		this.numWheels = numWheels;
		this.engine = new Engine(engineType,horsepower);
		this.wheels = new Wheel[numWheels];
		for(int i = 0; i < numWheels; i++) 
		{
            wheels[i] = new Wheel(brand, radius);
        }
	}
	
	@Override //here we are overriding the toString method to display the Car information
	 public String toString() 
	{
		StringBuilder carInfo = new StringBuilder();
		carInfo.append("This CAR is made by : " + company + "\n");
		//check if engine is null
		if(engine != null)
            carInfo.append("\t" + engine);
			else
			carInfo.append("\tEngine has been removed\n");
		for(Wheel wheel: wheels) 
		{	//check if wheel is null
			if(wheel != null)
            carInfo.append("\t" + wheel);
			else
			carInfo.append("\tThis wheel has been removed\n");
        }
        return carInfo.toString();
    }
	
	/** Engine removeEngine() is a method for removing the car engine
	 @return	removed		it is the removed engine  		    
	*/
	public Engine removeEngine() throws CloneNotSupportedException {
        if(engine == null) return null;
        Engine removed = engine;
        engine = null;
        return removed;
    }
	
	/** addEngine(Engine addedEngine)is a method for adding the car engine
	 @param		addedEngine		it is the added engine  		    
	*/
	public void addEngine(Engine addedEngine) throws CloneNotSupportedException
	{
        //check if engine is null
        if(this.engine != null) {
            System.out.println("This car is not supported for two engines\n");
            return;
        }
		//check if added engine is null
		else if(addedEngine == null) {
            System.out.println("Nothing is added");
            return;
        }
		else {
        this.engine = (Engine) addedEngine.clone();
        addedEngine = null;
		}
    }
	
	/** Wheel removeWheel(int tyrePosition) is a method for removing the car wheel
	@return		removed			it is the removed wheel  	
	@param		tyrePosition	it is the position where the wheel is to be removed
	*/
	public Wheel removeWheel(int tyrePosition) throws CloneNotSupportedException 
	{	
		//check if the wheel can be removed
		if(tyrePosition >= numWheels || tyrePosition < 0 || wheels[tyrePosition] == null) return null;
        Wheel removed = wheels[tyrePosition];
        wheels[tyrePosition] = null;
        return removed;
	}
	
	
	/** addWheel(Wheel addedWheel,int tyrePosition) is a method for adding the car wheel
	 @param		addedWheel		it is the added engine  		    
				tyrePosition 	position where the tyre is to be added
	
		*/
	public void addWheel(Wheel addedWheel,int tyrePosition) throws CloneNotSupportedException
	{	
		//check if the wheel exists
		if(this.wheels[tyrePosition] != null) {
            System.out.println("This car is not supported for dual tyres\n");
            return;
        }
		else if(addedWheel == null) {
            System.out.println("Nothing is add");
            return;
        }
		//check if the wheel can be added
        else if(tyrePosition >= numWheels || tyrePosition < 0 ) {
            System.out.println("This car cannot hold more than " + numWheels  + " number of wheels");
            return;
        }
		else 
		{
        wheels[tyrePosition] = (Wheel) addedWheel.clone();
        addedWheel = null;
		}
	}
	
	@Override //here we are overriding the clone method to create clones of car
	public Car clone() throws CloneNotSupportedException 
	{
        Car cloned = (Car)super.clone();
        cloned.engine = (Engine)engine.clone();
        cloned.wheels = (Wheel[])wheels.clone();
        return cloned;
    }
	
	@Override //here we are overriding the compareTo method to compares two cars
	public int compareTo(Car other) 
	{
        return this.engine.compareTo(other.engine);
    }
	
	@Override //here we are overriding the equals method
	public boolean equals(Object other)
	{	
		// check if the other is null
        if(other == null) return false;
        else if(getClass() != other.getClass()) return false;
		else if(this == other) return true;
		// the equals method will return true if the cars engine, numWheels and company are the same
        else 
		{
			Car otherCar = (Car)other;
			if (company.equals(otherCar.company) && numWheels == otherCar.numWheels && this.engine.equals(otherCar.engine))
			{return true;}
			else {return false;}	
		}
	}
	
	@Override //here we are overriding the hashCode method
	public int hashCode() 
	{	
		int hash = 3;
        hash = 7 * hash + engine.hashCode();
		hash = 11 * hash + new Integer(numWheels).hashCode(); 
		hash = 13 * hash + company.hashCode();
		return hash;
    }
}	



	
/** Wheel is the class which constructs wheels*/	
class Wheel implements Cloneable, Comparable<Wheel>
{	
	/**brand is the member of type string which holds the brand of the wheel*/
	private String brand;
	/**brand is the member of type double which holds the radius of the wheel*/
	private double radius;
	
	/** Wheel(String brand,double radius) is a constructor which constructs the wheel
	 @param		brand		brand of the wheel
				radius		radius of the wheels
	*/
	public Wheel(String brand,double radius)
	{
		this.brand = brand;
		this.radius = radius;
	}
	
	@Override //here we are overriding the toString method to display the wheel information
	public String toString() 
	{
		
		return "WHEEL : Brand " + brand + ", Radius " + radius + "\n";
    }
	
	
	@Override //here we are overriding the compareTo method to compares two wheels
	public int compareTo(Wheel other) 
	{
        int difference =  (int)(radius - other.radius);
		return difference;
    }
	
	@Override //here we are overriding the clone method to create clones of wheels
	public Wheel clone() throws CloneNotSupportedException {
        Wheel cloned = (Wheel) super.clone();
        return cloned;
    }
	
	@Override //here we are overriding the equals method
	public boolean equals(Object other)
	{
        if(other == null) return false;
        else if(getClass() != other.getClass()) return false;
		else if(this == other) return true;
        else 
		{
			Wheel otherWheel = (Wheel)other;
			if (brand ==otherWheel.brand && radius == otherWheel.radius)
			{return true;}
			else {return false;}	
		}
	}

	@Override //here we are overriding the hashCode method
	public int hashCode() 
	{
        int hash = 3;
		hash = 7 * hash + brand.hashCode(); 
		hash = 11 * hash + new Double(radius).hashCode();
		return hash;
    }
	
}



/** Engine is the class which constructs engine*/	
class Engine implements Cloneable, Comparable<Engine>
{	
	/**type is the member of type string which holds the type of the engine*/
	private String type;
	/**horsepower is the member of type double which holds the power of the engine*/
	private double horsepower;
	
	/** Engine(String type,double horsepower) is a constructor which constructs the engine
	 @param		type		type of the engine
				horsepower		power of the engine
	*/
	public Engine(String type,double horsepower)
	{
		this.type = type;
		this.horsepower = horsepower;
	}
	@Override //here we are overriding the toString method to display the engine information
	public String toString() 
	{
		return "And is made of : ENGINE " + type + ", Horse power " + horsepower + "\n";
	}
	
	@Override //here we are overriding the compareTo method to compares two engines
	public int compareTo(Engine other) {
        return (int)(horsepower - other.horsepower);
    }
    
	@Override //here we are overriding the clone method to create clones of engines
	public Engine clone() throws CloneNotSupportedException {
        Engine cloned = (Engine) super.clone();
        return cloned;
    }
	
	@Override //here we are overriding the equals method
	public boolean equals(Object other)
	{
        if(other == null) return false;
        else if(getClass() != other.getClass()) return false;
		else if(this == other) return true;
        else 
		{
			Engine otherEngine = (Engine)other;
			if (type ==otherEngine.type && horsepower == otherEngine.horsepower)
			{return true;}
			else {return false;}	
		}
	}
	@Override //here we are overriding the hashCode method
	public int hashCode() 
	{
        int hash = 3;
		hash = 7 * hash + type.hashCode(); 
		hash = 11 * hash + new Double(horsepower).hashCode();
		return hash;
    }

}

class Test {
	public static void main(String[] args) throws CloneNotSupportedException {
        
        //Creating car objects 
        Car car1 = new Car("Maruthi", 4 ,"MRF", 20, "V6",100 );
        Car car2 = new Car("Tata",  4 ,"CEAT", 12, "V7",200 );
        Car car3 = new Car("Ducati",  4 ,"DUNLOP", 18, "V8",300 );
        System.out.println("CAR1 \n" + car1);
		
		// creating engine and wheel objects
		Engine v6 = new Engine("V6", 100);
		Engine v7 = new Engine("V7", 200);
        Wheel mrf = new Wheel("MRF", 20);

		//Removing wheel from car 1
		System.out.println("Removing wheel of car1 from position 2 \n");
        car1.removeWheel(2);
		System.out.println("CAR1 \n" + car1);
		
        //Adding a wheel to car1
        System.out.println("Adding a wheel to car1, which has its wheel removed");
        car1.addWheel(mrf, 2);
		System.out.println("CAR1 \n" + car1);
		
		//Adding a wheel to car1, which already has wheels
        System.out.println("Adding a wheel to car1, which already has wheels");
        car1.addWheel(mrf, 2);
		
		
		//Removing an engine from car1
		car1.removeEngine();
		System.out.println("CAR1 \n" + car1);
		
		//Adding a engine to car1
        System.out.println("Adding a engine to car1, which is removed");
        car1.addEngine(v6);
		System.out.println("CAR1 \n" + car1);
		
		
		//Adding a engine to car1 which already has an engine
        System.out.println("Adding a engine to car1, which already has an engine");
        car1.addEngine(v6);
		
       
        
        //clone car1 and check for equals, hashcode, compateTo
        Car car1Clone = (Car) car1.clone();
        System.out.println("creating a clone of car1");
        System.out.println("CLONE_of_car1 \n" + car1Clone);
        System.out.println("Check if car1 and car1Clone are equal?? : " + car1.equals(car1Clone));
        System.out.println("car1.hashCode() = " + car1.hashCode());
        System.out.println("car1Clone.hashCode() = " + car1Clone.hashCode());
        System.out.println("car1.compareTo(car1Clone) : " + car1.compareTo(car1Clone));
		
		//removing engine because i want to change the engine
		car1.removeEngine();
		System.out.println("CAR1 \n" + car1);
		
		//Adding a different engine to car1
        System.out.println("Adding a engine to car1, which is removed");
        car1.addEngine(v7);
		System.out.println("CAR1 \n" + car1);
		
		//check for equals, hashcode, compateTo after changing the engine of car1
		System.out.println("Testing car1 and car1Clone after changing the engine of car1: ");  
        System.out.println("Check if car1 and car1Clone are equal?? " + car1.equals(car1Clone));
        System.out.println("car1.hashCode() = " + car1.hashCode());
        System.out.println("car1Clone.hashCode() = " + car1Clone.hashCode());
        System.out.println("car1.compareTo(car1Clone) : " + car1.compareTo(car1Clone));
        
    }

}
