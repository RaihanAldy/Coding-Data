package com.example.ayamku;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements AyamAdapter.ItemClickListener {
    private RecyclerView recyclerView;
    private AyamAdapter adapter;
    private ArrayList<Ayamku> AyamkuArrayList;
    private ArrayList<String> listGambar;
    ViewFlipper v_flipper;
    public double tot=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int images[] = {R.drawable.img, R.drawable.img_1,R.drawable.img_2
                ,R.drawable.img_3};
        v_flipper = findViewById(R.id.v_flipper);

        for (int i =0; i<images.length; i++){
            fliverImages(images[i]);
        }
        for (int image: images)
            fliverImages(image);

        addData();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        adapter = new AyamAdapter(AyamkuArrayList);
        //1 kolom
        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

        //GRID 2 kolom
        //GridLayoutManager layoutManager=new GridLayoutManager(this,2);

        //STAGGER 4 KOLOM
        StaggeredGridLayoutManager llm=new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(llm);
        //ambildata();
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.layout.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void postTotals()
    {
        TextView txtTot=(TextView) findViewById(R.id.totalPrice);
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        txtTot.setText("Rp. "+decimalFormat.format(tot));
    }

    public void onClick(View view, int position) {
        final Ayamku mhs = AyamkuArrayList.get(position);
        switch (view.getId()) {
            case R.id.txt_nama_mahasiswa:
                Toast.makeText(this,"okkkkkk" + mhs.getNama() ,Toast.LENGTH_SHORT).show();
                return;
            case R.id.img_card:
                tot=tot+1000;
                Toast.makeText(this,"gambare....." + mhs.getNama() ,Toast.LENGTH_SHORT).show();
                postTotals();
                return;
            default:
                Toast.makeText(this,"lainnya..... -> " + mhs.getNama()+ " Rp. "+tot ,Toast.LENGTH_SHORT).show();
                break;
        }
    }
    void addData(){
        AyamkuArrayList = new ArrayList<>();
        AyamkuArrayList.add(new Ayamku("Ghiyatsi MR", "1414370309", "123456789",1));
        AyamkuArrayList.add(new Ayamku("Najwa AD", "1214234560", "987654321",2));
        AyamkuArrayList.add(new Ayamku("Avanca", "1214230345", "987648765",3));
        AyamkuArrayList.add(new Ayamku("Annisa F", "1214378098", "098758124",4));
    }
    public void ambildata(){
        listGambar= new ArrayList<String>();

        listGambar.add("Ayam1");
        listGambar.add("Ayam2");
        listGambar.add("Ayam3");
        listGambar.add("Ayam4");
        listGambar.add("Ayam5");
    }

    public void checkout(View view) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        Toast.makeText(this,"Totol Rp. "+ decimalFormat.format(tot) ,Toast.LENGTH_SHORT).show();
    }
    public  void  fliverImages(int images){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(images);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);

        v_flipper.setInAnimation(this,android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this,android.R.anim.slide_out_right);

    }
}