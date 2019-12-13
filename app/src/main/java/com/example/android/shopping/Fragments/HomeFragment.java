package com.example.android.shopping.Fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.shopping.Models.BrandModel;
import com.example.android.shopping.Models.ProudctModel;
import com.example.android.shopping.R;
import com.smarteist.autoimageslider.SliderView;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private View view;
    private SliderView sliderView;
    private List<Integer> list;
    private List<BrandModel> brandModellist;
    private List<ProudctModel> proudctModelList;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private DividerItemDecoration dividerItemDecoration;
    brandAdapter bbrandAdapter;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_home, container, false);
        initSlider();
        initViews();
        return view;


    }

    private void initSlider() {
        sliderView=view.findViewById(R.id.imageSlider);
        list=new ArrayList<>();
        list.add(R.drawable.a);
        list.add(R.drawable.b);
        list.add(R.drawable.c);
        list.add(R.drawable.d);
        sliderView.setSliderAdapter(new SliderAdapter(getContext(),list ));
    }

    private void initViews() {
        recyclerView=view.findViewById(R.id.Recycler_home);
        layoutManager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        dividerItemDecoration=new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        brandModellist=new ArrayList<>();
        proudctModelList=new ArrayList<>();
        proudctModelList.add(new ProudctModel(R.drawable.shoes,"Running shoes 1"));
        proudctModelList.add(new ProudctModel(R.drawable.shoes,"Running shoes 2"));
        proudctModelList.add(new ProudctModel(R.drawable.shoes,"Running shoes 3"));
        proudctModelList.add(new ProudctModel(R.drawable.shoes,"Running shoes 4"));
        proudctModelList.add(new ProudctModel(R.drawable.shoes,"Running shoes 5"));
        brandModellist.add(new BrandModel("Adidas","Sports",R.drawable.adidas,proudctModelList));
        brandModellist.add(new BrandModel("Adidas","Sports",R.drawable.adidas,proudctModelList));
        brandModellist.add(new BrandModel("Adidas","Sports",R.drawable.adidas,proudctModelList));
        brandModellist.add(new BrandModel("Adidas","Sports",R.drawable.adidas,proudctModelList));
        brandModellist.add(new BrandModel("Adidas","Sports",R.drawable.adidas,proudctModelList));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(dividerItemDecoration );
          recyclerView.setAdapter(new brandAdapter(brandModellist));
    }

    public class brandAdapter extends RecyclerView.Adapter<brandAdapter.brandVH>{

        List<BrandModel> bb;
        @NonNull
        @Override
        public brandVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view=LayoutInflater.from(getContext()).inflate(R.layout.brand_item,parent,false);

            return new brandVH(view);
        }

         brandAdapter(List<BrandModel> bb) {
            this.bb = bb;
        }

        @Override
        public void onBindViewHolder(@NonNull brandVH holder, int position) {
            BrandModel brandModel=bb.get(position);
            String name=brandModel.getTitle();
            String categ=brandModel.getCateg();
            int img=brandModel.getImg();
            List<ProudctModel> proudctModels=brandModel.getProudcts();
            holder.title.setText(name);
            holder.categ.setText(categ);
            holder.brand_img.setImageResource(img);
            holder.products.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
            holder.products.setAdapter(new ProudctAdapter(proudctModels));

        }

        @Override
        public int getItemCount() {
            return bb.size();
        }

        class brandVH extends RecyclerView.ViewHolder{
               CircleImageView brand_img;
               TextView title,categ;
               RecyclerView products;
            public brandVH(@NonNull View itemView) {
                super(itemView);
                brand_img=itemView.findViewById(R.id.brand_img);
                title=itemView.findViewById(R.id.brand_title);
                categ=itemView.findViewById(R.id.brand_categ);
                products=itemView.findViewById(R.id.Recycler_item);
            }
        }
    }
    public class ProudctAdapter extends RecyclerView.Adapter<ProudctAdapter.ProductVH>{
        List<ProudctModel> pm;
        @NonNull
        @Override
        public ProductVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view=LayoutInflater.from(getContext()).inflate(R.layout.products_item,parent,false);
            return new ProductVH(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ProductVH holder, int position) {
         ProudctModel proudctModel=pm.get(position);
         String name=proudctModel.getTitle();
         int img=proudctModel.getImg();
         holder.textView.setText(name);
         holder.imageView.setImageResource(img);
        }

        ProudctAdapter(List<ProudctModel> pm) {
            this.pm = pm;
        }

        @Override
        public int getItemCount() {
            return pm.size();
        }

        class ProductVH extends RecyclerView.ViewHolder{
              ImageView imageView;
              TextView textView;
            public ProductVH(@NonNull View itemView) {
                super(itemView);
                imageView=itemView.findViewById(R.id.product_img);
                textView=itemView.findViewById(R.id.product_type);

            }
        }
    }
    public class  SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderHolder>{
       Context context;
       List<Integer> img;

       public SliderAdapter(Context context, List<Integer> img) {
           this.context = context;
           this.img = img;
       }

       @Override
       public SliderHolder onCreateViewHolder(ViewGroup parent) {
           View inflate=LayoutInflater.from(parent.getContext()).inflate(R.layout.slide_item,parent,false);
           return new SliderHolder(inflate);
       }

       @Override
       public void onBindViewHolder(SliderHolder viewHolder, int position) {
        int url=img.get(position);
        viewHolder.imageView.setImageResource(url);
       }

       @Override
       public int getCount() {
           return img.size();
       }

       class SliderHolder extends SliderViewAdapter.ViewHolder{
              ImageView imageView;
           public SliderHolder(View itemView) {
               super(itemView);
             imageView=itemView.findViewById(R.id.slider_item);
           }
       }
   }

}
