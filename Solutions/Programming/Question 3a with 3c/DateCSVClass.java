
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateCSVClass {
	
		/*
			For some reason, the output would be in a unidentified language depending on the machine you are looking at. However I am able to produce the correct result. 
		
		*/
		public static void main(String[] args) throws ParseException, IOException
	    {
			File file = new File("date.txt"); // or date.csv
			try {
			//create a new file if it doesn't exist already
			file.createNewFile();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
			String[] dayNames = {"First","Second","Third","Fourth","Fifth"	,"Sixth", "Seventh" ,"Eighth"	,"Nineth","Tenth"	,"Eleventh","Twelfth"	,"Thirteenth","Fourteenth","Fifteenth","Sixteenth","Seventeenth"	,"Eighteenth","Nineteenth","Twentieth","Twenty-first","Twenty-second", "Twenty-third", "Twenty-four","Twenty-fifth","Twenty-sixth", "Twenty-seventh", "Twenty-eighth", "Twenty-ninth","Thirtieth","Thirty-first"};
			String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};    
			String[] quarter = {"Q1", "Q2", "Q3", "Q4"};
			String[] dayOfWeek = {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};
			
			String firstDate = "2000-01-01";
			String endDate = "2004-12-31";
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			Calendar cal1 = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();
			
			Date date1 = sdf.parse(firstDate);
			Date date2 = sdf.parse(endDate);
			
			cal1.setTime(date1);
			cal2.setTime(date2);
			String dt1 = sdf.format(cal1.getTime());
			
			String firstDateText = dt1 + "," + monthNames[cal1.get(Calendar.MONTH)] + "," + cal1.get(Calendar.DAY_OF_YEAR) + "," + dayOfWeek[cal1.get(Calendar.DAY_OF_WEEK)- 1] + "," + quarter[(cal1.get(Calendar.MONTH)/3)] + "," + dayNames[cal1.get(Calendar.DAY_OF_MONTH) - 1] + " of " + monthNames[cal1.get(Calendar.MONTH)];
			
			
			System.out.println(firstDateText);
			FileOutputStream saveFile = new FileOutputStream("date.txt"); // or date.csv
			
			ObjectOutputStream save = new ObjectOutputStream(saveFile);
				
			save.writeObject(firstDateText);
			save.writeObject("\n"); // write a new line
			save.flush();
			
			while(cal1.before(cal2))
			{
				save.writeObject("\n");
				cal1.add(Calendar.DATE, 1);
				dt1 = sdf.format(cal1.getTime());
				String nextDateText = dt1 + "," + monthNames[cal1.get(Calendar.MONTH)] + "," + cal1.get(Calendar.DAY_OF_YEAR) + "," + dayOfWeek[cal1.get(Calendar.DAY_OF_WEEK)- 1] + "," + quarter[(cal1.get(Calendar.MONTH)/3)] + "," + dayNames[cal1.get(Calendar.DAY_OF_MONTH) - 1] + " of " + monthNames[cal1.get(Calendar.MONTH)];
				System.out.println(nextDateText);
				save.writeObject(nextDateText);
				save.writeObject("\n");
				save.flush();
			}
			save.close();
			

			
	    
	    }
}


