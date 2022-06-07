package garage;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] models = {"F-250", "Explorer", "Transit Connect", "Escape", "Maverick"};
		String[] colors = {"blue", "pink", "purple", "red", "brown", "white"};
		String[] modelPackages = {"standard", "premium", "deluxe"};
		
		ArrayList<Car> garage = new ArrayList<Car>();
		
		for (String a: models)
		{
			for (String b: colors)
			{
				for(String c: modelPackages)
				{
					garage.add(new Car(a, b, c));
				}
			}
		}
		JOptionPane.showMessageDialog(null, "Welcome to my Car Dealership!");
		boolean run = true;
		String[] options = {"display all cars", "Purchase a car","display all available models", "display all specific cars based on model", "remove all models based on color", "remove all models based on package", "remove one car with specific model and package", "add a car"};
		while (run)
		{
			Object menuSelection = JOptionPane.showInputDialog(null, "Choose from on of the options below please", "Car Dealership", 1, null, options, null);
			if(menuSelection == "display all cars")
			{
				String print = "";
				for(int i = 0; i < garage.size(); i++)
				{
					int a = i+1;
					print += a + ") " + " " + garage.get(i).model + " with " + garage.get(i).modelPackage + " package ";
					if (i%5 == 0)
					{
						print += "\n";
					}
				}
				JOptionPane.showMessageDialog(null, print);
			}
			
			else if (menuSelection == "Purchase a car") 
			{
				String print = "";
				String model = (String) JOptionPane.showInputDialog(null, "please select a model", "Car Dealership", 1, null, models, null);
				String color = (String) JOptionPane.showInputDialog(null, "please select a color", "Car Dealership", 1, null, colors, null);
				String carPackage = (String) JOptionPane.showInputDialog(null, "please select a package", "Car Dealership", 1, null, modelPackages, null);
				for (int i = 0; i < garage.size(); i++)
				{
					if(garage.get(i).model.equalsIgnoreCase(model) && garage.get(i).color.equalsIgnoreCase(color) && garage.get(i).modelPackage.equalsIgnoreCase(carPackage))
					{
						print += "Purchased a " + garage.get(i).color + " " + garage.get(i).model + " with a " + garage.get(i).modelPackage + " package.";
						garage.remove(i);
						i = garage.size();
					}
				}
				JOptionPane.showMessageDialog(null, print);
			}
			else if (menuSelection == "display all available models")
			{
				int toyota = 0;
				int tesla = 0;
				int ford = 0;
				int mitsubishi = 0;
				int subaru = 0;
				for (int i = 0; i < garage.size(); i++)
				{
					if (garage.get(i).model == "F-250")
						toyota++;
					else if (garage.get(i).model == "Explorer")
						tesla++;
					else if (garage.get(i).model == "Transit Connect")
						ford++;
					else if (garage.get(i).model == "Escape")
						mitsubishi++;
					else if (garage.get(i).model == "Maverick")
						subaru++;		
				}
				JOptionPane.showMessageDialog(null, "There are " + toyota + " F-250s, " + tesla + " Explorers, " + ford + " Transit Connects, " + mitsubishi + " Escapes, and " + subaru + " Mavericks.");
			}
			else if (menuSelection == "display all specific cars based on model")
			{
				String print = "";
				String model = (String) JOptionPane.showInputDialog(null, "please select a model", "Car Dealership", 1, null, models, null);
				for (int i = 0; i < garage.size(); i++)
				{
					if(garage.get(i).model.equalsIgnoreCase(model))
					{
						print += garage.get(i).color + " " + garage.get(i).model + " with " + garage.get(i).modelPackage + " package\n";
					}
				}
				JOptionPane.showMessageDialog(null, print);
			}
			else if (menuSelection == "remove all models based on color")
			{
				int counter = 0;
				String color = (String) JOptionPane.showInputDialog(null, "please select a color", "Car Dealership", 1, null, colors, null);
				for (int i = 0; i < garage.size(); i++)
				{
					if(garage.get(i).color.equalsIgnoreCase(color))
					{
						garage.remove(i);
						i = -1;
						counter++;
					}
				}
				JOptionPane.showMessageDialog(null, "removed " + counter + " cars");
			}
			else if (menuSelection == "remove all models based on package")
			{
				int counter = 0;
				String carPackage = (String) JOptionPane.showInputDialog(null, "please select a package", "Car Dealership", 1, null, modelPackages, null);
				for (int i = 0; i < garage.size(); i++)
				{
					if(garage.get(i).modelPackage.equalsIgnoreCase(carPackage))
					{
						garage.remove(i);
						i = 0;
						counter++;
					}
				}
				JOptionPane.showMessageDialog(null, "removed " + counter + " cars");
			}
			else if (menuSelection == "remove one car with specific model and package")
			{
				String print = "";
				String model = (String) JOptionPane.showInputDialog(null, "please select a model", "Car Dealership", 1, null, models, null);
				String carPackage = (String) JOptionPane.showInputDialog(null, "please select a package", "Car Dealership", 1, null, modelPackages, null);
				for (int i = 0; i < garage.size(); i++)
				{
					if(garage.get(i).model.equalsIgnoreCase(model) && garage.get(i).modelPackage.equalsIgnoreCase(carPackage))
					{
						print += "Removed a " + garage.get(i).color + " " + garage.get(i).model + " with a " + garage.get(i).modelPackage + " package.";
						garage.remove(i);
						i = garage.size();
					}
				}
				JOptionPane.showMessageDialog(null, print);
			}
			else if (menuSelection == "add a car")
			{
				String model = (String) JOptionPane.showInputDialog(null, "please select a model", "Car Dealership", 1, null, models, null);
				String color = (String) JOptionPane.showInputDialog(null, "please select a color", "Car Dealership", 1, null, colors, null);
				String carPackage = (String) JOptionPane.showInputDialog(null, "please select a package", "Car Dealership", 1, null, modelPackages, null);
				garage.add(new Car(model, color, carPackage));
				JOptionPane.showMessageDialog(null, "Added a: " + color + " " + model + " with a " + carPackage + " package");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Thank you for visiting");
				run = false;
			}
		}
	}
}
