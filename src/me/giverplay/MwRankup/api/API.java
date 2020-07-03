package me.giverplay.MwRankup.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class API
{
  public static String Construtor(String[] args)
  {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < args.length; i++)
	{
      if(args[i] != "")
      {
	    sb.append(args[i]);
	    sb.append(" ");
      }
	}
	return sb.toString();
  }
  
  public static String pegarTraducao(String idioma, String texto) throws Exception
  {
    String url = "https://translate.googleapis.com/translate_a/single?client=gtx&sl=auto&tl=" + idioma + "&dt=t&q=" + URLEncoder.encode(texto, "UTF-8");
	URL obj = new URL(url);
	HttpURLConnection rqst = (HttpURLConnection)obj.openConnection();
	rqst.setRequestProperty("User-Agent", "Mozilla/5.0");		    
	BufferedReader in = new BufferedReader(new InputStreamReader(rqst.getInputStream()));
				    
	StringBuffer resposta = new StringBuffer();
	String inputLine;
	while ((inputLine = in.readLine()) != null)
	{
	  resposta.append(inputLine);
	}
	in.close();		    
	String s = resposta.toString();	    
	String a = s.substring(s.indexOf("[[[\"") + 4, s.indexOf("\",\""));
    a = a.replace("\\\"", "").replace("\\u003c", "<").replace("\\u003e", ">");	    
	return a;
  } 
}
