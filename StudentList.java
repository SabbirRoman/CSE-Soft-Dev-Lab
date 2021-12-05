import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList
{
	public static void main(String[] args)
	{
		Constants constant = new Constants();

		//Check arguments
		//if the arguments is not given or given string's length is greater than 1 then it will not terminate

		if(args.length == 0 || args.length > 1)
		{
			System.out.println("Program terminated.\nPlease Enter a valid argument");
			return;
		}
		else if(args[0].equals(constant.showAll))
		{
			System.out.println(constant.dLoading);
			try
			{
				String reader = loadData(constant.studentList);
				String input[] = reader.split(constant.StudentEntryDelimite);
				for(String output : input)
				{
					System.out.println(output);
				}
			}
			catch (Exception e)
			{

			}
			System.out.println(constant.dLoaded);
		}
		else if(args[0].equals(constant.showRandom))
		{
			System.out.println(constant.dLoading);
			try
			{
				String reader = loadData(constant.studentList);
				String input[] = reader.split(constant.StudentEntryDelimite);
				Random random = new Random();
				int output = random.nextInt(input.length);
				System.out.println(input[output]);
			}
			catch (Exception e)
			{

			}
			System.out.println(constant.dLoaded);
		}
		else if(args[0].contains(constant.addEntry))
		{
			System.out.println(constant.dLoading);
			try
			{
				BufferedWriter file = new BufferedWriter(new FileWriter(constant.studentList, true));
				String text = args[0].substring(1);
				Date date = new Date();
				String dateformation = "dd/mm/yyyy-hh:mm:ss a";
				DateFormat dateFormat = new SimpleDateFormat(dateformation);
				String formateOfDate= dateFormat.format(date);
				file.write(", "+text+"\nList last updated on "+formateOfDate);
				file.close();
			}
			catch (Exception e)
			{

			}

			System.out.println(constant.dLoaded);
		}
		else if(args[0].contains(constant.findEntry))
		{
			System.out.println(constant.dLoading);
			try
			{
				String reader = loadData(constant.studentList);
				String input[] = reader.split(constant.StudentEntryDelimite);
				boolean done = false;
				String text = args[0].substring(1);
				for(int idx = 0; idx<input.length && !done; idx++)
				{
					if(input[idx].equals(text))
					{
						System.out.println("We found it!");
						done=true;
					}
				}
			}
			catch (Exception e)
			{

			}
			System.out.println(constant.dLoaded);
		}
		else if(args[0].contains(constant.showCount))
		{
			System.out.println(constant.dLoading);
			try
			{
				String reader = loadData(constant.studentList);
				char character[] = reader.toCharArray();
				boolean in_word = false;
				int count=0;
				for(char cnt:character)
				{
					if(cnt ==' ')
					{
						if (!in_word)
						{
							count++;
							in_word = true;
						}
						else
						{
							in_word = false;
						}
					}
				}
				System.out.println(count +" word(s) found " + character.length);
			}
			catch (Exception e)
			{

			}
			System.out.println(constant.dLoaded);
		}
	}
	public static String loadData(String filename)
	{
		try
		{
			BufferedReader fileStream = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			String line = fileStream.readLine();
			return line;
		}
		catch(Exception e)
		{

		}
		return "";
	}
}