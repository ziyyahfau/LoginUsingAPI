package noosc.project.otrs.login.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import noosc.project.otrs.login.R;
import noosc.project.otrs.login.model.TiketModel;

/**
 * Created by Fauziyyah Faturahma on 9/13/2017.
 */

public class TiketAdapter extends RecyclerView.Adapter<TiketAdapter.Holder> {

    private ArrayList<TiketModel> tikets;

    public TiketAdapter(ArrayList<TiketModel> tikets) {
        this.tikets = tikets;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_tiket_item, parent, false));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.txtQueue.setText(tikets.get(position).getQueue());
        holder.txtTitle.setText(tikets.get(position).getTitle()+"..");
        holder.txtTicket.setText(tikets.get(position).getTn());
        holder.txtUser.setText(tikets.get(position).getUser()+"..");
        holder.txtStatusName.setText(tikets.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return tikets.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_queue) TextView txtQueue;
        @BindView(R.id.txt_title) TextView txtTitle;
        @BindView(R.id.no_ticket) TextView txtTicket;
        @BindView(R.id.txt_user) TextView txtUser;
        @BindView(R.id.txt_status_name) TextView txtStatusName;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
