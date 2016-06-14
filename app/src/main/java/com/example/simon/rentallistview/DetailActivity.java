package com.example.simon.rentallistview;


import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);

        //set the back (up) button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //find all our view components
        ImageView imageView = (ImageView) findViewById(R.id.image);
        TextView addressTV = (TextView) findViewById(R.id.address);
        TextView descriptionTV = (TextView) findViewById(R.id.description);
        TextView priceTV = (TextView) findViewById(R.id.price);
        TextView bedroomsTV = (TextView) findViewById(R.id.bedrooms);
        TextView bathroomsTV = (TextView) findViewById(R.id.bathrooms);
        TextView carspotsTV = (TextView) findViewById(R.id.carspots);


        //collect our intent and populate our layout
        Intent intent = getIntent();

        Integer streetNumber = intent.getIntExtra("streetNumber", 0);
        String streetName = intent.getStringExtra("streetName");
        String suburb = intent.getStringExtra("suburb");
        String state = intent.getStringExtra("state");
        String description = intent.getStringExtra("description");
        Double price = intent.getDoubleExtra("price", 0.0);
        Integer bedrooms = intent.getIntExtra("bedrooms", 0);
        Integer bathrooms = intent.getIntExtra("bathrooms", 0);
        Integer carspots = intent.getIntExtra("carspots", 0);
        String image = intent.getStringExtra("image");
        Integer imageID = this.getResources().getIdentifier(image, "drawable", this.getPackageName());
        String address = streetNumber + " " + streetName + ", " + suburb + ", " + state;

        //set elements
        imageView.setImageResource(imageID);
        addressTV.setText(address);
        descriptionTV.setText(description);
        priceTV.setText('$' + Double.toString(price));
        bathroomsTV.setText("Bathrooms: " + bathrooms);
        bedroomsTV.setText("Bedrooms: " + bedrooms);
        carspotsTV.setText("Car Spots: " + carspots);

        //set the title of this activity to be the street name
        getSupportActionBar().setTitle(address);


    }
}
