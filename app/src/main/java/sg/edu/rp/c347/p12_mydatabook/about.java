package sg.edu.rp.c347.p12_mydatabook;

import android.Manifest;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class about extends AppCompatActivity {

    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        iv = findViewById(R.id.imageView2);

        int permissionCheck_Internet = ContextCompat.checkSelfPermission(about.this, Manifest.permission.INTERNET);

        if (permissionCheck_Internet == PermissionChecker.PERMISSION_GRANTED){
            String imageUrl = "https://upload.wikimedia.org/wikipedia/commons/8/80/Republic_Polytechnic_Logo.jpg";
            Picasso.with(this).load(imageUrl).placeholder(R.drawable.ajax_loader).error(R.drawable.error).into(iv);
        }else{
            ActivityCompat.requestPermissions(about.this, new String[]{Manifest.permission.INTERNET}, 0);

        }


    }
}
