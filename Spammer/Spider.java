

import java.util.*;

public class Spider
{
	private List<String> emails;
	private List<String> URLs;
	private int deadLinks;

	public Spider (String URL)
	{
		this.emails = new ArrayList<String>();
		this.URLs = new ArrayList<String>();
                this.URLs.add(URL);
                
	}
        
        
        

	public void setdeadLinks()
	{
		deadLinks++;
	}
        
        
        

	public void beginCrawl()
	{
		List<String> content = new ArrayList<String>();
		WebPage w = new WebPage();
		while (deadLinks < 10 && emails.size() <= 100)
		{
			if(!visitCheck(URLs.get(0)))
			{
				if(w.scan(URLs.get(0)))
				{
					content = w.getContent();
					process(content);
				}
				else
				{
					setdeadLinks();
				}
				Spambot.visitedURLs.add(URLs.get(0));
			}
			URLs.remove(0);	
		}
                for (int i = 0; i < emails.size();i++) {
                    
                
                Spambot.emailsFarmed.add(emails.get(i));
                }
	}
        
        
        

	public boolean visitCheck(String str)
	{
            try {
            return Spambot.visitedURLs.contains(str);
	}
            catch (NullPointerException ex) {
                return false;
            }
        }

	public void process(List<String> list)
	{
		String mergedContent = "";
		for (int i = 0; i < list.size(); i++)
		{
			mergedContent =  mergedContent + list.get(i);
		}
		String findURL = "<a href=";
		for(int i = 7, backCounter = 0; i < mergedContent.length(); i++, backCounter++)
		{
			if(mergedContent.substring(backCounter, i).equals(findURL))
			{
				char quote = '"';
				boolean linkcomplete = false;
				for(int linkcounter = i + 2; !linkcomplete; linkcounter++)
				{
					if(quote == mergedContent.charAt(linkcounter))
					{
						linkcomplete = true;
						URLs.add(mergedContent.substring(i + 2,linkcounter));
					}
				}
			}
		}
		char findemail = '@';
		for(int i = 0; i < mergedContent.length(); i++)
		{
			if(findemail == mergedContent.charAt(i))
			{
				int backcounter = 0;
				int frontcounter = 0;
				boolean backfound = false;
				for (backcounter = i - 1; !backfound && backcounter > 0; backcounter--)
				{
					if(mergedContent.charAt(backcounter) == ' ')
					{
						backfound = true;
					}
				}
				boolean frontfound = false;
				for (frontcounter = i + 1; !frontfound && frontcounter < mergedContent.length(); frontcounter++)
				{
					if(mergedContent.charAt(frontcounter) == ' ')
					{
						frontfound = true;
					}
				}
				emails.add(mergedContent.substring(backcounter, frontcounter));
			}
		}

	}
}
