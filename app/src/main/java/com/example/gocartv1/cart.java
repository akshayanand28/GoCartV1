package com.example.gocartv1;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class cart extends AppCompatActivity {

    private TextView textViewResult;
    private int tot=0;
    private ListView list;
    ProgressDialog progressDialog;
    private GridView Gv;
    private ArrayAdapter<String> adapter,adaptter1;
    private ArrayList<String> arrayList,arrayList2;
    String lgn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Button Login = (Button)findViewById(R.id.button2);
        Button pay=(Button)findViewById(R.id.button);
        final EditText logintext = (EditText)findViewById(R.id.tagid);
        final TextView totview=(TextView)findViewById(R.id.textView);

       // textViewResult = findViewById(R.id.text_view_result);

       list = (ListView) findViewById(R.id.Listview);
        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList);
        Gv = (GridView)findViewById(R.id.grid);
        arrayList2 = new ArrayList<String>();
        adaptter1=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList2);

       /* final ArrayList<Product> arrayOfUsers = new ArrayList<Product>();
// Create the adapter to convert the array to views
        final UsersAdapter adapter = new UsersAdapter(this, arrayOfUsers);
// Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.Listview);
        listView.setAdapter(adapter);*/
        // Here, you set the data in your ListView
       list.setAdapter(adapter);
       Gv.setAdapter(adaptter1);


/*
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if (!response.isSuccessful()) {
                    //textViewResult.setText("Code: " + response.code());
                    return;
                }


                List<Post> posts = response.body();

                for (Post post : posts) {
                    String content = "";
                    content += "ID: " + post.getId() + "\n";
                    content += "User ID: " + post.getUserId() + "\n";
                    content += "Title: " + post.getTitle() + "\n";
                    content += "Text: " + post.getText() + "\n\n";
                    Log.e("response-success",post.getTitle());
                    Log.e("response-success", "11111111111111111111111111111111111111111111111111111");
                    Product newProduct = new Product("hhhh","kkkk");
                    //adapter.add(newProduct);
                   //  arrayOfUsers.add(newProduct);

                    arrayList.add(post.getTitle());
                    adapter.notifyDataSetChanged();
                    arrayList2.add(post.getTitle());
                    adaptter1.notifyDataSetChanged();
                  // textViewResult.setText("ggg");
                    //textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
               // textViewResult.setText(t.getMessage());
            }
        });*/
pay.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(cart.this,Payment.class);
        startActivity(intent);
    }
});





        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lgn= logintext.getText().toString();

                //Toast.makeText(login.this,lgn,Toast.LENGTH_LONG).show();




                progressDialog = new ProgressDialog(cart.this);
                progressDialog.setMessage("Uploading...");


                progressDialog.show();
                //Toast.makeText(login.this,lgn,Toast.LENGTH_LONG).show();
                // Toast.makeText(login.this,"12222222222222222222222",Toast.LENGTH_LONG).show();
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("phn", "1234");
                jsonObject.addProperty("rfid", lgn);
                //JsonArray citiesArray = new JsonArray();
                //citiesArray.add(String.valueOf(passtext));

                //jsonObject.add("pass", citiesArray);
                IRetrofit jsonPostService = ServiceGenerator.createService(IRetrofit.class, "http://ec2-13-233-208-238.ap-south-1.compute.amazonaws.com/");
                Call<Objec> call = jsonPostService.postRawJSON(jsonObject);
                Log.e("call",jsonObject.toString());
                call.enqueue(new Callback<Objec>() {

                    @Override
                    public void onResponse(Call<Objec> call, Response<Objec> response) {
                        try{
                            Toast.makeText(cart.this,"LoggedIn",Toast.LENGTH_LONG).show();


                            progressDialog.dismiss();

                            arrayList.add(response.body().getName()+"           "+response.body().getPrice());
                            adapter.notifyDataSetChanged();
                            arrayList2.add(response.body().getR_one()+response.body().getP_one());
                            arrayList2.add(response.body().getR_two()+response.body().getP_two());
                            arrayList2.add(response.body().getR_three()+response.body().getP_three());
                            adaptter1.notifyDataSetChanged();
                            tot = tot+Integer.parseInt(response.body().getPrice());
                            totview.setText("Total :"+tot);
                            //Toast.makeText(login.this,response.body().getAuth(),Toast.LENGTH_LONG).show();
                           Log.e("response-success", response.body().getName());
                            Log.e("response-success", "11111111111111111111111111111111111111111111111111111");



                        }catch (Exception e){
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onFailure(Call<Objec> call, Throwable t) {
                        Log.e("response-failure", call.toString());
                    }

                });

                // Intent inttt=new Intent(login.this,MainActivity.class);
                //  startActivity(inttt);
            }
        });




    }
}