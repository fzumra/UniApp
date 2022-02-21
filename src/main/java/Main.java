import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static final String BASE_URL="http://universities.hipolabs.com/search?country=";
    public static void main(String[] args) {

        System.out.println("This program lists all universities for a given country name.");
        System.out.println("Enter country name: ");
        Scanner scn = new Scanner(System.in);
        String countryName = scn.nextLine();
        String formattedCountryName=countryName.toLowerCase(Locale.ROOT).replaceAll("\s","+");

        String result=retrieveInformation(BASE_URL+formattedCountryName);
        if (result!=null) {
            Gson gson = new Gson();
            University[] uniArray = gson.fromJson(result, University[].class);
            for(int i =0;i<uniArray.length;++i) {
                int index=i+1;
                System.out.println(index+"."+uniArray[i].name);

            }
        }


    }
    private static String retrieveInformation(String urlString) {
        HttpURLConnection connection = null;


        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            StringBuilder result = new StringBuilder();
            var inputStreamReader = new InputStreamReader(connection.getInputStream());
            var bufferedReader = new BufferedReader(inputStreamReader);
            for (String line; (line = bufferedReader.readLine()) != null; ) {
                result.append(line);
            }

            return result.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
