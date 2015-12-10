package br.com.dwd.sapatariaandroid;

import android.os.AsyncTask;
import android.widget.ListView;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * Created by android5243 on 26/09/15.
 */
public class WebClient {

//    private static final String URL = "http://localhost:8080/sapataria/rest/produto";
    //private static final String URL = "http://192.168.43.63:8080/sapataria/rest/produto";
    private static String URL = "";

    public WebClient(String url) {
        URL = "http://192.168.43.63:8080/sapataria/rest" + url;
    }

    public WebClient(String login, String senha) {
        URL = "http://192.168.43.63:8080/sapataria/rest/security/login/"+login+"/senha/"+senha;
    }

    public String get() {
        //HttpPost post = new HttpPost(URL);
//        HttpGet get = new HttpGet(URL);
        HttpGet get = new HttpGet(URL);
        String jsonDeResposta = null;
        try {

            //post.setEntity(new StringEntity(json));
            /*get.setHeader("Accept", "application/json");
            get.setHeader("Content-type", "application/json");*/
            get.setHeader("Accept", "text/plain");
            get.setHeader("Content-type", "text/plain");

            DefaultHttpClient client = new DefaultHttpClient();
            HttpResponse reponse = client.execute(get);
            jsonDeResposta = EntityUtils.toString(reponse.getEntity());

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  jsonDeResposta;

    }

}
