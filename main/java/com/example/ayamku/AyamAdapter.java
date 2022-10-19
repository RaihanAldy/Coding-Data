package com.example.ayamku;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AyamAdapter extends RecyclerView.Adapter<AyamAdapter.MahasiswaViewHolder> {
    public interface ItemClickListener {
        void onClick(View view, int position);
    }
    private ArrayList<Ayamku> dataList;
    private String KEY_TOT="TOT";
    public double tot=0;
    int gambar[] = {R.drawable.img, R.drawable.img_1, R.drawable.img_2,
            R.drawable.img_3, R.drawable.img_4};
    public AyamAdapter(ArrayList<Ayamku> dataList)
    {
        this.dataList = dataList;
    }
    private ItemClickListener clickListener;

    @Override
    public MahasiswaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new MahasiswaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MahasiswaViewHolder holder, int position){
        holder.txtNama.setText(dataList.get(position).getNama());
        holder.txtNpm.setText(dataList.get(position).getNpm());
        holder.txtNoHp.setText(dataList.get(position).getNohp());
        holder.icon.setImageResource(gambar[position]);

        // Set onclicklistener pada view Icon
        //holder.icon.setOnClickListener(new View.OnClickListener() {
        //  @Override
        // public void onClick(View v) {
        //    tot=tot+1000;
        //   System.out.println("helllo"+tot);
        // }
        //});
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }
    public void setClickListener(ItemClickListener clickListener) {
        this.clickListener = clickListener;
    }
    public class MahasiswaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView txtNama, txtNpm, txtNoHp;
        private ImageView icon;
        public MahasiswaViewHolder(View itemView) {
            super(itemView);
            txtNama = (TextView) itemView.findViewById(R.id.txt_nama_mahasiswa);
            txtNpm = (TextView) itemView.findViewById(R.id.txt_npm_mahasiswa);
            txtNoHp = (TextView) itemView.findViewById(R.id.txt_nohp_mahasiswa);
            icon=(ImageView) itemView.findViewById(R.id.img_card);
            itemView.setTag(itemView);
            itemView.setOnClickListener(this);
            txtNama.setOnClickListener(this);
            icon.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            if(clickListener != null) clickListener.onClick(view,
                    getAdapterPosition());
        }
    }
    public double getTot()
    {
        return  tot;
    }
    public void setTot(double tot)
    {
        this.tot=tot;
    }
}