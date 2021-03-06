package noosc.project.otrs.login.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import noosc.project.otrs.login.R;
import noosc.project.otrs.login.core.detail_tiket.DetailTiketActivity;
import noosc.project.otrs.login.model.TiketModel;

import static android.view.View.GONE;

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
        holder.txtTicketType.setText(tikets.get(position).getTicket_type());

    }

    @Override
    public int getItemCount() {return tikets.size();}

    class Holder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_queue) TextView txtQueue;
        @BindView(R.id.txt_title) TextView txtTitle;
        @BindView(R.id.no_ticket) TextView txtTicket;
        @BindView(R.id.txt_user) TextView txtUser;
        @BindView(R.id.txt_status_name) TextView txtStatusName;
        @BindView(R.id.txt_type) TextView txtTicketType;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
//            txtPriority.setVisibility(GONE);
            txtTicketType.setVisibility(GONE);
        }

        @OnClick(R.id.linearClicked)
        public void detailTicket(View v) {
            Intent intent = new Intent(v.getContext(), DetailTiketActivity.class);
            intent.putExtra("ticket", new GsonBuilder().create().toJson(tikets.get(getAdapterPosition())));
            v.getContext().startActivity(intent);
        }
    }
}
