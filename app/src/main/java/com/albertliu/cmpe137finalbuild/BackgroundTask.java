package com.albertliu.cmpe137finalbuild;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Albert on 5/10/2016.
 */
public class BackgroundTask extends AsyncTask<String, Void, String> {

    String register_url = "http://24.4.155.42:8080/loginapp/register.php";
    String login_url = "http://24.4.155.42:8080/loginapp/login.php";
    String size_url = "http://10.0.2.2:8080/loginapp/sizeinput.php";
    Context ctx;
    Activity activity;
    AlertDialog.Builder builder;
    ProgressDialog progressDialog;

    public BackgroundTask(Context ctx)
    {
        this.ctx = ctx;
        activity = (Activity)ctx;
    }

    @Override
    protected void onPreExecute() {

        builder = new AlertDialog.Builder(activity);
        progressDialog = new ProgressDialog(ctx);
        progressDialog.setTitle("Please wait...");
        progressDialog.setMessage("Connecting to server");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.show();

    }

    @Override
    protected String doInBackground(String... params) {

        String method = params[0];
        if(method.equals("register"))
        {
            try
            {
                URL url = new URL(register_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String name = params[1];
                String username = params[2];
                String password = params[3];
                String data = URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"+
                        URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"+
                        URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                String line = "";
                while ((line=bufferedReader.readLine()) != null)
                {
                    stringBuilder.append(line+"\n");
                }
                httpURLConnection.disconnect();
                Thread.sleep(5000);
                return stringBuilder.toString().trim();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else if (method.equals("login"))
        {
            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String username, password;
                username = params[1];
                password = params[2];
                String data = URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"+
                        URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                String line = "";
                while ((line=bufferedReader.readLine()) != null)
                {
                    stringBuilder.append(line+"\n");
                }
                httpURLConnection.disconnect();
                Thread.sleep(5000);
                return stringBuilder.toString().trim();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        if(method.equals("sizeinput")) {
            try {
                URL url = new URL(size_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String shirtsize = params[1];
                String pantswaist = params[2];
                String pantslength = params[3];
                String socksize = params[4];
                String data = URLEncoder.encode("shirtsize", "UTF-8") + "=" + URLEncoder.encode(shirtsize, "UTF-8") + "&" +
                        URLEncoder.encode("pantswaist", "UTF-8") + "=" + URLEncoder.encode(pantswaist, "UTF-8") + "&" +
                        URLEncoder.encode("pantslength", "UTF-8") + "=" + URLEncoder.encode(pantslength, "UTF-8") + "&" +
                        URLEncoder.encode("socksize", "UTF-8") + "=" + URLEncoder.encode(socksize, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line + "\n");
                }
                httpURLConnection.disconnect();
                Thread.sleep(5000);
                return stringBuilder.toString().trim();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return null;

    }

    @Override
    protected void onPostExecute(String json) {

        try {
            progressDialog.dismiss();
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("server_response");
            JSONObject JO = jsonArray.getJSONObject(0);
            String code = JO.getString("code");
            String message = JO.getString("message");
            if(code.equals("reg_true"))
            {
                showDialog("Success!", message, code);
            }
            else if(code.equals("reg_false"))
            {
                showDialog("Registration Error", message, code);
            }
            else if(code.equals("login_true"))
            {
                showDialog("Login Successful!", message, code);
            }
            else if(code.equals("login_false"))
            {
                showDialog("Login failed", message, code);
            }
            else if(code.equals("size_true"))
            {
                showDialog("Size Input Recorded", message, code);
            }
            else if(code.equals("size_false"))
            {
                showDialog("Size Input Failed", message, code);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    public void showDialog(String title, String message, String code)
    {
        builder.setTitle(title);
        if(code.equals("reg_true"))
        {
            builder.setMessage(message);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    activity.startActivity(new Intent(activity, aboutUS.class));
                }
            });
        }
        else if(code.equals("reg_false"))
        {
            builder.setMessage(message);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    activity.finish();
                }
            });
        }
        else if(code.equals("login_true"))
        {
        builder.setMessage(message);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    Intent intent = new Intent(activity, companyList.class);
                    activity.startActivity(intent);
                }
            });

        }
        else if(code.equals("login_false"))
        {

            builder.setMessage(message);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    LogoActivity.uID.setText("");
                    LogoActivity.password.setText("");
                    dialog.dismiss();
                }
            });
        }
        else if(code.equals("size_true"))
        {
            builder.setMessage(message);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(activity, editInfo.class);
                    activity.startActivity(intent);
                }
            });

        }
        else if(code.equals("size_false"))
        {
            builder.setMessage(message);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

        }
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
