package com.fabiansuarez.mywallet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.ViewHolder> {

    private ArrayList<Account> dataSet;
    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public AccountAdapter(ArrayList<Account> dataSet) {
        this.dataSet = dataSet;
    }

    /*
        CLASE CON LA QUE MANIPULASMO EL XML
            */
    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName, tvTypeAccount, tvBalance;
        private ImageView ivImage;
        private Button mBtnDelete, mBtnEdit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_item_name_account);
            tvTypeAccount = itemView.findViewById(R.id.tv_item_type_account);
            tvBalance = itemView.findViewById(R.id.tv_item_balance_account);
            ivImage = itemView.findViewById(R.id.iv_account);
            mBtnDelete = itemView.findViewById(R.id.btn_item_account_delete);
            mBtnEdit = itemView.findViewById(R.id.btn_item_account_edit);
        }

        public void loadItem(Account myAccount) {
            tvName.setText(myAccount.getName());
            tvTypeAccount.setText(myAccount.getTypeAccount());
            if (myAccount.getCurrentValue() < 0) {
                tvBalance.setTextColor(ContextCompat.getColor(itemView.getContext(), R.color.my_red_color));
            } else {
                tvBalance.setTextColor(ContextCompat.getColor(itemView.getContext(), R.color.my_green_color));
            }
            tvBalance.setText(myAccount.getCurrentValueToString());
            Picasso
                    .get()
                    .load(myAccount.getImageUrl())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(ivImage);

            mBtnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onClickListener != null) {
                        onClickListener.onClickDelete(myAccount);
                    }
                }
            });

            mBtnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onClickListener != null) {
                        onClickListener.onClickEdit(myAccount);
                    }
                }
            });
        }
    }


    @NonNull
    @Override
    public AccountAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rv_accounts_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AccountAdapter.ViewHolder holder, int position) {

        Account myAccount = dataSet.get(position);
        holder.loadItem(myAccount);

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public interface OnClickListener {
        void onClickDelete(Account myAccount);

        void onClickEdit(Account myAccount);
    }
}
