
import java.util.*;
import java.net.URL;
import java.io.BufferedReader;
import java.net.MalformedURLException;
import java.io.InputStreamReader;
import java.io.*;

public class WebPage
{
	private List<String> content;

	public boolean scan(String URL)
	{
		BufferedReader buffer = null;
		try
		{
			URL temp = new URL(URL);
			String line = null;
			buffer = new BufferedReader(new InputStreamReader(temp.openStream()));
			while ((line = buffer.readLine()) != null)
			{
				content.add(line);
			}
			return true;
		}
		catch (MalformedURLException ex)
		{
			return false;
		}
		catch (IOException ex)
		{
			return false;
		}
		
	}	
	public List<String> getContent()
	{
		return content;
	}
}
