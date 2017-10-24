package noosc.project.otrs.login.core.utama_companyTicket.AdapterCompany;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import noosc.project.otrs.login.R;

/**
 * Created by Fauziyyah Faturahma on 9/28/2017.
 */

public class AdapterCompanyTicket extends RecyclerView.Adapter<AdapterCompanyTicket.CompanyTicket> {


    @Override
    public CompanyTicket onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_company_ticket, parent, false);
        return new CompanyTicket(view);
    }

    @Override
    public void onBindViewHolder(CompanyTicket holder, int position) {
        //
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class CompanyTicket extends RecyclerView.ViewHolder {
        @BindView(R.id.cardViewTicketCompany) CardView cardViewCompany;
        @BindView(R.id.textClient1) TextView textViewClient;
        @BindView(R.id.arrow_next1) ImageView arrowClient;
        @BindView(R.id.cardClient1) ImageView cardClient;


        public CompanyTicket(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.cardViewTicketCompany)
        public void klikCompanyTicket(View v) {

            Toast.makeText(v.getContext(), "detail clicked", Toast.LENGTH_SHORT).show();
//            v.getContext().startActivity(new Intent(v.getContext(), DetailRecipe.class));
        }
    }
}
