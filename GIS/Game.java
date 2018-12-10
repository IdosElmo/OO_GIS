package GIS;

import java.io.*;
import java.util.ArrayList;

public class Game extends Layer{

	private static ArrayList<Element> set;
	private static String header; //used for csv file.
	
	public Game(){
		set = new ArrayList<Element>();
	}
		
	public void buildGame(String pathname){
		readFromCSV(pathname);
	}
	
	private static void readFromCSV(String pathname){ 
		
		BufferedReader br = null;
        String line = "";
        String csvSplitBy = ",";
        
        try {

            br = new BufferedReader(new FileReader(pathname));
            header = br.readLine(); //first line is a header.
            while ((line = br.readLine()) != null ) { //read parameters starting from 3rd line.
                // use comma as separator
                String[] string = line.split(csvSplitBy);
                if(string[0].contains("P")){
                	Packman packman = new Packman(string);
                	set.add(packman);
                } else if(string[0].contains("F")){
                	Fruit fruit = new Fruit(string);
                	set.add(fruit);
                }
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
	
	 public void saveGame()  {

	        BufferedReader br = null;
	        String output = "gameToCSV.csv";
	        
	        try {
	   
	            File file = new File(output);
	            if(!file.createNewFile()){ //if the file exists, delete it and start over.
	            	file.delete();
	            	writeToCSV(output);
	            } else { //file created and start normaly.
	            	writeToCSV(output);
	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
	 
	 private static void writeToCSV(String path) throws IOException{
		 BufferedWriter writer = new BufferedWriter(new FileWriter(path,true));
		 writer.write(header);
		 writer.newLine();
		 for (Element element : set) {
			 String string = element.toString();
		        String regex = "\\[|\\]";
		        string = string.replaceAll(regex, "");
		        writer.write(string);
		        writer.newLine();
		}
		 writer.close();
	 }
	 	 
	 public static void main(String[] a){
		 Game game = new Game();
		 String pathname = "C:/temp/game_1543684662657.csv";
		 game.buildGame(pathname);
		 game.saveGame();
	 }
}
