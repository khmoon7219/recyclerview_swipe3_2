package com.khmoon.recyclerview_swipe3.RECYCLERVIEW;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.khmoon.recyclerview_swipe3.MainActivity;
import com.khmoon.recyclerview_swipe3.R;

import java.util.ArrayList;

public class AdapterRC extends RecyclerView.Adapter<AdapterRC.ItemViewHolder> {
    public static final int CONTENT_ORDER = 1;
    public static final int CONTENT_CALL = 2;

    private Context context;

    private ArrayList<Item_order> mData;
    private OnItemClickListener mListener = null;
    private boolean isLongClick = false;
    private boolean isDblClick = false;
    private int clickCount = 0;
    private int isOrderCall = 0;
    private View view;


    public AdapterRC (Context context, ArrayList<Item_order> mData, int order_call) {
        this.context = context;
        this.mData = mData;
        isOrderCall = order_call;
    }

    public boolean getIsLongClick() { return this.isLongClick; }


    public class ItemViewHolder extends RecyclerView.ViewHolder {
        Button btn_item;
        LinearLayout layout_item;
//        ImageButton ImageButton_itemView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            layout_item = itemView.findViewById(R.id.layout_item);

            btn_item = itemView.findViewById(R.id.btn_main);
//            ImageButton_itemView = itemView.findViewById(R.id.ImageButton_itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    return false;
                }
            });

        }


        public void onBind(Item_order Item){
            btn_item.setText(Item.getItemText());
        }
    }

    @Override
    public AdapterRC.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rc_item_order, parent, false);
        return new AdapterRC.ItemViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull AdapterRC.ItemViewHolder holder, final int position) {
        holder.onBind(mData.get(position));

        holder.btn_item.setTag(position);
//        if (isOrderCall == MainActivity.CONTENT_ORDER) {
//            holder.btn_item.setAnimation(AnimationUtils.loadAnimation(context, R.anim.left_to_right));
//        } else if (isOrderCall == MainActivity.CONTENT_CALL) {
//            holder.btn_item.setAnimation(AnimationUtils.loadAnimation(context, R.anim.top_to_down));
//        }
        holder.btn_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 버튼 텍스트 읽어오기 부분을 만들어야 함.
//                String s = mData.get(position).getItemText().toString();
//                Log.e("___AdapterOrderRC", "Click: " + s);

//                int pos = getAdapterPosition();
                int pos = position;
                if(pos != RecyclerView.NO_POSITION) {
                    if(mListener != null) {

                        mListener.onItemClick(v, pos);
                        isLongClick = false;
//                        FromLeftToRight(v, position);
//                        holder.layout_item.setAnimation(AnimationUtils.loadAnimation(context, R.anim.left_to_right));
                        Log.e("___AdapterOrderRC", "pos 값: " + pos);
                    }
                }
            }
        });

        holder.btn_item.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
//                String s = mData.get(position).getItemText().toString();
//                Log.e("___AdapterOrderRC", "long Click: " + s);

//                int pos = getAdapterPosition();
                int pos = position;
                if(pos != RecyclerView.NO_POSITION) {
                    if(mListener != null) {
                        mListener.onItemClick(v, pos);

                        isLongClick = true;
////                        String ss = mData.get(pos).getItemText().toString();
//                        String[] sss = mData.get(pos).getItemText().toString().split("\n");
//                        int len = sss.length;
//
//                        MyApplication.getInstance().setnOrder(Integer.parseInt(sss[len -1]));
//                        Log.e("___AdapterOrderRC", "myApp.nOrder: " + MyApplication.getInstance().getnOrder());
                        Log.e("___AdapterOrderRC", "pos(long) 값: " + pos);
                    }
                }
                return true;
            }
        });

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public Item_order getItem(int position) {
        int tbl = mData.get(position).getnTable();
        int num = mData.get(position).getnNumber();
        int oc = mData.get(position).getIsOrderCall();

        Item_order gData = new Item_order(oc, tbl, num);

        Log.e("__onAdapterRC_getItem", "position: "+ position + " / Table: "
                + tbl + " / Number: " + num + " / OrderCall: " + oc);

        return gData;
    }

    public int getPosition(int num) {
        int size = mData.size();

        if (size != 0) {
            for (int i = 0; i < size; i++) {
                if (num == mData.get(i).getnNumber()) {
                    return i;
                }
            }
        }

        return -1;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void addItem(Item_order Item){
        if (isOrderCall == CONTENT_ORDER) {
            mData.add(Item);
        } else if(isOrderCall == CONTENT_CALL) {
            mData.add(0, Item);
        }

//        notifyDataSetChanged();
        if(isOrderCall == MainActivity.CONTENT_CALL) {
            notifyItemInserted(0);
        } else if (isOrderCall == MainActivity.CONTENT_ORDER) {
            int l = mData.size() - 1;
            Log.e("__onAdapterRC_addItem1", "l: " + l);
            notifyItemInserted(l);
        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                notifyDataSetChanged();
            }
        }, 1000);

    }

    public void addItem(Item_order Item, int position){
        mData.set(position, Item);
//        notifyDataSetChanged();

        Log.d("__onAdapterRC_addItem2", "position: " + position);
        notifyDataSetChanged();
    }

    public void removeAllItem() {
        mData.clear();
        notifyDataSetChanged();
    }

    public void removeItem(int position) {
        mData.remove(position);
//        notifyDataSetChanged();
//
        Log.e("__onAdapterRC_RemoveItem", "position: " + position);
        notifyItemRemoved(position);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                notifyDataSetChanged();
            }
        }, 1000);

        for(int i = 0; i < mData.size(); i++) {
            Log.d("___mData", "i: " + i + ", data: " + mData.get(i).getItemText().toString());
        }
    }

    public void OrderRightToLeft(View itemView, int position) {

        itemView.animate()
                .translationX(-50)
                .setDuration(1000)
                .setInterpolator(new BounceInterpolator())
                .withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        itemView.animate()
                                .translationX(0)
                                .setDuration(400)
                                .start();
                    }
                })
                .start();
    }

    public void OrderLeftToRight(View itemView, int position) {

        itemView.animate()
                .translationX(400)
                .setDuration(1000)
//                .setInterpolator(new BounceInterpolator())
                .start();
    }

    public void CallRightToLeft(View itemView, int position) {

        itemView.animate()
                .translationX(-300)
                .setDuration(1000)
                .start();
    }

    public void CallLeftToRight(View itemView, int position) {

        itemView.animate()
                .translationX(400)
                .setDuration(1000)
//                .setInterpolator(new BounceInterpolator())
                .start();
    }

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }


}