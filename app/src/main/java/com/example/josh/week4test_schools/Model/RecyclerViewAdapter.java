package com.example.josh.week4test_schools.Model;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.josh.week4test_schools.R;

import org.w3c.dom.Text;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    List<SchoolResult> schoolList;
    public static final String TAG = "_TAG";
    private OnItemClicked onClick;

    public RecyclerViewAdapter(List<SchoolResult> schoolList) {
        this.schoolList = schoolList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        int itemViewLayout = R.layout.recycler_layout;
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(itemViewLayout, viewGroup, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        SchoolResult schoolResult = schoolList.get(position);
        viewHolder.tvName.setText(schoolResult.getSchoolName());
        viewHolder.tvGrades.setText("Grades: " + schoolResult.getGrades2018());
        viewHolder.tvZip.setText("Zip Code: " + schoolResult.getZip());
        viewHolder.tvCounter.setText(position + "");
        viewHolder.llClicked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.onItemClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return schoolList.size();
    }

    public void add(SchoolResult schoolResult) {
        schoolList.add(schoolResult);
        this.notifyDataSetChanged();
    }



    public interface OnItemClicked{
        void onItemClick(int position);
    }

    class ViewHolder extends RecyclerView.ViewHolder {


        private final TextView tvName;
        private final TextView tvGrades;
        private final TextView tvZip;
        private final TextView tvCounter;
        private final LinearLayout llClicked;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            llClicked = itemView.findViewById(R.id.llClicked);
            tvName = itemView.findViewById(R.id.tvName);
            tvGrades = itemView.findViewById(R.id.tvGrades);
            tvZip = itemView.findViewById(R.id.tvZip);
            tvCounter = itemView.findViewById(R.id.tvCounter);

        }
    }

    public void setOnClick(OnItemClicked onClick){
        this.onClick = onClick;
    }
}